package rental.hqprjt.com.carrental.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;

import rental.hqprjt.com.carrental.R;

/**
 * Created by ssy on 2017/5/16.
 */

public class LRImgTextView extends android.support.percent.PercentRelativeLayout {
    private ImageView imgLeft;
    private ImageView imgRight;
    private EditText edtText;
    private Drawable imgLeftDraw;
    private Drawable imgRightDraw;
    private int cusTextColor;
    private int cusTextSize;
    private int imgMarginLeft;
    private int imgMarginRight;
    private int imgLeftW;
    private int imgLeftH;
    private int imgRightW;
    private int imgRightH;
    private String cusText;
    private Context context;
    private String cusHint;
    private int cusInputType;

    public LRImgTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.widget_cus_edittext, this);
        imgLeft = (ImageView) findViewById(R.id.imgLeft);
        imgRight = (ImageView) findViewById(R.id.imgRight);
        edtText = (EditText) findViewById(R.id.edtText);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CusEditText);
        cusInputType = a.getInt(R.styleable.CusEditText_cusInputType, InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);
        cusHint = a.getString(R.styleable.CusEditText_cusHint);
        cusText = a.getString(R.styleable.CusEditText_cusText);
        imgLeftDraw = a.getDrawable(R.styleable.CusEditText_leftImg);
        imgRightDraw = a.getDrawable(R.styleable.CusEditText_rightImg);
        cusTextColor = a.getColor(R.styleable.CusEditText_cusTextColor, 0X1C2932);
        cusTextSize = a.getDimensionPixelSize(R.styleable.CusEditText_cusTextSize, 10);
        imgMarginLeft = a.getInt(R.styleable.CusEditText_leftImgMargin, 5);
        imgMarginRight = a.getInt(R.styleable.CusEditText_rightImgMargin, 5);
        imgLeftW = a.getInt(R.styleable.CusEditText_leftImgW, 20);
        imgLeftH = a.getInt(R.styleable.CusEditText_leftImgH, 20);
        imgRightW = a.getInt(R.styleable.CusEditText_rightImgW, 20);
        imgRightH = a.getInt(R.styleable.CusEditText_rightImgH, 20);
        a.recycle();
        initView();

    }

    private void initView() {
        imgLeft.setBackgroundDrawable(imgLeftDraw);
        imgRight.setBackgroundDrawable(imgRightDraw);
        edtText.setText(cusText);
        edtText.setTextSize(TypedValue.COMPLEX_UNIT_PX,cusTextSize);
        edtText.setTextColor(cusTextColor);
        edtText.setHint(cusHint);
        edtText.setInputType(cusInputType);
    }

    public void setLeftImage(int imgRes) {
        imgLeft.setBackgroundResource(imgRes);
    }

    public void setRightImage(int imgRes) {
        imgRight.setBackgroundResource(imgRes);
    }
}

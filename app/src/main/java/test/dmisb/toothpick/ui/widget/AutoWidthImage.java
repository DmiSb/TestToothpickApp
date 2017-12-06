package test.dmisb.toothpick.ui.widget;

import android.content.Context;
import android.util.AttributeSet;

public class AutoWidthImage extends android.support.v7.widget.AppCompatImageView {

    public AutoWidthImage(Context context) {
        super(context);
    }

    public AutoWidthImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoWidthImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec);
    }
}

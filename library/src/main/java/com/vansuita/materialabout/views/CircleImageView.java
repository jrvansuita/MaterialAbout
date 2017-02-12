package com.vansuita.materialabout.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by jrvansuita on 10/02/17.
 */

public class CircleImageView extends RoundedImageView {

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        if (getParent() != null) {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
            lp.topMargin = getMeasuredHeight() / 2;
            setLayoutParams(lp);
        }
    }
}

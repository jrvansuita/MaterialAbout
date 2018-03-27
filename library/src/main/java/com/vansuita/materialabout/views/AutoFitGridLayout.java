package com.vansuita.materialabout.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by jrvansuita on 10/02/17.
 */

public final class AutoFitGridLayout extends ViewGroup {

    private int verticalSpace;

    private int horizontalSpace;

    private int columnCount = 2;

    private int childWidth;

    private ArrayList<View> notGoneViewList;

    public AutoFitGridLayout(Context context) {
        super(context);
    }

    public AutoFitGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoFitGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void refreshNotGoneChildList() {
        if (notGoneViewList == null) {
            notGoneViewList = new ArrayList<>();
        }
        notGoneViewList.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                notGoneViewList.add(child);
            }
        }
    }

    public int getVerticalSpace() {
        return verticalSpace;
    }

    public void setVerticalSpace(int verticalSpace) {
        this.verticalSpace = verticalSpace;
        requestLayout();
    }

    public int getHorizontalSpace() {
        return horizontalSpace;
    }

    public void setHorizontalSpace(int horizontalSpace) {
        this.horizontalSpace = horizontalSpace;
        requestLayout();
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        refreshNotGoneChildList();
        if (childWidth <= 0) {
            final int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
            childWidth = (int) (
                    (parentWidth - (columnCount - 1) * horizontalSpace * 1.0f) / columnCount + 0.5f);
        }
        int childCount = notGoneViewList.size();
        int line = childCount % columnCount == 0 ? childCount / columnCount
                : childCount / columnCount + 1;
        int totalHeight = 0;
        int childIndex = 0;
        for (int i = 0; i < line; i++) {
            int inlineHeight = 0;
            for (int j = 0; j < columnCount; j++) {
                childIndex = i * columnCount + j;
                if (childIndex < childCount) {
                    View child = notGoneViewList.get(childIndex);
                    int childWidthWithPadding = childWidth;
                    if (j == 0) {
                        // measureChild会在size的基础上减掉paddingLeft和paddingRight，对于每一行第一个元素加上paddingRight抵消
                        childWidthWithPadding += getPaddingRight();
                    } else if (j == columnCount -1){
                        // measureChild会在size的基础上减掉paddingLeft和paddingRight，对于每一行最后一个元素加上paddingLeft抵消
                        childWidthWithPadding += getPaddingLeft();
                    }
                    measureChild(child,
                            MeasureSpec.makeMeasureSpec(childWidthWithPadding, MeasureSpec.EXACTLY),
                            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                    int totalInlineChildHeight = child.getMeasuredHeight();
                    if (totalInlineChildHeight > inlineHeight) {
                        inlineHeight = totalInlineChildHeight;
                    }
                }
            }
            totalHeight += inlineHeight;
            totalHeight += verticalSpace;
        }
        totalHeight -= verticalSpace;
        totalHeight += getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                totalHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = notGoneViewList.size();
        int line = childCount % columnCount == 0 ? childCount / columnCount
                : childCount / columnCount + 1;
        int childIndex = 0;
        int lastLeft = getPaddingLeft();
        int lastTop = getPaddingTop();
        for (int i = 0; i < line; i++) {
            int inlineHeight = 0;
            for (int j = 0; j < columnCount; j++) {
                childIndex = i * columnCount + j;
                if (childIndex < childCount) {
                    View child = notGoneViewList.get(childIndex);
                    int childWidth = child.getMeasuredWidth();
                    int childHeight = child.getMeasuredHeight();

                    child.layout(lastLeft, lastTop, lastLeft + childWidth, lastTop + childHeight);
                    lastLeft += (childWidth + horizontalSpace);
                    int totalInlineChildHeight = child.getMeasuredHeight();
                    if (totalInlineChildHeight > inlineHeight) {
                        inlineHeight = totalInlineChildHeight;
                    }
                }
            }
            lastLeft = getPaddingLeft();
            lastTop += (inlineHeight + verticalSpace);
        }
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    public static class LayoutParams extends MarginLayoutParams {

        /**
         * {@inheritDoc}
         */
        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        /**
         * {@inheritDoc}
         */
        public LayoutParams(int width, int height) {
            super(width, height);
        }


        /**
         * {@inheritDoc}
         */
        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        /**
         * {@inheritDoc}
         */
        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }

        /**
         * Copy constructor. Clones the width, height, margin values, and
         * gravity of the source.
         *
         * @param source The layout params to copy from.
         */
        public LayoutParams(LayoutParams source) {
            super(source);
        }

    }
}
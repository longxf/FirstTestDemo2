package com.example.longxiaofeng.longxf;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by longxiaofeng on 17/3/29.
 */

public class MyViewGroup extends ViewGroup {

    int hSpace = 20;
    // vertical space among children views
    int vSpace = 20;

    // every child view width and height.
    int childWidth = 0;
    int childHeight = 0;

    int selfPadding = 50;

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        setBackgroundColor(Color.BLUE);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //    measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        //开始处理wrap_content,如果一个子元素都没有，就设置为0
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup，宽，高都是wrap_content，根据我们的需求，宽度是子控件的宽度，高度则是所有子控件的总和
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth() + childOne.getMeasuredWidth();
            int childHeight = childOne.getMeasuredHeight();

            double count = getChildCount();
            int row = (int) Math.ceil(count / 2);

            setMeasuredDimension(childWidth + selfPadding + selfPadding, childHeight * row + selfPadding + selfPadding);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //ViewGroup的宽度为wrap_content,则高度不需要管，宽度还是自控件的宽度
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth() + childOne.getMeasuredWidth();
            setMeasuredDimension(childWidth, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup的高度为wrap_content,则宽度不需要管，高度为子View的高度和
            View childOne = getChildAt(0);
            int childHeight = childOne.getMeasuredHeight();

            double count = getChildCount();
            int row = (int) Math.ceil(count / 2);

            setMeasuredDimension(widthSize, childHeight * row);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int height = selfPadding;
        int weight = selfPadding;
        int count = getChildCount();
        View child;

        for (int ii = 0; ii < count; ii++) {

            child = getChildAt(ii);

            if (ii % 2 == 0) {
                child.layout(weight, height, child.getMeasuredWidth() + weight, height + child.getMeasuredHeight());
                weight += child.getMeasuredWidth();
            } else {
                child.layout(weight, height, weight + child.getMeasuredWidth() + selfPadding, height +
                        child.getMeasuredHeight());
                weight = selfPadding;
                height += child.getMeasuredHeight();
            }

        }
    }


}

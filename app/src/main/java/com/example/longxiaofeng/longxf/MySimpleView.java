package com.example.longxiaofeng.longxf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.View;

import static android.R.attr.padding;

/**
 * Created by longxiaofeng on 17/3/29.
 */

public class MySimpleView extends View {
    Rect mBounds;
    int padding = 100;

    public MySimpleView(Context context) {
        super(context);
    }

    public MySimpleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public MySimpleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mPaint = new Paint();

        mPaint.setTextSize(100);

        mBounds = new Rect();
        mPaint.getTextBounds("hello", 0, "hello".length(), mBounds);

        mPaint.setColor(Color.RED);
        canvas.drawRect(0, 0, padding + mBounds.width() + padding, mBounds.height() + padding + padding, mPaint);

        // 绘制字符串
        mPaint.setColor(Color.BLACK);
        canvas.drawText("hello", 0 + padding, padding + mBounds.height(), mPaint);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }

    //    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        Paint mPaint = new Paint();

        mPaint.setTextSize(100);

        mBounds = new Rect();
        mPaint.getTextBounds("hello", 0, "hello".length(), mBounds);
        setMeasuredDimension(padding + mBounds.width() + padding, mBounds.height() + padding + padding);
    }
//
//    @Override
//    public void layout(@Px int l, @Px int t, @Px int r, @Px int b) {
//        super.layout(l, t, r, b);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//        super.onLayout(changed, left, top, right, bottom);
//    }
}

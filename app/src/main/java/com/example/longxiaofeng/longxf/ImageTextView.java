package com.example.longxiaofeng.longxf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static android.R.attr.bitmap;
import static android.R.attr.padding;

/**
 * Created by longxiaofeng on 17/3/30.
 */

public class ImageTextView extends View {
    private Paint mPaint;
    private Rect mBounds;
    private String text = "中国demo";

    int imageRes;

    public ImageTextView(Context context) {
        super(context);
        initView();
    }

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        initView();
    }

    public ImageTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mBounds = new Rect();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), imageRes);
        int wBitmap = 0;
        int hBitmap = 0;
        if (bitmap != null) {
            wBitmap = bitmap.getWidth();
            hBitmap = bitmap.getHeight();
        }


        mPaint.setTextSize(80);
        Paint.FontMetrics fm = mPaint.getFontMetrics();
        int textHeight = (int) (Math.ceil(fm.descent - fm.ascent) );
     //   mPaint.getTextBounds(text, 0, textHeight, mBounds);

        mPaint.setColor(Color.RED);


        Log.d("LXF","mPaint.measureText(text)="+mPaint.measureText(text));
        Log.d("LXF","mBounds.width()="+mBounds.width());
        Log.d("LXF","mPaint.getFontMetricsInt().ascent="+mPaint.getFontMetricsInt().ascent);
        canvas.drawRect(0, 0, mPaint.measureText(text) + wBitmap, textHeight, mPaint);


        mPaint.setColor(Color.BLACK);
        canvas.drawText(text, wBitmap,textHeight-fm.descent, mPaint);


        double m1 = mBounds.height() - hBitmap;
        int bitmapPosy = (int) Math.ceil(m1 / 2);
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0, bitmapPosy, mPaint);
        }



    }

    public void setText(String text) {
        this.text = text;
        // postInvalidate();
        requestLayout();
        invalidate();

    }

    public void setImageRes(int imageRes) {
        this.text = text;
        // postInvalidate();
        this.imageRes = imageRes;
        requestLayout();
        invalidate();

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // setMeasuredDimension(mBounds.width(), mBounds.height());
    }
}

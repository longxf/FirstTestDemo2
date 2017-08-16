package com.picturetagview;

import android.graphics.Camera;
import android.graphics.Matrix;


import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import static android.R.attr.radius;

/**
 * 上拉加载动画
 * Created by liuwangsheng on 2017/6/3.
 */

public class LoadingAnimView extends View {

    private static final float DIV_45_75 = 45f / 75f;
    private static final float DIV_30_75 = 30f / 75f;
    private static final float DIV_15_75 = 15f / 75f;

    /**
     * 动画时间周期
     */
    private static final long ANIMATION_INTV = 750;
    /**
     * 圆饼半径
     */
    private static final int CIRCULAR_RADIUS_DP = 6;
    /**
     * 圆饼颜色
     */
    private static final String ICON_COLOR = "#2a2a31";
    /**
     * 当前动画系数
     */
    private float mAnimationFactor = 0f;
    /**
     * 动画Animator
     */
    private ValueAnimator mAnimator;

    /**
     * 自定义绘制相关数据结构
     */
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Camera mCamera;
    private Matrix mMatrix;
    private Paint mPaint;

    public LoadingAnimView(Context context) {
        super(context);
        init();
    }

    public LoadingAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingAnimView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mCamera = new Camera();
        mMatrix = new Matrix();

       // startAnim();
    }

    public void startAnim() {
        if (mAnimator != null) {
            resetAnimator();
        }
        mAnimator = ValueAnimator.ofFloat(0, 1);
        mAnimator.setDuration(ANIMATION_INTV);
        mAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mAnimator.setRepeatMode(ValueAnimator.RESTART);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float factor = (float) valueAnimator.getAnimatedValue();
                if (factor < DIV_30_75) {
                    mAnimationFactor = factor / DIV_30_75 * 0.25f;
                } else if (factor < DIV_45_75) {
                    mAnimationFactor = 0.25f + ((factor - DIV_30_75) / DIV_15_75) * 0.5f;
                } else {
                    mAnimationFactor = 0.75f + (factor - DIV_45_75) / DIV_30_75 * 0.25f;
                }
                postInvalidate();
            }
        });
        if (!mAnimator.isRunning()) {
            mAnimator.start();
        }
    }

    public void stopAnim() {
        resetAnimator();
        clearAnimation();
    }

    private void resetAnimator() {
        if (mAnimator != null) {
            mAnimator.setRepeatCount(0);
            mAnimator.removeAllUpdateListeners();
            mAnimator.removeAllListeners();
            mAnimator.end();
            mAnimator.cancel();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
      //  int radius = UIUtils.dip2px(getContext(), CIRCULAR_RADIUS_DP);
        int radius=40;
        mBitmap.eraseColor(Color.TRANSPARENT);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor(ICON_COLOR));
        int alpha = (int) (255 * ((1 - 2 * Math.abs(mAnimationFactor - 0.5)) * 0.3 + 0.3));
        mPaint.setAlpha(alpha);

        mCanvas.drawCircle(width / 2f, height / 2f, radius, mPaint);

        mMatrix.reset();
        mCamera.save();
        mCamera.rotateY(mAnimationFactor * 360);
        mCamera.getMatrix(mMatrix);
        mCamera.restore();
        mMatrix.preTranslate(-width / 2f, -height / 2f);
        mMatrix.postTranslate(width / 2f, height / 2f);
        canvas.drawBitmap(mBitmap, mMatrix, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

}

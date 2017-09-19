package com.bowangzx.imageviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Administrator on 2017/9/18 0018.
 */

public class RoundImageView extends android.support.v7.widget.AppCompatImageView {

    private static final int DEFAULT_RADIUS = 0;

    private int mRadius = DEFAULT_RADIUS;
    private int mTopLeftRadius = DEFAULT_RADIUS;
    private int mTopRightRadius = DEFAULT_RADIUS;
    private int mBotLeftRadius = DEFAULT_RADIUS;
    private int mBotRightRadius = DEFAULT_RADIUS;
    private Paint cornerPaint;//画圆角
    private Paint mPaint;//花图像


    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundImageView, defStyleAttr, 0);

        mRadius = ta.getDimensionPixelSize(R.styleable.RoundImageView_riv_radius, DEFAULT_RADIUS);
        mTopLeftRadius = ta.getDimensionPixelSize(R.styleable.RoundImageView_riv_radius_top_left, DEFAULT_RADIUS);
        mTopRightRadius = ta.getDimensionPixelSize(R.styleable.RoundImageView_riv_radius_top_right, DEFAULT_RADIUS);
        mBotLeftRadius = ta.getDimensionPixelSize(R.styleable.RoundImageView_riv_radius_bottom_left, DEFAULT_RADIUS);
        mBotRightRadius = ta.getDimensionPixelSize(R.styleable.RoundImageView_riv_radius_bottom_right, DEFAULT_RADIUS);

        ta.recycle();

        init();


    }

    private void init() {
        if (mRadius!=0){
            mTopLeftRadius=mRadius;
            mTopRightRadius=mRadius;
            mBotLeftRadius=mRadius;
            mBotRightRadius=mRadius;
        }

        cornerPaint = new Paint();
        cornerPaint.setAntiAlias(true);
        cornerPaint.setColor(Color.WHITE);
        cornerPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        //
        mPaint = new Paint();
        mPaint.setXfermode(null);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas preCanvas = new Canvas(bitmap);//先画一波
        super.onDraw(preCanvas);
        drawLeftUp(preCanvas);
        drawRightUp(preCanvas);
        drawLeftDown(preCanvas);
        drawRightDown(preCanvas);
        canvas.drawBitmap(bitmap,0,0,mPaint);
        bitmap.recycle();


    }

    private void drawRightDown(Canvas canvas) {

        if (mBotRightRadius==0){
            return;
        }
        Path path = new Path();
        path.moveTo(getWidth()-mBotRightRadius, getHeight());
        path.lineTo(getWidth(), getHeight());
        path.lineTo(getWidth(), getHeight()-mBotRightRadius);
        path.arcTo(new RectF(getWidth()-mBotRightRadius*2,getHeight()-mBotRightRadius*2,getWidth(),getHeight()), 0, 90);
        path.close();
        canvas.drawPath(path,cornerPaint);
    }

    private void drawLeftDown(Canvas canvas) {
        if (mBotLeftRadius == 0) {
            return;
        }
        Path path = new Path();
        path.moveTo(0, getHeight() - mBotLeftRadius);
        path.lineTo(0, getHeight());
        path.lineTo(mBotLeftRadius, getHeight());
        path.arcTo(new RectF(0, getHeight() - mBotLeftRadius * 2, 0 + mBotLeftRadius * 2, getHeight()), 90, 90);
        path.close();
        canvas.drawPath(path, cornerPaint);

    }

    private void drawRightUp(Canvas canvas) {
        if (mTopRightRadius == 0) {
            return;
        }

        Path path = new Path();
        path.moveTo(getWidth(), mTopRightRadius);
        path.lineTo(getWidth(), 0);
        path.lineTo(getWidth() - mTopRightRadius, 0);
        path.arcTo(new RectF(getWidth() - mTopRightRadius * 2, 0, getWidth(), 0 + mTopRightRadius * 2), -90, 90);
        path.close();
        canvas.drawPath(path, cornerPaint);
    }

    private void drawLeftUp(Canvas canvas) {

        if (mTopLeftRadius == 0) {
            return;
        }
        Path path = new Path();
        path.moveTo(0, mTopLeftRadius);
        path.lineTo(0, 0);
        path.lineTo(mTopLeftRadius, 0);
        //arcTo的第二个参数是以多少度为开始点，第三个参数-90度表示逆时针画弧，正数表示顺时针
        path.arcTo(new RectF(0, 0, mTopLeftRadius * 2, mTopLeftRadius * 2), -90, -90);
        path.close();
        canvas.drawPath(path, cornerPaint);
    }
}

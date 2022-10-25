package com.jcodecraeer.xrecyclerview.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.jcodecraeer.xrecyclerview.C4702R;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallBeatIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallClipRotateIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallClipRotateMultipleIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallClipRotatePulseIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallGridBeatIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallGridPulseIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallPulseIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallPulseRiseIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallPulseSyncIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallRotateIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallScaleIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallScaleMultipleIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallScaleRippleIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallScaleRippleMultipleIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallSpinFadeLoaderIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallTrianglePathIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallZigZagDeflectIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallZigZagIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.CubeTransitionIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.LineScaleIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.LineScalePartyIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.LineScalePulseOutIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.LineScalePulseOutRapidIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.LineSpinFadeLoaderIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.PacmanIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.SemiCircleSpinIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.SquareSpinIndicator;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.TriangleSkewSpinIndicator;

/* loaded from: classes3.dex */
public class AVLoadingIndicatorView extends View {
    public static final int BallBeat = 17;
    public static final int BallClipRotate = 2;
    public static final int BallClipRotateMultiple = 5;
    public static final int BallClipRotatePulse = 3;
    public static final int BallGridBeat = 26;
    public static final int BallGridPulse = 1;
    public static final int BallPulse = 0;
    public static final int BallPulseRise = 6;
    public static final int BallPulseSync = 16;
    public static final int BallRotate = 7;
    public static final int BallScale = 12;
    public static final int BallScaleMultiple = 15;
    public static final int BallScaleRipple = 20;
    public static final int BallScaleRippleMultiple = 21;
    public static final int BallSpinFadeLoader = 22;
    public static final int BallTrianglePath = 11;
    public static final int BallZigZag = 9;
    public static final int BallZigZagDeflect = 10;
    public static final int CubeTransition = 8;
    public static final int DEFAULT_SIZE = 30;
    public static final int LineScale = 13;
    public static final int LineScaleParty = 14;
    public static final int LineScalePulseOut = 18;
    public static final int LineScalePulseOutRapid = 19;
    public static final int LineSpinFadeLoader = 23;
    public static final int Pacman = 25;
    public static final int SemiCircleSpin = 27;
    public static final int SquareSpin = 4;
    public static final int TriangleSkewSpin = 24;
    private boolean mHasAnimation;
    int mIndicatorColor;
    BaseIndicatorController mIndicatorController;
    int mIndicatorId;
    Paint mPaint;

    /* loaded from: classes3.dex */
    public @interface Indicator {
    }

    public AVLoadingIndicatorView(Context context) {
        super(context);
        init(null, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    public void destroy() {
        this.mHasAnimation = true;
        BaseIndicatorController baseIndicatorController = this.mIndicatorController;
        if (baseIndicatorController != null) {
            baseIndicatorController.destroy();
            this.mIndicatorController = null;
        }
        this.mPaint = null;
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C4702R.styleable.AVLoadingIndicatorView);
        this.mIndicatorId = obtainStyledAttributes.getInt(C4702R.styleable.AVLoadingIndicatorView_indicator, 0);
        this.mIndicatorColor = obtainStyledAttributes.getColor(C4702R.styleable.AVLoadingIndicatorView_indicator_color, -1);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(this.mIndicatorColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        applyIndicator();
    }

    public void setIndicatorId(int i) {
        this.mIndicatorId = i;
        applyIndicator();
    }

    public void setIndicatorColor(int i) {
        this.mIndicatorColor = i;
        this.mPaint.setColor(i);
        invalidate();
    }

    private void applyIndicator() {
        switch (this.mIndicatorId) {
            case 0:
                this.mIndicatorController = new BallPulseIndicator();
                break;
            case 1:
                this.mIndicatorController = new BallGridPulseIndicator();
                break;
            case 2:
                this.mIndicatorController = new BallClipRotateIndicator();
                break;
            case 3:
                this.mIndicatorController = new BallClipRotatePulseIndicator();
                break;
            case 4:
                this.mIndicatorController = new SquareSpinIndicator();
                break;
            case 5:
                this.mIndicatorController = new BallClipRotateMultipleIndicator();
                break;
            case 6:
                this.mIndicatorController = new BallPulseRiseIndicator();
                break;
            case 7:
                this.mIndicatorController = new BallRotateIndicator();
                break;
            case 8:
                this.mIndicatorController = new CubeTransitionIndicator();
                break;
            case 9:
                this.mIndicatorController = new BallZigZagIndicator();
                break;
            case 10:
                this.mIndicatorController = new BallZigZagDeflectIndicator();
                break;
            case 11:
                this.mIndicatorController = new BallTrianglePathIndicator();
                break;
            case 12:
                this.mIndicatorController = new BallScaleIndicator();
                break;
            case 13:
                this.mIndicatorController = new LineScaleIndicator();
                break;
            case 14:
                this.mIndicatorController = new LineScalePartyIndicator();
                break;
            case 15:
                this.mIndicatorController = new BallScaleMultipleIndicator();
                break;
            case 16:
                this.mIndicatorController = new BallPulseSyncIndicator();
                break;
            case 17:
                this.mIndicatorController = new BallBeatIndicator();
                break;
            case 18:
                this.mIndicatorController = new LineScalePulseOutIndicator();
                break;
            case 19:
                this.mIndicatorController = new LineScalePulseOutRapidIndicator();
                break;
            case 20:
                this.mIndicatorController = new BallScaleRippleIndicator();
                break;
            case 21:
                this.mIndicatorController = new BallScaleRippleMultipleIndicator();
                break;
            case 22:
                this.mIndicatorController = new BallSpinFadeLoaderIndicator();
                break;
            case 23:
                this.mIndicatorController = new LineSpinFadeLoaderIndicator();
                break;
            case 24:
                this.mIndicatorController = new TriangleSkewSpinIndicator();
                break;
            case 25:
                this.mIndicatorController = new PacmanIndicator();
                break;
            case 26:
                this.mIndicatorController = new BallGridBeatIndicator();
                break;
            case 27:
                this.mIndicatorController = new SemiCircleSpinIndicator();
                break;
        }
        this.mIndicatorController.setTarget(this);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(measureDimension(dp2px(30), i), measureDimension(dp2px(30), i2));
    }

    private int measureDimension(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawIndicator(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mHasAnimation) {
            return;
        }
        this.mHasAnimation = true;
        applyAnimation();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            BaseIndicatorController baseIndicatorController = this.mIndicatorController;
            if (baseIndicatorController == null) {
                return;
            }
            if (i == 8 || i == 4) {
                baseIndicatorController.setAnimationStatus(BaseIndicatorController.AnimStatus.END);
            } else {
                baseIndicatorController.setAnimationStatus(BaseIndicatorController.AnimStatus.START);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BaseIndicatorController baseIndicatorController = this.mIndicatorController;
        if (baseIndicatorController == null) {
            return;
        }
        baseIndicatorController.setAnimationStatus(BaseIndicatorController.AnimStatus.CANCEL);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        BaseIndicatorController baseIndicatorController = this.mIndicatorController;
        if (baseIndicatorController == null) {
            return;
        }
        baseIndicatorController.setAnimationStatus(BaseIndicatorController.AnimStatus.START);
    }

    void drawIndicator(Canvas canvas) {
        BaseIndicatorController baseIndicatorController = this.mIndicatorController;
        if (baseIndicatorController == null) {
            return;
        }
        baseIndicatorController.draw(canvas, this.mPaint);
    }

    void applyAnimation() {
        BaseIndicatorController baseIndicatorController = this.mIndicatorController;
        if (baseIndicatorController == null) {
            return;
        }
        baseIndicatorController.initAnimation();
    }

    private int dp2px(int i) {
        return ((int) getContext().getResources().getDisplayMetrics().density) * i;
    }
}

package eightbitlab.com.blurview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public class BlurView extends FrameLayout {
    private static final String TAG = "BlurView";
    BlurController blurController;
    private int overlayColor;

    public BlurView(Context context) {
        super(context);
        this.blurController = new NoOpController();
        init(null, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blurController = new NoOpController();
        init(attributeSet, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.blurController = new NoOpController();
        init(attributeSet, i);
    }

    private void init(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C4993R.styleable.BlurView, i, 0);
        this.overlayColor = obtainStyledAttributes.getColor(C4993R.styleable.BlurView_blurOverlayColor, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.blurController.draw(canvas)) {
            super.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.blurController.updateBlurViewSize();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.blurController.setBlurAutoUpdate(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            Log.e(TAG, "BlurView can't be used in not hardware-accelerated window!");
        } else {
            this.blurController.setBlurAutoUpdate(true);
        }
    }

    public BlurViewFacade setupWith(ViewGroup viewGroup) {
        BlockingBlurController blockingBlurController = new BlockingBlurController(this, viewGroup, this.overlayColor);
        this.blurController.destroy();
        this.blurController = blockingBlurController;
        return blockingBlurController;
    }

    public BlurViewFacade setBlurRadius(float f) {
        return this.blurController.setBlurRadius(f);
    }

    public BlurViewFacade setOverlayColor(int i) {
        this.overlayColor = i;
        return this.blurController.setOverlayColor(i);
    }

    public BlurViewFacade setBlurAutoUpdate(boolean z) {
        return this.blurController.setBlurAutoUpdate(z);
    }

    public BlurViewFacade setBlurEnabled(boolean z) {
        return this.blurController.setBlurEnabled(z);
    }
}

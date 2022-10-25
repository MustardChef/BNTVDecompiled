package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseIndicatorController {
    private List<Animator> mAnimators;
    private View mTarget;

    /* loaded from: classes3.dex */
    public enum AnimStatus {
        START,
        END,
        CANCEL
    }

    public abstract List<Animator> createAnimation();

    public abstract void draw(Canvas canvas, Paint paint);

    public void destroy() {
        this.mTarget = null;
        releaseAnimations();
        this.mAnimators = null;
    }

    public void setTarget(View view) {
        this.mTarget = view;
    }

    public View getTarget() {
        return this.mTarget;
    }

    public int getWidth() {
        View view = this.mTarget;
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }

    public int getHeight() {
        View view = this.mTarget;
        if (view == null) {
            return 0;
        }
        return view.getHeight();
    }

    public void postInvalidate() {
        View view = this.mTarget;
        if (view != null) {
            view.postInvalidate();
        }
    }

    public void initAnimation() {
        this.mAnimators = createAnimation();
    }

    private void releaseAnimations() {
        List<Animator> list = this.mAnimators;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animator animator = this.mAnimators.get(i);
            animator.cancel();
            animator.removeAllListeners();
        }
        this.mAnimators.clear();
        this.mAnimators = null;
    }

    public void setAnimationStatus(AnimStatus animStatus) {
        List<Animator> list = this.mAnimators;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animator animator = this.mAnimators.get(i);
            boolean isRunning = animator.isRunning();
            int i2 = C47411.f9895x40265abc[animStatus.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3 && isRunning) {
                        animator.cancel();
                    }
                } else if (isRunning) {
                    animator.end();
                }
            } else if (!isRunning) {
                animator.start();
            }
        }
    }

    /* renamed from: com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController$1 */
    /* loaded from: classes3.dex */
    static /* synthetic */ class C47411 {

        /* renamed from: $SwitchMap$com$jcodecraeer$xrecyclerview$progressindicator$indicator$BaseIndicatorController$AnimStatus */
        static final /* synthetic */ int[] f9895x40265abc;

        static {
            int[] iArr = new int[AnimStatus.values().length];
            f9895x40265abc = iArr;
            try {
                iArr[AnimStatus.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9895x40265abc[AnimStatus.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9895x40265abc[AnimStatus.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}

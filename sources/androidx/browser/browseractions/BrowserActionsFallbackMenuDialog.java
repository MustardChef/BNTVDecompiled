package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@Deprecated
/* loaded from: classes.dex */
class BrowserActionsFallbackMenuDialog extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 250;
    private static final long EXIT_ANIMATION_DURATION_MS = 150;
    private final View mContentView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BrowserActionsFallbackMenuDialog(Context context, View contentView) {
        super(context);
        this.mContentView = contentView;
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        startAnimation(true);
        super.show();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        startAnimation(false);
    }

    private void startAnimation(final boolean isEnterAnimation) {
        float f = isEnterAnimation ? 0.0f : 1.0f;
        float f2 = isEnterAnimation ? 1.0f : 0.0f;
        long j = isEnterAnimation ? ENTER_ANIMATION_DURATION_MS : 150L;
        this.mContentView.setScaleX(f);
        this.mContentView.setScaleY(f);
        this.mContentView.animate().scaleX(f2).scaleY(f2).setDuration(j).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: androidx.browser.browseractions.BrowserActionsFallbackMenuDialog.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (isEnterAnimation) {
                    return;
                }
                BrowserActionsFallbackMenuDialog.super.dismiss();
            }
        }).start();
    }
}

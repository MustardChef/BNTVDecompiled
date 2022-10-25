package eightbitlab.com.blurview;

import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public interface BlurViewFacade {
    BlurViewFacade setBlurAlgorithm(BlurAlgorithm blurAlgorithm);

    BlurViewFacade setBlurAutoUpdate(boolean z);

    BlurViewFacade setBlurEnabled(boolean z);

    BlurViewFacade setBlurRadius(float f);

    BlurViewFacade setFrameClearDrawable(Drawable drawable);

    BlurViewFacade setHasFixedTransformationMatrix(boolean z);

    BlurViewFacade setOverlayColor(int i);
}

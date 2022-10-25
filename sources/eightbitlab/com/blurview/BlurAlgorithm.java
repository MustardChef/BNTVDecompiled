package eightbitlab.com.blurview;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public interface BlurAlgorithm {
    Bitmap blur(Bitmap bitmap, float f);

    boolean canModifyBitmap();

    void destroy();

    Bitmap.Config getSupportedBitmapConfig();
}

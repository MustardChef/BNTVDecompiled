package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http.HttpStatusCodes;

/* loaded from: classes3.dex */
public class BallGridBeatIndicator extends BaseIndicatorController {
    public static final int ALPHA = 255;
    int[] alphas = {255, 255, 255, 255, 255, 255, 255, 255, 255};

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void draw(Canvas canvas, Paint paint) {
        float width = (getWidth() - 16.0f) / 6.0f;
        float f = 2.0f * width;
        float f2 = f + 4.0f;
        float width2 = (getWidth() / 2) - f2;
        float width3 = (getWidth() / 2) - f2;
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                canvas.save();
                float f3 = i2;
                float f4 = (f * f3) + width2 + (f3 * 4.0f);
                float f5 = i;
                canvas.translate(f4, (f * f5) + width3 + (f5 * 4.0f));
                paint.setAlpha(this.alphas[(i * 3) + i2]);
                canvas.drawCircle(0.0f, 0.0f, width, paint);
                canvas.restore();
            }
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> createAnimation() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {960, 930, 1190, 1130, 1340, 940, 1200, 820, 1190};
        int[] iArr2 = {360, 400, 680, HttpStatusCodes.HTTP_GONE, 710, -150, -120, 10, 320};
        for (final int i = 0; i < 9; i++) {
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 168, 255);
            ofInt.setDuration(iArr[i]);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay(iArr2[i]);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallGridBeatIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallGridBeatIndicator.this.alphas[i] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    BallGridBeatIndicator.this.postInvalidate();
                }
            });
            ofInt.start();
            arrayList.add(ofInt);
        }
        return arrayList;
    }
}

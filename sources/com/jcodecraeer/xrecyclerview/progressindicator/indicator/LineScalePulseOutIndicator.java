package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class LineScalePulseOutIndicator extends LineScaleIndicator {
    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.LineScaleIndicator, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> createAnimation() {
        ArrayList arrayList = new ArrayList();
        long[] jArr = {500, 250, 0, 250, 500};
        for (final int i = 0; i < 5; i++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(900L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr[i]);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.jcodecraeer.xrecyclerview.progressindicator.indicator.LineScalePulseOutIndicator.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LineScalePulseOutIndicator.this.scaleYFloats[i] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LineScalePulseOutIndicator.this.postInvalidate();
                }
            });
            ofFloat.start();
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}

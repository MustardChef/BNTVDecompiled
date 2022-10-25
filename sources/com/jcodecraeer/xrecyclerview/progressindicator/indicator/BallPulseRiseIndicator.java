package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BallPulseRiseIndicator extends BaseIndicatorController {
    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void draw(Canvas canvas, Paint paint) {
        float width = getWidth() / 10;
        float f = 2.0f * width;
        canvas.drawCircle(getWidth() / 4, f, width, paint);
        canvas.drawCircle((getWidth() * 3) / 4, f, width, paint);
        canvas.drawCircle(width, getHeight() - f, width, paint);
        canvas.drawCircle(getWidth() / 2, getHeight() - f, width, paint);
        canvas.drawCircle(getWidth() - width, getHeight() - f, width, paint);
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> createAnimation() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(getTarget(), PropertyValuesHolder.ofFloat("rotationX", 0.0f, 360.0f));
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setDuration(1500L);
        ofPropertyValuesHolder.start();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofPropertyValuesHolder);
        return arrayList;
    }
}

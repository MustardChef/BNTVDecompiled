package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SquareSpinIndicator extends BaseIndicatorController {
    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void draw(Canvas canvas, Paint paint) {
        canvas.drawRect(new RectF(getWidth() / 5, getHeight() / 5, (getWidth() * 4) / 5, (getHeight() * 4) / 5), paint);
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> createAnimation() {
        ArrayList arrayList = new ArrayList();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("rotationX", 0.0f, 180.0f, 180.0f, 0.0f, 0.0f);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(getTarget(), PropertyValuesHolder.ofFloat("rotationY", 0.0f, 0.0f, 180.0f, 180.0f, 0.0f), ofFloat);
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setDuration(2500L);
        ofPropertyValuesHolder.start();
        arrayList.add(ofPropertyValuesHolder);
        return arrayList;
    }
}

package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallSpinFadeLoaderIndicator;

/* loaded from: classes3.dex */
public class LineSpinFadeLoaderIndicator extends BallSpinFadeLoaderIndicator {
    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BallSpinFadeLoaderIndicator, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void draw(Canvas canvas, Paint paint) {
        float width = getWidth() / 10;
        for (int i = 0; i < 8; i++) {
            canvas.save();
            BallSpinFadeLoaderIndicator.Point circleAt = circleAt(getWidth(), getHeight(), (getWidth() / 2.5f) - width, 0.7853981633974483d * i);
            canvas.translate(circleAt.f9893x, circleAt.f9894y);
            canvas.scale(this.scaleFloats[i], this.scaleFloats[i]);
            canvas.rotate(i * 45);
            paint.setAlpha(this.alphas[i]);
            float f = -width;
            canvas.drawRoundRect(new RectF(f, f / 1.5f, width * 1.5f, width / 1.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }
}

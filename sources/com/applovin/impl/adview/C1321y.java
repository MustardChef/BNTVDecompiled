package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.applovin.impl.adview.AbstractC1252j;

/* renamed from: com.applovin.impl.adview.y */
/* loaded from: classes.dex */
public final class C1321y extends AbstractC1252j {

    /* renamed from: c */
    private static final Paint f768c = new Paint(1);

    /* renamed from: d */
    private static final Paint f769d = new Paint(1);

    /* renamed from: e */
    private static final Paint f770e = new Paint(1);

    public C1321y(Context context) {
        super(context);
        f768c.setColor(-1);
        f769d.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint = f770e;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    protected float getCenter() {
        return getSize() / 2.0f;
    }

    protected float getCrossOffset() {
        return this.f602a * 10.0f;
    }

    protected float getInnerCircleOffset() {
        return this.f602a * 2.0f;
    }

    protected float getInnerCircleRadius() {
        return getCenter() - getInnerCircleOffset();
    }

    protected float getStrokeWidth() {
        return this.f602a * 3.0f;
    }

    @Override // com.applovin.impl.adview.AbstractC1252j
    public AbstractC1252j.EnumC1253a getStyle() {
        return AbstractC1252j.EnumC1253a.WHITE_ON_BLACK;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f768c);
        canvas.drawCircle(center, center, getInnerCircleRadius(), f769d);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f770e;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawLine(crossOffset, crossOffset, size, size, paint);
        canvas.drawLine(crossOffset, size, size, crossOffset, paint);
    }
}

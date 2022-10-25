package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.AbstractC1252j;

/* renamed from: com.applovin.impl.adview.s */
/* loaded from: classes.dex */
public final class C1313s extends AbstractC1252j {

    /* renamed from: c */
    private static final Paint f751c = new Paint(1);

    /* renamed from: d */
    private static final Paint f752d = new Paint(1);

    public C1313s(Context context) {
        super(context);
        f751c.setARGB(80, 0, 0, 0);
        Paint paint = f752d;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override // com.applovin.impl.adview.AbstractC1252j
    /* renamed from: a */
    public void mo7900a(int i) {
        setViewScale(i / 30.0f);
    }

    protected float getCenter() {
        return getSize() / 2.0f;
    }

    protected float getCrossOffset() {
        return this.f602a * 8.0f;
    }

    protected float getStrokeWidth() {
        return this.f602a * 2.0f;
    }

    @Override // com.applovin.impl.adview.AbstractC1252j
    public AbstractC1252j.EnumC1253a getStyle() {
        return AbstractC1252j.EnumC1253a.WHITE_ON_TRANSPARENT;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float center = getCenter();
        canvas.drawCircle(center, center, center, f751c);
        float crossOffset = getCrossOffset();
        float size = getSize() - crossOffset;
        Paint paint = f752d;
        paint.setStrokeWidth(getStrokeWidth());
        canvas.drawLine(crossOffset, crossOffset, size, size, paint);
        canvas.drawLine(crossOffset, size, size, crossOffset, paint);
    }
}

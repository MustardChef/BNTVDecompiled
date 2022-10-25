package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aen */
/* loaded from: classes2.dex */
public final class aen extends FrameLayout {

    /* renamed from: a */
    private final aem f3620a;

    /* renamed from: b */
    private float f3621b;

    /* renamed from: c */
    private final int f3622c;

    public aen(Context context) {
        super(context, null);
        this.f3622c = 0;
        this.f3620a = new aem(this);
    }

    /* renamed from: a */
    public final void m5721a(float f) {
        if (this.f3621b != f) {
            this.f3621b = f;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3621b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = measuredWidth;
        float f2 = measuredHeight;
        float f3 = (this.f3621b / (f / f2)) - 1.0f;
        if (Math.abs(f3) <= 0.01f) {
            this.f3620a.m5722a();
            return;
        }
        if (f3 > 0.0f) {
            measuredHeight = (int) (f / this.f3621b);
        } else {
            measuredWidth = (int) (f2 * this.f3621b);
        }
        this.f3620a.m5722a();
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }
}

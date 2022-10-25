package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.webkit.WebView;

/* renamed from: com.applovin.impl.adview.i */
/* loaded from: classes.dex */
public class C1251i extends WebView {

    /* renamed from: a */
    private PointF f601a;

    public C1251i(Context context) {
        super(context);
        this.f601a = new PointF();
    }

    public PointF getAndClearLastClickLocation() {
        PointF pointF = this.f601a;
        this.f601a = new PointF();
        return pointF;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f601a = new PointF(motionEvent.getRawX(), motionEvent.getRawY());
        return super.onTouchEvent(motionEvent);
    }
}

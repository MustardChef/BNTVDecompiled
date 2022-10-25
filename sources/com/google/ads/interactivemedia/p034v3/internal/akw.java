package com.google.ads.interactivemedia.p034v3.internal;

import android.view.ViewGroup;
import android.webkit.WebView;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akw */
/* loaded from: classes2.dex */
public final class akw {

    /* renamed from: a */
    private final WebView f4344a;

    /* renamed from: b */
    private final ViewGroup f4345b;

    public akw(WebView webView, ViewGroup viewGroup) {
        this.f4344a = webView;
        this.f4345b = viewGroup;
    }

    /* renamed from: a */
    public final void m5062a() {
        this.f4344a.setVisibility(4);
    }

    /* renamed from: b */
    public final void m5061b() {
        if (((ViewGroup) this.f4344a.getParent()) == null) {
            this.f4345b.addView(this.f4344a, new ViewGroup.LayoutParams(-1, -1));
        }
        this.f4344a.setVisibility(0);
        this.f4345b.bringChildToFront(this.f4344a);
    }
}

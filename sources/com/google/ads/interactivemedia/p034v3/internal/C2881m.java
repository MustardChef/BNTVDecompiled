package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseBooleanArray;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.m */
/* loaded from: classes2.dex */
public final class C2881m {

    /* renamed from: a */
    private final SparseBooleanArray f8078a = new SparseBooleanArray();

    /* renamed from: b */
    private boolean f8079b;

    /* renamed from: a */
    public final C2908n m1662a() {
        C2616ce.m2685h(!this.f8079b);
        this.f8079b = true;
        return new C2908n(this.f8078a);
    }

    /* renamed from: b */
    public final void m1661b(int i) {
        C2616ce.m2685h(!this.f8079b);
        this.f8078a.append(i, true);
    }
}

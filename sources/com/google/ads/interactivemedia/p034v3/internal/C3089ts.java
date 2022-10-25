package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ts */
/* loaded from: classes2.dex */
public final class C3089ts {

    /* renamed from: a */
    private final InterfaceC2636cy f8973a;

    /* renamed from: d */
    private C3088tr f8976d;

    /* renamed from: b */
    private InterfaceC2922nn f8974b = new C2907mz();

    /* renamed from: e */
    private C3161wj f8977e = new C3161wj();

    /* renamed from: c */
    private int f8975c = 1048576;

    public C3089ts(InterfaceC2636cy interfaceC2636cy, C3088tr c3088tr) {
        this.f8973a = interfaceC2636cy;
        this.f8976d = c3088tr;
    }

    @Deprecated
    /* renamed from: a */
    public final C3090tt m1012a(Uri uri) {
        C3043s c3043s = new C3043s();
        c3043s.m1173e(uri);
        C2543ae m1177a = c3043s.m1177a();
        C2616ce.m2689d(m1177a.f3562b);
        C2537aa c2537aa = m1177a.f3562b;
        Object obj = c2537aa.f2870h;
        String str = c2537aa.f2868f;
        return new C3090tt(m1177a, this.f8973a, this.f8976d, this.f8974b.mo1582a(m1177a), this.f8977e, this.f8975c, null);
    }
}

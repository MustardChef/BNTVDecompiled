package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vv */
/* loaded from: classes2.dex */
public final class C3146vv {

    /* renamed from: a */
    public final int f9243a;

    /* renamed from: b */
    public final C2739gt[] f9244b;

    /* renamed from: c */
    public final InterfaceC3142vr[] f9245c;

    /* renamed from: d */
    public final C2596bl f9246d;

    /* renamed from: e */
    public final Object f9247e;

    public C3146vv(C2739gt[] c2739gtArr, InterfaceC3142vr[] interfaceC3142vrArr, C2596bl c2596bl, Object obj) {
        this.f9244b = c2739gtArr;
        this.f9245c = (InterfaceC3142vr[]) interfaceC3142vrArr.clone();
        this.f9246d = c2596bl;
        this.f9247e = obj;
        this.f9243a = c2739gtArr.length;
    }

    /* renamed from: a */
    public final boolean m783a(C3146vv c3146vv, int i) {
        return c3146vv != null && C2628cq.m2563T(this.f9244b[i], c3146vv.f9244b[i]) && C2628cq.m2563T(this.f9245c[i], c3146vv.f9245c[i]);
    }

    /* renamed from: b */
    public final boolean m782b(int i) {
        return this.f9244b[i] != null;
    }
}

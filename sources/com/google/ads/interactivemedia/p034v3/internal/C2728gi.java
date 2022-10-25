package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gi */
/* loaded from: classes2.dex */
public final class C2728gi implements InterfaceC2724ge {

    /* renamed from: a */
    public final C3063st f7389a;

    /* renamed from: d */
    public int f7392d;

    /* renamed from: e */
    public boolean f7393e;

    /* renamed from: c */
    public final List f7391c = new ArrayList();

    /* renamed from: b */
    public final Object f7390b = new Object();

    public C2728gi(InterfaceC3069sz interfaceC3069sz, boolean z) {
        this.f7389a = new C3063st(interfaceC3069sz, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2724ge
    /* renamed from: a */
    public final AbstractC2586bb mo2238a() {
        return this.f7389a.m1108j();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2724ge
    /* renamed from: b */
    public final Object mo2237b() {
        return this.f7390b;
    }

    /* renamed from: c */
    public final void m2236c(int i) {
        this.f7392d = i;
        this.f7393e = false;
        this.f7391c.clear();
    }
}

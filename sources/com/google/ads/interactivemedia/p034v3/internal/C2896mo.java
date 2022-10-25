package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashMap;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.mo */
/* loaded from: classes2.dex */
public final class C2896mo {

    /* renamed from: a */
    private final HashMap f8127a = new HashMap();

    /* renamed from: b */
    private UUID f8128b = C2692f.f7210d;

    /* renamed from: e */
    private C2933ny f8131e = C2936oa.f8229a;

    /* renamed from: f */
    private final C3161wj f8132f = new C3161wj();

    /* renamed from: c */
    private int[] f8129c = new int[0];

    /* renamed from: d */
    private final long f8130d = 300000;

    /* renamed from: a */
    public final C2906my m1632a(InterfaceC2939od interfaceC2939od) {
        return new C2906my(this.f8128b, this.f8131e, interfaceC2939od, this.f8127a, this.f8129c, this.f8132f, 300000L, null);
    }

    /* renamed from: b */
    public final void m1631b(int... iArr) {
        for (int i : iArr) {
            boolean z = true;
            if (i != 2 && i != 1) {
                z = false;
            }
            C2616ce.m2687f(z);
        }
        this.f8129c = (int[]) iArr.clone();
    }

    /* renamed from: c */
    public final void m1630c(UUID uuid, C2933ny c2933ny) {
        C2616ce.m2689d(uuid);
        this.f8128b = uuid;
        this.f8131e = c2933ny;
    }
}

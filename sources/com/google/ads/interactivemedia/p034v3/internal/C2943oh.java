package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.oh */
/* loaded from: classes2.dex */
public final class C2943oh {

    /* renamed from: b */
    private static final C3247zo f8244b = new C3247zo();

    /* renamed from: a */
    final InterfaceC3229yx f8245a;

    /* renamed from: c */
    private final C2962p f8246c;

    /* renamed from: d */
    private final C2626co f8247d;

    public C2943oh(InterfaceC3229yx interfaceC3229yx, C2962p c2962p, C2626co c2626co) {
        this.f8245a = interfaceC3229yx;
        this.f8246c = c2962p;
        this.f8247d = c2626co;
    }

    /* renamed from: a */
    public final boolean m1482a() {
        InterfaceC3229yx interfaceC3229yx = this.f8245a;
        return (interfaceC3229yx instanceof aef) || (interfaceC3229yx instanceof acg);
    }

    /* renamed from: b */
    public final boolean m1481b(InterfaceC3230yy interfaceC3230yy) throws IOException {
        return this.f8245a.mo432a(interfaceC3230yy, f8244b) == 0;
    }

    /* renamed from: c */
    public final C2943oh m1480c() {
        InterfaceC3229yx abnVar;
        C2616ce.m2685h(!m1482a());
        InterfaceC3229yx interfaceC3229yx = this.f8245a;
        if (interfaceC3229yx instanceof C2973pk) {
            abnVar = new C2973pk(this.f8246c.f8363c, this.f8247d);
        } else if (interfaceC3229yx instanceof adb) {
            abnVar = new adb();
        } else if (interfaceC3229yx instanceof acw) {
            abnVar = new acw();
        } else if (interfaceC3229yx instanceof acz) {
            abnVar = new acz();
        } else if (interfaceC3229yx instanceof abn) {
            abnVar = new abn();
        } else {
            String valueOf = String.valueOf(interfaceC3229yx.getClass().getSimpleName());
            throw new IllegalStateException(valueOf.length() != 0 ? "Unexpected extractor type for recreation: ".concat(valueOf) : new String("Unexpected extractor type for recreation: "));
        }
        return new C2943oh(abnVar, this.f8246c, this.f8247d);
    }
}

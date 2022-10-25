package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lt */
/* loaded from: classes2.dex */
public abstract class AbstractC2874lt {

    /* renamed from: a */
    private final C2871lq f8056a;

    /* renamed from: b */
    public final C2962p f8057b;

    /* renamed from: c */
    public final avg f8058c;

    /* renamed from: d */
    public final long f8059d;

    /* renamed from: e */
    public final List f8060e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ AbstractC2874lt(C2962p c2962p, List list, C2880lz c2880lz, List list2) {
        C2616ce.m2687f(!list.isEmpty());
        this.f8057b = c2962p;
        this.f8058c = avg.m4517l(list);
        this.f8060e = Collections.unmodifiableList(list2);
        this.f8056a = c2880lz.mo1663i(this);
        this.f8059d = C2628cq.m2512v(c2880lz.f8077j, 1000000L, c2880lz.f8076i);
    }

    /* renamed from: k */
    public abstract InterfaceC2850kw mo1675k();

    /* renamed from: l */
    public abstract C2871lq mo1674l();

    /* renamed from: m */
    public abstract void mo1673m();

    /* renamed from: n */
    public final C2871lq m1672n() {
        return this.f8056a;
    }
}

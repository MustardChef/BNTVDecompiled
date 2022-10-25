package com.google.ads.interactivemedia.p034v3.internal;

import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.oo */
/* loaded from: classes2.dex */
final class C2950oo extends AbstractC3107uj {

    /* renamed from: b */
    private final List f8255b;

    /* renamed from: c */
    private final long f8256c;

    public C2950oo(long j, List list) {
        super(0L, list.size() - 1);
        this.f8256c = j;
        this.f8255b = list;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3125va
    /* renamed from: a */
    public final long mo852a() {
        m907d();
        C2987py c2987py = (C2987py) this.f8255b.get((int) m908c());
        return this.f8256c + c2987py.f8528g + c2987py.f8526e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3125va
    /* renamed from: b */
    public final long mo851b() {
        m907d();
        return this.f8256c + ((C2987py) this.f8255b.get((int) m908c())).f8528g;
    }
}

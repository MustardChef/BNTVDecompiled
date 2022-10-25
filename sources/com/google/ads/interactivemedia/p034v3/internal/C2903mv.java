package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.mv */
/* loaded from: classes2.dex */
public final class C2903mv implements InterfaceC2889mh {

    /* renamed from: a */
    private final Set f8142a = new HashSet();

    /* renamed from: b */
    private C2895mn f8143b;

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2889mh
    /* renamed from: a */
    public final void mo1627a() {
        this.f8143b = null;
        avg m4517l = avg.m4517l(this.f8142a);
        this.f8142a.clear();
        int size = m4517l.size();
        for (int i = 0; i < size; i++) {
            ((C2895mn) m4517l.get(i)).m1643j();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2889mh
    /* renamed from: b */
    public final void mo1626b(Exception exc, boolean z) {
        this.f8143b = null;
        avg m4517l = avg.m4517l(this.f8142a);
        this.f8142a.clear();
        int size = m4517l.size();
        for (int i = 0; i < size; i++) {
            ((C2895mn) m4517l.get(i)).m1642k(exc, z);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2889mh
    /* renamed from: c */
    public final void mo1625c(C2895mn c2895mn) {
        this.f8142a.add(c2895mn);
        if (this.f8143b != null) {
            return;
        }
        this.f8143b = c2895mn;
        c2895mn.m1641l();
    }

    /* renamed from: d */
    public final void m1624d(C2895mn c2895mn) {
        this.f8142a.remove(c2895mn);
        if (this.f8143b == c2895mn) {
            this.f8143b = null;
            if (this.f8142a.isEmpty()) {
                return;
            }
            C2895mn c2895mn2 = (C2895mn) this.f8142a.iterator().next();
            this.f8143b = c2895mn2;
            c2895mn2.m1641l();
        }
    }
}

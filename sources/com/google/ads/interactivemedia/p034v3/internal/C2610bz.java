package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bz */
/* loaded from: classes2.dex */
public final class C2610bz {

    /* renamed from: a */
    public final Object f6913a;

    /* renamed from: b */
    private C2881m f6914b = new C2881m();

    /* renamed from: c */
    private boolean f6915c;

    /* renamed from: d */
    private boolean f6916d;

    public C2610bz(Object obj) {
        this.f6913a = obj;
    }

    /* renamed from: a */
    public final void m2710a(int i, InterfaceC2608bx interfaceC2608bx) {
        if (this.f6916d) {
            return;
        }
        if (i != -1) {
            this.f6914b.m1661b(i);
        }
        this.f6915c = true;
        interfaceC2608bx.mo2093a(this.f6913a);
    }

    /* renamed from: b */
    public final void m2709b(InterfaceC2609by interfaceC2609by) {
        if (this.f6916d || !this.f6915c) {
            return;
        }
        C2908n m1662a = this.f6914b.m1662a();
        this.f6914b = new C2881m();
        this.f6915c = false;
        interfaceC2609by.mo2092a(this.f6913a, m1662a);
    }

    /* renamed from: c */
    public final void m2708c(InterfaceC2609by interfaceC2609by) {
        this.f6916d = true;
        if (this.f6915c) {
            interfaceC2609by.mo2092a(this.f6913a, this.f6914b.m1662a());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f6913a.equals(((C2610bz) obj).f6913a);
    }

    public final int hashCode() {
        return this.f6913a.hashCode();
    }
}

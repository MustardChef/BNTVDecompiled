package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.brj */
/* loaded from: classes2.dex */
final class brj {

    /* renamed from: a */
    private final Object f6898a;

    /* renamed from: b */
    private final int f6899b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public brj(Object obj) {
        this.f6899b = System.identityHashCode(obj);
        this.f6898a = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof brj) {
            brj brjVar = (brj) obj;
            return this.f6899b == brjVar.f6899b && this.f6898a == brjVar.f6898a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6899b;
    }
}

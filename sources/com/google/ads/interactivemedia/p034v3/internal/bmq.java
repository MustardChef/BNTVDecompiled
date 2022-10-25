package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmq */
/* loaded from: classes2.dex */
final class bmq {

    /* renamed from: a */
    private final Object f6170a;

    /* renamed from: b */
    private final int f6171b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bmq(Object obj, int i) {
        this.f6170a = obj;
        this.f6171b = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bmq) {
            bmq bmqVar = (bmq) obj;
            return this.f6170a == bmqVar.f6170a && this.f6171b == bmqVar.f6171b;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f6170a) * 65535) + this.f6171b;
    }
}

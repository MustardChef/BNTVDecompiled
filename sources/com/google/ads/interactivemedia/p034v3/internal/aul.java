package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aul */
/* loaded from: classes2.dex */
final class aul extends awp implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    final Comparator f5113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aul(Comparator comparator) {
        atm.m4612j(comparator);
        this.f5113a = comparator;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awp, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f5113a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aul) {
            return this.f5113a.equals(((aul) obj).f5113a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5113a.hashCode();
    }

    public final String toString() {
        return this.f5113a.toString();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awz */
/* loaded from: classes2.dex */
final class awz extends awp implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    final awp f5237a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awz(awp awpVar) {
        this.f5237a = awpVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awp
    /* renamed from: a */
    public final awp mo4426a() {
        return this.f5237a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awp, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f5237a.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof awz) {
            return this.f5237a.equals(((awz) obj).f5237a);
        }
        return false;
    }

    public final int hashCode() {
        return -this.f5237a.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5237a);
        String.valueOf(valueOf).length();
        return String.valueOf(valueOf).concat(".reverse()");
    }
}

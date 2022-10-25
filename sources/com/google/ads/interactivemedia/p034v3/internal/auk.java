package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auk */
/* loaded from: classes2.dex */
final class auk extends awp implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    final ath f5111a;

    /* renamed from: b */
    final awp f5112b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public auk(ath athVar, awp awpVar) {
        atm.m4612j(athVar);
        this.f5111a = athVar;
        this.f5112b = awpVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.awp, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f5112b.compare(this.f5111a.mo4331a(obj), this.f5111a.mo4331a(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof auk) {
            auk aukVar = (auk) obj;
            if (this.f5111a.equals(aukVar.f5111a) && this.f5112b.equals(aukVar.f5112b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5111a, this.f5112b});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5112b);
        String valueOf2 = String.valueOf(this.f5111a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append(".onResultOf(");
        sb.append(valueOf2);
        sb.append(")");
        return sb.toString();
    }
}

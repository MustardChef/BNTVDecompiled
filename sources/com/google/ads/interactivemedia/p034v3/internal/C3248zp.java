package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zp */
/* loaded from: classes2.dex */
public final class C3248zp {

    /* renamed from: a */
    public final C3251zs f9611a;

    /* renamed from: b */
    public final C3251zs f9612b;

    public C3248zp(C3251zs c3251zs, C3251zs c3251zs2) {
        this.f9611a = c3251zs;
        this.f9612b = c3251zs2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C3248zp c3248zp = (C3248zp) obj;
            if (this.f9611a.equals(c3248zp.f9611a) && this.f9612b.equals(c3248zp.f9612b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f9611a.hashCode() * 31) + this.f9612b.hashCode();
    }

    public final String toString() {
        String concat;
        String valueOf = String.valueOf(this.f9611a);
        if (this.f9611a.equals(this.f9612b)) {
            concat = "";
        } else {
            String valueOf2 = String.valueOf(this.f9612b);
            String.valueOf(valueOf2).length();
            concat = ", ".concat(String.valueOf(valueOf2));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 2 + concat.length());
        sb.append("[");
        sb.append(valueOf);
        sb.append(concat);
        sb.append("]");
        return sb.toString();
    }
}

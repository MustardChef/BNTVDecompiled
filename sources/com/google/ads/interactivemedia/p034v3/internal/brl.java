package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2520k;
import java.io.Serializable;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.brl */
/* loaded from: classes2.dex */
public abstract class brl implements Map.Entry, Comparable, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    /* renamed from: c */
    public static brl m2714c(Object obj, Object obj2) {
        return new brk(obj, obj2);
    }

    /* renamed from: a */
    public abstract Object mo2716a();

    /* renamed from: b */
    public abstract Object mo2715b();

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        brl brlVar = (brl) obj;
        return new C2662dx(null).m2458k(mo2716a(), brlVar.mo2716a()).m2458k(mo2715b(), brlVar.mo2715b()).m2460i();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (C2520k.m5995a(mo2716a(), entry.getKey()) && C2520k.m5995a(mo2715b(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return mo2716a();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return mo2715b();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return mo2716a().hashCode() ^ mo2715b().hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(mo2716a());
        String valueOf2 = String.valueOf(mo2715b());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 3 + String.valueOf(valueOf2).length());
        sb.append("(");
        sb.append(valueOf);
        sb.append(',');
        sb.append(valueOf2);
        sb.append(')');
        return sb.toString();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseBooleanArray;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.n */
/* loaded from: classes2.dex */
public final class C2908n {

    /* renamed from: a */
    private final SparseBooleanArray f8169a;

    /* renamed from: a */
    public final int m1598a(int i) {
        C2616ce.m2683j(i, m1597b());
        return this.f8169a.keyAt(i);
    }

    /* renamed from: b */
    public final int m1597b() {
        return this.f8169a.size();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2908n) {
            C2908n c2908n = (C2908n) obj;
            if (C2628cq.f6961a < 24) {
                if (m1597b() == c2908n.m1597b()) {
                    for (int i = 0; i < m1597b(); i++) {
                        if (m1598a(i) != c2908n.m1598a(i)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return this.f8169a.equals(c2908n.f8169a);
        }
        return false;
    }

    public final int hashCode() {
        if (C2628cq.f6961a < 24) {
            int m1597b = m1597b();
            for (int i = 0; i < m1597b(); i++) {
                m1597b = (m1597b * 31) + m1598a(i);
            }
            return m1597b;
        }
        return this.f8169a.hashCode();
    }
}

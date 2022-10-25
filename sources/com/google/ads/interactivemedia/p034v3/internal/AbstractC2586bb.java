package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Pair;
import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bb */
/* loaded from: classes2.dex */
public abstract class AbstractC2586bb {

    /* renamed from: a */
    public static final AbstractC2586bb f5384a = new C2582ay();

    /* renamed from: a */
    public abstract int mo925a(Object obj);

    /* renamed from: b */
    public abstract int mo924b();

    /* renamed from: c */
    public abstract int mo923c();

    /* renamed from: d */
    public abstract C2583az mo922d(int i, C2583az c2583az, boolean z);

    /* renamed from: e */
    public abstract C2585ba mo921e(int i, C2585ba c2585ba, long j);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AbstractC2586bb) {
            AbstractC2586bb abstractC2586bb = (AbstractC2586bb) obj;
            if (abstractC2586bb.mo923c() == mo923c() && abstractC2586bb.mo924b() == mo924b()) {
                C2585ba c2585ba = new C2585ba();
                C2583az c2583az = new C2583az();
                C2585ba c2585ba2 = new C2585ba();
                C2583az c2583az2 = new C2583az();
                for (int i = 0; i < mo923c(); i++) {
                    if (!m4205o(i, c2585ba).equals(abstractC2586bb.m4205o(i, c2585ba2))) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < mo924b(); i2++) {
                    if (!mo922d(i2, c2583az, true).equals(abstractC2586bb.mo922d(i2, c2583az2, true))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public abstract Object mo920f(int i);

    /* renamed from: g */
    public int mo1131g(boolean z) {
        return m4204p() ? -1 : 0;
    }

    /* renamed from: h */
    public int mo1130h(boolean z) {
        if (m4204p()) {
            return -1;
        }
        return mo923c() - 1;
    }

    public final int hashCode() {
        C2585ba c2585ba = new C2585ba();
        C2583az c2583az = new C2583az();
        int mo923c = mo923c() + bqk.f6556bP;
        for (int i = 0; i < mo923c(); i++) {
            mo923c = (mo923c * 31) + m4205o(i, c2585ba).hashCode();
        }
        int mo924b = (mo923c * 31) + mo924b();
        for (int i2 = 0; i2 < mo924b(); i2++) {
            mo924b = (mo924b * 31) + mo922d(i2, c2583az, true).hashCode();
        }
        return mo924b;
    }

    /* renamed from: i */
    public final int m4209i(int i, C2583az c2583az, C2585ba c2585ba, int i2, boolean z) {
        int i3 = m4206m(i, c2583az).f5314c;
        if (m4205o(i3, c2585ba).f5362p == i) {
            int mo1129j = mo1129j(i3, i2, z);
            if (mo1129j == -1) {
                return -1;
            }
            return m4205o(mo1129j, c2585ba).f5361o;
        }
        return i + 1;
    }

    /* renamed from: j */
    public int mo1129j(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == mo1130h(z)) {
                return -1;
            }
            return i + 1;
        } else if (i2 != 1) {
            if (i2 == 2) {
                return i == mo1130h(z) ? mo1131g(z) : i + 1;
            }
            throw new IllegalStateException();
        } else {
            return i;
        }
    }

    /* renamed from: k */
    public final Pair m4208k(C2585ba c2585ba, C2583az c2583az, int i, long j) {
        Pair m4207l = m4207l(c2585ba, c2583az, i, j, 0L);
        C2616ce.m2689d(m4207l);
        return m4207l;
    }

    /* renamed from: l */
    public final Pair m4207l(C2585ba c2585ba, C2583az c2583az, int i, long j, long j2) {
        C2616ce.m2683j(i, mo923c());
        mo921e(i, c2585ba, j2);
        if (j == C3282C.TIME_UNSET) {
            j = c2585ba.f5359m;
            if (j == C3282C.TIME_UNSET) {
                return null;
            }
        }
        int i2 = c2585ba.f5361o;
        m4206m(i2, c2583az);
        while (i2 < c2585ba.f5362p && c2583az.f5316e != j) {
            int i3 = i2 + 1;
            if (m4206m(i3, c2583az).f5316e > j) {
                break;
            }
            i2 = i3;
        }
        mo922d(i2, c2583az, true);
        long j3 = j - c2583az.f5316e;
        long j4 = c2583az.f5315d;
        if (j4 != C3282C.TIME_UNSET) {
            j3 = Math.min(j3, j4 - 1);
        }
        long max = Math.max(0L, j3);
        Object obj = c2583az.f5313b;
        C2616ce.m2689d(obj);
        return Pair.create(obj, Long.valueOf(max));
    }

    /* renamed from: m */
    public final C2583az m4206m(int i, C2583az c2583az) {
        return mo922d(i, c2583az, false);
    }

    /* renamed from: n */
    public C2583az mo2442n(Object obj, C2583az c2583az) {
        return mo922d(mo925a(obj), c2583az, true);
    }

    /* renamed from: o */
    public final C2585ba m4205o(int i, C2585ba c2585ba) {
        return mo921e(i, c2585ba, 0L);
    }

    /* renamed from: p */
    public final boolean m4204p() {
        return mo923c() == 0;
    }

    /* renamed from: q */
    public int mo1128q(int i) {
        if (i == mo1131g(false)) {
            return -1;
        }
        return i - 1;
    }
}

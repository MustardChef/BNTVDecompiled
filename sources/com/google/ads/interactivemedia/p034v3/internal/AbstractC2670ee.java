package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Pair;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ee */
/* loaded from: classes2.dex */
public abstract class AbstractC2670ee extends AbstractC2586bb {

    /* renamed from: b */
    private final int f7097b;

    /* renamed from: c */
    private final C3101ud f7098c;

    public AbstractC2670ee(C3101ud c3101ud) {
        this.f7098c = c3101ud;
        this.f7097b = c3101ud.m931c();
    }

    /* renamed from: A */
    private final int m2444A(int i, boolean z) {
        if (z) {
            return this.f7098c.m930d(i);
        }
        if (i >= this.f7097b - 1) {
            return -1;
        }
        return i + 1;
    }

    /* renamed from: B */
    private final int m2443B(int i, boolean z) {
        if (z) {
            return this.f7098c.m929e(i);
        }
        if (i <= 0) {
            return -1;
        }
        return i - 1;
    }

    /* renamed from: x */
    public static Object m2441x(Object obj) {
        return ((Pair) obj).second;
    }

    /* renamed from: y */
    public static Object m2440y(Object obj) {
        return ((Pair) obj).first;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: a */
    public final int mo925a(Object obj) {
        int mo925a;
        if (obj instanceof Pair) {
            Object m2440y = m2440y(obj);
            Object m2441x = m2441x(obj);
            int mo1160r = mo1160r(m2440y);
            if (mo1160r == -1 || (mo925a = mo1155w(mo1160r).mo925a(m2441x)) == -1) {
                return -1;
            }
            return mo1157u(mo1160r) + mo925a;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: d */
    public final C2583az mo922d(int i, C2583az c2583az, boolean z) {
        int mo1159s = mo1159s(i);
        int mo1156v = mo1156v(mo1159s);
        mo1155w(mo1159s).mo922d(i - mo1157u(mo1159s), c2583az, z);
        c2583az.f5314c += mo1156v;
        if (z) {
            Object mo1154z = mo1154z(mo1159s);
            Object obj = c2583az.f5313b;
            C2616ce.m2689d(obj);
            c2583az.f5313b = Pair.create(mo1154z, obj);
        }
        return c2583az;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: e */
    public final C2585ba mo921e(int i, C2585ba c2585ba, long j) {
        int mo1158t = mo1158t(i);
        int mo1156v = mo1156v(mo1158t);
        int mo1157u = mo1157u(mo1158t);
        mo1155w(mo1158t).mo921e(i - mo1156v, c2585ba, j);
        Object mo1154z = mo1154z(mo1158t);
        if (!C2585ba.f5346a.equals(c2585ba.f5348b)) {
            mo1154z = Pair.create(mo1154z, c2585ba.f5348b);
        }
        c2585ba.f5348b = mo1154z;
        c2585ba.f5361o += mo1157u;
        c2585ba.f5362p += mo1157u;
        return c2585ba;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: f */
    public final Object mo920f(int i) {
        int mo1159s = mo1159s(i);
        return Pair.create(mo1154z(mo1159s), mo1155w(mo1159s).mo920f(i - mo1157u(mo1159s)));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: g */
    public final int mo1131g(boolean z) {
        if (this.f7097b == 0) {
            return -1;
        }
        int m933a = z ? this.f7098c.m933a() : 0;
        while (mo1155w(m933a).m4204p()) {
            m933a = m2444A(m933a, z);
            if (m933a == -1) {
                return -1;
            }
        }
        return mo1156v(m933a) + mo1155w(m933a).mo1131g(z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: h */
    public final int mo1130h(boolean z) {
        int i = this.f7097b;
        if (i == 0) {
            return -1;
        }
        int m932b = z ? this.f7098c.m932b() : i - 1;
        while (mo1155w(m932b).m4204p()) {
            m932b = m2443B(m932b, z);
            if (m932b == -1) {
                return -1;
            }
        }
        return mo1156v(m932b) + mo1155w(m932b).mo1130h(z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: j */
    public final int mo1129j(int i, int i2, boolean z) {
        int mo1158t = mo1158t(i);
        int mo1156v = mo1156v(mo1158t);
        int mo1129j = mo1155w(mo1158t).mo1129j(i - mo1156v, i2 == 2 ? 0 : i2, z);
        if (mo1129j != -1) {
            return mo1156v + mo1129j;
        }
        int m2444A = m2444A(mo1158t, z);
        while (m2444A != -1 && mo1155w(m2444A).m4204p()) {
            m2444A = m2444A(m2444A, z);
        }
        if (m2444A != -1) {
            return mo1156v(m2444A) + mo1155w(m2444A).mo1131g(z);
        }
        if (i2 == 2) {
            return mo1131g(z);
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: n */
    public final C2583az mo2442n(Object obj, C2583az c2583az) {
        Object m2440y = m2440y(obj);
        Object m2441x = m2441x(obj);
        int mo1160r = mo1160r(m2440y);
        int mo1156v = mo1156v(mo1160r);
        mo1155w(mo1160r).mo2442n(m2441x, c2583az);
        c2583az.f5314c += mo1156v;
        c2583az.f5313b = obj;
        return c2583az;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: q */
    public final int mo1128q(int i) {
        int mo1158t = mo1158t(i);
        int mo1156v = mo1156v(mo1158t);
        int mo1128q = mo1155w(mo1158t).mo1128q(i - mo1156v);
        if (mo1128q != -1) {
            return mo1156v + mo1128q;
        }
        int m2443B = m2443B(mo1158t, false);
        while (m2443B != -1 && mo1155w(m2443B).m4204p()) {
            m2443B = m2443B(m2443B, false);
        }
        if (m2443B != -1) {
            return mo1156v(m2443B) + mo1155w(m2443B).mo1130h(false);
        }
        return -1;
    }

    /* renamed from: r */
    protected abstract int mo1160r(Object obj);

    /* renamed from: s */
    protected abstract int mo1159s(int i);

    /* renamed from: t */
    protected abstract int mo1158t(int i);

    /* renamed from: u */
    protected abstract int mo1157u(int i);

    /* renamed from: v */
    protected abstract int mo1156v(int i);

    /* renamed from: w */
    protected abstract AbstractC2586bb mo1155w(int i);

    /* renamed from: z */
    protected abstract Object mo1154z(int i);
}

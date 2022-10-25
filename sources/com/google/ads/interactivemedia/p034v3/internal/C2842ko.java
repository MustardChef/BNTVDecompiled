package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ko */
/* loaded from: classes2.dex */
final class C2842ko extends AbstractC2586bb {

    /* renamed from: b */
    private final long f7889b;

    /* renamed from: c */
    private final long f7890c;

    /* renamed from: d */
    private final long f7891d;

    /* renamed from: e */
    private final int f7892e;

    /* renamed from: f */
    private final long f7893f;

    /* renamed from: g */
    private final long f7894g;

    /* renamed from: h */
    private final long f7895h;

    /* renamed from: i */
    private final C2864lj f7896i;

    /* renamed from: j */
    private final C2543ae f7897j;

    /* renamed from: k */
    private final C3232z f7898k;

    public C2842ko(long j, long j2, long j3, int i, long j4, long j5, long j6, C2864lj c2864lj, C2543ae c2543ae, C3232z c3232z) {
        C2616ce.m2685h(c2864lj.f8011d == (c3232z != null));
        this.f7889b = j;
        this.f7890c = j2;
        this.f7891d = j3;
        this.f7892e = i;
        this.f7893f = j4;
        this.f7894g = j5;
        this.f7895h = j6;
        this.f7896i = c2864lj;
        this.f7897j = c2543ae;
        this.f7898k = c3232z;
    }

    /* renamed from: r */
    private static boolean m1775r(C2864lj c2864lj) {
        return c2864lj.f8011d && c2864lj.f8012e != C3282C.TIME_UNSET && c2864lj.f8009b == C3282C.TIME_UNSET;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: a */
    public final int mo925a(Object obj) {
        int intValue;
        if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f7892e) >= 0 && intValue < mo924b()) {
            return intValue;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: b */
    public final int mo924b() {
        return this.f7896i.m1712a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: c */
    public final int mo923c() {
        return 1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: d */
    public final C2583az mo922d(int i, C2583az c2583az, boolean z) {
        C2616ce.m2683j(i, mo924b());
        return c2583az.m4291k(z ? this.f7896i.m1709d(i).f8040a : null, z ? Integer.valueOf(this.f7892e + i) : null, this.f7896i.m1710c(i), C2628cq.m2515s(this.f7896i.m1709d(i).f8041b - this.f7896i.m1709d(0).f8041b) - this.f7893f);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: e */
    public final C2585ba mo921e(int i, C2585ba c2585ba, long j) {
        InterfaceC2850kw mo1675k;
        C2616ce.m2683j(i, 1);
        long j2 = this.f7895h;
        if (m1775r(this.f7896i)) {
            if (j > 0) {
                j2 += j;
                if (j2 > this.f7894g) {
                    j2 = C3282C.TIME_UNSET;
                }
            }
            long j3 = this.f7893f + j2;
            long m1710c = this.f7896i.m1710c(0);
            int i2 = 0;
            while (i2 < this.f7896i.m1712a() - 1 && j3 >= m1710c) {
                j3 -= m1710c;
                i2++;
                m1710c = this.f7896i.m1710c(i2);
            }
            C2869lo m1709d = this.f7896i.m1709d(i2);
            int size = m1709d.f8042c.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (((C2862lh) m1709d.f8042c.get(i3)).f7999b == 2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 != -1 && (mo1675k = ((AbstractC2874lt) ((C2862lh) m1709d.f8042c.get(i3)).f8000c.get(0)).mo1675k()) != null && mo1675k.mo1655f(m1710c) != 0) {
                j2 = (j2 + mo1675k.mo1653h(mo1675k.mo1654g(j3, m1710c))) - j3;
            }
        }
        long j4 = j2;
        Object obj = C2585ba.f5346a;
        C2543ae c2543ae = this.f7897j;
        C2864lj c2864lj = this.f7896i;
        c2585ba.m4249c(obj, c2543ae, c2864lj, this.f7889b, this.f7890c, this.f7891d, true, m1775r(c2864lj), this.f7898k, j4, this.f7894g, mo924b() - 1, this.f7893f);
        return c2585ba;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: f */
    public final Object mo920f(int i) {
        C2616ce.m2683j(i, mo924b());
        return Integer.valueOf(this.f7892e + i);
    }
}

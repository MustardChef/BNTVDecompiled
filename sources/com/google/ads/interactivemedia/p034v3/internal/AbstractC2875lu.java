package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lu */
/* loaded from: classes2.dex */
public abstract class AbstractC2875lu extends C2880lz {

    /* renamed from: a */
    final long f8061a;

    /* renamed from: b */
    final long f8062b;

    /* renamed from: c */
    final List f8063c;

    /* renamed from: d */
    final long f8064d;

    /* renamed from: e */
    private final long f8065e;

    /* renamed from: f */
    private final long f8066f;

    public AbstractC2875lu(C2871lq c2871lq, long j, long j2, long j3, long j4, List list, long j5, long j6, long j7) {
        super(c2871lq, j, j2);
        this.f8061a = j3;
        this.f8062b = j4;
        this.f8063c = list;
        this.f8064d = j5;
        this.f8065e = j6;
        this.f8066f = j7;
    }

    /* renamed from: a */
    public final long m1671a(long j, long j2) {
        long mo1665c = mo1665c(j);
        return mo1665c != -1 ? mo1665c : (int) (m1668e((j2 - this.f8066f) + this.f8064d, j) - m1670b(j, j2));
    }

    /* renamed from: b */
    public final long m1670b(long j, long j2) {
        if (mo1665c(j) == -1) {
            long j3 = this.f8065e;
            if (j3 != C3282C.TIME_UNSET) {
                return Math.max(this.f8061a, m1668e((j2 - this.f8066f) - j3, j));
            }
        }
        return this.f8061a;
    }

    /* renamed from: c */
    public abstract long mo1665c(long j);

    /* renamed from: d */
    public final long m1669d(long j, long j2) {
        List list = this.f8063c;
        if (list != null) {
            return (((C2878lx) list.get((int) (j - this.f8061a))).f8072b * 1000000) / this.f8076i;
        }
        long mo1665c = mo1665c(j2);
        if (mo1665c == -1 || j != (this.f8061a + mo1665c) - 1) {
            return (this.f8062b * 1000000) / this.f8076i;
        }
        return j2 - m1667f(j);
    }

    /* renamed from: e */
    public final long m1668e(long j, long j2) {
        long j3 = this.f8061a;
        long mo1665c = mo1665c(j2);
        if (mo1665c == 0) {
            return j3;
        }
        if (this.f8063c == null) {
            long j4 = this.f8061a + (j / ((this.f8062b * 1000000) / this.f8076i));
            return j4 < j3 ? j3 : mo1665c != -1 ? Math.min(j4, (j3 + mo1665c) - 1) : j4;
        }
        long j5 = (mo1665c + j3) - 1;
        long j6 = j3;
        while (j6 <= j5) {
            long j7 = ((j5 - j6) / 2) + j6;
            int i = (m1667f(j7) > j ? 1 : (m1667f(j7) == j ? 0 : -1));
            if (i < 0) {
                j6 = 1 + j7;
            } else if (i <= 0) {
                return j7;
            } else {
                j5 = j7 - 1;
            }
        }
        return j6 == j3 ? j6 : j5;
    }

    /* renamed from: f */
    public final long m1667f(long j) {
        List list = this.f8063c;
        return C2628cq.m2512v(list != null ? ((C2878lx) list.get((int) (j - this.f8061a))).f8071a - this.f8077j : (j - this.f8061a) * this.f8062b, 1000000L, this.f8076i);
    }

    /* renamed from: g */
    public abstract C2871lq mo1664g(AbstractC2874lt abstractC2874lt, long j);

    /* renamed from: h */
    public boolean mo1666h() {
        return this.f8063c != null;
    }
}

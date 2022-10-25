package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qa */
/* loaded from: classes2.dex */
public final class C2990qa extends AbstractC2991qb {

    /* renamed from: a */
    public final int f8540a;

    /* renamed from: b */
    public final long f8541b;

    /* renamed from: c */
    public final boolean f8542c;

    /* renamed from: d */
    public final boolean f8543d;

    /* renamed from: e */
    public final long f8544e;

    /* renamed from: f */
    public final boolean f8545f;

    /* renamed from: g */
    public final int f8546g;

    /* renamed from: h */
    public final long f8547h;

    /* renamed from: i */
    public final int f8548i;

    /* renamed from: j */
    public final long f8549j;

    /* renamed from: k */
    public final long f8550k;

    /* renamed from: l */
    public final boolean f8551l;

    /* renamed from: m */
    public final boolean f8552m;

    /* renamed from: n */
    public final C2854l f8553n;

    /* renamed from: o */
    public final List f8554o;

    /* renamed from: p */
    public final List f8555p;

    /* renamed from: q */
    public final Map f8556q;

    /* renamed from: r */
    public final long f8557r;

    /* renamed from: s */
    public final C2988pz f8558s;

    public C2990qa(int i, String str, List list, long j, boolean z, long j2, boolean z2, int i2, long j3, int i3, long j4, long j5, boolean z3, boolean z4, boolean z5, C2854l c2854l, List list2, List list3, C2988pz c2988pz, Map map) {
        super(str, list, z3);
        long j6;
        this.f8540a = i;
        this.f8544e = j2;
        this.f8543d = z;
        this.f8545f = z2;
        this.f8546g = i2;
        this.f8547h = j3;
        this.f8548i = i3;
        this.f8549j = j4;
        this.f8550k = j5;
        this.f8551l = z4;
        this.f8552m = z5;
        this.f8553n = c2854l;
        this.f8554o = avg.m4517l(list2);
        this.f8555p = avg.m4517l(list3);
        this.f8556q = avj.m4505c(map);
        if (!list3.isEmpty()) {
            C2984pv c2984pv = (C2984pv) axd.m4386z(list3);
            j6 = c2984pv.f8528g + c2984pv.f8526e;
            this.f8557r = j6;
        } else if (list2.isEmpty()) {
            this.f8557r = 0L;
            j6 = 0;
        } else {
            C2986px c2986px = (C2986px) axd.m4386z(list2);
            j6 = c2986px.f8528g + c2986px.f8526e;
            this.f8557r = j6;
        }
        long j7 = j6;
        long j8 = C3282C.TIME_UNSET;
        if (j != C3282C.TIME_UNSET) {
            if (j >= 0) {
                j8 = Math.min(j7, j);
            } else {
                j8 = Math.max(0L, j6 + j);
            }
        }
        this.f8541b = j8;
        this.f8542c = j >= 0;
        this.f8558s = c2988pz;
    }

    /* renamed from: a */
    public final long m1346a() {
        return this.f8544e + this.f8557r;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3035rs
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ Object mo1188e(List list) {
        return this;
    }
}

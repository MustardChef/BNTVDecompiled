package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;
import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adn */
/* loaded from: classes2.dex */
final class adn {

    /* renamed from: a */
    private final InterfaceC3253zu f3434a;

    /* renamed from: b */
    private final boolean f3435b;

    /* renamed from: c */
    private final boolean f3436c;

    /* renamed from: f */
    private final C3246zn f3439f;

    /* renamed from: g */
    private byte[] f3440g;

    /* renamed from: h */
    private int f3441h;

    /* renamed from: i */
    private int f3442i;

    /* renamed from: j */
    private long f3443j;

    /* renamed from: k */
    private boolean f3444k;

    /* renamed from: l */
    private long f3445l;

    /* renamed from: o */
    private boolean f3448o;

    /* renamed from: p */
    private long f3449p;

    /* renamed from: q */
    private long f3450q;

    /* renamed from: r */
    private boolean f3451r;

    /* renamed from: d */
    private final SparseArray f3437d = new SparseArray();

    /* renamed from: e */
    private final SparseArray f3438e = new SparseArray();

    /* renamed from: m */
    private adm f3446m = new adm(null);

    /* renamed from: n */
    private adm f3447n = new adm(null);

    public adn(InterfaceC3253zu interfaceC3253zu, boolean z, boolean z2) {
        this.f3434a = interfaceC3253zu;
        this.f3435b = z;
        this.f3436c = z2;
        byte[] bArr = new byte[128];
        this.f3440g = bArr;
        this.f3439f = new C3246zn(bArr, 0, 0);
        m5784d();
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0145  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5787a(byte[] r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.adn.m5787a(byte[], int, int):void");
    }

    /* renamed from: b */
    public final void m5786b(C3243zk c3243zk) {
        this.f3438e.append(c3243zk.f9586a, c3243zk);
    }

    /* renamed from: c */
    public final void m5785c(C3244zl c3244zl) {
        this.f3437d.append(c3244zl.f9592d, c3244zl);
    }

    /* renamed from: d */
    public final void m5784d() {
        this.f3444k = false;
        this.f3448o = false;
        this.f3447n.m5792a();
    }

    /* renamed from: e */
    public final void m5783e(long j, int i, long j2) {
        this.f3442i = i;
        this.f3445l = j2;
        this.f3443j = j;
        if (!this.f3435b || i != 1) {
            if (!this.f3436c) {
                return;
            }
            if (i != 5 && i != 1 && i != 2) {
                return;
            }
        }
        adm admVar = this.f3446m;
        this.f3446m = this.f3447n;
        this.f3447n = admVar;
        admVar.m5792a();
        this.f3441h = 0;
        this.f3444k = true;
    }

    /* renamed from: f */
    public final boolean m5782f(long j, int i, boolean z, boolean z2) {
        boolean z3 = false;
        if (this.f3442i == 9 || (this.f3436c && adm.m5789d(this.f3447n, this.f3446m))) {
            if (z && this.f3448o) {
                long j2 = this.f3443j;
                int i2 = i + ((int) (j - j2));
                long j3 = this.f3450q;
                if (j3 != C3282C.TIME_UNSET) {
                    this.f3434a.mo441f(j3, this.f3451r ? 1 : 0, (int) (j2 - this.f3449p), i2, null);
                }
            }
            this.f3449p = this.f3443j;
            this.f3450q = this.f3445l;
            this.f3451r = false;
            this.f3448o = true;
        }
        boolean m5788e = this.f3435b ? this.f3447n.m5788e() : z2;
        boolean z4 = this.f3451r;
        int i3 = this.f3442i;
        if (i3 == 5 || (m5788e && i3 == 1)) {
            z3 = true;
        }
        boolean z5 = z4 | z3;
        this.f3451r = z5;
        return z5;
    }

    /* renamed from: g */
    public final boolean m5781g() {
        return this.f3436c;
    }
}

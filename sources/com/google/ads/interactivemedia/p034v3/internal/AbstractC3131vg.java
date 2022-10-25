package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vg */
/* loaded from: classes2.dex */
public abstract class AbstractC3131vg implements InterfaceC3142vr {

    /* renamed from: a */
    protected final C2587bc f9166a;

    /* renamed from: b */
    protected final int f9167b;

    /* renamed from: c */
    protected final int[] f9168c;

    /* renamed from: d */
    private final C2962p[] f9169d;

    /* renamed from: e */
    private final long[] f9170e;

    /* renamed from: f */
    private int f9171f;

    public AbstractC3131vg(C2587bc c2587bc, int[] iArr) {
        int length = iArr.length;
        int i = 0;
        C2616ce.m2685h(length > 0);
        C2616ce.m2689d(c2587bc);
        this.f9166a = c2587bc;
        this.f9167b = length;
        this.f9169d = new C2962p[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f9169d[i2] = c2587bc.m4193b(iArr[i2]);
        }
        Arrays.sort(this.f9169d, C3132vh.f9173b);
        this.f9168c = new int[this.f9167b];
        while (true) {
            int i3 = this.f9167b;
            if (i >= i3) {
                this.f9170e = new long[i3];
                return;
            } else {
                this.f9168c[i] = c2587bc.m4194a(this.f9169d[i]);
                i++;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2589be
    /* renamed from: a */
    public final int mo839a(int i) {
        return this.f9168c[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2589be
    /* renamed from: b */
    public final int mo838b(int i) {
        for (int i2 = 0; i2 < this.f9167b; i2++) {
            if (this.f9168c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2589be
    /* renamed from: c */
    public final int mo837c(C2962p c2962p) {
        for (int i = 0; i < this.f9167b; i++) {
            if (this.f9169d[i] == c2962p) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2589be
    /* renamed from: d */
    public final int mo836d() {
        return this.f9168c.length;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2589be
    /* renamed from: e */
    public final C2962p mo835e(int i) {
        return this.f9169d[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AbstractC3131vg abstractC3131vg = (AbstractC3131vg) obj;
            if (this.f9166a == abstractC3131vg.f9166a && Arrays.equals(this.f9168c, abstractC3131vg.f9168c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2589be
    /* renamed from: f */
    public final C2587bc mo834f() {
        return this.f9166a;
    }

    public final int hashCode() {
        int i = this.f9171f;
        if (i == 0) {
            int identityHashCode = (System.identityHashCode(this.f9166a) * 31) + Arrays.hashCode(this.f9168c);
            this.f9171f = identityHashCode;
            return identityHashCode;
        }
        return i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: k */
    public int mo806k(long j, List list) {
        return list.size();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: m */
    public void mo805m() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: n */
    public void mo804n() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: o */
    public void mo803o(float f) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: p */
    public final int mo802p() {
        return this.f9168c[mo797g()];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: q */
    public final C2962p mo801q() {
        return this.f9169d[mo797g()];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: r */
    public final boolean mo800r(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean mo799s = mo799s(i, elapsedRealtime);
        int i2 = 0;
        while (true) {
            if (i2 < this.f9167b) {
                if (mo799s) {
                    break;
                }
                mo799s = (i2 == i || mo799s(i2, elapsedRealtime)) ? false : true;
                i2++;
            } else if (!mo799s) {
                return false;
            }
        }
        long[] jArr = this.f9170e;
        jArr[i] = Math.max(jArr[i], C2628cq.m2544al(elapsedRealtime, j));
        return true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: s */
    public final boolean mo799s(int i, long j) {
        return this.f9170e[i] > j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: t */
    public final /* synthetic */ void mo798t() {
    }
}

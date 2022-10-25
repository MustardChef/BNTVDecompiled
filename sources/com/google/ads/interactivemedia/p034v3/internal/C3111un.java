package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;
import com.google.android.exoplayer2.C3282C;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.un */
/* loaded from: classes2.dex */
public final class C3111un implements InterfaceC3233za, InterfaceC3113up {

    /* renamed from: a */
    public static final C3109ul f9084a = C3109ul.f9076a;

    /* renamed from: c */
    private static final C3247zo f9085c = new C3247zo();

    /* renamed from: d */
    private final InterfaceC3229yx f9086d;

    /* renamed from: e */
    private final int f9087e;

    /* renamed from: f */
    private final C2962p f9088f;

    /* renamed from: g */
    private final SparseArray f9089g = new SparseArray();

    /* renamed from: h */
    private boolean f9090h;

    /* renamed from: i */
    private long f9091i;

    /* renamed from: j */
    private InterfaceC3250zr f9092j;

    /* renamed from: k */
    private C2962p[] f9093k;

    /* renamed from: l */
    private C3108uk f9094l;

    public C3111un(InterfaceC3229yx interfaceC3229yx, int i, C2962p c2962p) {
        this.f9086d = interfaceC3229yx;
        this.f9087e = i;
        this.f9088f = c2962p;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3113up
    /* renamed from: a */
    public final C3221yp mo899a() {
        InterfaceC3250zr interfaceC3250zr = this.f9092j;
        if (interfaceC3250zr instanceof C3221yp) {
            return (C3221yp) interfaceC3250zr;
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3113up
    /* renamed from: b */
    public final void mo898b() {
        this.f9086d.mo430c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: be */
    public final InterfaceC3253zu mo489be(int i, int i2) {
        C3110um c3110um = (C3110um) this.f9089g.get(i);
        if (c3110um == null) {
            C2616ce.m2685h(this.f9093k == null);
            c3110um = new C3110um(i, i2, i2 == this.f9087e ? this.f9088f : null);
            c3110um.m903c(this.f9094l, this.f9091i);
            this.f9089g.put(i, c3110um);
        }
        return c3110um;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3113up
    /* renamed from: c */
    public final boolean mo897c(InterfaceC3230yy interfaceC3230yy) throws IOException {
        int mo432a = this.f9086d.mo432a(interfaceC3230yy, f9085c);
        C2616ce.m2685h(mo432a != 1);
        return mo432a == 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3113up
    /* renamed from: d */
    public final C2962p[] mo896d() {
        return this.f9093k;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3113up
    /* renamed from: e */
    public final void mo895e(C3108uk c3108uk, long j, long j2) {
        this.f9094l = c3108uk;
        this.f9091i = j2;
        if (!this.f9090h) {
            this.f9086d.mo431b(this);
            if (j != C3282C.TIME_UNSET) {
                this.f9086d.mo429d(0L, j);
            }
            this.f9090h = true;
            return;
        }
        InterfaceC3229yx interfaceC3229yx = this.f9086d;
        if (j == C3282C.TIME_UNSET) {
            j = 0;
        }
        interfaceC3229yx.mo429d(0L, j);
        for (int i = 0; i < this.f9089g.size(); i++) {
            ((C3110um) this.f9089g.valueAt(i)).m903c(c3108uk, j2);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: m */
    public final void mo488m() {
        C2962p[] c2962pArr = new C2962p[this.f9089g.size()];
        for (int i = 0; i < this.f9089g.size(); i++) {
            C2962p c2962p = ((C3110um) this.f9089g.valueAt(i)).f9077a;
            C2616ce.m2688e(c2962p);
            c2962pArr[i] = c2962p;
        }
        this.f9093k = c2962pArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3233za
    /* renamed from: w */
    public final void mo487w(InterfaceC3250zr interfaceC3250zr) {
        this.f9092j = interfaceC3250zr;
    }
}

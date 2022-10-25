package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.extractor.p035ts.TsExtractor;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aef */
/* loaded from: classes2.dex */
public final class aef implements InterfaceC3229yx {

    /* renamed from: a */
    private final int f3586a;

    /* renamed from: b */
    private final int f3587b;

    /* renamed from: c */
    private final List f3588c;

    /* renamed from: d */
    private final C2621cj f3589d;

    /* renamed from: e */
    private final SparseIntArray f3590e;

    /* renamed from: f */
    private final aei f3591f;

    /* renamed from: g */
    private final SparseArray f3592g;

    /* renamed from: h */
    private final SparseBooleanArray f3593h;

    /* renamed from: i */
    private final SparseBooleanArray f3594i;

    /* renamed from: j */
    private final aec f3595j;

    /* renamed from: k */
    private aeb f3596k;

    /* renamed from: l */
    private InterfaceC3233za f3597l;

    /* renamed from: m */
    private int f3598m;

    /* renamed from: n */
    private boolean f3599n;

    /* renamed from: o */
    private boolean f3600o;

    /* renamed from: p */
    private boolean f3601p;

    /* renamed from: q */
    private aek f3602q;

    /* renamed from: r */
    private int f3603r;

    /* renamed from: s */
    private int f3604s;

    static {
        acy acyVar = acy.f3296a;
    }

    public aef() {
        this(1, TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        r2 = r2 + 1;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo433D(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r7) throws java.io.IOException {
        /*
            r6 = this;
            com.google.ads.interactivemedia.v3.internal.cj r0 = r6.f3589d
            byte[] r0 = r0.m2642H()
            r1 = 0
            r2 = 940(0x3ac, float:1.317E-42)
            r7.mo496f(r0, r1, r2)
            r2 = 0
        Ld:
            r3 = 188(0xbc, float:2.63E-43)
            if (r2 >= r3) goto L29
            r3 = 0
        L12:
            r4 = 5
            if (r3 >= r4) goto L24
            int r4 = r3 * 188
            int r4 = r4 + r2
            r4 = r0[r4]
            r5 = 71
            if (r4 == r5) goto L21
            int r2 = r2 + 1
            goto Ld
        L21:
            int r3 = r3 + 1
            goto L12
        L24:
            r7.mo493i(r2)
            r7 = 1
            return r7
        L29:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aef.mo433D(com.google.ads.interactivemedia.v3.internal.yy):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        int i;
        ?? r15;
        boolean z;
        long mo500b = interfaceC3230yy.mo500b();
        if (this.f3599n) {
            if (mo500b != -1 && this.f3586a != 2) {
                aec aecVar = this.f3595j;
                if (!aecVar.m5753d()) {
                    return aecVar.m5756a(interfaceC3230yy, c3247zo, this.f3604s);
                }
            }
            if (this.f3600o) {
                i = 2;
                z = false;
            } else {
                this.f3600o = true;
                aec aecVar2 = this.f3595j;
                if (aecVar2.m5755b() != C3282C.TIME_UNSET) {
                    z = false;
                    i = 2;
                    aeb aebVar = new aeb(aecVar2.m5754c(), aecVar2.m5755b(), mo500b, this.f3604s, TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
                    this.f3596k = aebVar;
                    this.f3597l.mo487w(aebVar.m519b());
                } else {
                    i = 2;
                    z = false;
                    this.f3597l.mo487w(new C3249zq(aecVar2.m5755b()));
                }
            }
            if (this.f3601p) {
                this.f3601p = z;
                mo429d(0L, 0L);
                if (interfaceC3230yy.mo498d() != 0) {
                    c3247zo.f9610a = 0L;
                    return 1;
                }
            }
            aeb aebVar2 = this.f3596k;
            r15 = z;
            if (aebVar2 != null) {
                r15 = z;
                if (aebVar2.m517d()) {
                    return this.f3596k.m520a(interfaceC3230yy, c3247zo);
                }
            }
        } else {
            i = 2;
            r15 = 0;
        }
        C2621cj c2621cj = this.f3589d;
        byte[] m2642H = c2621cj.m2642H();
        if (9400 - c2621cj.m2639c() < 188) {
            int m2641a = c2621cj.m2641a();
            if (m2641a > 0) {
                System.arraycopy(m2642H, c2621cj.m2639c(), m2642H, r15, m2641a);
            }
            this.f3589d.m2646D(m2642H, m2641a);
        }
        while (true) {
            C2621cj c2621cj2 = this.f3589d;
            if (c2621cj2.m2641a() >= 188) {
                int m2639c = c2621cj2.m2639c();
                int m2638d = c2621cj2.m2638d();
                int m5708f = aev.m5708f(c2621cj2.m2642H(), m2639c, m2638d);
                this.f3589d.m2644F(m5708f);
                int i2 = m5708f + 188;
                if (i2 > m2638d) {
                    int i3 = this.f3603r + (m5708f - m2639c);
                    this.f3603r = i3;
                    if (this.f3586a == i && i3 > 376) {
                        throw C2555ao.m4866a("Cannot find sync byte. Most likely not a Transport Stream.", null);
                    }
                } else {
                    this.f3603r = r15;
                }
                C2621cj c2621cj3 = this.f3589d;
                int m2638d2 = c2621cj3.m2638d();
                if (i2 > m2638d2) {
                    return r15;
                }
                int m2637e = c2621cj3.m2637e();
                if ((8388608 & m2637e) != 0) {
                    this.f3589d.m2644F(i2);
                    return r15;
                }
                int i4 = (4194304 & m2637e) != 0 ? 1 : 0;
                int i5 = (m2637e >> 8) & 8191;
                int i6 = m2637e & 32;
                aek aekVar = (m2637e & 16) != 0 ? (aek) this.f3592g.get(i5) : null;
                if (aekVar == null) {
                    this.f3589d.m2644F(i2);
                    return r15;
                }
                if (this.f3586a != i) {
                    int i7 = m2637e & 15;
                    int i8 = this.f3590e.get(i5, i7 - 1);
                    this.f3590e.put(i5, i7);
                    if (i8 == i7) {
                        this.f3589d.m2644F(i2);
                        return r15;
                    } else if (i7 != ((i8 + 1) & 15)) {
                        aekVar.mo5725c();
                    }
                }
                if (i6 != 0) {
                    int m2633i = this.f3589d.m2633i();
                    i4 |= (this.f3589d.m2633i() & 64) != 0 ? 2 : 0;
                    this.f3589d.m2643G(m2633i - 1);
                }
                boolean z2 = this.f3599n;
                if (this.f3586a == i || z2 || !this.f3594i.get(i5, r15)) {
                    this.f3589d.m2645E(i2);
                    aekVar.mo5727a(this.f3589d, i4);
                    this.f3589d.m2645E(m2638d2);
                }
                if (this.f3586a != i && !z2 && this.f3599n && mo500b != -1) {
                    this.f3601p = true;
                }
                this.f3589d.m2644F(i2);
                return r15;
            }
            int m2638d3 = c2621cj2.m2638d();
            int mo501a = interfaceC3230yy.mo501a(m2642H, m2638d3, 9400 - m2638d3);
            if (mo501a == -1) {
                return -1;
            }
            this.f3589d.m2645E(m2638d3 + mo501a);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f3597l = interfaceC3233za;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        aeb aebVar;
        C2616ce.m2685h(this.f3586a != 2);
        int size = this.f3588c.size();
        for (int i = 0; i < size; i++) {
            C2626co c2626co = (C2626co) this.f3588c.get(i);
            if (c2626co.m2587e() != C3282C.TIME_UNSET) {
                long m2589c = c2626co.m2589c();
                if (m2589c != C3282C.TIME_UNSET) {
                    if (m2589c != 0) {
                        if (m2589c == j2) {
                        }
                    }
                }
            }
            c2626co.m2584h(j2);
        }
        if (j2 != 0 && (aebVar = this.f3596k) != null) {
            aebVar.m518c(j2);
        }
        this.f3589d.m2648B(0);
        this.f3590e.clear();
        for (int i2 = 0; i2 < this.f3592g.size(); i2++) {
            ((aek) this.f3592g.valueAt(i2)).mo5725c();
        }
        this.f3603r = 0;
    }

    public aef(int i, int i2) {
        this(1, new C2626co(0L), new add(null), TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public aef(int i, C2626co c2626co, aei aeiVar, int i2) {
        this.f3591f = aeiVar;
        this.f3587b = TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;
        this.f3586a = i;
        this.f3588c = Collections.singletonList(c2626co);
        this.f3589d = new C2621cj(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.f3593h = sparseBooleanArray;
        this.f3594i = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.f3592g = sparseArray;
        this.f3590e = new SparseIntArray();
        this.f3595j = new aec(TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
        this.f3597l = InterfaceC3233za.f9550b;
        this.f3604s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray mo5733a = aeiVar.mo5733a();
        int size = mo5733a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f3592g.put(mo5733a.keyAt(i3), (aek) mo5733a.valueAt(i3));
        }
        this.f3592g.put(0, new ady(new aed(this)));
        this.f3602q = null;
    }
}

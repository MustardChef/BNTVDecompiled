package com.google.ads.interactivemedia.p034v3.internal;

import android.os.SystemClock;
import com.google.android.exoplayer2.C3282C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vf */
/* loaded from: classes2.dex */
public final class C3130vf extends AbstractC3131vg {

    /* renamed from: d */
    private final InterfaceC3153wb f9155d;

    /* renamed from: e */
    private final long f9156e;

    /* renamed from: f */
    private final long f9157f;

    /* renamed from: g */
    private final long f9158g;

    /* renamed from: h */
    private final avg f9159h;

    /* renamed from: i */
    private final InterfaceC2598bn f9160i;

    /* renamed from: j */
    private float f9161j;

    /* renamed from: k */
    private int f9162k;

    /* renamed from: l */
    private int f9163l;

    /* renamed from: m */
    private long f9164m;

    /* renamed from: n */
    private AbstractC3122uy f9165n;

    public C3130vf(C2587bc c2587bc, int[] iArr, InterfaceC3153wb interfaceC3153wb, List list, InterfaceC2598bn interfaceC2598bn) {
        super(c2587bc, iArr);
        this.f9155d = interfaceC3153wb;
        this.f9156e = 10000000L;
        this.f9157f = 25000000L;
        this.f9158g = 25000000L;
        this.f9159h = avg.m4517l(list);
        this.f9160i = interfaceC2598bn;
        this.f9161j = 1.0f;
        this.f9163l = 0;
        this.f9164m = C3282C.TIME_UNSET;
    }

    /* renamed from: l */
    public static /* bridge */ /* synthetic */ avg m843l(C3141vq[] c3141vqArr) {
        int length;
        int i;
        int[] iArr;
        int[] iArr2;
        ArrayList arrayList = new ArrayList();
        char c = 0;
        int i2 = 0;
        while (true) {
            length = c3141vqArr.length;
            i = 1;
            if (i2 >= length) {
                break;
            }
            C3141vq c3141vq = c3141vqArr[i2];
            if (c3141vq == null || c3141vq.f9236b.length <= 1) {
                arrayList.add(null);
            } else {
                avm m4509t = avg.m4509t();
                m4509t.m4498f(new C3128vd(0L, 0L));
                arrayList.add(m4509t);
            }
            i2++;
        }
        long[][] jArr = new long[length];
        for (int i3 = 0; i3 < c3141vqArr.length; i3++) {
            C3141vq c3141vq2 = c3141vqArr[i3];
            if (c3141vq2 == null) {
                jArr[i3] = new long[0];
            } else {
                jArr[i3] = new long[c3141vq2.f9236b.length];
                int i4 = 0;
                while (true) {
                    if (i4 >= c3141vq2.f9236b.length) {
                        break;
                    }
                    jArr[i3][i4] = c3141vq2.f9235a.m4193b(iArr2[i4]).f8368h;
                    i4++;
                }
                Arrays.sort(jArr[i3]);
            }
        }
        int[] iArr3 = new int[length];
        long[] jArr2 = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            long[] jArr3 = jArr[i5];
            jArr2[i5] = jArr3.length == 0 ? 0L : jArr3[0];
        }
        m842u(arrayList, jArr2);
        awa m4456b = awl.m4457a().m4458b().m4456b();
        int i6 = 0;
        while (i6 < length) {
            int length2 = jArr[i6].length;
            if (length2 <= i) {
                iArr = iArr3;
            } else {
                double[] dArr = new double[length2];
                int i7 = 0;
                while (true) {
                    long[] jArr4 = jArr[i6];
                    double d = 0.0d;
                    if (i7 >= jArr4.length) {
                        break;
                    }
                    int[] iArr4 = iArr3;
                    long j = jArr4[i7];
                    if (j != -1) {
                        d = Math.log(j);
                    }
                    dArr[i7] = d;
                    i7++;
                    iArr3 = iArr4;
                }
                iArr = iArr3;
                int i8 = length2 - 1;
                double d2 = dArr[i8] - dArr[c];
                int i9 = 0;
                while (i9 < i8) {
                    int i10 = i9 + 1;
                    m4456b.mo4462u(Double.valueOf(d2 == 0.0d ? 1.0d : (((dArr[i9] + dArr[i10]) * 0.5d) - dArr[c]) / d2), Integer.valueOf(i6));
                    i9 = i10;
                    c = 0;
                }
            }
            i6++;
            iArr3 = iArr;
            c = 0;
            i = 1;
        }
        int[] iArr5 = iArr3;
        avg m4517l = avg.m4517l(m4456b.mo4461v());
        for (int i11 = 0; i11 < m4517l.size(); i11++) {
            int intValue = ((Integer) m4517l.get(i11)).intValue();
            int i12 = iArr5[intValue] + 1;
            iArr5[intValue] = i12;
            jArr2[intValue] = jArr[intValue][i12];
            m842u(arrayList, jArr2);
        }
        for (int i13 = 0; i13 < c3141vqArr.length; i13++) {
            if (arrayList.get(i13) != null) {
                long j2 = jArr2[i13];
                jArr2[i13] = j2 + j2;
            }
        }
        m842u(arrayList, jArr2);
        avm m4509t2 = avg.m4509t();
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            avm avmVar = (avm) arrayList.get(i14);
            m4509t2.m4498f(avmVar == null ? avg.m4515n() : avmVar.m4499e());
        }
        return m4509t2.m4499e();
    }

    /* renamed from: u */
    private static void m842u(List list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            avm avmVar = (avm) list.get(i);
            if (avmVar != null) {
                avmVar.m4498f(new C3128vd(j, jArr[i]));
            }
        }
    }

    /* renamed from: v */
    private final int m841v(long j) {
        long j2;
        long mo756e = (((float) this.f9155d.mo756e()) * 0.7f) / this.f9161j;
        if (!this.f9159h.isEmpty()) {
            int i = 1;
            while (i < this.f9159h.size() - 1 && ((C3128vd) this.f9159h.get(i)).f9152a < mo756e) {
                i++;
            }
            C3128vd c3128vd = (C3128vd) this.f9159h.get(i - 1);
            C3128vd c3128vd2 = (C3128vd) this.f9159h.get(i);
            long j3 = c3128vd.f9152a;
            long j4 = c3128vd2.f9152a;
            mo756e = ((((float) (mo756e - j3)) / ((float) (j4 - j3))) * ((float) (c3128vd2.f9153b - j2))) + c3128vd.f9153b;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f9167b; i3++) {
            if (j == Long.MIN_VALUE || !mo799s(i3, j)) {
                if (mo835e(i3).f8368h <= mo756e) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    /* renamed from: w */
    private static final long m840w(List list) {
        if (list.isEmpty()) {
            return C3282C.TIME_UNSET;
        }
        AbstractC3122uy abstractC3122uy = (AbstractC3122uy) axd.m4386z(list);
        long j = abstractC3122uy.f9101l;
        if (j != C3282C.TIME_UNSET) {
            long j2 = abstractC3122uy.f9102m;
            if (j2 != C3282C.TIME_UNSET) {
                return j2 - j;
            }
        }
        return C3282C.TIME_UNSET;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: g */
    public final int mo797g() {
        return this.f9162k;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: h */
    public final int mo796h() {
        return this.f9163l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: i */
    public final void mo795i() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0094, code lost:
        if (r9 < r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x009e, code lost:
        if (r9 >= 25000000) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00a0, code lost:
        r13 = r2;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo794j(long r9, long r11, java.util.List r13, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3125va[] r14) {
        /*
            r8 = this;
            long r0 = android.os.SystemClock.elapsedRealtime()
            int r2 = r8.f9162k
            int r3 = r14.length
            r4 = 0
            if (r2 >= r3) goto L1d
            r2 = r14[r2]
            boolean r2 = r2.mo850e()
            if (r2 == 0) goto L1d
            int r2 = r8.f9162k
            r14 = r14[r2]
            r14.mo852a()
            r14.mo851b()
            goto L34
        L1d:
            if (r4 >= r3) goto L31
            r2 = r14[r4]
            boolean r5 = r2.mo850e()
            if (r5 == 0) goto L2e
            r2.mo852a()
            r2.mo851b()
            goto L34
        L2e:
            int r4 = r4 + 1
            goto L1d
        L31:
            m840w(r13)
        L34:
            int r14 = r8.f9163l
            if (r14 != 0) goto L42
            r9 = 1
            r8.f9163l = r9
            int r9 = r8.m841v(r0)
            r8.f9162k = r9
            return
        L42:
            int r2 = r8.f9162k
            boolean r3 = r13.isEmpty()
            r4 = -1
            if (r3 == 0) goto L4d
            r3 = -1
            goto L59
        L4d:
            java.lang.Object r3 = com.google.ads.interactivemedia.p034v3.internal.axd.m4386z(r13)
            com.google.ads.interactivemedia.v3.internal.uy r3 = (com.google.ads.interactivemedia.p034v3.internal.AbstractC3122uy) r3
            com.google.ads.interactivemedia.v3.internal.p r3 = r3.f9098i
            int r3 = r8.mo837c(r3)
        L59:
            if (r3 == r4) goto L64
            java.lang.Object r13 = com.google.ads.interactivemedia.p034v3.internal.axd.m4386z(r13)
            com.google.ads.interactivemedia.v3.internal.uy r13 = (com.google.ads.interactivemedia.p034v3.internal.AbstractC3122uy) r13
            int r14 = r13.f9099j
            r2 = r3
        L64:
            int r13 = r8.m841v(r0)
            boolean r0 = r8.mo799s(r2, r0)
            if (r0 != 0) goto La1
            com.google.ads.interactivemedia.v3.internal.p r0 = r8.mo835e(r2)
            com.google.ads.interactivemedia.v3.internal.p r1 = r8.mo835e(r13)
            int r1 = r1.f8368h
            int r0 = r0.f8368h
            if (r1 <= r0) goto L97
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 10000000(0x989680, double:4.9406565E-317)
            int r7 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r7 == 0) goto L92
            int r3 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r3 > 0) goto L92
            float r11 = (float) r11
            r12 = 1061158912(0x3f400000, float:0.75)
            float r11 = r11 * r12
            long r5 = (long) r11
        L92:
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 >= 0) goto L97
            goto La0
        L97:
            if (r1 >= r0) goto La1
            r11 = 25000000(0x17d7840, double:1.2351641E-316)
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 < 0) goto La1
        La0:
            r13 = r2
        La1:
            if (r13 != r2) goto La4
            goto La5
        La4:
            r14 = 3
        La5:
            r8.f9163l = r14
            r8.f9162k = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3130vf.mo794j(long, long, java.util.List, com.google.ads.interactivemedia.v3.internal.va[]):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3131vg, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: k */
    public final int mo806k(long j, List list) {
        int i;
        int i2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f9164m;
        if (j2 == C3282C.TIME_UNSET || elapsedRealtime - j2 >= 1000 || (!list.isEmpty() && !((AbstractC3122uy) axd.m4386z(list)).equals(this.f9165n))) {
            this.f9164m = elapsedRealtime;
            this.f9165n = list.isEmpty() ? null : (AbstractC3122uy) axd.m4386z(list);
            if (list.isEmpty()) {
                return 0;
            }
            int size = list.size();
            if (C2628cq.m2516r(((AbstractC3122uy) list.get(size - 1)).f9101l - j, this.f9161j) < 25000000) {
                return size;
            }
            m840w(list);
            C2962p mo835e = mo835e(m841v(elapsedRealtime));
            for (int i3 = 0; i3 < size; i3++) {
                AbstractC3122uy abstractC3122uy = (AbstractC3122uy) list.get(i3);
                C2962p c2962p = abstractC3122uy.f9098i;
                if (C2628cq.m2516r(abstractC3122uy.f9101l - j, this.f9161j) >= 25000000 && c2962p.f8368h < mo835e.f8368h && (i = c2962p.f8378r) != -1 && i <= 719 && (i2 = c2962p.f8377q) != -1 && i2 <= 1279 && i < mo835e.f8378r) {
                    return i3;
                }
            }
            return size;
        }
        return list.size();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3131vg, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: m */
    public final void mo805m() {
        this.f9165n = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3131vg, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: n */
    public final void mo804n() {
        this.f9164m = C3282C.TIME_UNSET;
        this.f9165n = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3131vg, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3142vr
    /* renamed from: o */
    public final void mo803o(float f) {
        this.f9161j = f;
    }
}

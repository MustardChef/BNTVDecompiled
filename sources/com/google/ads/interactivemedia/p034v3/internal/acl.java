package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Pair;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acl */
/* loaded from: classes2.dex */
public final class acl implements InterfaceC3229yx, InterfaceC3250zr {

    /* renamed from: a */
    public static final /* synthetic */ int f3204a = 0;

    /* renamed from: b */
    private final C2621cj f3205b;

    /* renamed from: c */
    private final C2621cj f3206c;

    /* renamed from: d */
    private final C2621cj f3207d;

    /* renamed from: e */
    private final C2621cj f3208e;

    /* renamed from: f */
    private final ArrayDeque f3209f;

    /* renamed from: g */
    private final List f3210g;

    /* renamed from: h */
    private int f3211h;

    /* renamed from: i */
    private int f3212i;

    /* renamed from: j */
    private long f3213j;

    /* renamed from: k */
    private int f3214k;

    /* renamed from: l */
    private C2621cj f3215l;

    /* renamed from: m */
    private int f3216m;

    /* renamed from: n */
    private int f3217n;

    /* renamed from: o */
    private int f3218o;

    /* renamed from: p */
    private int f3219p;

    /* renamed from: q */
    private InterfaceC3233za f3220q;

    /* renamed from: r */
    private ack[] f3221r;

    /* renamed from: s */
    private long[][] f3222s;

    /* renamed from: t */
    private int f3223t;

    /* renamed from: u */
    private long f3224u;

    /* renamed from: v */
    private int f3225v;

    static {
        aci aciVar = aci.f3195a;
    }

    public acl() {
        this(null);
    }

    /* renamed from: f */
    private static int m5844f(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    /* renamed from: i */
    private static int m5843i(acs acsVar, long j) {
        int m5822a = acsVar.m5822a(j);
        return m5822a == -1 ? acsVar.m5821b(j) : m5822a;
    }

    /* renamed from: j */
    private static long m5842j(acs acsVar, long j, long j2) {
        int m5843i = m5843i(acsVar, j);
        return m5843i == -1 ? j2 : Math.min(acsVar.f3265c[m5843i], j2);
    }

    /* renamed from: k */
    private final void m5841k() {
        this.f3211h = 0;
        this.f3214k = 0;
    }

    /* renamed from: l */
    private final void m5840l(long j) throws C2555ao {
        C2549ak c2549ak;
        C2549ak c2549ak2;
        long j2;
        List list;
        int i;
        int i2;
        C3237ze c3237ze;
        int i3;
        while (!this.f3209f.isEmpty() && ((abr) this.f3209f.peek()).f3103a == j) {
            abr abrVar = (abr) this.f3209f.pop();
            if (abrVar.f3107d == 1836019574) {
                ArrayList arrayList = new ArrayList();
                boolean z = this.f3225v == 1;
                C3237ze c3237ze2 = new C3237ze();
                abs m5892b = abrVar.m5892b(Atom.TYPE_udta);
                if (m5892b != null) {
                    Pair m5879a = aca.m5879a(m5892b);
                    C2549ak c2549ak3 = (C2549ak) m5879a.first;
                    C2549ak c2549ak4 = (C2549ak) m5879a.second;
                    if (c2549ak3 != null) {
                        c3237ze2.m484b(c2549ak3);
                    }
                    c2549ak = c2549ak4;
                    c2549ak2 = c2549ak3;
                } else {
                    c2549ak = null;
                    c2549ak2 = null;
                }
                abr m5893a = abrVar.m5893a(Atom.TYPE_meta);
                C2549ak m5878b = m5893a != null ? aca.m5878b(m5893a) : null;
                List m5876d = aca.m5876d(abrVar, c3237ze2, C3282C.TIME_UNSET, null, z, acj.f3198a);
                InterfaceC3233za interfaceC3233za = this.f3220q;
                C2616ce.m2689d(interfaceC3233za);
                int size = m5876d.size();
                int i4 = -1;
                int i5 = 0;
                long j3 = C3282C.TIME_UNSET;
                while (true) {
                    j2 = 0;
                    if (i5 >= size) {
                        break;
                    }
                    acs acsVar = (acs) m5876d.get(i5);
                    if (acsVar.f3264b == 0) {
                        list = m5876d;
                        i = size;
                        c3237ze = c3237ze2;
                    } else {
                        acp acpVar = acsVar.f3263a;
                        int i6 = i4;
                        long j4 = acpVar.f3234e;
                        if (j4 == C3282C.TIME_UNSET) {
                            j4 = acsVar.f3270h;
                        }
                        long max = Math.max(j3, j4);
                        list = m5876d;
                        i = size;
                        ack ackVar = new ack(acpVar, acsVar, interfaceC3233za.mo489be(i5, acpVar.f3231b));
                        if (MimeTypes.AUDIO_TRUEHD.equals(acpVar.f3235f.f8372l)) {
                            i2 = acsVar.f3267e * 16;
                        } else {
                            i2 = acsVar.f3267e + 30;
                        }
                        C2935o m1426b = acpVar.f3235f.m1426b();
                        m1426b.m1541W(i2);
                        if (acpVar.f3231b == 2 && j4 > 0 && (i3 = acsVar.f3264b) > 1) {
                            m1426b.m1548P(i3 / (((float) j4) / 1000000.0f));
                        }
                        int i7 = acpVar.f3231b;
                        int i8 = ach.f3194b;
                        if (i7 == 1 && c3237ze2.m485a()) {
                            m1426b.m1550N(c3237ze2.f9556a);
                            m1426b.m1549O(c3237ze2.f9557b);
                        }
                        int i9 = acpVar.f3231b;
                        C2549ak[] c2549akArr = new C2549ak[2];
                        c2549akArr[0] = c2549ak;
                        c2549akArr[1] = this.f3210g.isEmpty() ? null : new C2549ak(this.f3210g);
                        c3237ze = c3237ze2;
                        C2549ak c2549ak5 = new C2549ak(new InterfaceC2548aj[0]);
                        if (i9 == 1) {
                            if (c2549ak2 != null) {
                                c2549ak5 = c2549ak2;
                            }
                        } else if (i9 == 2 && m5878b != null) {
                            int i10 = 0;
                            while (true) {
                                if (i10 >= m5878b.m5127a()) {
                                    break;
                                }
                                InterfaceC2548aj m5126b = m5878b.m5126b(i10);
                                if (m5126b instanceof aaw) {
                                    aaw aawVar = (aaw) m5126b;
                                    if (MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS.equals(aawVar.f2932a)) {
                                        c2549ak5 = new C2549ak(aawVar);
                                        break;
                                    }
                                }
                                i10++;
                            }
                        }
                        for (int i11 = 0; i11 < 2; i11++) {
                            c2549ak5 = c2549ak5.m5124d(c2549akArr[i11]);
                        }
                        if (c2549ak5.m5127a() > 0) {
                            m1426b.m1540X(c2549ak5);
                        }
                        ackVar.f3201c.mo443b(m1426b.m1506v());
                        i4 = i6;
                        if (acpVar.f3231b == 2 && i4 == -1) {
                            i4 = arrayList.size();
                        }
                        arrayList.add(ackVar);
                        j3 = max;
                    }
                    i5++;
                    m5876d = list;
                    size = i;
                    c3237ze2 = c3237ze;
                }
                this.f3223t = i4;
                this.f3224u = j3;
                ack[] ackVarArr = (ack[]) arrayList.toArray(new ack[0]);
                this.f3221r = ackVarArr;
                int length = ackVarArr.length;
                long[][] jArr = new long[length];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i12 = 0; i12 < ackVarArr.length; i12++) {
                    jArr[i12] = new long[ackVarArr[i12].f3200b.f3264b];
                    jArr2[i12] = ackVarArr[i12].f3200b.f3268f[0];
                }
                int i13 = 0;
                while (i13 < ackVarArr.length) {
                    long j5 = Long.MAX_VALUE;
                    int i14 = -1;
                    for (int i15 = 0; i15 < ackVarArr.length; i15++) {
                        if (!zArr[i15]) {
                            long j6 = jArr2[i15];
                            if (j6 <= j5) {
                                i14 = i15;
                                j5 = j6;
                            }
                        }
                    }
                    int i16 = iArr[i14];
                    long[] jArr3 = jArr[i14];
                    jArr3[i16] = j2;
                    acs acsVar2 = ackVarArr[i14].f3200b;
                    j2 += acsVar2.f3266d[i16];
                    int i17 = i16 + 1;
                    iArr[i14] = i17;
                    if (i17 < jArr3.length) {
                        jArr2[i14] = acsVar2.f3268f[i17];
                    } else {
                        zArr[i14] = true;
                        i13++;
                    }
                }
                this.f3222s = jArr;
                interfaceC3233za.mo488m();
                interfaceC3233za.mo487w(this);
                this.f3209f.clear();
                this.f3211h = 2;
            } else if (!this.f3209f.isEmpty()) {
                ((abr) this.f3209f.peek()).m5891c(abrVar);
            }
        }
        if (this.f3211h != 2) {
            m5841k();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    public final boolean mo433D(InterfaceC3230yy interfaceC3230yy) throws IOException {
        return aco.m5828b(interfaceC3230yy);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f3220q = interfaceC3233za;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        this.f3209f.clear();
        this.f3214k = 0;
        this.f3216m = -1;
        this.f3217n = 0;
        this.f3218o = 0;
        this.f3219p = 0;
        if (j == 0) {
            m5841k();
            return;
        }
        ack[] ackVarArr = this.f3221r;
        if (ackVarArr != null) {
            for (ack ackVar : ackVarArr) {
                acs acsVar = ackVar.f3200b;
                int m5822a = acsVar.m5822a(j2);
                if (m5822a == -1) {
                    m5822a = acsVar.m5821b(j2);
                }
                ackVar.f3203e = m5822a;
                C3254zv c3254zv = ackVar.f3202d;
                if (c3254zv != null) {
                    c3254zv.m437b();
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: e */
    public final long mo447e() {
        return this.f3224u;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: g */
    public final C3248zp mo446g(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        int m5821b;
        if (((ack[]) C2616ce.m2689d(this.f3221r)).length == 0) {
            C3251zs c3251zs = C3251zs.f9615a;
            return new C3248zp(c3251zs, c3251zs);
        }
        int i = this.f3223t;
        if (i != -1) {
            acs acsVar = this.f3221r[i].f3200b;
            int m5843i = m5843i(acsVar, j);
            if (m5843i == -1) {
                C3251zs c3251zs2 = C3251zs.f9615a;
                return new C3248zp(c3251zs2, c3251zs2);
            }
            long j6 = acsVar.f3268f[m5843i];
            j2 = acsVar.f3265c[m5843i];
            if (j6 >= j || m5843i >= acsVar.f3264b - 1 || (m5821b = acsVar.m5821b(j)) == -1 || m5821b == m5843i) {
                j5 = -1;
                j4 = -9223372036854775807L;
            } else {
                j4 = acsVar.f3268f[m5821b];
                j5 = acsVar.f3265c[m5821b];
            }
            j3 = j5;
            j = j6;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -1;
            j4 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            ack[] ackVarArr = this.f3221r;
            if (i2 >= ackVarArr.length) {
                break;
            }
            if (i2 != this.f3223t) {
                acs acsVar2 = ackVarArr[i2].f3200b;
                long m5842j = m5842j(acsVar2, j, j2);
                if (j4 != C3282C.TIME_UNSET) {
                    j3 = m5842j(acsVar2, j4, j3);
                }
                j2 = m5842j;
            }
            i2++;
        }
        C3251zs c3251zs3 = new C3251zs(j, j2);
        return j4 == C3282C.TIME_UNSET ? new C3248zp(c3251zs3, c3251zs3) : new C3248zp(c3251zs3, new C3251zs(j4, j3));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3250zr
    /* renamed from: h */
    public final boolean mo445h() {
        return true;
    }

    public acl(byte[] bArr) {
        this.f3211h = 0;
        new ArrayList();
        this.f3210g = new ArrayList();
        this.f3208e = new C2621cj(16);
        this.f3209f = new ArrayDeque();
        this.f3205b = new C2621cj(C3245zm.f9602a);
        this.f3206c = new C2621cj(4);
        this.f3207d = new C2621cj();
        this.f3216m = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:191:0x0368, code lost:
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:256:0x008d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo432a(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r34, com.google.ads.interactivemedia.p034v3.internal.C3247zo r35) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1011
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.acl.mo432a(com.google.ads.interactivemedia.v3.internal.yy, com.google.ads.interactivemedia.v3.internal.zo):int");
    }
}

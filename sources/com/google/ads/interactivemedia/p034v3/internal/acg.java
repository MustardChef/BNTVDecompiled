package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.acg */
/* loaded from: classes2.dex */
public final class acg implements InterfaceC3229yx {

    /* renamed from: a */
    private static final byte[] f3158a;

    /* renamed from: b */
    private static final C2962p f3159b;

    /* renamed from: A */
    private acf f3160A;

    /* renamed from: B */
    private int f3161B;

    /* renamed from: C */
    private int f3162C;

    /* renamed from: D */
    private int f3163D;

    /* renamed from: E */
    private boolean f3164E;

    /* renamed from: F */
    private InterfaceC3233za f3165F;

    /* renamed from: G */
    private InterfaceC3253zu[] f3166G;

    /* renamed from: H */
    private InterfaceC3253zu[] f3167H;

    /* renamed from: I */
    private boolean f3168I;

    /* renamed from: c */
    private final int f3169c;

    /* renamed from: d */
    private final List f3170d;

    /* renamed from: e */
    private final SparseArray f3171e;

    /* renamed from: f */
    private final C2621cj f3172f;

    /* renamed from: g */
    private final C2621cj f3173g;

    /* renamed from: h */
    private final C2621cj f3174h;

    /* renamed from: i */
    private final byte[] f3175i;

    /* renamed from: j */
    private final C2621cj f3176j;

    /* renamed from: k */
    private final C2626co f3177k;

    /* renamed from: l */
    private final aac f3178l;

    /* renamed from: m */
    private final C2621cj f3179m;

    /* renamed from: n */
    private final ArrayDeque f3180n;

    /* renamed from: o */
    private final ArrayDeque f3181o;

    /* renamed from: p */
    private final InterfaceC3253zu f3182p;

    /* renamed from: q */
    private int f3183q;

    /* renamed from: r */
    private int f3184r;

    /* renamed from: s */
    private long f3185s;

    /* renamed from: t */
    private int f3186t;

    /* renamed from: u */
    private C2621cj f3187u;

    /* renamed from: v */
    private long f3188v;

    /* renamed from: w */
    private int f3189w;

    /* renamed from: x */
    private long f3190x;

    /* renamed from: y */
    private long f3191y;

    /* renamed from: z */
    private long f3192z;

    static {
        aci aciVar = aci.f3195a;
        f3158a = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        C2935o c2935o = new C2935o();
        c2935o.m1532ae(MimeTypes.APPLICATION_EMSG);
        f3159b = c2935o.m1506v();
    }

    public acg() {
        this(null);
    }

    /* renamed from: f */
    private static C2854l m5855f(List list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            abs absVar = (abs) list.get(i);
            if (absVar.f3107d == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] m2642H = absVar.f3106a.m2642H();
                UUID m5835b = acn.m5835b(m2642H);
                if (m5835b == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new C2827k(m5835b, MimeTypes.VIDEO_MP4, m2642H));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new C2854l(arrayList);
    }

    /* renamed from: g */
    private final void m5854g() {
        this.f3183q = 0;
        this.f3186t = 0;
    }

    /* renamed from: h */
    private static void m5853h(C2621cj c2621cj, int i, acr acrVar) throws C2555ao {
        c2621cj.m2644F(i + 8);
        int m5889e = abt.m5889e(c2621cj.m2637e());
        if ((m5889e & 1) != 0) {
            throw C2555ao.m4863d("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (m5889e & 2) != 0;
        int m2630l = c2621cj.m2630l();
        if (m2630l == 0) {
            Arrays.fill(acrVar.f3257l, 0, acrVar.f3250e, false);
            return;
        }
        int i2 = acrVar.f3250e;
        if (m2630l != i2) {
            StringBuilder sb = new StringBuilder(80);
            sb.append("Senc sample count ");
            sb.append(m2630l);
            sb.append(" is different from fragment sample count");
            sb.append(i2);
            throw C2555ao.m4866a(sb.toString(), null);
        }
        Arrays.fill(acrVar.f3257l, 0, m2630l, z);
        acrVar.m5824b(c2621cj.m2641a());
        C2621cj c2621cj2 = acrVar.f3259n;
        c2621cj.m2649A(c2621cj2.m2642H(), 0, c2621cj2.m2638d());
        acrVar.f3259n.m2644F(0);
        acrVar.f3260o = false;
    }

    /* renamed from: i */
    private final void m5852i(long j) throws C2555ao {
        acg acgVar;
        SparseArray sparseArray;
        abr abrVar;
        int i;
        int i2;
        int i3;
        byte[] bArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte[] bArr2;
        byte[] bArr3;
        int i9;
        boolean z;
        int i10;
        abr abrVar2;
        int i11;
        acr acrVar;
        List list;
        byte[] bArr4;
        int i12;
        int i13;
        abr abrVar3;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        long j2;
        final acg acgVar2 = this;
        while (!acgVar2.f3180n.isEmpty() && ((abr) acgVar2.f3180n.peek()).f3103a == j) {
            abr abrVar4 = (abr) acgVar2.f3180n.pop();
            int i24 = abrVar4.f3107d;
            int i25 = 12;
            int i26 = 8;
            if (i24 == 1836019574) {
                C2616ce.m2684i(true, "Unexpected moov box.");
                C2854l m5855f = m5855f(abrVar4.f3104b);
                abr m5893a = abrVar4.m5893a(Atom.TYPE_mvex);
                C2616ce.m2689d(m5893a);
                SparseArray sparseArray2 = new SparseArray();
                int size = m5893a.f3104b.size();
                long j3 = C3282C.TIME_UNSET;
                int i27 = 0;
                while (i27 < size) {
                    abs absVar = (abs) m5893a.f3104b.get(i27);
                    int i28 = absVar.f3107d;
                    if (i28 == 1953654136) {
                        C2621cj c2621cj = absVar.f3106a;
                        c2621cj.m2644F(i25);
                        Pair create = Pair.create(Integer.valueOf(c2621cj.m2637e()), new acb(c2621cj.m2637e() - 1, c2621cj.m2637e(), c2621cj.m2637e(), c2621cj.m2637e()));
                        sparseArray2.put(((Integer) create.first).intValue(), (acb) create.second);
                    } else if (i28 == 1835362404) {
                        C2621cj c2621cj2 = absVar.f3106a;
                        c2621cj2.m2644F(8);
                        j3 = abt.m5888f(c2621cj2.m2637e()) == 0 ? c2621cj2.m2626p() : c2621cj2.m2625q();
                    }
                    i27++;
                    i25 = 12;
                }
                List m5876d = aca.m5876d(abrVar4, new C3237ze(), j3, m5855f, false, new ath() { // from class: com.google.ads.interactivemedia.v3.internal.acd
                    @Override // com.google.ads.interactivemedia.p034v3.internal.ath
                    /* renamed from: a */
                    public final Object mo4331a(Object obj) {
                        return (acp) obj;
                    }
                });
                int size2 = m5876d.size();
                if (acgVar2.f3171e.size() == 0) {
                    for (int i29 = 0; i29 < size2; i29++) {
                        acs acsVar = (acs) m5876d.get(i29);
                        acp acpVar = acsVar.f3263a;
                        acgVar2.f3171e.put(acpVar.f3230a, new acf(acgVar2.f3165F.mo489be(i29, acpVar.f3231b), acsVar, m5850k(sparseArray2, acpVar.f3230a)));
                        acgVar2.f3191y = Math.max(acgVar2.f3191y, acpVar.f3234e);
                    }
                    acgVar2.f3165F.mo488m();
                } else {
                    C2616ce.m2685h(acgVar2.f3171e.size() == size2);
                    for (int i30 = 0; i30 < size2; i30++) {
                        acs acsVar2 = (acs) m5876d.get(i30);
                        acp acpVar2 = acsVar2.f3263a;
                        ((acf) acgVar2.f3171e.get(acpVar2.f3230a)).m5860g(acsVar2, m5850k(sparseArray2, acpVar2.f3230a));
                    }
                }
            } else {
                if (i24 == 1836019558) {
                    SparseArray sparseArray3 = acgVar2.f3171e;
                    int i31 = acgVar2.f3169c;
                    byte[] bArr5 = acgVar2.f3175i;
                    int size3 = abrVar4.f3105c.size();
                    int i32 = 0;
                    while (i32 < size3) {
                        abr abrVar5 = (abr) abrVar4.f3105c.get(i32);
                        if (abrVar5.f3107d == 1953653094) {
                            abs m5892b = abrVar5.m5892b(Atom.TYPE_tfhd);
                            C2616ce.m2689d(m5892b);
                            C2621cj c2621cj3 = m5892b.f3106a;
                            c2621cj3.m2644F(i26);
                            int m5889e = abt.m5889e(c2621cj3.m2637e());
                            acf acfVar = (acf) sparseArray3.get(c2621cj3.m2637e());
                            if (acfVar == null) {
                                acfVar = null;
                            } else {
                                if ((m5889e & 1) != 0) {
                                    long m2625q = c2621cj3.m2625q();
                                    acr acrVar2 = acfVar.f3147b;
                                    acrVar2.f3247b = m2625q;
                                    acrVar2.f3248c = m2625q;
                                }
                                acb acbVar = acfVar.f3150e;
                                int m2637e = (m5889e & 2) != 0 ? c2621cj3.m2637e() - 1 : acbVar.f3133a;
                                if ((m5889e & 8) != 0) {
                                    i4 = c2621cj3.m2637e();
                                } else {
                                    i4 = acbVar.f3134b;
                                }
                                if ((m5889e & 16) != 0) {
                                    i5 = c2621cj3.m2637e();
                                } else {
                                    i5 = acbVar.f3135c;
                                }
                                if ((m5889e & 32) != 0) {
                                    i6 = c2621cj3.m2637e();
                                } else {
                                    i6 = acbVar.f3136d;
                                }
                                acfVar.f3147b.f3246a = new acb(m2637e, i4, i5, i6);
                            }
                            if (acfVar != null) {
                                acr acrVar3 = acfVar.f3147b;
                                long j4 = acrVar3.f3261p;
                                boolean z2 = acrVar3.f3262q;
                                acfVar.m5859h();
                                acf.m5856k(acfVar);
                                abs m5892b2 = abrVar5.m5892b(Atom.TYPE_tfdt);
                                if (m5892b2 == null || (i31 & 2) != 0) {
                                    i7 = size3;
                                    acrVar3.f3261p = j4;
                                    acrVar3.f3262q = z2;
                                } else {
                                    C2621cj c2621cj4 = m5892b2.f3106a;
                                    c2621cj4.m2644F(i26);
                                    i7 = size3;
                                    acrVar3.f3261p = abt.m5888f(c2621cj4.m2637e()) == 1 ? c2621cj4.m2625q() : c2621cj4.m2626p();
                                    acrVar3.f3262q = true;
                                }
                                List list2 = abrVar5.f3104b;
                                int size4 = list2.size();
                                int i33 = 0;
                                int i34 = 0;
                                int i35 = 0;
                                while (true) {
                                    i8 = Atom.TYPE_trun;
                                    if (i33 >= size4) {
                                        break;
                                    }
                                    SparseArray sparseArray4 = sparseArray3;
                                    abs absVar2 = (abs) list2.get(i33);
                                    int i36 = i7;
                                    if (absVar2.f3107d == 1953658222) {
                                        C2621cj c2621cj5 = absVar2.f3106a;
                                        c2621cj5.m2644F(12);
                                        int m2630l = c2621cj5.m2630l();
                                        if (m2630l > 0) {
                                            i35 += m2630l;
                                            i34++;
                                        }
                                    }
                                    i33++;
                                    i7 = i36;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                i2 = i7;
                                acfVar.f3153h = 0;
                                acfVar.f3152g = 0;
                                acfVar.f3151f = 0;
                                acr acrVar4 = acfVar.f3147b;
                                acrVar4.f3249d = i34;
                                acrVar4.f3250e = i35;
                                if (acrVar4.f3252g.length < i34) {
                                    acrVar4.f3251f = new long[i34];
                                    acrVar4.f3252g = new int[i34];
                                }
                                if (acrVar4.f3253h.length < i35) {
                                    int i37 = (i35 * 125) / 100;
                                    acrVar4.f3253h = new int[i37];
                                    acrVar4.f3254i = new long[i37];
                                    acrVar4.f3255j = new boolean[i37];
                                    acrVar4.f3257l = new boolean[i37];
                                }
                                int i38 = 0;
                                int i39 = 0;
                                int i40 = 0;
                                while (true) {
                                    long j5 = 0;
                                    if (i38 >= size4) {
                                        break;
                                    }
                                    abs absVar3 = (abs) list2.get(i38);
                                    if (absVar3.f3107d == i8) {
                                        int i41 = i40 + 1;
                                        C2621cj c2621cj6 = absVar3.f3106a;
                                        c2621cj6.m2644F(8);
                                        int m5889e2 = abt.m5889e(c2621cj6.m2637e());
                                        list = list2;
                                        acp acpVar3 = acfVar.f3149d.f3263a;
                                        i12 = size4;
                                        acr acrVar5 = acfVar.f3147b;
                                        acb acbVar2 = acrVar5.f3246a;
                                        int i42 = C2628cq.f6961a;
                                        acrVar5.f3252g[i40] = c2621cj6.m2630l();
                                        long[] jArr = acrVar5.f3251f;
                                        i10 = i38;
                                        abrVar2 = abrVar4;
                                        long j6 = acrVar5.f3247b;
                                        jArr[i40] = j6;
                                        if ((m5889e2 & 1) != 0) {
                                            i13 = i32;
                                            i14 = i39;
                                            jArr[i40] = j6 + c2621cj6.m2637e();
                                        } else {
                                            i14 = i39;
                                            i13 = i32;
                                        }
                                        int i43 = m5889e2 & 4;
                                        int i44 = acbVar2.f3136d;
                                        if (i43 != 0) {
                                            i44 = c2621cj6.m2637e();
                                        }
                                        int i45 = m5889e2 & 256;
                                        int i46 = m5889e2 & 512;
                                        int i47 = m5889e2 & 1024;
                                        int i48 = m5889e2 & 2048;
                                        int i49 = i44;
                                        long[] jArr2 = acpVar3.f3237h;
                                        if (jArr2 != null) {
                                            bArr4 = bArr5;
                                            abrVar3 = abrVar5;
                                            if (jArr2.length == 1 && jArr2[0] == 0) {
                                                j5 = ((long[]) C2628cq.m2578E(acpVar3.f3238i))[0];
                                            }
                                        } else {
                                            bArr4 = bArr5;
                                            abrVar3 = abrVar5;
                                        }
                                        int[] iArr = acrVar5.f3253h;
                                        long[] jArr3 = acrVar5.f3254i;
                                        boolean[] zArr = acrVar5.f3255j;
                                        acrVar = acrVar3;
                                        boolean z3 = acpVar3.f3231b == 2 && (i31 & 1) != 0;
                                        int i50 = i14 + acrVar5.f3252g[i40];
                                        i11 = i31;
                                        boolean z4 = z3;
                                        long j7 = acpVar3.f3232c;
                                        long j8 = acrVar5.f3261p;
                                        int i51 = i14;
                                        while (i51 < i50) {
                                            if (i45 != 0) {
                                                i15 = i45;
                                                i16 = c2621cj6.m2637e();
                                            } else {
                                                i15 = i45;
                                                i16 = acbVar2.f3134b;
                                            }
                                            m5851j(i16);
                                            if (i46 != 0) {
                                                i18 = c2621cj6.m2637e();
                                                i17 = i46;
                                            } else {
                                                i17 = i46;
                                                i18 = acbVar2.f3135c;
                                            }
                                            m5851j(i18);
                                            if (i47 != 0) {
                                                i19 = c2621cj6.m2637e();
                                            } else {
                                                if (i51 == 0) {
                                                    if (i43 != 0) {
                                                        i19 = i49;
                                                        i51 = 0;
                                                    } else {
                                                        i51 = 0;
                                                    }
                                                }
                                                i19 = acbVar2.f3136d;
                                            }
                                            if (i48 != 0) {
                                                i20 = i43;
                                                i21 = i47;
                                                i22 = i48;
                                                i23 = c2621cj6.m2637e();
                                            } else {
                                                i20 = i43;
                                                i21 = i47;
                                                i22 = i48;
                                                i23 = 0;
                                            }
                                            long m2512v = C2628cq.m2512v((i23 + j8) - j5, 1000000L, j7);
                                            jArr3[i51] = m2512v;
                                            if (acrVar5.f3262q) {
                                                j2 = j7;
                                            } else {
                                                j2 = j7;
                                                jArr3[i51] = m2512v + acfVar.f3149d.f3270h;
                                            }
                                            iArr[i51] = i18;
                                            zArr[i51] = ((i19 >> 16) & 1) == 0 && (!z4 || i51 == 0);
                                            j8 += i16;
                                            i51++;
                                            j7 = j2;
                                            i45 = i15;
                                            i46 = i17;
                                            i43 = i20;
                                            i47 = i21;
                                            i48 = i22;
                                        }
                                        acrVar5.f3261p = j8;
                                        i39 = i50;
                                        i40 = i41;
                                    } else {
                                        i10 = i38;
                                        abrVar2 = abrVar4;
                                        i11 = i31;
                                        acrVar = acrVar3;
                                        list = list2;
                                        bArr4 = bArr5;
                                        i12 = size4;
                                        i13 = i32;
                                        abrVar3 = abrVar5;
                                    }
                                    i38 = i10 + 1;
                                    list2 = list;
                                    size4 = i12;
                                    abrVar4 = abrVar2;
                                    i32 = i13;
                                    bArr5 = bArr4;
                                    abrVar5 = abrVar3;
                                    acrVar3 = acrVar;
                                    i31 = i11;
                                    i8 = Atom.TYPE_trun;
                                }
                                abrVar = abrVar4;
                                i = i31;
                                acr acrVar6 = acrVar3;
                                byte[] bArr6 = bArr5;
                                i3 = i32;
                                acp acpVar4 = acfVar.f3149d.f3263a;
                                acb acbVar3 = acrVar6.f3246a;
                                C2616ce.m2689d(acbVar3);
                                acq m5826a = acpVar4.m5826a(acbVar3.f3133a);
                                abs m5892b3 = abrVar5.m5892b(Atom.TYPE_saiz);
                                if (m5892b3 != null) {
                                    C2616ce.m2689d(m5826a);
                                    C2621cj c2621cj7 = m5892b3.f3106a;
                                    int i52 = m5826a.f3244d;
                                    c2621cj7.m2644F(8);
                                    if ((abt.m5889e(c2621cj7.m2637e()) & 1) == 1) {
                                        c2621cj7.m2643G(8);
                                    }
                                    int m2633i = c2621cj7.m2633i();
                                    int m2630l2 = c2621cj7.m2630l();
                                    int i53 = acrVar6.f3250e;
                                    if (m2630l2 <= i53) {
                                        if (m2633i != 0) {
                                            boolean z5 = m2633i > i52;
                                            i9 = m2633i * m2630l2;
                                            z = false;
                                            Arrays.fill(acrVar6.f3257l, 0, m2630l2, z5);
                                        } else {
                                            boolean[] zArr2 = acrVar6.f3257l;
                                            i9 = 0;
                                            for (int i54 = 0; i54 < m2630l2; i54++) {
                                                int m2633i2 = c2621cj7.m2633i();
                                                i9 += m2633i2;
                                                zArr2[i54] = m2633i2 > i52;
                                            }
                                            z = false;
                                        }
                                        Arrays.fill(acrVar6.f3257l, m2630l2, acrVar6.f3250e, z);
                                        if (i9 > 0) {
                                            acrVar6.m5824b(i9);
                                        }
                                    } else {
                                        StringBuilder sb = new StringBuilder(78);
                                        sb.append("Saiz sample count ");
                                        sb.append(m2630l2);
                                        sb.append(" is greater than fragment sample count");
                                        sb.append(i53);
                                        throw C2555ao.m4866a(sb.toString(), null);
                                    }
                                }
                                abs m5892b4 = abrVar5.m5892b(Atom.TYPE_saio);
                                if (m5892b4 != null) {
                                    C2621cj c2621cj8 = m5892b4.f3106a;
                                    c2621cj8.m2644F(8);
                                    int m2637e2 = c2621cj8.m2637e();
                                    if ((abt.m5889e(m2637e2) & 1) == 1) {
                                        c2621cj8.m2643G(8);
                                    }
                                    int m2630l3 = c2621cj8.m2630l();
                                    if (m2630l3 != 1) {
                                        StringBuilder sb2 = new StringBuilder(40);
                                        sb2.append("Unexpected saio entry count: ");
                                        sb2.append(m2630l3);
                                        throw C2555ao.m4866a(sb2.toString(), null);
                                    }
                                    acrVar6.f3248c += abt.m5888f(m2637e2) == 0 ? c2621cj8.m2626p() : c2621cj8.m2625q();
                                }
                                abs m5892b5 = abrVar5.m5892b(Atom.TYPE_senc);
                                if (m5892b5 != null) {
                                    m5853h(m5892b5.f3106a, 0, acrVar6);
                                }
                                String str = m5826a != null ? m5826a.f3242b : null;
                                C2621cj c2621cj9 = null;
                                C2621cj c2621cj10 = null;
                                for (int i55 = 0; i55 < abrVar5.f3104b.size(); i55++) {
                                    abs absVar4 = (abs) abrVar5.f3104b.get(i55);
                                    C2621cj c2621cj11 = absVar4.f3106a;
                                    int i56 = absVar4.f3107d;
                                    if (i56 == 1935828848) {
                                        c2621cj11.m2644F(12);
                                        if (c2621cj11.m2637e() == 1936025959) {
                                            c2621cj9 = c2621cj11;
                                        }
                                    } else if (i56 == 1936158820) {
                                        c2621cj11.m2644F(12);
                                        if (c2621cj11.m2637e() == 1936025959) {
                                            c2621cj10 = c2621cj11;
                                        }
                                    }
                                }
                                if (c2621cj9 != null && c2621cj10 != null) {
                                    c2621cj9.m2644F(8);
                                    int m2637e3 = c2621cj9.m2637e();
                                    c2621cj9.m2643G(4);
                                    if (abt.m5888f(m2637e3) == 1) {
                                        c2621cj9.m2643G(4);
                                    }
                                    if (c2621cj9.m2637e() == 1) {
                                        c2621cj10.m2644F(8);
                                        int m5888f = abt.m5888f(c2621cj10.m2637e());
                                        c2621cj10.m2643G(4);
                                        if (m5888f == 1) {
                                            if (c2621cj10.m2626p() == 0) {
                                                throw C2555ao.m4863d("Variable length description in sgpd found (unsupported)");
                                            }
                                        } else if (m5888f >= 2) {
                                            c2621cj10.m2643G(4);
                                        }
                                        if (c2621cj10.m2626p() == 1) {
                                            c2621cj10.m2643G(1);
                                            int m2633i3 = c2621cj10.m2633i();
                                            int i57 = (m2633i3 & 240) >> 4;
                                            int i58 = m2633i3 & 15;
                                            if (c2621cj10.m2633i() == 1) {
                                                int m2633i4 = c2621cj10.m2633i();
                                                byte[] bArr7 = new byte[16];
                                                c2621cj10.m2649A(bArr7, 0, 16);
                                                if (m2633i4 == 0) {
                                                    int m2633i5 = c2621cj10.m2633i();
                                                    byte[] bArr8 = new byte[m2633i5];
                                                    c2621cj10.m2649A(bArr8, 0, m2633i5);
                                                    bArr3 = bArr8;
                                                } else {
                                                    bArr3 = null;
                                                }
                                                acrVar6.f3256k = true;
                                                acrVar6.f3258m = new acq(true, str, m2633i4, bArr7, i57, i58, bArr3);
                                            }
                                        } else {
                                            throw C2555ao.m4863d("Entry count in sgpd != 1 (unsupported).");
                                        }
                                    } else {
                                        throw C2555ao.m4863d("Entry count in sbgp != 1 (unsupported).");
                                    }
                                }
                                int size5 = abrVar5.f3104b.size();
                                int i59 = 0;
                                while (i59 < size5) {
                                    abs absVar5 = (abs) abrVar5.f3104b.get(i59);
                                    if (absVar5.f3107d == 1970628964) {
                                        C2621cj c2621cj12 = absVar5.f3106a;
                                        c2621cj12.m2644F(8);
                                        bArr2 = bArr6;
                                        c2621cj12.m2649A(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, f3158a)) {
                                            m5853h(c2621cj12, 16, acrVar6);
                                        }
                                    } else {
                                        bArr2 = bArr6;
                                    }
                                    i59++;
                                    bArr6 = bArr2;
                                }
                                bArr = bArr6;
                                i32 = i3 + 1;
                                bArr5 = bArr;
                                size3 = i2;
                                sparseArray3 = sparseArray;
                                abrVar4 = abrVar;
                                i31 = i;
                                i26 = 8;
                            }
                        }
                        sparseArray = sparseArray3;
                        abrVar = abrVar4;
                        i = i31;
                        i2 = size3;
                        i3 = i32;
                        bArr = bArr5;
                        i32 = i3 + 1;
                        bArr5 = bArr;
                        size3 = i2;
                        sparseArray3 = sparseArray;
                        abrVar4 = abrVar;
                        i31 = i;
                        i26 = 8;
                    }
                    C2854l m5855f2 = m5855f(abrVar4.f3104b);
                    acgVar = this;
                    if (m5855f2 != null) {
                        int size6 = acgVar.f3171e.size();
                        for (int i60 = 0; i60 < size6; i60++) {
                            acf acfVar2 = (acf) acgVar.f3171e.valueAt(i60);
                            acp acpVar5 = acfVar2.f3149d.f3263a;
                            acb acbVar4 = acfVar2.f3147b.f3246a;
                            int i61 = C2628cq.f6961a;
                            acq m5826a2 = acpVar5.m5826a(acbVar4.f3133a);
                            C2854l m1735b = m5855f2.m1735b(m5826a2 != null ? m5826a2.f3242b : null);
                            C2935o m1426b = acfVar2.f3149d.f3263a.f3235f.m1426b();
                            m1426b.m1551M(m1735b);
                            acfVar2.f3146a.mo443b(m1426b.m1506v());
                        }
                    }
                    if (acgVar.f3190x != C3282C.TIME_UNSET) {
                        int size7 = acgVar.f3171e.size();
                        for (int i62 = 0; i62 < size7; i62++) {
                            acf acfVar3 = (acf) acgVar.f3171e.valueAt(i62);
                            long j9 = acgVar.f3190x;
                            int i63 = acfVar3.f3151f;
                            while (true) {
                                acr acrVar7 = acfVar3.f3147b;
                                if (i63 < acrVar7.f3250e && acrVar7.m5825a(i63) < j9) {
                                    if (acfVar3.f3147b.f3255j[i63]) {
                                        acfVar3.f3154i = i63;
                                    }
                                    i63++;
                                }
                            }
                        }
                        acgVar.f3190x = C3282C.TIME_UNSET;
                    }
                } else {
                    acgVar = acgVar2;
                    if (!acgVar.f3180n.isEmpty()) {
                        ((abr) acgVar.f3180n.peek()).m5891c(abrVar4);
                    }
                }
                acgVar2 = acgVar;
            }
        }
        m5854g();
    }

    /* renamed from: j */
    private static void m5851j(int i) throws C2555ao {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Unexpected negative value: ");
        sb.append(i);
        throw C2555ao.m4866a(sb.toString(), null);
    }

    /* renamed from: k */
    private static final acb m5850k(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (acb) sparseArray.valueAt(0);
        }
        acb acbVar = (acb) sparseArray.get(i);
        C2616ce.m2689d(acbVar);
        return acbVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    public final boolean mo433D(InterfaceC3230yy interfaceC3230yy) throws IOException {
        return aco.m5829a(interfaceC3230yy);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0231, code lost:
        r21 = r2.m5866a();
        r1 = r2.m5861f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0239, code lost:
        if (r1 == null) goto L363;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x023b, code lost:
        r24 = r1.f3243c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0240, code lost:
        r24 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0242, code lost:
        r5.mo441f(r9, r21, r28.f3161B, 0, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0255, code lost:
        if (r28.f3181o.isEmpty() != false) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0257, code lost:
        r1 = (com.google.ads.interactivemedia.p034v3.internal.ace) r28.f3181o.removeFirst();
        r28.f3189w -= r1.f3145b;
        r3 = r1.f3144a + r9;
        r5 = r28.f3177k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x026b, code lost:
        if (r5 == null) goto L351;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x026d, code lost:
        r3 = r5.m2591a(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0271, code lost:
        r5 = r28.f3166G;
        r6 = r5.length;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0275, code lost:
        if (r8 >= r6) goto L356;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0277, code lost:
        r5[r8].mo441f(r3, 1, r1.f3145b, r28.f3189w, null);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0291, code lost:
        if (r2.m5857j() != false) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0293, code lost:
        r28.f3160A = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0295, code lost:
        r28.f3183q = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
        r4 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
        if (r28.f3183q != 3) goto L333;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
        r3 = r2.m5865b();
        r28.f3161B = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a3, code lost:
        if (r2.f3151f >= r2.f3154i) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:?, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a5, code lost:
        r1.mo493i(r3);
        r1 = r2.m5861f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
        if (r1 != null) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00af, code lost:
        r3 = r2.f3147b.f3259n;
        r1 = r1.f3244d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b5, code lost:
        if (r1 == 0) goto L317;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b7, code lost:
        r3.m2643G(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c2, code lost:
        if (r2.f3147b.m5823c(r2.f3151f) == false) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00c4, code lost:
        r3.m2643G(r3.m2629m() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d1, code lost:
        if (r2.m5857j() != false) goto L323;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d3, code lost:
        r28.f3160A = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d5, code lost:
        r28.f3183q = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d7, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e0, code lost:
        if (r2.f3149d.f3263a.f3236g != 1) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e2, code lost:
        r28.f3161B = r3 - 8;
        r1.mo493i(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f7, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(r2.f3149d.f3263a.f3235f.f8372l) == false) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f9, code lost:
        r28.f3162C = r2.m5864c(r28.f3161B, 7);
        com.google.ads.interactivemedia.p034v3.internal.C3212yg.m546b(r28.f3161B, r28.f3176j);
        r2.f3146a.mo442e(r28.f3176j, 7);
        r3 = r28.f3162C + 7;
        r28.f3162C = r3;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0117, code lost:
        r5 = 0;
        r3 = r2.m5864c(r28.f3161B, 0);
        r28.f3162C = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0120, code lost:
        r28.f3161B += r3;
        r28.f3183q = 4;
        r28.f3163D = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x012a, code lost:
        r3 = r2.f3149d.f3263a;
        r5 = r2.f3146a;
        r9 = r2.m5862e();
        r6 = r28.f3177k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0136, code lost:
        if (r6 == null) goto L336;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0138, code lost:
        r9 = r6.m2591a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x013c, code lost:
        r6 = r3.f3239j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x013e, code lost:
        if (r6 != 0) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0140, code lost:
        r3 = r28.f3162C;
        r4 = r28.f3161B;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0144, code lost:
        if (r3 >= r4) goto L341;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0146, code lost:
        r28.f3162C += r5.mo444a(r1, r4 - r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0152, code lost:
        r13 = r28.f3173g.m2642H();
        r13[0] = 0;
        r13[1] = 0;
        r13[2] = 0;
        r11 = r6 + 1;
        r6 = 4 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0169, code lost:
        if (r28.f3162C >= r28.f3161B) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x016b, code lost:
        r14 = r28.f3163D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x016f, code lost:
        if (r14 != 0) goto L389;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0171, code lost:
        r1.mo495g(r13, r6, r11);
        r28.f3173g.m2644F(0);
        r14 = r28.f3173g.m2637e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0180, code lost:
        if (r14 <= 0) goto L386;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0182, code lost:
        r28.f3163D = r14 - 1;
        r28.f3172f.m2644F(0);
        r5.mo442e(r28.f3172f, 4);
        r5.mo442e(r28.f3173g, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0199, code lost:
        if (r28.f3167H.length <= 0) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019b, code lost:
        r12 = r3.f3235f.f8372l;
        r18 = r13[4];
        r14 = com.google.ads.interactivemedia.p034v3.internal.C3245zm.f9602a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a9, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264.equals(r12) == false) goto L381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ad, code lost:
        if ((r18 & 31) == r4) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01b0, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01b6, code lost:
        if (com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265.equals(r12) == false) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01bd, code lost:
        if (((r18 & 126) >> r8) != 39) goto L385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c0, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01c1, code lost:
        r28.f3164E = r12;
        r28.f3162C += 5;
        r28.f3161B += r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d5, code lost:
        throw com.google.ads.interactivemedia.p034v3.internal.C2555ao.m4866a("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d8, code lost:
        if (r28.f3164E == false) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01da, code lost:
        r28.f3174h.m2648B(r14);
        r1.mo495g(r28.f3174h.m2642H(), 0, r28.f3163D);
        r5.mo442e(r28.f3174h, r28.f3163D);
        r4 = r28.f3163D;
        r12 = r28.f3174h;
        r12 = com.google.ads.interactivemedia.p034v3.internal.C3245zm.m465b(r12.m2642H(), r12.m2638d());
        r28.f3174h.m2644F(com.google.android.exoplayer2.util.MimeTypes.VIDEO_H265.equals(r3.f3235f.f8372l) ? 1 : 0);
        r28.f3174h.m2645E(r12);
        com.google.ads.interactivemedia.p034v3.internal.C2539ab.m5955i(r9, r28.f3174h, r28.f3167H);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x021c, code lost:
        r4 = r5.mo444a(r1, r14, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0222, code lost:
        r28.f3162C += r4;
        r28.f3163D -= r4;
        r4 = 6;
        r8 = 1;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int mo432a(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r29, com.google.ads.interactivemedia.p034v3.internal.C3247zo r30) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1826
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.acg.mo432a(com.google.ads.interactivemedia.v3.internal.yy, com.google.ads.interactivemedia.v3.internal.zo):int");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        int i;
        this.f3165F = interfaceC3233za;
        m5854g();
        InterfaceC3253zu[] interfaceC3253zuArr = new InterfaceC3253zu[2];
        this.f3166G = interfaceC3253zuArr;
        InterfaceC3253zu interfaceC3253zu = this.f3182p;
        int i2 = 0;
        if (interfaceC3253zu != null) {
            interfaceC3253zuArr[0] = interfaceC3253zu;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.f3169c & 4) != 0) {
            interfaceC3253zuArr[i] = this.f3165F.mo489be(100, 5);
            i3 = 101;
            i++;
        }
        InterfaceC3253zu[] interfaceC3253zuArr2 = (InterfaceC3253zu[]) C2628cq.m2549ag(this.f3166G, i);
        this.f3166G = interfaceC3253zuArr2;
        for (InterfaceC3253zu interfaceC3253zu2 : interfaceC3253zuArr2) {
            interfaceC3253zu2.mo443b(f3159b);
        }
        this.f3167H = new InterfaceC3253zu[this.f3170d.size()];
        while (i2 < this.f3167H.length) {
            InterfaceC3253zu mo489be = this.f3165F.mo489be(i3, 3);
            mo489be.mo443b((C2962p) this.f3170d.get(i2));
            this.f3167H[i2] = mo489be;
            i2++;
            i3++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        int size = this.f3171e.size();
        for (int i = 0; i < size; i++) {
            ((acf) this.f3171e.valueAt(i)).m5859h();
        }
        this.f3181o.clear();
        this.f3189w = 0;
        this.f3190x = j2;
        this.f3180n.clear();
        m5854g();
    }

    public acg(byte[] bArr) {
        this(0, null, Collections.emptyList());
    }

    public acg(int i, C2626co c2626co, List list) {
        this(i, c2626co, list, null);
    }

    public acg(int i, C2626co c2626co, List list, InterfaceC3253zu interfaceC3253zu) {
        this.f3169c = i;
        this.f3177k = c2626co;
        this.f3170d = Collections.unmodifiableList(list);
        this.f3182p = interfaceC3253zu;
        this.f3178l = new aac();
        this.f3179m = new C2621cj(16);
        this.f3172f = new C2621cj(C3245zm.f9602a);
        this.f3173g = new C2621cj(5);
        this.f3174h = new C2621cj();
        byte[] bArr = new byte[16];
        this.f3175i = bArr;
        this.f3176j = new C2621cj(bArr);
        this.f3180n = new ArrayDeque();
        this.f3181o = new ArrayDeque();
        this.f3171e = new SparseArray();
        this.f3191y = C3282C.TIME_UNSET;
        this.f3190x = C3282C.TIME_UNSET;
        this.f3192z = C3282C.TIME_UNSET;
        this.f3165F = InterfaceC3233za.f9550b;
        this.f3166G = new InterfaceC3253zu[0];
        this.f3167H = new InterfaceC3253zu[0];
    }
}

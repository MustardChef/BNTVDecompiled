package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kl */
/* loaded from: classes2.dex */
final class C2839kl implements InterfaceC3066sw, InterfaceC3099ub, InterfaceC3116us {

    /* renamed from: b */
    private static final Pattern f7861b = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: c */
    private static final Pattern f7862c = Pattern.compile("([1-4])=lang:(\\w+)(,.+)?");

    /* renamed from: a */
    final int f7863a;

    /* renamed from: d */
    private final InterfaceC2659du f7864d;

    /* renamed from: e */
    private final InterfaceC2921nm f7865e;

    /* renamed from: f */
    private final C2835kh f7866f;

    /* renamed from: g */
    private final long f7867g;

    /* renamed from: h */
    private final InterfaceC3168wq f7868h;

    /* renamed from: i */
    private final C2588bd f7869i;

    /* renamed from: j */
    private final C2838kk[] f7870j;

    /* renamed from: k */
    private final C2861lg f7871k;

    /* renamed from: m */
    private final C3076tf f7873m;

    /* renamed from: n */
    private final C2915ng f7874n;

    /* renamed from: o */
    private InterfaceC3065sv f7875o;

    /* renamed from: s */
    private C2864lj f7879s;

    /* renamed from: t */
    private int f7880t;

    /* renamed from: u */
    private List f7881u;

    /* renamed from: v */
    private final C2852ky f7882v;

    /* renamed from: w */
    private final C3154wc f7883w;

    /* renamed from: x */
    private final C3161wj f7884x;

    /* renamed from: y */
    private final C3161wj f7885y;

    /* renamed from: p */
    private C3117ut[] f7876p = new C3117ut[0];

    /* renamed from: q */
    private C2857lc[] f7877q = new C2857lc[0];

    /* renamed from: l */
    private final IdentityHashMap f7872l = new IdentityHashMap();

    /* renamed from: r */
    private InterfaceC3100uc f7878r = C3161wj.m735f(this.f7876p);

    public C2839kl(int i, C2864lj c2864lj, C2835kh c2835kh, int i2, C2852ky c2852ky, InterfaceC2659du interfaceC2659du, InterfaceC2921nm interfaceC2921nm, C2915ng c2915ng, C3161wj c3161wj, C3076tf c3076tf, long j, InterfaceC3168wq interfaceC3168wq, C3154wc c3154wc, C3161wj c3161wj2, InterfaceC2859le interfaceC2859le, byte[] bArr, byte[] bArr2) {
        List list;
        int i3;
        int i4;
        boolean[] zArr;
        C2962p[] c2962pArr;
        C2867lm m1778s;
        InterfaceC2921nm interfaceC2921nm2 = interfaceC2921nm;
        this.f7863a = i;
        this.f7879s = c2864lj;
        this.f7866f = c2835kh;
        this.f7880t = i2;
        this.f7882v = c2852ky;
        this.f7864d = interfaceC2659du;
        this.f7865e = interfaceC2921nm2;
        this.f7874n = c2915ng;
        this.f7884x = c3161wj;
        this.f7873m = c3076tf;
        this.f7867g = j;
        this.f7868h = interfaceC3168wq;
        this.f7883w = c3154wc;
        this.f7885y = c3161wj2;
        this.f7871k = new C2861lg(c2864lj, interfaceC2859le, c3154wc);
        int i5 = 0;
        C2869lo m1709d = c2864lj.m1709d(i2);
        this.f7881u = m1709d.f8043d;
        List list2 = m1709d.f8042c;
        List list3 = this.f7881u;
        int size = list2.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i6 = 0; i6 < size; i6++) {
            sparseIntArray.put(((C2862lh) list2.get(i6)).f7998a, i6);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i6));
            arrayList.add(arrayList2);
            sparseArray.put(i6, arrayList2);
        }
        for (int i7 = 0; i7 < size; i7++) {
            C2862lh c2862lh = (C2862lh) list2.get(i7);
            C2867lm m1777t = m1777t(c2862lh.f8002e);
            m1777t = m1777t == null ? m1777t(c2862lh.f8003f) : m1777t;
            int i8 = (m1777t == null || (i8 = sparseIntArray.get(Integer.parseInt(m1777t.f8034b), -1)) == -1) ? i7 : i8;
            if (i8 == i7 && (m1778s = m1778s(c2862lh.f8003f, "urn:mpeg:dash:adaptation-set-switching:2016")) != null) {
                for (String str : C2628cq.m2547ai(m1778s.f8034b, ",")) {
                    int i9 = sparseIntArray.get(Integer.parseInt(str), -1);
                    if (i9 != -1) {
                        i8 = Math.min(i8, i9);
                    }
                }
            }
            if (i8 != i7) {
                List list4 = (List) sparseArray.get(i7);
                List list5 = (List) sparseArray.get(i8);
                list5.addAll(list4);
                sparseArray.put(i7, list5);
                arrayList.remove(list4);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2];
        for (int i10 = 0; i10 < size2; i10++) {
            int[] m4380a = axn.m4380a((Collection) arrayList.get(i10));
            iArr[i10] = m4380a;
            Arrays.sort(m4380a);
        }
        boolean[] zArr2 = new boolean[size2];
        C2962p[][] c2962pArr2 = new C2962p[size2];
        int i11 = 0;
        int i12 = 0;
        while (i11 < size2) {
            int[] iArr2 = iArr[i11];
            int length = iArr2.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length) {
                    break;
                }
                List list6 = ((C2862lh) list2.get(iArr2[i13])).f8000c;
                while (i5 < list6.size()) {
                    if (!((AbstractC2874lt) list6.get(i5)).f8060e.isEmpty()) {
                        zArr2[i11] = true;
                        i12++;
                        break;
                    }
                    i5++;
                }
                i13++;
                i5 = 0;
            }
            int[] iArr3 = iArr[i11];
            int length2 = iArr3.length;
            int i14 = 0;
            while (true) {
                if (i14 >= length2) {
                    c2962pArr = new C2962p[0];
                    break;
                }
                int i15 = iArr3[i14];
                C2862lh c2862lh2 = (C2862lh) list2.get(i15);
                List list7 = ((C2862lh) list2.get(i15)).f8001d;
                int[] iArr4 = iArr3;
                int i16 = 0;
                while (i16 < list7.size()) {
                    C2867lm c2867lm = (C2867lm) list7.get(i16);
                    int i17 = length2;
                    List list8 = list7;
                    if (!"urn:scte:dash:cc:cea-608:2015".equals(c2867lm.f8033a)) {
                        if ("urn:scte:dash:cc:cea-708:2015".equals(c2867lm.f8033a)) {
                            C2935o c2935o = new C2935o();
                            c2935o.m1532ae(MimeTypes.APPLICATION_CEA708);
                            int i18 = c2862lh2.f7998a;
                            StringBuilder sb = new StringBuilder(18);
                            sb.append(i18);
                            sb.append(":cea708");
                            c2935o.m1545S(sb.toString());
                            c2962pArr = m1776u(c2867lm, f7862c, c2935o.m1506v());
                            break;
                        }
                        i16++;
                        length2 = i17;
                        list7 = list8;
                    } else {
                        C2935o c2935o2 = new C2935o();
                        c2935o2.m1532ae(MimeTypes.APPLICATION_CEA608);
                        int i19 = c2862lh2.f7998a;
                        StringBuilder sb2 = new StringBuilder(18);
                        sb2.append(i19);
                        sb2.append(":cea608");
                        c2935o2.m1545S(sb2.toString());
                        c2962pArr = m1776u(c2867lm, f7861b, c2935o2.m1506v());
                        break;
                    }
                }
                i14++;
                iArr3 = iArr4;
            }
            c2962pArr2[i11] = c2962pArr;
            if (c2962pArr.length != 0) {
                i12++;
            }
            i11++;
            i5 = 0;
        }
        int size3 = i12 + size2 + list3.size();
        C2587bc[] c2587bcArr = new C2587bc[size3];
        C2838kk[] c2838kkArr = new C2838kk[size3];
        int i20 = 0;
        int i21 = 0;
        while (i20 < size2) {
            int[] iArr5 = iArr[i20];
            ArrayList arrayList3 = new ArrayList();
            int length3 = iArr5.length;
            int i22 = size2;
            int i23 = 0;
            while (i23 < length3) {
                arrayList3.addAll(((C2862lh) list2.get(iArr5[i23])).f8000c);
                i23++;
                iArr = iArr;
            }
            int[][] iArr6 = iArr;
            int size4 = arrayList3.size();
            C2962p[] c2962pArr3 = new C2962p[size4];
            int i24 = 0;
            while (i24 < size4) {
                int i25 = size4;
                C2962p c2962p = ((AbstractC2874lt) arrayList3.get(i24)).f8057b;
                c2962pArr3[i24] = c2962p.m1425c(interfaceC2921nm2.mo1587b(c2962p));
                i24++;
                size4 = i25;
                arrayList3 = arrayList3;
            }
            C2862lh c2862lh3 = (C2862lh) list2.get(iArr5[0]);
            int i26 = i21 + 1;
            if (zArr2[i20]) {
                list = list2;
                i3 = i26;
                i26++;
            } else {
                list = list2;
                i3 = -1;
            }
            if (c2962pArr2[i20].length != 0) {
                int i27 = i26;
                i26++;
                i4 = i27;
            } else {
                i4 = -1;
            }
            c2587bcArr[i21] = new C2587bc(c2962pArr3);
            c2838kkArr[i21] = C2838kk.m1782d(c2862lh3.f7999b, iArr5, i21, i3, i4);
            int i28 = -1;
            if (i3 != -1) {
                C2935o c2935o3 = new C2935o();
                int i29 = c2862lh3.f7998a;
                zArr = zArr2;
                StringBuilder sb3 = new StringBuilder(16);
                sb3.append(i29);
                sb3.append(":emsg");
                c2935o3.m1545S(sb3.toString());
                c2935o3.m1532ae(MimeTypes.APPLICATION_EMSG);
                c2587bcArr[i3] = new C2587bc(c2935o3.m1506v());
                c2838kkArr[i3] = C2838kk.m1784b(iArr5, i21);
                i28 = -1;
            } else {
                zArr = zArr2;
            }
            if (i4 != i28) {
                c2587bcArr[i4] = new C2587bc(c2962pArr2[i20]);
                c2838kkArr[i4] = C2838kk.m1785a(iArr5, i21);
            }
            i20++;
            size2 = i22;
            iArr = iArr6;
            zArr2 = zArr;
            interfaceC2921nm2 = interfaceC2921nm;
            i21 = i26;
            list2 = list;
        }
        int i30 = 0;
        while (i30 < list3.size()) {
            C2935o c2935o4 = new C2935o();
            c2935o4.m1545S(((C2868ln) list3.get(i30)).m1679a());
            c2935o4.m1532ae(MimeTypes.APPLICATION_EMSG);
            c2587bcArr[i21] = new C2587bc(c2935o4.m1506v());
            c2838kkArr[i21] = C2838kk.m1783c(i30);
            i30++;
            i21++;
        }
        Pair create = Pair.create(new C2588bd(c2587bcArr), c2838kkArr);
        this.f7869i = (C2588bd) create.first;
        this.f7870j = (C2838kk[]) create.second;
    }

    /* renamed from: r */
    private final int m1779r(int i, int[] iArr) {
        int i2 = iArr[i];
        if (i2 == -1) {
            return -1;
        }
        int i3 = this.f7870j[i2].f7858e;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 == i3 && this.f7870j[i5].f7856c == 0) {
                return i4;
            }
        }
        return -1;
    }

    /* renamed from: s */
    private static C2867lm m1778s(List list, String str) {
        for (int i = 0; i < list.size(); i++) {
            C2867lm c2867lm = (C2867lm) list.get(i);
            if (str.equals(c2867lm.f8033a)) {
                return c2867lm;
            }
        }
        return null;
    }

    /* renamed from: t */
    private static C2867lm m1777t(List list) {
        return m1778s(list, "http://dashif.org/guidelines/trickmode");
    }

    /* renamed from: u */
    private static C2962p[] m1776u(C2867lm c2867lm, Pattern pattern, C2962p c2962p) {
        String str = c2867lm.f8034b;
        if (str == null) {
            return new C2962p[]{c2962p};
        }
        String[] m2547ai = C2628cq.m2547ai(str, ";");
        C2962p[] c2962pArr = new C2962p[m2547ai.length];
        for (int i = 0; i < m2547ai.length; i++) {
            Matcher matcher = pattern.matcher(m2547ai[i]);
            if (!matcher.matches()) {
                return new C2962p[]{c2962p};
            }
            int parseInt = Integer.parseInt(matcher.group(1));
            C2935o m1426b = c2962p.m1426b();
            String str2 = c2962p.f8361a;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 12);
            sb.append(str2);
            sb.append(":");
            sb.append(parseInt);
            m1426b.m1545S(sb.toString());
            m1426b.m1558F(parseInt);
            m1426b.m1542V(matcher.group(2));
            c2962pArr[i] = m1426b.m1506v();
        }
        return c2962pArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: a */
    public final long mo1030a(long j, C2740gu c2740gu) {
        C3117ut[] c3117utArr;
        for (C3117ut c3117ut : this.f7876p) {
            if (c3117ut.f9111a == 2) {
                return c3117ut.m884f(j, c2740gu);
            }
        }
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: bg */
    public final long mo888bg() {
        return this.f7878r.mo888bg();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: c */
    public final long mo887c() {
        return this.f7878r.mo887c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: d */
    public final long mo1029d() {
        return C3282C.TIME_UNSET;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: e */
    public final long mo1028e(long j) {
        for (C3117ut c3117ut : this.f7876p) {
            c3117ut.m877m(j);
        }
        for (C2857lc c2857lc : this.f7877q) {
            c2857lc.m1726e(j);
        }
        return j;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.google.ads.interactivemedia.v3.internal.ki, com.google.ads.interactivemedia.v3.internal.uu] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: f */
    public final long mo1027f(InterfaceC3142vr[] interfaceC3142vrArr, boolean[] zArr, InterfaceC3098ua[] interfaceC3098uaArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        int[] iArr;
        int i2;
        int[] iArr2;
        C2587bc c2587bc;
        int i3;
        C2587bc c2587bc2;
        int i4;
        InterfaceC3142vr[] interfaceC3142vrArr2 = interfaceC3142vrArr;
        InterfaceC3098ua[] interfaceC3098uaArr2 = interfaceC3098uaArr;
        int[] iArr3 = new int[interfaceC3142vrArr2.length];
        int i5 = 0;
        int i6 = 0;
        while (true) {
            i = -1;
            if (i6 >= interfaceC3142vrArr2.length) {
                break;
            }
            InterfaceC3142vr interfaceC3142vr = interfaceC3142vrArr2[i6];
            if (interfaceC3142vr != null) {
                iArr3[i6] = this.f7869i.m4122a(interfaceC3142vr.mo834f());
            } else {
                iArr3[i6] = -1;
            }
            i6++;
        }
        for (int i7 = 0; i7 < interfaceC3142vrArr2.length; i7++) {
            if (interfaceC3142vrArr2[i7] == null || !zArr[i7]) {
                InterfaceC3098ua interfaceC3098ua = interfaceC3098uaArr2[i7];
                if (interfaceC3098ua instanceof C3117ut) {
                    ((C3117ut) interfaceC3098ua).m879k(this);
                } else if (interfaceC3098ua instanceof C3115ur) {
                    ((C3115ur) interfaceC3098ua).m894c();
                }
                interfaceC3098uaArr2[i7] = null;
            }
        }
        int i8 = 0;
        while (true) {
            z = true;
            if (i8 >= interfaceC3142vrArr2.length) {
                break;
            }
            InterfaceC3098ua interfaceC3098ua2 = interfaceC3098uaArr2[i8];
            if ((interfaceC3098ua2 instanceof C3055sl) || (interfaceC3098ua2 instanceof C3115ur)) {
                int m1779r = m1779r(i8, iArr3);
                if (m1779r == -1) {
                    z = interfaceC3098uaArr2[i8] instanceof C3055sl;
                } else {
                    InterfaceC3098ua interfaceC3098ua3 = interfaceC3098uaArr2[i8];
                    if (!(interfaceC3098ua3 instanceof C3115ur) || ((C3115ur) interfaceC3098ua3).f9106a != interfaceC3098uaArr2[m1779r]) {
                        z = false;
                    }
                }
                if (!z) {
                    InterfaceC3098ua interfaceC3098ua4 = interfaceC3098uaArr2[i8];
                    if (interfaceC3098ua4 instanceof C3115ur) {
                        ((C3115ur) interfaceC3098ua4).m894c();
                    }
                    interfaceC3098uaArr2[i8] = null;
                }
            }
            i8++;
        }
        int i9 = 0;
        while (i9 < interfaceC3142vrArr2.length) {
            InterfaceC3142vr interfaceC3142vr2 = interfaceC3142vrArr2[i9];
            if (interfaceC3142vr2 == null) {
                i2 = i9;
                iArr2 = iArr3;
            } else {
                InterfaceC3098ua interfaceC3098ua5 = interfaceC3098uaArr2[i9];
                if (interfaceC3098ua5 == null) {
                    zArr2[i9] = z;
                    C2838kk c2838kk = this.f7870j[iArr3[i9]];
                    int i10 = c2838kk.f7856c;
                    if (i10 == 0) {
                        int i11 = c2838kk.f7859f;
                        boolean z2 = i11 != i;
                        if (z2) {
                            c2587bc = this.f7869i.m4121b(i11);
                            i3 = 1;
                        } else {
                            c2587bc = null;
                            i3 = 0;
                        }
                        int i12 = c2838kk.f7860g;
                        if (i12 != i) {
                            c2587bc2 = this.f7869i.m4121b(i12);
                            i3 += c2587bc2.f5406a;
                        } else {
                            c2587bc2 = null;
                        }
                        C2962p[] c2962pArr = new C2962p[i3];
                        int[] iArr4 = new int[i3];
                        if (z2) {
                            c2962pArr[i5] = c2587bc.m4193b(i5);
                            iArr4[i5] = 5;
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        ArrayList arrayList = new ArrayList();
                        if (i12 != i) {
                            for (int i13 = 0; i13 < c2587bc2.f5406a; i13++) {
                                C2962p m4193b = c2587bc2.m4193b(i13);
                                c2962pArr[i4] = m4193b;
                                iArr4[i4] = 3;
                                arrayList.add(m4193b);
                                i4++;
                            }
                        }
                        C2860lf m1720b = (this.f7879s.f8011d && z2) ? this.f7871k.m1720b() : null;
                        C2860lf c2860lf = m1720b;
                        i2 = i9;
                        iArr2 = iArr3;
                        C3117ut c3117ut = new C3117ut(c2838kk.f7855b, iArr4, c2962pArr, this.f7882v.m1750a(this.f7868h, this.f7879s, this.f7866f, this.f7880t, c2838kk.f7854a, interfaceC3142vr2, c2838kk.f7855b, this.f7867g, z2, arrayList, m1720b, this.f7864d), this, this.f7883w, j, this.f7865e, this.f7874n, this.f7884x, this.f7873m, null);
                        synchronized (this) {
                            this.f7872l.put(c3117ut, c2860lf);
                        }
                        interfaceC3098uaArr[i2] = c3117ut;
                    } else {
                        i2 = i9;
                        iArr2 = iArr3;
                        if (i10 == 2) {
                            interfaceC3098uaArr[i2] = new C2857lc((C2868ln) this.f7881u.get(c2838kk.f7857d), interfaceC3142vr2.mo834f().m4193b(0), this.f7879s.f8011d);
                        }
                    }
                } else {
                    i2 = i9;
                    iArr2 = iArr3;
                    if (interfaceC3098ua5 instanceof C3117ut) {
                        ((C3117ut) interfaceC3098ua5).m880j().mo1732b(interfaceC3142vr2);
                    }
                }
                i9 = i2 + 1;
                interfaceC3142vrArr2 = interfaceC3142vrArr;
                interfaceC3098uaArr2 = interfaceC3098uaArr;
                iArr3 = iArr2;
                i = -1;
                z = true;
                i5 = 0;
            }
            i9 = i2 + 1;
            interfaceC3142vrArr2 = interfaceC3142vrArr;
            interfaceC3098uaArr2 = interfaceC3098uaArr;
            iArr3 = iArr2;
            i = -1;
            z = true;
            i5 = 0;
        }
        int[] iArr5 = iArr3;
        int i14 = 0;
        while (i14 < interfaceC3142vrArr.length) {
            if (interfaceC3098uaArr[i14] != null || interfaceC3142vrArr[i14] == null) {
                iArr = iArr5;
            } else {
                iArr = iArr5;
                C2838kk c2838kk2 = this.f7870j[iArr[i14]];
                if (c2838kk2.f7856c == 1) {
                    int m1779r2 = m1779r(i14, iArr);
                    if (m1779r2 == -1) {
                        interfaceC3098uaArr[i14] = new C3055sl();
                    } else {
                        interfaceC3098uaArr[i14] = ((C3117ut) interfaceC3098uaArr[m1779r2]).m881i(j, c2838kk2.f7855b);
                    }
                    i14++;
                    iArr5 = iArr;
                }
            }
            i14++;
            iArr5 = iArr;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (InterfaceC3098ua interfaceC3098ua6 : interfaceC3098uaArr) {
            if (interfaceC3098ua6 instanceof C3117ut) {
                arrayList2.add((C3117ut) interfaceC3098ua6);
            } else if (interfaceC3098ua6 instanceof C2857lc) {
                arrayList3.add((C2857lc) interfaceC3098ua6);
            }
        }
        C3117ut[] c3117utArr = new C3117ut[arrayList2.size()];
        this.f7876p = c3117utArr;
        arrayList2.toArray(c3117utArr);
        C2857lc[] c2857lcArr = new C2857lc[arrayList3.size()];
        this.f7877q = c2857lcArr;
        arrayList3.toArray(c2857lcArr);
        this.f7878r = C3161wj.m735f(this.f7876p);
        return j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3099ub
    /* renamed from: g */
    public final /* bridge */ /* synthetic */ void mo934g(InterfaceC3100uc interfaceC3100uc) {
        this.f7875o.mo934g(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: h */
    public final C2588bd mo1025h() {
        return this.f7869i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: i */
    public final void mo1024i() throws IOException {
        this.f7868h.mo715a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3116us
    /* renamed from: j */
    public final synchronized void mo892j(C3117ut c3117ut) {
        C2860lf c2860lf = (C2860lf) this.f7872l.remove(c3117ut);
        if (c2860lf != null) {
            c2860lf.m1723d();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: k */
    public final void mo1022k(InterfaceC3065sv interfaceC3065sv, long j) {
        this.f7875o = interfaceC3065sv;
        interfaceC3065sv.mo1104bd(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: l */
    public final void mo878l(long j) {
        this.f7878r.mo878l(j);
    }

    /* renamed from: m */
    public final void m1781m() {
        this.f7871k.m1718d();
        for (C3117ut c3117ut : this.f7876p) {
            c3117ut.m879k(this);
        }
        this.f7875o = null;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.google.ads.interactivemedia.v3.internal.ki, com.google.ads.interactivemedia.v3.internal.uu] */
    /* renamed from: n */
    public final void m1780n(C2864lj c2864lj, int i) {
        C2857lc[] c2857lcArr;
        this.f7879s = c2864lj;
        this.f7880t = i;
        this.f7871k.m1717e(c2864lj);
        C3117ut[] c3117utArr = this.f7876p;
        if (c3117utArr != null) {
            for (C3117ut c3117ut : c3117utArr) {
                c3117ut.m880j().mo1733a(c2864lj, i);
            }
            this.f7875o.mo934g(this);
        }
        this.f7881u = c2864lj.m1709d(i).f8043d;
        for (C2857lc c2857lc : this.f7877q) {
            Iterator it = this.f7881u.iterator();
            while (true) {
                if (it.hasNext()) {
                    C2868ln c2868ln = (C2868ln) it.next();
                    if (c2868ln.m1679a().equals(c2857lc.m1727c())) {
                        c2857lc.m1725f(c2868ln, c2864lj.f8011d && i == c2864lj.m1712a() + (-1));
                    }
                }
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: o */
    public final boolean mo875o(long j) {
        return this.f7878r.mo875o(j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3100uc
    /* renamed from: p */
    public final boolean mo874p() {
        return this.f7878r.mo874p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3066sw
    /* renamed from: q */
    public final void mo1020q(long j) {
        for (C3117ut c3117ut : this.f7876p) {
            c3117ut.m870u(j);
        }
    }
}

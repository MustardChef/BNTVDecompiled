package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.adm */
/* loaded from: classes2.dex */
final class adm {

    /* renamed from: a */
    private boolean f3418a;

    /* renamed from: b */
    private boolean f3419b;

    /* renamed from: c */
    private C3244zl f3420c;

    /* renamed from: d */
    private int f3421d;

    /* renamed from: e */
    private int f3422e;

    /* renamed from: f */
    private int f3423f;

    /* renamed from: g */
    private int f3424g;

    /* renamed from: h */
    private boolean f3425h;

    /* renamed from: i */
    private boolean f3426i;

    /* renamed from: j */
    private boolean f3427j;

    /* renamed from: k */
    private boolean f3428k;

    /* renamed from: l */
    private int f3429l;

    /* renamed from: m */
    private int f3430m;

    /* renamed from: n */
    private int f3431n;

    /* renamed from: o */
    private int f3432o;

    /* renamed from: p */
    private int f3433p;

    private adm() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ adm(byte[] bArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* bridge */ /* synthetic */ boolean m5789d(adm admVar, adm admVar2) {
        int i;
        int i2;
        int i3;
        boolean z;
        if (admVar.f3418a) {
            if (admVar2.f3418a) {
                C3244zl c3244zl = admVar.f3420c;
                C2616ce.m2688e(c3244zl);
                C3244zl c3244zl2 = admVar2.f3420c;
                C2616ce.m2688e(c3244zl2);
                return (admVar.f3423f == admVar2.f3423f && admVar.f3424g == admVar2.f3424g && admVar.f3425h == admVar2.f3425h && (!admVar.f3426i || !admVar2.f3426i || admVar.f3427j == admVar2.f3427j) && (((i = admVar.f3421d) == (i2 = admVar2.f3421d) || (i != 0 && i2 != 0)) && ((i3 = c3244zl.f9599k) != 0 ? !(i3 == 1 && c3244zl2.f9599k == 1 && (admVar.f3432o != admVar2.f3432o || admVar.f3433p != admVar2.f3433p)) : c3244zl2.f9599k != 0 || (admVar.f3430m == admVar2.f3430m && admVar.f3431n == admVar2.f3431n)) && (z = admVar.f3428k) == admVar2.f3428k && (!z || admVar.f3429l == admVar2.f3429l))) ? false : true;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final void m5792a() {
        this.f3419b = false;
        this.f3418a = false;
    }

    /* renamed from: b */
    public final void m5791b(C3244zl c3244zl, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
        this.f3420c = c3244zl;
        this.f3421d = i;
        this.f3422e = i2;
        this.f3423f = i3;
        this.f3424g = i4;
        this.f3425h = z;
        this.f3426i = z2;
        this.f3427j = z3;
        this.f3428k = z4;
        this.f3429l = i5;
        this.f3430m = i6;
        this.f3431n = i7;
        this.f3432o = i8;
        this.f3433p = i9;
        this.f3418a = true;
        this.f3419b = true;
    }

    /* renamed from: c */
    public final void m5790c(int i) {
        this.f3422e = i;
        this.f3419b = true;
    }

    /* renamed from: e */
    public final boolean m5788e() {
        int i;
        return this.f3419b && ((i = this.f3422e) == 7 || i == 2);
    }
}

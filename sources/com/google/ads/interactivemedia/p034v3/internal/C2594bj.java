package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bj */
/* loaded from: classes2.dex */
public class C2594bj {

    /* renamed from: a */
    public static final C2594bj f5840a = new C2594bj(new C2593bi());

    /* renamed from: b */
    public final int f5841b;

    /* renamed from: c */
    public final int f5842c;

    /* renamed from: d */
    public final int f5843d;

    /* renamed from: e */
    public final int f5844e;

    /* renamed from: f */
    public final int f5845f;

    /* renamed from: g */
    public final int f5846g;

    /* renamed from: h */
    public final int f5847h;

    /* renamed from: i */
    public final int f5848i;

    /* renamed from: j */
    public final int f5849j;

    /* renamed from: k */
    public final int f5850k;

    /* renamed from: l */
    public final boolean f5851l;

    /* renamed from: m */
    public final avg f5852m;

    /* renamed from: n */
    public final avg f5853n;

    /* renamed from: o */
    public final int f5854o;

    /* renamed from: p */
    public final int f5855p;

    /* renamed from: q */
    public final int f5856q;

    /* renamed from: r */
    public final avg f5857r;

    /* renamed from: s */
    public final avg f5858s;

    /* renamed from: t */
    public final int f5859t;

    /* renamed from: u */
    public final boolean f5860u;

    /* renamed from: v */
    public final boolean f5861v;

    /* renamed from: w */
    public final boolean f5862w;

    /* renamed from: x */
    public final C2592bh f5863x;

    /* renamed from: y */
    public final avo f5864y;

    /* JADX INFO: Access modifiers changed from: protected */
    public C2594bj(C2593bi c2593bi) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        avg avgVar;
        avg avgVar2;
        int i7;
        int i8;
        avg avgVar3;
        avg avgVar4;
        int i9;
        C2592bh c2592bh;
        avo avoVar;
        i = c2593bi.f5766a;
        this.f5841b = i;
        i2 = c2593bi.f5767b;
        this.f5842c = i2;
        i3 = c2593bi.f5768c;
        this.f5843d = i3;
        i4 = c2593bi.f5769d;
        this.f5844e = i4;
        this.f5845f = 0;
        this.f5846g = 0;
        this.f5847h = 0;
        this.f5848i = 0;
        i5 = c2593bi.f5770e;
        this.f5849j = i5;
        i6 = c2593bi.f5771f;
        this.f5850k = i6;
        z = c2593bi.f5772g;
        this.f5851l = z;
        avgVar = c2593bi.f5773h;
        this.f5852m = avgVar;
        avgVar2 = c2593bi.f5774i;
        this.f5853n = avgVar2;
        this.f5854o = 0;
        i7 = c2593bi.f5775j;
        this.f5855p = i7;
        i8 = c2593bi.f5776k;
        this.f5856q = i8;
        avgVar3 = c2593bi.f5777l;
        this.f5857r = avgVar3;
        avgVar4 = c2593bi.f5778m;
        this.f5858s = avgVar4;
        i9 = c2593bi.f5779n;
        this.f5859t = i9;
        this.f5860u = false;
        this.f5861v = false;
        this.f5862w = false;
        c2592bh = c2593bi.f5780o;
        this.f5863x = c2592bh;
        avoVar = c2593bi.f5781p;
        this.f5864y = avoVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2594bj c2594bj = (C2594bj) obj;
            if (this.f5841b == c2594bj.f5841b && this.f5842c == c2594bj.f5842c && this.f5843d == c2594bj.f5843d && this.f5844e == c2594bj.f5844e && this.f5851l == c2594bj.f5851l && this.f5849j == c2594bj.f5849j && this.f5850k == c2594bj.f5850k && this.f5852m.equals(c2594bj.f5852m) && this.f5853n.equals(c2594bj.f5853n) && this.f5855p == c2594bj.f5855p && this.f5856q == c2594bj.f5856q && this.f5857r.equals(c2594bj.f5857r) && this.f5858s.equals(c2594bj.f5858s) && this.f5859t == c2594bj.f5859t && this.f5863x.equals(c2594bj.f5863x) && this.f5864y.equals(c2594bj.f5864y)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((this.f5841b + 31) * 31) + this.f5842c) * 31) + this.f5843d) * 31) + this.f5844e) * 28629151) + (this.f5851l ? 1 : 0)) * 31) + this.f5849j) * 31) + this.f5850k) * 31) + this.f5852m.hashCode()) * 31) + this.f5853n.hashCode()) * 961) + this.f5855p) * 31) + this.f5856q) * 31) + this.f5857r.hashCode()) * 31) + this.f5858s.hashCode()) * 31) + this.f5859t) * 923521) + this.f5863x.hashCode()) * 31) + this.f5864y.hashCode();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abn */
/* loaded from: classes2.dex */
public final class abn implements InterfaceC3229yx {

    /* renamed from: a */
    private final int f3074a;

    /* renamed from: b */
    private final long f3075b;

    /* renamed from: c */
    private final C2621cj f3076c;

    /* renamed from: d */
    private final C3240zh f3077d;

    /* renamed from: e */
    private final C3237ze f3078e;

    /* renamed from: f */
    private final C3239zg f3079f;

    /* renamed from: g */
    private final InterfaceC3253zu f3080g;

    /* renamed from: h */
    private InterfaceC3233za f3081h;

    /* renamed from: i */
    private InterfaceC3253zu f3082i;

    /* renamed from: j */
    private InterfaceC3253zu f3083j;

    /* renamed from: k */
    private int f3084k;

    /* renamed from: l */
    private C2549ak f3085l;

    /* renamed from: m */
    private long f3086m;

    /* renamed from: n */
    private long f3087n;

    /* renamed from: o */
    private long f3088o;

    /* renamed from: p */
    private int f3089p;

    /* renamed from: q */
    private abo f3090q;

    /* renamed from: r */
    private boolean f3091r;

    /* renamed from: s */
    private long f3092s;

    static {
        abm abmVar = abm.f3073a;
    }

    public abn() {
        this((byte[]) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015c  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int m5902g(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 633
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.abn.m5902g(com.google.ads.interactivemedia.v3.internal.yy):int");
    }

    /* renamed from: h */
    private final long m5901h(long j) {
        return this.f3086m + ((j * 1000000) / this.f3077d.f9566d);
    }

    /* renamed from: i */
    private static boolean m5900i(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    /* renamed from: j */
    private final boolean m5899j(InterfaceC3230yy interfaceC3230yy) throws IOException {
        abo aboVar = this.f3090q;
        if (aboVar != null) {
            long mo449a = aboVar.mo449a();
            if (mo449a != -1 && interfaceC3230yy.mo499c() > mo449a - 4) {
                return true;
            }
        }
        try {
            return !interfaceC3230yy.mo492k(this.f3076c.m2642H(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* renamed from: k */
    private final boolean m5898k(InterfaceC3230yy interfaceC3230yy, boolean z) throws IOException {
        int i;
        int i2;
        int m478b;
        int i3 = true != z ? 131072 : 32768;
        interfaceC3230yy.mo494h();
        if (interfaceC3230yy.mo498d() == 0) {
            C2549ak m481a = this.f3079f.m481a(interfaceC3230yy, null);
            this.f3085l = m481a;
            if (m481a != null) {
                this.f3078e.m484b(m481a);
            }
            i2 = (int) interfaceC3230yy.mo499c();
            if (!z) {
                interfaceC3230yy.mo493i(i2);
            }
            i = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!m5899j(interfaceC3230yy)) {
                this.f3076c.m2644F(0);
                int m2637e = this.f3076c.m2637e();
                if ((i == 0 || m5900i(m2637e, i)) && (m478b = C3241zi.m478b(m2637e)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.f3077d.m480a(m2637e);
                        i = m2637e;
                    }
                    interfaceC3230yy.mo497e(m478b - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == i3) {
                        if (z) {
                            return false;
                        }
                        throw C2555ao.m4866a("Searched too many bytes.", null);
                    }
                    if (z) {
                        interfaceC3230yy.mo494h();
                        interfaceC3230yy.mo497e(i2 + i6);
                    } else {
                        interfaceC3230yy.mo493i(1);
                    }
                    i5 = i6;
                    i = 0;
                    i4 = 0;
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            interfaceC3230yy.mo493i(i2 + i5);
        } else {
            interfaceC3230yy.mo494h();
        }
        this.f3084k = i;
        return true;
    }

    /* renamed from: l */
    private final abo m5897l(InterfaceC3230yy interfaceC3230yy) throws IOException {
        interfaceC3230yy.mo496f(this.f3076c.m2642H(), 0, 4);
        this.f3076c.m2644F(0);
        this.f3077d.m480a(this.f3076c.m2637e());
        return new abj(interfaceC3230yy.mo500b(), interfaceC3230yy.mo498d(), this.f3077d);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    public final boolean mo433D(InterfaceC3230yy interfaceC3230yy) throws IOException {
        return m5898k(interfaceC3230yy, true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        C2616ce.m2688e(this.f3082i);
        int i = C2628cq.f6961a;
        int m5902g = m5902g(interfaceC3230yy);
        if (m5902g == -1 && (this.f3090q instanceof abk)) {
            if (this.f3090q.mo447e() != m5901h(this.f3087n)) {
                abk abkVar = (abk) this.f3090q;
                throw null;
            }
        }
        return m5902g;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f3081h = interfaceC3233za;
        InterfaceC3253zu mo489be = interfaceC3233za.mo489be(0, 1);
        this.f3082i = mo489be;
        this.f3083j = mo489be;
        this.f3081h.mo488m();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        this.f3084k = 0;
        this.f3086m = C3282C.TIME_UNSET;
        this.f3087n = 0L;
        this.f3089p = 0;
        this.f3092s = j2;
        abo aboVar = this.f3090q;
        if (aboVar instanceof abk) {
            abk abkVar = (abk) aboVar;
            throw null;
        }
    }

    /* renamed from: f */
    public final void m5903f() {
        this.f3091r = true;
    }

    public abn(byte[] bArr) {
        this((long) C3282C.TIME_UNSET);
    }

    public abn(long j) {
        this.f3074a = 0;
        this.f3075b = j;
        this.f3076c = new C2621cj(10);
        this.f3077d = new C3240zh();
        this.f3078e = new C3237ze();
        this.f3086m = C3282C.TIME_UNSET;
        this.f3079f = new C3239zg();
        C3228yw c3228yw = new C3228yw();
        this.f3080g = c3228yw;
        this.f3083j = c3228yw;
    }
}

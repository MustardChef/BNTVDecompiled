package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.afb */
/* loaded from: classes2.dex */
public final class afb extends bnd implements bok {

    /* renamed from: a */
    private static final afb f3659a;

    /* renamed from: e */
    private int f3660e;

    /* renamed from: g */
    private long f3662g;

    /* renamed from: k */
    private long f3666k;

    /* renamed from: l */
    private long f3667l;

    /* renamed from: n */
    private long f3669n;

    /* renamed from: r */
    private int f3673r;

    /* renamed from: f */
    private String f3661f = "";

    /* renamed from: h */
    private String f3663h = "";

    /* renamed from: i */
    private String f3664i = "";

    /* renamed from: j */
    private String f3665j = "";

    /* renamed from: m */
    private String f3668m = "";

    /* renamed from: o */
    private String f3670o = "";

    /* renamed from: p */
    private String f3671p = "";

    /* renamed from: q */
    private bnj f3672q = m3277az();

    static {
        afb afbVar = new afb();
        f3659a = afbVar;
        bnd.m3290aD(afb.class, afbVar);
    }

    private afb() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m5671b(afb afbVar, long j) {
        afbVar.f3660e |= 2;
        afbVar.f3662g = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m5670c(afb afbVar, String str) {
        str.getClass();
        afbVar.f3660e |= 4;
        afbVar.f3663h = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static /* synthetic */ void m5669d(afb afbVar, String str) {
        str.getClass();
        afbVar.f3660e |= 8;
        afbVar.f3664i = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ void m5668e(afb afbVar, String str) {
        afbVar.f3660e |= 16;
        afbVar.f3665j = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ void m5667f(afb afbVar, String str) {
        afbVar.f3660e |= 1024;
        afbVar.f3671p = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ void m5666g(afb afbVar, String str) {
        str.getClass();
        afbVar.f3660e |= 1;
        afbVar.f3661f = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static /* synthetic */ void m5665h(afb afbVar, int i) {
        afbVar.f3673r = afa.m5674b(i);
        afbVar.f3660e |= 2048;
    }

    /* renamed from: j */
    public static afc m5664j() {
        return (afc) f3659a.m3283at();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnd
    /* renamed from: i */
    protected final Object mo2732i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return f3659a;
                    }
                    return new afc((byte[]) null, (int[]) null);
                }
                return new afb();
            }
            return m3291aC(f3659a, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", TtmlNode.TAG_P, "q", aey.class, "r", afa.m5675a()});
        }
        return (byte) 1;
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.apk */
/* loaded from: classes2.dex */
public final class apk extends bnd implements bok {

    /* renamed from: a */
    private static final apk f4848a;

    /* renamed from: e */
    private int f4849e;

    /* renamed from: f */
    private String f4850f = "";

    /* renamed from: g */
    private String f4851g = "";

    /* renamed from: h */
    private long f4852h;

    /* renamed from: i */
    private long f4853i;

    /* renamed from: j */
    private long f4854j;

    static {
        apk apkVar = new apk();
        f4848a = apkVar;
        bnd.m3290aD(apk.class, apkVar);
    }

    private apk() {
    }

    /* renamed from: d */
    public static apj m4826d() {
        return (apj) f4848a.m3283at();
    }

    /* renamed from: f */
    public static apk m4824f() {
        return f4848a;
    }

    /* renamed from: g */
    public static apk m4823g(bls blsVar) throws bnm {
        return (apk) bnd.m3281av(f4848a, blsVar);
    }

    /* renamed from: h */
    public static apk m4822h(bls blsVar, bmr bmrVar) throws bnm {
        return (apk) bnd.m3280aw(f4848a, blsVar, bmrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static /* synthetic */ void m4819l(apk apkVar, String str) {
        str.getClass();
        apkVar.f4849e |= 1;
        apkVar.f4850f = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static /* synthetic */ void m4818m(apk apkVar, long j) {
        apkVar.f4849e |= 16;
        apkVar.f4854j = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static /* synthetic */ void m4817n(apk apkVar, String str) {
        str.getClass();
        apkVar.f4849e |= 2;
        apkVar.f4851g = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static /* synthetic */ void m4816o(apk apkVar, long j) {
        apkVar.f4849e |= 4;
        apkVar.f4852h = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static /* synthetic */ void m4815p(apk apkVar, long j) {
        apkVar.f4849e |= 8;
        apkVar.f4853i = j;
    }

    /* renamed from: a */
    public final long m4829a() {
        return this.f4853i;
    }

    /* renamed from: b */
    public final long m4828b() {
        return this.f4852h;
    }

    /* renamed from: c */
    public final long m4827c() {
        return this.f4854j;
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
                        return f4848a;
                    }
                    return new apj(null);
                }
                return new apk();
            }
            return m3291aC(f4848a, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"e", "f", "g", "h", "i", "j"});
        }
        return (byte) 1;
    }

    /* renamed from: j */
    public final String m4821j() {
        return this.f4851g;
    }

    /* renamed from: k */
    public final String m4820k() {
        return this.f4850f;
    }
}

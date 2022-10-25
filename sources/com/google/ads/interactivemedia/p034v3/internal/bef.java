package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bef */
/* loaded from: classes2.dex */
public final class bef extends bnd implements bok {

    /* renamed from: a */
    private static final bef f5563a;

    /* renamed from: e */
    private beb f5564e;

    /* renamed from: f */
    private int f5565f;

    /* renamed from: g */
    private int f5566g;

    /* renamed from: h */
    private int f5567h;

    static {
        bef befVar = new bef();
        f5563a = befVar;
        bnd.m3290aD(bef.class, befVar);
    }

    private bef() {
    }

    /* renamed from: a */
    public final int m3922a() {
        return this.f5566g;
    }

    /* renamed from: b */
    public final beb m3921b() {
        beb bebVar = this.f5564e;
        return bebVar == null ? beb.m3947b() : bebVar;
    }

    /* renamed from: d */
    public final boolean m3919d() {
        return this.f5564e != null;
    }

    /* renamed from: e */
    public final int m3918e() {
        int m3938b = bec.m3938b(this.f5565f);
        return m3938b == 0 ? bec.f5551e : m3938b;
    }

    /* renamed from: f */
    public final int m3917f() {
        int m3875b = ben.m3875b(this.f5567h);
        return m3875b == 0 ? ben.f5595f : m3875b;
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
                        return f5563a;
                    }
                    return new bep((byte[]) null, (short[]) null);
                }
                return new bef();
            }
            return m3291aC(f5563a, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"e", "f", "g", "h"});
        }
        return (byte) 1;
    }
}

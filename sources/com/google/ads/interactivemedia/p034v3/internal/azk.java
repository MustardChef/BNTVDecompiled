package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azk */
/* loaded from: classes2.dex */
public final class azk {

    /* renamed from: a */
    private final bed f5323a;

    private azk(bed bedVar) {
        this.f5323a = bedVar;
    }

    /* renamed from: d */
    public static azk m4274d(String str, byte[] bArr, int i) {
        int i2;
        bep m3929j = bed.m3929j();
        m3929j.m3811m(str);
        m3929j.m3810n(bls.m3504t(bArr));
        int i3 = ben.f5590a;
        int i4 = i - 1;
        if (i4 != 0) {
            i2 = i4 != 1 ? ben.f5593d : ben.f5592c;
        } else {
            i2 = ben.f5591b;
        }
        m3929j.m3809o(i2);
        return new azk((bed) m3929j.mo3179aR());
    }

    /* renamed from: a */
    public final String m4277a() {
        return this.f5323a.m3934d();
    }

    /* renamed from: b */
    public final byte[] m4276b() {
        return this.f5323a.m3935c().m3509C();
    }

    /* renamed from: c */
    public final int m4275c() {
        int m3931g = this.f5323a.m3931g();
        int i = m3931g - 2;
        int i2 = ben.f5590a;
        if (m3931g != 0) {
            int i3 = 1;
            if (i != 1) {
                i3 = 2;
                if (i != 2) {
                    i3 = 3;
                    if (i != 3) {
                        if (i == 4) {
                            return 4;
                        }
                        throw new IllegalArgumentException("Unknown output prefix type");
                    }
                }
            }
            return i3;
        }
        throw null;
    }
}

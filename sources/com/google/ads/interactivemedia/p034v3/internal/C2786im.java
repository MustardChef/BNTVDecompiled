package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.im */
/* loaded from: classes2.dex */
public final class C2786im {

    /* renamed from: a */
    public final long f7600a;

    /* renamed from: b */
    public final AbstractC2586bb f7601b;

    /* renamed from: c */
    public final int f7602c;

    /* renamed from: d */
    public final C3067sx f7603d;

    /* renamed from: e */
    public final long f7604e;

    /* renamed from: f */
    public final AbstractC2586bb f7605f;

    /* renamed from: g */
    public final int f7606g;

    /* renamed from: h */
    public final C3067sx f7607h;

    /* renamed from: i */
    public final long f7608i;

    /* renamed from: j */
    public final long f7609j;

    public C2786im(long j, AbstractC2586bb abstractC2586bb, int i, C3067sx c3067sx, long j2, AbstractC2586bb abstractC2586bb2, int i2, C3067sx c3067sx2, long j3, long j4) {
        this.f7600a = j;
        this.f7601b = abstractC2586bb;
        this.f7602c = i;
        this.f7603d = c3067sx;
        this.f7604e = j2;
        this.f7605f = abstractC2586bb2;
        this.f7606g = i2;
        this.f7607h = c3067sx2;
        this.f7608i = j3;
        this.f7609j = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2786im c2786im = (C2786im) obj;
            if (this.f7600a == c2786im.f7600a && this.f7602c == c2786im.f7602c && this.f7604e == c2786im.f7604e && this.f7606g == c2786im.f7606g && this.f7608i == c2786im.f7608i && this.f7609j == c2786im.f7609j && anx.m4882b(this.f7601b, c2786im.f7601b) && anx.m4882b(this.f7603d, c2786im.f7603d) && anx.m4882b(this.f7605f, c2786im.f7605f) && anx.m4882b(this.f7607h, c2786im.f7607h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f7600a), this.f7601b, Integer.valueOf(this.f7602c), this.f7603d, Long.valueOf(this.f7604e), this.f7605f, Integer.valueOf(this.f7606g), this.f7607h, Long.valueOf(this.f7608i), Long.valueOf(this.f7609j)});
    }
}

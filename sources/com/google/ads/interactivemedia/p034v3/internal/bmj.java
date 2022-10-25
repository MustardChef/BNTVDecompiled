package com.google.ads.interactivemedia.p034v3.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmj */
/* loaded from: classes2.dex */
public final class bmj extends bnb implements bok {

    /* renamed from: e */
    private static final bmj f6102e;

    /* renamed from: A */
    private boolean f6103A;

    /* renamed from: B */
    private boolean f6104B;

    /* renamed from: C */
    private boolean f6105C;

    /* renamed from: D */
    private boolean f6106D;

    /* renamed from: M */
    private boolean f6115M;

    /* renamed from: O */
    private boolean f6117O;

    /* renamed from: f */
    private int f6120f;

    /* renamed from: g */
    private int f6121g;

    /* renamed from: o */
    private boolean f6129o;

    /* renamed from: q */
    private boolean f6131q;

    /* renamed from: r */
    private boolean f6132r;

    /* renamed from: s */
    private boolean f6133s;

    /* renamed from: z */
    private boolean f6140z;

    /* renamed from: Q */
    private byte f6119Q = 2;

    /* renamed from: h */
    private int f6122h = 2;

    /* renamed from: i */
    private boolean f6123i = true;

    /* renamed from: j */
    private String f6124j = "";

    /* renamed from: k */
    private int f6125k = 2;

    /* renamed from: l */
    private boolean f6126l = true;

    /* renamed from: m */
    private boolean f6127m = true;

    /* renamed from: n */
    private String f6128n = "";

    /* renamed from: p */
    private String f6130p = "";

    /* renamed from: t */
    private String f6134t = "";

    /* renamed from: u */
    private int f6135u = 1;

    /* renamed from: v */
    private String f6136v = "";

    /* renamed from: w */
    private String f6137w = "";

    /* renamed from: x */
    private String f6138x = "";

    /* renamed from: y */
    private int f6139y = 2;

    /* renamed from: E */
    private boolean f6107E = true;

    /* renamed from: F */
    private String f6108F = "";

    /* renamed from: G */
    private String f6109G = "";

    /* renamed from: H */
    private String f6110H = "";

    /* renamed from: I */
    private String f6111I = "";

    /* renamed from: J */
    private String f6112J = "";

    /* renamed from: K */
    private String f6113K = "";

    /* renamed from: L */
    private String f6114L = "";

    /* renamed from: N */
    private boolean f6116N = true;

    /* renamed from: P */
    private bnj f6118P = bor.m3116e();

    static {
        bmj bmjVar = new bmj();
        f6102e = bmjVar;
        bnd.m3290aD(bmj.class, bmjVar);
    }

    private bmj() {
    }

    /* renamed from: e */
    public static bmj m3351e() {
        return f6102e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnd
    /* renamed from: i */
    protected final Object mo2732i(int i, Object obj) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return f6102e;
                        }
                        this.f6119Q = obj == null ? (byte) 0 : (byte) 1;
                        return null;
                    }
                    return new bmh(null);
                }
                return new bmj();
            }
            return m3291aC(f6102e, "\u0001#\u0000\u0002\u0001ϧ#\u0000\u0001\u0001\u0001ဈ\u0002\u0002င\u0000\u0005င\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဈ\b\tဌ\r\nဇ\t\u000bဈ\u000e\fဈ\u0010\u000eင\u0011\u0010ဇ\u0012\u0011ဇ\u0013\u0012ဇ\u0014\u0013ဈ\u0006\u0017ဇ\u0016\u0018ဇ\u0001\u001aဇ\u0007\u001bဇ\n\u001cဇ\u000b\u001dဈ\f\u001fဇ\u0017$ဈ\u0018%ဈ\u0019'ဈ\u001a(ဈ\u001b)ဈ\u001c*ဇ\u0015,ဈ\u001d-ဈ\u001e.ဈ\u000f/ဇ\u001f0ဇ 1ဇ!ϧЛ", new Object[]{"f", "g", "j", "h", "k", "l", "m", TtmlNode.TAG_P, "u", bmi.m3354a(), "q", "v", "x", "y", "z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "n", "D", "i", "o", "r", "s", "t", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "C", "K", "L", "w", "M", "N", "O", "P", bmn.class});
        }
        return Byte.valueOf(this.f6119Q);
    }
}

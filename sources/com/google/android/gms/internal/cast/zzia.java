package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzia implements zzou {
    SUBTYPE_UNKNOWN(0),
    GPRS(1),
    EDGE(2),
    UMTS(3),
    CDMA(4),
    EVDO_0(5),
    EVDO_A(6),
    SUBTYPE_1XRTT(7),
    HSDPA(8),
    HSUPA(9),
    HSPA(10),
    IDEN(11),
    EVDO_B(12),
    LTE(13),
    EHRPD(14),
    HSPAP(15),
    GSM(16),
    TD_SCDMA(17),
    IWLAN(18);
    
    private static final zzov<zzia> zzt = new zzov<zzia>() { // from class: com.google.android.gms.internal.cast.zzhy
    };
    private final int zzu;

    zzia(int i) {
        this.zzu = i;
    }

    public static zzow zza() {
        return zzhz.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzu + " name=" + name() + Typography.greater;
    }
}

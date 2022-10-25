package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzrm {
    DOUBLE(zzrn.DOUBLE, 1),
    FLOAT(zzrn.FLOAT, 5),
    INT64(zzrn.LONG, 0),
    UINT64(zzrn.LONG, 0),
    INT32(zzrn.INT, 0),
    FIXED64(zzrn.LONG, 1),
    FIXED32(zzrn.INT, 5),
    BOOL(zzrn.BOOLEAN, 0),
    STRING(zzrn.STRING, 2),
    GROUP(zzrn.MESSAGE, 3),
    MESSAGE(zzrn.MESSAGE, 2),
    BYTES(zzrn.BYTE_STRING, 2),
    UINT32(zzrn.INT, 0),
    ENUM(zzrn.ENUM, 0),
    SFIXED32(zzrn.INT, 5),
    SFIXED64(zzrn.LONG, 1),
    SINT32(zzrn.INT, 0),
    SINT64(zzrn.LONG, 0);
    
    private final zzrn zzs;

    zzrm(zzrn zzrnVar, int i) {
        this.zzs = zzrnVar;
    }

    public final zzrn zza() {
        return this.zzs;
    }
}

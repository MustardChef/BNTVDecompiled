package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacj */
/* loaded from: classes3.dex */
public enum zzacj {
    DOUBLE(zzack.DOUBLE, 1),
    FLOAT(zzack.FLOAT, 5),
    INT64(zzack.LONG, 0),
    UINT64(zzack.LONG, 0),
    INT32(zzack.INT, 0),
    FIXED64(zzack.LONG, 1),
    FIXED32(zzack.INT, 5),
    BOOL(zzack.BOOLEAN, 0),
    STRING(zzack.STRING, 2),
    GROUP(zzack.MESSAGE, 3),
    MESSAGE(zzack.MESSAGE, 2),
    BYTES(zzack.BYTE_STRING, 2),
    UINT32(zzack.INT, 0),
    ENUM(zzack.ENUM, 0),
    SFIXED32(zzack.INT, 5),
    SFIXED64(zzack.LONG, 1),
    SINT32(zzack.INT, 0),
    SINT64(zzack.LONG, 0);
    
    private final zzack zzs;

    zzacj(zzack zzackVar, int i) {
        this.zzs = zzackVar;
    }

    public final zzack zza() {
        return this.zzs;
    }
}

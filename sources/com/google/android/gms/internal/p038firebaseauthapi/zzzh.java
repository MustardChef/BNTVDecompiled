package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzh */
/* loaded from: classes3.dex */
public enum zzzh {
    DOUBLE(0, 1, zzzx.DOUBLE),
    FLOAT(1, 1, zzzx.FLOAT),
    INT64(2, 1, zzzx.LONG),
    UINT64(3, 1, zzzx.LONG),
    INT32(4, 1, zzzx.INT),
    FIXED64(5, 1, zzzx.LONG),
    FIXED32(6, 1, zzzx.INT),
    BOOL(7, 1, zzzx.BOOLEAN),
    STRING(8, 1, zzzx.STRING),
    MESSAGE(9, 1, zzzx.MESSAGE),
    BYTES(10, 1, zzzx.BYTE_STRING),
    UINT32(11, 1, zzzx.INT),
    ENUM(12, 1, zzzx.ENUM),
    SFIXED32(13, 1, zzzx.INT),
    SFIXED64(14, 1, zzzx.LONG),
    SINT32(15, 1, zzzx.INT),
    SINT64(16, 1, zzzx.LONG),
    GROUP(17, 1, zzzx.MESSAGE),
    DOUBLE_LIST(18, 2, zzzx.DOUBLE),
    FLOAT_LIST(19, 2, zzzx.FLOAT),
    INT64_LIST(20, 2, zzzx.LONG),
    UINT64_LIST(21, 2, zzzx.LONG),
    INT32_LIST(22, 2, zzzx.INT),
    FIXED64_LIST(23, 2, zzzx.LONG),
    FIXED32_LIST(24, 2, zzzx.INT),
    BOOL_LIST(25, 2, zzzx.BOOLEAN),
    STRING_LIST(26, 2, zzzx.STRING),
    MESSAGE_LIST(27, 2, zzzx.MESSAGE),
    BYTES_LIST(28, 2, zzzx.BYTE_STRING),
    UINT32_LIST(29, 2, zzzx.INT),
    ENUM_LIST(30, 2, zzzx.ENUM),
    SFIXED32_LIST(31, 2, zzzx.INT),
    SFIXED64_LIST(32, 2, zzzx.LONG),
    SINT32_LIST(33, 2, zzzx.INT),
    SINT64_LIST(34, 2, zzzx.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzzx.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzzx.FLOAT),
    INT64_LIST_PACKED(37, 3, zzzx.LONG),
    UINT64_LIST_PACKED(38, 3, zzzx.LONG),
    INT32_LIST_PACKED(39, 3, zzzx.INT),
    FIXED64_LIST_PACKED(40, 3, zzzx.LONG),
    FIXED32_LIST_PACKED(41, 3, zzzx.INT),
    BOOL_LIST_PACKED(42, 3, zzzx.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzzx.INT),
    ENUM_LIST_PACKED(44, 3, zzzx.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzzx.INT),
    SFIXED64_LIST_PACKED(46, 3, zzzx.LONG),
    SINT32_LIST_PACKED(47, 3, zzzx.INT),
    SINT64_LIST_PACKED(48, 3, zzzx.LONG),
    GROUP_LIST(49, 2, zzzx.MESSAGE),
    MAP(50, 4, zzzx.VOID);
    
    private static final zzzh[] zzac;
    private final zzzx zzZ;
    private final int zzaa;
    private final Class<?> zzab;

    static {
        zzzh[] values = values();
        zzac = new zzzh[values.length];
        for (zzzh zzzhVar : values) {
            zzac[zzzhVar.zzaa] = zzzhVar;
        }
    }

    zzzh(int i, int i2, zzzx zzzxVar) {
        this.zzaa = i;
        this.zzZ = zzzxVar;
        zzzx zzzxVar2 = zzzx.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzab = zzzxVar.zza();
        } else if (i3 != 3) {
            this.zzab = null;
        } else {
            this.zzab = zzzxVar.zza();
        }
        if (i2 == 1) {
            zzzxVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzaa;
    }
}

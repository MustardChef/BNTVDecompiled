package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzon {
    DOUBLE(0, 1, zzpe.DOUBLE),
    FLOAT(1, 1, zzpe.FLOAT),
    INT64(2, 1, zzpe.LONG),
    UINT64(3, 1, zzpe.LONG),
    INT32(4, 1, zzpe.INT),
    FIXED64(5, 1, zzpe.LONG),
    FIXED32(6, 1, zzpe.INT),
    BOOL(7, 1, zzpe.BOOLEAN),
    STRING(8, 1, zzpe.STRING),
    MESSAGE(9, 1, zzpe.MESSAGE),
    BYTES(10, 1, zzpe.BYTE_STRING),
    UINT32(11, 1, zzpe.INT),
    ENUM(12, 1, zzpe.ENUM),
    SFIXED32(13, 1, zzpe.INT),
    SFIXED64(14, 1, zzpe.LONG),
    SINT32(15, 1, zzpe.INT),
    SINT64(16, 1, zzpe.LONG),
    GROUP(17, 1, zzpe.MESSAGE),
    DOUBLE_LIST(18, 2, zzpe.DOUBLE),
    FLOAT_LIST(19, 2, zzpe.FLOAT),
    INT64_LIST(20, 2, zzpe.LONG),
    UINT64_LIST(21, 2, zzpe.LONG),
    INT32_LIST(22, 2, zzpe.INT),
    FIXED64_LIST(23, 2, zzpe.LONG),
    FIXED32_LIST(24, 2, zzpe.INT),
    BOOL_LIST(25, 2, zzpe.BOOLEAN),
    STRING_LIST(26, 2, zzpe.STRING),
    MESSAGE_LIST(27, 2, zzpe.MESSAGE),
    BYTES_LIST(28, 2, zzpe.BYTE_STRING),
    UINT32_LIST(29, 2, zzpe.INT),
    ENUM_LIST(30, 2, zzpe.ENUM),
    SFIXED32_LIST(31, 2, zzpe.INT),
    SFIXED64_LIST(32, 2, zzpe.LONG),
    SINT32_LIST(33, 2, zzpe.INT),
    SINT64_LIST(34, 2, zzpe.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzpe.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzpe.FLOAT),
    INT64_LIST_PACKED(37, 3, zzpe.LONG),
    UINT64_LIST_PACKED(38, 3, zzpe.LONG),
    INT32_LIST_PACKED(39, 3, zzpe.INT),
    FIXED64_LIST_PACKED(40, 3, zzpe.LONG),
    FIXED32_LIST_PACKED(41, 3, zzpe.INT),
    BOOL_LIST_PACKED(42, 3, zzpe.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzpe.INT),
    ENUM_LIST_PACKED(44, 3, zzpe.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzpe.INT),
    SFIXED64_LIST_PACKED(46, 3, zzpe.LONG),
    SINT32_LIST_PACKED(47, 3, zzpe.INT),
    SINT64_LIST_PACKED(48, 3, zzpe.LONG),
    GROUP_LIST(49, 2, zzpe.MESSAGE),
    MAP(50, 4, zzpe.VOID);
    
    private static final zzon[] zzac;
    private final zzpe zzZ;
    private final int zzaa;
    private final Class<?> zzab;

    static {
        zzon[] values = values();
        zzac = new zzon[values.length];
        for (zzon zzonVar : values) {
            zzac[zzonVar.zzaa] = zzonVar;
        }
    }

    zzon(int i, int i2, zzpe zzpeVar) {
        this.zzaa = i;
        this.zzZ = zzpeVar;
        zzpe zzpeVar2 = zzpe.VOID;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzab = zzpeVar.zza();
        } else if (i3 != 3) {
            this.zzab = null;
        } else {
            this.zzab = zzpeVar.zza();
        }
        if (i2 == 1) {
            zzpeVar.ordinal();
        }
    }

    public final int zza() {
        return this.zzaa;
    }
}

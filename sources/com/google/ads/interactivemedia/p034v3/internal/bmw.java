package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmw */
/* loaded from: classes2.dex */
public enum bmw {
    DOUBLE(0, bmv.SCALAR, bno.DOUBLE),
    FLOAT(1, bmv.SCALAR, bno.FLOAT),
    INT64(2, bmv.SCALAR, bno.LONG),
    UINT64(3, bmv.SCALAR, bno.LONG),
    INT32(4, bmv.SCALAR, bno.INT),
    FIXED64(5, bmv.SCALAR, bno.LONG),
    FIXED32(6, bmv.SCALAR, bno.INT),
    BOOL(7, bmv.SCALAR, bno.BOOLEAN),
    STRING(8, bmv.SCALAR, bno.STRING),
    MESSAGE(9, bmv.SCALAR, bno.MESSAGE),
    BYTES(10, bmv.SCALAR, bno.BYTE_STRING),
    UINT32(11, bmv.SCALAR, bno.INT),
    ENUM(12, bmv.SCALAR, bno.ENUM),
    SFIXED32(13, bmv.SCALAR, bno.INT),
    SFIXED64(14, bmv.SCALAR, bno.LONG),
    SINT32(15, bmv.SCALAR, bno.INT),
    SINT64(16, bmv.SCALAR, bno.LONG),
    GROUP(17, bmv.SCALAR, bno.MESSAGE),
    DOUBLE_LIST(18, bmv.VECTOR, bno.DOUBLE),
    FLOAT_LIST(19, bmv.VECTOR, bno.FLOAT),
    INT64_LIST(20, bmv.VECTOR, bno.LONG),
    UINT64_LIST(21, bmv.VECTOR, bno.LONG),
    INT32_LIST(22, bmv.VECTOR, bno.INT),
    FIXED64_LIST(23, bmv.VECTOR, bno.LONG),
    FIXED32_LIST(24, bmv.VECTOR, bno.INT),
    BOOL_LIST(25, bmv.VECTOR, bno.BOOLEAN),
    STRING_LIST(26, bmv.VECTOR, bno.STRING),
    MESSAGE_LIST(27, bmv.VECTOR, bno.MESSAGE),
    BYTES_LIST(28, bmv.VECTOR, bno.BYTE_STRING),
    UINT32_LIST(29, bmv.VECTOR, bno.INT),
    ENUM_LIST(30, bmv.VECTOR, bno.ENUM),
    SFIXED32_LIST(31, bmv.VECTOR, bno.INT),
    SFIXED64_LIST(32, bmv.VECTOR, bno.LONG),
    SINT32_LIST(33, bmv.VECTOR, bno.INT),
    SINT64_LIST(34, bmv.VECTOR, bno.LONG),
    DOUBLE_LIST_PACKED(35, bmv.PACKED_VECTOR, bno.DOUBLE),
    FLOAT_LIST_PACKED(36, bmv.PACKED_VECTOR, bno.FLOAT),
    INT64_LIST_PACKED(37, bmv.PACKED_VECTOR, bno.LONG),
    UINT64_LIST_PACKED(38, bmv.PACKED_VECTOR, bno.LONG),
    INT32_LIST_PACKED(39, bmv.PACKED_VECTOR, bno.INT),
    FIXED64_LIST_PACKED(40, bmv.PACKED_VECTOR, bno.LONG),
    FIXED32_LIST_PACKED(41, bmv.PACKED_VECTOR, bno.INT),
    BOOL_LIST_PACKED(42, bmv.PACKED_VECTOR, bno.BOOLEAN),
    UINT32_LIST_PACKED(43, bmv.PACKED_VECTOR, bno.INT),
    ENUM_LIST_PACKED(44, bmv.PACKED_VECTOR, bno.ENUM),
    SFIXED32_LIST_PACKED(45, bmv.PACKED_VECTOR, bno.INT),
    SFIXED64_LIST_PACKED(46, bmv.PACKED_VECTOR, bno.LONG),
    SINT32_LIST_PACKED(47, bmv.PACKED_VECTOR, bno.INT),
    SINT64_LIST_PACKED(48, bmv.PACKED_VECTOR, bno.LONG),
    GROUP_LIST(49, bmv.VECTOR, bno.MESSAGE),
    MAP(50, bmv.MAP, bno.VOID);
    

    /* renamed from: Z */
    private static final bmw[] f6214Z;

    /* renamed from: ab */
    private final int f6242ab;

    /* renamed from: ac */
    private final bmv f6243ac;

    static {
        bmw[] values = values();
        f6214Z = new bmw[values.length];
        for (bmw bmwVar : values) {
            f6214Z[bmwVar.f6242ab] = bmwVar;
        }
    }

    bmw(int i, bmv bmvVar, bno bnoVar) {
        this.f6242ab = i;
        this.f6243ac = bmvVar;
        bno bnoVar2 = bno.VOID;
        bmv bmvVar2 = bmv.SCALAR;
        int ordinal = bmvVar.ordinal();
        if (ordinal == 1) {
            bnoVar.m3245a();
        } else if (ordinal == 3) {
            bnoVar.m3245a();
        }
        if (bmvVar == bmv.SCALAR) {
            bnoVar.ordinal();
        }
    }

    /* renamed from: a */
    public final int m3317a() {
        return this.f6242ab;
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpz */
/* loaded from: classes2.dex */
public enum bpz {
    DOUBLE(bqa.DOUBLE, 1),
    FLOAT(bqa.FLOAT, 5),
    INT64(bqa.LONG, 0),
    UINT64(bqa.LONG, 0),
    INT32(bqa.INT, 0),
    FIXED64(bqa.LONG, 1),
    FIXED32(bqa.INT, 5),
    BOOL(bqa.BOOLEAN, 0),
    STRING(bqa.STRING, 2),
    GROUP(bqa.MESSAGE, 3),
    MESSAGE(bqa.MESSAGE, 2),
    BYTES(bqa.BYTE_STRING, 2),
    UINT32(bqa.INT, 0),
    ENUM(bqa.ENUM, 0),
    SFIXED32(bqa.INT, 5),
    SFIXED64(bqa.LONG, 1),
    SINT32(bqa.INT, 0),
    SINT64(bqa.LONG, 0);
    

    /* renamed from: t */
    private final bqa f6429t;

    /* renamed from: u */
    private final int f6430u;

    bpz(bqa bqaVar, int i) {
        this.f6429t = bqaVar;
        this.f6430u = i;
    }

    /* renamed from: a */
    public final bqa m2858a() {
        return this.f6429t;
    }
}

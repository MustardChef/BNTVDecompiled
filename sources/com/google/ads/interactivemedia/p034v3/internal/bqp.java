package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bqp */
/* loaded from: classes2.dex */
public enum bqp implements bnf {
    DF_NONE(0),
    DF_HTTPHEADER(1),
    DF_COOKIE(2),
    DF_URL(3),
    DF_CGI_ARGS(4),
    DF_HOST_ORDER(5),
    DF_BYTE_SWAPPED(6),
    DF_LOGGING_ELEMENT_TYPE_ID(7);
    

    /* renamed from: i */
    private static final bng f6689i = new bqv(1);

    /* renamed from: k */
    private final int f6691k;

    bqp(int i) {
        this.f6691k = i;
    }

    /* renamed from: a */
    public static bng m2752a() {
        return f6689i;
    }

    /* renamed from: b */
    public static bqp m2751b(int i) {
        switch (i) {
            case 0:
                return DF_NONE;
            case 1:
                return DF_HTTPHEADER;
            case 2:
                return DF_COOKIE;
            case 3:
                return DF_URL;
            case 4:
                return DF_CGI_ARGS;
            case 5:
                return DF_HOST_ORDER;
            case 6:
                return DF_BYTE_SWAPPED;
            case 7:
                return DF_LOGGING_ELEMENT_TYPE_ID;
            default:
                return null;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bnf
    public final int getNumber() {
        return this.f6691k;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f6691k);
    }
}

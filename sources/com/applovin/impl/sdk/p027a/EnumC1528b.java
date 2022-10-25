package com.applovin.impl.sdk.p027a;

/* renamed from: com.applovin.impl.sdk.a.b */
/* loaded from: classes.dex */
public enum EnumC1528b {
    UNKNOWN(0),
    APPLOVIN_PRIMARY_ZONE(1),
    APPLOVIN_CUSTOM_ZONE(2),
    APPLOVIN_MULTIZONE(3),
    REGULAR_AD_TOKEN(4),
    DECODED_AD_TOKEN_JSON(5);
    

    /* renamed from: g */
    private final int f1478g;

    EnumC1528b(int i) {
        this.f1478g = i;
    }

    /* renamed from: a */
    public static EnumC1528b m7224a(int i) {
        return i == 1 ? APPLOVIN_PRIMARY_ZONE : i == 2 ? APPLOVIN_CUSTOM_ZONE : i == 3 ? APPLOVIN_MULTIZONE : i == 4 ? REGULAR_AD_TOKEN : i == 5 ? DECODED_AD_TOKEN_JSON : UNKNOWN;
    }

    /* renamed from: a */
    public int m7225a() {
        return this.f1478g;
    }
}

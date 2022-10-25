package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgv */
/* loaded from: classes2.dex */
public enum bgv implements bgw {
    DOUBLE,
    LAZILY_PARSED_NUMBER,
    LONG_OR_DOUBLE,
    BIG_DECIMAL;

    /* renamed from: b */
    public static final Double m3701b(bkv bkvVar) throws IOException {
        return Double.valueOf(bkvVar.mo3591a());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgw
    /* renamed from: a */
    public final /* synthetic */ Number mo3700a(bkv bkvVar) {
        int ordinal = ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        throw null;
                    }
                    throw null;
                }
                throw null;
            }
            return new bhq(bkvVar.mo3584h());
        }
        return m3701b(bkvVar);
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bbu */
/* loaded from: classes2.dex */
public final class bbu {

    /* renamed from: a */
    public static final String f5402a;

    static {
        new bbt();
        f5402a = "type.googleapis.com/google.crypto.tink.AesSivKey";
        int i = beo.f5597a;
        try {
            m4197a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /* renamed from: a */
    public static void m4197a() throws GeneralSecurityException {
        bae.m4232k(new bbw());
        if (bbq.m4198b()) {
            return;
        }
        bae.m4229n(new bbt());
    }
}

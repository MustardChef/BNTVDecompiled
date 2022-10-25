package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bag */
/* loaded from: classes2.dex */
public final class bag {

    /* renamed from: a */
    public static final String f5374a;

    /* renamed from: b */
    public static final String f5375b;
    @Deprecated

    /* renamed from: c */
    public static final beo f5376c;

    static {
        new bal();
        f5374a = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
        new bau();
        f5375b = "type.googleapis.com/google.crypto.tink.AesGcmKey";
        new bax();
        new bar();
        new bbd();
        new bbh();
        new bba();
        new bbk();
        f5376c = beo.m3873b();
        try {
            m4219a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /* renamed from: a */
    public static void m4219a() throws GeneralSecurityException {
        bae.m4232k(new bai());
        bcr.m4163a();
        bae.m4229n(new bal());
        bae.m4229n(new bau());
        if (bbq.m4198b()) {
            return;
        }
        bae.m4229n(new bar());
        bax.m4211l();
        bae.m4229n(new bba());
        bae.m4229n(new bbd());
        bae.m4229n(new bbh());
        bae.m4229n(new bbk());
    }
}

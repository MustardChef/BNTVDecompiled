package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.beu */
/* loaded from: classes2.dex */
final class beu extends ThreadLocal {
    /* renamed from: a */
    protected static final Cipher m3786a() {
        try {
            return (Cipher) bfj.f5644a.m3766a("AES/ECB/NOPADDING");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return m3786a();
    }
}

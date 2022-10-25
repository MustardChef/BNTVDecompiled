package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bes */
/* loaded from: classes2.dex */
final class bes extends ThreadLocal {
    /* renamed from: a */
    protected static final Cipher m3787a() {
        try {
            return (Cipher) bfj.f5644a.m3766a("AES/CTR/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return m3787a();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfk */
/* loaded from: classes2.dex */
public final class bfk implements bfl {

    /* renamed from: a */
    private final /* synthetic */ int f5653a;

    public bfk(int i) {
        this.f5653a = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bfl
    /* renamed from: a */
    public final /* synthetic */ Object mo3764a(String str, Provider provider) throws GeneralSecurityException {
        int i = this.f5653a;
        if (i == 0) {
            if (provider == null) {
                return KeyAgreement.getInstance(str);
            }
            return KeyAgreement.getInstance(str, provider);
        } else if (i == 1) {
            if (provider == null) {
                return Cipher.getInstance(str);
            }
            return Cipher.getInstance(str, provider);
        } else if (i == 2) {
            if (provider == null) {
                return KeyFactory.getInstance(str);
            }
            return KeyFactory.getInstance(str, provider);
        } else if (i == 3) {
            if (provider == null) {
                return KeyPairGenerator.getInstance(str);
            }
            return KeyPairGenerator.getInstance(str, provider);
        } else if (i == 4) {
            if (provider == null) {
                return Mac.getInstance(str);
            }
            return Mac.getInstance(str, provider);
        } else if (i != 5) {
            return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
        } else if (provider == null) {
            return MessageDigest.getInstance(str);
        } else {
            return MessageDigest.getInstance(str, provider);
        }
    }
}

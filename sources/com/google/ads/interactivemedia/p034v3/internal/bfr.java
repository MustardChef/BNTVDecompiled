package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bfr */
/* loaded from: classes2.dex */
public final class bfr implements bcu {

    /* renamed from: a */
    public static final int f5660a = bbp.f5397b;

    /* renamed from: b */
    private final ThreadLocal f5661b;

    /* renamed from: c */
    private final String f5662c;

    /* renamed from: d */
    private final Key f5663d;

    /* renamed from: e */
    private final int f5664e;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public bfr(String str, Key key) throws GeneralSecurityException {
        char c;
        int i;
        bfq bfqVar = new bfq(this);
        this.f5661b = bfqVar;
        if (bbp.m4200a(f5660a)) {
            this.f5662c = str;
            this.f5663d = key;
            if (key.getEncoded().length < 16) {
                throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
            }
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 392315023:
                    if (str.equals("HMACSHA224")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 392316170:
                    if (str.equals("HMACSHA384")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                i = 20;
            } else if (c == 1) {
                i = 28;
            } else if (c == 2) {
                i = 32;
            } else if (c != 3) {
                if (c != 4) {
                    throw new NoSuchAlgorithmException(str.length() != 0 ? "unknown Hmac algorithm: ".concat(str) : new String("unknown Hmac algorithm: "));
                }
                this.f5664e = 64;
                bfqVar.get();
                return;
            } else {
                i = 48;
            }
            this.f5664e = i;
            bfqVar.get();
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bcu
    /* renamed from: a */
    public final byte[] mo3742a(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > this.f5664e) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) this.f5661b.get()).update(bArr);
        return Arrays.copyOf(((Mac) this.f5661b.get()).doFinal(), i);
    }
}

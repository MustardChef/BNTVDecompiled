package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkm */
/* loaded from: classes3.dex */
public final class zzkm implements zzea {
    private final ThreadLocal<Mac> zza;
    private final String zzb;
    private final Key zzc;
    private final int zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public zzkm(String str, Key key) throws GeneralSecurityException {
        char c;
        int i;
        zzkl zzklVar = new zzkl(this);
        this.zza = zzklVar;
        this.zzb = str;
        this.zzc = key;
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
            case 392315118:
                if (str.equals("HMACSHA256")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 392316170:
                if (str.equals("HMACSHA384")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 392317873:
                if (str.equals("HMACSHA512")) {
                    c = 3;
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
            i = 32;
        } else if (c != 2) {
            if (c != 3) {
                throw new NoSuchAlgorithmException(str.length() != 0 ? "unknown Hmac algorithm: ".concat(str) : new String("unknown Hmac algorithm: "));
            }
            this.zzd = 64;
            zzklVar.get();
        } else {
            i = 48;
        }
        this.zzd = i;
        zzklVar.get();
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzea
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        if (i > this.zzd) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        this.zza.get().update(bArr);
        return Arrays.copyOf(this.zza.get().doFinal(), i);
    }
}

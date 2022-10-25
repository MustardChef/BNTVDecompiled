package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjs */
/* loaded from: classes3.dex */
public final class zzjs implements zzak {
    private static final byte[] zza = new byte[0];
    private final ECPrivateKey zzb;
    private final zzju zzc;
    private final String zzd;
    private final byte[] zze;
    private final zzjr zzf;
    private final int zzg;

    public zzjs(ECPrivateKey eCPrivateKey, byte[] bArr, String str, int i, zzjr zzjrVar) throws GeneralSecurityException {
        this.zzb = eCPrivateKey;
        this.zzc = new zzju(eCPrivateKey);
        this.zze = bArr;
        this.zzd = str;
        this.zzg = i;
        this.zzf = zzjrVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzak
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] zza(byte[] r10, byte[] r11) throws java.security.GeneralSecurityException {
        /*
            r9 = this;
            java.security.interfaces.ECPrivateKey r11 = r9.zzb
            java.security.spec.ECParameterSpec r11 = r11.getParams()
            java.security.spec.EllipticCurve r11 = r11.getCurve()
            int r0 = r9.zzg
            int r11 = com.google.android.gms.internal.p038firebaseauthapi.zzjw.zzc(r11)
            int r0 = r0 + (-1)
            if (r0 == 0) goto L1a
            r1 = 2
            if (r0 == r1) goto L18
            goto L1b
        L18:
            int r11 = r11 + r11
            goto L1d
        L1a:
            int r11 = r11 + r11
        L1b:
            int r11 = r11 + 1
        L1d:
            int r0 = r10.length
            if (r0 < r11) goto L49
            r1 = 0
            byte[] r3 = java.util.Arrays.copyOfRange(r10, r1, r11)
            com.google.android.gms.internal.firebase-auth-api.zzju r2 = r9.zzc
            java.lang.String r4 = r9.zzd
            byte[] r5 = r9.zze
            com.google.android.gms.internal.firebase-auth-api.zzjr r1 = r9.zzf
            int r7 = r1.zza()
            int r8 = r9.zzg
            r6 = 0
            byte[] r1 = r2.zza(r3, r4, r5, r6, r7, r8)
            com.google.android.gms.internal.firebase-auth-api.zzjr r2 = r9.zzf
            com.google.android.gms.internal.firebase-auth-api.zzag r1 = r2.zzb(r1)
            byte[] r10 = java.util.Arrays.copyOfRange(r10, r11, r0)
            byte[] r11 = com.google.android.gms.internal.p038firebaseauthapi.zzjs.zza
            byte[] r10 = r1.zzb(r10, r11)
            return r10
        L49:
            java.security.GeneralSecurityException r10 = new java.security.GeneralSecurityException
            java.lang.String r11 = "ciphertext too short"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzjs.zza(byte[], byte[]):byte[]");
    }
}

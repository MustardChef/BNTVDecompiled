package com.google.android.gms.internal.p038firebaseauthapi;

import java.security.SecureRandom;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkp */
/* loaded from: classes3.dex */
public final class zzkp {
    private static final ThreadLocal<SecureRandom> zza = new zzko();

    public static byte[] zza(int i) {
        byte[] bArr = new byte[i];
        zza.get().nextBytes(bArr);
        return bArr;
    }
}

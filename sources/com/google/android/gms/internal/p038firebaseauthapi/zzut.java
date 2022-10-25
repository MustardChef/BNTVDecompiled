package com.google.android.gms.internal.p038firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzut */
/* loaded from: classes3.dex */
public final class zzut {
    public static zzxo zza(PhoneAuthCredential phoneAuthCredential) {
        if (!TextUtils.isEmpty(phoneAuthCredential.zzh())) {
            return zzxo.zzc(phoneAuthCredential.zze(), phoneAuthCredential.zzh(), phoneAuthCredential.zzg());
        }
        return zzxo.zzb(phoneAuthCredential.zzd(), phoneAuthCredential.getSmsCode(), phoneAuthCredential.zzg());
    }
}

package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwi */
/* loaded from: classes3.dex */
public final class zzwi {
    public static long zza(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> zzc = zzae.zza('.').zzc(str);
        if (zzc.size() < 2) {
            String valueOf = String.valueOf(str);
            throw new RuntimeException(valueOf.length() != 0 ? "Invalid idToken ".concat(valueOf) : new String("Invalid idToken "));
        }
        try {
            zzwj zzc2 = zzwj.zzc(new String(Base64Utils.decodeUrlSafeNoPadding(zzc.get(1)), "UTF-8"));
            return zzc2.zzb().longValue() - zzc2.zza().longValue();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}

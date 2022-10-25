package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.p038firebaseauthapi.zzda;
import com.google.android.gms.internal.p038firebaseauthapi.zzdf;
import com.google.android.gms.internal.p038firebaseauthapi.zzdj;
import com.google.android.gms.internal.p038firebaseauthapi.zzdk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzk {
    private static zzk zzc;
    private final String zza;
    private zzdk zzb;

    private zzk(Context context, String str, boolean z) {
        this.zza = str;
        try {
            zzda.zza();
            zzdj zzdjVar = new zzdj();
            zzdjVar.zza(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str));
            zzdjVar.zzc(zzdf.zza);
            zzdjVar.zzb(String.format("android-keystore://firebear_master_key_id.%s", str));
            this.zzb = zzdjVar.zzd();
        } catch (IOException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebearCryptoHelper", valueOf.length() != 0 ? "Exception encountered during crypto setup:\n".concat(valueOf) : new String("Exception encountered during crypto setup:\n"));
        }
    }

    public static zzk zza(Context context, String str) {
        String str2;
        zzk zzkVar = zzc;
        if (zzkVar == null || ((str2 = zzkVar.zza) != str && (str2 == null || !str2.equals(str)))) {
            zzc = new zzk(context, str, true);
        }
        return zzc;
    }

    public final String zzb() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.zzb.zza().zzf().zze(com.google.android.gms.internal.p038firebaseauthapi.zzah.zza(byteArrayOutputStream));
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebearCryptoHelper", valueOf.length() != 0 ? "Exception encountered when attempting to get Public Key:\n".concat(valueOf) : new String("Exception encountered when attempting to get Public Key:\n"));
            return null;
        }
    }

    public final String zzc(String str) {
        try {
            return new String(((com.google.android.gms.internal.p038firebaseauthapi.zzak) this.zzb.zza().zzh(com.google.android.gms.internal.p038firebaseauthapi.zzak.class)).zza(Base64.decode(str, 8), null), "UTF-8");
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebearCryptoHelper", valueOf.length() != 0 ? "Exception encountered while decrypting bytes:\n".concat(valueOf) : new String("Exception encountered while decrypting bytes:\n"));
            return null;
        }
    }
}

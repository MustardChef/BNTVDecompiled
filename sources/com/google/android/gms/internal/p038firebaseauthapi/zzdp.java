package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdp */
/* loaded from: classes3.dex */
public final class zzdp implements zzav {
    private final SharedPreferences.Editor zza;
    private final String zzb = "GenericIdpKeyset";

    public zzdp(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        if (str2 == null) {
            this.zza = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.zza = applicationContext.getSharedPreferences(str2, 0).edit();
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzav
    public final void zzb(zzib zzibVar) throws IOException {
        if (!this.zza.putString(this.zzb, zzkh.zza(zzibVar.zzI())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzav
    public final void zzc(zzgy zzgyVar) throws IOException {
        if (!this.zza.putString(this.zzb, zzkh.zza(zzgyVar.zzI())).commit()) {
            throw new IOException("Failed to write to SharedPreferences");
        }
    }
}

package com.google.android.gms.internal.p038firebaseauthapi;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.net.HttpHeaders;
import java.net.URLConnection;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuc */
/* loaded from: classes3.dex */
public final class zzuc {
    private final Context zza;
    private zzus zzb;
    private final String zzc;
    private boolean zzd = false;
    private String zze;

    public zzuc(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zza = context.getApplicationContext();
        this.zzc = String.format("Android/%s/%s", "Fallback", str);
    }

    public final void zza(URLConnection uRLConnection) {
        String sb;
        if (this.zzd) {
            String str = this.zzc;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 19);
            sb2.append(str);
            sb2.append("/");
            sb2.append("FirebaseUI-Android");
            sb = sb2.toString();
        } else {
            String str2 = this.zzc;
            StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 21);
            sb3.append(str2);
            sb3.append("/");
            sb3.append("FirebaseCore-Android");
            sb = sb3.toString();
        }
        if (this.zzb == null) {
            Context context = this.zza;
            this.zzb = new zzus(context, context.getPackageName());
        }
        uRLConnection.setRequestProperty("X-Android-Package", this.zzb.zza());
        uRLConnection.setRequestProperty("X-Android-Cert", this.zzb.zzb());
        uRLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, zzud.zza());
        uRLConnection.setRequestProperty("X-Client-Version", sb);
        uRLConnection.setRequestProperty("X-Firebase-Locale", this.zze);
        this.zze = null;
    }

    public final void zzb(String str) {
        this.zzd = !TextUtils.isEmpty(str);
    }

    public final void zzc(String str) {
        this.zze = str;
    }
}

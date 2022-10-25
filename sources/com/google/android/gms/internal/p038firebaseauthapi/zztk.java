package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztk */
/* loaded from: classes3.dex */
public class zztk {
    final String zza;
    final zzuc zzb;

    public zztk(String str, zzuc zzucVar) {
        this.zza = str;
        this.zzb = zzucVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(String str, String str2) {
        String str3 = this.zza;
        int length = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(length + 5 + str.length() + String.valueOf(str2).length());
        sb.append(str3);
        sb.append(str);
        sb.append("?key=");
        sb.append(str2);
        return sb.toString();
    }
}

package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes.dex */
final class zzg implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final zzn zza(Context context, String str, zzm zzmVar) throws DynamiteModule.LoadingException {
        zzn zznVar = new zzn();
        zznVar.zza = zzmVar.zzb(context, str);
        int zza = zzmVar.zza(context, str, true);
        zznVar.zzb = zza;
        int i = zznVar.zza;
        if (i == 0) {
            if (zza == 0) {
                zznVar.zzc = 0;
                return zznVar;
            }
            i = 0;
        }
        if (i >= zza) {
            zznVar.zzc = -1;
        } else {
            zznVar.zzc = 1;
        }
        return zznVar;
    }
}

package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public interface zzq extends HasApiKey<Cast.CastOptions> {
    void zza(zzp zzpVar);

    Task<Void> zzb();

    Task<Void> zzc();

    Task<Void> zzd();

    Task<Void> zze(String str, String str2);

    Task<Cast.ApplicationConnectionResult> zzf(String str, LaunchOptions launchOptions);

    Task<Status> zzg(String str);

    Task<Void> zzh(double d);

    double zzi();

    Task<Void> zzj(boolean z);

    boolean zzk();

    int zzl();

    int zzm();

    ApplicationMetadata zzn();

    String zzo();

    Task<Void> zzp(String str, Cast.MessageReceivedCallback messageReceivedCallback);

    Task<Void> zzq(String str);
}

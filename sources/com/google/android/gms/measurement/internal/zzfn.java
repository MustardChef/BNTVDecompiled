package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzmy;
import com.google.firebase.messaging.Constants;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzfn implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzd zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzfk zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfn(zzfk zzfkVar, com.google.android.gms.internal.measurement.zzd zzdVar, ServiceConnection serviceConnection) {
        this.zzc = zzfkVar;
        this.zza = zzdVar;
        this.zzb = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        zzfl zzflVar = this.zzc.zza;
        str = this.zzc.zzb;
        com.google.android.gms.internal.measurement.zzd zzdVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza = zzflVar.zza(str, zzdVar);
        zzflVar.zza.zzp().zzc();
        if (zza != null) {
            long j = zza.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzflVar.zza.zzq().zzh().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = zza.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzflVar.zza.zzq().zze().zza("No referrer defined in Install Referrer response");
                } else {
                    zzflVar.zza.zzq().zzw().zza("InstallReferrer API result", string);
                    zzkv zzh = zzflVar.zza.zzh();
                    String valueOf = String.valueOf(string);
                    Bundle zza2 = zzh.zza(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (zza2 == null) {
                        zzflVar.zza.zzq().zze().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zza2.getString("medium");
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j2 = zza.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzflVar.zza.zzq().zze().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zza2.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzflVar.zza.zzb().zzi.zza()) {
                            zzflVar.zza.zzq().zzw().zza("Install Referrer campaign has already been logged");
                        } else if (!zzmy.zzb() || !zzflVar.zza.zza().zza(zzas.zzbs) || zzflVar.zza.zzaa()) {
                            zzflVar.zza.zzb().zzi.zza(j);
                            zzflVar.zza.zzq().zzw().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza2.putString("_cis", "referrer API");
                            zzflVar.zza.zzg().zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zza2);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzflVar.zza.zzm(), serviceConnection);
        }
    }
}

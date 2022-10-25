package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import com.google.android.gms.cast.internal.Logger;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzi {
    public String zzb;
    public String zzc;
    public long zzd = zza;
    public int zze = 1;
    public int zzf;
    public String zzg;
    private static final Logger zzh = new Logger("ApplicationAnalyticsSession");
    public static long zza = System.currentTimeMillis();

    private zzi() {
    }

    public static zzi zza() {
        zzi zziVar = new zzi();
        zza++;
        return zziVar;
    }

    public static zzi zzb(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return null;
        }
        zzi zziVar = new zzi();
        if (sharedPreferences.contains("application_id")) {
            zziVar.zzb = sharedPreferences.getString("application_id", "");
            if (sharedPreferences.contains("receiver_metrics_id")) {
                zziVar.zzc = sharedPreferences.getString("receiver_metrics_id", "");
                if (sharedPreferences.contains("analytics_session_id")) {
                    zziVar.zzd = sharedPreferences.getLong("analytics_session_id", 0L);
                    if (sharedPreferences.contains("event_sequence_number")) {
                        zziVar.zze = sharedPreferences.getInt("event_sequence_number", 0);
                        if (!sharedPreferences.contains("receiver_session_id")) {
                            zziVar.zzf = sharedPreferences.getInt("device_capabilities", 0);
                            return null;
                        }
                        zziVar.zzg = sharedPreferences.getString("receiver_session_id", "");
                        return zziVar;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public final void zzc(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        zzh.m369d("Save the ApplicationAnalyticsSession to SharedPreferences %s", sharedPreferences);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("application_id", this.zzb);
        edit.putString("receiver_metrics_id", this.zzc);
        edit.putLong("analytics_session_id", this.zzd);
        edit.putInt("event_sequence_number", this.zze);
        edit.putInt("device_capabilities", this.zzf);
        edit.putString("receiver_session_id", this.zzg);
        edit.apply();
    }
}

package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzl {
    private static final Logger zza = new Logger("FeatureUsageAnalytics");
    private static final String zzb = "20.0.0";
    private static zzl zzc;
    private final zzd zzd;
    private final SharedPreferences zze;
    private final String zzf;
    private final Runnable zzg;
    private final Handler zzh;
    private final Set<zzjt> zzi;
    private final Set<zzjt> zzj;
    private long zzk;

    private zzl(SharedPreferences sharedPreferences, zzd zzdVar, String str) {
        this.zze = sharedPreferences;
        this.zzd = zzdVar;
        this.zzf = str;
        HashSet hashSet = new HashSet();
        this.zzi = hashSet;
        HashSet hashSet2 = new HashSet();
        this.zzj = hashSet2;
        this.zzh = new zzci(Looper.getMainLooper());
        this.zzg = new Runnable(this) { // from class: com.google.android.gms.internal.cast.zzk
            private final zzl zza;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zza = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        };
        String string = sharedPreferences.getString("feature_usage_sdk_version", null);
        String string2 = sharedPreferences.getString("feature_usage_package_name", null);
        hashSet.clear();
        hashSet2.clear();
        this.zzk = 0L;
        if (!zzb.equals(string) || !str.equals(string2)) {
            HashSet hashSet3 = new HashSet();
            for (String str2 : sharedPreferences.getAll().keySet()) {
                if (str2.startsWith("feature_usage_timestamp_")) {
                    hashSet3.add(str2);
                }
            }
            hashSet3.add("feature_usage_last_report_time");
            zze(hashSet3);
            this.zze.edit().putString("feature_usage_sdk_version", zzb).putString("feature_usage_package_name", this.zzf).apply();
            return;
        }
        this.zzk = sharedPreferences.getLong("feature_usage_last_report_time", 0L);
        long zzg = zzg();
        HashSet hashSet4 = new HashSet();
        for (String str3 : sharedPreferences.getAll().keySet()) {
            if (str3.startsWith("feature_usage_timestamp_")) {
                long j = this.zze.getLong(str3, 0L);
                if (j == 0 || zzg - j <= 1209600000) {
                    if (str3.startsWith("feature_usage_timestamp_reported_feature_")) {
                        zzjt zzi = zzi(str3.substring(41));
                        this.zzj.add(zzi);
                        this.zzi.add(zzi);
                    } else if (str3.startsWith("feature_usage_timestamp_detected_feature_")) {
                        this.zzi.add(zzi(str3.substring(41)));
                    }
                } else {
                    hashSet4.add(str3);
                }
            }
        }
        zze(hashSet4);
        Preconditions.checkNotNull(this.zzh);
        Preconditions.checkNotNull(this.zzg);
        zzf();
    }

    public static synchronized zzl zza(SharedPreferences sharedPreferences, zzd zzdVar, String str) {
        zzl zzlVar;
        synchronized (zzl.class) {
            if (zzc == null) {
                zzc = new zzl(sharedPreferences, zzdVar, str);
            }
            zzlVar = zzc;
        }
        return zzlVar;
    }

    public static void zzb(zzjt zzjtVar) {
        zzl zzlVar = zzc;
        if (zzlVar == null) {
            return;
        }
        zzlVar.zze.edit().putLong(zzlVar.zzh(Integer.toString(zzjtVar.zza())), zzlVar.zzg()).apply();
        zzlVar.zzi.add(zzjtVar);
        zzlVar.zzf();
    }

    static String zzc(String str, String str2) {
        return String.format("%s%s", str, str2);
    }

    private final void zze(Set<String> set) {
        if (set.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = this.zze.edit();
        for (String str : set) {
            edit.remove(str);
        }
        edit.apply();
    }

    @RequiresNonNull({"handler", "reportFeatureUsageRunnable"})
    private final void zzf() {
        this.zzh.post(this.zzg);
    }

    private final long zzg() {
        return DefaultClock.getInstance().currentTimeMillis();
    }

    @RequiresNonNull({"sharedPreferences"})
    private final String zzh(String str) {
        String zzc2 = zzc("feature_usage_timestamp_reported_feature_", str);
        return this.zze.contains(zzc2) ? zzc2 : zzc("feature_usage_timestamp_detected_feature_", str);
    }

    private static zzjt zzi(String str) {
        try {
            return zzjt.zzb(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return zzjt.DEVELOPER_FEATURE_FLAG_UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzd() {
        if (this.zzi.isEmpty()) {
            return;
        }
        long j = true != this.zzj.equals(this.zzi) ? 86400000L : 172800000L;
        long zzg = zzg();
        long j2 = this.zzk;
        if (j2 == 0 || zzg - j2 >= j) {
            zza.m369d("Upload the feature usage report.", new Object[0]);
            zzki zza2 = zzkj.zza();
            zza2.zzb(zzb);
            zza2.zza(this.zzf);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.zzi);
            zzkc zza3 = zzkd.zza();
            zza3.zzb(arrayList);
            zza3.zza(zza2.zzp());
            zzks zzc2 = zzkt.zzc();
            zzc2.zzi(zza3.zzp());
            this.zzd.zzb(zzc2.zzp(), zzhi.API_USAGE_REPORT);
            SharedPreferences.Editor edit = this.zze.edit();
            if (!this.zzj.equals(this.zzi)) {
                this.zzj.clear();
                this.zzj.addAll(this.zzi);
                for (zzjt zzjtVar : this.zzj) {
                    String num = Integer.toString(zzjtVar.zza());
                    String zzh = zzh(num);
                    String zzc3 = zzc("feature_usage_timestamp_reported_feature_", num);
                    if (!TextUtils.equals(zzh, zzc3)) {
                        long j3 = this.zze.getLong(zzh, 0L);
                        edit.remove(zzh);
                        if (j3 != 0) {
                            edit.putLong(zzc3, j3);
                        }
                    }
                }
            }
            this.zzk = zzg;
            edit.putLong("feature_usage_last_report_time", zzg).apply();
        }
    }
}

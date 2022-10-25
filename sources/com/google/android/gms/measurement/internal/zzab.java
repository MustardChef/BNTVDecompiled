package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zzoh;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzab extends zzgr {
    private Boolean zza;
    private zzad zzb;
    private Boolean zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(zzfu zzfuVar) {
        super(zzfuVar);
        this.zzb = zzaa.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzad zzadVar) {
        this.zzb = zzadVar;
    }

    public final int zzd() {
        if (zzmg.zzb() && zzs().zzd(null, zzas.zzbw)) {
            zzkv zzo = zzo();
            Boolean zzaf = zzo.zzy.zzv().zzaf();
            if (zzo.zzi() >= 201500 || !(zzaf == null || zzaf.booleanValue())) {
                return 100;
            }
        }
        return 25;
    }

    public final int zza(String str) {
        return zza(str, zzas.zzah, 25, 100);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(String str) {
        if (zzmg.zzb() && zzd(null, zzas.zzbv)) {
            return zza(str, zzas.zzag, 500, 2000);
        }
        return 500;
    }

    public final int zzc(String str) {
        return zzb(str, zzas.zzn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzd(String str) {
        if (zzmg.zzb() && zzd(null, zzas.zzbv)) {
            return zza(str, zzas.zzaf, 25, 100);
        }
        return 25;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zze(String str) {
        return zza(str, zzas.zza);
    }

    public final boolean zze() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzm().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzq().zze().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final long zza(String str, zzej<Long> zzejVar) {
        if (str == null) {
            return zzejVar.zza(null).longValue();
        }
        String zza = this.zzb.zza(str, zzejVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzejVar.zza(null).longValue();
        }
        try {
            return zzejVar.zza(Long.valueOf(Long.parseLong(zza))).longValue();
        } catch (NumberFormatException unused) {
            return zzejVar.zza(null).longValue();
        }
    }

    public final int zzb(String str, zzej<Integer> zzejVar) {
        if (str == null) {
            return zzejVar.zza(null).intValue();
        }
        String zza = this.zzb.zza(str, zzejVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzejVar.zza(null).intValue();
        }
        try {
            return zzejVar.zza(Integer.valueOf(Integer.parseInt(zza))).intValue();
        } catch (NumberFormatException unused) {
            return zzejVar.zza(null).intValue();
        }
    }

    private final int zza(String str, zzej<Integer> zzejVar, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzejVar), i2), i);
    }

    public final double zzc(String str, zzej<Double> zzejVar) {
        if (str == null) {
            return zzejVar.zza(null).doubleValue();
        }
        String zza = this.zzb.zza(str, zzejVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzejVar.zza(null).doubleValue();
        }
        try {
            return zzejVar.zza(Double.valueOf(Double.parseDouble(zza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzejVar.zza(null).doubleValue();
        }
    }

    public final boolean zzd(String str, zzej<Boolean> zzejVar) {
        if (str == null) {
            return zzejVar.zza(null).booleanValue();
        }
        String zza = this.zzb.zza(str, zzejVar.zza());
        if (TextUtils.isEmpty(zza)) {
            return zzejVar.zza(null).booleanValue();
        }
        return zzejVar.zza(Boolean.valueOf(Boolean.parseBoolean(zza))).booleanValue();
    }

    public final boolean zze(String str, zzej<Boolean> zzejVar) {
        return zzd(str, zzejVar);
    }

    public final boolean zza(zzej<Boolean> zzejVar) {
        return zzd(null, zzejVar);
    }

    private final Bundle zzz() {
        try {
            if (zzm().getPackageManager() == null) {
                zzq().zze().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzm()).getApplicationInfo(zzm().getPackageName(), 128);
            if (applicationInfo == null) {
                zzq().zze().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            zzq().zze().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzf(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzz = zzz();
        if (zzz == null) {
            zzq().zze().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (zzz.containsKey(str)) {
            return Boolean.valueOf(zzz.getBoolean(str));
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> zzg(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzz()
            r1 = 0
            if (r0 != 0) goto L19
            com.google.android.gms.measurement.internal.zzeq r4 = r3.zzq()
            com.google.android.gms.measurement.internal.zzes r4 = r4.zze()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.zzm()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzeq r0 = r3.zzq()
            com.google.android.gms.measurement.internal.zzes r0 = r0.zze()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zzg(java.lang.String):java.util.List");
    }

    public final boolean zzf() {
        Boolean zzf = zzf("firebase_analytics_collection_deactivated");
        return zzf != null && zzf.booleanValue();
    }

    public final Boolean zzg() {
        Boolean zzf = zzf("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zzf == null || zzf.booleanValue());
    }

    public final Boolean zzh() {
        boolean z = true;
        if (!zzoh.zzb() || !zza(zzas.zzbt)) {
            return true;
        }
        Boolean zzf = zzf("google_analytics_automatic_screen_reporting_enabled");
        if (zzf != null && !zzf.booleanValue()) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final Boolean zzi() {
        if (zzml.zzb() && zza(zzas.zzch)) {
            return zzf("google_analytics_default_allow_ad_storage");
        }
        return null;
    }

    public final Boolean zzj() {
        if (zzml.zzb() && zza(zzas.zzch)) {
            return zzf("google_analytics_default_allow_analytics_storage");
        }
        return null;
    }

    public static long zzu() {
        return zzas.zzac.zza(null).longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(com.google.android.gms.measurement.internal.zzf r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.zze()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
            boolean r1 = com.google.android.gms.internal.measurement.zznv.zzb()
            if (r1 == 0) goto L2f
            com.google.android.gms.measurement.internal.zzab r1 = r5.zzs()
            java.lang.String r2 = r6.zzc()
            com.google.android.gms.measurement.internal.zzej<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzas.zzbi
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L2f
            java.lang.String r1 = r6.zzg()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
        L2f:
            java.lang.String r1 = r6.zzf()
        L33:
            com.google.android.gms.measurement.internal.zzej<java.lang.String> r2 = com.google.android.gms.measurement.internal.zzas.zzd
            r3 = 0
            java.lang.Object r2 = r2.zza(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.zzej<java.lang.String> r4 = com.google.android.gms.measurement.internal.zzas.zze
            java.lang.Object r3 = r4.zza(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L5d
            java.lang.String r1 = r3.concat(r1)
            goto L62
        L5d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L62:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.zzd()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            java.lang.String r1 = "gmp_version"
            java.lang.String r2 = "33025"
            r6.appendQueryParameter(r1, r2)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(com.google.android.gms.measurement.internal.zzf):java.lang.String");
    }

    public static long zzv() {
        return zzas.zzc.zza(null).longValue();
    }

    public final String zzw() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzx() {
        return zza("debug.deferred.deeplink", "");
    }

    private final String zza(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            zzq().zze().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            zzq().zze().zza("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            zzq().zze().zza("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzq().zze().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    public final boolean zzh(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzi(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzj(String str) {
        return zzd(str, zzas.zzaj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzk(String str) {
        zzej<String> zzejVar = zzas.zzak;
        if (str == null) {
            return zzejVar.zza(null);
        }
        return zzejVar.zza(this.zzb.zza(str, zzejVar.zza()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzy() {
        if (this.zza == null) {
            Boolean zzf = zzf("app_measurement_lite");
            this.zza = zzf;
            if (zzf == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzy.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }
}

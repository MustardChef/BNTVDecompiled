package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zznk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzii extends zzg {
    protected zzij zza;
    private volatile zzij zzb;
    private zzij zzc;
    private final Map<Activity, zzij> zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzij zzg;
    private zzij zzh;
    private boolean zzi;
    private final Object zzj;
    private zzij zzk;
    private String zzl;

    public zzii(zzfu zzfuVar) {
        super(zzfuVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzy() {
        return false;
    }

    public final zzij zza(boolean z) {
        zzv();
        zzc();
        if (!zzs().zza(zzas.zzbu) || !z) {
            return this.zza;
        }
        zzij zzijVar = this.zza;
        return zzijVar != null ? zzijVar : this.zzh;
    }

    public final void zza(Bundle bundle, long j) {
        String str;
        if (!zzs().zza(zzas.zzbu)) {
            zzq().zzj().zza("Manual screen reporting is disabled.");
            return;
        }
        synchronized (this.zzj) {
            if (!this.zzi) {
                zzq().zzj().zza("Cannot log screen view event when the app is in the background.");
                return;
            }
            String str2 = null;
            if (bundle != null) {
                String string = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                if (string != null && (string.length() <= 0 || string.length() > 100)) {
                    zzq().zzj().zza("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_CLASS);
                if (string2 != null && (string2.length() <= 0 || string2.length() > 100)) {
                    zzq().zzj().zza("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                } else {
                    str = string;
                    str2 = string2;
                }
            } else {
                str = null;
            }
            if (str2 == null) {
                Activity activity = this.zze;
                str2 = activity != null ? zza(activity.getClass().getCanonicalName()) : "Activity";
            }
            String str3 = str2;
            if (this.zzf && this.zzb != null) {
                this.zzf = false;
                boolean zzc = zzkv.zzc(this.zzb.zzb, str3);
                boolean zzc2 = zzkv.zzc(this.zzb.zza, str);
                if (zzc && zzc2) {
                    zzq().zzj().zza("Ignoring call to log screen view event with duplicate parameters.");
                    return;
                }
            }
            zzq().zzw().zza("Logging screen view with name, class", str == null ? "null" : str, str3 == null ? "null" : str3);
            zzij zzijVar = this.zzb == null ? this.zzc : this.zzb;
            zzij zzijVar2 = new zzij(str, str3, zzo().zzf(), true, j);
            this.zzb = zzijVar2;
            this.zzc = zzijVar;
            this.zzg = zzijVar2;
            zzp().zza(new zzil(this, bundle, zzijVar2, zzijVar, zzl().elapsedRealtime()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Bundle bundle, zzij zzijVar, zzij zzijVar2, long j) {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zza(zzijVar, zzijVar2, j, true, zzo().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, true, true));
    }

    @Deprecated
    public final void zza(Activity activity, String str, String str2) {
        if (!zzs().zzh().booleanValue()) {
            zzq().zzj().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
        } else if (this.zzb == null) {
            zzq().zzj().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzq().zzj().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass().getCanonicalName());
            }
            boolean zzc = zzkv.zzc(this.zzb.zzb, str2);
            boolean zzc2 = zzkv.zzc(this.zzb.zza, str);
            if (zzc && zzc2) {
                zzq().zzj().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzq().zzj().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
                zzq().zzj().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            } else {
                zzq().zzw().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzij zzijVar = new zzij(str, str2, zzo().zzf());
                this.zzd.put(activity, zzijVar);
                zza(activity, zzijVar, true);
            }
        }
    }

    public final zzij zzaa() {
        return this.zzb;
    }

    private final void zza(Activity activity, zzij zzijVar, boolean z) {
        zzij zzijVar2;
        zzij zzijVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzijVar.zzb == null) {
            zzijVar2 = new zzij(zzijVar.zza, activity != null ? zza(activity.getClass().getCanonicalName()) : null, zzijVar.zzc, zzijVar.zze, zzijVar.zzf);
        } else {
            zzijVar2 = zzijVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzijVar2;
        zzp().zza(new zzik(this, zzijVar2, zzijVar3, zzl().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzij zzijVar, zzij zzijVar2, long j, boolean z, Bundle bundle) {
        boolean z2;
        zzij zzijVar3;
        long zzb;
        zzc();
        boolean z3 = false;
        if (zzs().zza(zzas.zzas)) {
            z2 = z && this.zza != null;
            if (z2) {
                zza(this.zza, true, j);
            }
        } else {
            if (z && (zzijVar3 = this.zza) != null) {
                zza(zzijVar3, true, j);
            }
            z2 = false;
        }
        if ((zzijVar2 != null && zzijVar2.zzc == zzijVar.zzc && zzkv.zzc(zzijVar2.zzb, zzijVar.zzb) && zzkv.zzc(zzijVar2.zza, zzijVar.zza)) ? true : true) {
            Bundle bundle2 = new Bundle();
            if (zzs().zza(zzas.zzbu)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            Bundle bundle3 = bundle2;
            zza(zzijVar, bundle3, true);
            if (zzijVar2 != null) {
                if (zzijVar2.zza != null) {
                    bundle3.putString("_pn", zzijVar2.zza);
                }
                if (zzijVar2.zzb != null) {
                    bundle3.putString("_pc", zzijVar2.zzb);
                }
                bundle3.putLong("_pi", zzijVar2.zzc);
            }
            if (zzs().zza(zzas.zzas) && z2) {
                if (zznk.zzb() && zzs().zza(zzas.zzau)) {
                    zzb = zzj().zza(j);
                } else {
                    zzb = zzj().zzb.zzb();
                }
                if (zzb > 0) {
                    zzo().zza(bundle3, zzb);
                }
            }
            String str = "auto";
            if (zzs().zza(zzas.zzbu)) {
                if (!zzs().zzh().booleanValue()) {
                    bundle3.putLong("_mst", 1L);
                }
                if (zzijVar.zze) {
                    str = "app";
                }
            }
            String str2 = str;
            if (zzs().zza(zzas.zzbu)) {
                long currentTimeMillis = zzl().currentTimeMillis();
                if (zzijVar.zze && zzijVar.zzf != 0) {
                    currentTimeMillis = zzijVar.zzf;
                }
                zze().zza(str2, "_vs", currentTimeMillis, bundle3);
            } else {
                zze().zzb(str2, "_vs", bundle3);
            }
        }
        this.zza = zzijVar;
        if (zzs().zza(zzas.zzbu) && zzijVar.zze) {
            this.zzh = zzijVar;
        }
        zzg().zza(zzijVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzij zzijVar, boolean z, long j) {
        zzd().zza(zzl().elapsedRealtime());
        if (!zzj().zza(zzijVar != null && zzijVar.zzd, z, j) || zzijVar == null) {
            return;
        }
        zzijVar.zzd = false;
    }

    public static void zza(zzij zzijVar, Bundle bundle, boolean z) {
        if (bundle == null || zzijVar == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && zzijVar == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        if (zzijVar.zza != null) {
            bundle.putString("_sn", zzijVar.zza);
        } else {
            bundle.remove("_sn");
        }
        if (zzijVar.zzb != null) {
            bundle.putString("_sc", zzijVar.zzb);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", zzijVar.zzc);
    }

    public final void zza(String str, zzij zzijVar) {
        zzc();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zzijVar != null) {
                this.zzl = str;
                this.zzk = zzijVar;
            }
        }
    }

    private static String zza(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzij zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzij zzijVar = this.zzd.get(activity);
        if (zzijVar == null) {
            zzij zzijVar2 = new zzij(null, zza(activity.getClass().getCanonicalName()), zzo().zzf());
            this.zzd.put(activity, zzijVar2);
            zzijVar = zzijVar2;
        }
        return (zzs().zza(zzas.zzbu) && this.zzg != null) ? this.zzg : zzijVar;
    }

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!zzs().zzh().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzij(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zza(Activity activity) {
        if (zzs().zza(zzas.zzbu)) {
            synchronized (this.zzj) {
                this.zzi = true;
                if (activity != this.zze) {
                    synchronized (this.zzj) {
                        this.zze = activity;
                        this.zzf = false;
                    }
                    if (zzs().zza(zzas.zzbt) && zzs().zzh().booleanValue()) {
                        this.zzg = null;
                        zzp().zza(new zzio(this));
                    }
                }
            }
        }
        if (zzs().zza(zzas.zzbt) && !zzs().zzh().booleanValue()) {
            this.zzb = this.zzg;
            zzp().zza(new zzin(this));
            return;
        }
        zza(activity, zzd(activity), false);
        zza zzd = zzd();
        zzd.zzp().zza(new zze(zzd, zzd.zzl().elapsedRealtime()));
    }

    public final void zzb(Activity activity) {
        if (zzs().zza(zzas.zzbu)) {
            synchronized (this.zzj) {
                this.zzi = false;
                this.zzf = true;
            }
        }
        long elapsedRealtime = zzl().elapsedRealtime();
        if (zzs().zza(zzas.zzbt) && !zzs().zzh().booleanValue()) {
            this.zzb = null;
            zzp().zza(new zzim(this, elapsedRealtime));
            return;
        }
        zzij zzd = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzp().zza(new zzip(this, zzd, elapsedRealtime));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzij zzijVar;
        if (!zzs().zzh().booleanValue() || bundle == null || (zzijVar = this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzijVar.zzc);
        bundle2.putString("name", zzijVar.zza);
        bundle2.putString("referrer_name", zzijVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zzs().zzh().booleanValue()) {
            this.zzd.remove(activity);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzen zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzir zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzii zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzem zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjx zzj() {
        return super.zzj();
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

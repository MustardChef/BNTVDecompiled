package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzml;
import com.google.firebase.messaging.Constants;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public class zzfu implements zzgt {
    private static volatile zzfu zzb;
    final long zza;
    private Boolean zzaa;
    private long zzab;
    private volatile Boolean zzac;
    private Boolean zzad;
    private Boolean zzae;
    private volatile boolean zzaf;
    private int zzag;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzw zzh;
    private final zzab zzi;
    private final zzfc zzj;
    private final zzeq zzk;
    private final zzfr zzl;
    private final zzjx zzm;
    private final zzkv zzn;
    private final zzeo zzo;
    private final Clock zzp;
    private final zzii zzq;
    private final zzhb zzr;
    private final zza zzs;
    private final zzid zzt;
    private zzem zzu;
    private zzir zzv;
    private zzak zzw;
    private zzen zzx;
    private zzfl zzy;
    private boolean zzz = false;
    private AtomicInteger zzah = new AtomicInteger(0);

    private zzfu(zzgy zzgyVar) {
        long currentTimeMillis;
        boolean z = false;
        Preconditions.checkNotNull(zzgyVar);
        zzw zzwVar = new zzw(zzgyVar.zza);
        this.zzh = zzwVar;
        zzeg.zza = zzwVar;
        Context context = zzgyVar.zza;
        this.zzc = context;
        this.zzd = zzgyVar.zzb;
        this.zze = zzgyVar.zzc;
        this.zzf = zzgyVar.zzd;
        this.zzg = zzgyVar.zzh;
        this.zzac = zzgyVar.zze;
        this.zzaf = true;
        com.google.android.gms.internal.measurement.zzae zzaeVar = zzgyVar.zzg;
        if (zzaeVar != null && zzaeVar.zzg != null) {
            Object obj = zzaeVar.zzg.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzad = (Boolean) obj;
            }
            Object obj2 = zzaeVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzae = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzdh.zza(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        if (zzgyVar.zzi != null) {
            currentTimeMillis = zzgyVar.zzi.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zza = currentTimeMillis;
        this.zzi = new zzab(this);
        zzfc zzfcVar = new zzfc(this);
        zzfcVar.zzac();
        this.zzj = zzfcVar;
        zzeq zzeqVar = new zzeq(this);
        zzeqVar.zzac();
        this.zzk = zzeqVar;
        zzkv zzkvVar = new zzkv(this);
        zzkvVar.zzac();
        this.zzn = zzkvVar;
        zzeo zzeoVar = new zzeo(this);
        zzeoVar.zzac();
        this.zzo = zzeoVar;
        this.zzs = new zza(this);
        zzii zziiVar = new zzii(this);
        zziiVar.zzw();
        this.zzq = zziiVar;
        zzhb zzhbVar = new zzhb(this);
        zzhbVar.zzw();
        this.zzr = zzhbVar;
        zzjx zzjxVar = new zzjx(this);
        zzjxVar.zzw();
        this.zzm = zzjxVar;
        zzid zzidVar = new zzid(this);
        zzidVar.zzac();
        this.zzt = zzidVar;
        zzfr zzfrVar = new zzfr(this);
        zzfrVar.zzac();
        this.zzl = zzfrVar;
        if (zzgyVar.zzg != null && zzgyVar.zzg.zzb != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            zzhb zzg = zzg();
            if (zzg.zzm().getApplicationContext() instanceof Application) {
                Application application = (Application) zzg.zzm().getApplicationContext();
                if (zzg.zza == null) {
                    zzg.zza = new zzhy(zzg, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(zzg.zza);
                    application.registerActivityLifecycleCallbacks(zzg.zza);
                    zzg.zzq().zzw().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzq().zzh().zza("Application context is not an Application");
        }
        zzfrVar.zza(new zzfw(this, zzgyVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzgy zzgyVar) {
        String concat;
        zzes zzesVar;
        zzp().zzc();
        zzak zzakVar = new zzak(this);
        zzakVar.zzac();
        this.zzw = zzakVar;
        zzen zzenVar = new zzen(this, zzgyVar.zzf);
        zzenVar.zzw();
        this.zzx = zzenVar;
        zzem zzemVar = new zzem(this);
        zzemVar.zzw();
        this.zzu = zzemVar;
        zzir zzirVar = new zzir(this);
        zzirVar.zzw();
        this.zzv = zzirVar;
        this.zzn.zzad();
        this.zzj.zzad();
        this.zzy = new zzfl(this);
        this.zzx.zzx();
        zzq().zzu().zza("App measurement initialized, version", 33025L);
        zzq().zzu().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzaa = zzenVar.zzaa();
        if (TextUtils.isEmpty(this.zzd)) {
            if (zzh().zze(zzaa)) {
                zzesVar = zzq().zzu();
                concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                zzes zzu = zzq().zzu();
                String valueOf = String.valueOf(zzaa);
                concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                zzesVar = zzu;
            }
            zzesVar.zza(concat);
        }
        zzq().zzv().zza("Debug-level message logging enabled");
        if (this.zzag != this.zzah.get()) {
            zzq().zze().zza("Not all components initialized", Integer.valueOf(this.zzag), Integer.valueOf(this.zzah.get()));
        }
        this.zzz = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
        if (r10.equals(com.google.android.gms.measurement.internal.zzac.zza) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.measurement.zzae r10) {
        /*
            Method dump skipped, instructions count: 870
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfu.zza(com.google.android.gms.internal.measurement.zzae):void");
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzw zzt() {
        return this.zzh;
    }

    public final zzab zza() {
        return this.zzi;
    }

    public final zzfc zzb() {
        zza((zzgr) this.zzj);
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzeq zzq() {
        zzb(this.zzk);
        return this.zzk;
    }

    public final zzeq zzc() {
        zzeq zzeqVar = this.zzk;
        if (zzeqVar == null || !zzeqVar.zzaa()) {
            return null;
        }
        return this.zzk;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final zzfr zzp() {
        zzb(this.zzl);
        return this.zzl;
    }

    public final zzjx zzd() {
        zzb(this.zzm);
        return this.zzm;
    }

    public final zzfl zze() {
        return this.zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfr zzf() {
        return this.zzl;
    }

    public final zzhb zzg() {
        zzb(this.zzr);
        return this.zzr;
    }

    public final zzkv zzh() {
        zza((zzgr) this.zzn);
        return this.zzn;
    }

    public final zzeo zzi() {
        zza((zzgr) this.zzo);
        return this.zzo;
    }

    public final zzem zzj() {
        zzb(this.zzu);
        return this.zzu;
    }

    private final zzid zzah() {
        zzb(this.zzt);
        return this.zzt;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Context zzm() {
        return this.zzc;
    }

    public final boolean zzk() {
        return TextUtils.isEmpty(this.zzd);
    }

    public final String zzn() {
        return this.zzd;
    }

    public final String zzo() {
        return this.zze;
    }

    public final String zzr() {
        return this.zzf;
    }

    public final boolean zzs() {
        return this.zzg;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public final Clock zzl() {
        return this.zzp;
    }

    public final zzii zzu() {
        zzb(this.zzq);
        return this.zzq;
    }

    public final zzir zzv() {
        zzb(this.zzv);
        return this.zzv;
    }

    public final zzak zzw() {
        zzb(this.zzw);
        return this.zzw;
    }

    public final zzen zzx() {
        zzb(this.zzx);
        return this.zzx;
    }

    public final zza zzy() {
        zza zzaVar = this.zzs;
        if (zzaVar != null) {
            return zzaVar;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzfu zza(Context context, com.google.android.gms.internal.measurement.zzae zzaeVar, Long l) {
        if (zzaeVar != null && (zzaeVar.zze == null || zzaeVar.zzf == null)) {
            zzaeVar = new com.google.android.gms.internal.measurement.zzae(zzaeVar.zza, zzaeVar.zzb, zzaeVar.zzc, zzaeVar.zzd, null, null, zzaeVar.zzg);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzfu.class) {
                if (zzb == null) {
                    zzb = new zzfu(new zzgy(context, zzaeVar, l));
                }
            }
        } else if (zzaeVar != null && zzaeVar.zzg != null && zzaeVar.zzg.containsKey("dataCollectionDefaultEnabled")) {
            zzb.zza(zzaeVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        return zzb;
    }

    private static void zzb(zzgq zzgqVar) {
        if (zzgqVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzgqVar.zzaa()) {
            return;
        }
        String valueOf = String.valueOf(zzgqVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void zzb(zzg zzgVar) {
        if (zzgVar == null) {
            throw new IllegalStateException("Component not created");
        }
        if (zzgVar.zzu()) {
            return;
        }
        String valueOf = String.valueOf(zzgVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    private static void zza(zzgr zzgrVar) {
        if (zzgrVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(boolean z) {
        this.zzac = Boolean.valueOf(z);
    }

    public final boolean zzz() {
        return this.zzac != null && this.zzac.booleanValue();
    }

    public final boolean zzaa() {
        return zzab() == 0;
    }

    public final int zzab() {
        zzp().zzc();
        if (this.zzi.zzf()) {
            return 1;
        }
        Boolean bool = this.zzae;
        if (bool == null || !bool.booleanValue()) {
            if (zzml.zzb() && this.zzi.zza(zzas.zzcg) && !zzac()) {
                return 8;
            }
            Boolean zzu = zzb().zzu();
            if (zzu != null) {
                return zzu.booleanValue() ? 0 : 3;
            }
            Boolean zzf = this.zzi.zzf("firebase_analytics_collection_enabled");
            if (zzf != null) {
                return zzf.booleanValue() ? 0 : 4;
            }
            Boolean bool2 = this.zzad;
            if (bool2 != null) {
                return bool2.booleanValue() ? 0 : 5;
            } else if (GoogleServices.isMeasurementExplicitlyDisabled()) {
                return 6;
            } else {
                return (!this.zzi.zza(zzas.zzar) || this.zzac == null || this.zzac.booleanValue()) ? 0 : 7;
            }
        }
        return 2;
    }

    public final void zzb(boolean z) {
        zzp().zzc();
        this.zzaf = z;
    }

    public final boolean zzac() {
        zzp().zzc();
        return this.zzaf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzad() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzgq zzgqVar) {
        this.zzag++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzg zzgVar) {
        this.zzag++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzae() {
        this.zzah.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzaf() {
        if (!this.zzz) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzp().zzc();
        Boolean bool = this.zzaa;
        if (bool == null || this.zzab == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzab) > 1000)) {
            this.zzab = this.zzp.elapsedRealtime();
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(zzh().zzc("android.permission.INTERNET") && zzh().zzc("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzy() || (zzfm.zza(this.zzc) && zzkv.zza(this.zzc, false))));
            this.zzaa = valueOf;
            if (valueOf.booleanValue()) {
                if (!zzh().zza(zzx().zzab(), zzx().zzac(), zzx().zzad()) && TextUtils.isEmpty(zzx().zzac())) {
                    z = false;
                }
                this.zzaa = Boolean.valueOf(z);
            }
        }
        return this.zzaa.booleanValue();
    }

    public final void zzag() {
        zzp().zzc();
        zzb(zzah());
        String zzaa = zzx().zzaa();
        Pair<String, Boolean> zza = zzb().zza(zzaa);
        if (!this.zzi.zzg().booleanValue() || ((Boolean) zza.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza.first)) {
            zzq().zzv().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
        } else if (!zzah().zzf()) {
            zzq().zzh().zza("Network is not available for Deferred Deep Link request. Skipping");
        } else {
            zzkv zzh = zzh();
            zzx();
            URL zza2 = zzh.zza(33025L, zzaa, (String) zza.first, zzb().zzt.zza() - 1);
            zzid zzah = zzah();
            zzic zzicVar = new zzic(this) { // from class: com.google.android.gms.measurement.internal.zzfx
                private final zzfu zza;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                }

                @Override // com.google.android.gms.measurement.internal.zzic
                public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
                    this.zza.zza(str, i, th, bArr, map);
                }
            };
            zzah.zzc();
            zzah.zzab();
            Preconditions.checkNotNull(zza2);
            Preconditions.checkNotNull(zzicVar);
            zzah.zzp().zzc(new zzif(zzah, zzaa, zza2, null, null, zzicVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            zzq().zzh().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        zzb().zzs.zza(true);
        if (bArr.length == 0) {
            zzq().zzv().zza("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(optString)) {
                zzq().zzv().zza("Deferred Deep Link is empty.");
                return;
            }
            zzkv zzh = zzh();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = zzh.zzm().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                zzq().zzh().zza("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.zzr.zza("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
            zzkv zzh2 = zzh();
            if (TextUtils.isEmpty(optString) || !zzh2.zza(optString, optDouble)) {
                return;
            }
            zzh2.zzm().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            zzq().zze().zza("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}

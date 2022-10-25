package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzml;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzpg;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzen extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzen(zzfu zzfuVar, long j) {
        super(zzfuVar);
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzy() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(32:1|(1:3)(6:103|104|(1:106)(2:121|(1:123))|107|108|(31:110|(1:112)(1:119)|114|115|5|(1:102)(1:9)|10|(1:101)(1:14)|15|(1:(1:18)(1:19))|(3:21|22|(17:25|26|(1:28)|29|30|(1:88)(1:34)|35|(1:37)(1:87)|38|39|(2:84|(1:86))(4:43|(1:45)(1:83)|46|(1:82))|(3:51|(1:53)(1:56)|54)|57|(3:59|(1:61)(3:63|(3:66|(1:68)|64)|69)|62)|(1:71)|72|(1:(2:75|76)(2:78|79))(2:80|81)))|100|26|(0)|29|30|(1:32)|88|35|(0)(0)|38|39|(1:41)|84|(0)|(0)|57|(0)|(0)|72|(0)(0)))|4|5|(1:7)|102|10|(1:12)|101|15|(0)|(0)|100|26|(0)|29|30|(0)|88|35|(0)(0)|38|39|(0)|84|(0)|(0)|57|(0)|(0)|72|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0253, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0254, code lost:
        zzq().zze().zza("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzeq.zza(r0), r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b9 A[Catch: IllegalStateException -> 0x0253, TryCatch #3 {IllegalStateException -> 0x0253, blocks: (B:62:0x01b3, B:64:0x01b9, B:66:0x01c5, B:68:0x01d4, B:72:0x01dd, B:75:0x01e7, B:77:0x01f3, B:81:0x020a, B:83:0x0212, B:90:0x0236, B:92:0x024a, B:94:0x024f, B:93:0x024d, B:85:0x0218, B:86:0x021f, B:88:0x0225, B:67:0x01d0), top: B:127:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e7 A[Catch: IllegalStateException -> 0x0253, TRY_ENTER, TryCatch #3 {IllegalStateException -> 0x0253, blocks: (B:62:0x01b3, B:64:0x01b9, B:66:0x01c5, B:68:0x01d4, B:72:0x01dd, B:75:0x01e7, B:77:0x01f3, B:81:0x020a, B:83:0x0212, B:90:0x0236, B:92:0x024a, B:94:0x024f, B:93:0x024d, B:85:0x0218, B:86:0x021f, B:88:0x0225, B:67:0x01d0), top: B:127:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0225 A[Catch: IllegalStateException -> 0x0253, TryCatch #3 {IllegalStateException -> 0x0253, blocks: (B:62:0x01b3, B:64:0x01b9, B:66:0x01c5, B:68:0x01d4, B:72:0x01dd, B:75:0x01e7, B:77:0x01f3, B:81:0x020a, B:83:0x0212, B:90:0x0236, B:92:0x024a, B:94:0x024f, B:93:0x024d, B:85:0x0218, B:86:0x021f, B:88:0x0225, B:67:0x01d0), top: B:127:0x01b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0236 A[Catch: IllegalStateException -> 0x0253, TryCatch #3 {IllegalStateException -> 0x0253, blocks: (B:62:0x01b3, B:64:0x01b9, B:66:0x01c5, B:68:0x01d4, B:72:0x01dd, B:75:0x01e7, B:77:0x01f3, B:81:0x020a, B:83:0x0212, B:90:0x0236, B:92:0x024a, B:94:0x024f, B:93:0x024d, B:85:0x0218, B:86:0x021f, B:88:0x0225, B:67:0x01d0), top: B:127:0x01b3 }] */
    @Override // com.google.android.gms.measurement.internal.zzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzz() {
        /*
            Method dump skipped, instructions count: 730
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzen.zzz():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzn zza(String str) {
        long min;
        zzc();
        String zzaa = zzaa();
        String zzab = zzab();
        zzv();
        String str2 = this.zzb;
        long zzae = zzae();
        zzv();
        String str3 = this.zzd;
        zzv();
        zzc();
        if (this.zzf == 0) {
            this.zzf = this.zzy.zzh().zza(zzm(), zzm().getPackageName());
        }
        long j = this.zzf;
        boolean zzaa2 = this.zzy.zzaa();
        boolean z = !zzr().zzq;
        zzc();
        String zzah = !this.zzy.zzaa() ? null : zzah();
        zzfu zzfuVar = this.zzy;
        Long valueOf = Long.valueOf(zzfuVar.zzb().zzh.zza());
        if (valueOf.longValue() == 0) {
            min = zzfuVar.zza;
        } else {
            min = Math.min(zzfuVar.zza, valueOf.longValue());
        }
        int zzaf = zzaf();
        boolean booleanValue = zzs().zzg().booleanValue();
        Boolean zzf = zzs().zzf("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(zzf == null || zzf.booleanValue()).booleanValue();
        zzfc zzr = zzr();
        zzr.zzc();
        boolean z2 = zzr.zzf().getBoolean("deferred_analytics_collection", false);
        String zzac = zzac();
        Boolean zzf2 = zzs().zzf("google_analytics_default_allow_ad_personalization_signals");
        return new zzn(zzaa, zzab, str2, zzae, str3, 33025L, j, str, zzaa2, z, zzah, 0L, min, zzaf, booleanValue, booleanValue2, z2, zzac, zzf2 == null ? null : Boolean.valueOf(true ^ zzf2.booleanValue()), this.zzg, this.zzh, (zznv.zzb() && zzs().zza(zzas.zzbi)) ? zzad() : null, (zzml.zzb() && zzs().zza(zzas.zzcg)) ? zzr().zzx().zza() : "");
    }

    private final String zzah() {
        if (zzpg.zzb() && zzs().zza(zzas.zzbk)) {
            zzq().zzw().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> loadClass = zzm().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzm());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    zzq().zzj().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzq().zzi().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzaa() {
        zzv();
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzab() {
        zzv();
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzac() {
        zzv();
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzad() {
        zzv();
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzae() {
        zzv();
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzaf() {
        zzv();
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> zzag() {
        return this.zzh;
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

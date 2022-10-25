package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgk */
/* loaded from: classes3.dex */
public final class zzgk extends zzzo<zzgk, zzgj> implements zzaas {
    private static final zzgk zzg;
    private zzgt zzb;
    private zzge zze;
    private int zzf;

    static {
        zzgk zzgkVar = new zzgk();
        zzg = zzgkVar;
        zzzo.zzy(zzgk.class, zzgkVar);
    }

    private zzgk() {
    }

    public static zzgj zzd() {
        return zzg.zzs();
    }

    public static zzgk zze() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzgk zzgkVar, zzgt zzgtVar) {
        zzgtVar.getClass();
        zzgkVar.zzb = zzgtVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzgk zzgkVar, zzge zzgeVar) {
        zzgeVar.getClass();
        zzgkVar.zze = zzgeVar;
    }

    public final zzgt zza() {
        zzgt zzgtVar = this.zzb;
        return zzgtVar == null ? zzgt.zze() : zzgtVar;
    }

    public final zzge zzb() {
        zzge zzgeVar = this.zze;
        return zzgeVar == null ? zzge.zzc() : zzgeVar;
    }

    public final zzgb zzc() {
        zzgb zzb = zzgb.zzb(this.zzf);
        return zzb == null ? zzgb.UNRECOGNIZED : zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzzo
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zzg;
                    }
                    return new zzgj(null);
                }
                return new zzgk();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

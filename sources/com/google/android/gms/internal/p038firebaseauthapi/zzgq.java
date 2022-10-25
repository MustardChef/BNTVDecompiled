package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgq */
/* loaded from: classes3.dex */
public final class zzgq extends zzzo<zzgq, zzgp> implements zzaas {
    private static final zzgq zzh;
    private int zzb;
    private zzgk zze;
    private zzym zzf = zzym.zzb;
    private zzym zzg = zzym.zzb;

    static {
        zzgq zzgqVar = new zzgq();
        zzh = zzgqVar;
        zzzo.zzy(zzgq.class, zzgqVar);
    }

    private zzgq() {
    }

    public static zzgq zze(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzgq) zzzo.zzE(zzh, zzymVar, zzzbVar);
    }

    public static zzgp zzf() {
        return zzh.zzs();
    }

    public static zzgq zzg() {
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzgq zzgqVar, zzgk zzgkVar) {
        zzgkVar.getClass();
        zzgqVar.zze = zzgkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzl(zzgq zzgqVar, zzym zzymVar) {
        zzymVar.getClass();
        zzgqVar.zzf = zzymVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzgq zzgqVar, zzym zzymVar) {
        zzymVar.getClass();
        zzgqVar.zzg = zzymVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzgk zzb() {
        zzgk zzgkVar = this.zze;
        return zzgkVar == null ? zzgk.zze() : zzgkVar;
    }

    public final zzym zzc() {
        return this.zzf;
    }

    public final zzym zzd() {
        return this.zzg;
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
                        return zzh;
                    }
                    return new zzgp(null);
                }
                return new zzgq();
            }
            return zzz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}

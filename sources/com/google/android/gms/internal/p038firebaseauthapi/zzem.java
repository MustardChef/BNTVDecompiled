package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzem */
/* loaded from: classes3.dex */
public final class zzem extends zzzo<zzem, zzel> implements zzaas {
    private static final zzem zzg;
    private int zzb;
    private zzes zze;
    private zzhd zzf;

    static {
        zzem zzemVar = new zzem();
        zzg = zzemVar;
        zzzo.zzy(zzem.class, zzemVar);
    }

    private zzem() {
    }

    public static zzem zzd(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzem) zzzo.zzE(zzg, zzymVar, zzzbVar);
    }

    public static zzel zze() {
        return zzg.zzs();
    }

    public static /* synthetic */ void zzh(zzem zzemVar, zzes zzesVar) {
        zzesVar.getClass();
        zzemVar.zze = zzesVar;
    }

    public static /* synthetic */ void zzi(zzem zzemVar, zzhd zzhdVar) {
        zzhdVar.getClass();
        zzemVar.zzf = zzhdVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzes zzb() {
        zzes zzesVar = this.zze;
        return zzesVar == null ? zzes.zzf() : zzesVar;
    }

    public final zzhd zzc() {
        zzhd zzhdVar = this.zzf;
        return zzhdVar == null ? zzhd.zzf() : zzhdVar;
    }

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
                    return new zzel(null);
                }
                return new zzem();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

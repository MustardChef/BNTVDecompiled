package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhd */
/* loaded from: classes3.dex */
public final class zzhd extends zzzo<zzhd, zzhc> implements zzaas {
    private static final zzhd zzg;
    private int zzb;
    private zzhj zze;
    private zzym zzf = zzym.zzb;

    static {
        zzhd zzhdVar = new zzhd();
        zzg = zzhdVar;
        zzzo.zzy(zzhd.class, zzhdVar);
    }

    private zzhd() {
    }

    public static zzhd zzd(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzhd) zzzo.zzE(zzg, zzymVar, zzzbVar);
    }

    public static zzhc zze() {
        return zzg.zzs();
    }

    public static zzhd zzf() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzhd zzhdVar, zzhj zzhjVar) {
        zzhjVar.getClass();
        zzhdVar.zze = zzhjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzhd zzhdVar, zzym zzymVar) {
        zzymVar.getClass();
        zzhdVar.zzf = zzymVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhj zzb() {
        zzhj zzhjVar = this.zze;
        return zzhjVar == null ? zzhj.zzd() : zzhjVar;
    }

    public final zzym zzc() {
        return this.zzf;
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
                    return new zzhc(null);
                }
                return new zzhd();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

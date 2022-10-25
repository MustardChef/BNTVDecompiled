package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhg */
/* loaded from: classes3.dex */
public final class zzhg extends zzzo<zzhg, zzhf> implements zzaas {
    private static final zzhg zzg;
    private zzhj zzb;
    private int zze;
    private int zzf;

    static {
        zzhg zzhgVar = new zzhg();
        zzg = zzhgVar;
        zzzo.zzy(zzhg.class, zzhgVar);
    }

    private zzhg() {
    }

    public static zzhg zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzhg) zzzo.zzE(zzg, zzymVar, zzzbVar);
    }

    public static zzhf zzd() {
        return zzg.zzs();
    }

    public static zzhg zze() {
        return zzg;
    }

    public static /* synthetic */ void zzg(zzhg zzhgVar, zzhj zzhjVar) {
        zzhjVar.getClass();
        zzhgVar.zzb = zzhjVar;
    }

    public final zzhj zza() {
        zzhj zzhjVar = this.zzb;
        return zzhjVar == null ? zzhj.zzd() : zzhjVar;
    }

    public final int zzb() {
        return this.zze;
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
                    return new zzhf(null);
                }
                return new zzhg();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

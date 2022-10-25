package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzep */
/* loaded from: classes3.dex */
public final class zzep extends zzzo<zzep, zzeo> implements zzaas {
    private static final zzep zzf;
    private zzev zzb;
    private zzhg zze;

    static {
        zzep zzepVar = new zzep();
        zzf = zzepVar;
        zzzo.zzy(zzep.class, zzepVar);
    }

    private zzep() {
    }

    public static zzep zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzep) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzeo zzd() {
        return zzf.zzs();
    }

    public static /* synthetic */ void zzf(zzep zzepVar, zzev zzevVar) {
        zzevVar.getClass();
        zzepVar.zzb = zzevVar;
    }

    public static /* synthetic */ void zzg(zzep zzepVar, zzhg zzhgVar) {
        zzhgVar.getClass();
        zzepVar.zze = zzhgVar;
    }

    public final zzev zza() {
        zzev zzevVar = this.zzb;
        return zzevVar == null ? zzev.zze() : zzevVar;
    }

    public final zzhg zzb() {
        zzhg zzhgVar = this.zze;
        return zzhgVar == null ? zzhg.zze() : zzhgVar;
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
                        return zzf;
                    }
                    return new zzeo(null);
                }
                return new zzep();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

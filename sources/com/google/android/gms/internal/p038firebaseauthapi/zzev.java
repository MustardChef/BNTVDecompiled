package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzev */
/* loaded from: classes3.dex */
public final class zzev extends zzzo<zzev, zzeu> implements zzaas {
    private static final zzev zzf;
    private zzey zzb;
    private int zze;

    static {
        zzev zzevVar = new zzev();
        zzf = zzevVar;
        zzzo.zzy(zzev.class, zzevVar);
    }

    private zzev() {
    }

    public static zzev zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzev) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzeu zzd() {
        return zzf.zzs();
    }

    public static zzev zze() {
        return zzf;
    }

    public static /* synthetic */ void zzg(zzev zzevVar, zzey zzeyVar) {
        zzeyVar.getClass();
        zzevVar.zzb = zzeyVar;
    }

    public final zzey zza() {
        zzey zzeyVar = this.zzb;
        return zzeyVar == null ? zzey.zzc() : zzeyVar;
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
                        return zzf;
                    }
                    return new zzeu(null);
                }
                return new zzev();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

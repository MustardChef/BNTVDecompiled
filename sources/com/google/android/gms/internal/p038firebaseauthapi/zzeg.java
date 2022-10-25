package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeg */
/* loaded from: classes3.dex */
public final class zzeg extends zzzo<zzeg, zzef> implements zzaas {
    private static final zzeg zzf;
    private int zzb;
    private zzej zze;

    static {
        zzeg zzegVar = new zzeg();
        zzf = zzegVar;
        zzzo.zzy(zzeg.class, zzegVar);
    }

    private zzeg() {
    }

    public static zzeg zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzeg) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzej zzb() {
        zzej zzejVar = this.zze;
        return zzejVar == null ? zzej.zzb() : zzejVar;
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
                    return new zzef(null);
                }
                return new zzeg();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzft */
/* loaded from: classes3.dex */
public final class zzft extends zzzo<zzft, zzfs> implements zzaas {
    private static final zzft zzf;
    private int zzb;
    private int zze;

    static {
        zzft zzftVar = new zzft();
        zzf = zzftVar;
        zzzo.zzy(zzft.class, zzftVar);
    }

    private zzft() {
    }

    public static zzft zzb(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzft) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public final int zza() {
        return this.zzb;
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
                    return new zzfs(null);
                }
                return new zzft();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzb"});
        }
        return (byte) 1;
    }
}

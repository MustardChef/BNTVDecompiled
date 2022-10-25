package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfn */
/* loaded from: classes3.dex */
public final class zzfn extends zzzo<zzfn, zzfm> implements zzaas {
    private static final zzfn zzf;
    private int zzb;
    private int zze;

    static {
        zzfn zzfnVar = new zzfn();
        zzf = zzfnVar;
        zzzo.zzy(zzfn.class, zzfnVar);
    }

    private zzfn() {
    }

    public static zzfn zzb(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzfn) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzfm zzc() {
        return zzf.zzs();
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
                    return new zzfm(null);
                }
                return new zzfn();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

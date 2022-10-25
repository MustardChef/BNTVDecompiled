package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzim */
/* loaded from: classes3.dex */
public final class zzim extends zzzo<zzim, zzil> implements zzaas {
    private static final zzim zze;
    private String zzb = "";

    static {
        zzim zzimVar = new zzim();
        zze = zzimVar;
        zzzo.zzy(zzim.class, zzimVar);
    }

    private zzim() {
    }

    public static zzim zzb(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzim) zzzo.zzE(zze, zzymVar, zzzbVar);
    }

    public static zzim zzc() {
        return zze;
    }

    public final String zza() {
        return this.zzb;
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
                        return zze;
                    }
                    return new zzil(null);
                }
                return new zzim();
            }
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzb"});
        }
        return (byte) 1;
    }
}

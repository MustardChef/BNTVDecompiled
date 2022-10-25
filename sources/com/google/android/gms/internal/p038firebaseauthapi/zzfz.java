package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfz */
/* loaded from: classes3.dex */
public final class zzfz extends zzzo<zzfz, zzfy> implements zzaas {
    private static final zzfz zzb;

    static {
        zzfz zzfzVar = new zzfz();
        zzb = zzfzVar;
        zzzo.zzy(zzfz.class, zzfzVar);
    }

    private zzfz() {
    }

    public static zzfz zza(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzfz) zzzo.zzE(zzb, zzymVar, zzzbVar);
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
                        return zzb;
                    }
                    return new zzfy(null);
                }
                return new zzfz();
            }
            return zzz(zzb, "\u0000\u0000", null);
        }
        return (byte) 1;
    }
}

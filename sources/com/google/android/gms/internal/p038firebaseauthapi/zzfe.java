package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfe */
/* loaded from: classes3.dex */
public final class zzfe extends zzzo<zzfe, zzfd> implements zzaas {
    private static final zzfe zzf;
    private zzfh zzb;
    private int zze;

    static {
        zzfe zzfeVar = new zzfe();
        zzf = zzfeVar;
        zzzo.zzy(zzfe.class, zzfeVar);
    }

    private zzfe() {
    }

    public static zzfe zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzfe) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzfd zzd() {
        return zzf.zzs();
    }

    public static /* synthetic */ void zzf(zzfe zzfeVar, zzfh zzfhVar) {
        zzfhVar.getClass();
        zzfeVar.zzb = zzfhVar;
    }

    public final zzfh zza() {
        zzfh zzfhVar = this.zzb;
        return zzfhVar == null ? zzfh.zzc() : zzfhVar;
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
                    return new zzfd(null);
                }
                return new zzfe();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfq */
/* loaded from: classes3.dex */
public final class zzfq extends zzzo<zzfq, zzfp> implements zzaas {
    private static final zzfq zzf;
    private int zzb;
    private zzym zze = zzym.zzb;

    static {
        zzfq zzfqVar = new zzfq();
        zzf = zzfqVar;
        zzzo.zzy(zzfq.class, zzfqVar);
    }

    private zzfq() {
    }

    public static zzfq zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzfq) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzfp zzd() {
        return zzf.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzfq zzfqVar, zzym zzymVar) {
        zzymVar.getClass();
        zzfqVar.zze = zzymVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzym zzb() {
        return this.zze;
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
                        return zzf;
                    }
                    return new zzfp(null);
                }
                return new zzfq();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

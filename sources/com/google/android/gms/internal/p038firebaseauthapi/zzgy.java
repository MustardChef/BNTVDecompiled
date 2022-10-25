package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgy */
/* loaded from: classes3.dex */
public final class zzgy extends zzzo<zzgy, zzgx> implements zzaas {
    private static final zzgy zzf;
    private zzym zzb = zzym.zzb;
    private zzig zze;

    static {
        zzgy zzgyVar = new zzgy();
        zzf = zzgyVar;
        zzzo.zzy(zzgy.class, zzgyVar);
    }

    private zzgy() {
    }

    public static zzgy zzb(byte[] bArr, zzzb zzzbVar) throws zzzw {
        return (zzgy) zzzo.zzF(zzf, bArr, zzzbVar);
    }

    public static zzgx zzc() {
        return zzf.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzgy zzgyVar, zzym zzymVar) {
        zzymVar.getClass();
        zzgyVar.zzb = zzymVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzf(zzgy zzgyVar, zzig zzigVar) {
        zzigVar.getClass();
        zzgyVar.zze = zzigVar;
    }

    public final zzym zza() {
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
                        return zzf;
                    }
                    return new zzgx(null);
                }
                return new zzgy();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

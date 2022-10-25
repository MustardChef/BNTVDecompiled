package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfw */
/* loaded from: classes3.dex */
public final class zzfw extends zzzo<zzfw, zzfv> implements zzaas {
    private static final zzfw zzf;
    private int zzb;
    private zzym zze = zzym.zzb;

    static {
        zzfw zzfwVar = new zzfw();
        zzf = zzfwVar;
        zzzo.zzy(zzfw.class, zzfwVar);
    }

    private zzfw() {
    }

    public static zzfw zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzfw) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzfv zzd() {
        return zzf.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzfw zzfwVar, zzym zzymVar) {
        zzymVar.getClass();
        zzfwVar.zze = zzymVar;
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
                    return new zzfv(null);
                }
                return new zzfw();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzes */
/* loaded from: classes3.dex */
public final class zzes extends zzzo<zzes, zzer> implements zzaas {
    private static final zzes zzg;
    private int zzb;
    private zzey zze;
    private zzym zzf = zzym.zzb;

    static {
        zzes zzesVar = new zzes();
        zzg = zzesVar;
        zzzo.zzy(zzes.class, zzesVar);
    }

    private zzes() {
    }

    public static zzes zzd(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzes) zzzo.zzE(zzg, zzymVar, zzzbVar);
    }

    public static zzer zze() {
        return zzg.zzs();
    }

    public static zzes zzf() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzes zzesVar, zzey zzeyVar) {
        zzeyVar.getClass();
        zzesVar.zze = zzeyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzes zzesVar, zzym zzymVar) {
        zzymVar.getClass();
        zzesVar.zzf = zzymVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzey zzb() {
        zzey zzeyVar = this.zze;
        return zzeyVar == null ? zzey.zzc() : zzeyVar;
    }

    public final zzym zzc() {
        return this.zzf;
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
                        return zzg;
                    }
                    return new zzer(null);
                }
                return new zzes();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

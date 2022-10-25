package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgn */
/* loaded from: classes3.dex */
public final class zzgn extends zzzo<zzgn, zzgm> implements zzaas {
    private static final zzgn zzg;
    private int zzb;
    private zzgq zze;
    private zzym zzf = zzym.zzb;

    static {
        zzgn zzgnVar = new zzgn();
        zzg = zzgnVar;
        zzzo.zzy(zzgn.class, zzgnVar);
    }

    private zzgn() {
    }

    public static zzgn zzd(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzgn) zzzo.zzE(zzg, zzymVar, zzzbVar);
    }

    public static zzgm zze() {
        return zzg.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzgn zzgnVar, zzgq zzgqVar) {
        zzgqVar.getClass();
        zzgnVar.zze = zzgqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzgn zzgnVar, zzym zzymVar) {
        zzymVar.getClass();
        zzgnVar.zzf = zzymVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzgq zzb() {
        zzgq zzgqVar = this.zze;
        return zzgqVar == null ? zzgq.zzg() : zzgqVar;
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
                    return new zzgm(null);
                }
                return new zzgn();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfb */
/* loaded from: classes3.dex */
public final class zzfb extends zzzo<zzfb, zzfa> implements zzaas {
    private static final zzfb zzg;
    private int zzb;
    private zzfh zze;
    private zzym zzf = zzym.zzb;

    static {
        zzfb zzfbVar = new zzfb();
        zzg = zzfbVar;
        zzzo.zzy(zzfb.class, zzfbVar);
    }

    private zzfb() {
    }

    public static zzfb zzd(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzfb) zzzo.zzE(zzg, zzymVar, zzzbVar);
    }

    public static zzfa zze() {
        return zzg.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzfb zzfbVar, zzfh zzfhVar) {
        zzfhVar.getClass();
        zzfbVar.zze = zzfhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzfb zzfbVar, zzym zzymVar) {
        zzymVar.getClass();
        zzfbVar.zzf = zzymVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzfh zzb() {
        zzfh zzfhVar = this.zze;
        return zzfhVar == null ? zzfh.zzc() : zzfhVar;
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
                    return new zzfa(null);
                }
                return new zzfb();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

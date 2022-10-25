package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzed */
/* loaded from: classes3.dex */
public final class zzed extends zzzo<zzed, zzec> implements zzaas {
    private static final zzed zzg;
    private int zzb;
    private zzym zze = zzym.zzb;
    private zzej zzf;

    static {
        zzed zzedVar = new zzed();
        zzg = zzedVar;
        zzzo.zzy(zzed.class, zzedVar);
    }

    private zzed() {
    }

    public static zzed zzd(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzed) zzzo.zzE(zzg, zzymVar, zzzbVar);
    }

    public static zzec zze() {
        return zzg.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzed zzedVar, zzym zzymVar) {
        zzymVar.getClass();
        zzedVar.zze = zzymVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzed zzedVar, zzej zzejVar) {
        zzejVar.getClass();
        zzedVar.zzf = zzejVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzym zzb() {
        return this.zze;
    }

    public final zzej zzc() {
        zzej zzejVar = this.zzf;
        return zzejVar == null ? zzej.zzb() : zzejVar;
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
                    return new zzec(null);
                }
                return new zzed();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

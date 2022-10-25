package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgt */
/* loaded from: classes3.dex */
public final class zzgt extends zzzo<zzgt, zzgs> implements zzaas {
    private static final zzgt zzg;
    private int zzb;
    private int zze;
    private zzym zzf = zzym.zzb;

    static {
        zzgt zzgtVar = new zzgt();
        zzg = zzgtVar;
        zzzo.zzy(zzgt.class, zzgtVar);
    }

    private zzgt() {
    }

    public static zzgs zzd() {
        return zzg.zzs();
    }

    public static zzgt zze() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzi(zzgt zzgtVar, zzym zzymVar) {
        zzymVar.getClass();
        zzgtVar.zzf = zzymVar;
    }

    public final zzgv zza() {
        zzgv zzb = zzgv.zzb(this.zzb);
        return zzb == null ? zzgv.UNRECOGNIZED : zzb;
    }

    public final zzha zzb() {
        zzha zzb = zzha.zzb(this.zze);
        return zzb == null ? zzha.UNRECOGNIZED : zzb;
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
                    return new zzgs(null);
                }
                return new zzgt();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

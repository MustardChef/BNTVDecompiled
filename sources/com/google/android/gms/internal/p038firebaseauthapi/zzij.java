package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij */
/* loaded from: classes3.dex */
public final class zzij extends zzzo<zzij, zzii> implements zzaas {
    private static final zzij zzf;
    private int zzb;
    private zzim zze;

    static {
        zzij zzijVar = new zzij();
        zzf = zzijVar;
        zzzo.zzy(zzij.class, zzijVar);
    }

    private zzij() {
    }

    public static zzij zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzij) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzii zzd() {
        return zzf.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzij zzijVar, zzim zzimVar) {
        zzimVar.getClass();
        zzijVar.zze = zzimVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzim zzb() {
        zzim zzimVar = this.zze;
        return zzimVar == null ? zzim.zzc() : zzimVar;
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
                    return new zzii(null);
                }
                return new zzij();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

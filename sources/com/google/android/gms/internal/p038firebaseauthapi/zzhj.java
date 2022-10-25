package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhj */
/* loaded from: classes3.dex */
public final class zzhj extends zzzo<zzhj, zzhi> implements zzaas {
    private static final zzhj zzf;
    private int zzb;
    private int zze;

    static {
        zzhj zzhjVar = new zzhj();
        zzf = zzhjVar;
        zzzo.zzy(zzhj.class, zzhjVar);
    }

    private zzhj() {
    }

    public static zzhi zzc() {
        return zzf.zzs();
    }

    public static zzhj zzd() {
        return zzf;
    }

    public final zzha zza() {
        zzha zzb = zzha.zzb(this.zzb);
        return zzb == null ? zzha.UNRECOGNIZED : zzb;
    }

    public final int zzb() {
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
                    return new zzhi(null);
                }
                return new zzhj();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

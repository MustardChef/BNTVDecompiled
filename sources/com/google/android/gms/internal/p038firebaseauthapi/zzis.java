package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzis */
/* loaded from: classes3.dex */
public final class zzis extends zzzo<zzis, zzir> implements zzaas {
    private static final zzis zzf;
    private String zzb = "";
    private zzht zze;

    static {
        zzis zzisVar = new zzis();
        zzf = zzisVar;
        zzzo.zzy(zzis.class, zzisVar);
    }

    private zzis() {
    }

    public static zzis zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzis) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzis zzd() {
        return zzf;
    }

    public final String zza() {
        return this.zzb;
    }

    public final zzht zzb() {
        zzht zzhtVar = this.zze;
        return zzhtVar == null ? zzht.zze() : zzhtVar;
    }

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
                    return new zzir(null);
                }
                return new zzis();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

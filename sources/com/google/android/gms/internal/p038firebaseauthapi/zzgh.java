package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgh */
/* loaded from: classes3.dex */
public final class zzgh extends zzzo<zzgh, zzgg> implements zzaas {
    private static final zzgh zze;
    private zzgk zzb;

    static {
        zzgh zzghVar = new zzgh();
        zze = zzghVar;
        zzzo.zzy(zzgh.class, zzghVar);
    }

    private zzgh() {
    }

    public static zzgh zzb(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzgh) zzzo.zzE(zze, zzymVar, zzzbVar);
    }

    public static zzgg zzc() {
        return zze.zzs();
    }

    public static /* synthetic */ void zze(zzgh zzghVar, zzgk zzgkVar) {
        zzgkVar.getClass();
        zzghVar.zzb = zzgkVar;
    }

    public final zzgk zza() {
        zzgk zzgkVar = this.zzb;
        return zzgkVar == null ? zzgk.zze() : zzgkVar;
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
                        return zze;
                    }
                    return new zzgg(null);
                }
                return new zzgh();
            }
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzb"});
        }
        return (byte) 1;
    }
}

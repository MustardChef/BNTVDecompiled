package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzip */
/* loaded from: classes3.dex */
public final class zzip extends zzzo<zzip, zzio> implements zzaas {
    private static final zzip zzf;
    private int zzb;
    private zzis zze;

    static {
        zzip zzipVar = new zzip();
        zzf = zzipVar;
        zzzo.zzy(zzip.class, zzipVar);
    }

    private zzip() {
    }

    public static zzip zzc(zzym zzymVar, zzzb zzzbVar) throws zzzw {
        return (zzip) zzzo.zzE(zzf, zzymVar, zzzbVar);
    }

    public static zzio zzd() {
        return zzf.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzip zzipVar, zzis zzisVar) {
        zzisVar.getClass();
        zzipVar.zze = zzisVar;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzis zzb() {
        zzis zzisVar = this.zze;
        return zzisVar == null ? zzis.zzd() : zzisVar;
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
                    return new zzio(null);
                }
                return new zzip();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        }
        return (byte) 1;
    }
}

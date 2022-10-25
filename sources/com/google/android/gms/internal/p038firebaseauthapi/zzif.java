package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzif */
/* loaded from: classes3.dex */
public final class zzif extends zzzo<zzif, zzie> implements zzaas {
    private static final zzif zzh;
    private String zzb = "";
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzif zzifVar = new zzif();
        zzh = zzifVar;
        zzzo.zzy(zzif.class, zzifVar);
    }

    private zzif() {
    }

    public static zzie zzb() {
        return zzh.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzif zzifVar, String str) {
        str.getClass();
        zzifVar.zzb = str;
    }

    public final int zza() {
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
                        return zzh;
                    }
                    return new zzie(null);
                }
                return new zzif();
            }
            return zzz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}

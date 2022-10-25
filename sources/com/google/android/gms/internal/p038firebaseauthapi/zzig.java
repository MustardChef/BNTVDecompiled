package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzig */
/* loaded from: classes3.dex */
public final class zzig extends zzzo<zzig, zzid> implements zzaas {
    private static final zzig zzf;
    private int zzb;
    private zzzt<zzif> zze = zzB();

    static {
        zzig zzigVar = new zzig();
        zzf = zzigVar;
        zzzo.zzy(zzig.class, zzigVar);
    }

    private zzig() {
    }

    public static zzid zzb() {
        return zzf.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzig zzigVar, zzif zzifVar) {
        zzifVar.getClass();
        zzzt<zzif> zzztVar = zzigVar.zze;
        if (!zzztVar.zza()) {
            zzigVar.zze = zzzo.zzC(zzztVar);
        }
        zzigVar.zze.add(zzifVar);
    }

    public final zzif zza(int i) {
        return this.zze.get(0);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzzo
    protected final Object zzj(int i, Object obj, Object obj2) {
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
                    return new zzid(null);
                }
                return new zzig();
            }
            return zzz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", zzif.class});
        }
        return (byte) 1;
    }
}

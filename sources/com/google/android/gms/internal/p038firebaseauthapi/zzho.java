package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzho */
/* loaded from: classes3.dex */
public final class zzho extends zzzo<zzho, zzhl> implements zzaas {
    private static final zzho zzg;
    private String zzb = "";
    private zzym zze = zzym.zzb;
    private int zzf;

    static {
        zzho zzhoVar = new zzho();
        zzg = zzhoVar;
        zzzo.zzy(zzho.class, zzhoVar);
    }

    private zzho() {
    }

    public static zzhl zzd() {
        return zzg.zzs();
    }

    public static zzho zze() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzho zzhoVar, String str) {
        str.getClass();
        zzhoVar.zzb = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzho zzhoVar, zzym zzymVar) {
        zzymVar.getClass();
        zzhoVar.zze = zzymVar;
    }

    public final String zza() {
        return this.zzb;
    }

    public final zzym zzb() {
        return this.zze;
    }

    public final zzhn zzc() {
        zzhn zzb = zzhn.zzb(this.zzf);
        return zzb == null ? zzhn.UNRECOGNIZED : zzb;
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
                        return zzg;
                    }
                    return new zzhl(null);
                }
                return new zzho();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

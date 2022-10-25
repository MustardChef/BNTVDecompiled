package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzht */
/* loaded from: classes3.dex */
public final class zzht extends zzzo<zzht, zzhs> implements zzaas {
    private static final zzht zzg;
    private String zzb = "";
    private zzym zze = zzym.zzb;
    private int zzf;

    static {
        zzht zzhtVar = new zzht();
        zzg = zzhtVar;
        zzzo.zzy(zzht.class, zzhtVar);
    }

    private zzht() {
    }

    public static zzhs zzd() {
        return zzg.zzs();
    }

    public static zzht zze() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(zzht zzhtVar, String str) {
        str.getClass();
        zzhtVar.zzb = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzht zzhtVar, zzym zzymVar) {
        zzymVar.getClass();
        zzhtVar.zze = zzymVar;
    }

    public final String zza() {
        return this.zzb;
    }

    public final zzym zzb() {
        return this.zze;
    }

    public final zziu zzc() {
        zziu zzb = zziu.zzb(this.zzf);
        return zzb == null ? zziu.UNRECOGNIZED : zzb;
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
                    return new zzhs(null);
                }
                return new zzht();
            }
            return zzz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

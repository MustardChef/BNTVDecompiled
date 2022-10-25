package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzge */
/* loaded from: classes3.dex */
public final class zzge extends zzzo<zzge, zzgd> implements zzaas {
    private static final zzge zze;
    private zzht zzb;

    static {
        zzge zzgeVar = new zzge();
        zze = zzgeVar;
        zzzo.zzy(zzge.class, zzgeVar);
    }

    private zzge() {
    }

    public static zzgd zzb() {
        return zze.zzs();
    }

    public static zzge zzc() {
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zze(zzge zzgeVar, zzht zzhtVar) {
        zzhtVar.getClass();
        zzgeVar.zzb = zzhtVar;
    }

    public final zzht zza() {
        zzht zzhtVar = this.zzb;
        return zzhtVar == null ? zzht.zze() : zzhtVar;
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
                        return zze;
                    }
                    return new zzgd(null);
                }
                return new zzge();
            }
            return zzz(zze, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzb"});
        }
        return (byte) 1;
    }
}

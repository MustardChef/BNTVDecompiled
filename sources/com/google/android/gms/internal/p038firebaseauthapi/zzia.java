package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzia */
/* loaded from: classes3.dex */
public final class zzia extends zzzo<zzia, zzhz> implements zzaas {
    private static final zzia zzh;
    private zzho zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzia zziaVar = new zzia();
        zzh = zziaVar;
        zzzo.zzy(zzia.class, zziaVar);
    }

    private zzia() {
    }

    public static zzhz zzf() {
        return zzh.zzs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzh(zzia zziaVar, zzho zzhoVar) {
        zzhoVar.getClass();
        zziaVar.zzb = zzhoVar;
    }

    public final boolean zza() {
        return this.zzb != null;
    }

    public final zzho zzb() {
        zzho zzhoVar = this.zzb;
        return zzhoVar == null ? zzho.zze() : zzhoVar;
    }

    public final zzhq zzc() {
        zzhq zzb = zzhq.zzb(this.zze);
        return zzb == null ? zzhq.UNRECOGNIZED : zzb;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final zziu zze() {
        zziu zzb = zziu.zzb(this.zzg);
        return zzb == null ? zziu.UNRECOGNIZED : zzb;
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
                        return zzh;
                    }
                    return new zzhz(null);
                }
                return new zzia();
            }
            return zzz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}

package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzmg implements zzec<zzmj> {
    private static zzmg zza = new zzmg();
    private final zzec<zzmj> zzb;

    public static boolean zzb() {
        return ((zzmj) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmj) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzmj) zza.zza()).zzc();
    }

    private zzmg(zzec<zzmj> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzmg() {
        this(zzef.zza(new zzmi()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmj zza() {
        return this.zzb.zza();
    }
}

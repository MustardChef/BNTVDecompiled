package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzoo implements zzec<zzor> {
    private static zzoo zza = new zzoo();
    private final zzec<zzor> zzb;

    public static boolean zzb() {
        return ((zzor) zza.zza()).zza();
    }

    public static double zzc() {
        return ((zzor) zza.zza()).zzb();
    }

    public static long zzd() {
        return ((zzor) zza.zza()).zzc();
    }

    public static long zze() {
        return ((zzor) zza.zza()).zzd();
    }

    public static String zzf() {
        return ((zzor) zza.zza()).zze();
    }

    private zzoo(zzec<zzor> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzoo() {
        this(zzef.zza(new zzoq()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzor zza() {
        return this.zzb.zza();
    }
}

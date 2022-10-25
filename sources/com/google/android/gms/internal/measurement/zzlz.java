package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzlz implements zzec<zzly> {
    private static zzlz zza = new zzlz();
    private final zzec<zzly> zzb;

    public static boolean zzb() {
        return ((zzly) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzly) zza.zza()).zzb();
    }

    private zzlz(zzec<zzly> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzlz() {
        this(zzef.zza(new zzmb()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzly zza() {
        return this.zzb.zza();
    }
}

package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzoz implements zzec<zzoy> {
    private static zzoz zza = new zzoz();
    private final zzec<zzoy> zzb;

    public static boolean zzb() {
        return ((zzoy) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzoy) zza.zza()).zzb();
    }

    private zzoz(zzec<zzoy> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzoz() {
        this(zzef.zza(new zzpb()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzoy zza() {
        return this.zzb.zza();
    }
}

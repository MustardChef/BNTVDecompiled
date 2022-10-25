package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzpr implements zzec<zzpq> {
    private static zzpr zza = new zzpr();
    private final zzec<zzpq> zzb;

    public static boolean zzb() {
        return ((zzpq) zza.zza()).zza();
    }

    private zzpr(zzec<zzpq> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzpr() {
        this(zzef.zza(new zzps()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpq zza() {
        return this.zzb.zza();
    }
}

package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzpf implements zzec<zzpe> {
    private static zzpf zza = new zzpf();
    private final zzec<zzpe> zzb;

    public static boolean zzb() {
        return ((zzpe) zza.zza()).zza();
    }

    private zzpf(zzec<zzpe> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzpf() {
        this(zzef.zza(new zzph()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpe zza() {
        return this.zzb.zza();
    }
}

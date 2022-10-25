package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzoi implements zzec<zzol> {
    private static zzoi zza = new zzoi();
    private final zzec<zzol> zzb;

    public static long zzb() {
        return ((zzol) zza.zza()).zza();
    }

    private zzoi(zzec<zzol> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzoi() {
        this(zzef.zza(new zzok()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzol zza() {
        return this.zzb.zza();
    }
}

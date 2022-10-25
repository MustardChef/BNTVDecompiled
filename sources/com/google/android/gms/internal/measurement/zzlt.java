package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzlt implements zzec<zzls> {
    private static zzlt zza = new zzlt();
    private final zzec<zzls> zzb;

    public static boolean zzb() {
        return ((zzls) zza.zza()).zza();
    }

    private zzlt(zzec<zzls> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzlt() {
        this(zzef.zza(new zzlv()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzls zza() {
        return this.zzb.zza();
    }
}

package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzou implements zzec<zzox> {
    private static zzou zza = new zzou();
    private final zzec<zzox> zzb;

    public static boolean zzb() {
        return ((zzox) zza.zza()).zza();
    }

    private zzou(zzec<zzox> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzou() {
        this(zzef.zza(new zzow()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzox zza() {
        return this.zzb.zza();
    }
}

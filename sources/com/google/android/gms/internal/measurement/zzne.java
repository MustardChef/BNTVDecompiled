package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzne implements zzec<zznh> {
    private static zzne zza = new zzne();
    private final zzec<zznh> zzb;

    public static boolean zzb() {
        return ((zznh) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznh) zza.zza()).zzb();
    }

    private zzne(zzec<zznh> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzne() {
        this(zzef.zza(new zzng()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznh zza() {
        return this.zzb.zza();
    }
}

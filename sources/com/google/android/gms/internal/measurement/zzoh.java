package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzoh implements zzec<zzog> {
    private static zzoh zza = new zzoh();
    private final zzec<zzog> zzb;

    public static boolean zzb() {
        return ((zzog) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzog) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzog) zza.zza()).zzc();
    }

    private zzoh(zzec<zzog> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzoh() {
        this(zzef.zza(new zzoj()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzog zza() {
        return this.zzb.zza();
    }
}

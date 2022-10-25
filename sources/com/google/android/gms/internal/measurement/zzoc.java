package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzoc implements zzec<zzof> {
    private static zzoc zza = new zzoc();
    private final zzec<zzof> zzb;

    public static boolean zzb() {
        return ((zzof) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzof) zza.zza()).zzb();
    }

    private zzoc(zzec<zzof> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzoc() {
        this(zzef.zza(new zzoe()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzof zza() {
        return this.zzb.zza();
    }
}

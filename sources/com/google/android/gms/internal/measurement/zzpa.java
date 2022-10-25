package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzpa implements zzec<zzpd> {
    private static zzpa zza = new zzpa();
    private final zzec<zzpd> zzb;

    public static boolean zzb() {
        return ((zzpd) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzpd) zza.zza()).zzb();
    }

    private zzpa(zzec<zzpd> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzpa() {
        this(zzef.zza(new zzpc()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpd zza() {
        return this.zzb.zza();
    }
}

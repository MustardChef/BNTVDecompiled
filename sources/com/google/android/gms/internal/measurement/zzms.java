package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzms implements zzec<zzmv> {
    private static zzms zza = new zzms();
    private final zzec<zzmv> zzb;

    public static boolean zzb() {
        return ((zzmv) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmv) zza.zza()).zzb();
    }

    private zzms(zzec<zzmv> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzms() {
        this(zzef.zza(new zzmu()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmv zza() {
        return this.zzb.zza();
    }
}

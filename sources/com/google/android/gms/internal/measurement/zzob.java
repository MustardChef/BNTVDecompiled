package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzob implements zzec<zzoa> {
    private static zzob zza = new zzob();
    private final zzec<zzoa> zzb;

    public static boolean zzb() {
        return ((zzoa) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzoa) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzoa) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzoa) zza.zza()).zzd();
    }

    private zzob(zzec<zzoa> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzob() {
        this(zzef.zza(new zzod()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzoa zza() {
        return this.zzb.zza();
    }
}

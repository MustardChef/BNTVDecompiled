package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zznp implements zzec<zzno> {
    private static zznp zza = new zznp();
    private final zzec<zzno> zzb;

    public static boolean zzb() {
        return ((zzno) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzno) zza.zza()).zzb();
    }

    private zznp(zzec<zzno> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zznp() {
        this(zzef.zza(new zznr()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzno zza() {
        return this.zzb.zza();
    }
}

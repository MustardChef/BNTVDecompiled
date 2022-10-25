package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zznk implements zzec<zznn> {
    private static zznk zza = new zznk();
    private final zzec<zznn> zzb;

    public static boolean zzb() {
        return ((zznn) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznn) zza.zza()).zzb();
    }

    private zznk(zzec<zznn> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zznk() {
        this(zzef.zza(new zznm()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznn zza() {
        return this.zzb.zza();
    }
}

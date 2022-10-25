package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzon implements zzec<zzom> {
    private static zzon zza = new zzon();
    private final zzec<zzom> zzb;

    public static boolean zzb() {
        return ((zzom) zza.zza()).zza();
    }

    private zzon(zzec<zzom> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzon() {
        this(zzef.zza(new zzop()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzom zza() {
        return this.zzb.zza();
    }
}

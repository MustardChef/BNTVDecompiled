package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zznq implements zzec<zznt> {
    private static zznq zza = new zznq();
    private final zzec<zznt> zzb;

    public static boolean zzb() {
        return ((zznt) zza.zza()).zza();
    }

    private zznq(zzec<zznt> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zznq() {
        this(zzef.zza(new zzns()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznt zza() {
        return this.zzb.zza();
    }
}

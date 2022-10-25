package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzmm implements zzec<zzmp> {
    private static zzmm zza = new zzmm();
    private final zzec<zzmp> zzb;

    public static boolean zzb() {
        return ((zzmp) zza.zza()).zza();
    }

    private zzmm(zzec<zzmp> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzmm() {
        this(zzef.zza(new zzmo()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmp zza() {
        return this.zzb.zza();
    }
}

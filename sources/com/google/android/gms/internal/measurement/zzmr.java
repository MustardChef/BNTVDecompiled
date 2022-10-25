package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzmr implements zzec<zzmq> {
    private static zzmr zza = new zzmr();
    private final zzec<zzmq> zzb;

    public static boolean zzb() {
        return ((zzmq) zza.zza()).zza();
    }

    private zzmr(zzec<zzmq> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzmr() {
        this(zzef.zza(new zzmt()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmq zza() {
        return this.zzb.zza();
    }
}

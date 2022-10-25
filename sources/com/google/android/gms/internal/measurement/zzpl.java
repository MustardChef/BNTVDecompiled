package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzpl implements zzec<zzpk> {
    private static zzpl zza = new zzpl();
    private final zzec<zzpk> zzb;

    public static boolean zzb() {
        return ((zzpk) zza.zza()).zza();
    }

    private zzpl(zzec<zzpk> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public zzpl() {
        this(zzef.zza(new zzpn()));
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpk zza() {
        return this.zzb.zza();
    }
}

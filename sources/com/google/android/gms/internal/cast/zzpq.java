package com.google.android.gms.internal.cast;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzpq implements zzqk {
    private static final zzpw zzb = new zzpo();
    private final zzpw zza;

    public zzpq() {
        zzpw zzpwVar;
        zzpw[] zzpwVarArr = new zzpw[2];
        zzpwVarArr[0] = zzoo.zza();
        try {
            zzpwVar = (zzpw) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            zzpwVar = zzb;
        }
        zzpwVarArr[1] = zzpwVar;
        zzpp zzppVar = new zzpp(zzpwVarArr);
        zzpb.zzb(zzppVar, "messageInfoFactory");
        this.zza = zzppVar;
    }

    private static boolean zzb(zzpv zzpvVar) {
        return zzpvVar.zzc() == 1;
    }

    @Override // com.google.android.gms.internal.cast.zzqk
    public final <T> zzqj<T> zza(Class<T> cls) {
        zzql.zza(cls);
        zzpv zzc = this.zza.zzc(cls);
        if (!zzc.zza()) {
            if (zzos.class.isAssignableFrom(cls)) {
                if (zzb(zzc)) {
                    return zzqb.zzg(cls, zzc, zzqe.zzb(), zzpm.zzd(), zzql.zzC(), zzok.zza(), zzpu.zzb());
                }
                return zzqb.zzg(cls, zzc, zzqe.zzb(), zzpm.zzd(), zzql.zzC(), null, zzpu.zzb());
            } else if (zzb(zzc)) {
                return zzqb.zzg(cls, zzc, zzqe.zza(), zzpm.zzc(), zzql.zzA(), zzok.zzb(), zzpu.zza());
            } else {
                return zzqb.zzg(cls, zzc, zzqe.zza(), zzpm.zzc(), zzql.zzB(), null, zzpu.zza());
            }
        } else if (zzos.class.isAssignableFrom(cls)) {
            return zzqc.zzg(zzql.zzC(), zzok.zza(), zzc.zzb());
        } else {
            return zzqc.zzg(zzql.zzA(), zzok.zzb(), zzc.zzb());
        }
    }
}

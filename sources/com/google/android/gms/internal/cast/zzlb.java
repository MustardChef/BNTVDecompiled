package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzlb extends zzos<zzlb, zzla> implements zzpz {
    private static final zzlb zzg;
    private int zzb;
    private String zze = "";
    private String zzf = "";

    static {
        zzlb zzlbVar = new zzlb();
        zzg = zzlbVar;
        zzos.zzu(zzlb.class, zzlbVar);
    }

    private zzlb() {
    }

    public static zzla zza() {
        return zzg.zzp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzd(zzlb zzlbVar, String str) {
        str.getClass();
        zzlbVar.zzb |= 1;
        zzlbVar.zze = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.cast.zzos
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zzg;
                    }
                    return new zzla(null);
                }
                return new zzlb();
            }
            return zzv(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zze", "zzf"});
        }
        return (byte) 1;
    }
}

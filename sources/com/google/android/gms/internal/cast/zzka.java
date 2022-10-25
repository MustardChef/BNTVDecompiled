package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzka extends zzos<zzka, zzjz> implements zzpz {
    private static final zzoy<Integer, zzjt> zzh = new zzjy();
    private static final zzka zzi;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private zzox zzg = zzx();

    static {
        zzka zzkaVar = new zzka();
        zzi = zzkaVar;
        zzos.zzu(zzka.class, zzkaVar);
    }

    private zzka() {
    }

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
                        return zzi;
                    }
                    return new zzjz(null);
                }
                return new zzka();
            }
            return zzv(zzi, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001e", new Object[]{"zzb", "zze", "zzf", "zzg", zzjt.zzc()});
        }
        return (byte) 1;
    }
}

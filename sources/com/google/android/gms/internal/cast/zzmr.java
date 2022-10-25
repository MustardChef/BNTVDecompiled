package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzmr extends zzos<zzmr, zzmq> implements zzpz {
    private static final zzmr zzh;
    private int zzb;
    private zzpa<zznd> zze = zzz();
    private zzpa<zzkz> zzf = zzz();
    private zzmz zzg;

    static {
        zzmr zzmrVar = new zzmr();
        zzh = zzmrVar;
        zzos.zzu(zzmr.class, zzmrVar);
    }

    private zzmr() {
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
                        return zzh;
                    }
                    return new zzmq(null);
                }
                return new zzmr();
            }
            return zzv(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zzb", "zze", zznd.class, "zzf", zzkz.class, "zzg"});
        }
        return (byte) 1;
    }
}

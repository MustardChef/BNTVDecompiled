package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzmx extends zzos<zzmx, zzmw> implements zzpz {
    private static final zzmx zzi;
    private int zzb;
    private String zze = "";
    private zzpa<zzlp> zzf = zzz();
    private zzpa<zzlb> zzg = zzz();
    private boolean zzh;

    static {
        zzmx zzmxVar = new zzmx();
        zzi = zzmxVar;
        zzos.zzu(zzmx.class, zzmxVar);
    }

    private zzmx() {
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
                    return new zzmw(null);
                }
                return new zzmx();
            }
            return zzv(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001", new Object[]{"zzb", "zze", "zzf", zzlp.class, "zzg", zzlb.class, "zzh"});
        }
        return (byte) 1;
    }
}

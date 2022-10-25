package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzlx extends zzos<zzlx, zzlw> implements zzpz {
    private static final zzlx zzi;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zzlx zzlxVar = new zzlx();
        zzi = zzlxVar;
        zzos.zzu(zzlx.class, zzlxVar);
    }

    private zzlx() {
    }

    @Override // com.google.android.gms.internal.cast.zzos
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            this.zzh = obj == null ? (byte) 0 : (byte) 1;
                            return null;
                        }
                        return zzi;
                    }
                    return new zzlw(null);
                }
                return new zzlx();
            }
            return zzv(zzi, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔌ\u0000\u0002င\u0001\u0003ဌ\u0002", new Object[]{"zzb", "zze", zzhl.zza(), "zzf", "zzg", zzjw.zza()});
        }
        return Byte.valueOf(this.zzh);
    }
}

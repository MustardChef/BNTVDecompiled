package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzkd extends zzos<zzkd, zzkc> implements zzpz {
    private static final zzoy<Integer, zzjt> zzi = new zzkb();
    private static final zzkd zzj;
    private int zzb;
    private zzkj zze;
    private zzlz zzf;
    private zzpa<zzlv> zzg = zzz();
    private zzox zzh = zzx();

    static {
        zzkd zzkdVar = new zzkd();
        zzj = zzkdVar;
        zzos.zzu(zzkd.class, zzkdVar);
    }

    private zzkd() {
    }

    public static zzkc zza() {
        return zzj.zzp();
    }

    public static /* synthetic */ void zzd(zzkd zzkdVar, zzkj zzkjVar) {
        zzkjVar.getClass();
        zzkdVar.zze = zzkjVar;
        zzkdVar.zzb |= 1;
    }

    public static /* synthetic */ void zze(zzkd zzkdVar, Iterable iterable) {
        zzox zzoxVar = zzkdVar.zzh;
        if (!zzoxVar.zza()) {
            int size = zzoxVar.size();
            zzkdVar.zzh = zzoxVar.zze(size == 0 ? 10 : size + size);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzkdVar.zzh.zzg(((zzjt) it.next()).zza());
        }
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
                        return zzj;
                    }
                    return new zzkc(null);
                }
                return new zzkd();
            }
            return zzv(zzj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001e", new Object[]{"zzb", "zze", "zzf", "zzg", zzlv.class, "zzh", zzjt.zzc()});
        }
        return (byte) 1;
    }
}

package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public final class zzkl extends zzos<zzkl, zzkk> implements zzpz {
    private static final zzkl zzp;
    private int zzb;
    private zzlb zze;
    private boolean zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zzmt zzm;
    private int zzn;
    private int zzo;

    static {
        zzkl zzklVar = new zzkl();
        zzp = zzklVar;
        zzos.zzu(zzkl.class, zzklVar);
    }

    private zzkl() {
    }

    public static zzkk zza() {
        return zzp.zzp();
    }

    public static zzkk zzc(zzkl zzklVar) {
        zzkk zzp2 = zzp.zzp();
        zzp2.zzq(zzklVar);
        return zzp2;
    }

    public static zzkl zzd() {
        return zzp;
    }

    public static /* synthetic */ void zzf(zzkl zzklVar, zzlb zzlbVar) {
        zzlbVar.getClass();
        zzklVar.zze = zzlbVar;
        zzklVar.zzb |= 1;
    }

    public static /* synthetic */ void zzg(zzkl zzklVar, boolean z) {
        zzklVar.zzb |= 2;
        zzklVar.zzf = z;
    }

    public static /* synthetic */ void zzh(zzkl zzklVar, long j) {
        zzklVar.zzb |= 4;
        zzklVar.zzg = j;
    }

    public static /* synthetic */ void zzi(zzkl zzklVar, int i) {
        zzklVar.zzb |= 64;
        zzklVar.zzk = i;
    }

    public static /* synthetic */ void zzj(zzkl zzklVar, int i) {
        zzklVar.zzb |= 128;
        zzklVar.zzl = i;
    }

    public static /* synthetic */ void zzk(zzkl zzklVar, int i) {
        zzklVar.zzb |= 1024;
        zzklVar.zzo = i;
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
                        return zzp;
                    }
                    return new zzkk(null);
                }
                return new zzkl();
            }
            return zzv(zzp, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007င\u0006\bင\u0007\tဉ\b\nဌ\t\u000bင\n", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzfh.zzb(), "zzj", zzfe.zza(), "zzk", "zzl", "zzm", "zzn", zzgo.zza(), "zzo"});
        }
        return (byte) 1;
    }
}

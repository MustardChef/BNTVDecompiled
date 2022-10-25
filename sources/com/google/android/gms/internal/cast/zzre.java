package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzre extends zzrg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzre(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final void zza(Object obj, long j, byte b) {
        if (zzrh.zzb) {
            zzrh.zzD(obj, j, b);
        } else {
            zzrh.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final boolean zzb(Object obj, long j) {
        if (zzrh.zzb) {
            return zzrh.zzv(obj, j);
        }
        return zzrh.zzw(obj, j);
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final void zzc(Object obj, long j, boolean z) {
        if (zzrh.zzb) {
            zzrh.zzD(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzrh.zzE(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(zzk(obj, j));
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final void zze(Object obj, long j, float f) {
        zzl(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(zzm(obj, j));
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final void zzg(Object obj, long j, double d) {
        zzn(obj, j, Double.doubleToLongBits(d));
    }
}

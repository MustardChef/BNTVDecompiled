package com.google.android.gms.internal.p038firebaseauthapi;

import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabz */
/* loaded from: classes3.dex */
final class zzabz extends zzacb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabz(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final byte zza(Object obj, long j) {
        byte zzG;
        byte zzF;
        if (zzacc.zzb) {
            zzF = zzacc.zzF(obj, j);
            return zzF;
        }
        zzG = zzacc.zzG(obj, j);
        return zzG;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final void zzb(Object obj, long j, byte b) {
        if (zzacc.zzb) {
            zzacc.zzH(obj, j, b);
        } else {
            zzacc.zzI(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final boolean zzc(Object obj, long j) {
        if (zzacc.zzb) {
            return zzacc.zzw(obj, j);
        }
        return zzacc.zzx(obj, j);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final void zzd(Object obj, long j, boolean z) {
        if (zzacc.zzb) {
            zzacc.zzH(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzacc.zzI(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final float zze(Object obj, long j) {
        return Float.intBitsToFloat(zzj(obj, j));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final void zzf(Object obj, long j, float f) {
        zzk(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final double zzg(Object obj, long j) {
        return Double.longBitsToDouble(zzl(obj, j));
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final void zzh(Object obj, long j, double d) {
        zzm(obj, j, Double.doubleToLongBits(d));
    }
}

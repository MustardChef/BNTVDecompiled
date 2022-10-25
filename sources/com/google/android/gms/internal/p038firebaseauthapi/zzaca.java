package com.google.android.gms.internal.p038firebaseauthapi;

import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaca */
/* loaded from: classes3.dex */
final class zzaca extends zzacb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaca(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final byte zza(Object obj, long j) {
        return this.zza.getByte(obj, j);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final void zzb(Object obj, long j, byte b) {
        this.zza.putByte(obj, j, b);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final boolean zzc(Object obj, long j) {
        return this.zza.getBoolean(obj, j);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final void zzd(Object obj, long j, boolean z) {
        this.zza.putBoolean(obj, j, z);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final float zze(Object obj, long j) {
        return this.zza.getFloat(obj, j);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final void zzf(Object obj, long j, float f) {
        this.zza.putFloat(obj, j, f);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final double zzg(Object obj, long j) {
        return this.zza.getDouble(obj, j);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzacb
    public final void zzh(Object obj, long j, double d) {
        this.zza.putDouble(obj, j, d);
    }
}

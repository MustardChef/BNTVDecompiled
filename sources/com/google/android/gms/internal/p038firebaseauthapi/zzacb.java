package com.google.android.gms.internal.p038firebaseauthapi;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacb */
/* loaded from: classes3.dex */
abstract class zzacb {
    final Unsafe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacb(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract byte zza(Object obj, long j);

    public abstract void zzb(Object obj, long j, byte b);

    public abstract boolean zzc(Object obj, long j);

    public abstract void zzd(Object obj, long j, boolean z);

    public abstract float zze(Object obj, long j);

    public abstract void zzf(Object obj, long j, float f);

    public abstract double zzg(Object obj, long j);

    public abstract void zzh(Object obj, long j, double d);

    public final long zzi(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final int zzj(Object obj, long j) {
        return this.zza.getInt(obj, j);
    }

    public final void zzk(Object obj, long j, int i) {
        this.zza.putInt(obj, j, i);
    }

    public final long zzl(Object obj, long j) {
        return this.zza.getLong(obj, j);
    }

    public final void zzm(Object obj, long j, long j2) {
        this.zza.putLong(obj, j, j2);
    }

    public final Object zzn(Object obj, long j) {
        return this.zza.getObject(obj, j);
    }

    public final void zzo(Object obj, long j, Object obj2) {
        this.zza.putObject(obj, j, obj2);
    }

    public final int zzp(Class<?> cls) {
        return this.zza.arrayBaseOffset(cls);
    }

    public final int zzq(Class<?> cls) {
        return this.zza.arrayIndexScale(cls);
    }
}

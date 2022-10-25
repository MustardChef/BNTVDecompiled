package com.google.android.gms.internal.p038firebaseauthapi;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacc */
/* loaded from: classes3.dex */
public final class zzacc {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd;
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzacb zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    /* JADX WARN: Removed duplicated region for block: B:40:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instructions count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p038firebaseauthapi.zzacc.<clinit>():void");
    }

    private zzacc() {
    }

    private static int zzA(Class<?> cls) {
        if (zzi) {
            return zzg.zzp(cls);
        }
        return -1;
    }

    private static int zzB(Class<?> cls) {
        if (zzi) {
            return zzg.zzq(cls);
        }
        return -1;
    }

    private static boolean zzC(Class<?> cls) {
        if (zzxw.zza()) {
            try {
                Class<?> cls2 = zzd;
                cls2.getMethod("peekLong", cls, Boolean.TYPE);
                cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
                cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
                cls2.getMethod("peekInt", cls, Boolean.TYPE);
                cls2.getMethod("pokeByte", cls, Byte.TYPE);
                cls2.getMethod("peekByte", cls);
                cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
                cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private static Field zzD() {
        Field zzE;
        if (!zzxw.zza() || (zzE = zzE(Buffer.class, "effectiveDirectAddress")) == null) {
            Field zzE2 = zzE(Buffer.class, "address");
            if (zzE2 == null || zzE2.getType() != Long.TYPE) {
                return null;
            }
            return zzE2;
        }
        return zzE;
    }

    private static Field zzE(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzF(Object obj, long j) {
        return (byte) ((zzg.zzj(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzG(Object obj, long j) {
        return (byte) ((zzg.zzj(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzH(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        zzacb zzacbVar = zzg;
        int zzj = zzacbVar.zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzacbVar.zzk(obj, j2, ((255 & b) << i) | (zzj & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzI(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        zzacb zzacbVar = zzg;
        int i = (((int) j) & 3) << 3;
        zzacbVar.zzk(obj, j2, ((255 & b) << i) | (zzacbVar.zzj(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza() {
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb() {
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzc(Class<T> cls) {
        try {
            return (T) zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(Object obj, long j) {
        return zzg.zzj(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zze(Object obj, long j, int i) {
        zzg.zzk(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzf(Object obj, long j) {
        return zzg.zzl(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzg(Object obj, long j, long j2) {
        zzg.zzm(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzh(Object obj, long j) {
        return zzg.zzc(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzi(Object obj, long j, boolean z) {
        zzg.zzd(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzj(Object obj, long j) {
        return zzg.zze(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzk(Object obj, long j, float f) {
        zzg.zzf(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzl(Object obj, long j) {
        return zzg.zzg(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzm(Object obj, long j, double d) {
        zzg.zzh(obj, j, d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzn(Object obj, long j) {
        return zzg.zzn(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzo(Object obj, long j, Object obj2) {
        zzg.zzo(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zzp(byte[] bArr, long j) {
        return zzg.zza(bArr, zza + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzq(byte[] bArr, long j, byte b) {
        zzg.zzb(bArr, zza + j, b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzr() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzabx());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzw(Object obj, long j) {
        return zzF(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzx(Object obj, long j) {
        return zzG(obj, j) != 0;
    }
}

package com.google.android.gms.internal.p038firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxw */
/* loaded from: classes3.dex */
final class zzxw {
    private static final Class<?> zza;
    private static final boolean zzb;

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName("libcore.io.Memory");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
        try {
            cls2 = Class.forName("org.robolectric.Robolectric");
        } catch (Throwable unused2) {
        }
        zzb = cls2 != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza() {
        return (zza == null || zzb) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> zzb() {
        return zza;
    }
}

package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.security.MessageDigest;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
@CheckReturnValue
/* loaded from: classes2.dex */
public class zzw {
    private static final zzw zzd = new zzw(true, null, null);
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzb = str;
        this.zzc = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzb() {
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzc(Callable<String> callable) {
        return new zzv(callable, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zzd(String str) {
        return new zzw(false, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzw zze(String str, Throwable th) {
        return new zzw(false, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzg(String str, zzi zziVar, boolean z, boolean z2) {
        String str2 = true != z2 ? "not allowed" : "debug cert rejected";
        MessageDigest zza = AndroidUtilsLight.zza("SHA-1");
        Preconditions.checkNotNull(zza);
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza.digest(zziVar.zzc())), Boolean.valueOf(z), "12451000.false");
    }

    @Nullable
    String zza() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.zzc != null) {
            Log.d("GoogleCertificatesRslt", zza(), this.zzc);
        } else {
            Log.d("GoogleCertificatesRslt", zza());
        }
    }
}

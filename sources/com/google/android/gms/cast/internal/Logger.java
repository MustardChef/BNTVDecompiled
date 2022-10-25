package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes2.dex */
public class Logger {
    protected final String zza;
    private final boolean zzb;
    private boolean zzc;
    private String zzd;

    public Logger(String str) {
        Preconditions.checkNotEmpty(str, "The log tag cannot be null or empty.");
        this.zza = str;
        this.zzb = str.length() <= 23;
        this.zzc = false;
    }

    /* renamed from: d */
    public void m369d(String str, Object... objArr) {
        if (zzb()) {
            Log.d(this.zza, zzd(str, objArr));
        }
    }

    /* renamed from: e */
    public void m367e(String str, Object... objArr) {
        Log.e(this.zza, zzd(str, objArr));
    }

    /* renamed from: i */
    public void m365i(String str, Object... objArr) {
        Log.i(this.zza, zzd(str, objArr));
    }

    /* renamed from: v */
    public void m363v(String str, Object... objArr) {
    }

    /* renamed from: w */
    public void m362w(String str, Object... objArr) {
        Log.w(this.zza, zzd(str, objArr));
    }

    public final void zza(String str) {
        this.zzd = TextUtils.isEmpty(null) ? null : String.format("[%s] ", null);
    }

    public final boolean zzb() {
        return this.zzc || (this.zzb && Log.isLoggable(this.zza, 3));
    }

    public final void zzc(boolean z) {
        this.zzc = true;
    }

    protected final String zzd(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        if (TextUtils.isEmpty(this.zzd)) {
            return str;
        }
        String valueOf = String.valueOf(this.zzd);
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* renamed from: e */
    public void m366e(Throwable th, String str, Object... objArr) {
        Log.e(this.zza, zzd(str, objArr), th);
    }

    /* renamed from: i */
    public void m364i(Throwable th, String str, Object... objArr) {
        Log.i(this.zza, zzd(str, objArr), th);
    }

    /* renamed from: w */
    public void m361w(Throwable th, String str, Object... objArr) {
        Log.w(this.zza, zzd(str, objArr), th);
    }

    /* renamed from: d */
    public void m368d(Throwable th, String str, Object... objArr) {
        if (zzb()) {
            Log.d(this.zza, zzd(str, objArr), th);
        }
    }
}

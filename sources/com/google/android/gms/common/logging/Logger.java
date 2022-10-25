package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    public Logger(String str, String... strArr) {
        String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append("] ");
            sb = sb2.toString();
        }
        this.zzb = sb;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    /* renamed from: d */
    public void m346d(String str, Throwable th, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr), th);
        }
    }

    /* renamed from: e */
    public void m344e(String str, Throwable th, Object... objArr) {
        Log.e(this.zza, format(str, objArr), th);
    }

    protected String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    public String getTag() {
        return this.zza;
    }

    /* renamed from: i */
    public void m342i(String str, Object... objArr) {
        Log.i(this.zza, format(str, objArr));
    }

    public boolean isLoggable(int i) {
        return this.zzd <= i;
    }

    /* renamed from: v */
    public void m341v(String str, Throwable th, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr), th);
        }
    }

    /* renamed from: w */
    public void m339w(String str, Object... objArr) {
        Log.w(this.zza, format(str, objArr));
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        Log.wtf(this.zza, format(str, objArr), th);
    }

    /* renamed from: e */
    public void m343e(String str, Object... objArr) {
        Log.e(this.zza, format(str, objArr));
    }

    public void wtf(Throwable th) {
        Log.wtf(this.zza, th);
    }

    /* renamed from: d */
    public void m345d(String str, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.zza, format(str, objArr));
        }
    }

    /* renamed from: v */
    public void m340v(String str, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.zza, format(str, objArr));
        }
    }
}

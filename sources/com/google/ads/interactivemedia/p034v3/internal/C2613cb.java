package com.google.ads.interactivemedia.p034v3.internal;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cb */
/* loaded from: classes2.dex */
public final class C2613cb {

    /* renamed from: a */
    private static final boolean f6929a = true;

    /* renamed from: a */
    public static void m2698a(String str, String str2, Throwable th) {
        Log.e(str, m2696c(str2, th));
    }

    /* renamed from: b */
    public static void m2697b(String str, String str2, Throwable th) {
        Log.w(str, m2696c(str2, th));
    }

    /* renamed from: c */
    private static String m2696c(String str, Throwable th) {
        String replace;
        if (th != null) {
            Throwable th2 = th;
            while (true) {
                if (th2 != null) {
                    if (th2 instanceof UnknownHostException) {
                        replace = "UnknownHostException (no network)";
                        break;
                    }
                    th2 = th2.getCause();
                } else {
                    replace = Log.getStackTraceString(th).trim().replace("\t", "    ");
                    break;
                }
            }
        } else {
            replace = null;
        }
        if (TextUtils.isEmpty(replace)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace2 = replace.replace("\n", "\n  ");
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(replace2).length());
        sb.append(valueOf);
        sb.append("\n  ");
        sb.append(replace2);
        sb.append('\n');
        return sb.toString();
    }
}

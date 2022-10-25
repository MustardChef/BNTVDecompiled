package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.ads.interactivemedia.p034v3.impl.data.C2467al;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anz */
/* loaded from: classes2.dex */
public final class anz {

    /* renamed from: a */
    private static final char[] f4771a = "0123456789abcdef".toCharArray();

    /* renamed from: a */
    public static long m4875a(double d, DisplayMetrics displayMetrics) {
        return Math.round(d / displayMetrics.density);
    }

    /* renamed from: b */
    public static Activity m4874b(View view) {
        View rootView = view.getRootView();
        if (rootView != null) {
            view = rootView;
        }
        Context context = view.getContext();
        for (int i = 0; (context instanceof ContextWrapper) && i < 10; i++) {
            if (!(context instanceof Activity)) {
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (Activity) context;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static String m4873c(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length + length];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i + i;
            char[] cArr2 = f4771a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: d */
    public static String m4872d(String str) {
        if (str == null || !str.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            return str;
        }
        UUID fromString = UUID.fromString(str);
        byte[] bArr = new byte[16];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.putLong(fromString.getMostSignificantBits());
        wrap.putLong(fromString.getLeastSignificantBits());
        return C2467al.m6016a(bArr, true);
    }

    /* renamed from: e */
    public static String m4871e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* renamed from: f */
    public static boolean m4870f() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: g */
    public static boolean m4869g(String str) {
        return str == null || str.isEmpty();
    }

    /* renamed from: h */
    public static boolean m4868h(DisplayMetrics displayMetrics) {
        return (displayMetrics == null || displayMetrics.density == 0.0f) ? false : true;
    }

    /* renamed from: i */
    public static byte[] m4867i(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("String must be of even-length");
        }
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}

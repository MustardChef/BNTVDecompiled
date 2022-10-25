package com.google.android.datatransport.runtime.logging;

import android.util.Log;

/* loaded from: classes2.dex */
public final class Logging {
    private Logging() {
    }

    private static String getTag(String str) {
        return "TransportRuntime." + str;
    }

    /* renamed from: d */
    public static void m421d(String str, String str2) {
        Log.d(getTag(str), str2);
    }

    /* renamed from: d */
    public static void m420d(String str, String str2, Object obj) {
        Log.d(getTag(str), String.format(str2, obj));
    }

    /* renamed from: d */
    public static void m419d(String str, String str2, Object obj, Object obj2) {
        Log.d(getTag(str), String.format(str2, obj, obj2));
    }

    /* renamed from: d */
    public static void m418d(String str, String str2, Object... objArr) {
        Log.d(getTag(str), String.format(str2, objArr));
    }

    /* renamed from: i */
    public static void m416i(String str, String str2) {
        Log.i(getTag(str), str2);
    }

    /* renamed from: e */
    public static void m417e(String str, String str2, Throwable th) {
        Log.e(getTag(str), str2, th);
    }

    /* renamed from: w */
    public static void m415w(String str, String str2, Object obj) {
        Log.w(getTag(str), String.format(str2, obj));
    }
}

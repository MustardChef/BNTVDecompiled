package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ang */
/* loaded from: classes2.dex */
public final class ang {

    /* renamed from: a */
    private NetworkCapabilities f4710a;

    ang(ConnectivityManager connectivityManager) {
        if (connectivityManager == null || Build.VERSION.SDK_INT < 24) {
            return;
        }
        try {
            connectivityManager.registerDefaultNetworkCallback(new anf(this));
        } catch (RuntimeException unused) {
            synchronized (ang.class) {
                this.f4710a = null;
            }
        }
    }

    /* renamed from: c */
    public static ang m4919c(Context context) {
        if (context != null) {
            return new ang((ConnectivityManager) context.getSystemService("connectivity"));
        }
        return null;
    }

    /* renamed from: a */
    public final long m4921a() {
        synchronized (ang.class) {
            NetworkCapabilities networkCapabilities = this.f4710a;
            if (networkCapabilities != null) {
                if (networkCapabilities.hasTransport(4)) {
                    return 2L;
                }
                if (this.f4710a.hasTransport(1)) {
                    return 1L;
                }
                if (this.f4710a.hasTransport(0)) {
                    return 0L;
                }
            }
            return -1L;
        }
    }

    /* renamed from: b */
    public final NetworkCapabilities m4920b() {
        return this.f4710a;
    }
}

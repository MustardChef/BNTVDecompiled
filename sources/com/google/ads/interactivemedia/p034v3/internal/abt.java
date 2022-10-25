package com.google.ads.interactivemedia.p034v3.internal;

import androidx.core.view.ViewCompat;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abt */
/* loaded from: classes2.dex */
class abt {

    /* renamed from: d */
    public final int f3107d;

    public abt(int i) {
        this.f3107d = i;
    }

    /* renamed from: e */
    public static int m5889e(int i) {
        return i & ViewCompat.MEASURED_SIZE_MASK;
    }

    /* renamed from: f */
    public static int m5888f(int i) {
        return (i >> 24) & 255;
    }

    /* renamed from: g */
    public static String m5887g(int i) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return m5887g(this.f3107d);
    }
}

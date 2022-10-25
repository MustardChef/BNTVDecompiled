package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ym */
/* loaded from: classes2.dex */
public final class C3218ym {

    /* renamed from: a */
    public static final C3218ym f9508a = new C3218ym(-3, C3282C.TIME_UNSET, -1);

    /* renamed from: b */
    private final int f9509b;

    /* renamed from: c */
    private final long f9510c;

    /* renamed from: d */
    private final long f9511d;

    private C3218ym(int i, long j, long j2) {
        this.f9509b = i;
        this.f9510c = j;
        this.f9511d = j2;
    }

    /* renamed from: d */
    public static C3218ym m525d(long j, long j2) {
        return new C3218ym(-1, j, j2);
    }

    /* renamed from: e */
    public static C3218ym m524e(long j) {
        return new C3218ym(0, C3282C.TIME_UNSET, j);
    }

    /* renamed from: f */
    public static C3218ym m523f(long j, long j2) {
        return new C3218ym(-2, j, j2);
    }
}

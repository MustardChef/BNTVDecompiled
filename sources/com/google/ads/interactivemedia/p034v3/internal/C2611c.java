package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioAttributes;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.c */
/* loaded from: classes2.dex */
public final class C2611c {

    /* renamed from: a */
    public static final C2611c f6917a = C2539ab.m5960d(1, 1);

    /* renamed from: b */
    public final int f6918b = 0;

    /* renamed from: c */
    public final int f6919c = 1;

    /* renamed from: d */
    public final int f6920d = 1;

    /* renamed from: e */
    private AudioAttributes f6921e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2611c(int i, int i2) {
    }

    /* renamed from: a */
    public final AudioAttributes m2707a() {
        if (this.f6921e == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
            if (C2628cq.f6961a >= 29) {
                usage.setAllowedCapturePolicy(1);
            }
            this.f6921e = usage.build();
        }
        return this.f6921e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2611c c2611c = (C2611c) obj;
        return true;
    }

    public final int hashCode() {
        return 15699889;
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xj */
/* loaded from: classes2.dex */
public final class C3188xj {
    /* renamed from: a */
    public static void m619a(Surface surface, float f) {
        try {
            surface.setFrameRate(f, f == 0.0f ? 0 : 1);
        } catch (IllegalStateException e) {
            C2613cb.m2698a("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
        }
    }
}

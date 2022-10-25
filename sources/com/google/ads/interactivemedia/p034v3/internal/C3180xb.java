package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.xb */
/* loaded from: classes2.dex */
public final class C3180xb extends Surface {

    /* renamed from: b */
    private static int f9355b;

    /* renamed from: c */
    private static boolean f9356c;

    /* renamed from: a */
    public final boolean f9357a;

    /* renamed from: d */
    private final HandlerThreadC3179xa f9358d;

    /* renamed from: e */
    private boolean f9359e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C3180xb(HandlerThreadC3179xa handlerThreadC3179xa, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.f9358d = handlerThreadC3179xa;
        this.f9357a = z;
    }

    /* renamed from: a */
    public static C3180xb m684a(Context context, boolean z) {
        boolean z2 = true;
        if (z && !m683b(context)) {
            z2 = false;
        }
        C2616ce.m2685h(z2);
        return new HandlerThreadC3179xa().m686a(z ? f9355b : 0);
    }

    /* renamed from: b */
    public static synchronized boolean m683b(Context context) {
        int i;
        String eglQueryString;
        String eglQueryString2;
        synchronized (C3180xb.class) {
            if (!f9356c) {
                int i2 = 2;
                if (C2628cq.f6961a >= 24 && ((C2628cq.f6961a >= 26 || (!"samsung".equals(C2628cq.f6963c) && !"XT1650".equals(C2628cq.f6964d))) && ((C2628cq.f6961a >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content")))) {
                    if (C2628cq.f6961a >= 17 && (eglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString2.contains("EGL_KHR_surfaceless_context")) {
                        i2 = 1;
                    }
                    f9355b = i2;
                    f9356c = true;
                }
                i2 = 0;
                f9355b = i2;
                f9356c = true;
            }
            i = f9355b;
        }
        return i != 0;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.f9358d) {
            if (!this.f9359e) {
                this.f9358d.m685b();
                this.f9359e = true;
            }
        }
    }
}

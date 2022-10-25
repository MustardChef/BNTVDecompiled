package com.google.ads.interactivemedia.p034v3.internal;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.os.Handler;
import android.util.Log;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bs */
/* loaded from: classes2.dex */
public final class RunnableC2603bs implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: a */
    private static final int[] f6902a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: b */
    private final Handler f6903b;

    /* renamed from: c */
    private final int[] f6904c = new int[1];

    /* renamed from: d */
    private EGLDisplay f6905d;

    /* renamed from: e */
    private EGLContext f6906e;

    /* renamed from: f */
    private EGLSurface f6907f;

    /* renamed from: g */
    private SurfaceTexture f6908g;

    public RunnableC2603bs(Handler handler) {
        this.f6903b = handler;
    }

    /* renamed from: a */
    public final SurfaceTexture m2713a() {
        SurfaceTexture surfaceTexture = this.f6908g;
        C2616ce.m2689d(surfaceTexture);
        return surfaceTexture;
    }

    /* renamed from: b */
    public final void m2712b(int i) {
        EGLConfig eGLConfig;
        EGLSurface eglCreatePbufferSurface;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay == null) {
            throw new C2602br("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            this.f6905d = eglGetDisplay;
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr2 = new int[1];
            boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, f6902a, 0, eGLConfigArr, 0, 1, iArr2, 0);
            if (!eglChooseConfig || iArr2[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
                throw new C2602br(C2628cq.m2577F("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr2[0]), eGLConfigArr[0]));
            }
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f6905d, eGLConfig, EGL14.EGL_NO_CONTEXT, i == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
            if (eglCreateContext != null) {
                this.f6906e = eglCreateContext;
                EGLDisplay eGLDisplay = this.f6905d;
                if (i == 1) {
                    eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
                } else {
                    eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                    if (eglCreatePbufferSurface == null) {
                        throw new C2602br("eglCreatePbufferSurface failed");
                    }
                }
                if (EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext)) {
                    this.f6907f = eglCreatePbufferSurface;
                    GLES20.glGenTextures(1, this.f6904c, 0);
                    int i2 = 0;
                    while (true) {
                        int glGetError = GLES20.glGetError();
                        if (glGetError == 0) {
                            break;
                        }
                        String valueOf = String.valueOf(GLU.gluErrorString(glGetError));
                        Log.e("GlUtil", valueOf.length() != 0 ? "glError ".concat(valueOf) : new String("glError "));
                        i2 = glGetError;
                    }
                    if (i2 != 0) {
                        String valueOf2 = String.valueOf(GLU.gluErrorString(i2));
                        Log.e("GlUtil", valueOf2.length() != 0 ? "glError ".concat(valueOf2) : new String("glError "));
                    }
                    SurfaceTexture surfaceTexture = new SurfaceTexture(this.f6904c[0]);
                    this.f6908g = surfaceTexture;
                    surfaceTexture.setOnFrameAvailableListener(this);
                    return;
                }
                throw new C2602br("eglMakeCurrent failed");
            }
            throw new C2602br("eglCreateContext failed");
        }
        throw new C2602br("eglInitialize failed");
    }

    /* renamed from: c */
    public final void m2711c() {
        this.f6903b.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f6908g;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f6904c, 0);
            }
            EGLDisplay eGLDisplay = this.f6905d;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglMakeCurrent(this.f6905d, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface = this.f6907f;
            if (eGLSurface != null && !eGLSurface.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f6905d, this.f6907f);
            }
            EGLContext eGLContext = this.f6906e;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f6905d, eGLContext);
            }
            if (C2628cq.f6961a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay2 = this.f6905d;
            if (eGLDisplay2 != null && !eGLDisplay2.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f6905d);
            }
            this.f6905d = null;
            this.f6906e = null;
            this.f6907f = null;
            this.f6908g = null;
        } catch (Throwable th) {
            EGLDisplay eGLDisplay3 = this.f6905d;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglMakeCurrent(this.f6905d, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f6907f;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f6905d, this.f6907f);
            }
            EGLContext eGLContext2 = this.f6906e;
            if (eGLContext2 != null) {
                EGL14.eglDestroyContext(this.f6905d, eGLContext2);
            }
            if (C2628cq.f6961a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay4 = this.f6905d;
            if (eGLDisplay4 != null && !eGLDisplay4.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f6905d);
            }
            this.f6905d = null;
            this.f6906e = null;
            this.f6907f = null;
            this.f6908g = null;
            throw th;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f6903b.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTexture surfaceTexture = this.f6908g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}

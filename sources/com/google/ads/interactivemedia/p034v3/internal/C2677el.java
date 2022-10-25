package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.el */
/* loaded from: classes2.dex */
public final class C2677el {

    /* renamed from: a */
    private final AudioManager f7108a;

    /* renamed from: b */
    private final C2675ej f7109b;

    /* renamed from: c */
    private InterfaceC2676ek f7110c;

    /* renamed from: d */
    private C2611c f7111d;

    /* renamed from: e */
    private int f7112e;

    /* renamed from: f */
    private int f7113f;

    /* renamed from: g */
    private float f7114g = 1.0f;

    /* renamed from: h */
    private AudioFocusRequest f7115h;

    public C2677el(Context context, Handler handler, InterfaceC2676ek interfaceC2676ek) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        C2616ce.m2689d(audioManager);
        this.f7108a = audioManager;
        this.f7110c = interfaceC2676ek;
        this.f7109b = new C2675ej(this, handler);
        this.f7112e = 0;
    }

    /* renamed from: f */
    private final void m2433f() {
        if (this.f7112e == 0) {
            return;
        }
        if (C2628cq.f6961a >= 26) {
            AudioFocusRequest audioFocusRequest = this.f7115h;
            if (audioFocusRequest != null) {
                this.f7108a.abandonAudioFocusRequest(audioFocusRequest);
            }
        } else {
            this.f7108a.abandonAudioFocus(this.f7109b);
        }
        m2431h(0);
    }

    /* renamed from: g */
    private final void m2432g(int i) {
        int m2139X;
        InterfaceC2676ek interfaceC2676ek = this.f7110c;
        if (interfaceC2676ek != null) {
            SurfaceHolder$CallbackC2743gx surfaceHolder$CallbackC2743gx = (SurfaceHolder$CallbackC2743gx) interfaceC2676ek;
            boolean m2141V = surfaceHolder$CallbackC2743gx.f7451a.m2141V();
            C2745gz c2745gz = surfaceHolder$CallbackC2743gx.f7451a;
            m2139X = C2745gz.m2139X(m2141V, i);
            c2745gz.m2133ad(m2141V, i, m2139X);
        }
    }

    /* renamed from: h */
    private final void m2431h(int i) {
        if (this.f7112e == i) {
            return;
        }
        this.f7112e = i;
        float f = i == 3 ? 0.2f : 1.0f;
        if (this.f7114g == f) {
            return;
        }
        this.f7114g = f;
        InterfaceC2676ek interfaceC2676ek = this.f7110c;
        if (interfaceC2676ek != null) {
            r2.m2135ab(1, 2, Float.valueOf(r2.f7480y * ((SurfaceHolder$CallbackC2743gx) interfaceC2676ek).f7451a.f7465j.m2438a()));
        }
    }

    /* renamed from: a */
    public final float m2438a() {
        return this.f7114g;
    }

    /* renamed from: b */
    public final int m2437b(boolean z, int i) {
        int requestAudioFocus;
        if (i == 1 || this.f7113f != 1) {
            m2433f();
            return z ? 1 : -1;
        } else if (z) {
            if (this.f7112e != 1) {
                if (C2628cq.f6961a >= 26) {
                    AudioFocusRequest audioFocusRequest = this.f7115h;
                    if (audioFocusRequest != null) {
                        requestAudioFocus = this.f7108a.requestAudioFocus(audioFocusRequest);
                    } else {
                        new AudioFocusRequest.Builder(this.f7113f);
                        C2616ce.m2689d(null);
                        throw null;
                    }
                } else {
                    AudioManager audioManager = this.f7108a;
                    C2675ej c2675ej = this.f7109b;
                    C2616ce.m2689d(null);
                    requestAudioFocus = audioManager.requestAudioFocus(c2675ej, 3, this.f7113f);
                }
                if (requestAudioFocus == 1) {
                    m2431h(1);
                } else {
                    m2431h(0);
                    return -1;
                }
            }
            return 1;
        } else {
            return -1;
        }
    }

    /* renamed from: d */
    public final void m2435d() {
        this.f7110c = null;
        m2433f();
    }

    /* renamed from: e */
    public final void m2434e(C2611c c2611c) {
        if (C2628cq.m2563T(null, null)) {
            return;
        }
        this.f7111d = null;
        this.f7113f = 0;
        C2616ce.m2686g(true, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* bridge */ /* synthetic */ void m2436c(C2677el c2677el, int i) {
        if (i == -3 || i == -2) {
            if (i == -2) {
                c2677el.m2432g(0);
                c2677el.m2431h(2);
                return;
            }
            c2677el.m2431h(3);
        } else if (i == -1) {
            c2677el.m2432g(-1);
            c2677el.m2433f();
        } else if (i == 1) {
            c2677el.m2431h(1);
            c2677el.m2432g(1);
        } else {
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unknown focus change type: ");
            sb.append(i);
            Log.w("AudioFocusManager", sb.toString());
        }
    }
}

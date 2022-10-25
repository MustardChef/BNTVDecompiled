package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.he */
/* loaded from: classes2.dex */
public final class C2751he {

    /* renamed from: a */
    private final Context f7489a;

    /* renamed from: b */
    private final Handler f7490b;

    /* renamed from: c */
    private final InterfaceC2748hb f7491c;

    /* renamed from: d */
    private final AudioManager f7492d;

    /* renamed from: e */
    private C2750hd f7493e;

    /* renamed from: f */
    private int f7494f;

    /* renamed from: g */
    private int f7495g;

    /* renamed from: h */
    private boolean f7496h;

    public C2751he(Context context, Handler handler, InterfaceC2748hb interfaceC2748hb) {
        Context applicationContext = context.getApplicationContext();
        this.f7489a = applicationContext;
        this.f7490b = handler;
        this.f7491c = interfaceC2748hb;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
        C2616ce.m2688e(audioManager);
        this.f7492d = audioManager;
        this.f7494f = 3;
        this.f7495g = m2100g(audioManager, 3);
        this.f7496h = m2098i(audioManager, this.f7494f);
        C2750hd c2750hd = new C2750hd(this);
        try {
            applicationContext.registerReceiver(c2750hd, new IntentFilter(SystemMediaRouteProvider.LegacyImpl.VolumeChangeReceiver.VOLUME_CHANGED_ACTION));
            this.f7493e = c2750hd;
        } catch (RuntimeException e) {
            C2613cb.m2697b("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    /* renamed from: d */
    public static /* bridge */ /* synthetic */ void m2103d(C2751he c2751he) {
        c2751he.m2099h();
    }

    /* renamed from: g */
    private static int m2100g(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            StringBuilder sb = new StringBuilder(60);
            sb.append("Could not retrieve stream volume for stream type ");
            sb.append(i);
            C2613cb.m2697b("StreamVolumeManager", sb.toString(), e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    /* renamed from: h */
    public final void m2099h() {
        CopyOnWriteArraySet copyOnWriteArraySet;
        int m2100g = m2100g(this.f7492d, this.f7494f);
        boolean m2098i = m2098i(this.f7492d, this.f7494f);
        if (this.f7495g == m2100g && this.f7496h == m2098i) {
            return;
        }
        this.f7495g = m2100g;
        this.f7496h = m2098i;
        copyOnWriteArraySet = ((SurfaceHolder$CallbackC2743gx) this.f7491c).f7451a.f7462g;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((InterfaceC2565au) it.next()).mo2052as();
        }
    }

    /* renamed from: i */
    private static boolean m2098i(AudioManager audioManager, int i) {
        if (C2628cq.f6961a >= 23) {
            return audioManager.isStreamMute(i);
        }
        return m2100g(audioManager, i) == 0;
    }

    /* renamed from: a */
    public final int m2106a() {
        return this.f7492d.getStreamMaxVolume(this.f7494f);
    }

    /* renamed from: b */
    public final int m2105b() {
        if (C2628cq.f6961a >= 28) {
            return this.f7492d.getStreamMinVolume(this.f7494f);
        }
        return 0;
    }

    /* renamed from: e */
    public final void m2102e() {
        C2750hd c2750hd = this.f7493e;
        if (c2750hd != null) {
            try {
                this.f7489a.unregisterReceiver(c2750hd);
            } catch (RuntimeException e) {
                C2613cb.m2697b("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.f7493e = null;
        }
    }

    /* renamed from: f */
    public final void m2101f(int i) {
        C2751he c2751he;
        C2773i m2138Y;
        C2773i c2773i;
        CopyOnWriteArraySet copyOnWriteArraySet;
        if (this.f7494f == 3) {
            return;
        }
        this.f7494f = 3;
        m2099h();
        SurfaceHolder$CallbackC2743gx surfaceHolder$CallbackC2743gx = (SurfaceHolder$CallbackC2743gx) this.f7491c;
        c2751he = surfaceHolder$CallbackC2743gx.f7451a.f7466k;
        m2138Y = C2745gz.m2138Y(c2751he);
        c2773i = surfaceHolder$CallbackC2743gx.f7451a.f7455C;
        if (m2138Y.equals(c2773i)) {
            return;
        }
        surfaceHolder$CallbackC2743gx.f7451a.f7455C = m2138Y;
        copyOnWriteArraySet = surfaceHolder$CallbackC2743gx.f7451a.f7462g;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((InterfaceC2565au) it.next()).mo2053ar();
        }
    }
}

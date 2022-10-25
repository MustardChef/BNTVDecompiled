package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2478aw;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2479ax;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b;
import com.google.ads.interactivemedia.p034v3.impl.data.C2456aa;
import com.google.ads.interactivemedia.p034v3.impl.data.C2522m;
import com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahz */
/* loaded from: classes2.dex */
public final class ahz implements ajs {

    /* renamed from: a */
    private final ajx f4108a;

    /* renamed from: b */
    private final String f4109b;

    /* renamed from: c */
    private final View f4110c;

    /* renamed from: d */
    private ahy f4111d;

    /* renamed from: e */
    private Activity f4112e;

    /* renamed from: f */
    private boolean f4113f;

    /* renamed from: g */
    private final C2456aa f4114g;

    public ahz(String str, ajx ajxVar, View view) {
        C2456aa c2456aa = new C2456aa();
        this.f4109b = str;
        this.f4108a = ajxVar;
        this.f4110c = view;
        this.f4114g = c2456aa;
        this.f4112e = null;
        this.f4111d = null;
        this.f4113f = false;
    }

    /* renamed from: l */
    private static int m5220l(int i, float f) {
        return (int) Math.ceil(i / f);
    }

    /* renamed from: m */
    private final DisplayMetrics m5219m() {
        return this.f4110c.getContext().getResources().getDisplayMetrics();
    }

    /* renamed from: n */
    private static AbstractC2479ax m5218n(AbstractC2479ax abstractC2479ax, float f) {
        AbstractC2478aw builder = AbstractC2479ax.builder();
        builder.left(m5220l(abstractC2479ax.left(), f));
        builder.top(m5220l(abstractC2479ax.top(), f));
        builder.height(m5220l(abstractC2479ax.height(), f));
        builder.width(m5220l(abstractC2479ax.width(), f));
        return builder.build();
    }

    /* renamed from: c */
    public final AbstractC2482b m5228c(String str, String str2, String str3) {
        AbstractC2479ax m5218n = m5218n(AbstractC2479ax.builder().locationOnScreenOfView(this.f4110c).build(), m5219m().density);
        Rect rect = new Rect();
        boolean globalVisibleRect = this.f4110c.getGlobalVisibleRect(rect);
        IBinder windowToken = this.f4110c.getWindowToken();
        boolean z = false;
        if (!globalVisibleRect || windowToken == null || !this.f4110c.isShown()) {
            rect.set(0, 0, 0, 0);
        }
        AbstractC2478aw builder = AbstractC2479ax.builder();
        builder.left(rect.left);
        builder.top(rect.top);
        builder.height(rect.height());
        builder.width(rect.width());
        AbstractC2479ax m5218n2 = m5218n(builder.build(), m5219m().density);
        z = (this.f4110c.getGlobalVisibleRect(new Rect()) && this.f4110c.isShown()) ? true : true;
        AudioManager audioManager = (AudioManager) this.f4110c.getContext().getSystemService("audio");
        double streamVolume = audioManager != null ? audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3) : 0.0d;
        long currentTimeMillis = System.currentTimeMillis();
        InterfaceC2455a builder2 = AbstractC2482b.builder();
        builder2.queryId(str);
        builder2.eventId(str2);
        builder2.appState(str3);
        builder2.nativeTime(currentTimeMillis);
        builder2.nativeVolume(streamVolume);
        builder2.nativeViewHidden(z);
        builder2.nativeViewBounds(m5218n);
        builder2.nativeViewVisibleBounds(m5218n2);
        return builder2.build();
    }

    /* renamed from: f */
    public final void m5225f() {
        this.f4108a.m5141d(this, this.f4109b);
    }

    /* renamed from: g */
    public final void m5224g() {
        this.f4108a.m5133m(this.f4109b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajs
    /* renamed from: h */
    public final void mo5155h(String str, String str2) {
        this.f4108a.mo5122o(new ajq(ajo.activityMonitor, ajp.viewability, this.f4109b, m5228c(str, str2, "")));
    }

    /* renamed from: i */
    public final void m5223i() {
        Application m5993a;
        if (!this.f4113f || (m5993a = C2522m.m5993a(this.f4110c.getContext())) == null) {
            return;
        }
        ahy ahyVar = new ahy(this);
        this.f4111d = ahyVar;
        m5993a.registerActivityLifecycleCallbacks(ahyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final void m5222j(boolean z) {
        this.f4113f = z;
    }

    /* renamed from: k */
    public final void m5221k() {
        ahy ahyVar;
        Application m5993a = C2522m.m5993a(this.f4110c.getContext());
        if (m5993a == null || (ahyVar = this.f4111d) == null) {
            return;
        }
        m5993a.unregisterActivityLifecycleCallbacks(ahyVar);
    }
}

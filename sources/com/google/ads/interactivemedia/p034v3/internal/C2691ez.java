package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.ExoPlayer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ez */
/* loaded from: classes2.dex */
public final class C2691ez {

    /* renamed from: a */
    final Context f7188a;

    /* renamed from: b */
    final InterfaceC2598bn f7189b;

    /* renamed from: c */
    final atn f7190c;

    /* renamed from: d */
    final atn f7191d;

    /* renamed from: e */
    final atn f7192e;

    /* renamed from: f */
    final atn f7193f;

    /* renamed from: g */
    final atn f7194g;

    /* renamed from: h */
    final atn f7195h;

    /* renamed from: i */
    final Looper f7196i;

    /* renamed from: j */
    final C2611c f7197j;

    /* renamed from: k */
    final int f7198k;

    /* renamed from: l */
    final boolean f7199l;

    /* renamed from: m */
    final C2740gu f7200m;

    /* renamed from: n */
    final long f7201n;

    /* renamed from: o */
    final long f7202o;

    /* renamed from: p */
    final long f7203p;

    /* renamed from: q */
    final long f7204q;

    /* renamed from: r */
    boolean f7205r;

    /* renamed from: s */
    final C2681ep f7206s;

    public C2691ez(Context context, ale aleVar) {
        C2690ey c2690ey = new C2690ey(aleVar);
        C2688ew c2688ew = new C2688ew(context, 2);
        C2688ew c2688ew2 = new C2688ew(context, 1);
        C2687ev c2687ev = C2687ev.f7183a;
        C2688ew c2688ew3 = new C2688ew(context, 0);
        this.f7188a = context;
        this.f7190c = c2690ey;
        this.f7191d = c2688ew;
        this.f7192e = c2688ew2;
        this.f7193f = c2687ev;
        this.f7194g = c2688ew3;
        this.f7195h = new atn() { // from class: com.google.ads.interactivemedia.v3.internal.ex
            @Override // com.google.ads.interactivemedia.p034v3.internal.atn
            /* renamed from: a */
            public final Object mo1308a() {
                InterfaceC2598bn interfaceC2598bn = C2691ez.this.f7189b;
                C2616ce.m2689d(interfaceC2598bn);
                return new C2785il(interfaceC2598bn);
            }
        };
        this.f7196i = C2628cq.m2580C();
        this.f7197j = C2611c.f6917a;
        this.f7198k = 1;
        this.f7199l = true;
        this.f7200m = C2740gu.f7448b;
        this.f7201n = 5000L;
        this.f7202o = C3282C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
        this.f7206s = C2742gw.m2165c(0.97f, 1.03f, 1000L, 1.0E-7f, C2628cq.m2515s(20L), C2628cq.m2515s(500L), 0.999f);
        this.f7189b = InterfaceC2598bn.f6252a;
        this.f7203p = 500L;
        this.f7204q = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    }
}

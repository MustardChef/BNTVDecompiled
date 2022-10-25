package com.google.ads.interactivemedia.p034v3.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ags */
/* loaded from: classes2.dex */
public final class ags {

    /* renamed from: a */
    private static final ags f4015a = new ags();

    /* renamed from: b */
    private Context f4016b;

    /* renamed from: c */
    private BroadcastReceiver f4017c;

    /* renamed from: d */
    private boolean f4018d;

    /* renamed from: e */
    private boolean f4019e;

    /* renamed from: f */
    private agx f4020f;

    private ags() {
    }

    /* renamed from: a */
    public static ags m5324a() {
        return f4015a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* bridge */ /* synthetic */ void m5323b(ags agsVar, boolean z) {
        if (agsVar.f4019e != z) {
            agsVar.f4019e = z;
            if (agsVar.f4018d) {
                agsVar.m5317h();
                if (agsVar.f4020f != null) {
                    if (agsVar.m5319f()) {
                        ahq.m5244d().m5239i();
                    } else {
                        ahq.m5244d().m5240h();
                    }
                }
            }
        }
    }

    /* renamed from: h */
    private final void m5317h() {
        boolean z = this.f4019e;
        for (agj agjVar : agq.m5331a().m5329c()) {
            ahd m5343h = agjVar.m5343h();
            if (m5343h.m5283k()) {
                agw.m5309a().m5308b(m5343h.m5290a(), "setState", true != z ? "foregrounded" : "backgrounded");
            }
        }
    }

    /* renamed from: c */
    public final void m5322c(Context context) {
        this.f4016b = context.getApplicationContext();
    }

    /* renamed from: d */
    public final void m5321d() {
        this.f4017c = new agr(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f4016b.registerReceiver(this.f4017c, intentFilter);
        this.f4018d = true;
        m5317h();
    }

    /* renamed from: e */
    public final void m5320e() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.f4016b;
        if (context != null && (broadcastReceiver = this.f4017c) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.f4017c = null;
        }
        this.f4018d = false;
        this.f4019e = false;
        this.f4020f = null;
    }

    /* renamed from: f */
    public final boolean m5319f() {
        return !this.f4019e;
    }

    /* renamed from: g */
    public final void m5318g(agx agxVar) {
        this.f4020f = agxVar;
    }
}

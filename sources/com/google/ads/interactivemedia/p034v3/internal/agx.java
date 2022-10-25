package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.os.Handler;
import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agx */
/* loaded from: classes2.dex */
public final class agx {

    /* renamed from: a */
    private static agx f4030a;

    /* renamed from: b */
    private float f4031b = 0.0f;

    /* renamed from: c */
    private agp f4032c;

    /* renamed from: d */
    private agq f4033d;

    /* renamed from: e */
    private final C2518i f4034e;

    /* renamed from: f */
    private final C2518i f4035f;

    public agx(C2518i c2518i, C2518i c2518i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f4034e = c2518i;
        this.f4035f = c2518i2;
    }

    /* renamed from: b */
    public static agx m5300b() {
        if (f4030a == null) {
            f4030a = new agx(new C2518i(), new C2518i(), null, null, null);
        }
        return f4030a;
    }

    /* renamed from: a */
    public final float m5301a() {
        return this.f4031b;
    }

    /* renamed from: c */
    public final void m5299c(Context context) {
        this.f4032c = new agp(new Handler(), context, new C2518i(), this, null, null, null);
    }

    /* renamed from: d */
    public final void m5298d(float f) {
        this.f4031b = f;
        if (this.f4033d == null) {
            this.f4033d = agq.m5331a();
        }
        for (agj agjVar : this.f4033d.m5330b()) {
            agjVar.m5343h().m5285h(f);
        }
    }

    /* renamed from: e */
    public final void m5297e() {
        ags.m5324a().m5318g(this);
        ags.m5324a().m5321d();
        if (ags.m5324a().m5319f()) {
            ahq.m5244d().m5239i();
        }
        this.f4032c.m5335a();
    }

    /* renamed from: f */
    public final void m5296f() {
        ahq.m5244d().m5238j();
        ags.m5324a().m5320e();
        this.f4032c.m5334b();
    }
}

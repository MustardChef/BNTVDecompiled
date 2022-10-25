package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.df */
/* loaded from: classes2.dex */
public final class C2644df implements InterfaceC2637cz {

    /* renamed from: a */
    private final Context f7019a;

    /* renamed from: b */
    private final List f7020b;

    /* renamed from: c */
    private final InterfaceC2637cz f7021c;

    /* renamed from: d */
    private InterfaceC2637cz f7022d;

    /* renamed from: e */
    private InterfaceC2637cz f7023e;

    /* renamed from: f */
    private InterfaceC2637cz f7024f;

    /* renamed from: g */
    private InterfaceC2637cz f7025g;

    /* renamed from: h */
    private InterfaceC2637cz f7026h;

    /* renamed from: i */
    private InterfaceC2637cz f7027i;

    /* renamed from: j */
    private InterfaceC2637cz f7028j;

    /* renamed from: k */
    private InterfaceC2637cz f7029k;

    public C2644df(Context context, InterfaceC2637cz interfaceC2637cz) {
        this.f7019a = context.getApplicationContext();
        C2616ce.m2689d(interfaceC2637cz);
        this.f7021c = interfaceC2637cz;
        this.f7020b = new ArrayList();
    }

    /* renamed from: g */
    private final InterfaceC2637cz m2486g() {
        if (this.f7023e == null) {
            C2630cs c2630cs = new C2630cs(this.f7019a);
            this.f7023e = c2630cs;
            m2485h(c2630cs);
        }
        return this.f7023e;
    }

    /* renamed from: h */
    private final void m2485h(InterfaceC2637cz interfaceC2637cz) {
        for (int i = 0; i < this.f7020b.size(); i++) {
            interfaceC2637cz.mo1123f((InterfaceC2659du) this.f7020b.get(i));
        }
    }

    /* renamed from: i */
    private static final void m2484i(InterfaceC2637cz interfaceC2637cz, InterfaceC2659du interfaceC2659du) {
        if (interfaceC2637cz != null) {
            interfaceC2637cz.mo1123f(interfaceC2659du);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws IOException {
        InterfaceC2637cz interfaceC2637cz = this.f7029k;
        C2616ce.m2689d(interfaceC2637cz);
        return interfaceC2637cz.mo501a(bArr, i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    public final long mo1127b(C2642dd c2642dd) throws IOException {
        InterfaceC2637cz interfaceC2637cz;
        C2616ce.m2685h(this.f7029k == null);
        String scheme = c2642dd.f7011a.getScheme();
        if (C2628cq.m2558Y(c2642dd.f7011a)) {
            String path = c2642dd.f7011a.getPath();
            if (path != null && path.startsWith("/android_asset/")) {
                this.f7029k = m2486g();
            } else {
                if (this.f7022d == null) {
                    C2650dl c2650dl = new C2650dl();
                    this.f7022d = c2650dl;
                    m2485h(c2650dl);
                }
                this.f7029k = this.f7022d;
            }
        } else if ("asset".equals(scheme)) {
            this.f7029k = m2486g();
        } else if ("content".equals(scheme)) {
            if (this.f7024f == null) {
                C2634cw c2634cw = new C2634cw(this.f7019a);
                this.f7024f = c2634cw;
                m2485h(c2634cw);
            }
            this.f7029k = this.f7024f;
        } else if ("rtmp".equals(scheme)) {
            if (this.f7025g == null) {
                try {
                    InterfaceC2637cz interfaceC2637cz2 = (InterfaceC2637cz) Class.forName("bundled.androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                    this.f7025g = interfaceC2637cz2;
                    m2485h(interfaceC2637cz2);
                } catch (ClassNotFoundException unused) {
                    Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating RTMP extension", e);
                }
                if (this.f7025g == null) {
                    this.f7025g = this.f7021c;
                }
            }
            this.f7029k = this.f7025g;
        } else if ("udp".equals(scheme)) {
            if (this.f7026h == null) {
                C2661dw c2661dw = new C2661dw();
                this.f7026h = c2661dw;
                m2485h(c2661dw);
            }
            this.f7029k = this.f7026h;
        } else if ("data".equals(scheme)) {
            if (this.f7027i == null) {
                C2635cx c2635cx = new C2635cx();
                this.f7027i = c2635cx;
                m2485h(c2635cx);
            }
            this.f7029k = this.f7027i;
        } else {
            if (RawResourceDataSource.RAW_RESOURCE_SCHEME.equals(scheme) || "android.resource".equals(scheme)) {
                if (this.f7028j == null) {
                    C2657ds c2657ds = new C2657ds(this.f7019a);
                    this.f7028j = c2657ds;
                    m2485h(c2657ds);
                }
                interfaceC2637cz = this.f7028j;
            } else {
                interfaceC2637cz = this.f7021c;
            }
            this.f7029k = interfaceC2637cz;
        }
        return this.f7029k.mo1127b(c2642dd);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        InterfaceC2637cz interfaceC2637cz = this.f7029k;
        if (interfaceC2637cz == null) {
            return null;
        }
        return interfaceC2637cz.mo1126c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() throws IOException {
        InterfaceC2637cz interfaceC2637cz = this.f7029k;
        if (interfaceC2637cz != null) {
            try {
                interfaceC2637cz.mo1125d();
            } finally {
                this.f7029k = null;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: e */
    public final Map mo1124e() {
        InterfaceC2637cz interfaceC2637cz = this.f7029k;
        return interfaceC2637cz == null ? Collections.emptyMap() : interfaceC2637cz.mo1124e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: f */
    public final void mo1123f(InterfaceC2659du interfaceC2659du) {
        C2616ce.m2689d(interfaceC2659du);
        this.f7021c.mo1123f(interfaceC2659du);
        this.f7020b.add(interfaceC2659du);
        m2484i(this.f7022d, interfaceC2659du);
        m2484i(this.f7023e, interfaceC2659du);
        m2484i(this.f7024f, interfaceC2659du);
        m2484i(this.f7025g, interfaceC2659du);
        m2484i(this.f7026h, interfaceC2659du);
        m2484i(this.f7027i, interfaceC2659du);
        m2484i(this.f7028j, interfaceC2659du);
    }
}

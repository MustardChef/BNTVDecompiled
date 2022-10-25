package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ov */
/* loaded from: classes2.dex */
public final class C2957ov {

    /* renamed from: g */
    private final C2944oi f8335g;

    /* renamed from: c */
    private final InterfaceC2922nn f8331c = new C2907mz();

    /* renamed from: b */
    private final InterfaceC2995qf f8330b = new C2974pl();

    /* renamed from: h */
    private final C2975pm f8336h = C2979pq.f8482a;

    /* renamed from: a */
    private final InterfaceC2954os f8329a = InterfaceC2954os.f8280a;

    /* renamed from: i */
    private final C3161wj f8337i = new C3161wj();

    /* renamed from: j */
    private final C3161wj f8338j = new C3161wj();

    /* renamed from: d */
    private final int f8332d = 1;

    /* renamed from: e */
    private final List f8333e = Collections.emptyList();

    /* renamed from: f */
    private final long f8334f = C3282C.TIME_UNSET;

    public C2957ov(InterfaceC2636cy interfaceC2636cy) {
        this.f8335g = new C2944oi(interfaceC2636cy);
    }

    @Deprecated
    /* renamed from: a */
    public final C2959ox m1439a(Uri uri) {
        C3043s c3043s = new C3043s();
        c3043s.m1173e(uri);
        c3043s.m1175c(MimeTypes.APPLICATION_M3U8);
        C2543ae m1177a = c3043s.m1177a();
        C2616ce.m2689d(m1177a.f3562b);
        InterfaceC2995qf interfaceC2995qf = this.f8330b;
        List list = m1177a.f3562b.f2867e.isEmpty() ? this.f8333e : m1177a.f3562b.f2867e;
        if (!list.isEmpty()) {
            interfaceC2995qf = new C2980pr(interfaceC2995qf, list);
        }
        C2537aa c2537aa = m1177a.f3562b;
        Object obj = c2537aa.f2870h;
        if (c2537aa.f2867e.isEmpty() && !list.isEmpty()) {
            C3043s m5757a = m1177a.m5757a();
            m5757a.m1174d(list);
            m1177a = m5757a.m1177a();
        }
        C2543ae c2543ae = m1177a;
        C2944oi c2944oi = this.f8335g;
        InterfaceC2954os interfaceC2954os = this.f8329a;
        C3161wj c3161wj = this.f8338j;
        InterfaceC2921nm mo1582a = this.f8331c.mo1582a(c2543ae);
        C3161wj c3161wj2 = this.f8337i;
        return new C2959ox(c2543ae, c2944oi, interfaceC2954os, c3161wj, mo1582a, c3161wj2, new C2979pq(this.f8335g, c3161wj2, interfaceC2995qf, null), C3282C.TIME_UNSET, 1, null, null);
    }
}

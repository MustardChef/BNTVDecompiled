package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.kq */
/* loaded from: classes2.dex */
public final class C2844kq {

    /* renamed from: a */
    private final InterfaceC2636cy f7900a;

    /* renamed from: f */
    private final C2852ky f7905f;

    /* renamed from: b */
    private final InterfaceC2922nn f7901b = new C2907mz();

    /* renamed from: g */
    private final C3161wj f7906g = new C3161wj();

    /* renamed from: c */
    private final long f7902c = C3282C.TIME_UNSET;

    /* renamed from: d */
    private final long f7903d = 30000;

    /* renamed from: h */
    private final C3161wj f7907h = new C3161wj();

    /* renamed from: e */
    private final List f7904e = Collections.emptyList();

    public C2844kq(InterfaceC2636cy interfaceC2636cy) {
        this.f7905f = new C2852ky(interfaceC2636cy);
        this.f7900a = interfaceC2636cy;
    }

    @Deprecated
    /* renamed from: a */
    public final C2849kv m1774a(Uri uri) {
        C3043s c3043s = new C3043s();
        c3043s.m1173e(uri);
        c3043s.m1175c(MimeTypes.APPLICATION_MPD);
        C2543ae m1177a = c3043s.m1177a();
        C2616ce.m2689d(m1177a.f3562b);
        InterfaceC3169wr c2866ll = new C2866ll();
        List list = m1177a.f3562b.f2867e.isEmpty() ? this.f7904e : m1177a.f3562b.f2867e;
        InterfaceC3169wr c3036rt = !list.isEmpty() ? new C3036rt(c2866ll, list) : c2866ll;
        C2537aa c2537aa = m1177a.f3562b;
        Object obj = c2537aa.f2870h;
        if (c2537aa.f2867e.isEmpty() && !list.isEmpty()) {
            C3043s m5757a = m1177a.m5757a();
            m5757a.m1174d(list);
            m1177a = m5757a.m1177a();
        }
        C2543ae c2543ae = m1177a;
        return new C2849kv(c2543ae, this.f7900a, c3036rt, this.f7905f, this.f7907h, this.f7901b.mo1582a(c2543ae), this.f7906g, 30000L, null, null);
    }
}

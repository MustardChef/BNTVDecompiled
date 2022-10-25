package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.anggrayudi.storage.file.MimeType;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ob */
/* loaded from: classes2.dex */
public final class C2937ob implements InterfaceC2939od {

    /* renamed from: a */
    private final String f8233a;

    /* renamed from: b */
    private final Map f8234b;

    /* renamed from: c */
    private final C2646dh f8235c;

    public C2937ob(String str, C2646dh c2646dh) {
        C2616ce.m2687f(true);
        this.f8235c = c2646dh;
        this.f8233a = null;
        this.f8234b = new HashMap();
    }

    /* renamed from: d */
    private static byte[] m1485d(C2646dh c2646dh, String str, byte[] bArr, Map map) throws C2940oe {
        Map map2;
        List list;
        C2658dt c2658dt = new C2658dt(c2646dh.m2482a());
        C2641dc c2641dc = new C2641dc();
        c2641dc.m2491j(str);
        c2641dc.m2496e(map);
        c2641dc.m2497d();
        c2641dc.m2498c(bArr);
        c2641dc.m2499b(1);
        C2642dd m2500a = c2641dc.m2500a();
        int i = 0;
        C2642dd c2642dd = m2500a;
        int i2 = 0;
        while (true) {
            try {
                C2640db c2640db = new C2640db(c2658dt, c2642dd);
                try {
                    byte[] m2553ac = C2628cq.m2553ac(c2640db);
                    C2628cq.m2566Q(c2640db);
                    return m2553ac;
                } catch (C2653do e) {
                    int i3 = e.f7052b;
                    String str2 = null;
                    if ((i3 == 307 || i3 == 308) && i2 < 5 && (map2 = e.f7053c) != null && (list = (List) map2.get("Location")) != null && !list.isEmpty()) {
                        str2 = (String) list.get(i);
                    }
                    if (str2 == null) {
                        throw e;
                    }
                    i2++;
                    C2641dc m2490a = c2642dd.m2490a();
                    m2490a.m2491j(str2);
                    c2642dd = m2490a.m2500a();
                    C2628cq.m2566Q(c2640db);
                }
            } catch (Exception e2) {
                Uri m2470h = c2658dt.m2470h();
                C2616ce.m2689d(m2470h);
                throw new C2940oe(m2500a, m2470h, c2658dt.mo1124e(), c2658dt.m2471g(), e2);
            }
        }
    }

    /* renamed from: a */
    public final void m1486a(String str, String str2) {
        C2616ce.m2689d(str);
        C2616ce.m2689d(str2);
        synchronized (this.f8234b) {
            this.f8234b.put(str, str2);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2939od
    /* renamed from: b */
    public final byte[] mo1484b(C2929nu c2929nu) throws C2940oe {
        String m1567a = c2929nu.m1567a();
        String m2576G = C2628cq.m2576G(c2929nu.m1566b());
        StringBuilder sb = new StringBuilder(String.valueOf(m1567a).length() + 15 + m2576G.length());
        sb.append(m1567a);
        sb.append("&signedRequest=");
        sb.append(m2576G);
        return m1485d(this.f8235c, sb.toString(), null, Collections.emptyMap());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2939od
    /* renamed from: c */
    public final byte[] mo1483c(UUID uuid, aeg aegVar) throws C2940oe {
        String str;
        String m5735a = aegVar.m5735a();
        if (TextUtils.isEmpty(m5735a)) {
            m5735a = null;
        }
        if (TextUtils.isEmpty(m5735a)) {
            C2641dc c2641dc = new C2641dc();
            c2641dc.m2492i(Uri.EMPTY);
            throw new C2940oe(c2641dc.m2500a(), Uri.EMPTY, avj.m4504d(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap hashMap = new HashMap();
        if (C2692f.f7211e.equals(uuid)) {
            str = "text/xml";
        } else {
            str = C2692f.f7209c.equals(uuid) ? AbstractSpiCall.ACCEPT_JSON_VALUE : MimeType.BINARY_FILE;
        }
        hashMap.put("Content-Type", str);
        if (C2692f.f7211e.equals(uuid)) {
            hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f8234b) {
            hashMap.putAll(this.f8234b);
        }
        return m1485d(this.f8235c, m5735a, aegVar.m5734b(), hashMap);
    }
}

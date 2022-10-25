package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.util.Base64;
import java.io.IOException;
import java.net.URLDecoder;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cx */
/* loaded from: classes2.dex */
public final class C2635cx extends AbstractC2631ct {

    /* renamed from: a */
    private C2642dd f6990a;

    /* renamed from: b */
    private byte[] f6991b;

    /* renamed from: c */
    private int f6992c;

    /* renamed from: d */
    private int f6993d;

    public C2635cx() {
        super(false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f6993d;
        if (i3 == 0) {
            return -1;
        }
        int min = Math.min(i2, i3);
        System.arraycopy(C2628cq.m2578E(this.f6991b), this.f6992c, bArr, i, min);
        this.f6992c += min;
        this.f6993d -= min;
        m2507g(min);
        return min;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    public final long mo1127b(C2642dd c2642dd) throws IOException {
        m2505i(c2642dd);
        this.f6990a = c2642dd;
        Uri uri = c2642dd.f7011a;
        String scheme = uri.getScheme();
        boolean equals = "data".equals(scheme);
        String valueOf = String.valueOf(scheme);
        C2616ce.m2686g(equals, valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
        String[] m2547ai = C2628cq.m2547ai(uri.getSchemeSpecificPart(), ",");
        if (m2547ai.length != 2) {
            String valueOf2 = String.valueOf(uri);
            String.valueOf(valueOf2).length();
            throw C2555ao.m4865b("Unexpected URI format: ".concat(String.valueOf(valueOf2)), null);
        }
        String str = m2547ai[1];
        if (m2547ai[0].contains(";base64")) {
            try {
                this.f6991b = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                String valueOf3 = String.valueOf(str);
                throw C2555ao.m4865b(valueOf3.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(valueOf3) : new String("Error while parsing Base64 encoded string: "), e);
            }
        } else {
            this.f6991b = C2628cq.m2554ab(URLDecoder.decode(str, atg.f5037a.name()));
        }
        long j = c2642dd.f7015e;
        int length = this.f6991b.length;
        if (j > length) {
            this.f6991b = null;
            throw new C2639da(2008);
        }
        int i = (int) j;
        this.f6992c = i;
        int i2 = length - i;
        this.f6993d = i2;
        long j2 = c2642dd.f7016f;
        if (j2 != -1) {
            this.f6993d = (int) Math.min(i2, j2);
        }
        m2504j(c2642dd);
        long j3 = c2642dd.f7016f;
        return j3 != -1 ? j3 : this.f6993d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        C2642dd c2642dd = this.f6990a;
        if (c2642dd != null) {
            return c2642dd.f7011a;
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() {
        if (this.f6991b != null) {
            this.f6991b = null;
            m2506h();
        }
        this.f6990a = null;
    }
}

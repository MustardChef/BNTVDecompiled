package com.google.ads.interactivemedia.p034v3.internal;

import android.text.TextUtils;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pk */
/* loaded from: classes2.dex */
public final class C2973pk implements InterfaceC3229yx {

    /* renamed from: a */
    private static final Pattern f8459a = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: b */
    private static final Pattern f8460b = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: c */
    private final String f8461c;

    /* renamed from: d */
    private final C2626co f8462d;

    /* renamed from: f */
    private InterfaceC3233za f8464f;

    /* renamed from: h */
    private int f8466h;

    /* renamed from: e */
    private final C2621cj f8463e = new C2621cj();

    /* renamed from: g */
    private byte[] f8465g = new byte[1024];

    public C2973pk(String str, C2626co c2626co) {
        this.f8461c = str;
        this.f8462d = c2626co;
    }

    /* renamed from: f */
    private final InterfaceC3253zu m1380f(long j) {
        InterfaceC3253zu mo489be = this.f8464f.mo489be(0, 3);
        C2935o c2935o = new C2935o();
        c2935o.m1532ae(MimeTypes.TEXT_VTT);
        c2935o.m1542V(this.f8461c);
        c2935o.m1528ai(j);
        mo489be.mo443b(c2935o.m1506v());
        this.f8464f.mo488m();
        return mo489be;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    public final boolean mo433D(InterfaceC3230yy interfaceC3230yy) throws IOException {
        interfaceC3230yy.mo492k(this.f8465g, 0, 6, false);
        this.f8463e.m2646D(this.f8465g, 6);
        if (acv.m5817d(this.f8463e)) {
            return true;
        }
        interfaceC3230yy.mo492k(this.f8465g, 6, 3, false);
        this.f8463e.m2646D(this.f8465g, 9);
        return acv.m5817d(this.f8463e);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        int i;
        C2616ce.m2689d(this.f8464f);
        int mo500b = (int) interfaceC3230yy.mo500b();
        int i2 = this.f8466h;
        byte[] bArr = this.f8465g;
        int length = bArr.length;
        if (i2 == length) {
            if (mo500b != -1) {
                i = mo500b;
            } else {
                mo500b = length;
                i = -1;
            }
            this.f8465g = Arrays.copyOf(bArr, (mo500b * 3) / 2);
            mo500b = i;
        }
        byte[] bArr2 = this.f8465g;
        int i3 = this.f8466h;
        int mo501a = interfaceC3230yy.mo501a(bArr2, i3, bArr2.length - i3);
        if (mo501a != -1) {
            int i4 = this.f8466h + mo501a;
            this.f8466h = i4;
            if (mo500b == -1 || i4 != mo500b) {
                return 0;
            }
        }
        C2621cj c2621cj = new C2621cj(this.f8465g);
        acv.m5818c(c2621cj);
        long j = 0;
        long j2 = 0;
        for (String m2624r = c2621cj.m2624r(); !TextUtils.isEmpty(m2624r); m2624r = c2621cj.m2624r()) {
            if (m2624r.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f8459a.matcher(m2624r);
                if (matcher.find()) {
                    Matcher matcher2 = f8460b.matcher(m2624r);
                    if (matcher2.find()) {
                        String group = matcher.group(1);
                        C2616ce.m2689d(group);
                        j2 = acv.m5820a(group);
                        String group2 = matcher2.group(1);
                        C2616ce.m2689d(group2);
                        j = C2626co.m2586f(Long.parseLong(group2));
                    } else {
                        String valueOf = String.valueOf(m2624r);
                        throw C2555ao.m4866a(valueOf.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(valueOf) : new String("X-TIMESTAMP-MAP doesn't contain media timestamp: "), null);
                    }
                } else {
                    String valueOf2 = String.valueOf(m2624r);
                    throw C2555ao.m4866a(valueOf2.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(valueOf2) : new String("X-TIMESTAMP-MAP doesn't contain local timestamp: "), null);
                }
            }
        }
        Matcher m5819b = acv.m5819b(c2621cj);
        if (m5819b == null) {
            m1380f(0L);
        } else {
            String group3 = m5819b.group(1);
            C2616ce.m2689d(group3);
            long m5820a = acv.m5820a(group3);
            long m2590b = this.f8462d.m2590b(C2626co.m2585g((j + m5820a) - j2) % 8589934592L);
            InterfaceC3253zu m1380f = m1380f(m2590b - m5820a);
            this.f8463e.m2646D(this.f8465g, this.f8466h);
            m1380f.mo442e(this.f8463e, this.f8466h);
            m1380f.mo441f(m2590b, 1, this.f8466h, 0, null);
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f8464f = interfaceC3233za;
        interfaceC3233za.mo487w(new C3249zq(C3282C.TIME_UNSET));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        throw new IllegalStateException();
    }
}

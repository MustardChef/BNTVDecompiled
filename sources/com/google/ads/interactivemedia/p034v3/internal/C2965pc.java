package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pc */
/* loaded from: classes2.dex */
final class C2965pc implements InterfaceC3253zu {

    /* renamed from: a */
    private static final C2962p f8389a;

    /* renamed from: c */
    private final InterfaceC3253zu f8391c;

    /* renamed from: e */
    private C2962p f8393e;

    /* renamed from: b */
    private final aab f8390b = new aab();

    /* renamed from: d */
    private final C2962p f8392d = f8389a;

    /* renamed from: f */
    private byte[] f8394f = new byte[0];

    /* renamed from: g */
    private int f8395g = 0;

    static {
        C2935o c2935o = new C2935o();
        c2935o.m1532ae(MimeTypes.APPLICATION_ID3);
        f8389a = c2935o.m1506v();
        C2935o c2935o2 = new C2935o();
        c2935o2.m1532ae(MimeTypes.APPLICATION_EMSG);
        c2935o2.m1506v();
    }

    public C2965pc(InterfaceC3253zu interfaceC3253zu, int i) {
        this.f8391c = interfaceC3253zu;
    }

    /* renamed from: c */
    private final void m1420c(int i) {
        byte[] bArr = this.f8394f;
        if (bArr.length < i) {
            this.f8394f = Arrays.copyOf(bArr, i + (i >> 1));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: a */
    public final /* synthetic */ int mo444a(InterfaceC2746h interfaceC2746h, int i, boolean z) {
        return C2539ab.m5959e(this, interfaceC2746h, i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: b */
    public final void mo443b(C2962p c2962p) {
        this.f8393e = c2962p;
        this.f8391c.mo443b(this.f8392d);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: e */
    public final /* synthetic */ void mo442e(C2621cj c2621cj, int i) {
        C2539ab.m5958f(this, c2621cj, i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: f */
    public final void mo441f(long j, int i, int i2, int i3, C3252zt c3252zt) {
        C2616ce.m2689d(this.f8393e);
        int i4 = this.f8395g - i3;
        C2621cj c2621cj = new C2621cj(Arrays.copyOfRange(this.f8394f, i4 - i2, i4));
        byte[] bArr = this.f8394f;
        System.arraycopy(bArr, i4, bArr, 0, i3);
        this.f8395g = i3;
        if (!C2628cq.m2563T(this.f8393e.f8372l, this.f8392d.f8372l)) {
            if (MimeTypes.APPLICATION_EMSG.equals(this.f8393e.f8372l)) {
                aaa m5981c = aab.m5981c(c2621cj);
                C2962p m5982b = m5981c.m5982b();
                if (m5982b == null || !C2628cq.m2563T(this.f8392d.f8372l, m5982b.f8372l)) {
                    Log.w("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", this.f8392d.f8372l, m5981c.m5982b()));
                    return;
                }
                c2621cj = new C2621cj((byte[]) C2616ce.m2689d(m5981c.m5982b() != null ? m5981c.f2877e : null));
            } else {
                String valueOf = String.valueOf(this.f8393e.f8372l);
                Log.w("EmsgUnwrappingTrackOutput", valueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(valueOf) : new String("Ignoring sample for unsupported format: "));
                return;
            }
        }
        int m2641a = c2621cj.m2641a();
        this.f8391c.mo442e(c2621cj, m2641a);
        this.f8391c.mo441f(j, i, m2641a, i3, c3252zt);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: h */
    public final int mo440h(InterfaceC2746h interfaceC2746h, int i, boolean z) throws IOException {
        m1420c(this.f8395g + i);
        int mo501a = interfaceC2746h.mo501a(this.f8394f, this.f8395g, i);
        if (mo501a != -1) {
            this.f8395g += mo501a;
            return mo501a;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3253zu
    /* renamed from: i */
    public final void mo439i(C2621cj c2621cj, int i) {
        m1420c(this.f8395g + i);
        c2621cj.m2649A(this.f8394f, this.f8395g, i);
        this.f8395g += i;
    }
}

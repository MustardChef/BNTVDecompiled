package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.zx */
/* loaded from: classes2.dex */
public final class C3256zx implements InterfaceC3229yx {

    /* renamed from: a */
    private static final int[] f9630a;

    /* renamed from: b */
    private static final int[] f9631b;

    /* renamed from: c */
    private static final byte[] f9632c;

    /* renamed from: d */
    private static final byte[] f9633d;

    /* renamed from: e */
    private static final int f9634e;

    /* renamed from: f */
    private final byte[] f9635f;

    /* renamed from: g */
    private final int f9636g;

    /* renamed from: h */
    private boolean f9637h;

    /* renamed from: i */
    private long f9638i;

    /* renamed from: j */
    private int f9639j;

    /* renamed from: k */
    private int f9640k;

    /* renamed from: l */
    private boolean f9641l;

    /* renamed from: m */
    private long f9642m;

    /* renamed from: n */
    private int f9643n;

    /* renamed from: o */
    private int f9644o;

    /* renamed from: p */
    private long f9645p;

    /* renamed from: q */
    private InterfaceC3233za f9646q;

    /* renamed from: r */
    private InterfaceC3253zu f9647r;

    /* renamed from: s */
    private InterfaceC3250zr f9648s;

    /* renamed from: t */
    private boolean f9649t;

    static {
        C3255zw c3255zw = C3255zw.f9629a;
        f9630a = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f9631b = iArr;
        f9632c = C2628cq.m2554ab("#!AMR\n");
        f9633d = C2628cq.m2554ab("#!AMR-WB\n");
        f9634e = iArr[8];
    }

    public C3256zx() {
        this(null);
    }

    public C3256zx(byte[] bArr) {
        this.f9636g = 0;
        this.f9635f = new byte[1];
        this.f9643n = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036 A[Catch: EOFException -> 0x009d, TryCatch #0 {EOFException -> 0x009d, blocks: (B:4:0x0007, B:6:0x0018, B:20:0x0036, B:22:0x003f, B:21:0x003b, B:31:0x0061, B:32:0x0084, B:33:0x0085, B:34:0x009c), top: B:44:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b A[Catch: EOFException -> 0x009d, TryCatch #0 {EOFException -> 0x009d, blocks: (B:4:0x0007, B:6:0x0018, B:20:0x0036, B:22:0x003f, B:21:0x003b, B:31:0x0061, B:32:0x0084, B:33:0x0085, B:34:0x009c), top: B:44:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int m428f(com.google.ads.interactivemedia.p034v3.internal.InterfaceC3230yy r10) throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f9640k
            r1 = 0
            r2 = -1
            r3 = 1
            if (r0 != 0) goto L9e
            r10.mo494h()     // Catch: java.io.EOFException -> L9d
            byte[] r0 = r9.f9635f     // Catch: java.io.EOFException -> L9d
            r10.mo496f(r0, r1, r3)     // Catch: java.io.EOFException -> L9d
            byte[] r0 = r9.f9635f     // Catch: java.io.EOFException -> L9d
            r0 = r0[r1]     // Catch: java.io.EOFException -> L9d
            r4 = r0 & 131(0x83, float:1.84E-43)
            r5 = 0
            if (r4 > 0) goto L85
            int r0 = r0 >> 3
            r0 = r0 & 15
            boolean r4 = r9.f9637h     // Catch: java.io.EOFException -> L9d
            if (r4 == 0) goto L29
            r6 = 10
            if (r0 < r6) goto L34
            r6 = 13
            if (r0 <= r6) goto L29
            goto L34
        L29:
            if (r4 != 0) goto L5a
            r6 = 12
            if (r0 < r6) goto L34
            r6 = 14
            if (r0 > r6) goto L34
            goto L5a
        L34:
            if (r4 == 0) goto L3b
            int[] r4 = com.google.ads.interactivemedia.p034v3.internal.C3256zx.f9631b     // Catch: java.io.EOFException -> L9d
            r0 = r4[r0]     // Catch: java.io.EOFException -> L9d
            goto L3f
        L3b:
            int[] r4 = com.google.ads.interactivemedia.p034v3.internal.C3256zx.f9630a     // Catch: java.io.EOFException -> L9d
            r0 = r4[r0]     // Catch: java.io.EOFException -> L9d
        L3f:
            r9.f9639j = r0     // Catch: java.io.EOFException -> L9d
            r9.f9640k = r0
            int r4 = r9.f9643n
            if (r4 != r2) goto L52
            long r4 = r10.mo498d()
            r9.f9642m = r4
            int r0 = r9.f9639j
            r9.f9643n = r0
            r4 = r0
        L52:
            if (r4 != r0) goto L9e
            int r0 = r9.f9644o
            int r0 = r0 + r3
            r9.f9644o = r0
            goto L9e
        L5a:
            java.lang.String r10 = "WB"
            java.lang.String r1 = "NB"
            if (r3 == r4) goto L61
            r10 = r1
        L61:
            int r1 = r10.length()     // Catch: java.io.EOFException -> L9d
            int r1 = r1 + 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> L9d
            r3.<init>(r1)     // Catch: java.io.EOFException -> L9d
            java.lang.String r1 = "Illegal AMR "
            r3.append(r1)     // Catch: java.io.EOFException -> L9d
            r3.append(r10)     // Catch: java.io.EOFException -> L9d
            java.lang.String r10 = " frame type "
            r3.append(r10)     // Catch: java.io.EOFException -> L9d
            r3.append(r0)     // Catch: java.io.EOFException -> L9d
            java.lang.String r10 = r3.toString()     // Catch: java.io.EOFException -> L9d
            com.google.ads.interactivemedia.v3.internal.ao r10 = com.google.ads.interactivemedia.p034v3.internal.C2555ao.m4866a(r10, r5)     // Catch: java.io.EOFException -> L9d
            throw r10     // Catch: java.io.EOFException -> L9d
        L85:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> L9d
            r1 = 42
            r10.<init>(r1)     // Catch: java.io.EOFException -> L9d
            java.lang.String r1 = "Invalid padding bits for frame header "
            r10.append(r1)     // Catch: java.io.EOFException -> L9d
            r10.append(r0)     // Catch: java.io.EOFException -> L9d
            java.lang.String r10 = r10.toString()     // Catch: java.io.EOFException -> L9d
            com.google.ads.interactivemedia.v3.internal.ao r10 = com.google.ads.interactivemedia.p034v3.internal.C2555ao.m4866a(r10, r5)     // Catch: java.io.EOFException -> L9d
            throw r10     // Catch: java.io.EOFException -> L9d
        L9d:
            return r2
        L9e:
            com.google.ads.interactivemedia.v3.internal.zu r0 = r9.f9647r
            int r4 = r9.f9640k
            int r10 = r0.mo444a(r10, r4, r3)
            if (r10 != r2) goto La9
            return r2
        La9:
            int r0 = r9.f9640k
            int r0 = r0 - r10
            r9.f9640k = r0
            if (r0 <= 0) goto Lb1
            return r1
        Lb1:
            com.google.ads.interactivemedia.v3.internal.zu r2 = r9.f9647r
            long r3 = r9.f9645p
            long r5 = r9.f9638i
            long r3 = r3 + r5
            r5 = 1
            int r6 = r9.f9639j
            r7 = 0
            r8 = 0
            r2.mo441f(r3, r5, r6, r7, r8)
            long r2 = r9.f9638i
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r2 = r2 + r4
            r9.f9638i = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3256zx.m428f(com.google.ads.interactivemedia.v3.internal.yy):int");
    }

    /* renamed from: g */
    private static boolean m427g(InterfaceC3230yy interfaceC3230yy, byte[] bArr) throws IOException {
        interfaceC3230yy.mo494h();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        interfaceC3230yy.mo496f(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    /* renamed from: h */
    private final boolean m426h(InterfaceC3230yy interfaceC3230yy) throws IOException {
        byte[] bArr = f9632c;
        if (m427g(interfaceC3230yy, bArr)) {
            this.f9637h = false;
            interfaceC3230yy.mo493i(bArr.length);
            return true;
        }
        byte[] bArr2 = f9633d;
        if (m427g(interfaceC3230yy, bArr2)) {
            this.f9637h = true;
            interfaceC3230yy.mo493i(bArr2.length);
            return true;
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: D */
    public final boolean mo433D(InterfaceC3230yy interfaceC3230yy) throws IOException {
        return m426h(interfaceC3230yy);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: a */
    public final int mo432a(InterfaceC3230yy interfaceC3230yy, C3247zo c3247zo) throws IOException {
        C2616ce.m2688e(this.f9647r);
        int i = C2628cq.f6961a;
        if (interfaceC3230yy.mo498d() != 0 || m426h(interfaceC3230yy)) {
            if (!this.f9649t) {
                this.f9649t = true;
                boolean z = this.f9637h;
                String str = true != z ? MimeTypes.AUDIO_AMR_NB : MimeTypes.AUDIO_AMR_WB;
                int i2 = true != z ? 8000 : AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
                InterfaceC3253zu interfaceC3253zu = this.f9647r;
                C2935o c2935o = new C2935o();
                c2935o.m1532ae(str);
                c2935o.m1541W(f9634e);
                c2935o.m1556H(1);
                c2935o.m1531af(i2);
                interfaceC3253zu.mo443b(c2935o.m1506v());
            }
            int m428f = m428f(interfaceC3230yy);
            if (this.f9641l) {
                return m428f;
            }
            C3249zq c3249zq = new C3249zq(C3282C.TIME_UNSET);
            this.f9648s = c3249zq;
            this.f9646q.mo487w(c3249zq);
            this.f9641l = true;
            return m428f;
        }
        throw C2555ao.m4866a("Could not find AMR header.", null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: b */
    public final void mo431b(InterfaceC3233za interfaceC3233za) {
        this.f9646q = interfaceC3233za;
        this.f9647r = interfaceC3233za.mo489be(0, 1);
        interfaceC3233za.mo488m();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: c */
    public final void mo430c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3229yx
    /* renamed from: d */
    public final void mo429d(long j, long j2) {
        this.f9638i = 0L;
        this.f9639j = 0;
        this.f9640k = 0;
        if (j != 0) {
            InterfaceC3250zr interfaceC3250zr = this.f9648s;
            if (interfaceC3250zr instanceof C3222yq) {
                this.f9645p = ((C3222yq) interfaceC3250zr).m512C(j);
                return;
            }
        }
        this.f9645p = 0L;
    }
}

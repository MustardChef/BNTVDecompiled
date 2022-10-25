package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dl */
/* loaded from: classes2.dex */
public final class C2650dl extends AbstractC2631ct {

    /* renamed from: a */
    private RandomAccessFile f7048a;

    /* renamed from: b */
    private Uri f7049b;

    /* renamed from: c */
    private long f7050c;

    /* renamed from: d */
    private boolean f7051d;

    public C2650dl() {
        super(false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws C2649dk {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f7050c;
        if (j == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f7048a;
            int i3 = C2628cq.f6961a;
            int read = randomAccessFile.read(bArr, i, (int) Math.min(j, i2));
            if (read > 0) {
                this.f7050c -= read;
                m2507g(read);
            }
            return read;
        } catch (IOException e) {
            throw new C2649dk(e, 2000);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
        if (r1 != false) goto L31;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long mo1127b(com.google.ads.interactivemedia.p034v3.internal.C2642dd r8) throws com.google.ads.interactivemedia.p034v3.internal.C2649dk {
        /*
            r7 = this;
            android.net.Uri r0 = r8.f7011a
            r7.f7049b = r0
            r7.m2505i(r8)
            r1 = 1
            r2 = 2000(0x7d0, float:2.803E-42)
            r3 = 2006(0x7d6, float:2.811E-42)
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch: java.lang.RuntimeException -> L52 java.lang.SecurityException -> L59 java.io.FileNotFoundException -> L60
            java.lang.String r5 = r0.getPath()     // Catch: java.lang.RuntimeException -> L52 java.lang.SecurityException -> L59 java.io.FileNotFoundException -> L60
            com.google.ads.interactivemedia.p034v3.internal.C2616ce.m2689d(r5)     // Catch: java.lang.RuntimeException -> L52 java.lang.SecurityException -> L59 java.io.FileNotFoundException -> L60
            java.lang.String r6 = "r"
            r4.<init>(r5, r6)     // Catch: java.lang.RuntimeException -> L52 java.lang.SecurityException -> L59 java.io.FileNotFoundException -> L60
            r7.f7048a = r4
            long r5 = r8.f7015e     // Catch: java.io.IOException -> L4b
            r4.seek(r5)     // Catch: java.io.IOException -> L4b
            long r3 = r8.f7016f     // Catch: java.io.IOException -> L4b
            r5 = -1
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L32
            java.io.RandomAccessFile r0 = r7.f7048a     // Catch: java.io.IOException -> L4b
            long r3 = r0.length()     // Catch: java.io.IOException -> L4b
            long r5 = r8.f7015e     // Catch: java.io.IOException -> L4b
            long r3 = r3 - r5
        L32:
            r7.f7050c = r3     // Catch: java.io.IOException -> L4b
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 < 0) goto L42
            r7.f7051d = r1
            r7.m2504j(r8)
            long r0 = r7.f7050c
            return r0
        L42:
            com.google.ads.interactivemedia.v3.internal.dk r8 = new com.google.ads.interactivemedia.v3.internal.dk
            r0 = 2008(0x7d8, float:2.814E-42)
            r1 = 0
            r8.<init>(r1, r1, r0)
            throw r8
        L4b:
            r8 = move-exception
            com.google.ads.interactivemedia.v3.internal.dk r0 = new com.google.ads.interactivemedia.v3.internal.dk
            r0.<init>(r8, r2)
            throw r0
        L52:
            r8 = move-exception
            com.google.ads.interactivemedia.v3.internal.dk r0 = new com.google.ads.interactivemedia.v3.internal.dk
            r0.<init>(r8, r2)
            throw r0
        L59:
            r8 = move-exception
            com.google.ads.interactivemedia.v3.internal.dk r0 = new com.google.ads.interactivemedia.v3.internal.dk
            r0.<init>(r8, r3)
            throw r0
        L60:
            r8 = move-exception
            java.lang.String r2 = r0.getQuery()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L90
            java.lang.String r2 = r0.getFragment()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L90
            com.google.ads.interactivemedia.v3.internal.dk r0 = new com.google.ads.interactivemedia.v3.internal.dk
            int r1 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.f6961a
            r2 = 21
            r4 = 2005(0x7d5, float:2.81E-42)
            if (r1 < r2) goto L8a
            java.lang.Throwable r1 = r8.getCause()
            boolean r1 = com.google.ads.interactivemedia.p034v3.internal.C2648dj.m2479a(r1)
            if (r1 == 0) goto L8a
            goto L8c
        L8a:
            r3 = 2005(0x7d5, float:2.81E-42)
        L8c:
            r0.<init>(r8, r3)
            throw r0
        L90:
            com.google.ads.interactivemedia.v3.internal.dk r2 = new com.google.ads.interactivemedia.v3.internal.dk
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            java.lang.String r5 = r0.getPath()
            r3[r4] = r5
            java.lang.String r4 = r0.getQuery()
            r3[r1] = r4
            r1 = 2
            java.lang.String r0 = r0.getFragment()
            r3[r1] = r0
            java.lang.String r0 = "uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r1 = 1004(0x3ec, float:1.407E-42)
            r2.<init>(r0, r8, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2650dl.mo1127b(com.google.ads.interactivemedia.v3.internal.dd):long");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        return this.f7049b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() throws C2649dk {
        this.f7049b = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f7048a;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.f7048a = null;
                if (this.f7051d) {
                    this.f7051d = false;
                    m2506h();
                }
            } catch (IOException e) {
                throw new C2649dk(e, 2000);
            }
        } catch (Throwable th) {
            this.f7048a = null;
            if (this.f7051d) {
                this.f7051d = false;
                m2506h();
            }
            throw th;
        }
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.di */
/* loaded from: classes2.dex */
public final class C2647di extends AbstractC2631ct implements InterfaceC2637cz {

    /* renamed from: a */
    private final int f7036a;

    /* renamed from: b */
    private final int f7037b;

    /* renamed from: c */
    private final String f7038c;

    /* renamed from: d */
    private final C2654dp f7039d;

    /* renamed from: e */
    private final C2654dp f7040e;

    /* renamed from: f */
    private C2642dd f7041f;

    /* renamed from: g */
    private HttpURLConnection f7042g;

    /* renamed from: h */
    private InputStream f7043h;

    /* renamed from: i */
    private boolean f7044i;

    /* renamed from: j */
    private int f7045j;

    /* renamed from: k */
    private long f7046k;

    /* renamed from: l */
    private long f7047l;

    @Deprecated
    public C2647di() {
        this(null, 8000, 8000, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2647di(String str, int i, int i2, C2654dp c2654dp, byte[] bArr) {
        this(str, 8000, 8000, c2654dp);
    }

    /* renamed from: k */
    private final void m2480k() {
        HttpURLConnection httpURLConnection = this.f7042g;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                C2613cb.m2698a("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f7042g = null;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws C2652dn {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.f7046k;
            if (j != -1) {
                long j2 = j - this.f7047l;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j2);
            }
            InputStream inputStream = this.f7043h;
            int i3 = C2628cq.f6961a;
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            this.f7047l += read;
            m2507g(read);
            return read;
        } catch (IOException e) {
            C2642dd c2642dd = this.f7041f;
            int i4 = C2628cq.f6961a;
            throw C2652dn.m2477a(e, c2642dd, 2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e2, code lost:
        if (r11 != 0) goto L33;
     */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long mo1127b(com.google.ads.interactivemedia.p034v3.internal.C2642dd r15) throws com.google.ads.interactivemedia.p034v3.internal.C2652dn {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2647di.mo1127b(com.google.ads.interactivemedia.v3.internal.dd):long");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        HttpURLConnection httpURLConnection = this.f7042g;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() throws C2652dn {
        try {
            InputStream inputStream = this.f7043h;
            if (inputStream != null) {
                long j = this.f7046k;
                long j2 = j == -1 ? -1L : j - this.f7047l;
                HttpURLConnection httpURLConnection = this.f7042g;
                try {
                    if (httpURLConnection != null && C2628cq.f6961a >= 19) {
                        if (C2628cq.f6961a <= 20) {
                            try {
                                InputStream inputStream2 = httpURLConnection.getInputStream();
                                if (j2 == -1) {
                                    if (inputStream2.read() != -1) {
                                    }
                                } else if (j2 <= 2048) {
                                }
                                String name = inputStream2.getClass().getName();
                                if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                                    Class<? super Object> superclass = inputStream2.getClass().getSuperclass();
                                    C2616ce.m2689d(superclass);
                                    Method declaredMethod = superclass.getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                    declaredMethod.setAccessible(true);
                                    declaredMethod.invoke(inputStream2, new Object[0]);
                                }
                            } catch (Exception unused) {
                            }
                        }
                        inputStream.close();
                    }
                    inputStream.close();
                } catch (IOException e) {
                    int i = C2628cq.f6961a;
                    throw new C2652dn(e, 2000, 3);
                }
            }
        } finally {
            this.f7043h = null;
            m2480k();
            if (this.f7044i) {
                this.f7044i = false;
                m2506h();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2631ct, com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: e */
    public final Map mo1124e() {
        HttpURLConnection httpURLConnection = this.f7042g;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    private C2647di(String str, int i, int i2, C2654dp c2654dp) {
        super(true);
        this.f7038c = str;
        this.f7036a = 8000;
        this.f7037b = 8000;
        this.f7039d = c2654dp;
        this.f7040e = new C2654dp();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cs */
/* loaded from: classes2.dex */
public final class C2630cs extends AbstractC2631ct {

    /* renamed from: a */
    private final AssetManager f6975a;

    /* renamed from: b */
    private Uri f6976b;

    /* renamed from: c */
    private InputStream f6977c;

    /* renamed from: d */
    private long f6978d;

    /* renamed from: e */
    private boolean f6979e;

    public C2630cs(Context context) {
        super(false);
        this.f6975a = context.getAssets();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws C2629cr {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f6978d;
        if (j != 0) {
            if (j != -1) {
                try {
                    i2 = (int) Math.min(j, i2);
                } catch (IOException e) {
                    throw new C2629cr(e, 2000);
                }
            }
            InputStream inputStream = this.f6977c;
            int i3 = C2628cq.f6961a;
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            long j2 = this.f6978d;
            if (j2 != -1) {
                this.f6978d = j2 - read;
            }
            m2507g(read);
            return read;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    public final long mo1127b(C2642dd c2642dd) throws C2629cr {
        try {
            Uri uri = c2642dd.f7011a;
            this.f6976b = uri;
            String path = uri.getPath();
            C2616ce.m2689d(path);
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            m2505i(c2642dd);
            InputStream open = this.f6975a.open(path, 1);
            this.f6977c = open;
            if (open.skip(c2642dd.f7015e) < c2642dd.f7015e) {
                throw new C2629cr(null, 2008);
            }
            long j = c2642dd.f7016f;
            if (j != -1) {
                this.f6978d = j;
            } else {
                long available = this.f6977c.available();
                this.f6978d = available;
                if (available == 2147483647L) {
                    this.f6978d = -1L;
                }
            }
            this.f6979e = true;
            m2504j(c2642dd);
            return this.f6978d;
        } catch (C2629cr e) {
            throw e;
        } catch (IOException e2) {
            throw new C2629cr(e2, true != (e2 instanceof FileNotFoundException) ? 2000 : 2005);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        return this.f6976b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() throws C2629cr {
        this.f6976b = null;
        try {
            try {
                InputStream inputStream = this.f6977c;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f6977c = null;
                if (this.f6979e) {
                    this.f6979e = false;
                    m2506h();
                }
            } catch (IOException e) {
                throw new C2629cr(e, 2000);
            }
        } catch (Throwable th) {
            this.f6977c = null;
            if (this.f6979e) {
                this.f6979e = false;
                m2506h();
            }
            throw th;
        }
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ds */
/* loaded from: classes2.dex */
public final class C2657ds extends AbstractC2631ct {

    /* renamed from: a */
    private final Resources f7058a;

    /* renamed from: b */
    private final String f7059b;

    /* renamed from: c */
    private Uri f7060c;

    /* renamed from: d */
    private AssetFileDescriptor f7061d;

    /* renamed from: e */
    private InputStream f7062e;

    /* renamed from: f */
    private long f7063f;

    /* renamed from: g */
    private boolean f7064g;

    public C2657ds(Context context) {
        super(false);
        this.f7058a = context.getResources();
        this.f7059b = context.getPackageName();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws C2656dr {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f7063f;
        if (j != 0) {
            if (j != -1) {
                try {
                    i2 = (int) Math.min(j, i2);
                } catch (IOException e) {
                    throw new C2656dr(null, e, 2000);
                }
            }
            InputStream inputStream = this.f7062e;
            int i3 = C2628cq.f6961a;
            int read = inputStream.read(bArr, i, i2);
            if (read == -1) {
                if (this.f7063f == -1) {
                    return -1;
                }
                throw new C2656dr("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
            long j2 = this.f7063f;
            if (j2 != -1) {
                this.f7063f = j2 - read;
            }
            m2507g(read);
            return read;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
        if (r3.matches("\\d+") != false) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0165  */
    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long mo1127b(com.google.ads.interactivemedia.p034v3.internal.C2642dd r18) throws com.google.ads.interactivemedia.p034v3.internal.C2656dr {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C2657ds.mo1127b(com.google.ads.interactivemedia.v3.internal.dd):long");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        return this.f7060c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() throws C2656dr {
        this.f7060c = null;
        try {
            try {
                InputStream inputStream = this.f7062e;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f7062e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f7061d;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new C2656dr(null, e, 2000);
                    }
                } finally {
                    this.f7061d = null;
                    if (this.f7064g) {
                        this.f7064g = false;
                        m2506h();
                    }
                }
            } catch (Throwable th) {
                this.f7062e = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.f7061d;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.f7061d = null;
                        if (this.f7064g) {
                            this.f7064g = false;
                            m2506h();
                        }
                        throw th;
                    } catch (Throwable th2) {
                        this.f7061d = null;
                        if (this.f7064g) {
                            this.f7064g = false;
                            m2506h();
                        }
                        throw th2;
                    }
                } catch (IOException e2) {
                    throw new C2656dr(null, e2, 2000);
                }
            }
        } catch (IOException e3) {
            throw new C2656dr(null, e3, 2000);
        }
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.anggrayudi.storage.file.MimeType;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cw */
/* loaded from: classes2.dex */
public final class C2634cw extends AbstractC2631ct {

    /* renamed from: a */
    private final ContentResolver f6984a;

    /* renamed from: b */
    private Uri f6985b;

    /* renamed from: c */
    private AssetFileDescriptor f6986c;

    /* renamed from: d */
    private FileInputStream f6987d;

    /* renamed from: e */
    private long f6988e;

    /* renamed from: f */
    private boolean f6989f;

    public C2634cw(Context context) {
        super(false);
        this.f6984a = context.getContentResolver();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws C2633cv {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f6988e;
        if (j != 0) {
            if (j != -1) {
                try {
                    i2 = (int) Math.min(j, i2);
                } catch (IOException e) {
                    throw new C2633cv(e, 2000);
                }
            }
            FileInputStream fileInputStream = this.f6987d;
            int i3 = C2628cq.f6961a;
            int read = fileInputStream.read(bArr, i, i2);
            if (read == -1) {
                return -1;
            }
            long j2 = this.f6988e;
            if (j2 != -1) {
                this.f6988e = j2 - read;
            }
            m2507g(read);
            return read;
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    public final long mo1127b(C2642dd c2642dd) throws C2633cv {
        int i;
        AssetFileDescriptor openAssetFileDescriptor;
        long j;
        try {
            try {
                Uri uri = c2642dd.f7011a;
                this.f6985b = uri;
                m2505i(c2642dd);
                if ("content".equals(c2642dd.f7011a.getScheme())) {
                    Bundle bundle = new Bundle();
                    if (C2628cq.f6961a >= 31) {
                        C2632cu.m2503a(bundle);
                    }
                    openAssetFileDescriptor = this.f6984a.openTypedAssetFileDescriptor(uri, MimeType.UNKNOWN, bundle);
                } else {
                    openAssetFileDescriptor = this.f6984a.openAssetFileDescriptor(uri, "r");
                }
                this.f6986c = openAssetFileDescriptor;
                if (openAssetFileDescriptor == null) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
                    sb.append("Could not open file descriptor for: ");
                    sb.append(valueOf);
                    i = 2000;
                    try {
                        throw new C2633cv(new IOException(sb.toString()), 2000);
                    } catch (IOException e) {
                        e = e;
                        if (true == (e instanceof FileNotFoundException)) {
                            i = 2005;
                        }
                        throw new C2633cv(e, i);
                    }
                }
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.f6987d = fileInputStream;
                int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
                if (i2 != 0 && c2642dd.f7015e > length) {
                    throw new C2633cv(null, 2008);
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(c2642dd.f7015e + startOffset) - startOffset;
                if (skip != c2642dd.f7015e) {
                    throw new C2633cv(null, 2008);
                }
                if (i2 == 0) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.f6988e = -1L;
                        j = -1;
                    } else {
                        j = size - channel.position();
                        this.f6988e = j;
                        if (j < 0) {
                            throw new C2633cv(null, 2008);
                        }
                    }
                } else {
                    j = length - skip;
                    this.f6988e = j;
                    if (j < 0) {
                        throw new C2633cv(null, 2008);
                    }
                }
                long j2 = c2642dd.f7016f;
                if (j2 != -1) {
                    if (j != -1) {
                        j2 = Math.min(j, j2);
                    }
                    this.f6988e = j2;
                }
                this.f6989f = true;
                m2504j(c2642dd);
                long j3 = c2642dd.f7016f;
                return j3 != -1 ? j3 : this.f6988e;
            } catch (IOException e2) {
                e = e2;
                i = 2000;
            }
        } catch (C2633cv e3) {
            throw e3;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        return this.f6985b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() throws C2633cv {
        this.f6985b = null;
        try {
            try {
                FileInputStream fileInputStream = this.f6987d;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f6987d = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f6986c;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new C2633cv(e, 2000);
                    }
                } finally {
                    this.f6986c = null;
                    if (this.f6989f) {
                        this.f6989f = false;
                        m2506h();
                    }
                }
            } catch (Throwable th) {
                this.f6987d = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor2 = this.f6986c;
                        if (assetFileDescriptor2 != null) {
                            assetFileDescriptor2.close();
                        }
                        this.f6986c = null;
                        if (this.f6989f) {
                            this.f6989f = false;
                            m2506h();
                        }
                        throw th;
                    } catch (Throwable th2) {
                        this.f6986c = null;
                        if (this.f6989f) {
                            this.f6989f = false;
                            m2506h();
                        }
                        throw th2;
                    }
                } catch (IOException e2) {
                    throw new C2633cv(e2, 2000);
                }
            }
        } catch (IOException e3) {
            throw new C2633cv(e3, 2000);
        }
    }
}

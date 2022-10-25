package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.dd */
/* loaded from: classes2.dex */
public final class C2642dd {

    /* renamed from: a */
    public final Uri f7011a;

    /* renamed from: b */
    public final int f7012b;

    /* renamed from: c */
    public final byte[] f7013c;

    /* renamed from: d */
    public final Map f7014d;

    /* renamed from: e */
    public final long f7015e;

    /* renamed from: f */
    public final long f7016f;

    /* renamed from: g */
    public final String f7017g;

    /* renamed from: h */
    public final int f7018h;

    static {
        C2544af.m5676b("media3.datasource");
    }

    private C2642dd(Uri uri, int i, byte[] bArr, Map map, long j, long j2, String str, int i2) {
        byte[] bArr2;
        boolean z = false;
        boolean z2 = j >= 0;
        C2616ce.m2687f(z2);
        C2616ce.m2687f(z2);
        long j3 = -1;
        if (j2 > 0) {
            j3 = j2;
        } else if (j2 != -1) {
            j3 = j2;
            C2616ce.m2687f(z);
            this.f7011a = uri;
            this.f7012b = i;
            bArr2 = null;
            if (bArr != null && bArr.length != 0) {
                bArr2 = bArr;
            }
            this.f7013c = bArr2;
            this.f7014d = Collections.unmodifiableMap(new HashMap(map));
            this.f7015e = j;
            this.f7016f = j3;
            this.f7017g = str;
            this.f7018h = i2;
        }
        z = true;
        C2616ce.m2687f(z);
        this.f7011a = uri;
        this.f7012b = i;
        bArr2 = null;
        if (bArr != null) {
            bArr2 = bArr;
        }
        this.f7013c = bArr2;
        this.f7014d = Collections.unmodifiableMap(new HashMap(map));
        this.f7015e = j;
        this.f7016f = j3;
        this.f7017g = str;
        this.f7018h = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2642dd(Uri uri, int i, byte[] bArr, Map map, long j, long j2, String str, int i2, byte[] bArr2) {
        this(uri, i, bArr, map, j, j2, str, i2);
    }

    /* renamed from: c */
    public static String m2488c(int i) {
        if (i != 1) {
            if (i == 2) {
                return ShareTarget.METHOD_POST;
            }
            throw new IllegalStateException();
        }
        return ShareTarget.METHOD_GET;
    }

    /* renamed from: a */
    public final C2641dc m2490a() {
        return new C2641dc(this);
    }

    /* renamed from: b */
    public final C2642dd m2489b(long j) {
        long j2 = this.f7016f;
        long j3 = j2 != -1 ? j2 - j : -1L;
        long j4 = 0;
        if (j != 0) {
            j4 = j;
        } else if (j2 == j3) {
            return this;
        }
        return new C2642dd(this.f7011a, this.f7012b, this.f7013c, this.f7014d, this.f7015e + j4, j3, this.f7017g, this.f7018h);
    }

    /* renamed from: d */
    public final boolean m2487d(int i) {
        return (this.f7018h & i) == i;
    }

    public final String toString() {
        String m2488c = m2488c(this.f7012b);
        String valueOf = String.valueOf(this.f7011a);
        long j = this.f7015e;
        long j2 = this.f7016f;
        String str = this.f7017g;
        int i = this.f7018h;
        int length = String.valueOf(valueOf).length();
        StringBuilder sb = new StringBuilder(m2488c.length() + 70 + length + String.valueOf(str).length());
        sb.append("DataSpec[");
        sb.append(m2488c);
        sb.append(" ");
        sb.append(valueOf);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(j2);
        sb.append(", ");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    public C2642dd(Uri uri, long j, long j2) {
        this(uri, 1, null, Collections.emptyMap(), j, j2, null, 0);
    }
}

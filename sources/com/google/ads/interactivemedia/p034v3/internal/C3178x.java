package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.x */
/* loaded from: classes2.dex */
public final class C3178x {

    /* renamed from: a */
    public final UUID f9342a;

    /* renamed from: b */
    public final Uri f9343b;

    /* renamed from: c */
    public final avj f9344c;

    /* renamed from: d */
    public final boolean f9345d;

    /* renamed from: e */
    public final boolean f9346e;

    /* renamed from: f */
    public final boolean f9347f;

    /* renamed from: g */
    public final avg f9348g;

    /* renamed from: h */
    private final byte[] f9349h;

    public /* synthetic */ C3178x(C3151w c3151w) {
        UUID uuid;
        avj avjVar;
        avg avgVar;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        C2616ce.m2685h(true);
        uuid = c3151w.f9258a;
        C2616ce.m2689d(uuid);
        this.f9342a = uuid;
        c3151w.f9259b;
        byte[] bArr4 = null;
        this.f9343b = null;
        avjVar = c3151w.f9260c;
        this.f9344c = avjVar;
        this.f9345d = false;
        this.f9347f = false;
        this.f9346e = false;
        avgVar = c3151w.f9261d;
        this.f9348g = avgVar;
        bArr = c3151w.f9262e;
        if (bArr != null) {
            bArr2 = c3151w.f9262e;
            bArr3 = c3151w.f9262e;
            bArr4 = Arrays.copyOf(bArr2, bArr3.length);
        }
        this.f9349h = bArr4;
    }

    /* renamed from: b */
    public final byte[] m687b() {
        byte[] bArr = this.f9349h;
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3178x) {
            C3178x c3178x = (C3178x) obj;
            if (this.f9342a.equals(c3178x.f9342a)) {
                Uri uri = c3178x.f9343b;
                if (C2628cq.m2563T(null, null) && C2628cq.m2563T(this.f9344c, c3178x.f9344c)) {
                    boolean z = c3178x.f9345d;
                    boolean z2 = c3178x.f9347f;
                    boolean z3 = c3178x.f9346e;
                    if (this.f9348g.equals(c3178x.f9348g) && Arrays.equals(this.f9349h, c3178x.f9349h)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f9342a.hashCode() * 961) + this.f9344c.hashCode()) * 923521) + this.f9348g.hashCode()) * 31) + Arrays.hashCode(this.f9349h);
    }
}

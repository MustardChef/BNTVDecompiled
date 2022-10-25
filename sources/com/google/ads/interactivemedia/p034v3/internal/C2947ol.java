package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.util.LinkedHashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ol */
/* loaded from: classes2.dex */
final class C2947ol {

    /* renamed from: a */
    private final LinkedHashMap f8250a = new C2946ok();

    /* renamed from: a */
    public final byte[] m1475a(Uri uri) {
        if (uri == null) {
            return null;
        }
        return (byte[]) this.f8250a.get(uri);
    }

    /* renamed from: b */
    public final byte[] m1474b(Uri uri) {
        return (byte[]) this.f8250a.remove(uri);
    }

    /* renamed from: c */
    public final void m1473c(Uri uri, byte[] bArr) {
        LinkedHashMap linkedHashMap = this.f8250a;
        C2616ce.m2689d(uri);
        byte[] bArr2 = (byte[]) linkedHashMap.put(uri, (byte[]) C2616ce.m2689d(bArr));
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azu */
/* loaded from: classes2.dex */
public final class azu {

    /* renamed from: a */
    private final Object f5333a;

    /* renamed from: b */
    private final byte[] f5334b;

    /* renamed from: c */
    private final int f5335c;

    /* renamed from: d */
    private final int f5336d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public azu(Object obj, byte[] bArr, int i, int i2) {
        this.f5333a = obj;
        this.f5334b = Arrays.copyOf(bArr, bArr.length);
        this.f5335c = i;
        this.f5336d = i2;
    }

    /* renamed from: a */
    public final Object m4261a() {
        return this.f5333a;
    }

    /* renamed from: b */
    public final byte[] m4260b() {
        byte[] bArr = this.f5334b;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    /* renamed from: c */
    public final int m4259c() {
        return this.f5335c;
    }

    /* renamed from: d */
    public final int m4258d() {
        return this.f5336d;
    }
}

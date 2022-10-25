package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aej */
/* loaded from: classes2.dex */
public final class aej {

    /* renamed from: a */
    private final String f3611a;

    /* renamed from: b */
    private final int f3612b;

    /* renamed from: c */
    private final int f3613c;

    /* renamed from: d */
    private int f3614d;

    /* renamed from: e */
    private String f3615e;

    public aej(int i, int i2) {
        this(Integer.MIN_VALUE, i, i2);
    }

    /* renamed from: d */
    private final void m5728d() {
        if (this.f3614d == Integer.MIN_VALUE) {
            throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
        }
    }

    /* renamed from: a */
    public final int m5731a() {
        m5728d();
        return this.f3614d;
    }

    /* renamed from: b */
    public final String m5730b() {
        m5728d();
        return this.f3615e;
    }

    /* renamed from: c */
    public final void m5729c() {
        int i = this.f3614d;
        int i2 = i == Integer.MIN_VALUE ? this.f3612b : i + this.f3613c;
        this.f3614d = i2;
        String str = this.f3611a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
        sb.append(str);
        sb.append(i2);
        this.f3615e = sb.toString();
    }

    public aej(int i, int i2, int i3) {
        String str;
        if (i != Integer.MIN_VALUE) {
            StringBuilder sb = new StringBuilder(12);
            sb.append(i);
            sb.append("/");
            str = sb.toString();
        } else {
            str = "";
        }
        this.f3611a = str;
        this.f3612b = i2;
        this.f3613c = i3;
        this.f3614d = Integer.MIN_VALUE;
        this.f3615e = "";
    }
}

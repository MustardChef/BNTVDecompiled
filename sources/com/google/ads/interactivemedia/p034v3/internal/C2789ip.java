package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ip */
/* loaded from: classes2.dex */
public final class C2789ip {

    /* renamed from: a */
    public static final C2789ip f7612a = new C2789ip(-1, -1, -1);

    /* renamed from: b */
    public final int f7613b;

    /* renamed from: c */
    public final int f7614c;

    /* renamed from: d */
    public final int f7615d;

    /* renamed from: e */
    public final int f7616e;

    public C2789ip(int i, int i2, int i3) {
        this.f7613b = i;
        this.f7614c = i2;
        this.f7615d = i3;
        this.f7616e = C2628cq.m2560W(i3) ? C2628cq.m2523k(i3, i2) : -1;
    }

    public final String toString() {
        int i = this.f7613b;
        int i2 = this.f7614c;
        int i3 = this.f7615d;
        StringBuilder sb = new StringBuilder(83);
        sb.append("AudioFormat[sampleRate=");
        sb.append(i);
        sb.append(", channelCount=");
        sb.append(i2);
        sb.append(", encoding=");
        sb.append(i3);
        sb.append(']');
        return sb.toString();
    }
}

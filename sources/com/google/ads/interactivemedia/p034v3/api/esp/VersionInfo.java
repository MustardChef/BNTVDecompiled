package com.google.ads.interactivemedia.p034v3.api.esp;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.esp.VersionInfo */
/* loaded from: classes2.dex */
public final class VersionInfo {

    /* renamed from: a */
    private final int f2845a;

    /* renamed from: b */
    private final int f2846b;

    /* renamed from: c */
    private final int f2847c;

    public VersionInfo(int i, int i2, int i3) {
        this.f2845a = i;
        this.f2846b = i2;
        this.f2847c = i3;
    }

    public int getMajorVersion() {
        return this.f2845a;
    }

    public int getMicroVersion() {
        return this.f2847c;
    }

    public int getMinorVersion() {
        return this.f2846b;
    }

    public String toString() {
        int i = this.f2845a;
        int i2 = this.f2846b;
        int i3 = this.f2847c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }
}

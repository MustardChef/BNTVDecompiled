package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.md */
/* loaded from: classes2.dex */
public final class C2885md {

    /* renamed from: a */
    public final String f8090a;

    /* renamed from: b */
    public final String f8091b;

    public C2885md(String str, String str2) {
        this.f8090a = str;
        this.f8091b = str2;
    }

    public final String toString() {
        String str = this.f8090a;
        String str2 = this.f8091b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        return sb.toString();
    }
}

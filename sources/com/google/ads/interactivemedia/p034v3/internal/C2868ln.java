package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ln */
/* loaded from: classes2.dex */
public final class C2868ln {

    /* renamed from: a */
    public final aaa[] f8036a;

    /* renamed from: b */
    public final long[] f8037b;

    /* renamed from: c */
    public final String f8038c;

    /* renamed from: d */
    public final String f8039d;

    public C2868ln(String str, String str2, long[] jArr, aaa[] aaaVarArr) {
        this.f8038c = str;
        this.f8039d = str2;
        this.f8037b = jArr;
        this.f8036a = aaaVarArr;
    }

    /* renamed from: a */
    public final String m1679a() {
        String str = this.f8038c;
        String str2 = this.f8039d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("/");
        sb.append(str2);
        return sb.toString();
    }
}

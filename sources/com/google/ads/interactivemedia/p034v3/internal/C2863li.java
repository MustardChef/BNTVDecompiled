package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.li */
/* loaded from: classes2.dex */
public final class C2863li {

    /* renamed from: a */
    public final String f8004a;

    /* renamed from: b */
    public final String f8005b;

    /* renamed from: c */
    public final int f8006c;

    /* renamed from: d */
    public final int f8007d;

    public C2863li(String str, String str2, int i, int i2) {
        this.f8004a = str;
        this.f8005b = str2;
        this.f8006c = i;
        this.f8007d = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2863li) {
            C2863li c2863li = (C2863li) obj;
            return this.f8006c == c2863li.f8006c && this.f8007d == c2863li.f8007d && anx.m4882b(this.f8004a, c2863li.f8004a) && anx.m4882b(this.f8005b, c2863li.f8005b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8004a, this.f8005b, Integer.valueOf(this.f8006c), Integer.valueOf(this.f8007d)});
    }
}

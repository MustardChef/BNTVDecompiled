package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.i */
/* loaded from: classes2.dex */
public final class C2773i {

    /* renamed from: a */
    public final int f7554a = 0;

    /* renamed from: b */
    public final int f7555b;

    /* renamed from: c */
    public final int f7556c;

    public C2773i(int i, int i2) {
        this.f7555b = i;
        this.f7556c = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2773i) {
            C2773i c2773i = (C2773i) obj;
            int i = c2773i.f7554a;
            return this.f7555b == c2773i.f7555b && this.f7556c == c2773i.f7556c;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f7555b + 16337) * 31) + this.f7556c;
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ai */
/* loaded from: classes2.dex */
public class C2547ai {

    /* renamed from: a */
    public final Object f4115a;

    /* renamed from: b */
    public final int f4116b;

    /* renamed from: c */
    public final int f4117c;

    /* renamed from: d */
    public final long f4118d;

    /* renamed from: e */
    public final int f4119e;

    /* JADX INFO: Access modifiers changed from: protected */
    public C2547ai(C2547ai c2547ai) {
        this.f4115a = c2547ai.f4115a;
        this.f4116b = c2547ai.f4116b;
        this.f4117c = c2547ai.f4117c;
        this.f4118d = c2547ai.f4118d;
        this.f4119e = c2547ai.f4119e;
    }

    public C2547ai(Object obj) {
        this(obj, -1, -1, -1L, -1);
    }

    private C2547ai(Object obj, int i, int i2, long j, int i3) {
        this.f4115a = obj;
        this.f4116b = i;
        this.f4117c = i2;
        this.f4118d = j;
        this.f4119e = i3;
    }

    /* renamed from: a */
    public final C2547ai m5217a(Object obj) {
        return this.f4115a.equals(obj) ? this : new C2547ai(obj, this.f4116b, this.f4117c, this.f4118d, this.f4119e);
    }

    /* renamed from: b */
    public final boolean m5216b() {
        return this.f4116b != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2547ai) {
            C2547ai c2547ai = (C2547ai) obj;
            return this.f4115a.equals(c2547ai.f4115a) && this.f4116b == c2547ai.f4116b && this.f4117c == c2547ai.f4117c && this.f4118d == c2547ai.f4118d && this.f4119e == c2547ai.f4119e;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.f4115a.hashCode() + 527) * 31) + this.f4116b) * 31) + this.f4117c) * 31) + ((int) this.f4118d)) * 31) + this.f4119e;
    }

    public C2547ai(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    public C2547ai(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}

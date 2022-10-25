package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.py */
/* loaded from: classes2.dex */
public class C2987py implements Comparable {

    /* renamed from: c */
    public final String f8524c;

    /* renamed from: d */
    public final C2986px f8525d;

    /* renamed from: e */
    public final long f8526e;

    /* renamed from: f */
    public final int f8527f;

    /* renamed from: g */
    public final long f8528g;

    /* renamed from: h */
    public final C2854l f8529h;

    /* renamed from: i */
    public final String f8530i;

    /* renamed from: j */
    public final String f8531j;

    /* renamed from: k */
    public final long f8532k;

    /* renamed from: l */
    public final long f8533l;

    /* renamed from: m */
    public final boolean f8534m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2987py(String str, C2986px c2986px, long j, int i, long j2, C2854l c2854l, String str2, String str3, long j3, long j4, boolean z) {
        this.f8524c = str;
        this.f8525d = c2986px;
        this.f8526e = j;
        this.f8527f = i;
        this.f8528g = j2;
        this.f8529h = c2854l;
        this.f8530i = str2;
        this.f8531j = str3;
        this.f8532k = j3;
        this.f8533l = j4;
        this.f8534m = z;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        Long l = (Long) obj;
        if (this.f8528g > l.longValue()) {
            return 1;
        }
        return this.f8528g >= l.longValue() ? 0 : -1;
    }
}

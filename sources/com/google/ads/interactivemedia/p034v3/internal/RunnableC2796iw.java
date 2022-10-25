package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.iw */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC2796iw implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2801ja f7630a;

    /* renamed from: b */
    public final /* synthetic */ Exception f7631b;

    /* renamed from: c */
    private final /* synthetic */ int f7632c;

    public /* synthetic */ RunnableC2796iw(C2801ja c2801ja, Exception exc, int i) {
        this.f7632c = i;
        this.f7630a = c2801ja;
        this.f7631b = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7632c != 0) {
            this.f7630a.m1966h(this.f7631b);
        } else {
            this.f7630a.m1965i(this.f7631b);
        }
    }
}

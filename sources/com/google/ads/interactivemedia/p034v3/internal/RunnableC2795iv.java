package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.iv */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC2795iv implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2801ja f7627a;

    /* renamed from: b */
    public final /* synthetic */ C2679en f7628b;

    /* renamed from: c */
    private final /* synthetic */ int f7629c;

    public /* synthetic */ RunnableC2795iv(C2801ja c2801ja, C2679en c2679en, int i) {
        this.f7629c = i;
        this.f7627a = c2801ja;
        this.f7628b = c2679en;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7629c != 0) {
            this.f7627a.m1962l(this.f7628b);
        } else {
            this.f7627a.m1961m(this.f7628b);
        }
    }
}

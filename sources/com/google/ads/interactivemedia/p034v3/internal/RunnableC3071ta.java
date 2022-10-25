package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ta */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC3071ta implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C3076tf f8882a;

    /* renamed from: b */
    public final /* synthetic */ InterfaceC3077tg f8883b;

    /* renamed from: c */
    public final /* synthetic */ C3059sp f8884c;

    /* renamed from: d */
    public final /* synthetic */ C3064su f8885d;

    /* renamed from: e */
    private final /* synthetic */ int f8886e;

    public /* synthetic */ RunnableC3071ta(C3076tf c3076tf, InterfaceC3077tg interfaceC3077tg, C3059sp c3059sp, C3064su c3064su, int i) {
        this.f8886e = i;
        this.f8882a = c3076tf;
        this.f8883b = interfaceC3077tg;
        this.f8884c = c3059sp;
        this.f8885d = c3064su;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f8886e;
        if (i == 0) {
            C3076tf c3076tf = this.f8882a;
            this.f8883b.mo1067h(c3076tf.f8902a, c3076tf.f8903b, this.f8884c, this.f8885d);
        } else if (i != 1) {
            C3076tf c3076tf2 = this.f8882a;
            this.f8883b.mo1065j(c3076tf2.f8902a, c3076tf2.f8903b, this.f8884c, this.f8885d);
        } else {
            C3076tf c3076tf3 = this.f8882a;
            this.f8883b.mo1068g(c3076tf3.f8902a, c3076tf3.f8903b, this.f8884c, this.f8885d);
        }
    }
}

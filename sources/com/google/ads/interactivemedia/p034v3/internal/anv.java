package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anv */
/* loaded from: classes2.dex */
public final class anv implements Runnable {

    /* renamed from: a */
    final /* synthetic */ anw f4739a;

    /* renamed from: b */
    private final /* synthetic */ int f4740b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public anv(anw anwVar, int i) {
        this.f4740b = i;
        this.f4739a = anwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f4740b != 0) {
            this.f4739a.m4887w();
        } else {
            aql.m4755a(this.f4739a.f4742a);
        }
    }
}

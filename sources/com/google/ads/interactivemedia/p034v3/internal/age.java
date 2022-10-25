package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.age */
/* loaded from: classes2.dex */
public final class age {

    /* renamed from: a */
    private boolean f3952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m5367a(Context context) {
        C2518i.m5997d(context, "Application Context cannot be null");
        if (this.f3952a) {
            return;
        }
        this.f3952a = true;
        agx.m5300b().m5299c(context);
        ags.m5324a().m5322c(context);
        ahi.m5272g(context);
        agu.m5311b().m5310c(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean m5366b() {
        return this.f3952a;
    }

    /* renamed from: c */
    public final synchronized void m5365c() throws InterruptedException {
        while (!this.f3952a) {
            wait();
        }
    }

    /* renamed from: d */
    public final synchronized void m5364d() {
        boolean z = false;
        while (!this.f3952a) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: e */
    public final synchronized boolean m5363e() {
        return this.f3952a;
    }

    /* renamed from: f */
    public final synchronized boolean m5362f() {
        if (this.f3952a) {
            return false;
        }
        this.f3952a = true;
        notifyAll();
        return true;
    }

    /* renamed from: g */
    public final synchronized void m5361g() {
        this.f3952a = false;
    }
}

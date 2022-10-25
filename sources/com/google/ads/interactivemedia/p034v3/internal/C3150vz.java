package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vz */
/* loaded from: classes2.dex */
public final class C3150vz {

    /* renamed from: a */
    private final CopyOnWriteArrayList f9257a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public final void m777a(Handler handler, InterfaceC3152wa interfaceC3152wa) {
        m775c(interfaceC3152wa);
        this.f9257a.add(new C3149vy(handler, interfaceC3152wa));
    }

    /* renamed from: b */
    public final void m776b(final int i, final long j, final long j2) {
        boolean z;
        Handler handler;
        Iterator it = this.f9257a.iterator();
        while (it.hasNext()) {
            final C3149vy c3149vy = (C3149vy) it.next();
            z = c3149vy.f9256c;
            if (!z) {
                handler = c3149vy.f9254a;
                handler.post(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.vx
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC3152wa interfaceC3152wa;
                        C3149vy c3149vy2 = C3149vy.this;
                        int i2 = i;
                        long j3 = j;
                        long j4 = j2;
                        interfaceC3152wa = c3149vy2.f9255b;
                        interfaceC3152wa.mo769W(i2, j3, j4);
                    }
                });
            }
        }
    }

    /* renamed from: c */
    public final void m775c(InterfaceC3152wa interfaceC3152wa) {
        InterfaceC3152wa interfaceC3152wa2;
        Iterator it = this.f9257a.iterator();
        while (it.hasNext()) {
            C3149vy c3149vy = (C3149vy) it.next();
            interfaceC3152wa2 = c3149vy.f9255b;
            if (interfaceC3152wa2 == interfaceC3152wa) {
                c3149vy.m779c();
                this.f9257a.remove(c3149vy);
            }
        }
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aht */
/* loaded from: classes2.dex */
public final class aht {

    /* renamed from: a */
    private final BlockingQueue f4103a;

    /* renamed from: b */
    private final ThreadPoolExecutor f4104b;

    /* renamed from: c */
    private final ArrayDeque f4105c = new ArrayDeque();

    /* renamed from: d */
    private ahs f4106d = null;

    public aht() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f4103a = linkedBlockingQueue;
        this.f4104b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    /* renamed from: c */
    private final void m5232c() {
        ahs ahsVar = (ahs) this.f4105c.poll();
        this.f4106d = ahsVar;
        if (ahsVar != null) {
            ahsVar.executeOnExecutor(this.f4104b, new Object[0]);
        }
    }

    /* renamed from: a */
    public final void m5234a(ahs ahsVar) {
        ahsVar.m5235b(this);
        this.f4105c.add(ahsVar);
        if (this.f4106d == null) {
            m5232c();
        }
    }

    /* renamed from: b */
    public final void m5233b() {
        this.f4106d = null;
        m5232c();
    }
}

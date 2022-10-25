package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2494bl;
import com.google.ads.interactivemedia.p034v3.impl.data.C2456aa;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;
import com.google.ads.interactivemedia.p034v3.impl.data.EnumC2492bj;
import com.google.ads.interactivemedia.p034v3.impl.data.EnumC2493bk;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alv */
/* loaded from: classes2.dex */
public final class alv {

    /* renamed from: a */
    private final Queue f4411a;

    /* renamed from: b */
    private final akc f4412b;

    /* renamed from: c */
    private int f4413c;

    /* renamed from: d */
    private final C2456aa f4414d;

    public alv(akc akcVar) {
        C2456aa c2456aa = new C2456aa();
        this.f4411a = new ConcurrentLinkedQueue();
        this.f4413c = 1;
        this.f4414d = c2456aa;
        this.f4412b = akcVar;
    }

    /* renamed from: e */
    private final void m5012e(AbstractC2494bl abstractC2494bl) {
        ajq ajqVar = new ajq(ajo.adsLoader, ajp.nativeInstrumentation, "*", abstractC2494bl);
        int i = this.f4413c;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                return;
            }
            this.f4412b.mo5122o(ajqVar);
        } else if (this.f4411a.size() > 2) {
            this.f4413c = 3;
        } else {
            this.f4411a.add(ajqVar);
        }
    }

    /* renamed from: a */
    public final void m5016a(EnumC2492bj enumC2492bj, EnumC2493bk enumC2493bk) {
        m5012e(AbstractC2494bl.create(System.currentTimeMillis(), enumC2492bj, enumC2493bk));
    }

    /* renamed from: b */
    public final void m5015b(EnumC2492bj enumC2492bj, EnumC2493bk enumC2493bk, Exception exc) {
        m5012e(AbstractC2494bl.create(System.currentTimeMillis(), enumC2492bj, enumC2493bk, exc));
    }

    /* renamed from: c */
    public final void m5014c(final ayq ayqVar, ayr ayrVar, final EnumC2492bj enumC2492bj, final EnumC2493bk enumC2493bk) {
        ayqVar.mo4321g(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.alu
            @Override // java.lang.Runnable
            public final void run() {
                alv alvVar = alv.this;
                ayq ayqVar2 = ayqVar;
                EnumC2492bj enumC2492bj2 = enumC2492bj;
                EnumC2493bk enumC2493bk2 = enumC2493bk;
                try {
                    ayu.m4315e(ayqVar2, Exception.class);
                } catch (Exception e) {
                    String valueOf = String.valueOf(enumC2492bj2);
                    String valueOf2 = String.valueOf(enumC2493bk2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
                    sb.append("Exception in ");
                    sb.append(valueOf);
                    sb.append(".");
                    sb.append(valueOf2);
                    C2525p.m5990b(sb.toString(), e);
                    alvVar.m5015b(enumC2492bj2, enumC2493bk2, e);
                }
            }
        }, ayrVar);
    }

    /* renamed from: d */
    public final void m5013d(boolean z) {
        if (z) {
            this.f4413c = 2;
            ajq ajqVar = (ajq) this.f4411a.poll();
            while (ajqVar != null) {
                this.f4412b.mo5122o(ajqVar);
                ajqVar = (ajq) this.f4411a.poll();
            }
            return;
        }
        this.f4413c = 3;
        this.f4411a.clear();
    }
}

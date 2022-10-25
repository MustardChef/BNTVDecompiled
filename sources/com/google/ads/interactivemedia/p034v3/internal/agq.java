package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agq */
/* loaded from: classes2.dex */
public final class agq {

    /* renamed from: a */
    private static final agq f4011a = new agq();

    /* renamed from: b */
    private final ArrayList f4012b = new ArrayList();

    /* renamed from: c */
    private final ArrayList f4013c = new ArrayList();

    private agq() {
    }

    /* renamed from: a */
    public static agq m5331a() {
        return f4011a;
    }

    /* renamed from: b */
    public final Collection m5330b() {
        return Collections.unmodifiableCollection(this.f4013c);
    }

    /* renamed from: c */
    public final Collection m5329c() {
        return Collections.unmodifiableCollection(this.f4012b);
    }

    /* renamed from: d */
    public final void m5328d(agj agjVar) {
        this.f4012b.add(agjVar);
    }

    /* renamed from: e */
    public final void m5327e(agj agjVar) {
        boolean m5325g = m5325g();
        this.f4012b.remove(agjVar);
        this.f4013c.remove(agjVar);
        if (!m5325g || m5325g()) {
            return;
        }
        agx.m5300b().m5296f();
    }

    /* renamed from: f */
    public final void m5326f(agj agjVar) {
        boolean m5325g = m5325g();
        this.f4013c.add(agjVar);
        if (m5325g) {
            return;
        }
        agx.m5300b().m5297e();
    }

    /* renamed from: g */
    public final boolean m5325g() {
        return this.f4013c.size() > 0;
    }
}

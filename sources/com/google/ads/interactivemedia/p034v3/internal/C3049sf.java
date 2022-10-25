package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.sf */
/* loaded from: classes2.dex */
public final class C3049sf extends AbstractC2670ee {

    /* renamed from: b */
    private final int f8819b;

    /* renamed from: c */
    private final int f8820c;

    /* renamed from: d */
    private final int[] f8821d;

    /* renamed from: e */
    private final int[] f8822e;

    /* renamed from: f */
    private final AbstractC2586bb[] f8823f;

    /* renamed from: g */
    private final Object[] f8824g;

    /* renamed from: h */
    private final HashMap f8825h;

    public C3049sf(Collection collection, C3101ud c3101ud) {
        super(c3101ud);
        int size = collection.size();
        this.f8821d = new int[size];
        this.f8822e = new int[size];
        this.f8823f = new AbstractC2586bb[size];
        this.f8824g = new Object[size];
        this.f8825h = new HashMap();
        Iterator it = collection.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            C3051sh c3051sh = (C3051sh) it.next();
            AbstractC2586bb[] abstractC2586bbArr = this.f8823f;
            AbstractC2586bb m1108j = c3051sh.f8826a.m1108j();
            abstractC2586bbArr[i3] = m1108j;
            this.f8822e[i3] = i;
            this.f8821d[i3] = i2;
            i += m1108j.mo923c();
            i2 += this.f8823f[i3].mo924b();
            Object[] objArr = this.f8824g;
            Object obj = c3051sh.f8827b;
            objArr[i3] = obj;
            this.f8825h.put(obj, Integer.valueOf(i3));
            i3++;
        }
        this.f8819b = i;
        this.f8820c = i2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: b */
    public final int mo924b() {
        return this.f8820c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: c */
    public final int mo923c() {
        return this.f8819b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: r */
    protected final int mo1160r(Object obj) {
        Integer num = (Integer) this.f8825h.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: s */
    protected final int mo1159s(int i) {
        return C2628cq.m2541ao(this.f8821d, i + 1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: t */
    protected final int mo1158t(int i) {
        return C2628cq.m2541ao(this.f8822e, i + 1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: u */
    protected final int mo1157u(int i) {
        return this.f8821d[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: v */
    protected final int mo1156v(int i) {
        return this.f8822e[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: w */
    protected final AbstractC2586bb mo1155w(int i) {
        return this.f8823f[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: z */
    protected final Object mo1154z(int i) {
        return this.f8824g[i];
    }
}

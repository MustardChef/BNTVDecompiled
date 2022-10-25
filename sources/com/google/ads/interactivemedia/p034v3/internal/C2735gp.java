package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.gp */
/* loaded from: classes2.dex */
public final class C2735gp extends AbstractC2670ee {

    /* renamed from: b */
    private final int f7438b;

    /* renamed from: c */
    private final int f7439c;

    /* renamed from: d */
    private final int[] f7440d;

    /* renamed from: e */
    private final int[] f7441e;

    /* renamed from: f */
    private final AbstractC2586bb[] f7442f;

    /* renamed from: g */
    private final Object[] f7443g;

    /* renamed from: h */
    private final HashMap f7444h;

    public C2735gp(Collection collection, C3101ud c3101ud) {
        super(c3101ud);
        int size = collection.size();
        this.f7440d = new int[size];
        this.f7441e = new int[size];
        this.f7442f = new AbstractC2586bb[size];
        this.f7443g = new Object[size];
        this.f7444h = new HashMap();
        Iterator it = collection.iterator();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            InterfaceC2724ge interfaceC2724ge = (InterfaceC2724ge) it.next();
            this.f7442f[i3] = interfaceC2724ge.mo2238a();
            this.f7441e[i3] = i;
            this.f7440d[i3] = i2;
            i += this.f7442f[i3].mo923c();
            i2 += this.f7442f[i3].mo924b();
            this.f7443g[i3] = interfaceC2724ge.mo2237b();
            this.f7444h.put(this.f7443g[i3], Integer.valueOf(i3));
            i3++;
        }
        this.f7438b = i;
        this.f7439c = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public final List m2189A() {
        return Arrays.asList(this.f7442f);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: b */
    public final int mo924b() {
        return this.f7439c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2586bb
    /* renamed from: c */
    public final int mo923c() {
        return this.f7438b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: r */
    protected final int mo1160r(Object obj) {
        Integer num = (Integer) this.f7444h.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: s */
    protected final int mo1159s(int i) {
        return C2628cq.m2541ao(this.f7440d, i + 1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: t */
    protected final int mo1158t(int i) {
        return C2628cq.m2541ao(this.f7441e, i + 1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: u */
    protected final int mo1157u(int i) {
        return this.f7440d[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: v */
    protected final int mo1156v(int i) {
        return this.f7441e[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: w */
    protected final AbstractC2586bb mo1155w(int i) {
        return this.f7442f[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC2670ee
    /* renamed from: z */
    protected final Object mo1154z(int i) {
        return this.f7443g[i];
    }
}

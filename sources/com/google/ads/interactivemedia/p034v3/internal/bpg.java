package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpg */
/* loaded from: classes2.dex */
final class bpg implements Iterator {

    /* renamed from: a */
    final /* synthetic */ bpi f6374a;

    /* renamed from: b */
    private int f6375b = -1;

    /* renamed from: c */
    private boolean f6376c;

    /* renamed from: d */
    private Iterator f6377d;

    /* renamed from: a */
    private final Iterator m2971a() {
        Map map;
        if (this.f6377d == null) {
            map = this.f6374a.f6381c;
            this.f6377d = map.entrySet().iterator();
        }
        return this.f6377d;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f6375b + 1;
        list = this.f6374a.f6380b;
        if (i >= list.size()) {
            map = this.f6374a.f6381c;
            return !map.isEmpty() && m2971a().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        List list;
        List list2;
        this.f6376c = true;
        int i = this.f6375b + 1;
        this.f6375b = i;
        list = this.f6374a.f6380b;
        if (i < list.size()) {
            list2 = this.f6374a.f6380b;
            return (Map.Entry) list2.get(this.f6375b);
        }
        return (Map.Entry) m2971a().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f6376c) {
            this.f6376c = false;
            this.f6374a.m2956o();
            int i = this.f6375b;
            list = this.f6374a.f6380b;
            if (i < list.size()) {
                bpi bpiVar = this.f6374a;
                int i2 = this.f6375b;
                this.f6375b = i2 - 1;
                bpiVar.m2958m(i2);
                return;
            }
            m2971a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}

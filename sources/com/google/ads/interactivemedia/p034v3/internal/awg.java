package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awg */
/* loaded from: classes2.dex */
abstract class awg extends AbstractMap {

    /* renamed from: a */
    private transient Set f5203a;

    /* renamed from: b */
    private transient Set f5204b;

    /* renamed from: c */
    private transient Collection f5205c;

    /* renamed from: b */
    abstract Set mo4466b();

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f5203a;
        if (set == null) {
            Set mo4466b = mo4466b();
            this.f5203a = mo4466b;
            return mo4466b;
        }
        return set;
    }

    /* renamed from: g */
    Set mo4465g() {
        return new awe(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f5204b;
        if (set == null) {
            Set mo4465g = mo4465g();
            this.f5204b = mo4465g;
            return mo4465g;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f5205c;
        if (collection == null) {
            awf awfVar = new awf(this);
            this.f5205c = awfVar;
            return awfVar;
        }
        return collection;
    }
}

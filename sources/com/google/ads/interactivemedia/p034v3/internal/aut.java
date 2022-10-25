package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aut */
/* loaded from: classes2.dex */
public final class aut extends AbstractMap implements Serializable, auj {

    /* renamed from: a */
    private final auz f5125a;

    /* renamed from: b */
    private transient Set f5126b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aut(auz auzVar) {
        this.f5125a = auzVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f5125a.f5150p = this;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f5125a.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f5125a.containsValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f5125a.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f5126b;
        if (set == null) {
            auu auuVar = new auu(this.f5125a);
            this.f5126b = auuVar;
            return auuVar;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        auz auzVar = this.f5125a;
        int m4549e = auzVar.m4549e(obj);
        if (m4549e == -1) {
            return null;
        }
        return auzVar.f5135a[m4549e];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        return this.f5125a.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        return this.f5125a.m4537q(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        auz auzVar = this.f5125a;
        int m4417E = axd.m4417E(obj);
        int m4548f = auzVar.m4548f(obj, m4417E);
        if (m4548f == -1) {
            return null;
        }
        Object obj2 = auzVar.f5135a[m4548f];
        auzVar.m4543k(m4548f, m4417E);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f5125a.f5137c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Collection values() {
        return this.f5125a.keySet();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bq */
/* loaded from: classes2.dex */
public final class C2601bq implements Iterable {

    /* renamed from: a */
    private final Object f6431a = new Object();

    /* renamed from: b */
    private final Map f6432b = new HashMap();

    /* renamed from: c */
    private Set f6433c = Collections.emptySet();

    /* renamed from: d */
    private List f6434d = Collections.emptyList();

    /* renamed from: a */
    public final int m2857a(Object obj) {
        int intValue;
        synchronized (this.f6431a) {
            intValue = this.f6432b.containsKey(obj) ? ((Integer) this.f6432b.get(obj)).intValue() : 0;
        }
        return intValue;
    }

    /* renamed from: b */
    public final Set m2856b() {
        Set set;
        synchronized (this.f6431a) {
            set = this.f6433c;
        }
        return set;
    }

    /* renamed from: c */
    public final void m2855c(Object obj) {
        synchronized (this.f6431a) {
            ArrayList arrayList = new ArrayList(this.f6434d);
            arrayList.add(obj);
            this.f6434d = Collections.unmodifiableList(arrayList);
            Integer num = (Integer) this.f6432b.get(obj);
            if (num == null) {
                HashSet hashSet = new HashSet(this.f6433c);
                hashSet.add(obj);
                this.f6433c = Collections.unmodifiableSet(hashSet);
            }
            this.f6432b.put(obj, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    /* renamed from: d */
    public final void m2854d(Object obj) {
        synchronized (this.f6431a) {
            Integer num = (Integer) this.f6432b.get(obj);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f6434d);
            arrayList.remove(obj);
            this.f6434d = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.f6432b.remove(obj);
                HashSet hashSet = new HashSet(this.f6433c);
                hashSet.remove(obj);
                this.f6433c = Collections.unmodifiableSet(hashSet);
            } else {
                this.f6432b.put(obj, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator it;
        synchronized (this.f6431a) {
            it = this.f6434d.iterator();
        }
        return it;
    }
}

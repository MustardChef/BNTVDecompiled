package com.google.ads.interactivemedia.p034v3.internal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bpi */
/* loaded from: classes2.dex */
public class bpi extends AbstractMap {

    /* renamed from: a */
    private final int f6379a;

    /* renamed from: d */
    private boolean f6382d;

    /* renamed from: e */
    private volatile bph f6383e;

    /* renamed from: b */
    private List f6380b = Collections.emptyList();

    /* renamed from: c */
    private Map f6381c = Collections.emptyMap();

    /* renamed from: f */
    private Map f6384f = Collections.emptyMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static bpi m2968c(int i) {
        return new bpb(i);
    }

    /* renamed from: l */
    private final int m2959l(Comparable comparable) {
        int size = this.f6380b.size() - 1;
        int i = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((bpf) this.f6380b.get(size)).m2973a());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = comparable.compareTo(((bpf) this.f6380b.get(i2)).m2973a());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public final Object m2958m(int i) {
        m2956o();
        Object value = ((bpf) this.f6380b.remove(i)).getValue();
        if (!this.f6381c.isEmpty()) {
            Iterator it = m2957n().entrySet().iterator();
            List list = this.f6380b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new bpf(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    /* renamed from: n */
    private final SortedMap m2957n() {
        m2956o();
        if (this.f6381c.isEmpty() && !(this.f6381c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f6381c = treeMap;
            this.f6384f = treeMap.descendingMap();
        }
        return (SortedMap) this.f6381c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public final void m2956o() {
        if (this.f6382d) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a */
    public void mo2970a() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        if (this.f6382d) {
            return;
        }
        if (this.f6381c.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.f6381c);
        }
        this.f6381c = unmodifiableMap;
        if (this.f6384f.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.f6384f);
        }
        this.f6384f = unmodifiableMap2;
        this.f6382d = true;
    }

    /* renamed from: b */
    public final int m2969b() {
        return this.f6380b.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        m2956o();
        if (!this.f6380b.isEmpty()) {
            this.f6380b.clear();
        }
        if (this.f6381c.isEmpty()) {
            return;
        }
        this.f6381c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m2959l(comparable) >= 0 || this.f6381c.containsKey(comparable);
    }

    /* renamed from: d */
    public final Iterable m2967d() {
        return this.f6381c.isEmpty() ? bpe.m2975a() : this.f6381c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: e */
    public final Object put(Comparable comparable, Object obj) {
        m2956o();
        int m2959l = m2959l(comparable);
        if (m2959l >= 0) {
            return ((bpf) this.f6380b.get(m2959l)).setValue(obj);
        }
        m2956o();
        if (this.f6380b.isEmpty() && !(this.f6380b instanceof ArrayList)) {
            this.f6380b = new ArrayList(this.f6379a);
        }
        int i = -(m2959l + 1);
        if (i >= this.f6379a) {
            return m2957n().put(comparable, obj);
        }
        int size = this.f6380b.size();
        int i2 = this.f6379a;
        if (size == i2) {
            bpf bpfVar = (bpf) this.f6380b.remove(i2 - 1);
            m2957n().put(bpfVar.m2973a(), bpfVar.getValue());
        }
        this.f6380b.add(i, new bpf(this, comparable, obj));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f6383e == null) {
            this.f6383e = new bph(this);
        }
        return this.f6383e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bpi)) {
            return super.equals(obj);
        }
        bpi bpiVar = (bpi) obj;
        int size = size();
        if (size != bpiVar.size()) {
            return false;
        }
        int m2969b = m2969b();
        if (m2969b == bpiVar.m2969b()) {
            for (int i = 0; i < m2969b; i++) {
                if (!m2964g(i).equals(bpiVar.m2964g(i))) {
                    return false;
                }
            }
            if (m2969b != size) {
                return this.f6381c.equals(bpiVar.f6381c);
            }
            return true;
        }
        return entrySet().equals(bpiVar.entrySet());
    }

    /* renamed from: g */
    public final Map.Entry m2964g(int i) {
        return (Map.Entry) this.f6380b.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int m2959l = m2959l(comparable);
        if (m2959l >= 0) {
            return ((bpf) this.f6380b.get(m2959l)).getValue();
        }
        return this.f6381c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int m2969b = m2969b();
        int i = 0;
        for (int i2 = 0; i2 < m2969b; i2++) {
            i += ((bpf) this.f6380b.get(i2)).hashCode();
        }
        return this.f6381c.size() > 0 ? i + this.f6381c.hashCode() : i;
    }

    /* renamed from: j */
    public final boolean m2961j() {
        return this.f6382d;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        m2956o();
        Comparable comparable = (Comparable) obj;
        int m2959l = m2959l(comparable);
        if (m2959l >= 0) {
            return m2958m(m2959l);
        }
        if (this.f6381c.isEmpty()) {
            return null;
        }
        return this.f6381c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f6380b.size() + this.f6381c.size();
    }
}

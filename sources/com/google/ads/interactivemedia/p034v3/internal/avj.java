package com.google.ads.interactivemedia.p034v3.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avj */
/* loaded from: classes2.dex */
public abstract class avj<K, V> implements Map<K, V>, Serializable {

    /* renamed from: a */
    private transient avo f5176a;

    /* renamed from: b */
    private transient avo f5177b;

    /* renamed from: c */
    private transient avb f5178c;

    /* renamed from: c */
    public static avj m4505c(Map map) {
        if ((map instanceof avj) && !(map instanceof SortedMap)) {
            avj avjVar = (avj) map;
            if (!avjVar.mo4442i()) {
                return avjVar;
            }
        }
        Set<Map.Entry<K, V>> entrySet = map.entrySet();
        avh avhVar = new avh(entrySet instanceof Collection ? entrySet.size() : 4);
        avhVar.m4507e(entrySet);
        return avhVar.mo4489c();
    }

    /* renamed from: d */
    public static avj m4504d() {
        return awv.f5223a;
    }

    /* renamed from: j */
    public static avj m4502j(Object obj) {
        axd.m4415G("adBreakTime", obj);
        return awv.m4441k(1, new Object[]{"adBreakTime", obj});
    }

    /* renamed from: a */
    abstract avb mo4445a();

    @Override // java.util.Map
    /* renamed from: b */
    public avb values() {
        avb avbVar = this.f5178c;
        if (avbVar == null) {
            avb mo4445a = mo4445a();
            this.f5178c = mo4445a;
            return mo4445a;
        }
        return avbVar;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    /* renamed from: e */
    abstract avo mo4444e();

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    /* renamed from: f */
    abstract avo mo4443f();

    @Override // java.util.Map
    /* renamed from: g */
    public final avo entrySet() {
        avo avoVar = this.f5176a;
        if (avoVar == null) {
            avo mo4444e = mo4444e();
            this.f5176a = mo4444e;
            return mo4444e;
        }
        return avoVar;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    /* renamed from: h */
    public avo keySet() {
        avo avoVar = this.f5177b;
        if (avoVar == null) {
            avo mo4443f = mo4443f();
            this.f5177b = mo4443f;
            return mo4443f;
        }
        return avoVar;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return axd.m4410b(entrySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public abstract boolean mo4442i();

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        axd.m4413I(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    Object writeReplace() {
        return new avi(this);
    }
}

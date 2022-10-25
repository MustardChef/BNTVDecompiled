package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhl */
/* loaded from: classes2.dex */
public final class bhl {

    /* renamed from: a */
    private final Map f5727a;

    /* renamed from: b */
    private final bkk f5728b = bkk.m3607b();

    public bhl(Map map) {
        this.f5727a = map;
    }

    /* renamed from: a */
    public final bhz m3681a(bkt bktVar) {
        bhj bhjVar;
        Type m3599d = bktVar.m3599d();
        Class m3600c = bktVar.m3600c();
        bgj bgjVar = (bgj) this.f5727a.get(m3599d);
        if (bgjVar != null) {
            return new bhi(bgjVar, m3599d, 1);
        }
        bgj bgjVar2 = (bgj) this.f5727a.get(m3600c);
        if (bgjVar2 == null) {
            bhz bhzVar = null;
            try {
                Constructor declaredConstructor = m3600c.getDeclaredConstructor(new Class[0]);
                if (!declaredConstructor.isAccessible()) {
                    this.f5728b.mo3606a(declaredConstructor);
                }
                bhjVar = new bhj(declaredConstructor);
            } catch (NoSuchMethodException unused) {
                bhjVar = null;
            }
            if (bhjVar == null) {
                if (Collection.class.isAssignableFrom(m3600c)) {
                    if (SortedSet.class.isAssignableFrom(m3600c)) {
                        bhzVar = new bhg(4);
                    } else if (EnumSet.class.isAssignableFrom(m3600c)) {
                        bhzVar = new bhk(m3599d);
                    } else if (Set.class.isAssignableFrom(m3600c)) {
                        bhzVar = new bhg(5);
                    } else {
                        bhzVar = Queue.class.isAssignableFrom(m3600c) ? new bhg(6) : new bhg(7);
                    }
                } else if (Map.class.isAssignableFrom(m3600c)) {
                    if (ConcurrentNavigableMap.class.isAssignableFrom(m3600c)) {
                        bhzVar = new bhg(8);
                    } else if (ConcurrentMap.class.isAssignableFrom(m3600c)) {
                        bhzVar = new bhg(1);
                    } else if (SortedMap.class.isAssignableFrom(m3600c)) {
                        bhzVar = new bhg(0);
                    } else {
                        bhzVar = (!(m3599d instanceof ParameterizedType) || String.class.isAssignableFrom(bkt.m3601b(((ParameterizedType) m3599d).getActualTypeArguments()[0]).m3600c())) ? new bhg(3) : new bhg(2);
                    }
                }
                return bhzVar != null ? bhzVar : new bhh(m3600c, m3599d);
            }
            return bhjVar;
        }
        return new bhi(bgjVar2, m3599d, 0);
    }

    public final String toString() {
        return this.f5727a.toString();
    }
}

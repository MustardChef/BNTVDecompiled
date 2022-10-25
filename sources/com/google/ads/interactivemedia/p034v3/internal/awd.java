package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awd */
/* loaded from: classes2.dex */
public abstract class awd extends axa {
    /* renamed from: a */
    abstract Map mo4467a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        mo4467a().clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object m4395q = axd.m4395q(mo4467a(), key);
            if (anx.m4882b(m4395q, entry.getValue())) {
                return m4395q != null || mo4467a().containsKey(key);
            }
            return false;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return mo4467a().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        if (contains(obj) && (obj instanceof Map.Entry)) {
            return mo4467a().keySet().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.axa, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        try {
            atm.m4612j(collection);
            return axd.m4406f(this, collection);
        } catch (UnsupportedOperationException unused) {
            return axd.m4405g(this, collection.iterator());
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.axa, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        try {
            atm.m4612j(collection);
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet m4408d = axd.m4408d(collection.size());
            for (Object obj : collection) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    m4408d.add(((Map.Entry) obj).getKey());
                }
            }
            return mo4467a().keySet().retainAll(m4408d);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return mo4467a().size();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bhy */
/* loaded from: classes2.dex */
public final class bhy extends AbstractMap implements Serializable {

    /* renamed from: f */
    private static final Comparator f5758f = new bhr();

    /* renamed from: a */
    final Comparator f5759a;

    /* renamed from: b */
    bhx f5760b;

    /* renamed from: c */
    int f5761c;

    /* renamed from: d */
    int f5762d;

    /* renamed from: e */
    final bhx f5763e;

    /* renamed from: g */
    private bht f5764g;

    /* renamed from: h */
    private bhv f5765h;

    public bhy() {
        Comparator comparator = f5758f;
        this.f5761c = 0;
        this.f5762d = 0;
        this.f5763e = new bhx();
        this.f5759a = comparator;
    }

    /* renamed from: f */
    private final void m3663f(bhx bhxVar, boolean z) {
        while (bhxVar != null) {
            bhx bhxVar2 = bhxVar.f5751b;
            bhx bhxVar3 = bhxVar.f5752c;
            int i = bhxVar2 != null ? bhxVar2.f5757h : 0;
            int i2 = bhxVar3 != null ? bhxVar3.f5757h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                bhx bhxVar4 = bhxVar3.f5751b;
                bhx bhxVar5 = bhxVar3.f5752c;
                int i4 = (bhxVar4 != null ? bhxVar4.f5757h : 0) - (bhxVar5 != null ? bhxVar5.f5757h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    m3661h(bhxVar);
                } else {
                    m3660i(bhxVar3);
                    m3661h(bhxVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                bhx bhxVar6 = bhxVar2.f5751b;
                bhx bhxVar7 = bhxVar2.f5752c;
                int i5 = (bhxVar6 != null ? bhxVar6.f5757h : 0) - (bhxVar7 != null ? bhxVar7.f5757h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    m3660i(bhxVar);
                } else {
                    m3661h(bhxVar2);
                    m3660i(bhxVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                bhxVar.f5757h = i + 1;
                if (z) {
                    return;
                }
            } else {
                bhxVar.f5757h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            bhxVar = bhxVar.f5750a;
        }
    }

    /* renamed from: g */
    private final void m3662g(bhx bhxVar, bhx bhxVar2) {
        bhx bhxVar3 = bhxVar.f5750a;
        bhxVar.f5750a = null;
        if (bhxVar2 != null) {
            bhxVar2.f5750a = bhxVar3;
        }
        if (bhxVar3 == null) {
            this.f5760b = bhxVar2;
        } else if (bhxVar3.f5751b == bhxVar) {
            bhxVar3.f5751b = bhxVar2;
        } else {
            bhxVar3.f5752c = bhxVar2;
        }
    }

    /* renamed from: h */
    private final void m3661h(bhx bhxVar) {
        bhx bhxVar2 = bhxVar.f5751b;
        bhx bhxVar3 = bhxVar.f5752c;
        bhx bhxVar4 = bhxVar3.f5751b;
        bhx bhxVar5 = bhxVar3.f5752c;
        bhxVar.f5752c = bhxVar4;
        if (bhxVar4 != null) {
            bhxVar4.f5750a = bhxVar;
        }
        m3662g(bhxVar, bhxVar3);
        bhxVar3.f5751b = bhxVar;
        bhxVar.f5750a = bhxVar3;
        int max = Math.max(bhxVar2 != null ? bhxVar2.f5757h : 0, bhxVar4 != null ? bhxVar4.f5757h : 0) + 1;
        bhxVar.f5757h = max;
        bhxVar3.f5757h = Math.max(max, bhxVar5 != null ? bhxVar5.f5757h : 0) + 1;
    }

    /* renamed from: i */
    private final void m3660i(bhx bhxVar) {
        bhx bhxVar2 = bhxVar.f5751b;
        bhx bhxVar3 = bhxVar.f5752c;
        bhx bhxVar4 = bhxVar2.f5751b;
        bhx bhxVar5 = bhxVar2.f5752c;
        bhxVar.f5751b = bhxVar5;
        if (bhxVar5 != null) {
            bhxVar5.f5750a = bhxVar;
        }
        m3662g(bhxVar, bhxVar2);
        bhxVar2.f5752c = bhxVar;
        bhxVar.f5750a = bhxVar2;
        int max = Math.max(bhxVar3 != null ? bhxVar3.f5757h : 0, bhxVar5 != null ? bhxVar5.f5757h : 0) + 1;
        bhxVar.f5757h = max;
        bhxVar2.f5757h = Math.max(max, bhxVar4 != null ? bhxVar4.f5757h : 0) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    /* renamed from: a */
    final bhx m3668a(Object obj, boolean z) {
        int i;
        bhx bhxVar;
        Comparator comparator = this.f5759a;
        bhx bhxVar2 = this.f5760b;
        if (bhxVar2 != null) {
            Comparable comparable = comparator == f5758f ? (Comparable) obj : null;
            while (true) {
                if (comparable != null) {
                    i = comparable.compareTo(bhxVar2.f5755f);
                } else {
                    i = comparator.compare(obj, bhxVar2.f5755f);
                }
                if (i == 0) {
                    return bhxVar2;
                }
                bhx bhxVar3 = i < 0 ? bhxVar2.f5751b : bhxVar2.f5752c;
                if (bhxVar3 == null) {
                    break;
                }
                bhxVar2 = bhxVar3;
            }
        } else {
            i = 0;
        }
        if (z) {
            bhx bhxVar4 = this.f5763e;
            if (bhxVar2 == null) {
                if (comparator == f5758f && !(obj instanceof Comparable)) {
                    throw new ClassCastException(String.valueOf(obj.getClass().getName()).concat(" is not Comparable"));
                }
                bhxVar = new bhx(null, obj, bhxVar4, bhxVar4.f5754e);
                this.f5760b = bhxVar;
            } else {
                bhxVar = new bhx(bhxVar2, obj, bhxVar4, bhxVar4.f5754e);
                if (i < 0) {
                    bhxVar2.f5751b = bhxVar;
                } else {
                    bhxVar2.f5752c = bhxVar;
                }
                m3663f(bhxVar2, true);
            }
            this.f5761c++;
            this.f5762d++;
            return bhxVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final bhx m3667b(Map.Entry entry) {
        bhx m3666c = m3666c(entry.getKey());
        if (m3666c != null) {
            Object obj = m3666c.f5756g;
            Object value = entry.getValue();
            if (obj == value || (obj != null && obj.equals(value))) {
                return m3666c;
            }
            return null;
        }
        return null;
    }

    /* renamed from: c */
    final bhx m3666c(Object obj) {
        if (obj != null) {
            try {
                return m3668a(obj, false);
            } catch (ClassCastException unused) {
                return null;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f5760b = null;
        this.f5761c = 0;
        this.f5762d++;
        bhx bhxVar = this.f5763e;
        bhxVar.f5754e = bhxVar;
        bhxVar.f5753d = bhxVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return m3666c(obj) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final bhx m3665d(Object obj) {
        bhx m3666c = m3666c(obj);
        if (m3666c != null) {
            m3664e(m3666c, true);
        }
        return m3666c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final void m3664e(bhx bhxVar, boolean z) {
        bhx bhxVar2;
        bhx bhxVar3;
        int i;
        if (z) {
            bhx bhxVar4 = bhxVar.f5754e;
            bhxVar4.f5753d = bhxVar.f5753d;
            bhxVar.f5753d.f5754e = bhxVar4;
        }
        bhx bhxVar5 = bhxVar.f5751b;
        bhx bhxVar6 = bhxVar.f5752c;
        bhx bhxVar7 = bhxVar.f5750a;
        int i2 = 0;
        if (bhxVar5 == null || bhxVar6 == null) {
            if (bhxVar5 != null) {
                m3662g(bhxVar, bhxVar5);
                bhxVar.f5751b = null;
            } else if (bhxVar6 != null) {
                m3662g(bhxVar, bhxVar6);
                bhxVar.f5752c = null;
            } else {
                m3662g(bhxVar, null);
            }
            m3663f(bhxVar7, false);
            this.f5761c--;
            this.f5762d++;
            return;
        }
        if (bhxVar5.f5757h > bhxVar6.f5757h) {
            do {
                bhxVar3 = bhxVar5;
                bhxVar5 = bhxVar5.f5752c;
            } while (bhxVar5 != null);
        } else {
            do {
                bhxVar2 = bhxVar6;
                bhxVar6 = bhxVar6.f5751b;
            } while (bhxVar6 != null);
            bhxVar3 = bhxVar2;
        }
        m3664e(bhxVar3, false);
        bhx bhxVar8 = bhxVar.f5751b;
        if (bhxVar8 != null) {
            i = bhxVar8.f5757h;
            bhxVar3.f5751b = bhxVar8;
            bhxVar8.f5750a = bhxVar3;
            bhxVar.f5751b = null;
        } else {
            i = 0;
        }
        bhx bhxVar9 = bhxVar.f5752c;
        if (bhxVar9 != null) {
            i2 = bhxVar9.f5757h;
            bhxVar3.f5752c = bhxVar9;
            bhxVar9.f5750a = bhxVar3;
            bhxVar.f5752c = null;
        }
        bhxVar3.f5757h = Math.max(i, i2) + 1;
        m3662g(bhxVar, bhxVar3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        bht bhtVar = this.f5764g;
        if (bhtVar != null) {
            return bhtVar;
        }
        bht bhtVar2 = new bht(this);
        this.f5764g = bhtVar2;
        return bhtVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        bhx m3666c = m3666c(obj);
        if (m3666c != null) {
            return m3666c.f5756g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        bhv bhvVar = this.f5765h;
        if (bhvVar != null) {
            return bhvVar;
        }
        bhv bhvVar2 = new bhv(this);
        this.f5765h = bhvVar2;
        return bhvVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        Objects.requireNonNull(obj, "key == null");
        bhx m3668a = m3668a(obj, true);
        Object obj3 = m3668a.f5756g;
        m3668a.f5756g = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        bhx m3665d = m3665d(obj);
        if (m3665d != null) {
            return m3665d.f5756g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f5761c;
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.axd */
/* loaded from: classes2.dex */
public final class axd {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* renamed from: A */
    public static Object[] m4421A(Iterable iterable) {
        boolean z = iterable instanceof Collection;
        ArrayList arrayList = iterable;
        if (!z) {
            arrayList = m4392t(iterable.iterator());
        }
        return arrayList.toArray();
    }

    /* renamed from: B */
    public static Object m4420B(Iterable iterable) {
        return m4387y(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C */
    public static Object m4419C(Iterable iterable) {
        if (iterable.isEmpty()) {
            return null;
        }
        return m4412J(iterable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: D */
    public static int m4418D(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: E */
    public static int m4417E(Object obj) {
        return m4418D(obj == null ? 0 : obj.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: F */
    public static int m4416F(int i) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max > highestOneBit) {
            int i2 = highestOneBit + highestOneBit;
            if (i2 > 0) {
                return i2;
            }
            return 1073741824;
        }
        return highestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: G */
    public static void m4415G(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            String.valueOf(valueOf).length();
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(valueOf)));
        } else if (obj2 != null) {
        } else {
            String obj3 = obj.toString();
            StringBuilder sb = new StringBuilder(obj3.length() + 26);
            sb.append("null value in entry: ");
            sb.append(obj3);
            sb.append("=null");
            throw new NullPointerException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: H */
    public static void m4414H(boolean z) {
        atm.m4614h(z, "no calls to next() since the last call to remove()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: I */
    public static void m4413I(int i, String str) {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 40);
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: J */
    private static Object m4412J(List list) {
        return list.get(list.size() - 1);
    }

    /* renamed from: a */
    public static boolean m4411a(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        atm.m4612j(comparator);
        atm.m4612j(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = awo.f5210a;
            }
        } else if (!(iterable instanceof axc)) {
            return false;
        } else {
            comparator2 = ((axc) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static int m4410b(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    /* renamed from: c */
    public static HashSet m4409c() {
        return new HashSet();
    }

    /* renamed from: d */
    public static HashSet m4408d(int i) {
        return new HashSet(m4397o(i));
    }

    /* renamed from: e */
    public static Set m4407e() {
        return Collections.newSetFromMap(new IdentityHashMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static boolean m4406f(Set set, Collection collection) {
        atm.m4612j(collection);
        if (collection instanceof awn) {
            collection = ((awn) collection).m4452a();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return m4405g(set, collection.iterator());
        }
        Iterator it = set.iterator();
        atm.m4612j(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static boolean m4405g(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    /* renamed from: h */
    public static void m4404h(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: i */
    public static void m4403i(Object obj) {
        Objects.requireNonNull(obj);
    }

    /* renamed from: j */
    public static int m4402j() {
        try {
            return Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return -1;
        }
    }

    /* renamed from: k */
    public static boolean m4401k() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public static Object[] m4400l(Object[] objArr, int i) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public static void m4399m(Object obj, int i) {
        if (obj != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i);
        throw new NullPointerException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static void m4398n(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            m4399m(objArr[i2], i2);
        }
    }

    /* renamed from: o */
    static int m4397o(int i) {
        if (i < 3) {
            m4413I(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static Object m4396p(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static Object m4395q(Map map, Object obj) {
        atm.m4612j(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* renamed from: r */
    public static HashMap m4394r(int i) {
        return new HashMap(m4397o(i));
    }

    /* renamed from: s */
    public static Map.Entry m4393s(Object obj, Object obj2) {
        return new avc(obj, obj2);
    }

    /* renamed from: t */
    public static ArrayList m4392t(Iterator it) {
        ArrayList arrayList = new ArrayList();
        atm.m4612j(it);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @SafeVarargs
    /* renamed from: u */
    public static ArrayList m4391u(Object... objArr) {
        m4413I(1, "arraySize");
        ArrayList arrayList = new ArrayList(6);
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    /* renamed from: v */
    public static Object m4390v(Iterator it) {
        Object next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public static Object m4389w(Iterator it) {
        if (it.hasNext()) {
            Object next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public static void m4388x(Iterator it) {
        atm.m4612j(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    /* renamed from: y */
    public static Object m4387y(Iterator it) {
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: z */
    public static Object m4386z(Iterable iterable) {
        if (iterable instanceof List) {
            if (iterable.isEmpty()) {
                throw new NoSuchElementException();
            }
            return m4412J(iterable);
        }
        return m4390v(iterable.iterator());
    }
}

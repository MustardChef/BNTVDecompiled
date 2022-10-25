package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.awx */
/* loaded from: classes2.dex */
public final class awx extends avw {

    /* renamed from: c */
    static final awx f5234c = new awx(avg.m4515n(), awo.f5210a);

    /* renamed from: d */
    final transient avg f5235d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public awx(avg avgVar, Comparator comparator) {
        super(comparator);
        this.f5235d = avgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public final int m4437A(Object obj, boolean z) {
        avg avgVar = this.f5235d;
        atm.m4612j(obj);
        int binarySearch = Collections.binarySearch(avgVar, obj, ((avw) this).f5195a);
        return binarySearch >= 0 ? z ? binarySearch : binarySearch + 1 : ~binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public final awx m4436B(int i, int i2) {
        if (i == 0) {
            if (i2 == size()) {
                return this;
            }
            i = 0;
        }
        if (i < i2) {
            return new awx(this.f5235d.subList(i, i2), this.f5195a);
        }
        return m4468x(this.f5195a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: a */
    public final int mo4435a() {
        return this.f5235d.mo4435a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: b */
    public final int mo4434b() {
        return this.f5235d.mo4434b();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: c */
    public final avg mo4425c() {
        return this.f5235d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        int m4437A = m4437A(obj, true);
        if (m4437A == size()) {
            return null;
        }
        return this.f5235d.get(m4437A);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.f5235d, obj, this.f5195a) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof awn) {
            collection = ((awn) collection).m4452a();
        }
        if (!axd.m4411a(((avw) this).f5195a, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        axf it = iterator();
        Iterator it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
        while (true) {
            try {
                int m4473j = m4473j(next2, next);
                if (m4473j >= 0) {
                    if (m4473j != 0) {
                        break;
                    } else if (!it2.hasNext()) {
                        return true;
                    } else {
                        next = it2.next();
                    }
                } else if (!it.hasNext()) {
                    return false;
                } else {
                    next2 = it.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw, com.google.ads.interactivemedia.p034v3.internal.avo, com.google.ads.interactivemedia.p034v3.internal.avb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: d */
    public final axf iterator() {
        return this.f5235d.listIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: e */
    public final boolean mo4423e() {
        return this.f5235d.mo4423e();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: ClassCastException | NoSuchElementException -> 0x0046, TryCatch #0 {ClassCastException | NoSuchElementException -> 0x0046, blocks: (B:17:0x002a, B:18:0x002e, B:20:0x0034, B:22:0x003e), top: B:29:0x002a }] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avo, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L4
            return r0
        L4:
            boolean r1 = r6 instanceof java.util.Set
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            java.util.Set r6 = (java.util.Set) r6
            int r1 = r5.size()
            int r3 = r6.size()
            if (r1 == r3) goto L17
            return r2
        L17:
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L1e
            return r0
        L1e:
            java.util.Comparator r1 = r5.f5195a
            boolean r1 = com.google.ads.interactivemedia.p034v3.internal.axd.m4411a(r1, r6)
            if (r1 == 0) goto L47
            java.util.Iterator r6 = r6.iterator()
            com.google.ads.interactivemedia.v3.internal.axf r1 = r5.iterator()     // Catch: java.lang.Throwable -> L46
        L2e:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L45
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r4 = r6.next()     // Catch: java.lang.Throwable -> L46
            if (r4 == 0) goto L44
            int r3 = r5.m4473j(r3, r4)     // Catch: java.lang.Throwable -> L46
            if (r3 == 0) goto L2e
        L44:
            return r2
        L45:
            return r0
        L46:
            return r2
        L47:
            boolean r6 = r5.containsAll(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.awx.equals(java.lang.Object):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: f */
    public final Object[] mo4433f() {
        return this.f5235d.mo4433f();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f5235d.get(0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw, java.util.NavigableSet
    public final Object floor(Object obj) {
        int m4427z = m4427z(obj, true) - 1;
        if (m4427z == -1) {
            return null;
        }
        return this.f5235d.get(m4427z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avb
    /* renamed from: g */
    public final int mo4422g(Object[] objArr) {
        return this.f5235d.mo4422g(objArr);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw, java.util.NavigableSet
    public final Object higher(Object obj) {
        int m4437A = m4437A(obj, false);
        if (m4437A == size()) {
            return null;
        }
        return this.f5235d.get(m4437A);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f5235d.get(size() - 1);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw, java.util.NavigableSet
    public final Object lower(Object obj) {
        int m4427z = m4427z(obj, false) - 1;
        if (m4427z == -1) {
            return null;
        }
        return this.f5235d.get(m4427z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw
    /* renamed from: p */
    final avw mo4432p() {
        Comparator reverseOrder = Collections.reverseOrder(this.f5195a);
        if (isEmpty()) {
            return m4468x(reverseOrder);
        }
        return new awx(this.f5235d.mo4521h(), reverseOrder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.avw
    /* renamed from: s */
    public final avw mo4431s(Object obj, boolean z) {
        return m4436B(0, m4427z(obj, z));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f5235d.size();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw
    /* renamed from: u */
    final avw mo4430u(Object obj, boolean z, Object obj2, boolean z2) {
        return mo4429w(obj, z).mo4431s(obj2, z2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw
    /* renamed from: w */
    final avw mo4429w(Object obj, boolean z) {
        return m4436B(m4437A(obj, z), size());
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avw, java.util.NavigableSet
    /* renamed from: y */
    public final axf descendingIterator() {
        return this.f5235d.mo4521h().listIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z */
    public final int m4427z(Object obj, boolean z) {
        avg avgVar = this.f5235d;
        atm.m4612j(obj);
        int binarySearch = Collections.binarySearch(avgVar, obj, ((avw) this).f5195a);
        return binarySearch >= 0 ? z ? binarySearch + 1 : binarySearch : ~binarySearch;
    }
}

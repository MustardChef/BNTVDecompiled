package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auz */
/* loaded from: classes2.dex */
public final class auz extends AbstractMap implements Serializable, auj {

    /* renamed from: a */
    transient Object[] f5135a;

    /* renamed from: b */
    transient Object[] f5136b;

    /* renamed from: c */
    transient int f5137c;

    /* renamed from: d */
    transient int f5138d;

    /* renamed from: e */
    private transient int[] f5139e;

    /* renamed from: f */
    private transient int[] f5140f;

    /* renamed from: g */
    private transient int[] f5141g;

    /* renamed from: h */
    private transient int[] f5142h;

    /* renamed from: i */
    private transient int f5143i;

    /* renamed from: j */
    private transient int f5144j;

    /* renamed from: k */
    private transient int[] f5145k;

    /* renamed from: l */
    private transient int[] f5146l;

    /* renamed from: m */
    private transient Set f5147m;

    /* renamed from: n */
    private transient Set f5148n;

    /* renamed from: o */
    private transient Set f5149o;

    /* renamed from: p */
    private transient auj f5150p;

    private auz() {
        m4545i(2);
    }

    /* renamed from: A */
    private static int[] m4556A(int[] iArr, int i) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i);
        Arrays.fill(copyOf, length, i, -1);
        return copyOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public final void m4555B(int i, Object obj) {
        atm.m4618d(i != -1);
        int m4550d = m4550d(obj, axd.m4417E(obj));
        int i2 = this.f5144j;
        if (m4550d == -1) {
            if (i2 == i) {
                i2 = this.f5145k[i];
            } else if (i2 == this.f5137c) {
                i2 = m4550d;
            }
            if (i == -2) {
                m4550d = this.f5146l[-2];
            } else if (this.f5137c != -2) {
                m4550d = -2;
            }
            m4529y(this.f5145k[i], this.f5146l[i]);
            m4535s(i, axd.m4417E(this.f5135a[i]));
            this.f5135a[i] = obj;
            m4532v(i, axd.m4417E(obj));
            m4529y(i2, i);
            m4529y(i, m4550d);
            return;
        }
        String valueOf = String.valueOf(obj);
        String.valueOf(valueOf).length();
        throw new IllegalArgumentException("Key already present in map: ".concat(String.valueOf(valueOf)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public final void m4554C(int i, Object obj) {
        atm.m4618d(i != -1);
        int m4417E = axd.m4417E(obj);
        if (m4548f(obj, m4417E) == -1) {
            m4534t(i, axd.m4417E(this.f5136b[i]));
            this.f5136b[i] = obj;
            m4531w(i, m4417E);
            return;
        }
        String valueOf = String.valueOf(obj);
        String.valueOf(valueOf).length();
        throw new IllegalArgumentException("Value already present in map: ".concat(String.valueOf(valueOf)));
    }

    /* renamed from: p */
    public static auz m4538p() {
        return new auz();
    }

    /* renamed from: r */
    private final int m4536r(int i) {
        return i & (this.f5139e.length - 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        m4545i(16);
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* renamed from: s */
    private final void m4535s(int i, int i2) {
        atm.m4618d(i != -1);
        int m4536r = m4536r(i2);
        int[] iArr = this.f5139e;
        int i3 = iArr[m4536r];
        if (i3 == i) {
            int[] iArr2 = this.f5141g;
            iArr[m4536r] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.f5141g[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                String valueOf = String.valueOf(this.f5135a[i]);
                String.valueOf(valueOf).length();
                throw new AssertionError("Expected to find entry with key ".concat(String.valueOf(valueOf)));
            } else if (i3 != i) {
                i4 = this.f5141g[i3];
            } else {
                int[] iArr3 = this.f5141g;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
        }
    }

    /* renamed from: t */
    private final void m4534t(int i, int i2) {
        atm.m4618d(i != -1);
        int m4536r = m4536r(i2);
        int[] iArr = this.f5140f;
        int i3 = iArr[m4536r];
        if (i3 == i) {
            int[] iArr2 = this.f5142h;
            iArr[m4536r] = iArr2[i];
            iArr2[i] = -1;
            return;
        }
        int i4 = this.f5142h[i3];
        while (true) {
            int i5 = i3;
            i3 = i4;
            if (i3 == -1) {
                String valueOf = String.valueOf(this.f5136b[i]);
                String.valueOf(valueOf).length();
                throw new AssertionError("Expected to find entry with value ".concat(String.valueOf(valueOf)));
            } else if (i3 != i) {
                i4 = this.f5142h[i3];
            } else {
                int[] iArr3 = this.f5142h;
                iArr3[i5] = iArr3[i];
                iArr3[i] = -1;
                return;
            }
        }
    }

    /* renamed from: u */
    private final void m4533u(int i) {
        int length = this.f5141g.length;
        if (length < i) {
            int m4527a = ava.m4527a(length, i);
            this.f5135a = Arrays.copyOf(this.f5135a, m4527a);
            this.f5136b = Arrays.copyOf(this.f5136b, m4527a);
            this.f5141g = m4556A(this.f5141g, m4527a);
            this.f5142h = m4556A(this.f5142h, m4527a);
            this.f5145k = m4556A(this.f5145k, m4527a);
            this.f5146l = m4556A(this.f5146l, m4527a);
        }
        if (this.f5139e.length < i) {
            int m4416F = axd.m4416F(i);
            this.f5139e = m4528z(m4416F);
            this.f5140f = m4528z(m4416F);
            for (int i2 = 0; i2 < this.f5137c; i2++) {
                int m4536r = m4536r(axd.m4417E(this.f5135a[i2]));
                int[] iArr = this.f5141g;
                int[] iArr2 = this.f5139e;
                iArr[i2] = iArr2[m4536r];
                iArr2[m4536r] = i2;
                int m4536r2 = m4536r(axd.m4417E(this.f5136b[i2]));
                int[] iArr3 = this.f5142h;
                int[] iArr4 = this.f5140f;
                iArr3[i2] = iArr4[m4536r2];
                iArr4[m4536r2] = i2;
            }
        }
    }

    /* renamed from: v */
    private final void m4532v(int i, int i2) {
        atm.m4618d(i != -1);
        int m4536r = m4536r(i2);
        int[] iArr = this.f5141g;
        int[] iArr2 = this.f5139e;
        iArr[i] = iArr2[m4536r];
        iArr2[m4536r] = i;
    }

    /* renamed from: w */
    private final void m4531w(int i, int i2) {
        atm.m4618d(i != -1);
        int m4536r = m4536r(i2);
        int[] iArr = this.f5142h;
        int[] iArr2 = this.f5140f;
        iArr[i] = iArr2[m4536r];
        iArr2[m4536r] = i;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f5137c);
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* renamed from: x */
    private final void m4530x(int i, int i2, int i3) {
        int i4;
        int i5;
        atm.m4618d(i != -1);
        m4535s(i, i2);
        m4534t(i, i3);
        m4529y(this.f5145k[i], this.f5146l[i]);
        int i6 = this.f5137c - 1;
        if (i6 != i) {
            int i7 = this.f5145k[i6];
            int i8 = this.f5146l[i6];
            m4529y(i7, i);
            m4529y(i, i8);
            Object[] objArr = this.f5135a;
            Object obj = objArr[i6];
            Object[] objArr2 = this.f5136b;
            Object obj2 = objArr2[i6];
            objArr[i] = obj;
            objArr2[i] = obj2;
            int m4536r = m4536r(axd.m4417E(obj));
            int[] iArr = this.f5139e;
            int i9 = iArr[m4536r];
            if (i9 == i6) {
                iArr[m4536r] = i;
            } else {
                int i10 = this.f5141g[i9];
                while (true) {
                    i4 = i9;
                    i9 = i10;
                    if (i9 == i6) {
                        break;
                    }
                    i10 = this.f5141g[i9];
                }
                this.f5141g[i4] = i;
            }
            int[] iArr2 = this.f5141g;
            iArr2[i] = iArr2[i6];
            iArr2[i6] = -1;
            int m4536r2 = m4536r(axd.m4417E(obj2));
            int[] iArr3 = this.f5140f;
            int i11 = iArr3[m4536r2];
            if (i11 == i6) {
                iArr3[m4536r2] = i;
            } else {
                int i12 = this.f5142h[i11];
                while (true) {
                    i5 = i11;
                    i11 = i12;
                    if (i11 == i6) {
                        break;
                    }
                    i12 = this.f5142h[i11];
                }
                this.f5142h[i5] = i;
            }
            int[] iArr4 = this.f5142h;
            iArr4[i] = iArr4[i6];
            iArr4[i6] = -1;
        }
        Object[] objArr3 = this.f5135a;
        int i13 = this.f5137c - 1;
        objArr3[i13] = null;
        this.f5136b[i13] = null;
        this.f5137c = i13;
        this.f5138d++;
    }

    /* renamed from: z */
    private static int[] m4528z(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* renamed from: b */
    final int m4552b(Object obj, int i, int[] iArr, int[] iArr2, Object[] objArr) {
        int i2 = iArr[m4536r(i)];
        while (i2 != -1) {
            if (anx.m4882b(objArr[i2], obj)) {
                return i2;
            }
            i2 = iArr2[i2];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final int m4551c(Object obj) {
        return m4550d(obj, axd.m4417E(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        Arrays.fill(this.f5135a, 0, this.f5137c, (Object) null);
        Arrays.fill(this.f5136b, 0, this.f5137c, (Object) null);
        Arrays.fill(this.f5139e, -1);
        Arrays.fill(this.f5140f, -1);
        Arrays.fill(this.f5141g, 0, this.f5137c, -1);
        Arrays.fill(this.f5142h, 0, this.f5137c, -1);
        Arrays.fill(this.f5145k, 0, this.f5137c, -1);
        Arrays.fill(this.f5146l, 0, this.f5137c, -1);
        this.f5137c = 0;
        this.f5143i = -2;
        this.f5144j = -2;
        this.f5138d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return m4551c(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        return m4549e(obj) != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final int m4550d(Object obj, int i) {
        return m4552b(obj, i, this.f5139e, this.f5141g, this.f5135a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final int m4549e(Object obj) {
        return m4548f(obj, axd.m4417E(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f5149o;
        if (set == null) {
            aus ausVar = new aus(this);
            this.f5149o = ausVar;
            return ausVar;
        }
        return set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final int m4548f(Object obj, int i) {
        return m4552b(obj, i, this.f5140f, this.f5142h, this.f5136b);
    }

    /* renamed from: g */
    public final auj m4547g() {
        auj aujVar = this.f5150p;
        if (aujVar == null) {
            aut autVar = new aut(this);
            this.f5150p = autVar;
            return autVar;
        }
        return aujVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        int m4551c = m4551c(obj);
        if (m4551c == -1) {
            return null;
        }
        return this.f5136b[m4551c];
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: h */
    public final Set values() {
        Set set = this.f5148n;
        if (set == null) {
            auw auwVar = new auw(this);
            this.f5148n = auwVar;
            return auwVar;
        }
        return set;
    }

    /* renamed from: i */
    final void m4545i(int i) {
        axd.m4413I(i, "expectedSize");
        int m4416F = axd.m4416F(i);
        this.f5137c = 0;
        this.f5135a = new Object[i];
        this.f5136b = new Object[i];
        this.f5139e = m4528z(m4416F);
        this.f5140f = m4528z(m4416F);
        this.f5141g = m4528z(i);
        this.f5142h = m4528z(i);
        this.f5143i = -2;
        this.f5144j = -2;
        this.f5145k = m4528z(i);
        this.f5146l = m4528z(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public final void m4544j(int i, int i2) {
        m4530x(i, i2, axd.m4417E(this.f5136b[i]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public final void m4543k(int i, int i2) {
        m4530x(i, axd.m4417E(this.f5135a[i]), i2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.f5147m;
        if (set == null) {
            auv auvVar = new auv(this);
            this.f5147m = auvVar;
            return auvVar;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int m4417E = axd.m4417E(obj);
        int m4550d = m4550d(obj, m4417E);
        if (m4550d != -1) {
            Object obj3 = this.f5136b[m4550d];
            if (anx.m4882b(obj3, obj2)) {
                return obj2;
            }
            m4554C(m4550d, obj2);
            return obj3;
        }
        int m4417E2 = axd.m4417E(obj2);
        atm.m4616f(m4548f(obj2, m4417E2) == -1, "Value already present: %s", obj2);
        m4533u(this.f5137c + 1);
        Object[] objArr = this.f5135a;
        int i = this.f5137c;
        objArr[i] = obj;
        this.f5136b[i] = obj2;
        m4532v(i, m4417E);
        m4531w(this.f5137c, m4417E2);
        m4529y(this.f5144j, this.f5137c);
        m4529y(this.f5137c, -2);
        this.f5137c++;
        this.f5138d++;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public final Object m4537q(Object obj, Object obj2) {
        int m4417E = axd.m4417E(obj);
        int m4548f = m4548f(obj, m4417E);
        if (m4548f != -1) {
            Object obj3 = this.f5135a[m4548f];
            if (anx.m4882b(obj3, obj2)) {
                return obj2;
            }
            m4555B(m4548f, obj2);
            return obj3;
        }
        int i = this.f5144j;
        int m4417E2 = axd.m4417E(obj2);
        atm.m4616f(m4550d(obj2, m4417E2) == -1, "Key already present: %s", obj2);
        m4533u(this.f5137c + 1);
        Object[] objArr = this.f5135a;
        int i2 = this.f5137c;
        objArr[i2] = obj2;
        this.f5136b[i2] = obj;
        m4532v(i2, m4417E2);
        m4531w(this.f5137c, m4417E);
        int i3 = i == -2 ? this.f5143i : this.f5146l[i];
        m4529y(i, this.f5137c);
        m4529y(this.f5137c, i3);
        this.f5137c++;
        this.f5138d++;
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        int m4417E = axd.m4417E(obj);
        int m4550d = m4550d(obj, m4417E);
        if (m4550d == -1) {
            return null;
        }
        Object obj2 = this.f5136b[m4550d];
        m4544j(m4550d, m4417E);
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f5137c;
    }

    /* renamed from: y */
    private final void m4529y(int i, int i2) {
        if (i != -2) {
            this.f5146l[i] = i2;
        } else {
            this.f5143i = i2;
        }
        if (i2 == -2) {
            this.f5144j = i;
        } else {
            this.f5145k[i2] = i;
        }
    }
}

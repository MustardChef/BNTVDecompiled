package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ug */
/* loaded from: classes2.dex */
final class C3104ug {

    /* renamed from: a */
    private int f9064a;

    /* renamed from: b */
    private final SparseArray f9065b;

    /* renamed from: c */
    private final InterfaceC2600bp f9066c;

    public C3104ug() {
        C3103uf c3103uf = C3103uf.f9061a;
        throw null;
    }

    /* renamed from: b */
    public final Object m917b() {
        SparseArray sparseArray = this.f9065b;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    /* renamed from: c */
    public final void m916c(int i, Object obj) {
        if (this.f9064a == -1) {
            C2616ce.m2685h(this.f9065b.size() == 0);
            this.f9064a = 0;
        }
        if (this.f9065b.size() > 0) {
            SparseArray sparseArray = this.f9065b;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            C2616ce.m2687f(i >= keyAt);
            if (keyAt == i) {
                InterfaceC2600bp interfaceC2600bp = this.f9066c;
                SparseArray sparseArray2 = this.f9065b;
                interfaceC2600bp.mo919a(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f9065b.append(i, obj);
    }

    /* renamed from: d */
    public final void m915d() {
        for (int i = 0; i < this.f9065b.size(); i++) {
            this.f9066c.mo919a(this.f9065b.valueAt(i));
        }
        this.f9064a = -1;
        this.f9065b.clear();
    }

    /* renamed from: e */
    public final void m914e(int i) {
        for (int size = this.f9065b.size() - 1; size >= 0 && i < this.f9065b.keyAt(size); size--) {
            this.f9066c.mo919a(this.f9065b.valueAt(size));
            this.f9065b.removeAt(size);
        }
        this.f9064a = this.f9065b.size() > 0 ? Math.min(this.f9064a, this.f9065b.size() - 1) : -1;
    }

    /* renamed from: f */
    public final void m913f(int i) {
        int i2 = 0;
        while (i2 < this.f9065b.size() - 1) {
            int i3 = i2 + 1;
            if (i < this.f9065b.keyAt(i3)) {
                return;
            }
            this.f9066c.mo919a(this.f9065b.valueAt(i2));
            this.f9065b.removeAt(i2);
            int i4 = this.f9064a;
            if (i4 > 0) {
                this.f9064a = i4 - 1;
            }
            i2 = i3;
        }
    }

    /* renamed from: g */
    public final boolean m912g() {
        return this.f9065b.size() == 0;
    }

    public C3104ug(InterfaceC2600bp interfaceC2600bp) {
        this.f9065b = new SparseArray();
        this.f9066c = interfaceC2600bp;
        this.f9064a = -1;
    }

    /* renamed from: a */
    public final Object m918a(int i) {
        if (this.f9064a == -1) {
            this.f9064a = 0;
        }
        while (true) {
            int i2 = this.f9064a;
            if (i2 > 0 && i < this.f9065b.keyAt(i2)) {
                this.f9064a--;
            }
        }
        while (this.f9064a < this.f9065b.size() - 1 && i >= this.f9065b.keyAt(this.f9064a + 1)) {
            this.f9064a++;
        }
        return this.f9065b.valueAt(this.f9064a);
    }
}

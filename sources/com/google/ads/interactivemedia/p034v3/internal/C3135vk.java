package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vk */
/* loaded from: classes2.dex */
public final class C3135vk extends C2594bj {

    /* renamed from: z */
    public static final C3135vk f9192z = new C3136vl().m820v();

    /* renamed from: A */
    public final int f9193A;

    /* renamed from: B */
    public final boolean f9194B;

    /* renamed from: C */
    public final boolean f9195C;

    /* renamed from: D */
    public final boolean f9196D;

    /* renamed from: E */
    public final boolean f9197E;

    /* renamed from: F */
    public final boolean f9198F;

    /* renamed from: G */
    public final boolean f9199G;

    /* renamed from: H */
    public final boolean f9200H;

    /* renamed from: I */
    public final boolean f9201I;

    /* renamed from: J */
    public final boolean f9202J;

    /* renamed from: K */
    public final boolean f9203K;

    /* renamed from: L */
    private final SparseArray f9204L;

    /* renamed from: M */
    private final SparseBooleanArray f9205M;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C3135vk(C3136vl c3136vl) {
        super(c3136vl);
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        SparseArray sparseArray;
        SparseBooleanArray sparseBooleanArray;
        z = c3136vl.f9206a;
        this.f9194B = z;
        this.f9195C = false;
        z2 = c3136vl.f9207b;
        this.f9196D = z2;
        z3 = c3136vl.f9208c;
        this.f9197E = z3;
        this.f9198F = false;
        this.f9199G = false;
        this.f9200H = false;
        this.f9193A = 0;
        z4 = c3136vl.f9209d;
        this.f9201I = z4;
        this.f9202J = false;
        z5 = c3136vl.f9210e;
        this.f9203K = z5;
        sparseArray = c3136vl.f9211f;
        this.f9204L = sparseArray;
        sparseBooleanArray = c3136vl.f9212g;
        this.f9205M = sparseBooleanArray;
    }

    /* renamed from: a */
    public static C3135vk m831a(Context context) {
        return new C3136vl(context).m820v();
    }

    /* renamed from: b */
    public final C3137vm m830b(int i, C2588bd c2588bd) {
        Map map = (Map) this.f9204L.get(i);
        if (map != null) {
            return (C3137vm) map.get(c2588bd);
        }
        return null;
    }

    /* renamed from: c */
    public final boolean m829c(int i) {
        return this.f9205M.get(i);
    }

    /* renamed from: d */
    public final boolean m828d(int i, C2588bd c2588bd) {
        Map map = (Map) this.f9204L.get(i);
        return map != null && map.containsKey(c2588bd);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C2594bj
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C3135vk c3135vk = (C3135vk) obj;
            if (super.equals(c3135vk) && this.f9194B == c3135vk.f9194B && this.f9196D == c3135vk.f9196D && this.f9197E == c3135vk.f9197E && this.f9201I == c3135vk.f9201I && this.f9203K == c3135vk.f9203K) {
                SparseBooleanArray sparseBooleanArray = this.f9205M;
                SparseBooleanArray sparseBooleanArray2 = c3135vk.f9205M;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                                break;
                            }
                            i++;
                        } else {
                            SparseArray sparseArray = this.f9204L;
                            SparseArray sparseArray2 = c3135vk.f9204L;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                for (int i2 = 0; i2 < size2; i2++) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i2);
                                        Map map2 = (Map) sparseArray2.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                C2588bd c2588bd = (C2588bd) entry.getKey();
                                                if (map2.containsKey(c2588bd)) {
                                                    if (!C2628cq.m2563T(entry.getValue(), map2.get(c2588bd))) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C2594bj
    public final int hashCode() {
        return ((((((((((super.hashCode() + 31) * 31) + (this.f9194B ? 1 : 0)) * 961) + (this.f9196D ? 1 : 0)) * 31) + (this.f9197E ? 1 : 0)) * 28629151) + (this.f9201I ? 1 : 0)) * 961) + (this.f9203K ? 1 : 0);
    }
}

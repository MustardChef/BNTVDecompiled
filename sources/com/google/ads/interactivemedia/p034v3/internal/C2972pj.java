package com.google.ads.interactivemedia.p034v3.internal;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pj */
/* loaded from: classes2.dex */
public final class C2972pj {

    /* renamed from: a */
    private final SparseArray f8458a = new SparseArray();

    /* renamed from: a */
    public final C2626co m1382a(int i) {
        C2626co c2626co = (C2626co) this.f8458a.get(i);
        if (c2626co == null) {
            C2626co c2626co2 = new C2626co(TimestampAdjuster.MODE_SHARED);
            this.f8458a.put(i, c2626co2);
            return c2626co2;
        }
        return c2626co;
    }

    /* renamed from: b */
    public final void m1381b() {
        this.f8458a.clear();
    }
}

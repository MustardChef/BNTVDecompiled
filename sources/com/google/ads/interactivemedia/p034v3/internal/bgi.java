package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2476au;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgi */
/* loaded from: classes2.dex */
public final class bgi {

    /* renamed from: a */
    private bhn f5685a = bhn.f5735a;

    /* renamed from: k */
    private final int f5695k = bgu.f5700a;

    /* renamed from: b */
    private final bga f5686b = bfz.IDENTITY;

    /* renamed from: c */
    private final Map f5687c = new HashMap();

    /* renamed from: d */
    private final List f5688d = new ArrayList();

    /* renamed from: e */
    private final List f5689e = new ArrayList();

    /* renamed from: f */
    private final int f5690f = 2;

    /* renamed from: g */
    private final int f5691g = 2;

    /* renamed from: h */
    private final boolean f5692h = true;

    /* renamed from: i */
    private final bgw f5693i = bgv.DOUBLE;

    /* renamed from: j */
    private final bgw f5694j = bgv.LAZILY_PARSED_NUMBER;

    /* renamed from: a */
    public final bgh m3718a() {
        ArrayList arrayList = new ArrayList(this.f5688d.size() + this.f5689e.size() + 3);
        arrayList.addAll(this.f5688d);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f5689e);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        boolean z = bks.f5952a;
        return new bgh(this.f5685a, this.f5686b, this.f5687c, true, this.f5695k, arrayList, this.f5693i, this.f5694j);
    }

    /* renamed from: b */
    public final void m3717b(Type type, Object obj) {
        boolean z = obj instanceof bgs;
        boolean z2 = true;
        if (!z && !(obj instanceof bgl) && !(obj instanceof bgj) && !(obj instanceof bgy)) {
            z2 = false;
        }
        axd.m4404h(z2);
        if (obj instanceof bgj) {
            this.f5687c.put(type, (bgj) obj);
        }
        if (z || (obj instanceof bgl)) {
            this.f5688d.add(bja.m3619a(bkt.m3601b(type), obj));
        }
        if (obj instanceof bgy) {
            this.f5688d.add(bkh.m3614a(bkt.m3601b(type), (bgy) obj));
        }
    }

    /* renamed from: c */
    public final void m3716c(bgz bgzVar) {
        this.f5688d.add(bgzVar);
    }

    /* renamed from: d */
    public final void m3715d(C2476au c2476au) {
        this.f5685a = this.f5685a.m3676e(c2476au);
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vl */
/* loaded from: classes2.dex */
public final class C3136vl extends C2593bi {

    /* renamed from: a */
    private boolean f9206a;

    /* renamed from: b */
    private boolean f9207b;

    /* renamed from: c */
    private boolean f9208c;

    /* renamed from: d */
    private boolean f9209d;

    /* renamed from: e */
    private boolean f9210e;

    /* renamed from: f */
    private final SparseArray f9211f;

    /* renamed from: g */
    private final SparseBooleanArray f9212g;

    @Deprecated
    public C3136vl() {
        this.f9211f = new SparseArray();
        this.f9212g = new SparseBooleanArray();
        m826B();
    }

    /* renamed from: B */
    private final void m826B() {
        this.f9206a = true;
        this.f9207b = true;
        this.f9208c = true;
        this.f9209d = true;
        this.f9210e = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C2593bi
    /* renamed from: q */
    public final /* synthetic */ void mo825q(Context context) {
        super.mo825q(context);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C2593bi
    /* renamed from: r */
    public final /* bridge */ /* synthetic */ C2593bi mo824r(int i, int i2) {
        super.mo824r(i, i2);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.C2593bi
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ void mo823s(Context context) {
        super.mo823s(context);
    }

    /* renamed from: v */
    public final C3135vk m820v() {
        return new C3135vk(this);
    }

    public C3136vl(Context context) {
        mo825q(context);
        mo823s(context);
        this.f9211f = new SparseArray();
        this.f9212g = new SparseBooleanArray();
        m826B();
    }
}

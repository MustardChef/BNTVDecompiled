package com.google.ads.interactivemedia.p034v3.internal;

import android.view.View;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agf */
/* loaded from: classes2.dex */
public abstract class agf {
    /* renamed from: b */
    public abstract void mo5349b(View view, agl aglVar, String str);

    /* renamed from: c */
    public abstract void mo5348c();

    /* renamed from: d */
    public abstract void mo5347d(View view);

    /* renamed from: e */
    public abstract void mo5346e();

    /* renamed from: f */
    public abstract void mo5345f();

    /* renamed from: a */
    public static agf m5360a(agg aggVar, agh aghVar) {
        if (agd.m5368c()) {
            return new agj(aggVar, aghVar);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}

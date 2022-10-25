package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agu */
/* loaded from: classes2.dex */
public final class agu {

    /* renamed from: a */
    private static final agu f4025a = new agu();

    /* renamed from: b */
    private Context f4026b;

    private agu() {
    }

    /* renamed from: b */
    public static agu m5311b() {
        return f4025a;
    }

    /* renamed from: a */
    public final Context m5312a() {
        return this.f4026b;
    }

    /* renamed from: c */
    public final void m5310c(Context context) {
        this.f4026b = context != null ? context.getApplicationContext() : null;
    }
}

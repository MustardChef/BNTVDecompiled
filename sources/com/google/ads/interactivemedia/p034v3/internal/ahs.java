package com.google.ads.interactivemedia.p034v3.internal;

import android.os.AsyncTask;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahs */
/* loaded from: classes2.dex */
public abstract class ahs extends AsyncTask {

    /* renamed from: a */
    private aht f4101a;

    /* renamed from: d */
    protected final ahl f4102d;

    public ahs(ahl ahlVar) {
        this.f4102d = ahlVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        aht ahtVar = this.f4101a;
        if (ahtVar != null) {
            ahtVar.m5233b();
        }
    }

    /* renamed from: b */
    public final void m5235b(aht ahtVar) {
        this.f4101a = ahtVar;
    }
}

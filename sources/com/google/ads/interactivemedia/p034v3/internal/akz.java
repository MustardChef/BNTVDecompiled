package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akz */
/* loaded from: classes2.dex */
final class akz {

    /* renamed from: b */
    private aky f4350b;

    /* renamed from: a */
    private final Handler f4349a = new Handler();

    /* renamed from: c */
    private boolean f4351c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m5060a(aky akyVar, Handler handler, long j) {
        akyVar.mo5054a();
        m5056e(akyVar, handler, 200L);
    }

    /* renamed from: e */
    private static void m5056e(final aky akyVar, final Handler handler, long j) {
        handler.postDelayed(new Runnable(handler, 200L) { // from class: com.google.ads.interactivemedia.v3.internal.akx

            /* renamed from: b */
            public final /* synthetic */ Handler f4347b;

            /* renamed from: c */
            public final /* synthetic */ long f4348c = 200;

            @Override // java.lang.Runnable
            public final void run() {
                akz.m5060a(aky.this, this.f4347b, 200L);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final void m5059b(aky akyVar) {
        this.f4350b = akyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m5058c() {
        if (this.f4351c) {
            return;
        }
        this.f4351c = true;
        this.f4350b.mo5054a();
        m5056e(this.f4350b, this.f4349a, 200L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final void m5057d() {
        if (this.f4351c) {
            this.f4351c = false;
            this.f4349a.removeCallbacksAndMessages(null);
        }
    }
}

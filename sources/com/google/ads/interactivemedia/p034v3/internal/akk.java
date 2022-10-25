package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akk */
/* loaded from: classes2.dex */
public final class akk {

    /* renamed from: a */
    private final aki f4297a;

    /* renamed from: b */
    private final akc f4298b;

    /* renamed from: c */
    private final ayr f4299c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akk(akc akcVar, ExecutorService executorService, aki akiVar) {
        this.f4299c = ayu.m4319a(executorService);
        this.f4297a = akiVar;
        this.f4298b = akcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ AbstractC2500br m5107b(AbstractC2499bq abstractC2499bq) throws Exception {
        return this.f4297a.mo5109a(abstractC2499bq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public final void m5106c(ajp ajpVar, String str, final AbstractC2499bq abstractC2499bq) {
        ajp ajpVar2 = ajp.activate;
        if (ajpVar.ordinal() == 35) {
            ayu.m4316d(this.f4299c.mo4320a(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.akf
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return akk.this.m5107b(abstractC2499bq);
                }
            }), new akg(this, str), this.f4299c);
            return;
        }
        String valueOf = String.valueOf(ajpVar);
        String.valueOf(valueOf).length();
        C2525p.m5989c("Unexpected network request of type".concat(String.valueOf(valueOf)));
    }
}

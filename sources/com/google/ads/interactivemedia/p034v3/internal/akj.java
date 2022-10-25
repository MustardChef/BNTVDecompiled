package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br;
import com.google.ads.interactivemedia.p034v3.impl.data.EnumC2498bp;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akj */
/* loaded from: classes2.dex */
final class akj implements aki {

    /* renamed from: a */
    private final arb f4295a;

    /* renamed from: b */
    private final AbstractC2490bh f4296b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akj(Context context, AbstractC2490bh abstractC2490bh) {
        this.f4295a = new arg(context);
        this.f4296b = abstractC2490bh;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aki
    /* renamed from: a */
    public final AbstractC2500br mo5109a(AbstractC2499bq abstractC2499bq) {
        Task doRead;
        try {
            final int i = abstractC2499bq.requestType() == EnumC2498bp.GET ? 0 : 1;
            arb arbVar = this.f4295a;
            final String url = abstractC2499bq.url();
            final String content = abstractC2499bq.content();
            if (this.f4296b.isLimitedAdTracking()) {
                doRead = Tasks.forException(new arc(8));
            } else {
                final arg argVar = (arg) arbVar;
                doRead = ((arg) arbVar).doRead(TaskApiCall.builder().setFeatures(atd.f5035b).setAutoResolveMissingFeatures(false).run(new RemoteCall() { // from class: com.google.ads.interactivemedia.v3.internal.ard
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        String str = url;
                        int i2 = i;
                        String str2 = content;
                        ((aqx) ((arh) obj).getService()).mo4745e(new aqy(str, i2, str2), new arf((TaskCompletionSource) obj2));
                    }
                }).build());
            }
            return AbstractC2500br.forResponse(abstractC2499bq.mo6002id(), (String) Tasks.await(doRead, abstractC2499bq.connectionTimeoutMs() + abstractC2499bq.readTimeoutMs(), TimeUnit.MILLISECONDS));
        } catch (InterruptedException | TimeoutException unused) {
            return AbstractC2500br.forError(abstractC2499bq.mo6002id(), 101);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof arc) {
                return AbstractC2500br.forError(abstractC2499bq.mo6002id(), ((arc) cause).m4738a());
            }
            if (cause instanceof ApiException) {
                return AbstractC2500br.forError(abstractC2499bq.mo6002id(), 102);
            }
            return AbstractC2500br.forError(abstractC2499bq.mo6002id(), 100);
        }
    }
}

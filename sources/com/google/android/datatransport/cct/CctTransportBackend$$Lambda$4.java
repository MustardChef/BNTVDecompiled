package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

/* loaded from: classes2.dex */
final /* synthetic */ class CctTransportBackend$$Lambda$4 implements RetryStrategy {
    private static final CctTransportBackend$$Lambda$4 instance = new CctTransportBackend$$Lambda$4();

    private CctTransportBackend$$Lambda$4() {
    }

    @Override // com.google.android.datatransport.runtime.retries.RetryStrategy
    public Object shouldRetry(Object obj, Object obj2) {
        return CctTransportBackend.lambda$send$0((CctTransportBackend.HttpRequest) obj, (CctTransportBackend.HttpResponse) obj2);
    }
}

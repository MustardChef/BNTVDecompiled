package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdError;
import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aib */
/* loaded from: classes2.dex */
public final class aib implements AdErrorEvent {

    /* renamed from: a */
    private final AdError f4121a;

    /* renamed from: b */
    private final Object f4122b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aib(AdError adError) {
        this.f4121a = adError;
        this.f4122b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aib(AdError adError, Object obj) {
        this.f4121a = adError;
        this.f4122b = obj;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdErrorEvent
    public final AdError getError() {
        return this.f4121a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdErrorEvent
    public final Object getUserRequestContext() {
        return this.f4122b;
    }
}

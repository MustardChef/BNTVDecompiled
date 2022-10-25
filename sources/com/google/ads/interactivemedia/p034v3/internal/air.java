package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdsManager;
import com.google.ads.interactivemedia.p034v3.api.AdsManagerLoadedEvent;
import com.google.ads.interactivemedia.p034v3.api.StreamManager;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.air */
/* loaded from: classes2.dex */
public final class air implements AdsManagerLoadedEvent {

    /* renamed from: a */
    private final AdsManager f4176a;

    /* renamed from: b */
    private final StreamManager f4177b;

    /* renamed from: c */
    private final Object f4178c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public air(AdsManager adsManager, Object obj) {
        this.f4176a = adsManager;
        this.f4177b = null;
        this.f4178c = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public air(StreamManager streamManager, Object obj) {
        this.f4176a = null;
        this.f4177b = streamManager;
        this.f4178c = obj;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManagerLoadedEvent
    public final AdsManager getAdsManager() {
        return this.f4176a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManagerLoadedEvent
    public final StreamManager getStreamManager() {
        return this.f4177b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManagerLoadedEvent
    public final Object getUserRequestContext() {
        return this.f4178c;
    }
}

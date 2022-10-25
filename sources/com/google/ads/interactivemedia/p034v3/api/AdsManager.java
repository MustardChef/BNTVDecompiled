package com.google.ads.interactivemedia.p034v3.api;

import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.AdsManager */
/* loaded from: classes2.dex */
public interface AdsManager extends BaseManager {
    void clicked();

    void discardAdBreak();

    List<Float> getAdCuePoints();

    void pause();

    @Deprecated
    void requestNextAdBreak();

    void resume();

    void skip();

    void start();
}

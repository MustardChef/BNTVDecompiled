package com.google.ads.interactivemedia.p034v3.api;

import com.google.ads.interactivemedia.p034v3.api.player.ContentProgressProvider;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.AdsRequest */
/* loaded from: classes2.dex */
public interface AdsRequest {
    String getAdTagUrl();

    String getAdsResponse();

    ContentProgressProvider getContentProgressProvider();

    String getExtraParameter(String str);

    Map<String, String> getExtraParameters();

    Object getUserRequestContext();

    void setAdTagUrl(String str);

    void setAdWillAutoPlay(boolean z);

    void setAdWillPlayMuted(boolean z);

    void setAdsResponse(String str);

    void setContentDuration(float f);

    void setContentKeywords(List<String> list);

    void setContentProgressProvider(ContentProgressProvider contentProgressProvider);

    void setContentTitle(String str);

    void setContentUrl(String str);

    void setContinuousPlayback(boolean z);

    void setExtraParameter(String str, String str2);

    void setLiveStreamPrefetchSeconds(float f);

    void setUserRequestContext(Object obj);

    void setVastLoadTimeout(float f);
}

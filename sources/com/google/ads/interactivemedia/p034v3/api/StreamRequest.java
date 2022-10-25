package com.google.ads.interactivemedia.p034v3.api;

import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.StreamRequest */
/* loaded from: classes2.dex */
public interface StreamRequest {

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.api.StreamRequest$StreamFormat */
    /* loaded from: classes2.dex */
    public enum StreamFormat {
        DASH,
        HLS
    }

    Map<String, String> getAdTagParameters();

    String getApiKey();

    String getAssetKey();

    String getAuthToken();

    String getContentSourceId();

    String getContentUrl();

    String getCustomAssetKey();

    StreamFormat getFormat();

    String getLiveStreamEventId();

    String getManifestSuffix();

    String getNetworkCode();

    String getOAuthToken();

    String getProjectNumber();

    String getRegion();

    String getStreamActivityMonitorId();

    Boolean getUseQAStreamBaseUrl();

    Object getUserRequestContext();

    String getVideoId();

    void setAdTagParameters(Map<String, String> map);

    void setAuthToken(String str);

    void setContentUrl(String str);

    void setFormat(StreamFormat streamFormat);

    void setManifestSuffix(String str);

    void setStreamActivityMonitorId(String str);

    void setUseQAStreamBaseUrl(Boolean bool);

    void setUserRequestContext(Object obj);
}

package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.p034v3.internal.aio;
import com.google.ads.interactivemedia.p034v3.internal.ais;
import com.google.ads.interactivemedia.p034v3.internal.ait;
import com.google.ads.interactivemedia.p034v3.internal.aiu;
import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avj;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.z */
/* loaded from: classes2.dex */
final class C2535z implements InterfaceC2488bf {
    private avj<String, String> adTagParameters;
    private String adTagUrl;
    private String adsResponse;
    private String apiKey;
    private String assetKey;
    private String authToken;
    private avj<String, String> companionSlots;
    private AbstractC2481az consentSettings;
    private Float contentDuration;
    private avg<String> contentKeywords;
    private String contentSourceId;
    private String contentTitle;
    private String contentUrl;
    private String customAssetKey;
    private String env;
    private avg<AbstractC2484bb> espSignals;
    private avj<String, String> extraParameters;
    private String format;
    private AbstractC2490bh identifierInfo;
    private Boolean isTv;
    private Integer linearAdSlotHeight;
    private Integer linearAdSlotWidth;
    private String liveStreamEventId;
    private Float liveStreamPrefetchSeconds;
    private aio marketAppInfo;
    private String msParameter;
    private String network;
    private String networkCode;
    private String oAuthToken;
    private Boolean omidAdSessionsOnStartedOnly;
    private String projectNumber;
    private String region;
    private ImaSdkSettings settings;
    private String streamActivityMonitorId;
    private Boolean supportsExternalNavigation;
    private Boolean supportsIconClickFallback;
    private Boolean supportsNativeNetworking;
    private Boolean supportsResizing;
    private Boolean useQAStreamBaseUrl;
    private Boolean usesCustomVideoPlayback;
    private Float vastLoadTimeout;
    private ait videoContinuousPlay;
    private String videoId;
    private ais videoPlayActivation;
    private aiu videoPlayMuted;

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf adTagParameters(Map<String, String> map) {
        this.adTagParameters = map == null ? null : avj.m4505c(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf adTagUrl(String str) {
        this.adTagUrl = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf adsResponse(String str) {
        this.adsResponse = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf apiKey(String str) {
        this.apiKey = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf assetKey(String str) {
        this.assetKey = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf authToken(String str) {
        this.authToken = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public AbstractC2489bg build() {
        return new C2457ab(this.adTagUrl, this.adTagParameters, this.adsResponse, this.apiKey, this.assetKey, this.authToken, this.companionSlots, this.contentDuration, this.contentKeywords, this.contentTitle, this.contentUrl, this.contentSourceId, this.consentSettings, this.customAssetKey, this.env, this.espSignals, this.extraParameters, this.format, this.identifierInfo, this.isTv, this.linearAdSlotWidth, this.linearAdSlotHeight, this.liveStreamEventId, this.liveStreamPrefetchSeconds, this.marketAppInfo, this.msParameter, this.network, this.networkCode, this.oAuthToken, this.omidAdSessionsOnStartedOnly, this.projectNumber, this.region, this.settings, this.supportsExternalNavigation, this.supportsIconClickFallback, this.supportsNativeNetworking, this.streamActivityMonitorId, this.supportsResizing, this.useQAStreamBaseUrl, this.usesCustomVideoPlayback, this.vastLoadTimeout, this.videoId, this.videoPlayActivation, this.videoContinuousPlay, this.videoPlayMuted, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf companionSlots(Map<String, String> map) {
        this.companionSlots = map == null ? null : avj.m4505c(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf consentSettings(AbstractC2481az abstractC2481az) {
        this.consentSettings = abstractC2481az;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf contentDuration(Float f) {
        this.contentDuration = f;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf contentKeywords(List<String> list) {
        this.contentKeywords = list == null ? null : avg.m4517l(list);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf contentSourceId(String str) {
        this.contentSourceId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf contentTitle(String str) {
        this.contentTitle = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf contentUrl(String str) {
        this.contentUrl = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf customAssetKey(String str) {
        this.customAssetKey = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf env(String str) {
        this.env = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf espSignals(List<AbstractC2484bb> list) {
        this.espSignals = list == null ? null : avg.m4517l(list);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf extraParameters(Map<String, String> map) {
        this.extraParameters = map == null ? null : avj.m4505c(map);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf format(String str) {
        this.format = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf identifierInfo(AbstractC2490bh abstractC2490bh) {
        this.identifierInfo = abstractC2490bh;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf isTv(Boolean bool) {
        this.isTv = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf linearAdSlotHeight(Integer num) {
        this.linearAdSlotHeight = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf linearAdSlotWidth(Integer num) {
        this.linearAdSlotWidth = num;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf liveStreamEventId(String str) {
        this.liveStreamEventId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf liveStreamPrefetchSeconds(Float f) {
        this.liveStreamPrefetchSeconds = f;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf marketAppInfo(aio aioVar) {
        this.marketAppInfo = aioVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf msParameter(String str) {
        this.msParameter = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf network(String str) {
        this.network = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf networkCode(String str) {
        this.networkCode = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf oAuthToken(String str) {
        this.oAuthToken = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf omidAdSessionsOnStartedOnly(Boolean bool) {
        this.omidAdSessionsOnStartedOnly = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf projectNumber(String str) {
        this.projectNumber = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf region(String str) {
        this.region = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf settings(ImaSdkSettings imaSdkSettings) {
        this.settings = imaSdkSettings;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf streamActivityMonitorId(String str) {
        this.streamActivityMonitorId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf supportsExternalNavigation(Boolean bool) {
        this.supportsExternalNavigation = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf supportsIconClickFallback(Boolean bool) {
        this.supportsIconClickFallback = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf supportsNativeNetworking(Boolean bool) {
        this.supportsNativeNetworking = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf supportsResizing(Boolean bool) {
        this.supportsResizing = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf useQAStreamBaseUrl(Boolean bool) {
        this.useQAStreamBaseUrl = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf usesCustomVideoPlayback(Boolean bool) {
        this.usesCustomVideoPlayback = bool;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf vastLoadTimeout(Float f) {
        this.vastLoadTimeout = f;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf videoContinuousPlay(ait aitVar) {
        this.videoContinuousPlay = aitVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf videoId(String str) {
        this.videoId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf videoPlayActivation(ais aisVar) {
        this.videoPlayActivation = aisVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2488bf
    public InterfaceC2488bf videoPlayMuted(aiu aiuVar) {
        this.videoPlayMuted = aiuVar;
        return this;
    }
}

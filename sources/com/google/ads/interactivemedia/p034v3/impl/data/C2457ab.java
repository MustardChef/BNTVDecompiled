package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.p034v3.internal.aio;
import com.google.ads.interactivemedia.p034v3.internal.ais;
import com.google.ads.interactivemedia.p034v3.internal.ait;
import com.google.ads.interactivemedia.p034v3.internal.aiu;
import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avj;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ab */
/* loaded from: classes2.dex */
final class C2457ab extends AbstractC2489bg {
    private final avj<String, String> adTagParameters;
    private final String adTagUrl;
    private final String adsResponse;
    private final String apiKey;
    private final String assetKey;
    private final String authToken;
    private final avj<String, String> companionSlots;
    private final AbstractC2481az consentSettings;
    private final Float contentDuration;
    private final avg<String> contentKeywords;
    private final String contentSourceId;
    private final String contentTitle;
    private final String contentUrl;
    private final String customAssetKey;
    private final String env;
    private final avg<AbstractC2484bb> espSignals;
    private final avj<String, String> extraParameters;
    private final String format;
    private final AbstractC2490bh identifierInfo;
    private final Boolean isTv;
    private final Integer linearAdSlotHeight;
    private final Integer linearAdSlotWidth;
    private final String liveStreamEventId;
    private final Float liveStreamPrefetchSeconds;
    private final aio marketAppInfo;
    private final String msParameter;
    private final String network;
    private final String networkCode;
    private final String oAuthToken;
    private final Boolean omidAdSessionsOnStartedOnly;
    private final String projectNumber;
    private final String region;
    private final ImaSdkSettings settings;
    private final String streamActivityMonitorId;
    private final Boolean supportsExternalNavigation;
    private final Boolean supportsIconClickFallback;
    private final Boolean supportsNativeNetworking;
    private final Boolean supportsResizing;
    private final Boolean useQAStreamBaseUrl;
    private final Boolean usesCustomVideoPlayback;
    private final Float vastLoadTimeout;
    private final ait videoContinuousPlay;
    private final String videoId;
    private final ais videoPlayActivation;
    private final aiu videoPlayMuted;

    private C2457ab(String str, avj<String, String> avjVar, String str2, String str3, String str4, String str5, avj<String, String> avjVar2, Float f, avg<String> avgVar, String str6, String str7, String str8, AbstractC2481az abstractC2481az, String str9, String str10, avg<AbstractC2484bb> avgVar2, avj<String, String> avjVar3, String str11, AbstractC2490bh abstractC2490bh, Boolean bool, Integer num, Integer num2, String str12, Float f2, aio aioVar, String str13, String str14, String str15, String str16, Boolean bool2, String str17, String str18, ImaSdkSettings imaSdkSettings, Boolean bool3, Boolean bool4, Boolean bool5, String str19, Boolean bool6, Boolean bool7, Boolean bool8, Float f3, String str20, ais aisVar, ait aitVar, aiu aiuVar) {
        this.adTagUrl = str;
        this.adTagParameters = avjVar;
        this.adsResponse = str2;
        this.apiKey = str3;
        this.assetKey = str4;
        this.authToken = str5;
        this.companionSlots = avjVar2;
        this.contentDuration = f;
        this.contentKeywords = avgVar;
        this.contentTitle = str6;
        this.contentUrl = str7;
        this.contentSourceId = str8;
        this.consentSettings = abstractC2481az;
        this.customAssetKey = str9;
        this.env = str10;
        this.espSignals = avgVar2;
        this.extraParameters = avjVar3;
        this.format = str11;
        this.identifierInfo = abstractC2490bh;
        this.isTv = bool;
        this.linearAdSlotWidth = num;
        this.linearAdSlotHeight = num2;
        this.liveStreamEventId = str12;
        this.liveStreamPrefetchSeconds = f2;
        this.marketAppInfo = aioVar;
        this.msParameter = str13;
        this.network = str14;
        this.networkCode = str15;
        this.oAuthToken = str16;
        this.omidAdSessionsOnStartedOnly = bool2;
        this.projectNumber = str17;
        this.region = str18;
        this.settings = imaSdkSettings;
        this.supportsExternalNavigation = bool3;
        this.supportsIconClickFallback = bool4;
        this.supportsNativeNetworking = bool5;
        this.streamActivityMonitorId = str19;
        this.supportsResizing = bool6;
        this.useQAStreamBaseUrl = bool7;
        this.usesCustomVideoPlayback = bool8;
        this.vastLoadTimeout = f3;
        this.videoId = str20;
        this.videoPlayActivation = aisVar;
        this.videoContinuousPlay = aitVar;
        this.videoPlayMuted = aiuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2457ab(String str, avj avjVar, String str2, String str3, String str4, String str5, avj avjVar2, Float f, avg avgVar, String str6, String str7, String str8, AbstractC2481az abstractC2481az, String str9, String str10, avg avgVar2, avj avjVar3, String str11, AbstractC2490bh abstractC2490bh, Boolean bool, Integer num, Integer num2, String str12, Float f2, aio aioVar, String str13, String str14, String str15, String str16, Boolean bool2, String str17, String str18, ImaSdkSettings imaSdkSettings, Boolean bool3, Boolean bool4, Boolean bool5, String str19, Boolean bool6, Boolean bool7, Boolean bool8, Float f3, String str20, ais aisVar, ait aitVar, aiu aiuVar, C2456aa c2456aa) {
        this(str, avjVar, str2, str3, str4, str5, avjVar2, f, avgVar, str6, str7, str8, abstractC2481az, str9, str10, avgVar2, avjVar3, str11, abstractC2490bh, bool, num, num2, str12, f2, aioVar, str13, str14, str15, str16, bool2, str17, str18, imaSdkSettings, bool3, bool4, bool5, str19, bool6, bool7, bool8, f3, str20, aisVar, aitVar, aiuVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public avj<String, String> adTagParameters() {
        return this.adTagParameters;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String adTagUrl() {
        return this.adTagUrl;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String adsResponse() {
        return this.adsResponse;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String apiKey() {
        return this.apiKey;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String assetKey() {
        return this.assetKey;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String authToken() {
        return this.authToken;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public avj<String, String> companionSlots() {
        return this.companionSlots;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public AbstractC2481az consentSettings() {
        return this.consentSettings;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Float contentDuration() {
        return this.contentDuration;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public avg<String> contentKeywords() {
        return this.contentKeywords;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String contentSourceId() {
        return this.contentSourceId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String contentTitle() {
        return this.contentTitle;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String contentUrl() {
        return this.contentUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String customAssetKey() {
        return this.customAssetKey;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String env() {
        return this.env;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2489bg) {
            AbstractC2489bg abstractC2489bg = (AbstractC2489bg) obj;
            String str = this.adTagUrl;
            if (str != null ? str.equals(abstractC2489bg.adTagUrl()) : abstractC2489bg.adTagUrl() == null) {
                avj<String, String> avjVar = this.adTagParameters;
                if (avjVar != null ? avjVar.equals(abstractC2489bg.adTagParameters()) : abstractC2489bg.adTagParameters() == null) {
                    String str2 = this.adsResponse;
                    if (str2 != null ? str2.equals(abstractC2489bg.adsResponse()) : abstractC2489bg.adsResponse() == null) {
                        String str3 = this.apiKey;
                        if (str3 != null ? str3.equals(abstractC2489bg.apiKey()) : abstractC2489bg.apiKey() == null) {
                            String str4 = this.assetKey;
                            if (str4 != null ? str4.equals(abstractC2489bg.assetKey()) : abstractC2489bg.assetKey() == null) {
                                String str5 = this.authToken;
                                if (str5 != null ? str5.equals(abstractC2489bg.authToken()) : abstractC2489bg.authToken() == null) {
                                    avj<String, String> avjVar2 = this.companionSlots;
                                    if (avjVar2 != null ? avjVar2.equals(abstractC2489bg.companionSlots()) : abstractC2489bg.companionSlots() == null) {
                                        Float f = this.contentDuration;
                                        if (f != null ? f.equals(abstractC2489bg.contentDuration()) : abstractC2489bg.contentDuration() == null) {
                                            avg<String> avgVar = this.contentKeywords;
                                            if (avgVar != null ? avgVar.equals(abstractC2489bg.contentKeywords()) : abstractC2489bg.contentKeywords() == null) {
                                                String str6 = this.contentTitle;
                                                if (str6 != null ? str6.equals(abstractC2489bg.contentTitle()) : abstractC2489bg.contentTitle() == null) {
                                                    String str7 = this.contentUrl;
                                                    if (str7 != null ? str7.equals(abstractC2489bg.contentUrl()) : abstractC2489bg.contentUrl() == null) {
                                                        String str8 = this.contentSourceId;
                                                        if (str8 != null ? str8.equals(abstractC2489bg.contentSourceId()) : abstractC2489bg.contentSourceId() == null) {
                                                            AbstractC2481az abstractC2481az = this.consentSettings;
                                                            if (abstractC2481az != null ? abstractC2481az.equals(abstractC2489bg.consentSettings()) : abstractC2489bg.consentSettings() == null) {
                                                                String str9 = this.customAssetKey;
                                                                if (str9 != null ? str9.equals(abstractC2489bg.customAssetKey()) : abstractC2489bg.customAssetKey() == null) {
                                                                    String str10 = this.env;
                                                                    if (str10 != null ? str10.equals(abstractC2489bg.env()) : abstractC2489bg.env() == null) {
                                                                        avg<AbstractC2484bb> avgVar2 = this.espSignals;
                                                                        if (avgVar2 != null ? avgVar2.equals(abstractC2489bg.espSignals()) : abstractC2489bg.espSignals() == null) {
                                                                            avj<String, String> avjVar3 = this.extraParameters;
                                                                            if (avjVar3 != null ? avjVar3.equals(abstractC2489bg.extraParameters()) : abstractC2489bg.extraParameters() == null) {
                                                                                String str11 = this.format;
                                                                                if (str11 != null ? str11.equals(abstractC2489bg.format()) : abstractC2489bg.format() == null) {
                                                                                    AbstractC2490bh abstractC2490bh = this.identifierInfo;
                                                                                    if (abstractC2490bh != null ? abstractC2490bh.equals(abstractC2489bg.identifierInfo()) : abstractC2489bg.identifierInfo() == null) {
                                                                                        Boolean bool = this.isTv;
                                                                                        if (bool != null ? bool.equals(abstractC2489bg.isTv()) : abstractC2489bg.isTv() == null) {
                                                                                            Integer num = this.linearAdSlotWidth;
                                                                                            if (num != null ? num.equals(abstractC2489bg.linearAdSlotWidth()) : abstractC2489bg.linearAdSlotWidth() == null) {
                                                                                                Integer num2 = this.linearAdSlotHeight;
                                                                                                if (num2 != null ? num2.equals(abstractC2489bg.linearAdSlotHeight()) : abstractC2489bg.linearAdSlotHeight() == null) {
                                                                                                    String str12 = this.liveStreamEventId;
                                                                                                    if (str12 != null ? str12.equals(abstractC2489bg.liveStreamEventId()) : abstractC2489bg.liveStreamEventId() == null) {
                                                                                                        Float f2 = this.liveStreamPrefetchSeconds;
                                                                                                        if (f2 != null ? f2.equals(abstractC2489bg.liveStreamPrefetchSeconds()) : abstractC2489bg.liveStreamPrefetchSeconds() == null) {
                                                                                                            aio aioVar = this.marketAppInfo;
                                                                                                            if (aioVar != null ? aioVar.equals(abstractC2489bg.marketAppInfo()) : abstractC2489bg.marketAppInfo() == null) {
                                                                                                                String str13 = this.msParameter;
                                                                                                                if (str13 != null ? str13.equals(abstractC2489bg.msParameter()) : abstractC2489bg.msParameter() == null) {
                                                                                                                    String str14 = this.network;
                                                                                                                    if (str14 != null ? str14.equals(abstractC2489bg.network()) : abstractC2489bg.network() == null) {
                                                                                                                        String str15 = this.networkCode;
                                                                                                                        if (str15 != null ? str15.equals(abstractC2489bg.networkCode()) : abstractC2489bg.networkCode() == null) {
                                                                                                                            String str16 = this.oAuthToken;
                                                                                                                            if (str16 != null ? str16.equals(abstractC2489bg.oAuthToken()) : abstractC2489bg.oAuthToken() == null) {
                                                                                                                                Boolean bool2 = this.omidAdSessionsOnStartedOnly;
                                                                                                                                if (bool2 != null ? bool2.equals(abstractC2489bg.omidAdSessionsOnStartedOnly()) : abstractC2489bg.omidAdSessionsOnStartedOnly() == null) {
                                                                                                                                    String str17 = this.projectNumber;
                                                                                                                                    if (str17 != null ? str17.equals(abstractC2489bg.projectNumber()) : abstractC2489bg.projectNumber() == null) {
                                                                                                                                        String str18 = this.region;
                                                                                                                                        if (str18 != null ? str18.equals(abstractC2489bg.region()) : abstractC2489bg.region() == null) {
                                                                                                                                            ImaSdkSettings imaSdkSettings = this.settings;
                                                                                                                                            if (imaSdkSettings != null ? imaSdkSettings.equals(abstractC2489bg.settings()) : abstractC2489bg.settings() == null) {
                                                                                                                                                Boolean bool3 = this.supportsExternalNavigation;
                                                                                                                                                if (bool3 != null ? bool3.equals(abstractC2489bg.supportsExternalNavigation()) : abstractC2489bg.supportsExternalNavigation() == null) {
                                                                                                                                                    Boolean bool4 = this.supportsIconClickFallback;
                                                                                                                                                    if (bool4 != null ? bool4.equals(abstractC2489bg.supportsIconClickFallback()) : abstractC2489bg.supportsIconClickFallback() == null) {
                                                                                                                                                        Boolean bool5 = this.supportsNativeNetworking;
                                                                                                                                                        if (bool5 != null ? bool5.equals(abstractC2489bg.supportsNativeNetworking()) : abstractC2489bg.supportsNativeNetworking() == null) {
                                                                                                                                                            String str19 = this.streamActivityMonitorId;
                                                                                                                                                            if (str19 != null ? str19.equals(abstractC2489bg.streamActivityMonitorId()) : abstractC2489bg.streamActivityMonitorId() == null) {
                                                                                                                                                                Boolean bool6 = this.supportsResizing;
                                                                                                                                                                if (bool6 != null ? bool6.equals(abstractC2489bg.supportsResizing()) : abstractC2489bg.supportsResizing() == null) {
                                                                                                                                                                    Boolean bool7 = this.useQAStreamBaseUrl;
                                                                                                                                                                    if (bool7 != null ? bool7.equals(abstractC2489bg.useQAStreamBaseUrl()) : abstractC2489bg.useQAStreamBaseUrl() == null) {
                                                                                                                                                                        Boolean bool8 = this.usesCustomVideoPlayback;
                                                                                                                                                                        if (bool8 != null ? bool8.equals(abstractC2489bg.usesCustomVideoPlayback()) : abstractC2489bg.usesCustomVideoPlayback() == null) {
                                                                                                                                                                            Float f3 = this.vastLoadTimeout;
                                                                                                                                                                            if (f3 != null ? f3.equals(abstractC2489bg.vastLoadTimeout()) : abstractC2489bg.vastLoadTimeout() == null) {
                                                                                                                                                                                String str20 = this.videoId;
                                                                                                                                                                                if (str20 != null ? str20.equals(abstractC2489bg.videoId()) : abstractC2489bg.videoId() == null) {
                                                                                                                                                                                    ais aisVar = this.videoPlayActivation;
                                                                                                                                                                                    if (aisVar != null ? aisVar.equals(abstractC2489bg.videoPlayActivation()) : abstractC2489bg.videoPlayActivation() == null) {
                                                                                                                                                                                        ait aitVar = this.videoContinuousPlay;
                                                                                                                                                                                        if (aitVar != null ? aitVar.equals(abstractC2489bg.videoContinuousPlay()) : abstractC2489bg.videoContinuousPlay() == null) {
                                                                                                                                                                                            aiu aiuVar = this.videoPlayMuted;
                                                                                                                                                                                            if (aiuVar != null ? aiuVar.equals(abstractC2489bg.videoPlayMuted()) : abstractC2489bg.videoPlayMuted() == null) {
                                                                                                                                                                                                return true;
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public avg<AbstractC2484bb> espSignals() {
        return this.espSignals;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public avj<String, String> extraParameters() {
        return this.extraParameters;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String format() {
        return this.format;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public AbstractC2490bh identifierInfo() {
        return this.identifierInfo;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Boolean isTv() {
        return this.isTv;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Integer linearAdSlotHeight() {
        return this.linearAdSlotHeight;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Integer linearAdSlotWidth() {
        return this.linearAdSlotWidth;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String liveStreamEventId() {
        return this.liveStreamEventId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Float liveStreamPrefetchSeconds() {
        return this.liveStreamPrefetchSeconds;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public aio marketAppInfo() {
        return this.marketAppInfo;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String msParameter() {
        return this.msParameter;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String network() {
        return this.network;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String networkCode() {
        return this.networkCode;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String oAuthToken() {
        return this.oAuthToken;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Boolean omidAdSessionsOnStartedOnly() {
        return this.omidAdSessionsOnStartedOnly;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String projectNumber() {
        return this.projectNumber;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String region() {
        return this.region;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public ImaSdkSettings settings() {
        return this.settings;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String streamActivityMonitorId() {
        return this.streamActivityMonitorId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Boolean supportsExternalNavigation() {
        return this.supportsExternalNavigation;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Boolean supportsIconClickFallback() {
        return this.supportsIconClickFallback;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Boolean supportsNativeNetworking() {
        return this.supportsNativeNetworking;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Boolean supportsResizing() {
        return this.supportsResizing;
    }

    public String toString() {
        String str = this.adTagUrl;
        String valueOf = String.valueOf(this.adTagParameters);
        String str2 = this.adsResponse;
        String str3 = this.apiKey;
        String str4 = this.assetKey;
        String str5 = this.authToken;
        String valueOf2 = String.valueOf(this.companionSlots);
        String valueOf3 = String.valueOf(this.contentDuration);
        String valueOf4 = String.valueOf(this.contentKeywords);
        String str6 = this.contentTitle;
        String str7 = this.contentUrl;
        String str8 = this.contentSourceId;
        String valueOf5 = String.valueOf(this.consentSettings);
        String str9 = this.customAssetKey;
        String str10 = this.env;
        String valueOf6 = String.valueOf(this.espSignals);
        String valueOf7 = String.valueOf(this.extraParameters);
        String str11 = this.format;
        String valueOf8 = String.valueOf(this.identifierInfo);
        String valueOf9 = String.valueOf(this.isTv);
        String valueOf10 = String.valueOf(this.linearAdSlotWidth);
        String valueOf11 = String.valueOf(this.linearAdSlotHeight);
        String str12 = this.liveStreamEventId;
        String valueOf12 = String.valueOf(this.liveStreamPrefetchSeconds);
        String valueOf13 = String.valueOf(this.marketAppInfo);
        String str13 = this.msParameter;
        String str14 = this.network;
        String str15 = this.networkCode;
        String str16 = this.oAuthToken;
        String valueOf14 = String.valueOf(this.omidAdSessionsOnStartedOnly);
        String str17 = this.projectNumber;
        String str18 = this.region;
        String valueOf15 = String.valueOf(this.settings);
        String valueOf16 = String.valueOf(this.supportsExternalNavigation);
        String valueOf17 = String.valueOf(this.supportsIconClickFallback);
        String valueOf18 = String.valueOf(this.supportsNativeNetworking);
        String str19 = this.streamActivityMonitorId;
        String valueOf19 = String.valueOf(this.supportsResizing);
        String valueOf20 = String.valueOf(this.useQAStreamBaseUrl);
        String valueOf21 = String.valueOf(this.usesCustomVideoPlayback);
        String valueOf22 = String.valueOf(this.vastLoadTimeout);
        String str20 = this.videoId;
        String valueOf23 = String.valueOf(this.videoPlayActivation);
        String valueOf24 = String.valueOf(this.videoContinuousPlay);
        String valueOf25 = String.valueOf(this.videoPlayMuted);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 780 + String.valueOf(valueOf).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(valueOf5).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str11).length() + String.valueOf(valueOf8).length() + String.valueOf(valueOf9).length() + String.valueOf(valueOf10).length() + String.valueOf(valueOf11).length() + String.valueOf(str12).length() + String.valueOf(valueOf12).length() + String.valueOf(valueOf13).length() + String.valueOf(str13).length() + String.valueOf(str14).length() + String.valueOf(str15).length() + String.valueOf(str16).length() + String.valueOf(valueOf14).length() + String.valueOf(str17).length() + String.valueOf(str18).length() + String.valueOf(valueOf15).length() + String.valueOf(valueOf16).length() + String.valueOf(valueOf17).length() + String.valueOf(valueOf18).length() + String.valueOf(str19).length() + String.valueOf(valueOf19).length() + String.valueOf(valueOf20).length() + String.valueOf(valueOf21).length() + String.valueOf(valueOf22).length() + String.valueOf(str20).length() + String.valueOf(valueOf23).length() + String.valueOf(valueOf24).length() + String.valueOf(valueOf25).length());
        sb.append("GsonAdsRequest{adTagUrl=");
        sb.append(str);
        sb.append(", adTagParameters=");
        sb.append(valueOf);
        sb.append(", adsResponse=");
        sb.append(str2);
        sb.append(", apiKey=");
        sb.append(str3);
        sb.append(", assetKey=");
        sb.append(str4);
        sb.append(", authToken=");
        sb.append(str5);
        sb.append(", companionSlots=");
        sb.append(valueOf2);
        sb.append(", contentDuration=");
        sb.append(valueOf3);
        sb.append(", contentKeywords=");
        sb.append(valueOf4);
        sb.append(", contentTitle=");
        sb.append(str6);
        sb.append(", contentUrl=");
        sb.append(str7);
        sb.append(", contentSourceId=");
        sb.append(str8);
        sb.append(", consentSettings=");
        sb.append(valueOf5);
        sb.append(", customAssetKey=");
        sb.append(str9);
        sb.append(", env=");
        sb.append(str10);
        sb.append(", espSignals=");
        sb.append(valueOf6);
        sb.append(", extraParameters=");
        sb.append(valueOf7);
        sb.append(", format=");
        sb.append(str11);
        sb.append(", identifierInfo=");
        sb.append(valueOf8);
        sb.append(", isTv=");
        sb.append(valueOf9);
        sb.append(", linearAdSlotWidth=");
        sb.append(valueOf10);
        sb.append(", linearAdSlotHeight=");
        sb.append(valueOf11);
        sb.append(", liveStreamEventId=");
        sb.append(str12);
        sb.append(", liveStreamPrefetchSeconds=");
        sb.append(valueOf12);
        sb.append(", marketAppInfo=");
        sb.append(valueOf13);
        sb.append(", msParameter=");
        sb.append(str13);
        sb.append(", network=");
        sb.append(str14);
        sb.append(", networkCode=");
        sb.append(str15);
        sb.append(", oAuthToken=");
        sb.append(str16);
        sb.append(", omidAdSessionsOnStartedOnly=");
        sb.append(valueOf14);
        sb.append(", projectNumber=");
        sb.append(str17);
        sb.append(", region=");
        sb.append(str18);
        sb.append(", settings=");
        sb.append(valueOf15);
        sb.append(", supportsExternalNavigation=");
        sb.append(valueOf16);
        sb.append(", supportsIconClickFallback=");
        sb.append(valueOf17);
        sb.append(", supportsNativeNetworking=");
        sb.append(valueOf18);
        sb.append(", streamActivityMonitorId=");
        sb.append(str19);
        sb.append(", supportsResizing=");
        sb.append(valueOf19);
        sb.append(", useQAStreamBaseUrl=");
        sb.append(valueOf20);
        sb.append(", usesCustomVideoPlayback=");
        sb.append(valueOf21);
        sb.append(", vastLoadTimeout=");
        sb.append(valueOf22);
        sb.append(", videoId=");
        sb.append(str20);
        sb.append(", videoPlayActivation=");
        sb.append(valueOf23);
        sb.append(", videoContinuousPlay=");
        sb.append(valueOf24);
        sb.append(", videoPlayMuted=");
        sb.append(valueOf25);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Boolean useQAStreamBaseUrl() {
        return this.useQAStreamBaseUrl;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Boolean usesCustomVideoPlayback() {
        return this.usesCustomVideoPlayback;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public Float vastLoadTimeout() {
        return this.vastLoadTimeout;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public ait videoContinuousPlay() {
        return this.videoContinuousPlay;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public String videoId() {
        return this.videoId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public ais videoPlayActivation() {
        return this.videoPlayActivation;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2489bg
    public aiu videoPlayMuted() {
        return this.videoPlayMuted;
    }

    public int hashCode() {
        String str = this.adTagUrl;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        avj<String, String> avjVar = this.adTagParameters;
        int hashCode2 = (hashCode ^ (avjVar == null ? 0 : avjVar.hashCode())) * 1000003;
        String str2 = this.adsResponse;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.apiKey;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.assetKey;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.authToken;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        avj<String, String> avjVar2 = this.companionSlots;
        int hashCode7 = (hashCode6 ^ (avjVar2 == null ? 0 : avjVar2.hashCode())) * 1000003;
        Float f = this.contentDuration;
        int hashCode8 = (hashCode7 ^ (f == null ? 0 : f.hashCode())) * 1000003;
        avg<String> avgVar = this.contentKeywords;
        int hashCode9 = (hashCode8 ^ (avgVar == null ? 0 : avgVar.hashCode())) * 1000003;
        String str6 = this.contentTitle;
        int hashCode10 = (hashCode9 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.contentUrl;
        int hashCode11 = (hashCode10 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.contentSourceId;
        int hashCode12 = (hashCode11 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        AbstractC2481az abstractC2481az = this.consentSettings;
        int hashCode13 = (hashCode12 ^ (abstractC2481az == null ? 0 : abstractC2481az.hashCode())) * 1000003;
        String str9 = this.customAssetKey;
        int hashCode14 = (hashCode13 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.env;
        int hashCode15 = (hashCode14 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        avg<AbstractC2484bb> avgVar2 = this.espSignals;
        int hashCode16 = (hashCode15 ^ (avgVar2 == null ? 0 : avgVar2.hashCode())) * 1000003;
        avj<String, String> avjVar3 = this.extraParameters;
        int hashCode17 = (hashCode16 ^ (avjVar3 == null ? 0 : avjVar3.hashCode())) * 1000003;
        String str11 = this.format;
        int hashCode18 = (hashCode17 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        AbstractC2490bh abstractC2490bh = this.identifierInfo;
        int hashCode19 = (hashCode18 ^ (abstractC2490bh == null ? 0 : abstractC2490bh.hashCode())) * 1000003;
        Boolean bool = this.isTv;
        int hashCode20 = (hashCode19 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        Integer num = this.linearAdSlotWidth;
        int hashCode21 = (hashCode20 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Integer num2 = this.linearAdSlotHeight;
        int hashCode22 = (hashCode21 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        String str12 = this.liveStreamEventId;
        int hashCode23 = (hashCode22 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        Float f2 = this.liveStreamPrefetchSeconds;
        int hashCode24 = (hashCode23 ^ (f2 == null ? 0 : f2.hashCode())) * 1000003;
        aio aioVar = this.marketAppInfo;
        int hashCode25 = (hashCode24 ^ (aioVar == null ? 0 : aioVar.hashCode())) * 1000003;
        String str13 = this.msParameter;
        int hashCode26 = (hashCode25 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.network;
        int hashCode27 = (hashCode26 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.networkCode;
        int hashCode28 = (hashCode27 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        String str16 = this.oAuthToken;
        int hashCode29 = (hashCode28 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
        Boolean bool2 = this.omidAdSessionsOnStartedOnly;
        int hashCode30 = (hashCode29 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
        String str17 = this.projectNumber;
        int hashCode31 = (hashCode30 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
        String str18 = this.region;
        int hashCode32 = (hashCode31 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
        ImaSdkSettings imaSdkSettings = this.settings;
        int hashCode33 = (hashCode32 ^ (imaSdkSettings == null ? 0 : imaSdkSettings.hashCode())) * 1000003;
        Boolean bool3 = this.supportsExternalNavigation;
        int hashCode34 = (hashCode33 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
        Boolean bool4 = this.supportsIconClickFallback;
        int hashCode35 = (hashCode34 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
        Boolean bool5 = this.supportsNativeNetworking;
        int hashCode36 = (hashCode35 ^ (bool5 == null ? 0 : bool5.hashCode())) * 1000003;
        String str19 = this.streamActivityMonitorId;
        int hashCode37 = (hashCode36 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
        Boolean bool6 = this.supportsResizing;
        int hashCode38 = (hashCode37 ^ (bool6 == null ? 0 : bool6.hashCode())) * 1000003;
        Boolean bool7 = this.useQAStreamBaseUrl;
        int hashCode39 = (hashCode38 ^ (bool7 == null ? 0 : bool7.hashCode())) * 1000003;
        Boolean bool8 = this.usesCustomVideoPlayback;
        int hashCode40 = (hashCode39 ^ (bool8 == null ? 0 : bool8.hashCode())) * 1000003;
        Float f3 = this.vastLoadTimeout;
        int hashCode41 = (hashCode40 ^ (f3 == null ? 0 : f3.hashCode())) * 1000003;
        String str20 = this.videoId;
        int hashCode42 = (hashCode41 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
        ais aisVar = this.videoPlayActivation;
        int hashCode43 = (hashCode42 ^ (aisVar == null ? 0 : aisVar.hashCode())) * 1000003;
        ait aitVar = this.videoContinuousPlay;
        int hashCode44 = (hashCode43 ^ (aitVar == null ? 0 : aitVar.hashCode())) * 1000003;
        aiu aiuVar = this.videoPlayMuted;
        return hashCode44 ^ (aiuVar != null ? aiuVar.hashCode() : 0);
    }
}

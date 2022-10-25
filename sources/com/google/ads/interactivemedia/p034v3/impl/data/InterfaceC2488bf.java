package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.p034v3.internal.aio;
import com.google.ads.interactivemedia.p034v3.internal.ais;
import com.google.ads.interactivemedia.p034v3.internal.ait;
import com.google.ads.interactivemedia.p034v3.internal.aiu;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bf */
/* loaded from: classes2.dex */
public interface InterfaceC2488bf {
    InterfaceC2488bf adTagParameters(Map<String, String> map);

    InterfaceC2488bf adTagUrl(String str);

    InterfaceC2488bf adsResponse(String str);

    InterfaceC2488bf apiKey(String str);

    InterfaceC2488bf assetKey(String str);

    InterfaceC2488bf authToken(String str);

    AbstractC2489bg build();

    InterfaceC2488bf companionSlots(Map<String, String> map);

    InterfaceC2488bf consentSettings(AbstractC2481az abstractC2481az);

    InterfaceC2488bf contentDuration(Float f);

    InterfaceC2488bf contentKeywords(List<String> list);

    InterfaceC2488bf contentSourceId(String str);

    InterfaceC2488bf contentTitle(String str);

    InterfaceC2488bf contentUrl(String str);

    InterfaceC2488bf customAssetKey(String str);

    InterfaceC2488bf env(String str);

    InterfaceC2488bf espSignals(List<AbstractC2484bb> list);

    InterfaceC2488bf extraParameters(Map<String, String> map);

    InterfaceC2488bf format(String str);

    InterfaceC2488bf identifierInfo(AbstractC2490bh abstractC2490bh);

    InterfaceC2488bf isTv(Boolean bool);

    InterfaceC2488bf linearAdSlotHeight(Integer num);

    InterfaceC2488bf linearAdSlotWidth(Integer num);

    InterfaceC2488bf liveStreamEventId(String str);

    InterfaceC2488bf liveStreamPrefetchSeconds(Float f);

    InterfaceC2488bf marketAppInfo(aio aioVar);

    InterfaceC2488bf msParameter(String str);

    InterfaceC2488bf network(String str);

    InterfaceC2488bf networkCode(String str);

    InterfaceC2488bf oAuthToken(String str);

    InterfaceC2488bf omidAdSessionsOnStartedOnly(Boolean bool);

    InterfaceC2488bf projectNumber(String str);

    InterfaceC2488bf region(String str);

    InterfaceC2488bf settings(ImaSdkSettings imaSdkSettings);

    InterfaceC2488bf streamActivityMonitorId(String str);

    InterfaceC2488bf supportsExternalNavigation(Boolean bool);

    InterfaceC2488bf supportsIconClickFallback(Boolean bool);

    InterfaceC2488bf supportsNativeNetworking(Boolean bool);

    InterfaceC2488bf supportsResizing(Boolean bool);

    InterfaceC2488bf useQAStreamBaseUrl(Boolean bool);

    InterfaceC2488bf usesCustomVideoPlayback(Boolean bool);

    InterfaceC2488bf vastLoadTimeout(Float f);

    InterfaceC2488bf videoContinuousPlay(ait aitVar);

    InterfaceC2488bf videoId(String str);

    InterfaceC2488bf videoPlayActivation(ais aisVar);

    InterfaceC2488bf videoPlayMuted(aiu aiuVar);
}

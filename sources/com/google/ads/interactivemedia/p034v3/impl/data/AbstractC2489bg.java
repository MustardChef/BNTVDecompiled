package com.google.ads.interactivemedia.p034v3.impl.data;

import android.os.Build;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.AdsRequest;
import com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.p034v3.api.ImaSdkSettings;
import com.google.ads.interactivemedia.p034v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.StreamRequest;
import com.google.ads.interactivemedia.p034v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.p034v3.internal.aia;
import com.google.ads.interactivemedia.p034v3.internal.aio;
import com.google.ads.interactivemedia.p034v3.internal.ais;
import com.google.ads.interactivemedia.p034v3.internal.ait;
import com.google.ads.interactivemedia.p034v3.internal.aiu;
import com.google.ads.interactivemedia.p034v3.internal.aiv;
import com.google.ads.interactivemedia.p034v3.internal.aja;
import com.google.ads.interactivemedia.p034v3.internal.akq;
import com.google.ads.interactivemedia.p034v3.internal.ald;
import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avh;
import com.google.ads.interactivemedia.p034v3.internal.avj;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bg */
/* loaded from: classes2.dex */
public abstract class AbstractC2489bg {
    public static InterfaceC2488bf builder() {
        return new C2535z();
    }

    public static AbstractC2489bg create(AdsRequest adsRequest, String str, AbstractC2481az abstractC2481az, List<AbstractC2484bb> list, String str2, ImaSdkSettings imaSdkSettings, aio aioVar, boolean z, AbstractC2490bh abstractC2490bh, AdDisplayContainer adDisplayContainer) {
        String adTagUrl = adsRequest.getAdTagUrl();
        String adsResponse = adsRequest.getAdsResponse();
        Map<String, String> extraParameters = adsRequest.getExtraParameters();
        aiv aivVar = (aiv) adsRequest;
        ais m5189a = aivVar.m5189a();
        aiu m5187c = aivVar.m5187c();
        ait m5188b = aivVar.m5188b();
        Float m5186d = aivVar.m5186d();
        List<String> m5181i = aivVar.m5181i();
        String m5183g = aivVar.m5183g();
        String m5182h = aivVar.m5182h();
        Float m5184f = aivVar.m5184f();
        Float m5185e = aivVar.m5185e();
        Map<String, String> companionSlots = getCompanionSlots((aia) adDisplayContainer);
        ViewGroup adContainer = adDisplayContainer.getAdContainer();
        InterfaceC2488bf builder = builder();
        builder.adTagUrl(adTagUrl);
        builder.adsResponse(adsResponse);
        builder.companionSlots(companionSlots);
        builder.consentSettings(abstractC2481az);
        builder.contentDuration(m5186d);
        builder.contentKeywords(m5181i);
        builder.contentTitle(m5183g);
        builder.contentUrl(m5182h);
        builder.env(str);
        builder.espSignals(list);
        builder.extraParameters(extraParameters);
        builder.identifierInfo(abstractC2490bh);
        Boolean valueOf = Boolean.valueOf(z);
        builder.isTv(valueOf);
        builder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        builder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        builder.liveStreamPrefetchSeconds(m5185e);
        builder.marketAppInfo(aioVar);
        builder.network(str2);
        builder.omidAdSessionsOnStartedOnly(true);
        builder.settings(imaSdkSettings);
        builder.supportsExternalNavigation(Boolean.valueOf(!z));
        builder.supportsIconClickFallback(valueOf);
        builder.supportsNativeNetworking(Boolean.valueOf(supportsNativeNetworkRequests()));
        builder.supportsResizing(Boolean.valueOf(adDisplayContainer.getPlayer() instanceof ResizablePlayer));
        builder.usesCustomVideoPlayback(Boolean.valueOf(!(adDisplayContainer.getPlayer() instanceof ald)));
        builder.vastLoadTimeout(m5184f);
        builder.videoContinuousPlay(m5188b);
        builder.videoPlayActivation(m5189a);
        builder.videoPlayMuted(m5187c);
        return builder.build();
    }

    public static AbstractC2489bg createFromStreamRequest(StreamRequest streamRequest, String str, AbstractC2481az abstractC2481az, List<AbstractC2484bb> list, String str2, ImaSdkSettings imaSdkSettings, aio aioVar, boolean z, String str3, AbstractC2490bh abstractC2490bh, StreamDisplayContainer streamDisplayContainer) {
        Map<String, String> companionSlots = getCompanionSlots((akq) streamDisplayContainer);
        ViewGroup adContainer = streamDisplayContainer.getAdContainer();
        String str4 = streamRequest.getFormat() == StreamRequest.StreamFormat.DASH ? "dash" : "hls";
        InterfaceC2488bf builder = builder();
        builder.adTagParameters(streamRequest.getAdTagParameters());
        builder.apiKey(streamRequest.getApiKey());
        builder.assetKey(streamRequest.getAssetKey());
        builder.authToken(streamRequest.getAuthToken());
        builder.companionSlots(companionSlots);
        builder.consentSettings(abstractC2481az);
        builder.contentSourceId(streamRequest.getContentSourceId());
        builder.contentUrl(streamRequest.getContentUrl());
        builder.customAssetKey(streamRequest.getCustomAssetKey());
        builder.env(str);
        builder.espSignals(list);
        builder.format(str4);
        builder.identifierInfo(abstractC2490bh);
        Boolean valueOf = Boolean.valueOf(z);
        builder.isTv(valueOf);
        builder.linearAdSlotWidth(Integer.valueOf(adContainer.getWidth()));
        builder.linearAdSlotHeight(Integer.valueOf(adContainer.getHeight()));
        builder.liveStreamEventId(streamRequest.getLiveStreamEventId());
        builder.marketAppInfo(aioVar);
        builder.msParameter(str3);
        builder.network(str2);
        builder.networkCode(streamRequest.getNetworkCode());
        builder.oAuthToken(streamRequest.getOAuthToken());
        builder.omidAdSessionsOnStartedOnly(true);
        builder.projectNumber(streamRequest.getProjectNumber());
        builder.region(streamRequest.getRegion());
        builder.settings(imaSdkSettings);
        builder.streamActivityMonitorId(streamRequest.getStreamActivityMonitorId());
        builder.supportsExternalNavigation(Boolean.valueOf(true ^ z));
        builder.supportsIconClickFallback(valueOf);
        builder.supportsNativeNetworking(Boolean.valueOf(supportsNativeNetworkRequests()));
        builder.supportsResizing(Boolean.valueOf(streamDisplayContainer.getVideoStreamPlayer() instanceof ResizablePlayer));
        builder.useQAStreamBaseUrl(streamRequest.getUseQAStreamBaseUrl());
        builder.videoId(streamRequest.getVideoId());
        return builder.build();
    }

    private static Map<String, String> getCompanionSlots(aja ajaVar) {
        Map m5180a = ajaVar.m5180a();
        if (m5180a == null || m5180a.isEmpty()) {
            return null;
        }
        avh avhVar = new avh();
        for (String str : m5180a.keySet()) {
            CompanionAdSlot companionAdSlot = (CompanionAdSlot) m5180a.get(str);
            int width = companionAdSlot.getWidth();
            int height = companionAdSlot.getHeight();
            StringBuilder sb = new StringBuilder(23);
            sb.append(width);
            sb.append("x");
            sb.append(height);
            avhVar.mo4491a(str, sb.toString());
        }
        return avhVar.mo4489c();
    }

    private static boolean supportsNativeNetworkRequests() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public abstract avj<String, String> adTagParameters();

    public abstract String adTagUrl();

    public abstract String adsResponse();

    public abstract String apiKey();

    public abstract String assetKey();

    public abstract String authToken();

    public abstract avj<String, String> companionSlots();

    public abstract AbstractC2481az consentSettings();

    public abstract Float contentDuration();

    public abstract avg<String> contentKeywords();

    public abstract String contentSourceId();

    public abstract String contentTitle();

    public abstract String contentUrl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String customAssetKey();

    public abstract String env();

    public abstract avg<AbstractC2484bb> espSignals();

    public abstract avj<String, String> extraParameters();

    public abstract String format();

    public abstract AbstractC2490bh identifierInfo();

    public abstract Boolean isTv();

    public abstract Integer linearAdSlotHeight();

    public abstract Integer linearAdSlotWidth();

    public abstract String liveStreamEventId();

    public abstract Float liveStreamPrefetchSeconds();

    public abstract aio marketAppInfo();

    public abstract String msParameter();

    public abstract String network();

    public abstract String networkCode();

    public abstract String oAuthToken();

    public abstract Boolean omidAdSessionsOnStartedOnly();

    public abstract String projectNumber();

    public abstract String region();

    public abstract ImaSdkSettings settings();

    public abstract String streamActivityMonitorId();

    public abstract Boolean supportsExternalNavigation();

    public abstract Boolean supportsIconClickFallback();

    public abstract Boolean supportsNativeNetworking();

    public abstract Boolean supportsResizing();

    public abstract Boolean useQAStreamBaseUrl();

    public abstract Boolean usesCustomVideoPlayback();

    public abstract Float vastLoadTimeout();

    public abstract ait videoContinuousPlay();

    public abstract String videoId();

    public abstract ais videoPlayActivation();

    public abstract aiu videoPlayMuted();
}

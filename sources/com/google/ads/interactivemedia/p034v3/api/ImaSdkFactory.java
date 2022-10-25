package com.google.ads.interactivemedia.p034v3.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2487be;
import com.google.ads.interactivemedia.p034v3.impl.data.C2516g;
import com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2486bd;
import com.google.ads.interactivemedia.p034v3.impl.data.TestingConfiguration;
import com.google.ads.interactivemedia.p034v3.internal.aia;
import com.google.ads.interactivemedia.p034v3.internal.aip;
import com.google.ads.interactivemedia.p034v3.internal.aiv;
import com.google.ads.interactivemedia.p034v3.internal.ajc;
import com.google.ads.interactivemedia.p034v3.internal.ajj;
import com.google.ads.interactivemedia.p034v3.internal.ajk;
import com.google.ads.interactivemedia.p034v3.internal.akq;
import com.google.ads.interactivemedia.p034v3.internal.aks;
import com.google.ads.interactivemedia.p034v3.internal.alc;
import com.google.ads.interactivemedia.p034v3.internal.atm;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.ImaSdkFactory */
/* loaded from: classes2.dex */
public class ImaSdkFactory {
    private static ImaSdkFactory instance;

    private ImaSdkFactory() {
    }

    private AdsLoader createAdsLoader(Context context, Uri uri, BaseDisplayContainer baseDisplayContainer, ImaSdkSettings imaSdkSettings, TestingConfiguration testingConfiguration) {
        if (uri == null) {
            uri = readJsCoreUri(imaSdkSettings);
        }
        aip aipVar = new aip(context, uri, imaSdkSettings, baseDisplayContainer, testingConfiguration, Executors.newCachedThreadPool());
        aipVar.m5199l();
        return aipVar;
    }

    @Deprecated
    public static VideoAdPlayer createSdkOwnedPlayer(Context context, ViewGroup viewGroup) {
        atm.m4612j(context);
        atm.m4612j(viewGroup);
        return new alc(context, viewGroup);
    }

    public static ImaSdkFactory getInstance() {
        if (instance == null) {
            instance = new ImaSdkFactory();
        }
        return instance;
    }

    private Uri readJsCoreUri(ImaSdkSettings imaSdkSettings) {
        return (imaSdkSettings == null || !imaSdkSettings.isDebugMode()) ? ajj.f4234a : ajj.f4235b;
    }

    @Deprecated
    public AdDisplayContainer createAdDisplayContainer() {
        return new aia((ViewGroup) null, (VideoAdPlayer) null);
    }

    public AdsRenderingSettings createAdsRenderingSettings() {
        return new C2516g();
    }

    public AdsRequest createAdsRequest() {
        return new aiv();
    }

    @Deprecated
    public AdDisplayContainer createAudioAdDisplayContainer(Context context) {
        atm.m4612j(context);
        return new aia(context, (VideoAdPlayer) null);
    }

    public StreamRequest createCloudPodStreamRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        aks aksVar = new aks();
        aksVar.m5082f(str);
        aksVar.m5084d(str2);
        aksVar.m5087a(str3);
        aksVar.m5083e(str4);
        aksVar.m5079i(str5);
        aksVar.m5080h(str6);
        aksVar.m5081g(str7);
        return aksVar;
    }

    public CompanionAdSlot createCompanionAdSlot() {
        return new ajc();
    }

    public FriendlyObstruction createFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        InterfaceC2486bd builder = AbstractC2487be.builder();
        builder.view(view);
        builder.purpose(friendlyObstructionPurpose);
        builder.detailedReason(str);
        return builder.build();
    }

    public ImaSdkSettings createImaSdkSettings() {
        return new ajk();
    }

    public StreamRequest createLiveStreamRequest(String str, String str2) {
        aks aksVar = new aks();
        aksVar.m5086b(str);
        aksVar.m5087a(str2);
        return aksVar;
    }

    public StreamRequest createPodStreamRequest(String str, String str2, String str3) {
        aks aksVar = new aks();
        aksVar.m5082f(str);
        aksVar.m5084d(str2);
        aksVar.m5087a(str3);
        return aksVar;
    }

    @Deprecated
    public StreamDisplayContainer createStreamDisplayContainer() {
        return new akq(null, null);
    }

    public StreamRequest createVodStreamRequest(String str, String str2, String str3) {
        aks aksVar = new aks();
        aksVar.m5085c(str);
        aksVar.m5078j(str2);
        aksVar.m5087a(str3);
        return aksVar;
    }

    public static AdDisplayContainer createAdDisplayContainer(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
        atm.m4612j(viewGroup);
        atm.m4612j(videoAdPlayer);
        return new aia(viewGroup, videoAdPlayer);
    }

    public static StreamDisplayContainer createStreamDisplayContainer(ViewGroup viewGroup, VideoStreamPlayer videoStreamPlayer) {
        atm.m4612j(viewGroup);
        atm.m4612j(videoStreamPlayer);
        return new akq(viewGroup, videoStreamPlayer);
    }

    public static AdDisplayContainer createAudioAdDisplayContainer(Context context, VideoAdPlayer videoAdPlayer) {
        atm.m4612j(context);
        atm.m4612j(videoAdPlayer);
        return new aia(context, videoAdPlayer);
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer) {
        return createAdsLoader(context, imaSdkSettings, adDisplayContainer, Executors.newCachedThreadPool());
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer, ExecutorService executorService) {
        aip aipVar = new aip(context, readJsCoreUri(imaSdkSettings), imaSdkSettings, adDisplayContainer, null, executorService);
        aipVar.m5199l();
        return aipVar;
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, StreamDisplayContainer streamDisplayContainer) {
        return createAdsLoader(context, imaSdkSettings, streamDisplayContainer, Executors.newCachedThreadPool());
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, StreamDisplayContainer streamDisplayContainer, ExecutorService executorService) {
        aip aipVar = new aip(context, readJsCoreUri(imaSdkSettings), imaSdkSettings, streamDisplayContainer, null, executorService);
        aipVar.m5199l();
        return aipVar;
    }
}

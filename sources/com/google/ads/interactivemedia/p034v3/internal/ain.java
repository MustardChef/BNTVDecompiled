package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.AdError;
import com.google.ads.interactivemedia.p034v3.api.AdsRequest;
import com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.StreamRequest;
import com.google.ads.interactivemedia.p034v3.api.player.ContentProgressProvider;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ain */
/* loaded from: classes2.dex */
public final class ain implements ajt {

    /* renamed from: a */
    final /* synthetic */ aip f4154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ain(aip aipVar) {
        this.f4154a = aipVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajt
    /* renamed from: a */
    public final void mo5154a(String str, AdError.AdErrorType adErrorType, int i, String str2) {
        Map map;
        Map map2;
        Object obj;
        Map map3;
        aji ajiVar;
        Map map4;
        map = this.f4154a.f4161g;
        if (map.get(str) != null) {
            map4 = this.f4154a.f4161g;
            obj = ((AdsRequest) map4.get(str)).getUserRequestContext();
        } else {
            map2 = this.f4154a.f4162h;
            if (map2.get(str) != null) {
                map3 = this.f4154a.f4162h;
                obj = ((StreamRequest) map3.get(str)).getUserRequestContext();
            } else {
                obj = new Object();
            }
        }
        aib aibVar = new aib(new AdError(adErrorType, i, str2), obj);
        ajiVar = this.f4154a.f4159e;
        ajiVar.m5165c(aibVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajt
    /* renamed from: b */
    public final void mo5153b(String str, List list, SortedSet sortedSet, boolean z) {
        BaseDisplayContainer baseDisplayContainer;
        Map map;
        akm akmVar;
        ajx ajxVar;
        akm akmVar2;
        Context context;
        aji ajiVar;
        aji ajiVar2;
        aip aipVar = this.f4154a;
        baseDisplayContainer = aipVar.f4165k;
        AdDisplayContainer adDisplayContainer = (AdDisplayContainer) baseDisplayContainer;
        map = aipVar.f4161g;
        AdsRequest adsRequest = (AdsRequest) map.get(str);
        if (adsRequest == null) {
            ajiVar2 = this.f4154a.f4159e;
            AdError.AdErrorType adErrorType = AdError.AdErrorType.LOAD;
            AdError.AdErrorCode adErrorCode = AdError.AdErrorCode.INTERNAL_ERROR;
            String valueOf = String.valueOf(str);
            ajiVar2.m5165c(new aib(new AdError(adErrorType, adErrorCode, valueOf.length() != 0 ? "Request not found for session id: ".concat(valueOf) : new String("Request not found for session id: ")), new Object()));
            return;
        }
        ContentProgressProvider contentProgressProvider = adsRequest.getContentProgressProvider();
        AdError adError = null;
        akp akpVar = contentProgressProvider != null ? new akp(contentProgressProvider) : null;
        akmVar = this.f4154a.f4163i;
        akmVar.m5101e(((aiv) adsRequest).m5182h());
        if (sortedSet != null && !sortedSet.isEmpty() && akpVar == null) {
            adError = new AdError(AdError.AdErrorType.PLAY, AdError.AdErrorCode.PLAYLIST_NO_CONTENT_TRACKING, "Unable to handle cue points, no content progress provider configured.");
        }
        if (adError != null) {
            ajiVar = this.f4154a.f4159e;
            ajiVar.m5165c(new aib(adError, adsRequest.getUserRequestContext()));
            return;
        }
        aip aipVar2 = this.f4154a;
        ajxVar = aipVar2.f4157c;
        akmVar2 = aipVar2.f4163i;
        aji ajiVar3 = new aji();
        context = this.f4154a.f4156b;
        aip.m5201j(aipVar2, new air(new aiq(str, ajxVar, adDisplayContainer, akpVar, list, sortedSet, akmVar2, ajiVar3, context, z), adsRequest.getUserRequestContext()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajt
    /* renamed from: c */
    public final void mo5152c(String str, String str2, boolean z) {
        BaseDisplayContainer baseDisplayContainer;
        Map map;
        akm akmVar;
        akm akmVar2;
        ajx ajxVar;
        akm akmVar3;
        Context context;
        aji ajiVar;
        aip aipVar = this.f4154a;
        baseDisplayContainer = aipVar.f4165k;
        StreamDisplayContainer streamDisplayContainer = (StreamDisplayContainer) baseDisplayContainer;
        map = aipVar.f4162h;
        StreamRequest streamRequest = (StreamRequest) map.get(str);
        if (streamRequest == null) {
            ajiVar = this.f4154a.f4159e;
            AdError.AdErrorType adErrorType = AdError.AdErrorType.LOAD;
            AdError.AdErrorCode adErrorCode = AdError.AdErrorCode.INTERNAL_ERROR;
            String valueOf = String.valueOf(str);
            ajiVar.m5165c(new aib(new AdError(adErrorType, adErrorCode, valueOf.length() != 0 ? "Request not found for session id: ".concat(valueOf) : new String("Request not found for session id: ")), new Object()));
            return;
        }
        akmVar = this.f4154a.f4163i;
        akmVar.m5101e(streamRequest.getContentUrl());
        akmVar2 = this.f4154a.f4163i;
        akmVar2.m5097i();
        aip aipVar2 = this.f4154a;
        ajxVar = aipVar2.f4157c;
        String manifestSuffix = streamRequest.getManifestSuffix();
        akmVar3 = this.f4154a.f4163i;
        aji ajiVar2 = new aji();
        context = this.f4154a.f4156b;
        aip.m5201j(aipVar2, new air(new akr(str, ajxVar, streamDisplayContainer, new aku(str, ajxVar, ajiVar2, streamDisplayContainer, manifestSuffix), new ahz(str, ajxVar, streamDisplayContainer.getAdContainer()), akmVar3, ajiVar2, context, str2, z), streamRequest.getUserRequestContext()));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajt
    /* renamed from: d */
    public final void mo5151d(String str, AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode) {
        Map map;
        Map map2;
        Object obj;
        Map map3;
        aji ajiVar;
        Map map4;
        map = this.f4154a.f4161g;
        if (map.get(str) != null) {
            map4 = this.f4154a.f4161g;
            obj = ((AdsRequest) map4.get(str)).getUserRequestContext();
        } else {
            map2 = this.f4154a.f4162h;
            if (map2.get(str) != null) {
                map3 = this.f4154a.f4162h;
                obj = ((StreamRequest) map3.get(str)).getUserRequestContext();
            } else {
                obj = new Object();
            }
        }
        aib aibVar = new aib(new AdError(adErrorType, adErrorCode, "adsLoaded message did not contain cue points."), obj);
        ajiVar = this.f4154a.f4159e;
        ajiVar.m5165c(aibVar);
    }
}

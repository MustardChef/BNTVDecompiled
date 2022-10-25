package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdsRequest;
import com.google.ads.interactivemedia.p034v3.api.player.ContentProgressProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aiv */
/* loaded from: classes2.dex */
public final class aiv implements AdsRequest {

    /* renamed from: a */
    private String f4180a;

    /* renamed from: b */
    private Map f4181b;

    /* renamed from: c */
    private String f4182c;

    /* renamed from: d */
    private ContentProgressProvider f4183d;

    /* renamed from: e */
    private ais f4184e = ais.UNKNOWN;

    /* renamed from: f */
    private aiu f4185f = aiu.UNKNOWN;

    /* renamed from: g */
    private ait f4186g = ait.UNKNOWN;

    /* renamed from: h */
    private Float f4187h;

    /* renamed from: i */
    private List f4188i;

    /* renamed from: j */
    private String f4189j;

    /* renamed from: k */
    private String f4190k;

    /* renamed from: l */
    private Float f4191l;

    /* renamed from: m */
    private Float f4192m;

    /* renamed from: n */
    private transient Object f4193n;

    /* renamed from: a */
    public final ais m5189a() {
        return this.f4184e;
    }

    /* renamed from: b */
    public final ait m5188b() {
        return this.f4186g;
    }

    /* renamed from: c */
    public final aiu m5187c() {
        return this.f4185f;
    }

    /* renamed from: d */
    public final Float m5186d() {
        return this.f4187h;
    }

    /* renamed from: e */
    public final Float m5185e() {
        return this.f4192m;
    }

    /* renamed from: f */
    public final Float m5184f() {
        return this.f4191l;
    }

    /* renamed from: g */
    public final String m5183g() {
        return this.f4189j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final String getAdTagUrl() {
        return this.f4180a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final String getAdsResponse() {
        return this.f4182c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final ContentProgressProvider getContentProgressProvider() {
        return this.f4183d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final String getExtraParameter(String str) {
        Map map = this.f4181b;
        if (map == null) {
            return null;
        }
        return (String) map.get(str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final Map<String, String> getExtraParameters() {
        return this.f4181b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final Object getUserRequestContext() {
        return this.f4193n;
    }

    /* renamed from: h */
    public final String m5182h() {
        return this.f4190k;
    }

    /* renamed from: i */
    public final List m5181i() {
        return this.f4188i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setAdTagUrl(String str) {
        this.f4180a = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setAdWillAutoPlay(boolean z) {
        this.f4184e = z ? ais.AUTO : ais.CLICK;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setAdWillPlayMuted(boolean z) {
        this.f4185f = z ? aiu.MUTED : aiu.UNMUTED;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setAdsResponse(String str) {
        this.f4182c = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setContentDuration(float f) {
        this.f4187h = Float.valueOf(f);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setContentKeywords(List<String> list) {
        this.f4188i = list;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setContentProgressProvider(ContentProgressProvider contentProgressProvider) {
        this.f4183d = contentProgressProvider;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setContentTitle(String str) {
        this.f4189j = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setContentUrl(String str) {
        this.f4190k = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setContinuousPlayback(boolean z) {
        this.f4186g = z ? ait.ON : ait.OFF;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setExtraParameter(String str, String str2) {
        if (this.f4181b == null) {
            this.f4181b = new HashMap();
        }
        this.f4181b.put(str, str2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setLiveStreamPrefetchSeconds(float f) {
        this.f4192m = Float.valueOf(f);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setUserRequestContext(Object obj) {
        this.f4193n = obj;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRequest
    public final void setVastLoadTimeout(float f) {
        this.f4191l = Float.valueOf(f);
    }
}

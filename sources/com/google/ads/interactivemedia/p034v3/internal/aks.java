package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.StreamRequest;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aks */
/* loaded from: classes2.dex */
public final class aks implements StreamRequest {

    /* renamed from: a */
    private String f4317a;

    /* renamed from: b */
    private String f4318b;

    /* renamed from: c */
    private String f4319c;

    /* renamed from: d */
    private String f4320d;

    /* renamed from: e */
    private String f4321e;

    /* renamed from: f */
    private String f4322f;

    /* renamed from: g */
    private String f4323g;

    /* renamed from: h */
    private String f4324h;

    /* renamed from: i */
    private String f4325i;

    /* renamed from: j */
    private String f4326j;

    /* renamed from: k */
    private Map f4327k;

    /* renamed from: l */
    private String f4328l;

    /* renamed from: m */
    private String f4329m;

    /* renamed from: n */
    private String f4330n;

    /* renamed from: o */
    private String f4331o;

    /* renamed from: p */
    private StreamRequest.StreamFormat f4332p;

    /* renamed from: q */
    private Boolean f4333q;

    /* renamed from: r */
    private transient Object f4334r;

    /* renamed from: a */
    public final void m5087a(String str) {
        this.f4318b = str;
    }

    /* renamed from: b */
    public final void m5086b(String str) {
        this.f4317a = str;
    }

    /* renamed from: c */
    public final void m5085c(String str) {
        this.f4319c = str;
    }

    /* renamed from: d */
    public final void m5084d(String str) {
        this.f4322f = str;
    }

    /* renamed from: e */
    public final void m5083e(String str) {
        this.f4323g = str;
    }

    /* renamed from: f */
    public final void m5082f(String str) {
        this.f4321e = str;
    }

    /* renamed from: g */
    public final void m5081g(String str) {
        this.f4326j = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final Map<String, String> getAdTagParameters() {
        return this.f4327k;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getApiKey() {
        return this.f4318b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getAssetKey() {
        return this.f4317a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getAuthToken() {
        return this.f4330n;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getContentSourceId() {
        return this.f4319c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getContentUrl() {
        return this.f4329m;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getCustomAssetKey() {
        return this.f4322f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final StreamRequest.StreamFormat getFormat() {
        return this.f4332p;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getLiveStreamEventId() {
        return this.f4323g;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getManifestSuffix() {
        return this.f4328l;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getNetworkCode() {
        return this.f4321e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getOAuthToken() {
        return this.f4326j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getProjectNumber() {
        return this.f4325i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getRegion() {
        return this.f4324h;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getStreamActivityMonitorId() {
        return this.f4331o;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final Boolean getUseQAStreamBaseUrl() {
        return this.f4333q;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final Object getUserRequestContext() {
        return this.f4334r;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final String getVideoId() {
        return this.f4320d;
    }

    /* renamed from: h */
    public final void m5080h(String str) {
        this.f4325i = str;
    }

    /* renamed from: i */
    public final void m5079i(String str) {
        this.f4324h = str;
    }

    /* renamed from: j */
    public final void m5078j(String str) {
        this.f4320d = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final void setAdTagParameters(Map<String, String> map) {
        this.f4327k = map;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final void setAuthToken(String str) {
        this.f4330n = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final void setContentUrl(String str) {
        this.f4329m = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final void setFormat(StreamRequest.StreamFormat streamFormat) {
        this.f4332p = streamFormat;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final void setManifestSuffix(String str) {
        this.f4328l = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final void setStreamActivityMonitorId(String str) {
        this.f4331o = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final void setUseQAStreamBaseUrl(Boolean bool) {
        this.f4333q = bool;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamRequest
    public final void setUserRequestContext(Object obj) {
        this.f4334r = obj;
    }
}

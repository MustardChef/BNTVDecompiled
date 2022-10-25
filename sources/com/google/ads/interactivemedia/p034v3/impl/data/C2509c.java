package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.AdPodInfo;
import com.google.ads.interactivemedia.p034v3.api.CompanionAd;
import com.google.ads.interactivemedia.p034v3.api.IMASDK;
import com.google.ads.interactivemedia.p034v3.api.UiElement;
import com.google.ads.interactivemedia.p034v3.api.UniversalAdId;
import com.google.ads.interactivemedia.p034v3.internal.brf;
import com.google.ads.interactivemedia.p034v3.internal.brg;
import com.google.ads.interactivemedia.p034v3.internal.brh;
import com.google.ads.interactivemedia.p034v3.internal.bri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.c */
/* loaded from: classes2.dex */
public final class C2509c implements IMASDK {
    private String adId;
    private String adSystem;
    @bri
    @brg
    private String[] adWrapperCreativeIds;
    @bri
    @brg
    private String[] adWrapperIds;
    @bri
    @brg
    private String[] adWrapperSystems;
    private String advertiserName;
    private String clickThroughUrl;
    @bri
    @brg
    private List<CompanionAdImpl> companions;
    private String contentType;
    private String creativeAdId;
    private String creativeId;
    private String dealId;
    private String description;
    private boolean disableUi;
    private double duration;
    private int height;
    private String surveyUrl;
    private String title;
    private String traffickingParameters;
    @bri
    @brg
    private Set<UiElement> uiElements;
    private String universalAdIdRegistry;
    private String universalAdIdValue;
    @bri
    @brg
    private C2510ca[] universalAdIds;
    private int vastMediaBitrate;
    private int vastMediaHeight;
    private int vastMediaWidth;
    private int width;
    private boolean linear = false;
    private boolean skippable = false;
    private double skipTimeOffset = -1.0d;
    @bri
    @brg
    private C2513d adPodInfo = new C2513d();

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return brf.m2729c(this, obj, "vastMediaBitrate", "vastMediaHeight", "vastMediaWidth");
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getAdId() {
        return this.adId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public AdPodInfo getAdPodInfo() {
        return this.adPodInfo;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getAdSystem() {
        return this.adSystem;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String[] getAdWrapperCreativeIds() {
        return this.adWrapperCreativeIds;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String[] getAdWrapperIds() {
        return this.adWrapperIds;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String[] getAdWrapperSystems() {
        return this.adWrapperSystems;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getAdvertiserName() {
        return this.advertiserName;
    }

    public String getClickThruUrl() {
        return this.clickThroughUrl;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public List<CompanionAd> getCompanionAds() {
        ArrayList arrayList = new ArrayList();
        List<CompanionAdImpl> list = this.companions;
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getContentType() {
        return this.contentType;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getCreativeAdId() {
        return this.creativeAdId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getCreativeId() {
        return this.creativeId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getDealId() {
        return this.dealId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getDescription() {
        return this.description;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public double getDuration() {
        return this.duration;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public int getHeight() {
        return this.height;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public double getSkipTimeOffset() {
        return this.skipTimeOffset;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getSurveyUrl() {
        return this.surveyUrl;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getTitle() {
        return this.title;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getTraffickingParameters() {
        return this.traffickingParameters;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public Set<UiElement> getUiElements() {
        return this.uiElements;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getUniversalAdIdRegistry() {
        return this.universalAdIdRegistry;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public String getUniversalAdIdValue() {
        return this.universalAdIdValue;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public UniversalAdId[] getUniversalAdIds() {
        return this.universalAdIds;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public int getVastMediaBitrate() {
        return this.vastMediaBitrate;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public int getVastMediaHeight() {
        return this.vastMediaHeight;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public int getVastMediaWidth() {
        return this.vastMediaWidth;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return brh.m2722a(this, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public boolean isLinear() {
        return this.linear;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public boolean isSkippable() {
        return this.skippable;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.IMASDK
    public boolean isUiDisabled() {
        return this.disableUi;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdPodInfo(C2513d c2513d) {
        this.adPodInfo = c2513d;
    }

    public void setAdSystem(String str) {
        this.adSystem = str;
    }

    public void setAdWrapperCreativeIds(String[] strArr) {
        this.adWrapperCreativeIds = strArr;
    }

    public void setAdWrapperIds(String[] strArr) {
        this.adWrapperIds = strArr;
    }

    public void setAdWrapperSystems(String[] strArr) {
        this.adWrapperSystems = strArr;
    }

    public void setAdvertiserName(String str) {
        this.advertiserName = str;
    }

    public void setClickThruUrl(String str) {
        this.clickThroughUrl = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setCreativeAdId(String str) {
        this.creativeAdId = str;
    }

    public void setCreativeId(String str) {
        this.creativeId = str;
    }

    public void setDealId(String str) {
        this.dealId = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDuration(double d) {
        this.duration = d;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setLinear(boolean z) {
        this.linear = z;
    }

    public void setSkipTimeOffset(double d) {
        this.skipTimeOffset = d;
    }

    public void setSkippable(boolean z) {
        this.skippable = z;
    }

    public void setSurveyUrl(String str) {
        this.surveyUrl = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTraffickingParameters(String str) {
        this.traffickingParameters = str;
    }

    public void setUiDisabled(boolean z) {
        this.disableUi = z;
    }

    public void setUiElements(Set<UiElement> set) {
        this.uiElements = set;
    }

    public void setUniversalAdIdRegistry(String str) {
        this.universalAdIdRegistry = str;
    }

    public void setUniversalAdIdValue(String str) {
        this.universalAdIdValue = str;
    }

    public void setUniversalAdIds(C2510ca[] c2510caArr) {
        this.universalAdIds = c2510caArr;
    }

    public void setVastMediaBitrate(int i) {
        this.vastMediaBitrate = i;
    }

    public void setVastMediaHeight(int i) {
        this.vastMediaHeight = i;
    }

    public void setVastMediaWidth(int i) {
        this.vastMediaWidth = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        String str = this.adId;
        String str2 = this.creativeId;
        String str3 = this.creativeAdId;
        String str4 = this.universalAdIdValue;
        String str5 = this.universalAdIdRegistry;
        String str6 = this.title;
        String str7 = this.description;
        String str8 = this.contentType;
        String arrays = Arrays.toString(this.adWrapperIds);
        String arrays2 = Arrays.toString(this.adWrapperSystems);
        String arrays3 = Arrays.toString(this.adWrapperCreativeIds);
        String str9 = this.adSystem;
        String str10 = this.advertiserName;
        String str11 = this.surveyUrl;
        String str12 = this.dealId;
        boolean z = this.linear;
        boolean z2 = this.skippable;
        int i = this.width;
        int i2 = this.height;
        int i3 = this.vastMediaHeight;
        int i4 = this.vastMediaWidth;
        int i5 = this.vastMediaBitrate;
        String str13 = this.traffickingParameters;
        String str14 = this.clickThroughUrl;
        double d = this.duration;
        String valueOf = String.valueOf(this.adPodInfo);
        String valueOf2 = String.valueOf(this.uiElements);
        boolean z3 = this.disableUi;
        double d2 = this.skipTimeOffset;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        int length3 = String.valueOf(str3).length();
        int length4 = String.valueOf(str4).length();
        int length5 = String.valueOf(str5).length();
        int length6 = String.valueOf(str6).length();
        int length7 = String.valueOf(str7).length();
        int length8 = String.valueOf(str8).length();
        int length9 = String.valueOf(arrays).length();
        int length10 = String.valueOf(arrays2).length();
        int length11 = String.valueOf(arrays3).length();
        int length12 = String.valueOf(str9).length();
        int length13 = String.valueOf(str10).length();
        int length14 = String.valueOf(str11).length();
        int length15 = String.valueOf(str12).length();
        int length16 = String.valueOf(str13).length();
        int length17 = String.valueOf(str14).length();
        StringBuilder sb = new StringBuilder(length + 542 + length2 + length3 + length4 + length5 + length6 + length7 + length8 + length9 + length10 + length11 + length12 + length13 + length14 + length15 + length16 + length17 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
        sb.append("Ad [adId=");
        sb.append(str);
        sb.append(", creativeId=");
        sb.append(str2);
        sb.append(", creativeAdId=");
        sb.append(str3);
        sb.append(", universalAdIdValue=");
        sb.append(str4);
        sb.append(", universalAdIdRegistry=");
        sb.append(str5);
        sb.append(", title=");
        sb.append(str6);
        sb.append(", description=");
        sb.append(str7);
        sb.append(", contentType=");
        sb.append(str8);
        sb.append(", adWrapperIds=");
        sb.append(arrays);
        sb.append(", adWrapperSystems=");
        sb.append(arrays2);
        sb.append(", adWrapperCreativeIds=");
        sb.append(arrays3);
        sb.append(", adSystem=");
        sb.append(str9);
        sb.append(", advertiserName=");
        sb.append(str10);
        sb.append(", surveyUrl=");
        sb.append(str11);
        sb.append(", dealId=");
        sb.append(str12);
        sb.append(", linear=");
        sb.append(z);
        sb.append(", skippable=");
        sb.append(z2);
        sb.append(", width=");
        sb.append(i);
        sb.append(", height=");
        sb.append(i2);
        sb.append(", vastMediaHeight=");
        sb.append(i3);
        sb.append(", vastMediaWidth=");
        sb.append(i4);
        sb.append(", vastMediaBitrate=");
        sb.append(i5);
        sb.append(", traffickingParameters=");
        sb.append(str13);
        sb.append(", clickThroughUrl=");
        sb.append(str14);
        sb.append(", duration=");
        sb.append(d);
        sb.append(", adPodInfo=");
        sb.append(valueOf);
        sb.append(", uiElements=");
        sb.append(valueOf2);
        sb.append(", disableUi=");
        sb.append(z3);
        sb.append(", skipTimeOffset=");
        sb.append(d2);
        sb.append("]");
        return sb.toString();
    }
}

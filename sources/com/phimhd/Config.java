package com.phimhd;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class Config {
    @SerializedName("approvedApp")
    boolean approvedApp;
    @SerializedName("config")
    String config;
    @SerializedName("defaultContentPopUpAds")
    String defaultContentPopUpAds;
    @SerializedName("idPlayerToGetLink")
    String idPlayerToGetLink;
    @SerializedName("isBanned")
    String isBanned;
    @SerializedName("isPermitFullscreen")
    String isPermitFullscreen;
    @SerializedName("isRequired")
    boolean isRequired;
    @SerializedName("streamByWebEmbed")
    boolean isStreamByWebEmbed;
    @SerializedName(SDKConstants.PARAM_KEY)
    String key;
    @SerializedName("listBanners")
    ArrayList<Banner> listBanners;
    @SerializedName("listServers")
    String listServers;
    @SerializedName("movieOnlyForPremium")
    boolean movieOnlyForPremium;
    @SerializedName("needToGetLink")
    String needToGetLink;
    @SerializedName("phone")
    String phone;
    @SerializedName("premium")
    String premium;
    @SerializedName("showUpgradeMethod")
    boolean showUpgradeMethod;
    @SerializedName("token")
    String token;
    @SerializedName("unlimited")
    String unlimited;
    @SerializedName("urlApiGetStream")
    String urlApiGetStream;
    @SerializedName("urlImagePoster")
    String urlImagePoster;
    @SerializedName("urlPaymentMomo")
    String urlPaymentMomo;
    @SerializedName("urlPaymentPaypal")
    String urlPaymentPaypal;
    @SerializedName("urlPrivacy")
    String urlPrivacy;
    @SerializedName("urlRedirectPoster")
    String urlRedirectPoster;
    @SerializedName("value")
    String value;
    @SerializedName("vast")
    String vast;
    @SerializedName(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION)
    float version;
    @SerializedName("watchAdsToAccessPremiumMovie")
    boolean watchAdsToAccessPremiumMovie;

    public String getIsPermitFullscreen() {
        return this.isPermitFullscreen;
    }

    public ArrayList<Banner> getListBanners() {
        return this.listBanners;
    }

    public void setListBanners(ArrayList<Banner> arrayList) {
        this.listBanners = arrayList;
    }

    public float getVersion() {
        return this.version;
    }

    public void setVersion(float f) {
        this.version = f;
    }

    public boolean getApprovedApp() {
        return this.approvedApp;
    }

    public void setApprovedApp(boolean z) {
        this.approvedApp = z;
    }

    public void setIsPermitFullscreen(String str) {
        this.isPermitFullscreen = str;
    }

    public String getIdPlayerToGetLink() {
        return this.idPlayerToGetLink;
    }

    public void setIdPlayerToGetLink(String str) {
        this.idPlayerToGetLink = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getDefaultContentPopUpAds() {
        return this.defaultContentPopUpAds;
    }

    public void setDefaultContentPopUpAds(String str) {
        this.defaultContentPopUpAds = str;
    }

    public boolean isShowUpgradeMethod() {
        return this.showUpgradeMethod;
    }

    public void setShowUpgradeMethod(boolean z) {
        this.showUpgradeMethod = z;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getUrlPaymentMomo() {
        return this.urlPaymentMomo;
    }

    public void setUrlPaymentMomo(String str) {
        this.urlPaymentMomo = str;
    }

    public String getUrlPaymentPaypal() {
        return this.urlPaymentPaypal;
    }

    public void setUrlPaymentPaypal(String str) {
        this.urlPaymentPaypal = str;
    }

    public String getNeedToGetLink() {
        return this.needToGetLink;
    }

    public void setNeedToGetLink(String str) {
        this.needToGetLink = str;
    }

    public String getUrlImagePoster() {
        return this.urlImagePoster;
    }

    public String isBanned() {
        return this.isBanned;
    }

    public String getVast() {
        return this.vast;
    }

    public void setVast(String str) {
        this.vast = str;
    }

    public String getUrlPrivacy() {
        return this.urlPrivacy;
    }

    public void setUrlPrivacy(String str) {
        this.urlPrivacy = str;
    }

    public void setBanned(String str) {
        this.isBanned = str;
    }

    public void setUrlImagePoster(String str) {
        this.urlImagePoster = str;
    }

    public String getUrlRedirectPoster() {
        return this.urlRedirectPoster;
    }

    public void setUrlRedirectPoster(String str) {
        this.urlRedirectPoster = str;
    }

    public boolean isWatchAdsToAccessPremiumMovie() {
        return this.watchAdsToAccessPremiumMovie;
    }

    public void setWatchAdsToAccessPremiumMovie(boolean z) {
        this.watchAdsToAccessPremiumMovie = z;
    }

    public boolean isMovieOnlyForPremium() {
        return this.movieOnlyForPremium;
    }

    public void setMovieOnlyForPremium(boolean z) {
        this.movieOnlyForPremium = z;
    }

    public String getListServers() {
        return this.listServers;
    }

    public void setListServers(String str) {
        this.listServers = str;
    }

    public boolean isStreamByWebEmbed() {
        return this.isStreamByWebEmbed;
    }

    public String getPremium() {
        return this.premium;
    }

    public void setPremium(String str) {
        this.premium = str;
    }

    public String getUnlimited() {
        return this.unlimited;
    }

    public void setUnlimited(String str) {
        this.unlimited = str;
    }

    public void setStreamByWebEmbed(boolean z) {
        this.isStreamByWebEmbed = z;
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public String getConfig() {
        return this.config;
    }

    public void setConfig(String str) {
        this.config = str;
    }

    public String getUrlApiGetStream() {
        return this.urlApiGetStream;
    }

    public void setUrlApiGetStream(String str) {
        this.urlApiGetStream = str;
    }

    public void setRequired(boolean z) {
        this.isRequired = z;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }
}

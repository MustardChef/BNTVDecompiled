package com.phimhd;

import com.facebook.appevents.UserDataStore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class LocaleIP {
    @SerializedName("as")
    @Expose

    /* renamed from: as */
    private String f10041as;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName(UserDataStore.COUNTRY)
    @Expose
    private String country;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("isp")
    @Expose
    private String isp;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("org")
    @Expose

    /* renamed from: org  reason: collision with root package name */
    private String f10827org;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName(TtmlNode.TAG_REGION)
    @Expose
    private String region;
    @SerializedName("regionName")
    @Expose
    private String regionName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("zip")
    @Expose
    private String zip;

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public String getAs() {
        return this.f10041as;
    }

    public void setAs(String str) {
        this.f10041as = str;
    }

    public String getOrg() {
        return this.f10827org;
    }

    public void setOrg(String str) {
        this.f10827org = str;
    }

    public String getIsp() {
        return this.isp;
    }

    public void setIsp(String str) {
        this.isp = str;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public double getLon() {
        return this.lon;
    }

    public void setLon(double d) {
        this.lon = d;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String str) {
        this.zip = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}

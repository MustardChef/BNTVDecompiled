package com.phimhd;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class Key {
    @SerializedName("_id")
    private String _id;
    private long createdTime;
    private long expiredTime;
    @SerializedName(SDKConstants.PARAM_KEY)
    private String key;
    @SerializedName("phone")
    private String phone;
    @SerializedName("token")
    private String token;

    public boolean isExpired() {
        return this.expiredTime != -1 && System.currentTimeMillis() >= this.expiredTime;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String str) {
        this._id = str;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(long j) {
        this.createdTime = j;
    }

    public long getExpiredTime() {
        return this.expiredTime;
    }

    public void setExpiredTime(long j) {
        this.expiredTime = j;
    }
}

package com.phimhd;

/* loaded from: classes4.dex */
public class User {
    String _id;
    String fbId;
    boolean isActive;
    Key key;
    String keyId;
    String name;
    String token;
    String tokenFCM;
    String urlPhoto;

    public String getTokenFCM() {
        return this.tokenFCM;
    }

    public void setTokenFCM(String str) {
        this.tokenFCM = str;
    }

    public Key getKey() {
        return this.key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String str) {
        this._id = str;
    }

    public String getFbId() {
        return this.fbId;
    }

    public void setFbId(String str) {
        this.fbId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUrlPhoto() {
        return this.urlPhoto;
    }

    public void setUrlPhoto(String str) {
        this.urlPhoto = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean z) {
        this.isActive = z;
    }
}

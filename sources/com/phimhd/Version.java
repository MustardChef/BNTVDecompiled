package com.phimhd;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class Version {
    String description;
    boolean isRequired;
    String linkApk;
    int typeUpdate;
    @SerializedName("value")
    String version;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public int getTypeUpdate() {
        return this.typeUpdate;
    }

    public void setTypeUpdate(int i) {
        this.typeUpdate = i;
    }

    public String getLinkApk() {
        return this.linkApk;
    }

    public void setLinkApk(String str) {
        this.linkApk = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public void setRequired(boolean z) {
        this.isRequired = z;
    }
}

package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.CompanionAd;
import com.google.ads.interactivemedia.p034v3.internal.brf;
import com.google.ads.interactivemedia.p034v3.internal.brh;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.CompanionAdImpl */
/* loaded from: classes2.dex */
public class CompanionAdImpl implements CompanionAd {
    private String apiFramework;
    private String resourceValue;
    private AbstractC2505bw size = AbstractC2505bw.create(0, 0);

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return brf.m2729c(this, obj, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAd
    public String getApiFramework() {
        return this.apiFramework;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAd
    public int getHeight() {
        return this.size.height().intValue();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAd
    public String getResourceValue() {
        return this.resourceValue;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CompanionAd
    public int getWidth() {
        return this.size.width().intValue();
    }

    public int hashCode() {
        return brh.m2722a(this, new String[0]);
    }

    void setApiFramework(String str) {
        this.apiFramework = str;
    }

    void setResourceValue(String str) {
        this.resourceValue = str;
    }

    void setSize(AbstractC2505bw abstractC2505bw) {
        this.size = abstractC2505bw;
    }

    public String toString() {
        String str = this.apiFramework;
        String str2 = this.resourceValue;
        String valueOf = String.valueOf(this.size.width());
        String valueOf2 = String.valueOf(this.size.height());
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 58 + length2 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
        sb.append("CompanionAd [apiFramework=");
        sb.append(str);
        sb.append(", resourceUrl=");
        sb.append(str2);
        sb.append(", width=");
        sb.append(valueOf);
        sb.append(", height=");
        sb.append(valueOf2);
        sb.append("]");
        return sb.toString();
    }
}

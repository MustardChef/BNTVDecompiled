package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.UniversalAdId;
import com.google.ads.interactivemedia.p034v3.internal.brf;
import com.google.ads.interactivemedia.p034v3.internal.brh;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ca */
/* loaded from: classes2.dex */
public final class C2510ca implements UniversalAdId {
    private String adIdValue = "unknown";
    private String adIdRegistry = "unknown";

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return brf.m2729c(this, obj, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.UniversalAdId
    public String getAdIdRegistry() {
        return this.adIdRegistry;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.UniversalAdId
    public String getAdIdValue() {
        return this.adIdValue;
    }

    public int hashCode() {
        return brh.m2722a(this, new String[0]);
    }

    public void setAdIdRegistry(String str) {
        this.adIdRegistry = str;
    }

    public void setAdIdValue(String str) {
        this.adIdValue = str;
    }

    public String toString() {
        String str = this.adIdValue;
        String str2 = this.adIdRegistry;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41 + String.valueOf(str2).length());
        sb.append("UniversalAdId [adIdValue=");
        sb.append(str);
        sb.append(", adIdRegistry=");
        sb.append(str2);
        sb.append("]");
        return sb.toString();
    }
}

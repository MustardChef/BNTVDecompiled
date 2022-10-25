package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.AdPodInfo;
import com.google.ads.interactivemedia.p034v3.internal.brf;
import com.google.ads.interactivemedia.p034v3.internal.brh;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.d */
/* loaded from: classes2.dex */
public final class C2513d implements AdPodInfo {
    public int podIndex;
    public double timeOffset;
    public int totalAds = 1;
    public int adPosition = 1;
    public boolean isBumper = false;
    public double maxDuration = -1.0d;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return brf.m2729c(this, obj, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdPodInfo
    public int getAdPosition() {
        return this.adPosition;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdPodInfo
    public double getMaxDuration() {
        return this.maxDuration;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdPodInfo
    public int getPodIndex() {
        return this.podIndex;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdPodInfo
    public double getTimeOffset() {
        return this.timeOffset;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdPodInfo
    public int getTotalAds() {
        return this.totalAds;
    }

    public int hashCode() {
        return brh.m2722a(this, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdPodInfo
    public boolean isBumper() {
        return this.isBumper;
    }

    public String toString() {
        int i = this.totalAds;
        int i2 = this.adPosition;
        boolean z = this.isBumper;
        double d = this.maxDuration;
        int i3 = this.podIndex;
        double d2 = this.timeOffset;
        StringBuilder sb = new StringBuilder(169);
        sb.append("AdPodInfo [totalAds=");
        sb.append(i);
        sb.append(", adPosition=");
        sb.append(i2);
        sb.append(", isBumper=");
        sb.append(z);
        sb.append(", maxDuration=");
        sb.append(d);
        sb.append(", podIndex=");
        sb.append(i3);
        sb.append(", timeOffset=");
        sb.append(d2);
        sb.append("]");
        return sb.toString();
    }
}

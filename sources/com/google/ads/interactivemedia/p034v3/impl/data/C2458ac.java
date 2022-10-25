package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ac */
/* loaded from: classes2.dex */
public final class C2458ac extends AbstractC2490bh {
    private final String appSetId;
    private final int appSetIdScope;
    private final String deviceId;
    private final String idType;
    private final boolean isLimitedAdTracking;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2458ac(String str, String str2, boolean z, String str3, int i) {
        Objects.requireNonNull(str, "Null deviceId");
        this.deviceId = str;
        Objects.requireNonNull(str2, "Null idType");
        this.idType = str2;
        this.isLimitedAdTracking = z;
        Objects.requireNonNull(str3, "Null appSetId");
        this.appSetId = str3;
        this.appSetIdScope = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh
    public String appSetId() {
        return this.appSetId;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh
    public int appSetIdScope() {
        return this.appSetIdScope;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh
    public String deviceId() {
        return this.deviceId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2490bh) {
            AbstractC2490bh abstractC2490bh = (AbstractC2490bh) obj;
            if (this.deviceId.equals(abstractC2490bh.deviceId()) && this.idType.equals(abstractC2490bh.idType()) && this.isLimitedAdTracking == abstractC2490bh.isLimitedAdTracking() && this.appSetId.equals(abstractC2490bh.appSetId()) && this.appSetIdScope == abstractC2490bh.appSetIdScope()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.deviceId.hashCode() ^ 1000003) * 1000003) ^ this.idType.hashCode()) * 1000003) ^ (true != this.isLimitedAdTracking ? 1237 : 1231)) * 1000003) ^ this.appSetId.hashCode()) * 1000003) ^ this.appSetIdScope;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh
    public String idType() {
        return this.idType;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2490bh
    public boolean isLimitedAdTracking() {
        return this.isLimitedAdTracking;
    }

    public String toString() {
        String str = this.deviceId;
        String str2 = this.idType;
        boolean z = this.isLimitedAdTracking;
        String str3 = this.appSetId;
        int i = this.appSetIdScope;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 99 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("IdentifierInfo{deviceId=");
        sb.append(str);
        sb.append(", idType=");
        sb.append(str2);
        sb.append(", isLimitedAdTracking=");
        sb.append(z);
        sb.append(", appSetId=");
        sb.append(str3);
        sb.append(", appSetIdScope=");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }
}

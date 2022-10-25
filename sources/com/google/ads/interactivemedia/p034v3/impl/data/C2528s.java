package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.s */
/* loaded from: classes2.dex */
public final class C2528s extends AbstractC2481az {
    private final String addtlConsent;
    private final String gdprApplies;
    private final String tcString;
    private final String uspString;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2528s(String str, String str2, String str3, String str4) {
        Objects.requireNonNull(str, "Null gdprApplies");
        this.gdprApplies = str;
        Objects.requireNonNull(str2, "Null tcString");
        this.tcString = str2;
        Objects.requireNonNull(str3, "Null addtlConsent");
        this.addtlConsent = str3;
        Objects.requireNonNull(str4, "Null uspString");
        this.uspString = str4;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2481az
    public String addtlConsent() {
        return this.addtlConsent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2481az) {
            AbstractC2481az abstractC2481az = (AbstractC2481az) obj;
            if (this.gdprApplies.equals(abstractC2481az.gdprApplies()) && this.tcString.equals(abstractC2481az.tcString()) && this.addtlConsent.equals(abstractC2481az.addtlConsent()) && this.uspString.equals(abstractC2481az.uspString())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2481az
    public String gdprApplies() {
        return this.gdprApplies;
    }

    public int hashCode() {
        return ((((((this.gdprApplies.hashCode() ^ 1000003) * 1000003) ^ this.tcString.hashCode()) * 1000003) ^ this.addtlConsent.hashCode()) * 1000003) ^ this.uspString.hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2481az
    public String tcString() {
        return this.tcString;
    }

    public String toString() {
        String str = this.gdprApplies;
        String str2 = this.tcString;
        String str3 = this.addtlConsent;
        String str4 = this.uspString;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 67 + length2 + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("ConsentSettings{gdprApplies=");
        sb.append(str);
        sb.append(", tcString=");
        sb.append(str2);
        sb.append(", addtlConsent=");
        sb.append(str3);
        sb.append(", uspString=");
        sb.append(str4);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2481az
    public String uspString() {
        return this.uspString;
    }
}

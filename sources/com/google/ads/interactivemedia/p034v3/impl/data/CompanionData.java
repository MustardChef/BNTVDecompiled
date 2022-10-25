package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2527r.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.CompanionData */
/* loaded from: classes2.dex */
public abstract class CompanionData {
    private String companionId;

    private static CompanionData create(String str, String str2, String str3, EnumC2480ay enumC2480ay) {
        return new C2527r(str, str2, str3, enumC2480ay);
    }

    public abstract String clickThroughUrl();

    public String companionId() {
        return this.companionId;
    }

    public abstract String size();

    public abstract String src();

    public final String toString() {
        String companionId = companionId();
        String size = size();
        String src = src();
        String clickThroughUrl = clickThroughUrl();
        String valueOf = String.valueOf(type());
        int length = String.valueOf(companionId).length();
        int length2 = String.valueOf(size).length();
        int length3 = String.valueOf(src).length();
        StringBuilder sb = new StringBuilder(length + 66 + length2 + length3 + String.valueOf(clickThroughUrl).length() + String.valueOf(valueOf).length());
        sb.append("CompanionData [companionId=");
        sb.append(companionId);
        sb.append(", size=");
        sb.append(size);
        sb.append(", src=");
        sb.append(src);
        sb.append(", clickThroughUrl=");
        sb.append(clickThroughUrl);
        sb.append(", type=");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public abstract EnumC2480ay type();

    public static CompanionData create(String str, String str2, String str3, String str4, EnumC2480ay enumC2480ay) {
        CompanionData create = create(str2, str3, str4, enumC2480ay);
        create.companionId = str;
        return create;
    }
}

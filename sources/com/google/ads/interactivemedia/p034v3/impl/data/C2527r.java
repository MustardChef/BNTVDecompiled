package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.r */
/* loaded from: classes2.dex */
final class C2527r extends CompanionData {
    private final String clickThroughUrl;
    private final String size;
    private final String src;
    private final EnumC2480ay type;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2527r(String str, String str2, String str3, EnumC2480ay enumC2480ay) {
        Objects.requireNonNull(str, "Null size");
        this.size = str;
        Objects.requireNonNull(str2, "Null src");
        this.src = str2;
        Objects.requireNonNull(str3, "Null clickThroughUrl");
        this.clickThroughUrl = str3;
        Objects.requireNonNull(enumC2480ay, "Null type");
        this.type = enumC2480ay;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.CompanionData
    public String clickThroughUrl() {
        return this.clickThroughUrl;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompanionData) {
            CompanionData companionData = (CompanionData) obj;
            if (this.size.equals(companionData.size()) && this.src.equals(companionData.src()) && this.clickThroughUrl.equals(companionData.clickThroughUrl()) && this.type.equals(companionData.type())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.size.hashCode() ^ 1000003) * 1000003) ^ this.src.hashCode()) * 1000003) ^ this.clickThroughUrl.hashCode()) * 1000003) ^ this.type.hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.CompanionData
    public String size() {
        return this.size;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.CompanionData
    public String src() {
        return this.src;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.CompanionData
    public EnumC2480ay type() {
        return this.type;
    }
}

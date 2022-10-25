package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ag */
/* loaded from: classes2.dex */
public final class C2462ag extends AbstractC2500br {
    private final String content;
    private final String contentType;
    private final int errorCode;

    /* renamed from: id */
    private final String f2850id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2462ag(String str, String str2, String str3, int i) {
        Objects.requireNonNull(str, "Null id");
        this.f2850id = str;
        Objects.requireNonNull(str2, "Null content");
        this.content = str2;
        Objects.requireNonNull(str3, "Null contentType");
        this.contentType = str3;
        this.errorCode = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br
    public String content() {
        return this.content;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br
    public String contentType() {
        return this.contentType;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2500br) {
            AbstractC2500br abstractC2500br = (AbstractC2500br) obj;
            if (this.f2850id.equals(abstractC2500br.mo6001id()) && this.content.equals(abstractC2500br.content()) && this.contentType.equals(abstractC2500br.contentType()) && this.errorCode == abstractC2500br.errorCode()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br
    public int errorCode() {
        return this.errorCode;
    }

    public int hashCode() {
        return ((((((this.f2850id.hashCode() ^ 1000003) * 1000003) ^ this.content.hashCode()) * 1000003) ^ this.contentType.hashCode()) * 1000003) ^ this.errorCode;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2500br
    /* renamed from: id */
    public String mo6001id() {
        return this.f2850id;
    }

    public String toString() {
        String str = this.f2850id;
        String str2 = this.content;
        String str3 = this.contentType;
        int i = this.errorCode;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 71 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("NetworkResponseData{id=");
        sb.append(str);
        sb.append(", content=");
        sb.append(str2);
        sb.append(", contentType=");
        sb.append(str3);
        sb.append(", errorCode=");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }
}

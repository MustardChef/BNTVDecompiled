package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.af */
/* loaded from: classes2.dex */
final class C2461af extends AbstractC2499bq {
    private final int connectionTimeoutMs;
    private final String content;

    /* renamed from: id */
    private final String f2849id;
    private final int readTimeoutMs;
    private final EnumC2498bp requestType;
    private final String url;
    private final String userAgent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2461af(EnumC2498bp enumC2498bp, String str, String str2, String str3, String str4, int i, int i2) {
        Objects.requireNonNull(enumC2498bp, "Null requestType");
        this.requestType = enumC2498bp;
        Objects.requireNonNull(str, "Null id");
        this.f2849id = str;
        Objects.requireNonNull(str2, "Null url");
        this.url = str2;
        this.content = str3;
        Objects.requireNonNull(str4, "Null userAgent");
        this.userAgent = str4;
        this.connectionTimeoutMs = i;
        this.readTimeoutMs = i2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq
    public int connectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq
    public String content() {
        return this.content;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2499bq) {
            AbstractC2499bq abstractC2499bq = (AbstractC2499bq) obj;
            if (this.requestType.equals(abstractC2499bq.requestType()) && this.f2849id.equals(abstractC2499bq.mo6002id()) && this.url.equals(abstractC2499bq.url()) && ((str = this.content) != null ? str.equals(abstractC2499bq.content()) : abstractC2499bq.content() == null) && this.userAgent.equals(abstractC2499bq.userAgent()) && this.connectionTimeoutMs == abstractC2499bq.connectionTimeoutMs() && this.readTimeoutMs == abstractC2499bq.readTimeoutMs()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((this.requestType.hashCode() ^ 1000003) * 1000003) ^ this.f2849id.hashCode()) * 1000003) ^ this.url.hashCode()) * 1000003;
        String str = this.content;
        return ((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.userAgent.hashCode()) * 1000003) ^ this.connectionTimeoutMs) * 1000003) ^ this.readTimeoutMs;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq
    /* renamed from: id */
    public String mo6002id() {
        return this.f2849id;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq
    public int readTimeoutMs() {
        return this.readTimeoutMs;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq
    public EnumC2498bp requestType() {
        return this.requestType;
    }

    public String toString() {
        String valueOf = String.valueOf(this.requestType);
        String str = this.f2849id;
        String str2 = this.url;
        String str3 = this.content;
        String str4 = this.userAgent;
        int i = this.connectionTimeoutMs;
        int i2 = this.readTimeoutMs;
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(str).length();
        int length3 = String.valueOf(str2).length();
        StringBuilder sb = new StringBuilder(length + 125 + length2 + length3 + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NetworkRequestData{requestType=");
        sb.append(valueOf);
        sb.append(", id=");
        sb.append(str);
        sb.append(", url=");
        sb.append(str2);
        sb.append(", content=");
        sb.append(str3);
        sb.append(", userAgent=");
        sb.append(str4);
        sb.append(", connectionTimeoutMs=");
        sb.append(i);
        sb.append(", readTimeoutMs=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq
    public String url() {
        return this.url;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2499bq
    public String userAgent() {
        return this.userAgent;
    }
}

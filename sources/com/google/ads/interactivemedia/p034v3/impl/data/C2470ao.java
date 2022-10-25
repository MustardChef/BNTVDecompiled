package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ao */
/* loaded from: classes2.dex */
public final class C2470ao extends AbstractC2505bw {
    private final Integer height;
    private final Integer width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2470ao(Integer num, Integer num2) {
        Objects.requireNonNull(num, "Null width");
        this.width = num;
        Objects.requireNonNull(num2, "Null height");
        this.height = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2505bw) {
            AbstractC2505bw abstractC2505bw = (AbstractC2505bw) obj;
            if (this.width.equals(abstractC2505bw.width()) && this.height.equals(abstractC2505bw.height())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.width.hashCode() ^ 1000003) * 1000003) ^ this.height.hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2505bw
    public Integer height() {
        return this.height;
    }

    public String toString() {
        String valueOf = String.valueOf(this.width);
        String valueOf2 = String.valueOf(this.height);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25 + String.valueOf(valueOf2).length());
        sb.append("SizeData{width=");
        sb.append(valueOf);
        sb.append(", height=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2505bw
    public Integer width() {
        return this.width;
    }
}

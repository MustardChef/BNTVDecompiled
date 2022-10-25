package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aiy */
/* loaded from: classes2.dex */
final class aiy extends akt {
    private final String TXXX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aiy(String str) {
        Objects.requireNonNull(str, "Null TXXX");
        this.TXXX = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akt
    String TXXX() {
        return this.TXXX;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof akt) {
            return this.TXXX.equals(((akt) obj).TXXX());
        }
        return false;
    }

    public int hashCode() {
        return this.TXXX.hashCode() ^ 1000003;
    }

    public String toString() {
        String str = this.TXXX;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 28);
        sb.append("TimedMetadataWithKeys{TXXX=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}

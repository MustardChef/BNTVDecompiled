package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aix */
/* loaded from: classes2.dex */
public final class aix extends aio {
    private final int appVersion;
    private final String packageName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aix(int i, String str) {
        this.appVersion = i;
        Objects.requireNonNull(str, "Null packageName");
        this.packageName = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aio
    public int appVersion() {
        return this.appVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aio) {
            aio aioVar = (aio) obj;
            if (this.appVersion == aioVar.appVersion() && this.packageName.equals(aioVar.packageName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.appVersion ^ 1000003) * 1000003) ^ this.packageName.hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aio
    public String packageName() {
        return this.packageName;
    }

    public String toString() {
        int i = this.appVersion;
        String str = this.packageName;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("MarketAppInfo{appVersion=");
        sb.append(i);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}

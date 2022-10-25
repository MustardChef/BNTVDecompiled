package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.u */
/* loaded from: classes2.dex */
public final class C2530u extends AbstractC2484bb {
    private final AbstractC2485bc adapterVersion;
    private final String name;
    private final AbstractC2485bc sdkVersion;
    private final String signals;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2530u(AbstractC2485bc abstractC2485bc, AbstractC2485bc abstractC2485bc2, String str, String str2) {
        Objects.requireNonNull(abstractC2485bc, "Null adapterVersion");
        this.adapterVersion = abstractC2485bc;
        Objects.requireNonNull(abstractC2485bc2, "Null sdkVersion");
        this.sdkVersion = abstractC2485bc2;
        Objects.requireNonNull(str, "Null name");
        this.name = str;
        Objects.requireNonNull(str2, "Null signals");
        this.signals = str2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2484bb
    public AbstractC2485bc adapterVersion() {
        return this.adapterVersion;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2484bb) {
            AbstractC2484bb abstractC2484bb = (AbstractC2484bb) obj;
            if (this.adapterVersion.equals(abstractC2484bb.adapterVersion()) && this.sdkVersion.equals(abstractC2484bb.sdkVersion()) && this.name.equals(abstractC2484bb.name()) && this.signals.equals(abstractC2484bb.signals())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.adapterVersion.hashCode() ^ 1000003) * 1000003) ^ this.sdkVersion.hashCode()) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.signals.hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2484bb
    public String name() {
        return this.name;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2484bb
    public AbstractC2485bc sdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2484bb
    public String signals() {
        return this.signals;
    }

    public String toString() {
        String valueOf = String.valueOf(this.adapterVersion);
        String valueOf2 = String.valueOf(this.sdkVersion);
        String str = this.name;
        String str2 = this.signals;
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 60 + length2 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb.append("EspSignalData{adapterVersion=");
        sb.append(valueOf);
        sb.append(", sdkVersion=");
        sb.append(valueOf2);
        sb.append(", name=");
        sb.append(str);
        sb.append(", signals=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}

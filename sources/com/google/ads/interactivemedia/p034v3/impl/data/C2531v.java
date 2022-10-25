package com.google.ads.interactivemedia.p034v3.impl.data;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.v */
/* loaded from: classes2.dex */
public final class C2531v extends AbstractC2485bc {
    private final int major;
    private final int micro;
    private final int minor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2531v(int i, int i2, int i3) {
        this.major = i;
        this.minor = i2;
        this.micro = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2485bc) {
            AbstractC2485bc abstractC2485bc = (AbstractC2485bc) obj;
            if (this.major == abstractC2485bc.major() && this.minor == abstractC2485bc.minor() && this.micro == abstractC2485bc.micro()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.major ^ 1000003) * 1000003) ^ this.minor) * 1000003) ^ this.micro;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2485bc
    public int major() {
        return this.major;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2485bc
    public int micro() {
        return this.micro;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2485bc
    public int minor() {
        return this.minor;
    }

    public String toString() {
        int i = this.major;
        int i2 = this.minor;
        int i3 = this.micro;
        StringBuilder sb = new StringBuilder(71);
        sb.append("EspVersionInfo{major=");
        sb.append(i);
        sb.append(", minor=");
        sb.append(i2);
        sb.append(", micro=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }
}

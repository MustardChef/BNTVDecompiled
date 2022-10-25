package com.google.ads.interactivemedia.p034v3.impl.data;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.t */
/* loaded from: classes2.dex */
final class C2529t extends AbstractC2483ba {
    private final double end;
    private final boolean played;
    private final double start;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2529t(double d, double d2, boolean z) {
        this.start = d;
        this.end = d2;
        this.played = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2483ba
    public double end() {
        return this.end;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2483ba) {
            AbstractC2483ba abstractC2483ba = (AbstractC2483ba) obj;
            if (Double.doubleToLongBits(this.start) == Double.doubleToLongBits(abstractC2483ba.start()) && Double.doubleToLongBits(this.end) == Double.doubleToLongBits(abstractC2483ba.end()) && this.played == abstractC2483ba.played()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (true != this.played ? 1237 : 1231) ^ ((((((int) ((Double.doubleToLongBits(this.start) >>> 32) ^ Double.doubleToLongBits(this.start))) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.end) >>> 32) ^ Double.doubleToLongBits(this.end)))) * 1000003);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2483ba
    public boolean played() {
        return this.played;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2483ba
    public double start() {
        return this.start;
    }

    public String toString() {
        double d = this.start;
        double d2 = this.end;
        boolean z = this.played;
        StringBuilder sb = new StringBuilder(88);
        sb.append("CuePointData{start=");
        sb.append(d);
        sb.append(", end=");
        sb.append(d2);
        sb.append(", played=");
        sb.append(z);
        sb.append("}");
        return sb.toString();
    }
}

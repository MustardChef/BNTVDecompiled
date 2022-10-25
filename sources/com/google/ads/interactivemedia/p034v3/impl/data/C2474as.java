package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.as */
/* loaded from: classes2.dex */
public final class C2474as extends AbstractC2506bx {
    private final long currentTime;
    private final long duration;
    private final String timeUnit;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2474as(long j, long j2, String str) {
        this.currentTime = j;
        this.duration = j2;
        Objects.requireNonNull(str, "Null timeUnit");
        this.timeUnit = str;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2506bx
    public long currentTime() {
        return this.currentTime;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2506bx
    public long duration() {
        return this.duration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2506bx) {
            AbstractC2506bx abstractC2506bx = (AbstractC2506bx) obj;
            if (this.currentTime == abstractC2506bx.currentTime() && this.duration == abstractC2506bx.duration() && this.timeUnit.equals(abstractC2506bx.timeUnit())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.currentTime;
        long j2 = this.duration;
        return this.timeUnit.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2506bx
    public String timeUnit() {
        return this.timeUnit;
    }

    public String toString() {
        long j = this.currentTime;
        long j2 = this.duration;
        String str = this.timeUnit;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 90);
        sb.append("TimeUpdateData{currentTime=");
        sb.append(j);
        sb.append(", duration=");
        sb.append(j2);
        sb.append(", timeUnit=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}

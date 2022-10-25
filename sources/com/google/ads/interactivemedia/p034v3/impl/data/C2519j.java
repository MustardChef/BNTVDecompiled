package com.google.ads.interactivemedia.p034v3.impl.data;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.j */
/* loaded from: classes2.dex */
final class C2519j extends AbstractC2482b {
    private final String appState;
    private final String eventId;
    private final long nativeTime;
    private final AbstractC2479ax nativeViewBounds;
    private final boolean nativeViewHidden;
    private final AbstractC2479ax nativeViewVisibleBounds;
    private final double nativeVolume;
    private final String queryId;

    private C2519j(String str, String str2, String str3, long j, double d, boolean z, AbstractC2479ax abstractC2479ax, AbstractC2479ax abstractC2479ax2) {
        this.queryId = str;
        this.eventId = str2;
        this.appState = str3;
        this.nativeTime = j;
        this.nativeVolume = d;
        this.nativeViewHidden = z;
        this.nativeViewBounds = abstractC2479ax;
        this.nativeViewVisibleBounds = abstractC2479ax2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2519j(String str, String str2, String str3, long j, double d, boolean z, AbstractC2479ax abstractC2479ax, AbstractC2479ax abstractC2479ax2, C2518i c2518i) {
        this(str, str2, str3, j, d, z, abstractC2479ax, abstractC2479ax2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b
    public String appState() {
        return this.appState;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2482b) {
            AbstractC2482b abstractC2482b = (AbstractC2482b) obj;
            if (this.queryId.equals(abstractC2482b.queryId()) && this.eventId.equals(abstractC2482b.eventId()) && this.appState.equals(abstractC2482b.appState()) && this.nativeTime == abstractC2482b.nativeTime() && Double.doubleToLongBits(this.nativeVolume) == Double.doubleToLongBits(abstractC2482b.nativeVolume()) && this.nativeViewHidden == abstractC2482b.nativeViewHidden() && this.nativeViewBounds.equals(abstractC2482b.nativeViewBounds()) && this.nativeViewVisibleBounds.equals(abstractC2482b.nativeViewVisibleBounds())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b
    public String eventId() {
        return this.eventId;
    }

    public int hashCode() {
        int hashCode = this.queryId.hashCode();
        int hashCode2 = this.eventId.hashCode();
        int hashCode3 = this.appState.hashCode();
        long j = this.nativeTime;
        return ((((((((((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.nativeVolume) >>> 32) ^ Double.doubleToLongBits(this.nativeVolume)))) * 1000003) ^ (true != this.nativeViewHidden ? 1237 : 1231)) * 1000003) ^ this.nativeViewBounds.hashCode()) * 1000003) ^ this.nativeViewVisibleBounds.hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b
    public long nativeTime() {
        return this.nativeTime;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b
    public AbstractC2479ax nativeViewBounds() {
        return this.nativeViewBounds;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b
    public boolean nativeViewHidden() {
        return this.nativeViewHidden;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b
    public AbstractC2479ax nativeViewVisibleBounds() {
        return this.nativeViewVisibleBounds;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b
    public double nativeVolume() {
        return this.nativeVolume;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2482b
    public String queryId() {
        return this.queryId;
    }

    public String toString() {
        String str = this.queryId;
        String str2 = this.eventId;
        String str3 = this.appState;
        long j = this.nativeTime;
        double d = this.nativeVolume;
        boolean z = this.nativeViewHidden;
        String valueOf = String.valueOf(this.nativeViewBounds);
        String valueOf2 = String.valueOf(this.nativeViewVisibleBounds);
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        int length3 = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(length + 191 + length2 + length3 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
        sb.append("ActivityMonitorData{queryId=");
        sb.append(str);
        sb.append(", eventId=");
        sb.append(str2);
        sb.append(", appState=");
        sb.append(str3);
        sb.append(", nativeTime=");
        sb.append(j);
        sb.append(", nativeVolume=");
        sb.append(d);
        sb.append(", nativeViewHidden=");
        sb.append(z);
        sb.append(", nativeViewBounds=");
        sb.append(valueOf);
        sb.append(", nativeViewVisibleBounds=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }
}

package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.h */
/* loaded from: classes2.dex */
final class C2517h implements InterfaceC2455a {
    private String appState;
    private String eventId;
    private Long nativeTime;
    private AbstractC2479ax nativeViewBounds;
    private Boolean nativeViewHidden;
    private AbstractC2479ax nativeViewVisibleBounds;
    private Double nativeVolume;
    private String queryId;

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public InterfaceC2455a appState(String str) {
        Objects.requireNonNull(str, "Null appState");
        this.appState = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public AbstractC2482b build() {
        String str;
        String str2;
        Long l;
        String str3 = this.queryId;
        if (str3 == null || (str = this.eventId) == null || (str2 = this.appState) == null || (l = this.nativeTime) == null || this.nativeVolume == null || this.nativeViewHidden == null || this.nativeViewBounds == null || this.nativeViewVisibleBounds == null) {
            StringBuilder sb = new StringBuilder();
            if (this.queryId == null) {
                sb.append(" queryId");
            }
            if (this.eventId == null) {
                sb.append(" eventId");
            }
            if (this.appState == null) {
                sb.append(" appState");
            }
            if (this.nativeTime == null) {
                sb.append(" nativeTime");
            }
            if (this.nativeVolume == null) {
                sb.append(" nativeVolume");
            }
            if (this.nativeViewHidden == null) {
                sb.append(" nativeViewHidden");
            }
            if (this.nativeViewBounds == null) {
                sb.append(" nativeViewBounds");
            }
            if (this.nativeViewVisibleBounds == null) {
                sb.append(" nativeViewVisibleBounds");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new C2519j(str3, str, str2, l.longValue(), this.nativeVolume.doubleValue(), this.nativeViewHidden.booleanValue(), this.nativeViewBounds, this.nativeViewVisibleBounds, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public InterfaceC2455a eventId(String str) {
        Objects.requireNonNull(str, "Null eventId");
        this.eventId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public InterfaceC2455a nativeTime(long j) {
        this.nativeTime = Long.valueOf(j);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public InterfaceC2455a nativeViewBounds(AbstractC2479ax abstractC2479ax) {
        Objects.requireNonNull(abstractC2479ax, "Null nativeViewBounds");
        this.nativeViewBounds = abstractC2479ax;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public InterfaceC2455a nativeViewHidden(boolean z) {
        this.nativeViewHidden = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public InterfaceC2455a nativeViewVisibleBounds(AbstractC2479ax abstractC2479ax) {
        Objects.requireNonNull(abstractC2479ax, "Null nativeViewVisibleBounds");
        this.nativeViewVisibleBounds = abstractC2479ax;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public InterfaceC2455a nativeVolume(double d) {
        this.nativeVolume = Double.valueOf(d);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2455a
    public InterfaceC2455a queryId(String str) {
        Objects.requireNonNull(str, "Null queryId");
        this.queryId = str;
        return this;
    }
}

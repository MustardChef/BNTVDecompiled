package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdProgressInfo;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aif */
/* loaded from: classes2.dex */
public final class aif implements AdProgressInfo {

    /* renamed from: a */
    private final double f4129a;

    /* renamed from: b */
    private final double f4130b;

    /* renamed from: c */
    private final int f4131c;

    /* renamed from: d */
    private final int f4132d;

    /* renamed from: e */
    private final double f4133e;

    /* renamed from: f */
    private final double f4134f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aif(double d, double d2, int i, int i2, double d3, double d4) {
        this.f4129a = d;
        this.f4130b = d2;
        this.f4131c = i;
        this.f4132d = i2;
        this.f4133e = d3;
        this.f4134f = d4;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdProgressInfo
    public final double getAdBreakDuration() {
        return this.f4133e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdProgressInfo
    public final double getAdPeriodDuration() {
        return this.f4134f;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdProgressInfo
    public final int getAdPosition() {
        return this.f4131c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdProgressInfo
    public final double getCurrentTime() {
        return this.f4129a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdProgressInfo
    public final double getDuration() {
        return this.f4130b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdProgressInfo
    public final int getTotalAds() {
        return this.f4132d;
    }
}

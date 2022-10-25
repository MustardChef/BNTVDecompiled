package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.CuePoint;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajh */
/* loaded from: classes2.dex */
public final class ajh implements CuePoint {

    /* renamed from: a */
    private final double f4230a;

    /* renamed from: b */
    private final double f4231b;

    /* renamed from: c */
    private final boolean f4232c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajh(double d, double d2, boolean z) {
        this.f4230a = d;
        this.f4231b = d2;
        this.f4232c = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CuePoint
    public final double getEndTime() {
        return this.f4231b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CuePoint
    public final long getEndTimeMs() {
        return (long) Math.floor(this.f4231b * 1000.0d);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CuePoint
    public final double getStartTime() {
        return this.f4230a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CuePoint
    public final long getStartTimeMs() {
        return (long) Math.floor(this.f4230a * 1000.0d);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.CuePoint
    public final boolean isPlayed() {
        return this.f4232c;
    }
}

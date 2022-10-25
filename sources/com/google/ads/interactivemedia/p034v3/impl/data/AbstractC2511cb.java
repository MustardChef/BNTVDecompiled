package com.google.ads.interactivemedia.p034v3.impl.data;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.cb */
/* loaded from: classes2.dex */
public abstract class AbstractC2511cb {
    public abstract AbstractC2512cc build();

    public abstract AbstractC2511cb volume(float f);

    public AbstractC2511cb volumePercentage(int i) {
        return volume(i / 100.0f);
    }
}

package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.ate;

/* compiled from: IMASDK */
@ate(m4626a = C2519j.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.b */
/* loaded from: classes2.dex */
public abstract class AbstractC2482b {
    public static InterfaceC2455a builder() {
        return new C2517h();
    }

    public abstract String appState();

    public abstract String eventId();

    public abstract long nativeTime();

    public abstract AbstractC2479ax nativeViewBounds();

    public abstract boolean nativeViewHidden();

    public abstract AbstractC2479ax nativeViewVisibleBounds();

    public abstract double nativeVolume();

    public abstract String queryId();
}

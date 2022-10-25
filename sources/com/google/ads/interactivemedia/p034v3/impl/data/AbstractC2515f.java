package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.p034v3.api.UiElement;
import com.google.ads.interactivemedia.p034v3.internal.ate;
import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avo;

/* compiled from: IMASDK */
@ate(m4626a = C2523n.class)
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.f */
/* loaded from: classes2.dex */
public abstract class AbstractC2515f {
    public static AbstractC2514e builder(AdsRenderingSettings adsRenderingSettings) {
        C2516g c2516g = (C2516g) adsRenderingSettings;
        C2521l c2521l = new C2521l();
        c2521l.setBitrate(c2516g.getBitrateKbps());
        c2521l.setDisableUi(c2516g.getDisableUi());
        c2521l.setEnablePreloading(c2516g.getEnablePreloading());
        c2521l.setEnableFocusSkipButton(c2516g.getFocusSkipButtonWhenAvailable());
        c2521l.setLoadVideoTimeout(c2516g.getLoadVideoTimeout());
        c2521l.setMimeTypes(c2516g.getMimeTypes());
        c2521l.setPlayAdsAfterTime(c2516g.getPlayAdsAfterTime());
        c2521l.setUiElements(c2516g.getUiElements());
        return c2521l;
    }

    public abstract int bitrate();

    public abstract boolean disableUi();

    public abstract boolean enableFocusSkipButton();

    public abstract boolean enablePreloading();

    public abstract int loadVideoTimeout();

    public abstract avg<String> mimeTypes();

    public abstract double playAdsAfterTime();

    abstract AbstractC2514e toBuilder();

    public abstract avo<UiElement> uiElements();
}

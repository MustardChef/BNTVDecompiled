package com.google.ads.interactivemedia.p034v3.api;

import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.AdsRenderingSettings */
/* loaded from: classes2.dex */
public interface AdsRenderingSettings {
    int getBitrateKbps();

    boolean getDisableUi();

    boolean getEnableCustomTabs();

    boolean getEnablePreloading();

    boolean getFocusSkipButtonWhenAvailable();

    List<String> getMimeTypes();

    void setBitrateKbps(int i);

    void setDisableUi(boolean z);

    void setEnableCustomTabs(boolean z);

    void setEnablePreloading(boolean z);

    void setFocusSkipButtonWhenAvailable(boolean z);

    void setLoadVideoTimeout(int i);

    void setMimeTypes(List<String> list);

    void setPlayAdsAfterTime(double d);

    void setUiElements(Set<UiElement> set);
}

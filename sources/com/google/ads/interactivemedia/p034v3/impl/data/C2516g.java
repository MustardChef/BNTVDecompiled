package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.p034v3.api.UiElement;
import com.google.ads.interactivemedia.p034v3.internal.brf;
import com.google.ads.interactivemedia.p034v3.internal.brh;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.g */
/* loaded from: classes2.dex */
public final class C2516g implements AdsRenderingSettings {
    private boolean enablePreloading;
    private Set<UiElement> uiElements;
    private int bitrate = -1;
    private List<String> mimeTypes = null;
    private boolean enableFocusSkipButton = true;
    private double playAdsAfterTime = -1.0d;
    private boolean disableUi = false;
    private boolean enableCustomTabs = false;
    private int loadVideoTimeout = -1;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return brf.m2729c(this, obj, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public int getBitrateKbps() {
        return this.bitrate;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public boolean getDisableUi() {
        return this.disableUi;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public boolean getEnableCustomTabs() {
        return this.enableCustomTabs;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public boolean getEnablePreloading() {
        return this.enablePreloading;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public boolean getFocusSkipButtonWhenAvailable() {
        return this.enableFocusSkipButton;
    }

    public int getLoadVideoTimeout() {
        return this.loadVideoTimeout;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public List<String> getMimeTypes() {
        return this.mimeTypes;
    }

    public double getPlayAdsAfterTime() {
        return this.playAdsAfterTime;
    }

    public Set<UiElement> getUiElements() {
        return this.uiElements;
    }

    public int hashCode() {
        return brh.m2722a(this, new String[0]);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setBitrateKbps(int i) {
        this.bitrate = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setDisableUi(boolean z) {
        this.disableUi = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setEnableCustomTabs(boolean z) {
        this.enableCustomTabs = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setEnablePreloading(boolean z) {
        this.enablePreloading = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setFocusSkipButtonWhenAvailable(boolean z) {
        this.enableFocusSkipButton = z;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setLoadVideoTimeout(int i) {
        this.loadVideoTimeout = i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setMimeTypes(List<String> list) {
        this.mimeTypes = list;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setPlayAdsAfterTime(double d) {
        this.playAdsAfterTime = d;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings
    public void setUiElements(Set<UiElement> set) {
        this.uiElements = set;
    }
}

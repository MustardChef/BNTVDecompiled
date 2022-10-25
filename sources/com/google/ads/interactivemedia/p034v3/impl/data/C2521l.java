package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.UiElement;
import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avo;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.l */
/* loaded from: classes2.dex */
final class C2521l extends AbstractC2514e {
    private Integer bitrate;
    private Boolean disableUi;
    private Boolean enableFocusSkipButton;
    private Boolean enablePreloading;
    private Integer loadVideoTimeout;
    private avg<String> mimeTypes;
    private Double playAdsAfterTime;
    private avo<UiElement> uiElements;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2521l() {
    }

    private C2521l(AbstractC2515f abstractC2515f) {
        this.bitrate = Integer.valueOf(abstractC2515f.bitrate());
        this.mimeTypes = abstractC2515f.mimeTypes();
        this.uiElements = abstractC2515f.uiElements();
        this.enablePreloading = Boolean.valueOf(abstractC2515f.enablePreloading());
        this.enableFocusSkipButton = Boolean.valueOf(abstractC2515f.enableFocusSkipButton());
        this.playAdsAfterTime = Double.valueOf(abstractC2515f.playAdsAfterTime());
        this.disableUi = Boolean.valueOf(abstractC2515f.disableUi());
        this.loadVideoTimeout = Integer.valueOf(abstractC2515f.loadVideoTimeout());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2521l(AbstractC2515f abstractC2515f, C2520k c2520k) {
        this(abstractC2515f);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2515f build() {
        Integer num = this.bitrate;
        if (num == null || this.enablePreloading == null || this.enableFocusSkipButton == null || this.playAdsAfterTime == null || this.disableUi == null || this.loadVideoTimeout == null) {
            StringBuilder sb = new StringBuilder();
            if (this.bitrate == null) {
                sb.append(" bitrate");
            }
            if (this.enablePreloading == null) {
                sb.append(" enablePreloading");
            }
            if (this.enableFocusSkipButton == null) {
                sb.append(" enableFocusSkipButton");
            }
            if (this.playAdsAfterTime == null) {
                sb.append(" playAdsAfterTime");
            }
            if (this.disableUi == null) {
                sb.append(" disableUi");
            }
            if (this.loadVideoTimeout == null) {
                sb.append(" loadVideoTimeout");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new C2523n(num.intValue(), this.mimeTypes, this.uiElements, this.enablePreloading.booleanValue(), this.enableFocusSkipButton.booleanValue(), this.playAdsAfterTime.doubleValue(), this.disableUi.booleanValue(), this.loadVideoTimeout.intValue(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2514e setBitrate(int i) {
        this.bitrate = Integer.valueOf(i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2514e setDisableUi(boolean z) {
        this.disableUi = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2514e setEnableFocusSkipButton(boolean z) {
        this.enableFocusSkipButton = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2514e setEnablePreloading(boolean z) {
        this.enablePreloading = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2514e setLoadVideoTimeout(int i) {
        this.loadVideoTimeout = Integer.valueOf(i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2514e setMimeTypes(List<String> list) {
        this.mimeTypes = list == null ? null : avg.m4517l(list);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2514e setPlayAdsAfterTime(double d) {
        this.playAdsAfterTime = Double.valueOf(d);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2514e
    public AbstractC2514e setUiElements(Set<UiElement> set) {
        this.uiElements = set == null ? null : avo.m4495l(set);
        return this;
    }
}

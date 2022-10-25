package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.UiElement;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.e */
/* loaded from: classes2.dex */
public abstract class AbstractC2514e {
    public abstract AbstractC2515f build();

    abstract AbstractC2514e setBitrate(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AbstractC2514e setDisableUi(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AbstractC2514e setEnableFocusSkipButton(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AbstractC2514e setEnablePreloading(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AbstractC2514e setLoadVideoTimeout(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AbstractC2514e setMimeTypes(List<String> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AbstractC2514e setPlayAdsAfterTime(double d);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract AbstractC2514e setUiElements(Set<UiElement> set);
}

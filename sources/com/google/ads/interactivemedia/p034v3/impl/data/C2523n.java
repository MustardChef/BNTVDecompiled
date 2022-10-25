package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.UiElement;
import com.google.ads.interactivemedia.p034v3.internal.avg;
import com.google.ads.interactivemedia.p034v3.internal.avo;
import com.google.ads.interactivemedia.p034v3.internal.bqk;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.n */
/* loaded from: classes2.dex */
final class C2523n extends AbstractC2515f {
    private final int bitrate;
    private final boolean disableUi;
    private final boolean enableFocusSkipButton;
    private final boolean enablePreloading;
    private final int loadVideoTimeout;
    private final avg<String> mimeTypes;
    private final double playAdsAfterTime;
    private final avo<UiElement> uiElements;

    private C2523n(int i, avg<String> avgVar, avo<UiElement> avoVar, boolean z, boolean z2, double d, boolean z3, int i2) {
        this.bitrate = i;
        this.mimeTypes = avgVar;
        this.uiElements = avoVar;
        this.enablePreloading = z;
        this.enableFocusSkipButton = z2;
        this.playAdsAfterTime = d;
        this.disableUi = z3;
        this.loadVideoTimeout = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2523n(int i, avg avgVar, avo avoVar, boolean z, boolean z2, double d, boolean z3, int i2, C2522m c2522m) {
        this(i, avgVar, avoVar, z, z2, d, z3, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    public int bitrate() {
        return this.bitrate;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    public boolean disableUi() {
        return this.disableUi;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    public boolean enableFocusSkipButton() {
        return this.enableFocusSkipButton;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    public boolean enablePreloading() {
        return this.enablePreloading;
    }

    public boolean equals(Object obj) {
        avg<String> avgVar;
        avo<UiElement> avoVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2515f) {
            AbstractC2515f abstractC2515f = (AbstractC2515f) obj;
            if (this.bitrate == abstractC2515f.bitrate() && ((avgVar = this.mimeTypes) != null ? avgVar.equals(abstractC2515f.mimeTypes()) : abstractC2515f.mimeTypes() == null) && ((avoVar = this.uiElements) != null ? avoVar.equals(abstractC2515f.uiElements()) : abstractC2515f.uiElements() == null) && this.enablePreloading == abstractC2515f.enablePreloading() && this.enableFocusSkipButton == abstractC2515f.enableFocusSkipButton() && Double.doubleToLongBits(this.playAdsAfterTime) == Double.doubleToLongBits(abstractC2515f.playAdsAfterTime()) && this.disableUi == abstractC2515f.disableUi() && this.loadVideoTimeout == abstractC2515f.loadVideoTimeout()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    public int loadVideoTimeout() {
        return this.loadVideoTimeout;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    public avg<String> mimeTypes() {
        return this.mimeTypes;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    public double playAdsAfterTime() {
        return this.playAdsAfterTime;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    AbstractC2514e toBuilder() {
        return new C2521l(this, null);
    }

    public String toString() {
        int i = this.bitrate;
        String valueOf = String.valueOf(this.mimeTypes);
        String valueOf2 = String.valueOf(this.uiElements);
        boolean z = this.enablePreloading;
        boolean z2 = this.enableFocusSkipButton;
        double d = this.playAdsAfterTime;
        boolean z3 = this.disableUi;
        int i2 = this.loadVideoTimeout;
        int length = String.valueOf(valueOf).length();
        StringBuilder sb = new StringBuilder(length + bqk.f6552bL + String.valueOf(valueOf2).length());
        sb.append("AdsRenderingSettingsData{bitrate=");
        sb.append(i);
        sb.append(", mimeTypes=");
        sb.append(valueOf);
        sb.append(", uiElements=");
        sb.append(valueOf2);
        sb.append(", enablePreloading=");
        sb.append(z);
        sb.append(", enableFocusSkipButton=");
        sb.append(z2);
        sb.append(", playAdsAfterTime=");
        sb.append(d);
        sb.append(", disableUi=");
        sb.append(z3);
        sb.append(", loadVideoTimeout=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f
    public avo<UiElement> uiElements() {
        return this.uiElements;
    }

    public int hashCode() {
        int i = (this.bitrate ^ 1000003) * 1000003;
        avg<String> avgVar = this.mimeTypes;
        int hashCode = (i ^ (avgVar == null ? 0 : avgVar.hashCode())) * 1000003;
        avo<UiElement> avoVar = this.uiElements;
        return ((((((((((hashCode ^ (avoVar != null ? avoVar.hashCode() : 0)) * 1000003) ^ (true != this.enablePreloading ? 1237 : 1231)) * 1000003) ^ (true != this.enableFocusSkipButton ? 1237 : 1231)) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.playAdsAfterTime) >>> 32) ^ Double.doubleToLongBits(this.playAdsAfterTime)))) * 1000003) ^ (true == this.disableUi ? 1231 : 1237)) * 1000003) ^ this.loadVideoTimeout;
    }
}

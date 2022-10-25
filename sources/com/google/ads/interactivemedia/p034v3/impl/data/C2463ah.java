package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.avg;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ah */
/* loaded from: classes2.dex */
final class C2463ah extends AbstractC2501bs {
    private avg<AbstractC2503bu> obstructions;

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2501bs
    public AbstractC2504bv build() {
        avg<AbstractC2503bu> avgVar = this.obstructions;
        if (avgVar != null) {
            return new C2465aj(avgVar, null);
        }
        throw new IllegalStateException("Missing required properties: obstructions");
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2501bs
    public AbstractC2501bs obstructions(List<AbstractC2503bu> list) {
        this.obstructions = avg.m4517l(list);
        return this;
    }
}

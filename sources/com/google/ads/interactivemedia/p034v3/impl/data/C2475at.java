package com.google.ads.interactivemedia.p034v3.impl.data;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.at */
/* loaded from: classes2.dex */
final class C2475at extends AbstractC2511cb {
    private Float volume;

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2511cb
    public AbstractC2512cc build() {
        Float f = this.volume;
        if (f == null) {
            throw new IllegalStateException("Missing required properties: volume");
        }
        return new C2477av(f.floatValue(), null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2511cb
    public AbstractC2511cb volume(float f) {
        this.volume = Float.valueOf(f);
        return this;
    }
}

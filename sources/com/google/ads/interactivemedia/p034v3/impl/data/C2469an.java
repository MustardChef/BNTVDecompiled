package com.google.ads.interactivemedia.p034v3.impl.data;

import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.an */
/* loaded from: classes2.dex */
final class C2469an extends ResizeAndPositionVideoMsgData {
    private final Integer height;
    private final Integer width;

    /* renamed from: x */
    private final Integer f2851x;

    /* renamed from: y */
    private final Integer f2852y;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2469an(Integer num, Integer num2, Integer num3, Integer num4) {
        Objects.requireNonNull(num, "Null x");
        this.f2851x = num;
        Objects.requireNonNull(num2, "Null y");
        this.f2852y = num2;
        Objects.requireNonNull(num3, "Null width");
        this.width = num3;
        Objects.requireNonNull(num4, "Null height");
        this.height = num4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ResizeAndPositionVideoMsgData) {
            ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData = (ResizeAndPositionVideoMsgData) obj;
            if (this.f2851x.equals(resizeAndPositionVideoMsgData.mo6010x()) && this.f2852y.equals(resizeAndPositionVideoMsgData.mo6009y()) && this.width.equals(resizeAndPositionVideoMsgData.width()) && this.height.equals(resizeAndPositionVideoMsgData.height())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f2851x.hashCode() ^ 1000003) * 1000003) ^ this.f2852y.hashCode()) * 1000003) ^ this.width.hashCode()) * 1000003) ^ this.height.hashCode();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.ResizeAndPositionVideoMsgData
    public Integer height() {
        return this.height;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.ResizeAndPositionVideoMsgData
    public Integer width() {
        return this.width;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.ResizeAndPositionVideoMsgData
    /* renamed from: x */
    public Integer mo6010x() {
        return this.f2851x;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.ResizeAndPositionVideoMsgData
    /* renamed from: y */
    public Integer mo6009y() {
        return this.f2852y;
    }
}

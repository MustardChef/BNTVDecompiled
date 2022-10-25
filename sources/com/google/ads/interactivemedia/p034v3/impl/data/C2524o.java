package com.google.ads.interactivemedia.p034v3.impl.data;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.o */
/* loaded from: classes2.dex */
final class C2524o extends AbstractC2478aw {
    private Integer height;
    private Integer left;
    private Integer top;
    private Integer width;

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2478aw
    public AbstractC2479ax build() {
        Integer num = this.left;
        if (num == null || this.top == null || this.height == null || this.width == null) {
            StringBuilder sb = new StringBuilder();
            if (this.left == null) {
                sb.append(" left");
            }
            if (this.top == null) {
                sb.append(" top");
            }
            if (this.height == null) {
                sb.append(" height");
            }
            if (this.width == null) {
                sb.append(" width");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new C2526q(num.intValue(), this.top.intValue(), this.height.intValue(), this.width.intValue(), null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2478aw
    public AbstractC2478aw height(int i) {
        this.height = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2478aw
    public AbstractC2478aw left(int i) {
        this.left = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2478aw
    public AbstractC2478aw top(int i) {
        this.top = Integer.valueOf(i);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2478aw
    public AbstractC2478aw width(int i) {
        this.width = Integer.valueOf(i);
        return this;
    }
}

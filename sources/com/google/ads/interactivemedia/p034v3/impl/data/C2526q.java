package com.google.ads.interactivemedia.p034v3.impl.data;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.q */
/* loaded from: classes2.dex */
final class C2526q extends AbstractC2479ax {
    private final int height;
    private final int left;
    private final int top;
    private final int width;

    private C2526q(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.height = i3;
        this.width = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2526q(int i, int i2, int i3, int i4, C2525p c2525p) {
        this(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2479ax) {
            AbstractC2479ax abstractC2479ax = (AbstractC2479ax) obj;
            if (this.left == abstractC2479ax.left() && this.top == abstractC2479ax.top() && this.height == abstractC2479ax.height() && this.width == abstractC2479ax.width()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.left ^ 1000003) * 1000003) ^ this.top) * 1000003) ^ this.height) * 1000003) ^ this.width;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2479ax
    public int height() {
        return this.height;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2479ax
    public int left() {
        return this.left;
    }

    public String toString() {
        int i = this.left;
        int i2 = this.top;
        int i3 = this.height;
        int i4 = this.width;
        StringBuilder sb = new StringBuilder(90);
        sb.append("BoundingRectData{left=");
        sb.append(i);
        sb.append(", top=");
        sb.append(i2);
        sb.append(", height=");
        sb.append(i3);
        sb.append(", width=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2479ax
    public int top() {
        return this.top;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2479ax
    public int width() {
        return this.width;
    }
}

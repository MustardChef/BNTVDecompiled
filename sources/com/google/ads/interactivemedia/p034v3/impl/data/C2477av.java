package com.google.ads.interactivemedia.p034v3.impl.data;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.av */
/* loaded from: classes2.dex */
final class C2477av extends AbstractC2512cc {
    private final float volume;

    private C2477av(float f) {
        this.volume = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2477av(float f, C2476au c2476au) {
        this(f);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AbstractC2512cc) && Float.floatToIntBits(this.volume) == Float.floatToIntBits(((AbstractC2512cc) obj).volume());
    }

    public int hashCode() {
        return Float.floatToIntBits(this.volume) ^ 1000003;
    }

    public String toString() {
        float f = this.volume;
        StringBuilder sb = new StringBuilder(40);
        sb.append("VolumeUpdateData{volume=");
        sb.append(f);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2512cc
    public float volume() {
        return this.volume;
    }
}

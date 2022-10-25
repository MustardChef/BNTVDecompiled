package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.internal.avg;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.aj */
/* loaded from: classes2.dex */
final class C2465aj extends AbstractC2504bv {
    private final avg<AbstractC2503bu> obstructions;

    private C2465aj(avg<AbstractC2503bu> avgVar) {
        this.obstructions = avgVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2465aj(avg avgVar, C2464ai c2464ai) {
        this(avgVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2504bv) {
            return this.obstructions.equals(((AbstractC2504bv) obj).obstructions());
        }
        return false;
    }

    public int hashCode() {
        return this.obstructions.hashCode() ^ 1000003;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2504bv
    public avg<AbstractC2503bu> obstructions() {
        return this.obstructions;
    }

    public String toString() {
        String valueOf = String.valueOf(this.obstructions);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
        sb.append("ObstructionListData{obstructions=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}

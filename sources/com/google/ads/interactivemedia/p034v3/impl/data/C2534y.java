package com.google.ads.interactivemedia.p034v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.y */
/* loaded from: classes2.dex */
final class C2534y extends AbstractC2487be {
    private final String detailedReason;
    private final FriendlyObstructionPurpose purpose;
    private final View view;

    private C2534y(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.view = view;
        this.purpose = friendlyObstructionPurpose;
        this.detailedReason = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2534y(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str, C2533x c2533x) {
        this(view, friendlyObstructionPurpose, str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2487be
    public String detailedReason() {
        return this.detailedReason;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2487be) {
            AbstractC2487be abstractC2487be = (AbstractC2487be) obj;
            if (this.view.equals(abstractC2487be.view()) && this.purpose.equals(abstractC2487be.purpose()) && ((str = this.detailedReason) != null ? str.equals(abstractC2487be.detailedReason()) : abstractC2487be.detailedReason() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((this.view.hashCode() ^ 1000003) * 1000003) ^ this.purpose.hashCode()) * 1000003;
        String str = this.detailedReason;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2487be
    public FriendlyObstructionPurpose purpose() {
        return this.purpose;
    }

    public String toString() {
        String valueOf = String.valueOf(this.view);
        String valueOf2 = String.valueOf(this.purpose);
        String str = this.detailedReason;
        int length = String.valueOf(valueOf).length();
        StringBuilder sb = new StringBuilder(length + 57 + String.valueOf(valueOf2).length() + String.valueOf(str).length());
        sb.append("FriendlyObstructionImpl{view=");
        sb.append(valueOf);
        sb.append(", purpose=");
        sb.append(valueOf2);
        sb.append(", detailedReason=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2487be
    public View view() {
        return this.view;
    }
}

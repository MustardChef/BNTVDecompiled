package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.am */
/* loaded from: classes2.dex */
final class C2468am extends AbstractC2503bu {
    private final boolean attached;
    private final AbstractC2479ax bounds;
    private final String detailedReason;
    private final boolean hidden;
    private final FriendlyObstructionPurpose purpose;
    private final String type;

    private C2468am(boolean z, AbstractC2479ax abstractC2479ax, String str, boolean z2, FriendlyObstructionPurpose friendlyObstructionPurpose, String str2) {
        this.attached = z;
        this.bounds = abstractC2479ax;
        this.detailedReason = str;
        this.hidden = z2;
        this.purpose = friendlyObstructionPurpose;
        this.type = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2468am(boolean z, AbstractC2479ax abstractC2479ax, String str, boolean z2, FriendlyObstructionPurpose friendlyObstructionPurpose, String str2, C2467al c2467al) {
        this(z, abstractC2479ax, str, z2, friendlyObstructionPurpose, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2503bu
    public boolean attached() {
        return this.attached;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2503bu
    public AbstractC2479ax bounds() {
        return this.bounds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2503bu
    public String detailedReason() {
        return this.detailedReason;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2503bu) {
            AbstractC2503bu abstractC2503bu = (AbstractC2503bu) obj;
            if (this.attached == abstractC2503bu.attached() && this.bounds.equals(abstractC2503bu.bounds()) && ((str = this.detailedReason) != null ? str.equals(abstractC2503bu.detailedReason()) : abstractC2503bu.detailedReason() == null) && this.hidden == abstractC2503bu.hidden() && this.purpose.equals(abstractC2503bu.purpose()) && this.type.equals(abstractC2503bu.type())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((true != this.attached ? 1237 : 1231) ^ 1000003) * 1000003) ^ this.bounds.hashCode()) * 1000003;
        String str = this.detailedReason;
        return ((((((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ (true == this.hidden ? 1231 : 1237)) * 1000003) ^ this.purpose.hashCode()) * 1000003) ^ this.type.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2503bu
    public boolean hidden() {
        return this.hidden;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2503bu
    public FriendlyObstructionPurpose purpose() {
        return this.purpose;
    }

    public String toString() {
        boolean z = this.attached;
        String valueOf = String.valueOf(this.bounds);
        String str = this.detailedReason;
        boolean z2 = this.hidden;
        String valueOf2 = String.valueOf(this.purpose);
        String str2 = this.type;
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 88 + length2 + String.valueOf(valueOf2).length() + String.valueOf(str2).length());
        sb.append("ObstructionData{attached=");
        sb.append(z);
        sb.append(", bounds=");
        sb.append(valueOf);
        sb.append(", detailedReason=");
        sb.append(str);
        sb.append(", hidden=");
        sb.append(z2);
        sb.append(", purpose=");
        sb.append(valueOf2);
        sb.append(", type=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2503bu
    public String type() {
        return this.type;
    }
}

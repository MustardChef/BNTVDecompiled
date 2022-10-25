package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;
import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.ak */
/* loaded from: classes2.dex */
final class C2466ak extends AbstractC2502bt {
    private Boolean attached;
    private AbstractC2479ax bounds;
    private String detailedReason;
    private Boolean hidden;
    private FriendlyObstructionPurpose purpose;
    private String type;

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2502bt
    public AbstractC2502bt attached(boolean z) {
        this.attached = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2502bt
    public AbstractC2502bt bounds(AbstractC2479ax abstractC2479ax) {
        Objects.requireNonNull(abstractC2479ax, "Null bounds");
        this.bounds = abstractC2479ax;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2502bt
    public AbstractC2503bu build() {
        Boolean bool = this.attached;
        if (bool == null || this.bounds == null || this.hidden == null || this.purpose == null || this.type == null) {
            StringBuilder sb = new StringBuilder();
            if (this.attached == null) {
                sb.append(" attached");
            }
            if (this.bounds == null) {
                sb.append(" bounds");
            }
            if (this.hidden == null) {
                sb.append(" hidden");
            }
            if (this.purpose == null) {
                sb.append(" purpose");
            }
            if (this.type == null) {
                sb.append(" type");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new C2468am(bool.booleanValue(), this.bounds, this.detailedReason, this.hidden.booleanValue(), this.purpose, this.type, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2502bt
    public AbstractC2502bt detailedReason(String str) {
        this.detailedReason = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2502bt
    public AbstractC2502bt hidden(boolean z) {
        this.hidden = Boolean.valueOf(z);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2502bt
    public AbstractC2502bt purpose(FriendlyObstructionPurpose friendlyObstructionPurpose) {
        Objects.requireNonNull(friendlyObstructionPurpose, "Null purpose");
        this.purpose = friendlyObstructionPurpose;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2502bt
    public AbstractC2502bt type(String str) {
        Objects.requireNonNull(str, "Null type");
        this.type = str;
        return this;
    }
}

package com.google.ads.interactivemedia.p034v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;
import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.w */
/* loaded from: classes2.dex */
final class C2532w implements InterfaceC2486bd {
    private String detailedReason;
    private FriendlyObstructionPurpose purpose;
    private View view;

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2486bd
    public AbstractC2487be build() {
        FriendlyObstructionPurpose friendlyObstructionPurpose;
        View view = this.view;
        if (view == null || (friendlyObstructionPurpose = this.purpose) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.view == null) {
                sb.append(" view");
            }
            if (this.purpose == null) {
                sb.append(" purpose");
            }
            throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
        }
        return new C2534y(view, friendlyObstructionPurpose, this.detailedReason, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2486bd
    public InterfaceC2486bd detailedReason(String str) {
        this.detailedReason = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2486bd
    public InterfaceC2486bd purpose(FriendlyObstructionPurpose friendlyObstructionPurpose) {
        Objects.requireNonNull(friendlyObstructionPurpose, "Null purpose");
        this.purpose = friendlyObstructionPurpose;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.impl.data.InterfaceC2486bd
    public InterfaceC2486bd view(View view) {
        Objects.requireNonNull(view, "Null view");
        this.view = view;
        return this;
    }
}

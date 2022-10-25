package com.google.ads.interactivemedia.p034v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.be */
/* loaded from: classes2.dex */
public abstract class AbstractC2487be implements FriendlyObstruction {
    public static InterfaceC2486bd builder() {
        return new C2532w();
    }

    public abstract String detailedReason();

    @Override // com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction
    public String getDetailedReason() {
        return detailedReason();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction
    public FriendlyObstructionPurpose getPurpose() {
        return purpose();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction
    public View getView() {
        return view();
    }

    public abstract FriendlyObstructionPurpose purpose();

    public abstract View view();
}

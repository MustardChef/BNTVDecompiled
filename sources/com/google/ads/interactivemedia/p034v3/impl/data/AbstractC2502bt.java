package com.google.ads.interactivemedia.p034v3.impl.data;

import android.os.Build;
import android.view.View;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstructionPurpose;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bt */
/* loaded from: classes2.dex */
public abstract class AbstractC2502bt {
    public abstract AbstractC2502bt attached(boolean z);

    public abstract AbstractC2502bt bounds(AbstractC2479ax abstractC2479ax);

    public abstract AbstractC2503bu build();

    public abstract AbstractC2502bt detailedReason(String str);

    public abstract AbstractC2502bt hidden(boolean z);

    public abstract AbstractC2502bt purpose(FriendlyObstructionPurpose friendlyObstructionPurpose);

    public abstract AbstractC2502bt type(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC2502bt view(View view) {
        return attached(Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : true).bounds(AbstractC2479ax.builder().locationOnScreenOfView(view).build()).hidden(!view.isShown()).type(view.getClass().getCanonicalName());
    }
}

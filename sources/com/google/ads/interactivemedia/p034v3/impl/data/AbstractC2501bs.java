package com.google.ads.interactivemedia.p034v3.impl.data;

import com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.impl.data.bs */
/* loaded from: classes2.dex */
public abstract class AbstractC2501bs {
    public abstract AbstractC2504bv build();

    public AbstractC2501bs friendlyObstructions(Collection<FriendlyObstruction> collection) {
        ArrayList arrayList = new ArrayList();
        for (FriendlyObstruction friendlyObstruction : collection) {
            arrayList.add(AbstractC2503bu.builder().view(friendlyObstruction.getView()).purpose(friendlyObstruction.getPurpose()).detailedReason(friendlyObstruction.getDetailedReason()).build());
        }
        return obstructions(arrayList);
    }

    public abstract AbstractC2501bs obstructions(List<AbstractC2503bu> list);
}

package com.google.ads.interactivemedia.p034v3.api;

import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.BaseDisplayContainer */
/* loaded from: classes2.dex */
public interface BaseDisplayContainer {
    void claim();

    @Deprecated
    void destroy();

    ViewGroup getAdContainer();

    Collection<CompanionAdSlot> getCompanionSlots();

    void registerFriendlyObstruction(FriendlyObstruction friendlyObstruction);

    @Deprecated
    void registerVideoControlsOverlay(View view);

    @Deprecated
    void setAdContainer(ViewGroup viewGroup);

    void setCompanionSlots(Collection<CompanionAdSlot> collection);

    void unregisterAllFriendlyObstructions();

    @Deprecated
    void unregisterAllVideoControlsOverlays();
}

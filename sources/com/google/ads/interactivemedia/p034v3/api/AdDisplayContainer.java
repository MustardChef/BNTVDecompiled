package com.google.ads.interactivemedia.p034v3.api;

import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.AdDisplayContainer */
/* loaded from: classes2.dex */
public interface AdDisplayContainer extends BaseDisplayContainer {
    VideoAdPlayer getPlayer();

    @Deprecated
    void setPlayer(VideoAdPlayer videoAdPlayer);
}

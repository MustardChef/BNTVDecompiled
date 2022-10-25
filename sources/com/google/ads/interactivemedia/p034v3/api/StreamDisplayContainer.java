package com.google.ads.interactivemedia.p034v3.api;

import com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.StreamDisplayContainer */
/* loaded from: classes2.dex */
public interface StreamDisplayContainer extends BaseDisplayContainer {
    VideoStreamPlayer getVideoStreamPlayer();

    @Deprecated
    void setVideoStreamPlayer(VideoStreamPlayer videoStreamPlayer);
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.p034v3.api.StreamDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoStreamPlayer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akq */
/* loaded from: classes2.dex */
public final class akq extends aja implements StreamDisplayContainer {

    /* renamed from: a */
    private VideoStreamPlayer f4314a;

    public akq(ViewGroup viewGroup, VideoStreamPlayer videoStreamPlayer) {
        super(viewGroup);
        this.f4314a = videoStreamPlayer;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamDisplayContainer
    public final VideoStreamPlayer getVideoStreamPlayer() {
        return this.f4314a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.StreamDisplayContainer
    public final void setVideoStreamPlayer(VideoStreamPlayer videoStreamPlayer) {
        atm.m4612j(videoStreamPlayer);
        this.f4314a = videoStreamPlayer;
    }
}

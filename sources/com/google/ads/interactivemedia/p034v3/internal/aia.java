package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aia */
/* loaded from: classes2.dex */
public final class aia extends aja implements AdDisplayContainer {

    /* renamed from: a */
    private VideoAdPlayer f4120a;

    public aia(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
        super(viewGroup);
        this.f4120a = videoAdPlayer;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer
    public final VideoAdPlayer getPlayer() {
        return this.f4120a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer
    public final void setPlayer(VideoAdPlayer videoAdPlayer) {
        atm.m4612j(videoAdPlayer);
        this.f4120a = videoAdPlayer;
    }

    public aia(Context context, VideoAdPlayer videoAdPlayer) {
        this(new aiw(context), videoAdPlayer);
    }
}

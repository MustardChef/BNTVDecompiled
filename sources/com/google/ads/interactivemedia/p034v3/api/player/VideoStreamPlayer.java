package com.google.ads.interactivemedia.p034v3.api.player;

import java.util.HashMap;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer */
/* loaded from: classes2.dex */
public interface VideoStreamPlayer extends ContentProgressProvider, VolumeProvider {

    /* compiled from: IMASDK */
    /* renamed from: com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer$VideoStreamPlayerCallback */
    /* loaded from: classes2.dex */
    public interface VideoStreamPlayerCallback {
        void onContentComplete();

        void onPause();

        void onResume();

        void onUserTextReceived(String str);

        void onVolumeChanged(int i);
    }

    void addCallback(VideoStreamPlayerCallback videoStreamPlayerCallback);

    void loadUrl(String str, List<HashMap<String, String>> list);

    void onAdBreakEnded();

    void onAdBreakStarted();

    void onAdPeriodEnded();

    void onAdPeriodStarted();

    void pause();

    void removeCallback(VideoStreamPlayerCallback videoStreamPlayerCallback);

    void resume();

    void seek(long j);
}

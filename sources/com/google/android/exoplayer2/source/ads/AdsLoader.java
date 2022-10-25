package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.p036ui.AdViewProvider;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;

/* loaded from: classes2.dex */
public interface AdsLoader {

    /* loaded from: classes2.dex */
    public interface EventListener {

        /* renamed from: com.google.android.exoplayer2.source.ads.AdsLoader$EventListener$-CC  reason: invalid class name */
        /* loaded from: classes2.dex */
        public final /* synthetic */ class CC {
            public static void $default$onAdClicked(EventListener eventListener) {
            }

            public static void $default$onAdLoadError(EventListener eventListener, AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec) {
            }

            public static void $default$onAdPlaybackState(EventListener eventListener, AdPlaybackState adPlaybackState) {
            }

            public static void $default$onAdTapped(EventListener eventListener) {
            }
        }

        void onAdClicked();

        void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec);

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();
    }

    void handlePrepareComplete(AdsMediaSource adsMediaSource, int i, int i2);

    void handlePrepareError(AdsMediaSource adsMediaSource, int i, int i2, IOException iOException);

    void release();

    void setPlayer(Player player);

    void setSupportedContentTypes(int... iArr);

    void start(AdsMediaSource adsMediaSource, DataSpec dataSpec, Object obj, AdViewProvider adViewProvider, EventListener eventListener);

    void stop(AdsMediaSource adsMediaSource, EventListener eventListener);
}

package com.google.android.exoplayer2.ext.mediasession;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.p002v4.media.MediaDescriptionCompat;
import android.support.p002v4.media.session.MediaSessionCompat;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
public abstract class TimelineQueueNavigator implements MediaSessionConnector.QueueNavigator {
    public static final int DEFAULT_MAX_QUEUE_SIZE = 10;
    private long activeQueueItemId;
    private final int maxQueueSize;
    private final MediaSessionCompat mediaSession;
    private final Timeline.Window window;

    public abstract MediaDescriptionCompat getMediaDescription(Player player, int i);

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.CommandReceiver
    public boolean onCommand(Player player, String str, Bundle bundle, ResultReceiver resultReceiver) {
        return false;
    }

    public TimelineQueueNavigator(MediaSessionCompat mediaSessionCompat) {
        this(mediaSessionCompat, 10);
    }

    public TimelineQueueNavigator(MediaSessionCompat mediaSessionCompat, int i) {
        Assertions.checkState(i > 0);
        this.mediaSession = mediaSessionCompat;
        this.maxQueueSize = i;
        this.activeQueueItemId = -1L;
        this.window = new Timeline.Window();
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
    public long getSupportedQueueNavigatorActions(Player player) {
        boolean z;
        boolean z2;
        Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty() || player.isPlayingAd()) {
            z = false;
            z2 = false;
        } else {
            currentTimeline.getWindow(player.getCurrentMediaItemIndex(), this.window);
            boolean z3 = currentTimeline.getWindowCount() > 1;
            z2 = player.isCommandAvailable(5) || !this.window.isLive() || player.isCommandAvailable(6);
            z = (this.window.isLive() && this.window.isDynamic) || player.isCommandAvailable(8);
            r2 = z3;
        }
        long j = r2 ? 4096L : 0L;
        if (z2) {
            j |= 16;
        }
        return z ? j | 32 : j;
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
    public final void onTimelineChanged(Player player) {
        publishFloatingQueueWindow(player);
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
    public final void onCurrentMediaItemIndexChanged(Player player) {
        if (this.activeQueueItemId == -1 || player.getCurrentTimeline().getWindowCount() > this.maxQueueSize) {
            publishFloatingQueueWindow(player);
        } else if (player.getCurrentTimeline().isEmpty()) {
        } else {
            this.activeQueueItemId = player.getCurrentMediaItemIndex();
        }
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
    public final long getActiveQueueItemId(Player player) {
        return this.activeQueueItemId;
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
    public void onSkipToPrevious(Player player) {
        player.seekToPrevious();
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
    public void onSkipToQueueItem(Player player, long j) {
        int i;
        Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty() || player.isPlayingAd() || (i = (int) j) < 0 || i >= currentTimeline.getWindowCount()) {
            return;
        }
        player.seekToDefaultPosition(i);
    }

    @Override // com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector.QueueNavigator
    public void onSkipToNext(Player player) {
        player.seekToNext();
    }

    private void publishFloatingQueueWindow(Player player) {
        Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            this.mediaSession.setQueue(Collections.emptyList());
            this.activeQueueItemId = -1L;
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int min = Math.min(this.maxQueueSize, currentTimeline.getWindowCount());
        int currentMediaItemIndex = player.getCurrentMediaItemIndex();
        long j = currentMediaItemIndex;
        arrayDeque.add(new MediaSessionCompat.QueueItem(getMediaDescription(player, currentMediaItemIndex), j));
        boolean shuffleModeEnabled = player.getShuffleModeEnabled();
        int i = currentMediaItemIndex;
        while (true) {
            if ((currentMediaItemIndex != -1 || i != -1) && arrayDeque.size() < min) {
                if (i != -1 && (i = currentTimeline.getNextWindowIndex(i, 0, shuffleModeEnabled)) != -1) {
                    arrayDeque.add(new MediaSessionCompat.QueueItem(getMediaDescription(player, i), i));
                }
                if (currentMediaItemIndex != -1 && arrayDeque.size() < min && (currentMediaItemIndex = currentTimeline.getPreviousWindowIndex(currentMediaItemIndex, 0, shuffleModeEnabled)) != -1) {
                    arrayDeque.addFirst(new MediaSessionCompat.QueueItem(getMediaDescription(player, currentMediaItemIndex), currentMediaItemIndex));
                }
            }
        }
        this.mediaSession.setQueue(new ArrayList(arrayDeque));
        this.activeQueueItemId = j;
    }
}

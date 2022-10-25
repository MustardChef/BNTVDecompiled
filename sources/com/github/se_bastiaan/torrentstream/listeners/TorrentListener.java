package com.github.se_bastiaan.torrentstream.listeners;

import com.github.se_bastiaan.torrentstream.StreamStatus;
import com.github.se_bastiaan.torrentstream.Torrent;

/* loaded from: classes2.dex */
public interface TorrentListener {
    void onStreamError(Torrent torrent, Exception exc);

    void onStreamPrepared(Torrent torrent);

    void onStreamProgress(Torrent torrent, StreamStatus streamStatus);

    void onStreamReady(Torrent torrent);

    void onStreamStarted(Torrent torrent);

    void onStreamStopped();
}

package com.github.se_bastiaan.torrentstream.exceptions;

/* loaded from: classes2.dex */
public class NotInitializedException extends Exception {
    public NotInitializedException() {
        super("TorrentStreamer is not initialized. Call init() first before getting an instance.");
    }
}

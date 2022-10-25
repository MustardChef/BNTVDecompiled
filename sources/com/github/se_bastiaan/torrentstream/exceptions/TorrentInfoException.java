package com.github.se_bastiaan.torrentstream.exceptions;

/* loaded from: classes2.dex */
public class TorrentInfoException extends Exception {
    public TorrentInfoException(Throwable th) {
        super("No torrent info could be found or read", th);
    }
}

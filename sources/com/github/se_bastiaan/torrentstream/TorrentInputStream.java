package com.github.se_bastiaan.torrentstream;

import com.frostwire.jlibtorrent.AlertListener;
import com.frostwire.jlibtorrent.alerts.Alert;
import com.frostwire.jlibtorrent.alerts.AlertType;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
class TorrentInputStream extends FilterInputStream implements AlertListener {
    private long location;
    private boolean stopped;
    private Torrent torrent;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TorrentInputStream(Torrent torrent, InputStream inputStream) {
        super(inputStream);
        this.torrent = torrent;
    }

    protected void finalize() throws Throwable {
        synchronized (this) {
            this.stopped = true;
            notifyAll();
        }
        super.finalize();
    }

    private synchronized boolean waitForPiece(long j) {
        while (!Thread.currentThread().isInterrupted() && !this.stopped) {
            try {
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.torrent.hasBytes(j)) {
                return true;
            }
            wait();
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        if (waitForPiece(this.location)) {
            this.location++;
            return super.read();
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int pieceLength = this.torrent.getTorrentHandle().torrentFile().pieceLength();
        for (int i3 = 0; i3 < i2; i3 += pieceLength) {
            if (!waitForPiece(this.location + i3)) {
                return -1;
            }
        }
        this.location += i2;
        return super.read(bArr, i, i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.stopped = true;
            notifyAll();
        }
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        this.location += j;
        return super.skip(j);
    }

    private synchronized void pieceFinished() {
        notifyAll();
    }

    @Override // com.frostwire.jlibtorrent.AlertListener
    public int[] types() {
        return new int[]{AlertType.PIECE_FINISHED.swig()};
    }

    /* renamed from: com.github.se_bastiaan.torrentstream.TorrentInputStream$1 */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C24341 {
        static final /* synthetic */ int[] $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType;

        static {
            int[] iArr = new int[AlertType.values().length];
            $SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType = iArr;
            try {
                iArr[AlertType.PIECE_FINISHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.frostwire.jlibtorrent.AlertListener
    public void alert(Alert<?> alert) {
        if (C24341.$SwitchMap$com$frostwire$jlibtorrent$alerts$AlertType[alert.type().ordinal()] != 1) {
            return;
        }
        pieceFinished();
    }
}

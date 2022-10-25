package com.frostwire.jlibtorrent;

import java.util.Iterator;

/* loaded from: classes2.dex */
public final class PiecesTracker {
    private final boolean[] complete;
    private final int[][] files;
    private final int numFiles;
    private final int numPieces;
    private final long[][] sizes;

    public PiecesTracker(TorrentInfo torrentInfo) {
        int numFiles = torrentInfo.numFiles();
        this.numFiles = numFiles;
        int numPieces = torrentInfo.numPieces();
        this.numPieces = numPieces;
        this.files = new int[numFiles];
        this.sizes = new long[numFiles];
        this.complete = new boolean[numPieces];
        FileStorage files = torrentInfo.files();
        for (int i = 0; i < this.numFiles; i++) {
            long fileSize = files.fileSize(i);
            int piece = torrentInfo.mapFile(i, 0L, 1).piece();
            int piece2 = torrentInfo.mapFile(i, fileSize - 1, 1).piece();
            int i2 = (piece2 - piece) + 1;
            this.files[i] = new int[i2];
            this.sizes[i] = new long[i2];
            for (int i3 = piece; i3 <= piece2; i3++) {
                int i4 = i3 - piece;
                this.files[i][i4] = i3;
                Iterator<FileSlice> it = torrentInfo.mapBlock(i3, 0L, torrentInfo.pieceSize(i3)).iterator();
                while (it.hasNext()) {
                    FileSlice next = it.next();
                    if (next.fileIndex() == i) {
                        this.sizes[i][i4] = next.size();
                    }
                }
            }
        }
    }

    public int numFiles() {
        return this.numFiles;
    }

    public int numPieces() {
        return this.numPieces;
    }

    public boolean isComplete(int i) {
        return this.complete[i];
    }

    public void setComplete(int i, boolean z) {
        this.complete[i] = z;
    }

    public long getSequentialDownloadedBytes(int i) {
        int[] iArr = this.files[i];
        long j = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!this.complete[iArr[i2]]) {
                break;
            }
            j += this.sizes[i][i2];
        }
        return j;
    }

    public int getSequentialDownloadedPieces(int i) {
        int i2 = 0;
        for (int i3 : this.files[i]) {
            if (!this.complete[i3]) {
                break;
            }
            i2++;
        }
        return i2;
    }
}

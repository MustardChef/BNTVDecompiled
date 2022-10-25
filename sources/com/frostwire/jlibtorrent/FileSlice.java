package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.file_slice;

/* loaded from: classes2.dex */
public final class FileSlice {
    private final int fileIndex;
    private final long offset;
    private final long size;

    public FileSlice(file_slice file_sliceVar) {
        this.fileIndex = file_sliceVar.getFile_index();
        this.offset = file_sliceVar.getOffset();
        this.size = file_sliceVar.getSize();
    }

    public int fileIndex() {
        return this.fileIndex;
    }

    public long offset() {
        return this.offset;
    }

    public long size() {
        return this.size;
    }

    public String toString() {
        return String.format("FileSlice(fileIndex: %d, offset: %d, size: %d)", Integer.valueOf(this.fileIndex), Long.valueOf(this.offset), Long.valueOf(this.size));
    }
}

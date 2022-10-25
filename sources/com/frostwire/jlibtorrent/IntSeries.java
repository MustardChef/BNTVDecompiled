package com.frostwire.jlibtorrent;

/* loaded from: classes2.dex */
public final class IntSeries {
    private final long[] buffer;
    private int end;
    private int head;
    private int size;

    IntSeries(long[] jArr) {
        if (jArr == null) {
            throw new IllegalArgumentException("buffer to hold data can't be null");
        }
        if (jArr.length == 0) {
            throw new IllegalArgumentException("buffer to hold data can't be of size 0");
        }
        this.buffer = jArr;
        this.head = -1;
        this.end = -1;
        this.size = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntSeries(int i) {
        this(new long[i]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(long j) {
        int i = this.head;
        if (i == -1) {
            this.end = 0;
            this.head = 0;
            this.buffer[0] = j;
            this.size = 1;
            return;
        }
        long[] jArr = this.buffer;
        int length = (this.end + 1) % jArr.length;
        this.end = length;
        jArr[length] = j;
        if (length <= i) {
            this.head = (i + 1) % jArr.length;
        }
        int i2 = this.head;
        if (i2 <= length) {
            this.size = (length - i2) + 1;
        } else {
            this.size = jArr.length;
        }
    }

    public long get(int i) {
        return this.buffer[(this.head + i) % this.size];
    }

    public long last() {
        int i = this.end;
        if (i != 0) {
            return this.buffer[i];
        }
        return 0L;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        int i = 0;
        while (true) {
            long[] jArr = this.buffer;
            if (i < jArr.length) {
                sb.append(jArr[i]);
                if (i != this.buffer.length - 1) {
                    sb.append(", ");
                }
                i++;
            } else {
                sb.append(" ]");
                return "{ head: " + this.head + ", end: " + this.end + ", size: " + size() + ", buffer: " + sb.toString() + " }";
            }
        }
    }
}

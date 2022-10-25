package com.fasterxml.jackson.core.util;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class ByteArrayBuilder extends OutputStream {
    static final int DEFAULT_BLOCK_ARRAY_SIZE = 40;
    private static final int INITIAL_BLOCK_SIZE = 500;
    private static final int MAX_BLOCK_SIZE = 131072;
    public static final byte[] NO_BYTES = new byte[0];
    private final BufferRecycler _bufferRecycler;
    private byte[] _currBlock;
    private int _currBlockPtr;
    private final LinkedList<byte[]> _pastBlocks;
    private int _pastLen;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public ByteArrayBuilder() {
        this((BufferRecycler) null);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler) {
        this(bufferRecycler, 500);
    }

    public ByteArrayBuilder(int i) {
        this(null, i);
    }

    public ByteArrayBuilder(BufferRecycler bufferRecycler, int i) {
        this._pastBlocks = new LinkedList<>();
        this._bufferRecycler = bufferRecycler;
        this._currBlock = bufferRecycler == null ? new byte[i > 131072 ? 131072 : i] : bufferRecycler.allocByteBuffer(2);
    }

    private ByteArrayBuilder(BufferRecycler bufferRecycler, byte[] bArr, int i) {
        this._pastBlocks = new LinkedList<>();
        this._bufferRecycler = null;
        this._currBlock = bArr;
        this._currBlockPtr = i;
    }

    public static ByteArrayBuilder fromInitial(byte[] bArr, int i) {
        return new ByteArrayBuilder(null, bArr, i);
    }

    public void reset() {
        this._pastLen = 0;
        this._currBlockPtr = 0;
        if (this._pastBlocks.isEmpty()) {
            return;
        }
        this._pastBlocks.clear();
    }

    public int size() {
        return this._pastLen + this._currBlockPtr;
    }

    public void release() {
        byte[] bArr;
        reset();
        BufferRecycler bufferRecycler = this._bufferRecycler;
        if (bufferRecycler == null || (bArr = this._currBlock) == null) {
            return;
        }
        bufferRecycler.releaseByteBuffer(2, bArr);
        this._currBlock = null;
    }

    public void append(int i) {
        if (this._currBlockPtr >= this._currBlock.length) {
            _allocMore();
        }
        byte[] bArr = this._currBlock;
        int i2 = this._currBlockPtr;
        this._currBlockPtr = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void appendTwoBytes(int i) {
        int i2 = this._currBlockPtr;
        int i3 = i2 + 1;
        byte[] bArr = this._currBlock;
        if (i3 < bArr.length) {
            int i4 = i2 + 1;
            this._currBlockPtr = i4;
            bArr[i2] = (byte) (i >> 8);
            this._currBlockPtr = i4 + 1;
            bArr[i4] = (byte) i;
            return;
        }
        append(i >> 8);
        append(i);
    }

    public void appendThreeBytes(int i) {
        int i2 = this._currBlockPtr;
        int i3 = i2 + 2;
        byte[] bArr = this._currBlock;
        if (i3 < bArr.length) {
            int i4 = i2 + 1;
            this._currBlockPtr = i4;
            bArr[i2] = (byte) (i >> 16);
            int i5 = i4 + 1;
            this._currBlockPtr = i5;
            bArr[i4] = (byte) (i >> 8);
            this._currBlockPtr = i5 + 1;
            bArr[i5] = (byte) i;
            return;
        }
        append(i >> 16);
        append(i >> 8);
        append(i);
    }

    public void appendFourBytes(int i) {
        int i2 = this._currBlockPtr;
        int i3 = i2 + 3;
        byte[] bArr = this._currBlock;
        if (i3 < bArr.length) {
            int i4 = i2 + 1;
            this._currBlockPtr = i4;
            bArr[i2] = (byte) (i >> 24);
            int i5 = i4 + 1;
            this._currBlockPtr = i5;
            bArr[i4] = (byte) (i >> 16);
            int i6 = i5 + 1;
            this._currBlockPtr = i6;
            bArr[i5] = (byte) (i >> 8);
            this._currBlockPtr = i6 + 1;
            bArr[i6] = (byte) i;
            return;
        }
        append(i >> 24);
        append(i >> 16);
        append(i >> 8);
        append(i);
    }

    public byte[] toByteArray() {
        int i = this._pastLen + this._currBlockPtr;
        if (i == 0) {
            return NO_BYTES;
        }
        byte[] bArr = new byte[i];
        Iterator<byte[]> it = this._pastBlocks.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this._currBlock, 0, bArr, i2, this._currBlockPtr);
        int i3 = i2 + this._currBlockPtr;
        if (i3 != i) {
            throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
        }
        if (!this._pastBlocks.isEmpty()) {
            reset();
        }
        return bArr;
    }

    public byte[] resetAndGetFirstSegment() {
        reset();
        return this._currBlock;
    }

    public byte[] finishCurrentSegment() {
        _allocMore();
        return this._currBlock;
    }

    public byte[] completeAndCoalesce(int i) {
        this._currBlockPtr = i;
        return toByteArray();
    }

    public byte[] getCurrentSegment() {
        return this._currBlock;
    }

    public void setCurrentSegmentLength(int i) {
        this._currBlockPtr = i;
    }

    public int getCurrentSegmentLength() {
        return this._currBlockPtr;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        while (true) {
            int min = Math.min(this._currBlock.length - this._currBlockPtr, i2);
            if (min > 0) {
                System.arraycopy(bArr, i, this._currBlock, this._currBlockPtr, min);
                i += min;
                this._currBlockPtr += min;
                i2 -= min;
            }
            if (i2 <= 0) {
                return;
            }
            _allocMore();
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        append(i);
    }

    private void _allocMore() {
        int length = this._pastLen + this._currBlock.length;
        if (length < 0) {
            throw new IllegalStateException("Maximum Java array size (2GB) exceeded by `ByteArrayBuilder`");
        }
        this._pastLen = length;
        int max = Math.max(length >> 1, 1000);
        if (max > 131072) {
            max = 131072;
        }
        this._pastBlocks.add(this._currBlock);
        this._currBlock = new byte[max];
        this._currBlockPtr = 0;
    }
}

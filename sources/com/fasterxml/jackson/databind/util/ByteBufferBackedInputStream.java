package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferBackedInputStream extends InputStream {

    /* renamed from: _b */
    protected final ByteBuffer f2800_b;

    public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
        this.f2800_b = byteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f2800_b.remaining();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f2800_b.hasRemaining()) {
            return this.f2800_b.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f2800_b.hasRemaining()) {
            int min = Math.min(i2, this.f2800_b.remaining());
            this.f2800_b.get(bArr, i, min);
            return min;
        }
        return -1;
    }
}

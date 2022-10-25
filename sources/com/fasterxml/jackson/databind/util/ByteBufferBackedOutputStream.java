package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferBackedOutputStream extends OutputStream {

    /* renamed from: _b */
    protected final ByteBuffer f2801_b;

    public ByteBufferBackedOutputStream(ByteBuffer byteBuffer) {
        this.f2801_b = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.f2801_b.put((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.f2801_b.put(bArr, i, i2);
    }
}

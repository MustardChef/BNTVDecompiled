package com.hippo.unifile;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface UniRandomAccessFile {
    void close() throws IOException;

    long getFilePointer() throws IOException;

    long length() throws IOException;

    void read(byte[] bArr) throws IOException;

    void read(byte[] bArr, int i, int i2) throws IOException;

    void seek(long j) throws IOException;

    void setLength(long j) throws IOException;

    int skipBytes(int i) throws IOException;

    void write(byte[] bArr) throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}

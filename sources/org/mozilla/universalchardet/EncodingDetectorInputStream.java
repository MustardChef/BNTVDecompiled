package org.mozilla.universalchardet;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public class EncodingDetectorInputStream extends InputStream {
    private final UniversalDetector detector = new UniversalDetector(null);

    /* renamed from: in */
    private InputStream f10802in;

    public EncodingDetectorInputStream(InputStream inputStream) {
        this.f10802in = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f10802in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10802in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f10802in.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f10802in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) >= 0) {
            return bArr[0];
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f10802in.read(bArr, i, i2);
        if (!this.detector.isDone() && read > 0) {
            this.detector.handleData(bArr, i, read);
        }
        if (read == -1) {
            this.detector.dataEnd();
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f10802in.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.detector.isDone()) {
            return this.f10802in.skip(j);
        }
        int i = 0;
        long j2 = -1;
        for (long j3 = 0; j3 < j && i >= 0; j3++) {
            i = this.f10802in.read();
            j2++;
        }
        return j2;
    }

    public String getDetectedCharset() {
        return this.detector.getDetectedCharset();
    }
}

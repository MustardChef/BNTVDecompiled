package org.mozilla.universalchardet;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class EncodingDetectorOutputStream extends OutputStream {
    private final UniversalDetector detector = new UniversalDetector(null);
    private OutputStream out;

    public EncodingDetectorOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
        this.detector.dataEnd();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        if (this.detector.isDone()) {
            return;
        }
        this.detector.handleData(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public String getDetectedCharset() {
        return this.detector.getDetectedCharset();
    }
}

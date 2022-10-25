package org.jsoup.internal;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import org.jsoup.helper.Validate;

/* loaded from: classes.dex */
public final class ConstrainableInputStream extends BufferedInputStream {
    private static final int DefaultSize = 32768;
    private final boolean capped;
    private boolean interrupted;
    private final int maxSize;
    private int remaining;
    private long startTime;
    private long timeout;

    private ConstrainableInputStream(InputStream inputStream, int i, int i2) {
        super(inputStream, i);
        this.timeout = 0L;
        Validate.isTrue(i2 >= 0);
        this.maxSize = i2;
        this.remaining = i2;
        this.capped = i2 != 0;
        this.startTime = System.nanoTime();
    }

    public static ConstrainableInputStream wrap(InputStream inputStream, int i, int i2) {
        if (inputStream instanceof ConstrainableInputStream) {
            return (ConstrainableInputStream) inputStream;
        }
        return new ConstrainableInputStream(inputStream, i, i2);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.interrupted || (this.capped && this.remaining <= 0)) {
            return -1;
        }
        if (Thread.interrupted()) {
            this.interrupted = true;
            return -1;
        } else if (expired()) {
            throw new SocketTimeoutException("Read timeout");
        } else {
            if (this.capped && i2 > (i3 = this.remaining)) {
                i2 = i3;
            }
            try {
                int read = super.read(bArr, i, i2);
                this.remaining -= read;
                return read;
            } catch (SocketTimeoutException unused) {
                return 0;
            }
        }
    }

    public ByteBuffer readToByteBuffer(int i) throws IOException {
        Validate.isTrue(i >= 0, "maxSize must be 0 (unlimited) or larger");
        boolean z = i > 0;
        int i2 = 32768;
        if (z && i < 32768) {
            i2 = i;
        }
        byte[] bArr = new byte[i2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                break;
            }
            if (z) {
                if (read >= i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.remaining = this.maxSize - this.markpos;
    }

    public ConstrainableInputStream timeout(long j, long j2) {
        this.startTime = j;
        this.timeout = j2 * 1000000;
        return this;
    }

    private boolean expired() {
        return this.timeout != 0 && System.nanoTime() - this.startTime > this.timeout;
    }
}

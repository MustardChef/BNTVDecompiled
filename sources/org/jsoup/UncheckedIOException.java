package org.jsoup;

import java.io.IOException;

/* loaded from: classes4.dex */
public class UncheckedIOException extends RuntimeException {
    public UncheckedIOException(IOException iOException) {
        super(iOException);
    }

    public UncheckedIOException(String str) {
        super(new IOException(str));
    }

    public IOException ioException() {
        return (IOException) getCause();
    }
}

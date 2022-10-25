package com.frostwire.jlibtorrent;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
final class Files {
    private static final int EOF = -1;

    private Files() {
    }

    public static byte[] bytes(File file) throws IOException {
        FileInputStream fileInputStream;
        try {
            fileInputStream = openInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] byteArray = toByteArray(fileInputStream, file.length());
            closeQuietly((InputStream) fileInputStream);
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly((InputStream) fileInputStream);
            throw th;
        }
    }

    private static FileInputStream openInputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            } else if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            } else {
                return new FileInputStream(file);
            }
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    private static byte[] toByteArray(InputStream inputStream, long j) throws IOException {
        if (j > 2147483647L) {
            throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
        }
        return toByteArray(inputStream, (int) j);
    }

    private static byte[] toByteArray(InputStream inputStream, int i) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
        }
        int i2 = 0;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Unexpected readed size. current: " + i2 + ", excepted: " + i);
    }

    static void closeQuietly(InputStream inputStream) {
        closeQuietly((Closeable) inputStream);
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}

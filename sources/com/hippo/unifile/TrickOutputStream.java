package com.hippo.unifile;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
class TrickOutputStream extends FileOutputStream {
    private final ParcelFileDescriptor mPfd;

    private TrickOutputStream(ParcelFileDescriptor parcelFileDescriptor, FileDescriptor fileDescriptor) {
        super(fileDescriptor);
        this.mPfd = parcelFileDescriptor;
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.mPfd.close();
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static OutputStream create(Context context, Uri uri, String str) throws IOException {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, str);
            if (openFileDescriptor == null) {
                throw new IOException("Can't get ParcelFileDescriptor");
            }
            FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
            if (fileDescriptor == null) {
                throw new IOException("Can't get FileDescriptor");
            }
            return new TrickOutputStream(openFileDescriptor, fileDescriptor);
        } catch (Exception unused) {
            throw new IOException("Can't get ParcelFileDescriptor");
        }
    }
}

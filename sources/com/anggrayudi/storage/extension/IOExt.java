package com.anggrayudi.storage.extension;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import kotlin.Metadata;

@Metadata(m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0004¨\u0006\u0005"}, m107d2 = {"closeStream", "", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "Ljava/io/Reader;", "storage_release"}, m106k = 2, m105mv = {1, 5, 1}, m103xi = 48)
/* renamed from: com.anggrayudi.storage.extension.IOUtils */
/* loaded from: classes.dex */
public final class IOExt {
    public static final void closeStream(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final void closeStream(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final void closeStream(Reader reader) {
        if (reader == null) {
            return;
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

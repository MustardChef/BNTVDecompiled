package org.acra.util;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;

/* compiled from: IOUtils.kt */
@Metadata(m108d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J/\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\tJ\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\rH\u0007¨\u0006\u0016"}, m107d2 = {"Lorg/acra/util/IOUtils;", "", "()V", "deleteFile", "", "file", "Ljava/io/File;", "deserialize", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", "clazz", "Ljava/lang/Class;", "s", "", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/io/Serializable;", "safeClose", "closeable", "Ljava/io/Closeable;", "serialize", "serializable", "writeStringToFile", "content", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class IOUtils {
    public static final IOUtils INSTANCE = new IOUtils();

    private IOUtils() {
    }

    @JvmStatic
    public static final void safeClose(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    @JvmStatic
    public static final void deleteFile(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (file.delete()) {
            return;
        }
        ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Could not delete file: ", file));
    }

    @JvmStatic
    public static final void writeStringToFile(File file, String content) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(content, "content");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        try {
            outputStreamWriter.write(content);
            outputStreamWriter.flush();
        } finally {
            safeClose(outputStreamWriter);
        }
    }

    public final String serialize(Serializable serializable) {
        Intrinsics.checkNotNullParameter(serializable, "serializable");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            Throwable th = null;
            objectOutputStream.writeObject(serializable);
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            kotlin.p043io.Closeable.closeFinally(objectOutputStream, th);
            return encodeToString;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final <T extends Serializable> T deserialize(Class<T> clazz, String str) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (str != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
                Throwable th = null;
                try {
                    Object readObject = objectInputStream.readObject();
                    if (clazz.isInstance(readObject)) {
                        T cast = clazz.cast(readObject);
                        kotlin.p043io.Closeable.closeFinally(objectInputStream, th);
                        return cast;
                    }
                    Unit unit = Unit.INSTANCE;
                    kotlin.p043io.Closeable.closeFinally(objectInputStream, th);
                } finally {
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }
}

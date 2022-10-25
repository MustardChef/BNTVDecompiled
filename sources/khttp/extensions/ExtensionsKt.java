package khttp.extensions;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.io.Writer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import khttp.structures.files.FileLike;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Extensions.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0005\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004\u001a&\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u0002H\t0\b0\u0007\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\bH\u0000\u001a6\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u0010\u001a7\u0010\u0011\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u0012\u001a\u0002H\f2\u0006\u0010\u0013\u001a\u0002H\r¢\u0006\u0002\u0010\u0014\u001a\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016\u001a\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0007*\u00020\u0016\u001a\u0014\u0010\u0019\u001a\u00020\u000b*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0000¨\u0006\u001c"}, m107d2 = {"fileLike", "Lkhttp/structures/files/FileLike;", "Ljava/io/File;", "name", "", "Ljava/nio/file/Path;", "getSuperclasses", "", "Ljava/lang/Class;", ExifInterface.GPS_DIRECTION_TRUE, "putAllIfAbsentWithNull", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "other", "", "putIfAbsentWithNull", SDKConstants.PARAM_KEY, "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "split", "", TtmlNode.RUBY_DELIMITER, "splitLines", "writeAndFlush", "Ljava/io/Writer;", TypedValues.Custom.S_STRING, "library_release"}, m106k = 2, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class ExtensionsKt {
    public static final FileLike fileLike(File receiver$0, String name) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return new FileLike(name, receiver$0);
    }

    public static /* synthetic */ FileLike fileLike$default(File file, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = file.getName();
            Intrinsics.checkExpressionValueIsNotNull(str, "this.name");
        }
        return fileLike(file, str);
    }

    public static final FileLike fileLike(Path receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        return new FileLike(receiver$0);
    }

    public static final FileLike fileLike(Path receiver$0, String name) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return new FileLike(name, receiver$0);
    }

    public static final FileLike fileLike(String receiver$0, String name) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return new FileLike(name, receiver$0);
    }

    public static final void writeAndFlush(Writer receiver$0, String string) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(string, "string");
        receiver$0.write(string);
        receiver$0.flush();
    }

    public static final List<byte[]> splitLines(byte[] receiver$0) {
        int i;
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        if (receiver$0.length == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int length = receiver$0.length;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            byte b = receiver$0[i4];
            if (i3 > 0) {
                i3--;
            } else {
                byte b2 = (byte) 10;
                if (b == b2) {
                    arrayList.add(ArraysKt.sliceArray(receiver$0, RangesKt.until(i2, i4)));
                } else {
                    byte b3 = (byte) 13;
                    if (b == b3 && (i = i4 + 1) < receiver$0.length && receiver$0[i] == b2) {
                        arrayList.add(ArraysKt.sliceArray(receiver$0, RangesKt.until(i2, i4)));
                        i2 = i4 + 2;
                        i3 = 1;
                    } else if (b == b3) {
                        arrayList.add(ArraysKt.sliceArray(receiver$0, RangesKt.until(i2, i4)));
                    }
                }
                i2 = i4 + 1;
            }
        }
        arrayList.add(ArraysKt.sliceArray(receiver$0, RangesKt.until(i2, receiver$0.length)));
        return arrayList;
    }

    public static final List<byte[]> split(byte[] receiver$0, byte[] delimiter) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(delimiter, "delimiter");
        ArrayList arrayList = new ArrayList();
        int length = receiver$0.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 > 0) {
                i2--;
            } else if (Arrays.equals(ArraysKt.sliceArray(receiver$0, RangesKt.until(i3, delimiter.length + i3)), delimiter)) {
                i2 = delimiter.length;
                arrayList.add(ArraysKt.sliceArray(receiver$0, RangesKt.until(i, i3)));
                i = delimiter.length + i3;
            }
        }
        arrayList.add(ArraysKt.sliceArray(receiver$0, RangesKt.until(i, receiver$0.length)));
        return arrayList;
    }

    public static final <T> List<Class<? super T>> getSuperclasses(Class<T> receiver$0) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        ArrayList arrayList = new ArrayList();
        for (Class<? super T> superclass = receiver$0.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        return arrayList;
    }

    public static final <K, V> void putIfAbsentWithNull(Map<K, V> receiver$0, K k, V v) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        if (receiver$0.containsKey(k)) {
            return;
        }
        receiver$0.put(k, v);
    }

    public static final <K, V> void putAllIfAbsentWithNull(Map<K, V> receiver$0, Map<K, ? extends V> other) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(other, "other");
        for (Map.Entry<K, ? extends V> entry : other.entrySet()) {
            putIfAbsentWithNull(receiver$0, entry.getKey(), entry.getValue());
        }
    }
}

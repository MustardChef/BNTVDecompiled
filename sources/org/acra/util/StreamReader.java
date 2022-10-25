package org.acra.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.Closeable;
import kotlin.p043io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: StreamReader.kt */
@Metadata(m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B9\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001b\u001a\u00020\u0003J\b\u0010\u001c\u001a\u00020\u0003H\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\u00020\u00002\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u001c\u0010\u001e\u001a\u00020\u000b*\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018¨\u0006$"}, m107d2 = {"Lorg/acra/util/StreamReader;", "", "filename", "", "(Ljava/lang/String;)V", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "inputStream", "Ljava/io/InputStream;", "limit", "", "timeout", "filter", "Lkotlin/Function1;", "", "(Ljava/io/InputStream;IILkotlin/jvm/functions/Function1;)V", "getFilter", "()Lkotlin/jvm/functions/Function1;", "setFilter", "(Lkotlin/jvm/functions/Function1;)V", "getLimit", "()I", "setLimit", "(I)V", "getTimeout", "setTimeout", "read", "readFully", "readWithTimeout", "readUntil", "buffer", "", "until", "", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class StreamReader {
    public static final Companion Companion = new Companion(null);
    private static final int INDEFINITE = -1;
    private static final int NO_LIMIT = -1;
    private Function1<? super String, Boolean> filter;
    private final InputStream inputStream;
    private int limit;
    private int timeout;

    public StreamReader(InputStream inputStream, int i, int i2, Function1<? super String, Boolean> function1) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        this.inputStream = inputStream;
        this.limit = i;
        this.timeout = i2;
        this.filter = function1;
    }

    public /* synthetic */ StreamReader(InputStream inputStream, int i, int i2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(inputStream, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? -1 : i2, (i3 & 8) != 0 ? null : function1);
    }

    public final Function1<String, Boolean> getFilter() {
        return this.filter;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    /* renamed from: setFilter  reason: collision with other method in class */
    public final void m10748setFilter(Function1<? super String, Boolean> function1) {
        this.filter = function1;
    }

    /* renamed from: setLimit  reason: collision with other method in class */
    public final void m10749setLimit(int i) {
        this.limit = i;
    }

    /* renamed from: setTimeout  reason: collision with other method in class */
    public final void m10750setTimeout(int i) {
        this.timeout = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StreamReader(String filename) {
        this(new File(filename));
        Intrinsics.checkNotNullParameter(filename, "filename");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StreamReader(File file) {
        this(new FileInputStream(file), 0, 0, null, 14, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    public final StreamReader setLimit(int i) {
        this.limit = i;
        return this;
    }

    public final StreamReader setTimeout(int i) {
        this.timeout = i;
        return this;
    }

    public final StreamReader setFilter(Function1<? super String, Boolean> function1) {
        this.filter = function1;
        return this;
    }

    public final String read() throws IOException {
        String joinToString$default;
        String readFully = this.timeout == -1 ? readFully() : readWithTimeout();
        Function1<? super String, Boolean> function1 = this.filter;
        if (function1 == null) {
            joinToString$default = null;
        } else {
            List arrayList = new ArrayList();
            for (Object obj : StringsKt.split$default((CharSequence) readFully, new String[]{"\\r?\\n"}, false, 0, 6, (Object) null)) {
                if (function1.invoke(obj).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            List list = arrayList;
            if (getLimit() != -1) {
                list = CollectionsKt.takeLast(list, getLimit());
            }
            joinToString$default = CollectionsKt.joinToString$default(list, "\n", null, null, 0, null, null, 62, null);
        }
        return joinToString$default == null ? this.limit == -1 ? readFully : CollectionsKt.joinToString$default(CollectionsKt.takeLast(StringsKt.split$default((CharSequence) readFully, new String[]{"\\r?\\n"}, false, 0, 6, (Object) null), this.limit), "\n", null, null, 0, null, null, 62, null) : joinToString$default;
    }

    private final String readFully() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(this.inputStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        Throwable th = null;
        try {
            String readText = TextStreamsKt.readText(bufferedReader);
            Closeable.closeFinally(bufferedReader, th);
            return readText;
        } finally {
        }
    }

    private final String readWithTimeout() throws IOException {
        long currentTimeMillis = System.currentTimeMillis() + this.timeout;
        InputStream inputStream = this.inputStream;
        Throwable th = null;
        try {
            InputStream inputStream2 = inputStream;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int readUntil = readUntil(inputStream2, bArr, currentTimeMillis);
                if (readUntil != -1) {
                    byteArrayOutputStream.write(bArr, 0, readUntil);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    Closeable.closeFinally(inputStream, th);
                    Intrinsics.checkNotNullExpressionValue(byteArrayOutputStream2, "inputStream.use { input ->\n            val output = ByteArrayOutputStream()\n            val buffer = ByteArray(ACRAConstants.DEFAULT_BUFFER_SIZE_IN_BYTES)\n            var count: Int\n            while (input.readUntil(buffer, until).also { count = it } != -1) {\n                output.write(buffer, 0, count)\n            }\n            output.toString()\n        }");
                    return byteArrayOutputStream2;
                }
            }
        } finally {
        }
    }

    private final int readUntil(InputStream inputStream, byte[] bArr, long j) throws IOException {
        int read;
        int i = 0;
        while (System.currentTimeMillis() < j && i < bArr.length && (read = inputStream.read(bArr, i, Math.min(this.inputStream.available(), bArr.length - i))) != -1) {
            i += read;
        }
        return i;
    }

    /* compiled from: StreamReader.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lorg/acra/util/StreamReader$Companion;", "", "()V", "INDEFINITE", "", "NO_LIMIT", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

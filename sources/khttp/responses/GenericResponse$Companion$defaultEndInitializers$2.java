package khttp.responses;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import khttp.structures.files.FileLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.p043io.Closeable;

/* compiled from: GenericResponse.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "response", "Lkhttp/responses/GenericResponse;", "connection", "Ljava/net/HttpURLConnection;", "invoke"}, m106k = 3, m105mv = {1, 1, 13})
/* loaded from: classes4.dex */
final class GenericResponse$Companion$defaultEndInitializers$2 extends Lambda implements Function2<GenericResponse, HttpURLConnection, Unit> {
    public static final GenericResponse$Companion$defaultEndInitializers$2 INSTANCE = new GenericResponse$Companion$defaultEndInitializers$2();

    GenericResponse$Companion$defaultEndInitializers$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(GenericResponse genericResponse, HttpURLConnection httpURLConnection) {
        invoke2(genericResponse, httpURLConnection);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(GenericResponse response, HttpURLConnection connection) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        Intrinsics.checkParameterIsNotNull(connection, "connection");
        List<FileLike> files = response.getRequest().getFiles();
        Object data = response.getRequest().getData();
        if (!files.isEmpty()) {
            return;
        }
        File file = (File) (!(data instanceof File) ? null : data);
        if (file != null) {
            data = new FileInputStream(file);
        } else if (!(data instanceof InputStream)) {
            data = null;
        }
        InputStream inputStream = (InputStream) data;
        if (inputStream == null) {
            return;
        }
        if (!connection.getDoOutput()) {
            connection.setDoOutput(true);
        }
        InputStream inputStream2 = inputStream;
        Throwable th = null;
        try {
            InputStream inputStream3 = inputStream2;
            OutputStream outputStream = connection.getOutputStream();
            Throwable th2 = null;
            OutputStream outputStream2 = outputStream;
            while (inputStream3.available() > 0) {
                byte[] bArr = new byte[Math.min(4096, inputStream3.available())];
                inputStream3.read(bArr);
                outputStream2.write(bArr);
            }
            Unit unit = Unit.INSTANCE;
            Closeable.closeFinally(outputStream, th2);
            Unit unit2 = Unit.INSTANCE;
            Closeable.closeFinally(inputStream2, th);
        } finally {
        }
    }
}

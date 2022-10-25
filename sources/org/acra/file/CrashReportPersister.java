package org.acra.file;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p043io.FilesKt;
import org.acra.data.CrashReportData;
import org.json.JSONException;

/* compiled from: CrashReportPersister.kt */
@Metadata(m108d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, m107d2 = {"Lorg/acra/file/CrashReportPersister;", "", "()V", "load", "Lorg/acra/data/CrashReportData;", "file", "Ljava/io/File;", "store", "", "crashData", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class CrashReportPersister {
    public final CrashReportData load(File file) throws IOException, JSONException {
        Intrinsics.checkNotNullParameter(file, "file");
        return new CrashReportData(FilesKt.readText$default(file, null, 1, null));
    }

    public final void store(CrashReportData crashData, File file) throws IOException, JSONException {
        Intrinsics.checkNotNullParameter(crashData, "crashData");
        Intrinsics.checkNotNullParameter(file, "file");
        FilesKt.writeText$default(file, crashData.toJSON(), null, 2, null);
    }
}

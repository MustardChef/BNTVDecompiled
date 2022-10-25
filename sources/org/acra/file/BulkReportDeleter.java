package org.acra.file;

import android.content.Context;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;

/* compiled from: BulkReportDeleter.kt */
@Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m107d2 = {"Lorg/acra/file/BulkReportDeleter;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "reportLocator", "Lorg/acra/file/ReportLocator;", "deleteReports", "", "approved", "", "nrToKeep", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class BulkReportDeleter {
    private final ReportLocator reportLocator;

    public BulkReportDeleter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.reportLocator = new ReportLocator(context);
    }

    public final void deleteReports(boolean z, int i) {
        List sortedWith = ArraysKt.sortedWith(z ? this.reportLocator.getApprovedReports() : this.reportLocator.getUnapprovedReports(), new Comparator<T>() { // from class: org.acra.file.BulkReportDeleter$deleteReports$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((File) t).lastModified()), Long.valueOf(((File) t2).lastModified()));
            }
        });
        int i2 = 0;
        int size = sortedWith.size() - i;
        if (size <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            if (!((File) sortedWith.get(i2)).delete()) {
                ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Could not delete report : ", sortedWith.get(i2)));
            }
            if (i3 >= size) {
                return;
            }
            i2 = i3;
        }
    }
}

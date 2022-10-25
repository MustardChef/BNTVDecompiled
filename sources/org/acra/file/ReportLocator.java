package org.acra.file;

import android.content.Context;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportLocator.kt */
@Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006\u0012"}, m107d2 = {"Lorg/acra/file/ReportLocator;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "approvedFolder", "Ljava/io/File;", "getApprovedFolder", "()Ljava/io/File;", "approvedReports", "", "getApprovedReports", "()[Ljava/io/File;", "unapprovedFolder", "getUnapprovedFolder", "unapprovedReports", "getUnapprovedReports", "Companion", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class ReportLocator {
    private static final String APPROVED_FOLDER_NAME = "ACRA-approved";
    public static final Companion Companion = new Companion(null);
    private static final String UNAPPROVED_FOLDER_NAME = "ACRA-unapproved";
    private final Context context;

    public ReportLocator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final File getUnapprovedFolder() {
        File dir = this.context.getDir(UNAPPROVED_FOLDER_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(dir, "context.getDir(UNAPPROVED_FOLDER_NAME, Context.MODE_PRIVATE)");
        return dir;
    }

    public final File[] getUnapprovedReports() {
        File[] listFiles = getUnapprovedFolder().listFiles();
        return listFiles == null ? new File[0] : listFiles;
    }

    public final File getApprovedFolder() {
        File dir = this.context.getDir(APPROVED_FOLDER_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(dir, "context.getDir(APPROVED_FOLDER_NAME, Context.MODE_PRIVATE)");
        return dir;
    }

    public final File[] getApprovedReports() {
        List sortedWith;
        File[] listFiles = getApprovedFolder().listFiles();
        File[] fileArr = null;
        if (listFiles != null && (sortedWith = ArraysKt.sortedWith(listFiles, new Comparator<T>() { // from class: org.acra.file.ReportLocator$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((File) t).lastModified()), Long.valueOf(((File) t2).lastModified()));
            }
        })) != null) {
            Object[] array = sortedWith.toArray(new File[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            fileArr = (File[]) array;
        }
        return fileArr == null ? new File[0] : fileArr;
    }

    /* compiled from: ReportLocator.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m107d2 = {"Lorg/acra/file/ReportLocator$Companion;", "", "()V", "APPROVED_FOLDER_NAME", "", "UNAPPROVED_FOLDER_NAME", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

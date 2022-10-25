package org.acra.startup;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Report.kt */
@Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m107d2 = {"Lorg/acra/startup/Report;", "", "file", "Ljava/io/File;", "approved", "", "(Ljava/io/File;Z)V", "approve", "getApprove", "()Z", "setApprove", "(Z)V", "getApproved", "delete", "getDelete", "setDelete", "getFile", "()Ljava/io/File;", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class Report {
    private boolean approve;
    private final boolean approved;
    private boolean delete;
    private final File file;

    public Report(File file, boolean z) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.approved = z;
    }

    public final boolean getApproved() {
        return this.approved;
    }

    public final File getFile() {
        return this.file;
    }

    public final boolean getDelete() {
        return this.delete;
    }

    public final void setDelete(boolean z) {
        this.delete = z;
    }

    public final boolean getApprove() {
        return this.approve;
    }

    public final void setApprove(boolean z) {
        this.approve = z;
    }
}

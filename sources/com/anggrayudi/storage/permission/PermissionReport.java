package com.anggrayudi.storage.permission;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionReport.kt */
@Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m107d2 = {"Lcom/anggrayudi/storage/permission/PermissionReport;", "", "permission", "", "isGranted", "", "deniedPermanently", "(Ljava/lang/String;ZZ)V", "getDeniedPermanently", "()Z", "getPermission", "()Ljava/lang/String;", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class PermissionReport {
    private final boolean deniedPermanently;
    private final boolean isGranted;
    private final String permission;

    public PermissionReport(String permission, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        this.permission = permission;
        this.isGranted = z;
        this.deniedPermanently = z2;
    }

    public final String getPermission() {
        return this.permission;
    }

    public final boolean isGranted() {
        return this.isGranted;
    }

    public final boolean getDeniedPermanently() {
        return this.deniedPermanently;
    }
}

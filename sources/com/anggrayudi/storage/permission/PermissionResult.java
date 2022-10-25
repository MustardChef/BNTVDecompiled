package com.anggrayudi.storage.permission;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionResult.kt */
@Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m107d2 = {"Lcom/anggrayudi/storage/permission/PermissionResult;", "", "permissions", "", "Lcom/anggrayudi/storage/permission/PermissionReport;", "(Ljava/util/List;)V", "areAllPermissionsGranted", "", "getAreAllPermissionsGranted", "()Z", "getPermissions", "()Ljava/util/List;", "storage_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes.dex */
public final class PermissionResult {
    private final List<PermissionReport> permissions;

    public PermissionResult(List<PermissionReport> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.permissions = permissions;
    }

    public final List<PermissionReport> getPermissions() {
        return this.permissions;
    }

    public final boolean getAreAllPermissionsGranted() {
        List<PermissionReport> list = this.permissions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (PermissionReport permissionReport : list) {
            if (!permissionReport.isGranted()) {
                return false;
            }
        }
        return true;
    }
}

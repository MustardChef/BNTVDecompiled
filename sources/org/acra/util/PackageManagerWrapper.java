package org.acra.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;

/* compiled from: PackageManagerWrapper.kt */
@Metadata(m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m107d2 = {"Lorg/acra/util/PackageManagerWrapper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "hasPermission", "", "permission", "", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class PackageManagerWrapper {
    private final Context context;

    public PackageManagerWrapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final boolean hasPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        try {
            return packageManager.checkPermission(permission, this.context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public final PackageInfo getPackageInfo() {
        PackageManager packageManager = this.context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            return packageManager.getPackageInfo(this.context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            ACRA.log.mo61w(ACRA.LOG_TAG, Intrinsics.stringPlus("Failed to find PackageInfo for current App : ", this.context.getPackageName()));
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }
}

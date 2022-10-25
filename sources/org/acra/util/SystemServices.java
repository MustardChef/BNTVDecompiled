package org.acra.util;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.os.DropBoxManager;
import android.telephony.TelephonyManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SystemServices.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0011"}, m107d2 = {"Lorg/acra/util/SystemServices;", "", "()V", "getActivityManager", "Landroid/app/ActivityManager;", "context", "Landroid/content/Context;", "getDropBoxManager", "Landroid/os/DropBoxManager;", "getNotificationManager", "Landroid/app/NotificationManager;", "getService", "id", "", "getTelephonyManager", "Landroid/telephony/TelephonyManager;", "ServiceNotReachedException", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
/* loaded from: classes4.dex */
public final class SystemServices {
    public static final SystemServices INSTANCE = new SystemServices();

    private SystemServices() {
    }

    @JvmStatic
    public static final TelephonyManager getTelephonyManager(Context context) throws ServiceNotReachedException {
        Intrinsics.checkNotNullParameter(context, "context");
        return (TelephonyManager) INSTANCE.getService(context, "phone");
    }

    @JvmStatic
    public static final DropBoxManager getDropBoxManager(Context context) throws ServiceNotReachedException {
        Intrinsics.checkNotNullParameter(context, "context");
        return (DropBoxManager) INSTANCE.getService(context, "dropbox");
    }

    @JvmStatic
    public static final NotificationManager getNotificationManager(Context context) throws ServiceNotReachedException {
        Intrinsics.checkNotNullParameter(context, "context");
        return (NotificationManager) INSTANCE.getService(context, "notification");
    }

    @JvmStatic
    public static final ActivityManager getActivityManager(Context context) throws ServiceNotReachedException {
        Intrinsics.checkNotNullParameter(context, "context");
        return (ActivityManager) INSTANCE.getService(context, "activity");
    }

    private final Object getService(Context context, String str) throws ServiceNotReachedException {
        Object systemService = context.getSystemService(str);
        if (systemService != null) {
            return systemService;
        }
        throw new ServiceNotReachedException(Intrinsics.stringPlus("Unable to load SystemService ", str));
    }

    /* compiled from: SystemServices.kt */
    @Metadata(m108d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m107d2 = {"Lorg/acra/util/SystemServices$ServiceNotReachedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "acra-core_release"}, m106k = 1, m105mv = {1, 5, 1}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class ServiceNotReachedException extends Exception {
        public ServiceNotReachedException(String str) {
            super(str);
        }
    }
}

package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;

/* loaded from: classes.dex */
public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    public static void setComponentEnabled(Context context, Class<?> klazz, boolean enabled) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, klazz.getName()), enabled ? 1 : 2, 1);
            Logger logger = Logger.get();
            String str = TAG;
            Object[] objArr = new Object[2];
            objArr[0] = klazz.getName();
            objArr[1] = enabled ? "enabled" : "disabled";
            logger.debug(str, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e) {
            Logger logger2 = Logger.get();
            String str2 = TAG;
            Object[] objArr2 = new Object[2];
            objArr2[0] = klazz.getName();
            objArr2[1] = enabled ? "enabled" : "disabled";
            logger2.debug(str2, String.format("%s could not be %s", objArr2), e);
        }
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> klazz) {
        return isComponentExplicitlyEnabled(context, klazz.getName());
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String className) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, className)) == 1;
    }
}

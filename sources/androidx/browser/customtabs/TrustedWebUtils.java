package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.BundleCompat;
import androidx.core.content.FileProvider;
import java.io.File;

/* loaded from: classes.dex */
public class TrustedWebUtils {
    public static final String ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA = "android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA";
    public static final String EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY = "android.support.customtabs.extra.LAUNCH_AS_TRUSTED_WEB_ACTIVITY";

    private TrustedWebUtils() {
    }

    public static void launchBrowserSiteSettings(Context context, CustomTabsSession session, Uri uri) {
        Intent intent = new Intent(ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA);
        intent.setPackage(session.getComponentName().getPackageName());
        intent.setData(uri);
        Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, CustomTabsIntent.EXTRA_SESSION, session.getBinder());
        intent.putExtras(bundle);
        PendingIntent id = session.getId();
        if (id != null) {
            intent.putExtra(CustomTabsIntent.EXTRA_SESSION_ID, id);
        }
        context.startActivity(intent);
    }

    public static boolean areSplashScreensSupported(Context context, String packageName, String version) {
        ResolveInfo resolveService = context.getPackageManager().resolveService(new Intent().setAction(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(packageName), 64);
        if (resolveService == null || resolveService.filter == null) {
            return false;
        }
        return resolveService.filter.hasCategory(version);
    }

    public static boolean transferSplashImage(Context context, File file, String fileProviderAuthority, String packageName, CustomTabsSession session) {
        Uri uriForFile = FileProvider.getUriForFile(context, fileProviderAuthority, file);
        context.grantUriPermission(packageName, uriForFile, 1);
        return session.receiveFile(uriForFile, 1, null);
    }

    @Deprecated
    public static void launchAsTrustedWebActivity(Context context, CustomTabsIntent customTabsIntent, Uri uri) {
        if (BundleCompat.getBinder(customTabsIntent.intent.getExtras(), CustomTabsIntent.EXTRA_SESSION) == null) {
            throw new IllegalArgumentException("Given CustomTabsIntent should be associated with a valid CustomTabsSession");
        }
        customTabsIntent.intent.putExtra(EXTRA_LAUNCH_AS_TRUSTED_WEB_ACTIVITY, true);
        customTabsIntent.launchUrl(context, uri);
    }
}

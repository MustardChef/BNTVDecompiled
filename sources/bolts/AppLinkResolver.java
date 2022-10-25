package bolts;

import android.net.Uri;

/* loaded from: classes.dex */
public interface AppLinkResolver {
    Task<AppLink> getAppLinkFromUrlInBackground(Uri uri);
}

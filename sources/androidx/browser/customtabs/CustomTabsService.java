package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import androidx.browser.customtabs.CustomTabsService;
import androidx.collection.SimpleArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class CustomTabsService extends Service {
    public static final String ACTION_CUSTOM_TABS_CONNECTION = "android.support.customtabs.action.CustomTabsService";
    public static final String CATEGORY_COLOR_SCHEME_CUSTOMIZATION = "androidx.browser.customtabs.category.ColorSchemeCustomization";
    public static final String CATEGORY_NAVBAR_COLOR_CUSTOMIZATION = "androidx.browser.customtabs.category.NavBarColorCustomization";
    public static final String CATEGORY_TRUSTED_WEB_ACTIVITY_IMMERSIVE_MODE = "androidx.browser.trusted.category.ImmersiveMode";
    public static final String CATEGORY_WEB_SHARE_TARGET_V2 = "androidx.browser.trusted.category.WebShareTargetV2";
    public static final int FILE_PURPOSE_TRUSTED_WEB_ACTIVITY_SPLASH_IMAGE = 1;
    public static final String KEY_SUCCESS = "androidx.browser.customtabs.SUCCESS";
    public static final String KEY_URL = "android.support.customtabs.otherurls.URL";
    public static final int RELATION_HANDLE_ALL_URLS = 2;
    public static final int RELATION_USE_AS_ORIGIN = 1;
    public static final int RESULT_FAILURE_DISALLOWED = -1;
    public static final int RESULT_FAILURE_MESSAGING_ERROR = -3;
    public static final int RESULT_FAILURE_REMOTE_ERROR = -2;
    public static final int RESULT_SUCCESS = 0;
    public static final String TRUSTED_WEB_ACTIVITY_CATEGORY = "androidx.browser.trusted.category.TrustedWebActivities";
    final SimpleArrayMap<IBinder, IBinder.DeathRecipient> mDeathRecipientMap = new SimpleArrayMap<>();
    private ICustomTabsService.Stub mBinder = new BinderC01981();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FilePurpose {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Relation {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Result {
    }

    protected abstract Bundle extraCommand(String commandName, Bundle args);

    protected abstract boolean mayLaunchUrl(CustomTabsSessionToken sessionToken, Uri url, Bundle extras, List<Bundle> otherLikelyBundles);

    protected abstract boolean newSession(CustomTabsSessionToken sessionToken);

    protected abstract int postMessage(CustomTabsSessionToken sessionToken, String message, Bundle extras);

    protected abstract boolean receiveFile(CustomTabsSessionToken sessionToken, Uri uri, int purpose, Bundle extras);

    protected abstract boolean requestPostMessageChannel(CustomTabsSessionToken sessionToken, Uri postMessageOrigin);

    protected abstract boolean updateVisuals(CustomTabsSessionToken sessionToken, Bundle bundle);

    protected abstract boolean validateRelationship(CustomTabsSessionToken sessionToken, int relation, Uri origin, Bundle extras);

    protected abstract boolean warmup(long flags);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.browser.customtabs.CustomTabsService$1 */
    /* loaded from: classes.dex */
    public class BinderC01981 extends ICustomTabsService.Stub {
        BinderC01981() {
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long flags) {
            return CustomTabsService.this.warmup(flags);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback callback) {
            return newSessionInternal(callback, null);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback callback, Bundle extras) {
            return newSessionInternal(callback, getSessionIdFromBundle(extras));
        }

        private boolean newSessionInternal(ICustomTabsCallback callback, PendingIntent sessionId) {
            final CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(callback, sessionId);
            try {
                IBinder.DeathRecipient deathRecipient = new IBinder.DeathRecipient() { // from class: androidx.browser.customtabs.-$$Lambda$CustomTabsService$1$-CrclSdcvxH0H-69DgvKLQ8BdJY
                    @Override // android.os.IBinder.DeathRecipient
                    public final void binderDied() {
                        CustomTabsService.BinderC01981.this.lambda$newSessionInternal$0$CustomTabsService$1(customTabsSessionToken);
                    }
                };
                synchronized (CustomTabsService.this.mDeathRecipientMap) {
                    callback.asBinder().linkToDeath(deathRecipient, 0);
                    CustomTabsService.this.mDeathRecipientMap.put(callback.asBinder(), deathRecipient);
                }
                return CustomTabsService.this.newSession(customTabsSessionToken);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public /* synthetic */ void lambda$newSessionInternal$0$CustomTabsService$1(CustomTabsSessionToken customTabsSessionToken) {
            CustomTabsService.this.cleanUpSession(customTabsSessionToken);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback callback, Uri url, Bundle extras, List<Bundle> otherLikelyBundles) {
            return CustomTabsService.this.mayLaunchUrl(new CustomTabsSessionToken(callback, getSessionIdFromBundle(extras)), url, extras, otherLikelyBundles);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String commandName, Bundle args) {
            return CustomTabsService.this.extraCommand(commandName, args);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback callback, Bundle bundle) {
            return CustomTabsService.this.updateVisuals(new CustomTabsSessionToken(callback, getSessionIdFromBundle(bundle)), bundle);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback callback, Uri postMessageOrigin) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(callback, null), postMessageOrigin);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback callback, Uri postMessageOrigin, Bundle extras) {
            return CustomTabsService.this.requestPostMessageChannel(new CustomTabsSessionToken(callback, getSessionIdFromBundle(extras)), postMessageOrigin);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback callback, String message, Bundle extras) {
            return CustomTabsService.this.postMessage(new CustomTabsSessionToken(callback, getSessionIdFromBundle(extras)), message, extras);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback callback, int relation, Uri origin, Bundle extras) {
            return CustomTabsService.this.validateRelationship(new CustomTabsSessionToken(callback, getSessionIdFromBundle(extras)), relation, origin, extras);
        }

        @Override // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback callback, Uri uri, int purpose, Bundle extras) {
            return CustomTabsService.this.receiveFile(new CustomTabsSessionToken(callback, getSessionIdFromBundle(extras)), uri, purpose, extras);
        }

        private PendingIntent getSessionIdFromBundle(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(CustomTabsIntent.EXTRA_SESSION_ID);
            bundle.remove(CustomTabsIntent.EXTRA_SESSION_ID);
            return pendingIntent;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    protected boolean cleanUpSession(CustomTabsSessionToken sessionToken) {
        try {
            synchronized (this.mDeathRecipientMap) {
                IBinder callbackBinder = sessionToken.getCallbackBinder();
                if (callbackBinder == null) {
                    return false;
                }
                callbackBinder.unlinkToDeath(this.mDeathRecipientMap.get(callbackBinder), 0);
                this.mDeathRecipientMap.remove(callbackBinder);
                return true;
            }
        } catch (NoSuchElementException unused) {
            return false;
        }
    }
}

package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;
import androidx.core.app.BundleCompat;

/* loaded from: classes.dex */
public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";
    private final CustomTabsCallback mCallback;
    final ICustomTabsCallback mCallbackBinder;
    private final PendingIntent mSessionId;

    /* loaded from: classes.dex */
    static class MockCallback extends ICustomTabsCallback.Stub {
        @Override // android.support.customtabs.ICustomTabsCallback.Stub, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String callbackName, Bundle args) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public Bundle extraCallbackWithResult(String callbackName, Bundle args) {
            return null;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle extras) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int navigationEvent, Bundle extras) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String message, Bundle extras) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int relation, Uri requestedOrigin, boolean result, Bundle extras) {
        }
    }

    public static CustomTabsSessionToken getSessionTokenFromIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        IBinder binder = BundleCompat.getBinder(extras, CustomTabsIntent.EXTRA_SESSION);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(CustomTabsIntent.EXTRA_SESSION_ID);
        if (binder == null && pendingIntent == null) {
            return null;
        }
        return new CustomTabsSessionToken(binder != null ? ICustomTabsCallback.Stub.asInterface(binder) : null, pendingIntent);
    }

    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new MockCallback(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomTabsSessionToken(ICustomTabsCallback callbackBinder, PendingIntent sessionId) {
        if (callbackBinder == null && sessionId == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.mCallbackBinder = callbackBinder;
        this.mSessionId = sessionId;
        this.mCallback = callbackBinder == null ? null : new CustomTabsCallback() { // from class: androidx.browser.customtabs.CustomTabsSessionToken.1
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onNavigationEvent(int navigationEvent, Bundle extras) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onNavigationEvent(navigationEvent, extras);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void extraCallback(String callbackName, Bundle args) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.extraCallback(callbackName, args);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public Bundle extraCallbackWithResult(String callbackName, Bundle args) {
                try {
                    return CustomTabsSessionToken.this.mCallbackBinder.extraCallbackWithResult(callbackName, args);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onMessageChannelReady(Bundle extras) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onMessageChannelReady(extras);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onPostMessage(String message, Bundle extras) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onPostMessage(message, extras);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onRelationshipValidationResult(int relation, Uri origin, boolean result, Bundle extras) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onRelationshipValidationResult(relation, origin, result, extras);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IBinder getCallbackBinder() {
        ICustomTabsCallback iCustomTabsCallback = this.mCallbackBinder;
        if (iCustomTabsCallback == null) {
            return null;
        }
        return iCustomTabsCallback.asBinder();
    }

    private IBinder getCallbackBinderAssertNotNull() {
        ICustomTabsCallback iCustomTabsCallback = this.mCallbackBinder;
        if (iCustomTabsCallback == null) {
            throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
        }
        return iCustomTabsCallback.asBinder();
    }

    PendingIntent getId() {
        return this.mSessionId;
    }

    public boolean hasCallback() {
        return this.mCallbackBinder != null;
    }

    public boolean hasId() {
        return this.mSessionId != null;
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.mSessionId;
        return pendingIntent != null ? pendingIntent.hashCode() : getCallbackBinderAssertNotNull().hashCode();
    }

    public boolean equals(Object o) {
        if (o instanceof CustomTabsSessionToken) {
            CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) o;
            PendingIntent id = customTabsSessionToken.getId();
            PendingIntent pendingIntent = this.mSessionId;
            if ((pendingIntent == null) != (id == null)) {
                return false;
            }
            if (pendingIntent != null) {
                return pendingIntent.equals(id);
            }
            return getCallbackBinderAssertNotNull().equals(customTabsSessionToken.getCallbackBinderAssertNotNull());
        }
        return false;
    }

    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    public boolean isAssociatedWith(CustomTabsSession session) {
        return session.getBinder().equals(this.mCallbackBinder);
    }
}

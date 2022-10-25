package androidx.browser.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

/* loaded from: classes.dex */
public class TrustedWebActivityCallbackRemote {
    private final ITrustedWebActivityCallback mCallbackBinder;

    private TrustedWebActivityCallbackRemote(ITrustedWebActivityCallback callbackBinder) {
        this.mCallbackBinder = callbackBinder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TrustedWebActivityCallbackRemote fromBinder(IBinder binder) {
        ITrustedWebActivityCallback asInterface = binder == null ? null : ITrustedWebActivityCallback.Stub.asInterface(binder);
        if (asInterface == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(asInterface);
    }

    public void runExtraCallback(String callbackName, Bundle args) throws RemoteException {
        this.mCallbackBinder.onExtraCallback(callbackName, args);
    }
}

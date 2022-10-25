package com.applovin.sdk;

import android.app.Activity;

/* loaded from: classes.dex */
public interface AppLovinUserService {

    /* loaded from: classes.dex */
    public interface OnConsentDialogDismissListener {
        void onDismiss();
    }

    void showConsentDialog(Activity activity, OnConsentDialogDismissListener onConsentDialogDismissListener);
}

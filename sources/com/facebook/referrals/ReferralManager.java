package com.facebook.referrals;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Validate;

/* loaded from: classes.dex */
public class ReferralManager {
    private static volatile ReferralManager instance;
    private ReferralLogger logger;

    ReferralManager() {
        Validate.sdkInitialized();
    }

    public static ReferralManager getInstance() {
        if (instance == null) {
            synchronized (ReferralManager.class) {
                if (instance == null) {
                    instance = new ReferralManager();
                }
            }
        }
        return instance;
    }

    public void startReferral(Activity activity) {
        startReferralImpl(new ActivityStartActivityDelegate(activity));
    }

    public void startReferral(Fragment fragment) {
        startReferralImpl(new FragmentStartActivityDelegate(new FragmentWrapper(fragment)));
    }

    public void startReferral(android.app.Fragment fragment) {
        startReferralImpl(new FragmentStartActivityDelegate(new FragmentWrapper(fragment)));
    }

    public void startReferral(FragmentWrapper fragmentWrapper) {
        startReferralImpl(new FragmentStartActivityDelegate(fragmentWrapper));
    }

    public void registerCallback(CallbackManager callbackManager, final FacebookCallback<ReferralResult> facebookCallback) {
        if (!(callbackManager instanceof CallbackManagerImpl)) {
            throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        }
        ((CallbackManagerImpl) callbackManager).registerCallback(ReferralClient.getReferralRequestCode(), new CallbackManagerImpl.Callback() { // from class: com.facebook.referrals.ReferralManager.1
            @Override // com.facebook.internal.CallbackManagerImpl.Callback
            public boolean onActivityResult(int i, Intent intent) {
                return ReferralManager.this.onActivityResult(i, intent, facebookCallback);
            }
        });
    }

    private void startReferralImpl(StartActivityDelegate startActivityDelegate) {
        ReferralLogger logger = getLogger(startActivityDelegate.getActivityContext());
        if (logger != null) {
            logger.logStartReferral();
        }
        if (tryFacebookActivity(startActivityDelegate)) {
            return;
        }
        FacebookException facebookException = new FacebookException("Failed to open Referral dialog: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        if (logger != null) {
            logger.logError(facebookException);
        }
        throw facebookException;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean onActivityResult(int r5, android.content.Intent r6, com.facebook.FacebookCallback<com.facebook.referrals.ReferralResult> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "error_message"
            java.lang.String r1 = "fb_referral_codes"
            r2 = -1
            r3 = 0
            if (r5 != r2) goto L32
            if (r6 == 0) goto L32
            android.os.Bundle r2 = r6.getExtras()     // Catch: org.json.JSONException -> L60
            if (r2 == 0) goto L32
            android.os.Bundle r2 = r6.getExtras()     // Catch: org.json.JSONException -> L60
            boolean r2 = r2.containsKey(r1)     // Catch: org.json.JSONException -> L60
            if (r2 == 0) goto L32
            android.os.Bundle r5 = r6.getExtras()     // Catch: org.json.JSONException -> L60
            java.lang.String r5 = r5.getString(r1)     // Catch: org.json.JSONException -> L60
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch: org.json.JSONException -> L60
            r6.<init>(r5)     // Catch: org.json.JSONException -> L60
            java.util.List r5 = com.facebook.internal.Utility.convertJSONArrayToList(r6)     // Catch: org.json.JSONException -> L60
            com.facebook.referrals.ReferralResult r6 = new com.facebook.referrals.ReferralResult     // Catch: org.json.JSONException -> L60
            r6.<init>(r5)     // Catch: org.json.JSONException -> L60
            r5 = r3
            goto L68
        L32:
            if (r5 != 0) goto L57
            if (r6 == 0) goto L54
            android.os.Bundle r5 = r6.getExtras()     // Catch: org.json.JSONException -> L60
            if (r5 == 0) goto L54
            android.os.Bundle r5 = r6.getExtras()     // Catch: org.json.JSONException -> L60
            boolean r5 = r5.containsKey(r0)     // Catch: org.json.JSONException -> L60
            if (r5 == 0) goto L54
            android.os.Bundle r5 = r6.getExtras()     // Catch: org.json.JSONException -> L60
            java.lang.String r5 = r5.getString(r0)     // Catch: org.json.JSONException -> L60
            com.facebook.FacebookException r6 = new com.facebook.FacebookException     // Catch: org.json.JSONException -> L60
            r6.<init>(r5)     // Catch: org.json.JSONException -> L60
            goto L5e
        L54:
            r5 = r3
            r6 = r5
            goto L68
        L57:
            com.facebook.FacebookException r6 = new com.facebook.FacebookException     // Catch: org.json.JSONException -> L60
            java.lang.String r5 = "Unexpected call to ReferralManager.onActivityResult"
            r6.<init>(r5)     // Catch: org.json.JSONException -> L60
        L5e:
            r5 = r6
            goto L67
        L60:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException
            java.lang.String r6 = "Unable to parse referral codes from response"
            r5.<init>(r6)
        L67:
            r6 = r3
        L68:
            com.facebook.referrals.ReferralLogger r0 = r4.getLogger(r3)
            if (r0 == 0) goto L7d
            if (r6 == 0) goto L74
            r0.logSuccess()
            goto L7d
        L74:
            if (r5 == 0) goto L7a
            r0.logError(r5)
            goto L7d
        L7a:
            r0.logCancel()
        L7d:
            if (r6 == 0) goto L83
            r7.onSuccess(r6)
            goto L8c
        L83:
            if (r5 == 0) goto L89
            r7.onError(r5)
            goto L8c
        L89:
            r7.onCancel()
        L8c:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.referrals.ReferralManager.onActivityResult(int, android.content.Intent, com.facebook.FacebookCallback):boolean");
    }

    private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate) {
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(ReferralFragment.TAG);
        if (resolveIntent(intent)) {
            try {
                startActivityDelegate.startActivityForResult(intent, CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode());
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        }
        return false;
    }

    private ReferralLogger getLogger(Context context) {
        if (context == null) {
            context = FacebookSdk.getApplicationContext();
        }
        if (context == null) {
            return null;
        }
        if (this.logger == null) {
            this.logger = new ReferralLogger(context, FacebookSdk.getApplicationId());
        }
        return this.logger;
    }

    private static boolean resolveIntent(Intent intent) {
        return FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null;
    }

    /* loaded from: classes.dex */
    private static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(Activity activity) {
            Validate.notNull(activity, "activity");
            this.activity = activity;
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.activity.startActivityForResult(intent, i);
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public Activity getActivityContext() {
            return this.activity;
        }
    }

    /* loaded from: classes.dex */
    private static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final FragmentWrapper fragment;

        FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            Validate.notNull(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public void startActivityForResult(Intent intent, int i) {
            this.fragment.startActivityForResult(intent, i);
        }

        @Override // com.facebook.referrals.StartActivityDelegate
        public Activity getActivityContext() {
            return this.fragment.getActivity();
        }
    }
}

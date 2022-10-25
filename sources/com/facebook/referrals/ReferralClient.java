package com.facebook.referrals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookSdk;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTab;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.CustomTabPrefetchHelper;

/* loaded from: classes.dex */
class ReferralClient {
    private static final int CHALLENGE_LENGTH = 20;
    private static final int CUSTOM_TAB_REQUEST_CODE = 1;
    static final String ERROR_MESSAGE_KEY = "error_message";
    static final String REFERRAL_CODES_KEY = "fb_referral_codes";
    private static final String REFERRAL_DIALOG = "share_referral";
    private String currentPackage;
    protected String expectedChallenge;
    private Fragment fragment;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferralClient(Fragment fragment) {
        this.fragment = fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startReferral() {
        if (tryStartReferral()) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("error_message", "Failed to open Referral dialog: Chrome custom tab could not be started. Please make sure internet permission is granted and Chrome is installed");
        finishReferral(0, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        if (i != 1) {
            return;
        }
        if (intent != null && (stringExtra = intent.getStringExtra(CustomTabMainActivity.EXTRA_URL)) != null && stringExtra.startsWith(CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectUrl()))) {
            Bundle parseUrlQueryString = Utility.parseUrlQueryString(Uri.parse(stringExtra).getQuery());
            if (validateChallenge(parseUrlQueryString)) {
                intent.putExtras(parseUrlQueryString);
            } else {
                i2 = 0;
                intent.putExtra("error_message", "The referral response was missing a valid challenge string.");
            }
        }
        finishReferral(i2, intent);
    }

    private boolean validateChallenge(Bundle bundle) {
        if (this.expectedChallenge != null) {
            boolean equals = this.expectedChallenge.equals(bundle.getString(ServerProtocol.DIALOG_PARAM_STATE));
            this.expectedChallenge = null;
            return equals;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getReferralRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Referral.toRequestCode();
    }

    private void finishReferral(int i, Intent intent) {
        FragmentActivity activity;
        if (!this.fragment.isAdded() || (activity = this.fragment.getActivity()) == null) {
            return;
        }
        activity.setResult(i, intent);
        activity.finish();
    }

    private boolean tryStartReferral() {
        if (this.fragment.getActivity() != null && this.fragment.getActivity().checkCallingOrSelfPermission("android.permission.INTERNET") == 0 && isCustomTabsAllowed()) {
            Bundle parameters = getParameters();
            if (FacebookSdk.hasCustomTabsPrefetching) {
                CustomTabPrefetchHelper.mayLaunchUrl(CustomTab.getURIForAction(REFERRAL_DIALOG, parameters));
            }
            Intent intent = new Intent(this.fragment.getActivity(), CustomTabMainActivity.class);
            intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, REFERRAL_DIALOG);
            intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, parameters);
            intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, getChromePackage());
            this.fragment.startActivityForResult(intent, 1);
            return true;
        }
        return false;
    }

    private Bundle getParameters() {
        Bundle bundle = new Bundle();
        this.expectedChallenge = Utility.generateRandomString(20);
        bundle.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, CustomTabUtils.getValidRedirectURI(getDeveloperDefinedRedirectUrl()));
        bundle.putString("app_id", FacebookSdk.getApplicationId());
        bundle.putString(ServerProtocol.DIALOG_PARAM_STATE, this.expectedChallenge);
        return bundle;
    }

    private boolean isCustomTabsAllowed() {
        return getChromePackage() != null;
    }

    private String getChromePackage() {
        if (this.currentPackage == null) {
            this.currentPackage = CustomTabUtils.getChromePackage();
        }
        return this.currentPackage;
    }

    static String getDeveloperDefinedRedirectUrl() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize";
    }
}

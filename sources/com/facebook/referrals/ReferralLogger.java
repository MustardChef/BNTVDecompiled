package com.facebook.referrals;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.appevents.InternalAppEventsLogger;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReferralLogger {
    static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    static final String EVENT_NAME_REFERRAL_CANCEL = "fb_mobile_referral_cancel";
    static final String EVENT_NAME_REFERRAL_ERROR = "fb_mobile_referral_error";
    static final String EVENT_NAME_REFERRAL_START = "fb_mobile_referral_start";
    static final String EVENT_NAME_REFERRAL_SUCCESS = "fb_mobile_referral_success";
    static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    static final String EVENT_PARAM_ERROR_MESSAGE = "2_error_message";
    static final String EVENT_PARAM_EXTRAS = "3_extras";
    static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    static final String EVENT_PARAM_VALUE_EMPTY = "";
    static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private String facebookVersion;
    private final InternalAppEventsLogger logger;
    private String loggerID = UUID.randomUUID().toString();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferralLogger(Context context, String str) {
        PackageInfo packageInfo;
        this.logger = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (packageInfo = packageManager.getPackageInfo(FACEBOOK_PACKAGE_NAME, 0)) == null) {
                return;
            }
            this.facebookVersion = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private Bundle getReferralLoggingBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(EVENT_PARAM_AUTH_LOGGER_ID, this.loggerID);
        bundle.putLong(EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
        bundle.putString(EVENT_PARAM_ERROR_MESSAGE, "");
        bundle.putString(EVENT_PARAM_EXTRAS, "");
        return bundle;
    }

    public void logStartReferral() {
        Bundle referralLoggingBundle = getReferralLoggingBundle();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EVENT_EXTRAS_REQUEST_CODE, ReferralClient.getReferralRequestCode());
            String str = this.facebookVersion;
            if (str != null) {
                jSONObject.put(EVENT_EXTRAS_FACEBOOK_VERSION, str);
            }
            referralLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
        } catch (JSONException unused) {
        }
        this.logger.logEventImplicitly(EVENT_NAME_REFERRAL_START, referralLoggingBundle);
    }

    public void logSuccess() {
        this.logger.logEventImplicitly(EVENT_NAME_REFERRAL_SUCCESS, getReferralLoggingBundle());
    }

    public void logCancel() {
        this.logger.logEventImplicitly(EVENT_NAME_REFERRAL_CANCEL, getReferralLoggingBundle());
    }

    public void logError(Exception exc) {
        Bundle referralLoggingBundle = getReferralLoggingBundle();
        if (exc != null && exc.getMessage() != null) {
            referralLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
        }
        this.logger.logEventImplicitly(EVENT_NAME_REFERRAL_ERROR, referralLoggingBundle);
    }
}

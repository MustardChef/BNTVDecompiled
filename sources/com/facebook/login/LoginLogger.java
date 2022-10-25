package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LoginLogger {
    static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    static final String EVENT_EXTRAS_FAILURE = "failure";
    static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
    static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    static final String EVENT_NAME_LOGIN_HEARTBEAT = "fb_mobile_login_heartbeat";
    static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
    static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
    static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
    static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    static final String EVENT_PARAM_CHALLENGE = "7_challenge";
    static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    static final String EVENT_PARAM_EXTRAS = "6_extras";
    static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    static final String EVENT_PARAM_METHOD = "3_method";
    static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    private String applicationId;
    private String facebookVersion;
    private final InternalAppEventsLogger logger;

    static /* synthetic */ InternalAppEventsLogger access$000(LoginLogger loginLogger) {
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return null;
        }
        try {
            return loginLogger.logger;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginLogger(Context context, String str) {
        PackageInfo packageInfo;
        this.applicationId = str;
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

    public String getApplicationId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.applicationId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    static Bundle newAuthorizationLoggingBundle(String str) {
        if (CrashShieldHandler.isObjectCrashing(LoginLogger.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putLong(EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
            bundle.putString(EVENT_PARAM_AUTH_LOGGER_ID, str);
            bundle.putString(EVENT_PARAM_METHOD, "");
            bundle.putString(EVENT_PARAM_LOGIN_RESULT, "");
            bundle.putString(EVENT_PARAM_ERROR_MESSAGE, "");
            bundle.putString(EVENT_PARAM_ERROR_CODE, "");
            bundle.putString(EVENT_PARAM_EXTRAS, "");
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, LoginLogger.class);
            return null;
        }
    }

    public void logStartLogin(LoginClient.Request request) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(request.getAuthId());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("login_behavior", request.getLoginBehavior().toString());
                jSONObject.put(EVENT_EXTRAS_REQUEST_CODE, LoginClient.getLoginRequestCode());
                jSONObject.put("permissions", TextUtils.join(",", request.getPermissions()));
                jSONObject.put("default_audience", request.getDefaultAudience().toString());
                jSONObject.put(EVENT_EXTRAS_IS_REAUTHORIZE, request.isRerequest());
                String str = this.facebookVersion;
                if (str != null) {
                    jSONObject.put(EVENT_EXTRAS_FACEBOOK_VERSION, str);
                }
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
            } catch (JSONException unused) {
            }
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_START, null, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logCompleteLogin(String str, Map<String, String> map, LoginClient.Result.Code code, Map<String, String> map2, Exception exc) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
            if (code != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, code.getLoggingValue());
            }
            if (exc != null && exc.getMessage() != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
            }
            JSONObject jSONObject = map.isEmpty() ? null : new JSONObject(map);
            if (map2 != null) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            if (jSONObject != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
            }
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_COMPLETE, newAuthorizationLoggingBundle);
            if (code == LoginClient.Result.Code.SUCCESS) {
                logHeartbeatEvent(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private void logHeartbeatEvent(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            final Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
            worker.schedule(new Runnable() { // from class: com.facebook.login.LoginLogger.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        LoginLogger.access$000(LoginLogger.this).logEventImplicitly(LoginLogger.EVENT_NAME_LOGIN_HEARTBEAT, newAuthorizationLoggingBundle);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }, 5L, TimeUnit.SECONDS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logAuthorizationMethodStart(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_METHOD_START, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
            if (str3 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str3);
            }
            if (str4 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str4);
            }
            if (str5 != null) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str5);
            }
            if (map != null && !map.isEmpty()) {
                newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, new JSONObject(map).toString());
            }
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_METHOD_COMPLETE, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logAuthorizationMethodNotTried(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_METHOD_NOT_TRIED, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logLoginStatusStart(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_START, newAuthorizationLoggingBundle(str));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logLoginStatusSuccess(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.SUCCESS.getLoggingValue());
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logLoginStatusFailure(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, EVENT_EXTRAS_FAILURE);
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logLoginStatusError(String str, Exception exc) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.toString());
            this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logUnexpectedError(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            logUnexpectedError(str, str2, "");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public void logUnexpectedError(String str, String str2, String str3) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle("");
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str2);
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str3);
            this.logger.logEventImplicitly(str, newAuthorizationLoggingBundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}

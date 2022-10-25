package com.facebook.login;

import android.net.Uri;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.LoginClient;
import java.util.Collection;

/* loaded from: classes.dex */
public class DeviceLoginManager extends LoginManager {
    private static volatile DeviceLoginManager instance;
    private String deviceAuthTargetUserId;
    private Uri deviceRedirectUri;

    public static DeviceLoginManager getInstance() {
        if (CrashShieldHandler.isObjectCrashing(DeviceLoginManager.class)) {
            return null;
        }
        try {
            if (instance == null) {
                synchronized (DeviceLoginManager.class) {
                    if (instance == null) {
                        instance = new DeviceLoginManager();
                    }
                }
            }
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, DeviceLoginManager.class);
            return null;
        }
    }

    public void setDeviceRedirectUri(Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.deviceRedirectUri = uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public Uri getDeviceRedirectUri() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceRedirectUri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public void setDeviceAuthTargetUserId(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            this.deviceAuthTargetUserId = str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public String getDeviceAuthTargetUserId() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.deviceAuthTargetUserId;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.login.LoginManager
    public LoginClient.Request createLoginRequest(Collection<String> collection) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LoginClient.Request createLoginRequest = super.createLoginRequest(collection);
            Uri deviceRedirectUri = getDeviceRedirectUri();
            if (deviceRedirectUri != null) {
                createLoginRequest.setDeviceRedirectUriString(deviceRedirectUri.toString());
            }
            String deviceAuthTargetUserId = getDeviceAuthTargetUserId();
            if (deviceAuthTargetUserId != null) {
                createLoginRequest.setDeviceAuthTargetUserId(deviceAuthTargetUserId);
            }
            return createLoginRequest;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}

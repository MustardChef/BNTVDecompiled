package com.facebook.appevents.ondeviceprocessing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.ppml.receiver.IReceiverService;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class RemoteServiceWrapper {
    static final String RECEIVER_SERVICE_ACTION = "ReceiverService";
    static final String RECEIVER_SERVICE_PACKAGE = "com.facebook.katana";
    static final String RECEIVER_SERVICE_PACKAGE_WAKIZASHI = "com.facebook.wakizashi";
    private static final String TAG = "RemoteServiceWrapper";
    private static Boolean isServiceAvailable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum ServiceResult {
        OPERATION_SUCCESS,
        SERVICE_NOT_AVAILABLE,
        SERVICE_ERROR
    }

    public static ServiceResult sendInstallEvent(String str) {
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            return sendEvents(EventType.MOBILE_APP_INSTALL, str, new LinkedList());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceWrapper.class);
            return null;
        }
    }

    public static ServiceResult sendCustomEvents(String str, List<AppEvent> list) {
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            return sendEvents(EventType.CUSTOM_APP_EVENTS, str, list);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceWrapper.class);
            return null;
        }
    }

    public static boolean isServiceAvailable() {
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
            return false;
        }
        try {
            if (isServiceAvailable == null) {
                isServiceAvailable = Boolean.valueOf(getVerifiedServiceIntent(FacebookSdk.getApplicationContext()) != null);
            }
            return isServiceAvailable.booleanValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceWrapper.class);
            return false;
        }
    }

    private static ServiceResult sendEvents(EventType eventType, String str, List<AppEvent> list) {
        ServiceResult serviceResult;
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            ServiceResult serviceResult2 = ServiceResult.SERVICE_NOT_AVAILABLE;
            AppEventUtility.assertIsNotMainThread();
            Context applicationContext = FacebookSdk.getApplicationContext();
            Intent verifiedServiceIntent = getVerifiedServiceIntent(applicationContext);
            if (verifiedServiceIntent != null) {
                RemoteServiceConnection remoteServiceConnection = new RemoteServiceConnection();
                if (applicationContext.bindService(verifiedServiceIntent, remoteServiceConnection, 1)) {
                    try {
                        IBinder binder = remoteServiceConnection.getBinder();
                        if (binder != null) {
                            IReceiverService asInterface = IReceiverService.Stub.asInterface(binder);
                            Bundle buildEventsBundle = RemoteServiceParametersHelper.buildEventsBundle(eventType, str, list);
                            if (buildEventsBundle != null) {
                                asInterface.sendEvents(buildEventsBundle);
                                String str2 = TAG;
                                Utility.logd(str2, "Successfully sent events to the remote service: " + buildEventsBundle);
                            }
                            serviceResult = ServiceResult.OPERATION_SUCCESS;
                        } else {
                            serviceResult = ServiceResult.SERVICE_NOT_AVAILABLE;
                        }
                        applicationContext.unbindService(remoteServiceConnection);
                        Utility.logd(TAG, "Unbound from the remote service");
                        return serviceResult;
                    } catch (RemoteException | InterruptedException e) {
                        ServiceResult serviceResult3 = ServiceResult.SERVICE_ERROR;
                        String str3 = TAG;
                        Utility.logd(str3, e);
                        applicationContext.unbindService(remoteServiceConnection);
                        Utility.logd(str3, "Unbound from the remote service");
                        return serviceResult3;
                    }
                }
                return ServiceResult.SERVICE_ERROR;
            }
            return serviceResult2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceWrapper.class);
            return null;
        }
    }

    private static Intent getVerifiedServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intent intent = new Intent(RECEIVER_SERVICE_ACTION);
                intent.setPackage(RECEIVER_SERVICE_PACKAGE);
                if (packageManager.resolveService(intent, 0) != null && FacebookSignatureValidator.validateSignature(context, RECEIVER_SERVICE_PACKAGE)) {
                    return intent;
                }
                Intent intent2 = new Intent(RECEIVER_SERVICE_ACTION);
                intent2.setPackage(RECEIVER_SERVICE_PACKAGE_WAKIZASHI);
                if (packageManager.resolveService(intent2, 0) != null) {
                    if (FacebookSignatureValidator.validateSignature(context, RECEIVER_SERVICE_PACKAGE_WAKIZASHI)) {
                        return intent2;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, RemoteServiceWrapper.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum EventType {
        MOBILE_APP_INSTALL("MOBILE_APP_INSTALL"),
        CUSTOM_APP_EVENTS("CUSTOM_APP_EVENTS");
        
        private String eventType;

        EventType(String str) {
            this.eventType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.eventType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class RemoteServiceConnection implements ServiceConnection {
        private IBinder binder;
        private final CountDownLatch latch = new CountDownLatch(1);

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        RemoteServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.binder = iBinder;
            this.latch.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            this.latch.countDown();
        }

        public IBinder getBinder() throws InterruptedException {
            this.latch.await(5L, TimeUnit.SECONDS);
            return this.binder;
        }
    }
}

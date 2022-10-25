package com.facebook.gamingservices.cloudgaming;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.internal.GamingMediaUploader;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public abstract class AppToUserNotificationSender {
    public static void scheduleAppToUserNotification(String str, String str2, Bitmap bitmap, int i, String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, bitmap, getParameters(), new MediaUploadCallback(str, str2, i, str3, callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, File file, int i, String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, file, getParameters(), new MediaUploadCallback(str, str2, i, str3, callback));
    }

    public static void scheduleAppToUserNotification(String str, String str2, Uri uri, int i, String str3, GraphRequest.Callback callback) throws FileNotFoundException {
        GamingMediaUploader.uploadToGamingServices(SDKConstants.PARAM_A2U_CAPTION, uri, getParameters(), new MediaUploadCallback(str, str2, i, str3, callback));
    }

    private static Bundle getParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("upload_source", "A2U");
        return bundle;
    }
}

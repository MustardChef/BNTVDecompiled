package com.facebook.gamingservices.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public abstract class GamingMediaUploader {
    private static final String photoUploadEdge = "me/photos";

    public static void uploadToGamingServices(String str, Bitmap bitmap, Bundle bundle, GraphRequest.Callback callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", bitmap, str, bundle, callback).executeAsync();
    }

    public static void uploadToGamingServices(String str, File file, Bundle bundle, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", file, str, bundle, callback).executeAsync();
    }

    public static void uploadToGamingServices(String str, Uri uri, Bundle bundle, GraphRequest.Callback callback) throws FileNotFoundException {
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (Utility.isFileUri(uri) || Utility.isContentUri(uri)) {
            GraphRequest.newUploadPhotoRequest(currentAccessToken, "me/photos", uri, str, bundle, callback).executeAsync();
            return;
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putString("url", uri.toString());
        if (str != null && !str.isEmpty()) {
            bundle2.putString("caption", str);
        }
        new GraphRequest(currentAccessToken, "me/photos", bundle2, HttpMethod.POST, callback).executeAsync();
    }
}

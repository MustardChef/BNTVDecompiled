package com.facebook.gamingservices;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public class GamingImageUploader {
    private static final String photoUploadEdge = "me/photos";
    private Context context;

    public GamingImageUploader(Context context) {
        this.context = context;
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z) {
        uploadToMediaLibrary(str, bitmap, z, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, Bitmap bitmap, boolean z, GraphRequest.Callback callback) {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", bitmap, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, File file, boolean z) throws FileNotFoundException {
        uploadToMediaLibrary(str, file, z, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, File file, boolean z, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", file, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z) throws FileNotFoundException {
        uploadToMediaLibrary(str, uri, z, (GraphRequest.Callback) null);
    }

    public void uploadToMediaLibrary(String str, Uri uri, boolean z, GraphRequest.Callback callback) throws FileNotFoundException {
        GraphRequest.newUploadPhotoRequest(AccessToken.getCurrentAccessToken(), "me/photos", uri, str, (Bundle) null, z ? new OpenGamingMediaDialog(this.context, callback) : callback).executeAsync();
    }
}

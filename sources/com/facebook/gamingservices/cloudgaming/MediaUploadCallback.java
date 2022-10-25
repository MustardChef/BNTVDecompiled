package com.facebook.gamingservices.cloudgaming;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* compiled from: AppToUserNotificationSender.java */
/* loaded from: classes.dex */
class MediaUploadCallback implements GraphRequest.Callback {
    private String body;
    GraphRequest.Callback callback;
    private String payload;
    private int timeInterval;
    private String title;

    public MediaUploadCallback(String str, String str2, int i, String str3, GraphRequest.Callback callback) {
        this.title = str;
        this.body = str2;
        this.timeInterval = i;
        this.payload = str3;
        this.callback = callback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        if (graphResponse.getError() != null) {
            throw new FacebookException(graphResponse.getError().getErrorMessage());
        }
        String optString = graphResponse.getJSONObject().optString("id");
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        Bundle bundle = new Bundle();
        bundle.putString("title", this.title);
        bundle.putString("body", this.body);
        bundle.putInt(SDKConstants.PARAM_A2U_TIME_INTERVAL, this.timeInterval);
        String str = this.payload;
        if (str != null) {
            bundle.putString(SDKConstants.PARAM_A2U_PAYLOAD, str);
        }
        bundle.putString(SDKConstants.PARAM_A2U_MEDIA_ID, optString);
        new GraphRequest(currentAccessToken, SDKConstants.PARAM_A2U_GRAPH_PATH, bundle, HttpMethod.POST, this.callback).executeAsync();
    }
}

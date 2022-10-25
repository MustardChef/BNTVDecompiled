package com.facebook.gamingservices;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class OpenGamingMediaDialog implements GraphRequest.OnProgressCallback {
    private Context context;
    private GraphRequest.Callback nestedCallback;

    public OpenGamingMediaDialog(Context context) {
        this(context, null);
    }

    public OpenGamingMediaDialog(Context context, GraphRequest.Callback callback) {
        this.context = context;
        this.nestedCallback = callback;
    }

    @Override // com.facebook.GraphRequest.Callback
    public void onCompleted(GraphResponse graphResponse) {
        GraphRequest.Callback callback = this.nestedCallback;
        if (callback != null) {
            callback.onCompleted(graphResponse);
        }
        if (graphResponse == null || graphResponse.getError() != null) {
            return;
        }
        String optString = graphResponse.getJSONObject().optString("id", null);
        String optString2 = graphResponse.getJSONObject().optString("video_id", null);
        if (optString == null && optString2 == null) {
            return;
        }
        if (optString == null) {
            optString = optString2;
        }
        if (CloudGameLoginHandler.isRunningInCloud()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", optString);
                jSONObject.put(SDKConstants.PARAM_DEEP_LINK, "MEDIA_ASSET");
                DaemonRequest.executeAsync(this.context, jSONObject, (DaemonRequest.Callback) null, SDKMessageEnum.OPEN_GAMING_SERVICES_DEEP_LINK);
                return;
            } catch (JSONException unused) {
                return;
            }
        }
        this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://fb.gg/me/media_asset/" + optString)));
    }

    @Override // com.facebook.GraphRequest.OnProgressCallback
    public void onProgress(long j, long j2) {
        GraphRequest.Callback callback = this.nestedCallback;
        if (callback == null || !(callback instanceof GraphRequest.OnProgressCallback)) {
            return;
        }
        ((GraphRequest.OnProgressCallback) callback).onProgress(j, j2);
    }
}

package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppAdLibrary {
    public static final String PLACEMENT_ID = "placementID";

    public static void loadRewardedVideo(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.LOAD_REWARDED_VIDEO);
    }

    public static void loadInterstitialAd(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.LOAD_INTERSTITIAL_AD);
    }

    public static void showRewardedVideo(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.SHOW_REWARDED_VIDEO);
    }

    public static void showInterstitialAd(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.SHOW_INTERSTITIAL_AD);
    }
}

package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InAppPurchaseLibrary {
    public static final String DEVELOPER_PAYLOAD = "developerPayload";
    public static final String PRODUCT_ID = "productID";
    public static final String PURCHASE_TOKEN = "purchaseToken";

    public static void onReady(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.ON_READY);
    }

    public static void getCatalog(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.GET_CATALOG);
    }

    public static void getPurchases(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.GET_PURCHASES);
    }

    public static void purchase(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.PURCHASE);
    }

    public static void consumePurchase(Context context, JSONObject jSONObject, DaemonRequest.Callback callback) {
        DaemonRequest.executeAsync(context, jSONObject, callback, SDKMessageEnum.CONSUME_PURCHASE);
    }
}

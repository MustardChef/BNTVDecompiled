package com.facebook.gamingservices.cloudgaming.internal;

import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public enum SDKMessageEnum {
    OPEN_PLAY_STORE("openPlayStore"),
    OPEN_APP_STORE("openAppStore"),
    MARK_GAME_LOADED("markGameLoaded"),
    GET_PLAYER_DATA("getPlayerData"),
    SET_PLAYER_DATA("setPlayerData"),
    GET_CATALOG("getCatalog"),
    GET_PURCHASES("getPurchases"),
    PURCHASE(FirebaseAnalytics.Event.PURCHASE),
    CONSUME_PURCHASE("consumePurchase"),
    ON_READY("onReady"),
    LOAD_INTERSTITIAL_AD("loadInterstitialAd"),
    LOAD_REWARDED_VIDEO("loadRewardedVideo"),
    SHOW_INTERSTITIAL_AD("showInterstitialAd"),
    SHOW_REWARDED_VIDEO("showRewardedVideo"),
    GET_ACCESS_TOKEN("getAccessToken"),
    GET_CONTEXT_TOKEN("getContextToken"),
    GET_PAYLOAD("getPayload"),
    IS_ENV_READY("isEnvReady"),
    SHARE("share"),
    CAN_CREATE_SHORTCUT("canCreateShortcut"),
    CREATE_SHORTCUT("createShortcut"),
    OPEN_GAMING_SERVICES_DEEP_LINK("openGamingServicesDeepLink"),
    OPEN_GAME_REQUESTS_DIALOG("openGameRequestsDialog"),
    POST_SESSION_SCORE("postSessionScore");
    
    private final String mStringValue;

    SDKMessageEnum(String str) {
        this.mStringValue = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mStringValue;
    }

    public static SDKMessageEnum fromString(String str) {
        SDKMessageEnum[] values;
        for (SDKMessageEnum sDKMessageEnum : values()) {
            if (sDKMessageEnum.toString().equals(str)) {
                return sDKMessageEnum;
            }
        }
        return null;
    }
}

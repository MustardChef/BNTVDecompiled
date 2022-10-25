package com.applovin.sdk;

import android.content.Intent;
import java.util.Map;

/* loaded from: classes.dex */
public interface AppLovinEventService {
    Map<String, Object> getSuperProperties();

    void setSuperProperty(Object obj, String str);

    void trackCheckout(String str, Map<String, String> map);

    void trackEvent(String str);

    void trackEvent(String str, Map<String, String> map);

    void trackInAppPurchase(Intent intent, Map<String, String> map);
}

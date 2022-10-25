package com.applovin.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.p015c.C1391c;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.C1720c;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Map<String, AppLovinSdk> sdkInstances = new HashMap();
    private static final Object sdkInstancesLock = new Object();
    public final C1662k coreSdk;

    /* loaded from: classes.dex */
    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.sdk.AppLovinSdk$a */
    /* loaded from: classes.dex */
    public static class C1797a extends AppLovinSdkSettings {
        C1797a(Context context) {
            super(context);
        }
    }

    private AppLovinSdk(C1662k c1662k) {
        this.coreSdk = c1662k;
    }

    /* renamed from: a */
    public static AppLovinSdk m6085a(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (appLovinSdkSettings != null) {
            if (context != null) {
                synchronized (sdkInstancesLock) {
                    Map<String, AppLovinSdk> map = sdkInstances;
                    if (map.containsKey(str)) {
                        return map.get(str);
                    }
                    if (!TextUtils.isEmpty(str) && str.contains(File.separator)) {
                        C1710r.m6310i(TAG, "\n**************************************************\nINVALID SDK KEY: " + str + "\n**************************************************\n");
                        if (!map.isEmpty()) {
                            return map.values().iterator().next();
                        }
                        str = str.replace(File.separator, "");
                    }
                    if (map.isEmpty()) {
                        String arrays = Arrays.toString(Arrays.copyOf(new Throwable().getStackTrace(), 5));
                        C1710r.m6312g(TAG, "AppLovinSdk.getInstance()\n" + arrays);
                    }
                    C1662k c1662k = new C1662k();
                    c1662k.m6644a(str, appLovinSdkSettings, context);
                    AppLovinSdk appLovinSdk = new AppLovinSdk(c1662k);
                    c1662k.m6646a(appLovinSdk);
                    map.put(str, appLovinSdk);
                    return appLovinSdk;
                }
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No userSettings specified");
    }

    /* renamed from: a */
    public static List<AppLovinSdk> m6086a() {
        return new ArrayList(sdkInstances.values());
    }

    public static AppLovinSdk getInstance(Context context) {
        return getInstance(new C1797a(context), context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(C1720c.m6288a(context).m6286a("applovin.sdk.key", ""), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    public static AppLovinSdk getInstance(String str, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        return m6085a(str, appLovinSdkSettings, context);
    }

    private static String getVersion() {
        return "10.3.3";
    }

    private static int getVersionCode() {
        return 10030399;
    }

    public static void initializeSdk(Context context) {
        initializeSdk(context, null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        AppLovinSdk appLovinSdk = getInstance(context);
        if (appLovinSdk != null) {
            appLovinSdk.initializeSdk(sdkInitializationListener);
        } else {
            C1710r.m6310i(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reinitializeAll(Boolean bool, Boolean bool2, Boolean bool3) {
        synchronized (sdkInstancesLock) {
            for (AppLovinSdk appLovinSdk : sdkInstances.values()) {
                appLovinSdk.coreSdk.m6626b();
                appLovinSdk.coreSdk.m6605i();
                if (bool != null) {
                    C1710r m6588z = appLovinSdk.coreSdk.m6588z();
                    m6588z.m6317c(TAG, "Toggled 'huc' to " + bool);
                    appLovinSdk.getEventService().trackEvent("huc", CollectionUtils.map("value", bool.toString()));
                }
                if (bool2 != null) {
                    C1710r m6588z2 = appLovinSdk.coreSdk.m6588z();
                    m6588z2.m6317c(TAG, "Toggled 'aru' to " + bool2);
                    appLovinSdk.getEventService().trackEvent("aru", CollectionUtils.map("value", bool2.toString()));
                }
                if (bool3 != null) {
                    C1710r m6588z3 = appLovinSdk.coreSdk.m6588z();
                    m6588z3.m6317c(TAG, "Toggled 'dns' to " + bool3);
                    appLovinSdk.getEventService().trackEvent("dns", CollectionUtils.map("value", bool3.toString()));
                }
            }
        }
    }

    public AppLovinAdService getAdService() {
        return this.coreSdk.m6594t();
    }

    public List<MaxMediatedNetworkInfo> getAvailableMediatedNetworks() {
        JSONArray m7599a = C1391c.m7599a(this.coreSdk);
        ArrayList arrayList = new ArrayList(m7599a.length());
        for (int i = 0; i < m7599a.length(); i++) {
            arrayList.add(new MaxMediatedNetworkInfoImpl(JsonUtils.getJSONObject(m7599a, i, (JSONObject) null)));
        }
        return arrayList;
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.coreSdk.m6596r();
    }

    public AppLovinEventService getEventService() {
        return this.coreSdk.m6593u();
    }

    public String getMediationProvider() {
        return this.coreSdk.m6595s();
    }

    public AppLovinPostbackService getPostbackService() {
        return this.coreSdk.m6665V();
    }

    public String getSdkKey() {
        return this.coreSdk.m6590x();
    }

    public AppLovinSdkSettings getSettings() {
        return this.coreSdk.m6598p();
    }

    public String getUserIdentifier() {
        return this.coreSdk.m6601m();
    }

    public AppLovinUserSegment getUserSegment() {
        return this.coreSdk.m6597q();
    }

    public AppLovinUserService getUserService() {
        return this.coreSdk.m6592v();
    }

    public AppLovinVariableService getVariableService() {
        return this.coreSdk.m6591w();
    }

    public boolean hasCriticalErrors() {
        return this.coreSdk.m6589y();
    }

    public void initializeSdk() {
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.m6647a(sdkInitializationListener);
    }

    public boolean isEnabled() {
        return this.coreSdk.m6613d();
    }

    public boolean isInitialized() {
        return this.coreSdk.m6613d();
    }

    public void setMediationProvider(String str) {
        this.coreSdk.m6614c(str);
    }

    public void setPluginVersion(String str) {
        this.coreSdk.m6645a(str);
    }

    public void setUserIdentifier(String str) {
        this.coreSdk.m6619b(str);
    }

    public void showMediationDebugger() {
        this.coreSdk.m6602l();
    }

    public String toString() {
        return "AppLovinSdk{sdkKey='" + getSdkKey() + "', isEnabled=" + isEnabled() + ", isFirstSession=" + this.coreSdk.m6673N() + '}';
    }
}

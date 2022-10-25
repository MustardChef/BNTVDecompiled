package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AppLovinSdkSettings {

    /* renamed from: a */
    private boolean f2686a;

    /* renamed from: b */
    private boolean f2687b;

    /* renamed from: c */
    private boolean f2688c;

    /* renamed from: d */
    private boolean f2689d;

    /* renamed from: e */
    private List<String> f2690e;

    /* renamed from: f */
    private List<String> f2691f;
    private final Map<String, Object> localSettings;
    private final Map<String, String> metaData;

    @Deprecated
    public AppLovinSdkSettings() {
        this(null);
    }

    public AppLovinSdkSettings(Context context) {
        this.localSettings = new HashMap();
        this.metaData = new HashMap();
        this.f2690e = Collections.emptyList();
        this.f2691f = Collections.emptyList();
        this.f2686a = Utils.isVerboseLoggingEnabled(context);
        this.f2688c = true;
        this.f2689d = true;
    }

    public List<String> getInitializationAdUnitIds() {
        return this.f2691f;
    }

    public List<String> getTestDeviceAdvertisingIds() {
        return this.f2690e;
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.f2688c;
    }

    public boolean isExceptionHandlerEnabled() {
        return this.f2689d;
    }

    public boolean isMuted() {
        return this.f2687b;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.f2686a;
    }

    public void setCreativeDebuggerEnabled(boolean z) {
        this.f2688c = z;
    }

    public void setExceptionHandlerEnabled(boolean z) {
        this.f2689d = true;
    }

    public void setInitializationAdUnitIds(List<String> list) {
        if (list == null) {
            this.f2691f = Collections.emptyList();
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (StringUtils.isValidString(str) && str.length() > 0) {
                if (str.length() == 16) {
                    arrayList.add(str);
                } else {
                    C1710r.m6310i("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + str + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                }
            }
        }
        this.f2691f = arrayList;
    }

    public void setMuted(boolean z) {
        this.f2687b = z;
    }

    public void setTestDeviceAdvertisingIds(List<String> list) {
        if (list == null) {
            this.f2690e = Collections.emptyList();
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (str == null || str.length() != 36) {
                C1710r.m6310i("AppLovinSdkSettings", "Unable to set test device advertising id (" + str + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
            } else {
                arrayList.add(str);
            }
        }
        this.f2690e = arrayList;
    }

    public void setVerboseLogging(boolean z) {
        if (!Utils.isVerboseLoggingConfigured()) {
            this.f2686a = z;
            return;
        }
        C1710r.m6310i("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already or AppLovinSdkSettings was initialized without a context.");
        if (Utils.isVerboseLoggingEnabled(null) != z) {
            C1710r.m6310i("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
        }
    }

    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.f2686a + ", muted=" + this.f2687b + ", testDeviceAdvertisingIds=" + this.f2690e.toString() + ", initializationAdUnitIds=" + this.f2691f.toString() + ", creativeDebuggerEnabled=" + this.f2688c + ", exceptionHandlerEnabled=" + this.f2689d + '}';
    }
}

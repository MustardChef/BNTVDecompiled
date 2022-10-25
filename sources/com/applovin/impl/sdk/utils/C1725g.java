package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p029c.C1569c;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p029c.C1571e;
import com.uwetrottmann.tmdb2.Tmdb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.utils.g */
/* loaded from: classes.dex */
public class C1725g {

    /* renamed from: a */
    private static final int[] f2482a = {7, 4, 2, 1, 11};

    /* renamed from: b */
    private static final int[] f2483b = {5, 6, 10, 3, 9, 8, 14};

    /* renamed from: c */
    private static final int[] f2484c = {15, 12, 13};

    /* renamed from: d */
    private static final int[] f2485d = {20};

    /* renamed from: a */
    public static String m6266a(InputStream inputStream, C1662k c1662k) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) c1662k.m6656a(C1568b.f1785cZ)).intValue()];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toString("UTF-8");
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static String m6264a(String str, C1662k c1662k) {
        return m6263a((String) c1662k.m6656a(C1568b.f1671aQ), str, c1662k);
    }

    /* renamed from: a */
    public static String m6263a(String str, String str2, C1662k c1662k) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        }
        if (str2 != null) {
            if (c1662k != null) {
                return str + str2;
            }
            throw new IllegalArgumentException("No sdk specified");
        }
        throw new IllegalArgumentException("No endpoint specified");
    }

    /* renamed from: a */
    public static JSONObject m6262a(JSONObject jSONObject) throws JSONException {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    /* renamed from: a */
    public static void m6269a(int i, C1662k c1662k) {
        C1569c m6678I = c1662k.m6678I();
        if (i == 401) {
            m6678I.m7002a(C1568b.f1650W, "");
            m6678I.m7002a(C1568b.f1652Y, "");
            m6678I.m7004a();
            C1710r.m6310i("AppLovinSdk", "SDK key \"" + c1662k.m6590x() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
        } else if (i == 418) {
            m6678I.m7002a((C1568b<?>) C1568b.f1649V, (Object) true);
            m6678I.m7004a();
        } else {
            if (i < 400 || i >= 500) {
                if (i != -1 || !((Boolean) c1662k.m6656a(C1568b.f1651X)).booleanValue()) {
                    return;
                }
            } else if (!((Boolean) c1662k.m6656a(C1568b.f1651X)).booleanValue()) {
                return;
            }
            c1662k.m6603k();
        }
    }

    /* renamed from: a */
    public static void m6261a(JSONObject jSONObject, boolean z, C1662k c1662k) {
        c1662k.m6634af().m6725a(jSONObject, z);
    }

    /* renamed from: a */
    public static boolean m6270a() {
        return m6265a((String) null);
    }

    /* renamed from: a */
    private static boolean m6268a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m6267a(Context context) {
        if (context.getSystemService("connectivity") != null) {
            NetworkInfo m6260b = m6260b(context);
            if (m6260b != null) {
                return m6260b.isConnected();
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m6265a(String str) {
        if (C1724f.m6274e()) {
            return (!C1724f.m6273f() || TextUtils.isEmpty(str)) ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        return true;
    }

    /* renamed from: b */
    private static NetworkInfo m6260b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: b */
    public static String m6259b(String str, C1662k c1662k) {
        return m6263a((String) c1662k.m6656a(C1568b.f1672aR), str, c1662k);
    }

    /* renamed from: c */
    public static void m6258c(JSONObject jSONObject, C1662k c1662k) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", null);
        if (StringUtils.isValidString(string)) {
            c1662k.m6653a((C1570d<C1570d<String>>) C1570d.f1953y, (C1570d<String>) string);
            c1662k.m6588z().m6317c("ConnectionUtils", "Updated persisted data");
        }
    }

    /* renamed from: d */
    public static void m6257d(JSONObject jSONObject, C1662k c1662k) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        try {
            if (jSONObject.has("settings")) {
                C1569c m6678I = c1662k.m6678I();
                if (jSONObject.isNull("settings")) {
                    return;
                }
                m6678I.m6999a(jSONObject.getJSONObject("settings"));
                m6678I.m7004a();
            }
        } catch (JSONException e) {
            c1662k.m6588z().m6318b("ConnectionUtils", "Unable to parse settings out of API response", e);
        }
    }

    /* renamed from: e */
    public static Map<String, String> m6256e(C1662k c1662k) {
        String str;
        HashMap hashMap = new HashMap();
        String str2 = (String) c1662k.m6656a(C1568b.f1652Y);
        if (!StringUtils.isValidString(str2)) {
            if (!((Boolean) c1662k.m6656a(C1568b.f1903en)).booleanValue()) {
                str2 = c1662k.m6590x();
                str = Tmdb.PARAM_API_KEY;
            }
            hashMap.putAll(Utils.stringifyObjectMap(c1662k.m6667T().m6545h()));
            return hashMap;
        }
        str = "device_token";
        hashMap.put(str, str2);
        hashMap.putAll(Utils.stringifyObjectMap(c1662k.m6667T().m6545h()));
        return hashMap;
    }

    /* renamed from: e */
    public static void m6255e(JSONObject jSONObject, C1662k c1662k) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(c1662k.m6677J()).edit();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, null);
                if (object != null) {
                    C1571e.m6980a(next, object, (SharedPreferences) null, edit);
                }
            }
            edit.apply();
        }
    }

    /* renamed from: f */
    public static String m6254f(C1662k c1662k) {
        NetworkInfo m6260b = m6260b(c1662k.m6677J());
        if (m6260b != null) {
            int type = m6260b.getType();
            int subtype = m6260b.getSubtype();
            return type == 1 ? "wifi" : type == 0 ? m6268a(subtype, f2482a) ? "2g" : m6268a(subtype, f2483b) ? "3g" : m6268a(subtype, f2484c) ? "4g" : m6268a(subtype, f2485d) ? "5g" : "mobile" : "unknown";
        }
        return "unknown";
    }

    /* renamed from: f */
    public static void m6253f(JSONObject jSONObject, C1662k c1662k) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "zones", null);
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        c1662k.m6661Z().m7197a(jSONArray);
    }

    /* renamed from: g */
    public static String m6252g(C1662k c1662k) {
        return m6263a((String) c1662k.m6656a(C1568b.f1669aO), ((Boolean) c1662k.m6656a(C1568b.f1845dh)).booleanValue() ? "5.0/ad" : "4.0/ad", c1662k);
    }

    /* renamed from: g */
    public static void m6251g(JSONObject jSONObject, C1662k c1662k) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "zones", null);
        if (jSONArray != null) {
            c1662k.m6661Z().m7196b(jSONArray);
        }
    }

    /* renamed from: h */
    public static String m6250h(C1662k c1662k) {
        return m6263a((String) c1662k.m6656a(C1568b.f1670aP), ((Boolean) c1662k.m6656a(C1568b.f1845dh)).booleanValue() ? "5.0/ad" : "4.0/ad", c1662k);
    }

    /* renamed from: h */
    public static void m6249h(JSONObject jSONObject, C1662k c1662k) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "variables", (JSONObject) null);
        if (jSONObject2 != null) {
            c1662k.m6591w().updateVariables(jSONObject2);
        }
    }

    /* renamed from: i */
    public static String m6248i(C1662k c1662k) {
        return m6263a((String) c1662k.m6656a(C1568b.f1675aU), "1.0/variable_config", c1662k);
    }

    /* renamed from: j */
    public static String m6247j(C1662k c1662k) {
        return m6263a((String) c1662k.m6656a(C1568b.f1676aV), "1.0/variable_config", c1662k);
    }
}

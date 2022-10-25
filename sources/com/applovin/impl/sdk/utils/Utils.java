package com.applovin.impl.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.C1543h;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p030d.C1576a;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.appevents.AppEventsConstants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class Utils {
    public static final String MACRO_CLCODE = "{CLCODE}";
    public static final String MACRO_CLICK_X = "{CLICK_X}";
    public static final String MACRO_CLICK_Y = "{CLICK_Y}";
    private static final String MACRO_EVENT_ID = "{EVENT_ID}";
    public static final String MACRO_IS_VIDEO_CLICK = "{IS_VIDEO_CLICK}";
    public static final String MACRO_SCREEN_HEIGHT = "{SCREEN_HEIGHT}";
    public static final String MACRO_SCREEN_WIDTH = "{SCREEN_WIDTH}";
    private static final String PLACEMENT_MACRO = "{PLACEMENT}";
    public static final String PLAY_STORE_PACKAGE_NAME = "com.android.vending";
    public static final String PLAY_STORE_SCHEME = "market";
    public static final String SHOWN_OUT_OF_CONTEXT_MACRO = "{SOC}";
    private static final String TAG = "Utils";
    public static Boolean isExoPlayerEligible;

    public static boolean bitMaskContainsFlag(long j, long j2) {
        return (j & j2) != 0;
    }

    public static List<Uri> checkCachedResourcesExist(boolean z, AbstractC1537g abstractC1537g, C1662k c1662k, Context context) {
        if (abstractC1537g instanceof C1129a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Uri uri : new ArrayList(abstractC1537g.m7172A())) {
            if (!c1662k.m6662Y().m6340b(uri.getLastPathSegment(), context)) {
                C1710r m6588z = c1662k.m6588z();
                m6588z.m6314e(TAG, "Cached HTML asset missing: " + uri);
                arrayList.add(uri);
            }
        }
        if (z) {
            Uri mo7082h = abstractC1537g.mo7082h();
            if (!c1662k.m6662Y().m6340b(mo7082h.getLastPathSegment(), context)) {
                C1710r m6588z2 = c1662k.m6588z();
                m6588z2.m6314e(TAG, "Cached video missing: " + mo7082h);
                arrayList.add(mo7082h);
            }
        }
        return arrayList;
    }

    public static boolean checkClassExistence(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean checkClassesExistence(List<String> list) {
        for (String str : list) {
            if (checkClassExistence(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkExoPlayerEligibility(C1662k c1662k) {
        if (isExoPlayerEligible == null) {
            int tryToGetExoPlayerVersionCode = tryToGetExoPlayerVersionCode();
            int intValue = ((Integer) c1662k.m6656a(C1568b.f1769cJ)).intValue();
            isExoPlayerEligible = Boolean.valueOf(checkClassExistence("com.google.android.exoplayer2.ui.PlayerView") && tryToGetExoPlayerVersionCode >= ((Integer) c1662k.m6656a(C1568b.f1768cI)).intValue() && (intValue < 0 || tryToGetExoPlayerVersionCode <= intValue));
        }
        return isExoPlayerEligible.booleanValue();
    }

    public static void close(Closeable closeable, C1662k c1662k) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            if (c1662k != null) {
                C1710r m6588z = c1662k.m6588z();
                m6588z.m6318b(TAG, "Unable to close stream: " + closeable, th);
            }
        }
    }

    public static void disconnect(HttpURLConnection httpURLConnection, C1662k c1662k) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (c1662k != null) {
                C1710r m6588z = c1662k.m6588z();
                m6588z.m6318b(TAG, "Unable to disconnect connection: " + httpURLConnection, th);
            }
        }
    }

    public static String encodeUrlMap(Map<String, String> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            TreeMap treeMap = new TreeMap(new Comparator<String>() { // from class: com.applovin.impl.sdk.utils.Utils.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(String str, String str2) {
                    return str.compareToIgnoreCase(str2);
                }
            });
            treeMap.putAll(map);
            map = treeMap;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append((Object) entry.getKey());
            sb.append('=');
            sb.append((Object) entry.getValue());
        }
        return sb.toString();
    }

    private static long floatToLong(float f) {
        return Math.round(f);
    }

    private static List<Class> generateClassesList(List<String> list, C1662k c1662k) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            try {
                arrayList.add(Class.forName(str));
            } catch (ClassNotFoundException unused) {
                C1710r m6588z = c1662k.m6588z();
                m6588z.m6314e(TAG, "Failed to create class for name: " + str);
            }
        }
        return arrayList;
    }

    public static int getAlwaysFinishActivitiesSetting(Context context) {
        C1724f.m6277b();
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    public static String getAndroidOSInfo() {
        try {
            return Build.VERSION.RELEASE + " (" + getAndroidSdkCodename() + " - API " + Build.VERSION.SDK_INT + ")";
        } catch (Throwable th) {
            C1710r.m6316c(TAG, "Unable to get Android OS info", th);
            return "";
        }
    }

    public static String getAndroidSdkCodename() {
        Field[] fields;
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt(null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            C1710r.m6316c(TAG, "Unable to get Android SDK codename", th);
            return "";
        }
    }

    public static boolean getBooleanForProbability(int i) {
        return i > 0 && i <= 100 && ((int) (Math.random() * 100.0d)) + 1 <= i;
    }

    public static Field getField(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return getField(superclass, str);
        }
    }

    public static Map<String, String> getMetaData(AppLovinSdkSettings appLovinSdkSettings) {
        try {
            Field field = getField(appLovinSdkSettings.getClass(), "metaData");
            if (field != null) {
                field.setAccessible(true);
            }
            return (Map) field.get(appLovinSdkSettings);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getOrientation(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    public static List<C1576a> getPostbacks(String str, JSONObject jSONObject, String str2, String str3, C1662k c1662k) {
        return getPostbacks(str, jSONObject, str2, (Map<String, String>) null, str3, c1662k);
    }

    public static List<C1576a> getPostbacks(String str, JSONObject jSONObject, String str2, String str3, Map<String, String> map, C1662k c1662k) {
        return getPostbacks(str, jSONObject, str2, Collections.emptyMap(), str3, map, false, c1662k);
    }

    public static List<C1576a> getPostbacks(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, C1662k c1662k) {
        return getPostbacks(str, jSONObject, str2, map, str3, null, false, c1662k);
    }

    public static List<C1576a> getPostbacks(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, Map<String, String> map2, boolean z, C1662k c1662k) {
        if (map == null) {
            map = new HashMap<>(1);
        }
        Map<String, String> map3 = map;
        map3.put(MACRO_CLCODE, str2);
        return getPostbacks(str, jSONObject, map3, str3, map2, z, c1662k);
    }

    public static List<C1576a> getPostbacks(String str, JSONObject jSONObject, Map<String, String> map, String str2, C1662k c1662k) {
        return getPostbacks(str, jSONObject, map, str2, (Map<String, String>) null, c1662k);
    }

    public static List<C1576a> getPostbacks(String str, JSONObject jSONObject, Map<String, String> map, String str2, Map<String, String> map2, C1662k c1662k) {
        return getPostbacks(str, jSONObject, map, str2, map2, false, c1662k);
    }

    public static List<C1576a> getPostbacks(String str, JSONObject jSONObject, Map<String, String> map, String str2, Map<String, String> map2, boolean z, C1662k c1662k) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, str, new JSONObject());
        ArrayList arrayList = new ArrayList(jSONObject2.length() + 1);
        if (StringUtils.isValidString(str2)) {
            arrayList.add(new C1576a(str2, null, map2, z));
        }
        if (jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String optString = jSONObject2.optString(next);
                        String replace = StringUtils.replace(next, map);
                        if (!TextUtils.isEmpty(optString)) {
                            optString = StringUtils.replace(optString, map);
                        }
                        arrayList.add(new C1576a(replace, optString, map2, z));
                    }
                } catch (Throwable th) {
                    c1662k.m6588z().m6318b(TAG, "Failed to create and add postback url.", th);
                }
            }
        }
        return arrayList;
    }

    public static View getRootView(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }

    public static int getRotation(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    public static String getSafedkSdkKey() {
        return getSafedkString("getSdkKey");
    }

    private static String getSafedkString(String str) {
        try {
            return (String) Class.forName("com.applovin.quality.AppLovinQualityService").getMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getSafedkVersion() {
        return getSafedkString("getVersion");
    }

    public static long getServerAdjustedUnixTimestampMillis(C1662k c1662k) {
        long longValue = ((Long) c1662k.m6656a(C1568b.f1905ep)).longValue();
        long longValue2 = ((Long) c1662k.m6656a(C1568b.f1906eq)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        return (longValue <= 0 || longValue2 <= 0) ? currentTimeMillis : currentTimeMillis + (longValue - longValue2);
    }

    public static String getString(Class cls, String str) {
        try {
            Field field = getField(cls, str);
            field.setAccessible(true);
            return (String) field.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getUserEngagementSdkVersion() {
        try {
            return (String) Class.forName("com.applovin.sdk.userengagement.impl.api.AppLovinUserEngagementSdkImpl").getMethod("getVersion", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int getVideoCompletionPercent(JSONObject jSONObject) {
        int i = JsonUtils.getInt(jSONObject, "video_completion_percent", -1);
        if (i < 0 || i > 100) {
            return 95;
        }
        return i;
    }

    public static C1531d getZone(JSONObject jSONObject, C1662k c1662k) {
        return C1531d.m7216a(AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", null)), AppLovinAdType.fromString(JsonUtils.getString(jSONObject, AppEventsConstants.EVENT_PARAM_AD_TYPE, null)), JsonUtils.getString(jSONObject, "zone_id", null));
    }

    public static byte[] gzip(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean hasAndroidCoreJsonLibrary(C1662k c1662k) {
        if (C1724f.m6276c()) {
            try {
                JSONObject.wrap(JSONObject.NULL);
                return true;
            } catch (Throwable th) {
                c1662k.m6588z().m6321a(TAG, "Failed to wrap JSONObject with exception", th);
                return false;
            }
        }
        return true;
    }

    public static boolean isAppLovinTestEnvironment(Context context) {
        return C1720c.m6288a(context).m6287a("applovin.sdk.is_test_environment");
    }

    public static boolean isBML(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER || appLovinAdSize == AppLovinAdSize.CROSS_PROMO;
    }

    public static boolean isCurrentProcessInForeground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            C1710r.m6316c(TAG, "Exception thrown while getting memory state.", th);
        }
        return runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200;
    }

    public static boolean isDomainWhitelisted(String str, List<String> list) {
        for (String str2 : list) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean isProguardRulesOmitted() {
        try {
            Class.forName("com.applovin.sdk.AppLovinSdk");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }

    public static boolean isPubInDebugMode(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean isTestApp(Context context) {
        String packageName = context.getPackageName();
        return "com.revolverolver.fliptrickster".equals(packageName) || "com.mindstormstudios.idlemakeover".equals(packageName);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000a A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:2:0x0000, B:3:0x0004, B:5:0x000a, B:7:0x001d, B:9:0x0025), top: B:17:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isVPNConnected() {
        /*
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Throwable -> L2f
        L4:
            boolean r1 = r0.hasMoreElements()     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L37
            java.lang.Object r1 = r0.nextElement()     // Catch: java.lang.Throwable -> L2f
            java.net.NetworkInterface r1 = (java.net.NetworkInterface) r1     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = r1.getDisplayName()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = "tun"
            boolean r2 = r1.contains(r2)     // Catch: java.lang.Throwable -> L2f
            if (r2 != 0) goto L2d
            java.lang.String r2 = "ppp"
            boolean r2 = r1.contains(r2)     // Catch: java.lang.Throwable -> L2f
            if (r2 != 0) goto L2d
            java.lang.String r2 = "ipsec"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L4
        L2d:
            r0 = 1
            return r0
        L2f:
            r0 = move-exception
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "Unable to check Network Interfaces"
            com.applovin.impl.sdk.C1710r.m6316c(r1, r2, r0)
        L37:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.Utils.isVPNConnected():boolean");
    }

    public static boolean isVerboseLoggingConfigured() {
        Context m6676K = C1662k.m6676K();
        if (m6676K != null) {
            return C1720c.m6288a(m6676K).m6287a("applovin.sdk.verbose_logging");
        }
        return false;
    }

    public static boolean isVerboseLoggingEnabled(Context context) {
        if (context == null) {
            context = C1662k.m6676K();
        }
        if (context != null) {
            return C1720c.m6288a(context).m6285a("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    public static boolean isViewInChildView(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (isViewInChildView(view, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isViewInTopActivity(View view, Activity activity) {
        View rootView;
        if (activity != null && view != null) {
            Window window = activity.getWindow();
            if (window != null) {
                rootView = window.getDecorView();
            } else {
                View findViewById = activity.findViewById(16908290);
                if (findViewById != null) {
                    rootView = findViewById.getRootView();
                }
            }
            return isViewInChildView(view, rootView);
        }
        return false;
    }

    public static void maybeHandleNoFillResponseForPublisher(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, C1662k c1662k) {
        if (jSONObject.has("no_fill_reason")) {
            Object object = JsonUtils.getObject(jSONObject, "no_fill_reason", new Object());
            C1710r.m6310i("AppLovinSdk", "\n**************************************************\nNO FILL received:\n..ID: \"" + str + "\"\n..FORMAT: \"" + maxAdFormat.getLabel() + "\"\n..SDK KEY: \"" + c1662k.m6590x() + "\"\n..PACKAGE NAME: \"" + c1662k.m6677J().getPackageName() + "\"\n..Reason: " + object + "\n**************************************************\n");
        }
    }

    public static AppLovinAd maybeRetrieveNonDummyAd(AppLovinAd appLovinAd, C1662k c1662k) {
        if (appLovinAd instanceof C1543h) {
            C1543h c1543h = (C1543h) appLovinAd;
            AppLovinAd dequeueAd = c1662k.m6594t().dequeueAd(c1543h.getAdZone());
            C1710r m6588z = c1662k.m6588z();
            m6588z.m6319b(TAG, "Dequeued ad for dummy ad: " + dequeueAd);
            if (dequeueAd != null) {
                c1543h.m7067a(dequeueAd);
                ((AppLovinAdBase) dequeueAd).setDummyAd(c1543h);
                return dequeueAd;
            }
            return c1543h.m7068a();
        }
        return appLovinAd;
    }

    public static double millisToSeconds(long j) {
        return j / 1000.0d;
    }

    public static boolean objectIsOfType(Object obj, List<String> list, C1662k c1662k) {
        if (list == null) {
            return false;
        }
        for (Class cls : generateClassesList(list, c1662k)) {
            if (cls.isInstance(obj)) {
                if (!(obj instanceof Map)) {
                    if (obj instanceof List) {
                        for (Object obj2 : (List) obj) {
                            if (!objectIsOfType(obj2, list, c1662k)) {
                                return false;
                            }
                        }
                        return true;
                    }
                    return true;
                }
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    if (!(entry.getKey() instanceof String)) {
                        c1662k.m6588z().m6319b(TAG, "Invalid key type used. Map keys should be of type String.");
                        return false;
                    } else if (!objectIsOfType(entry.getValue(), list, c1662k)) {
                        return false;
                    }
                }
                return true;
            }
        }
        C1710r m6588z = c1662k.m6588z();
        m6588z.m6319b(TAG, "Object '" + obj + "' does not match any of the required types '" + list + "'.");
        return false;
    }

    public static boolean openUri(Context context, Uri uri, C1662k c1662k) {
        boolean z;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            if (PLAY_STORE_SCHEME.equals(intent.getScheme())) {
                intent.setPackage("com.android.vending");
            }
            c1662k.m6638ab().m6132b();
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            C1710r m6588z = c1662k.m6588z();
            m6588z.m6318b(TAG, "Unable to open \"" + uri + "\".", th);
            z = false;
        }
        if (!z) {
            c1662k.m6638ab().m6130c();
        }
        return z;
    }

    public static long parseColor(String str) {
        if (StringUtils.isValidString(str)) {
            try {
                return Color.parseColor(str);
            } catch (Throwable unused) {
                return Long.MAX_VALUE;
            }
        }
        return Long.MAX_VALUE;
    }

    public static void putObjectForStringIfValid(String str, String str2, Map map) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    public static void renameKeyInObjectMap(String str, String str2, Map<String, Object> map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    public static String replaceCommonMacros(String str) {
        return replaceCommonMacros(false, str);
    }

    public static String replaceCommonMacros(boolean z, String str) {
        return str.replace(PLACEMENT_MACRO, "").replace(SHOWN_OUT_OF_CONTEXT_MACRO, String.valueOf(z));
    }

    public static String retrieveLauncherActivityFullyQualifiedName(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (queryIntentActivities.isEmpty()) {
            return null;
        }
        return queryIntentActivities.get(0).activityInfo.name;
    }

    public static Activity retrieveParentActivity(View view, C1662k c1662k) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                c1662k.m6588z().m6318b(TAG, "Encountered error while retrieving activity from view", th);
            }
        }
        return null;
    }

    public static Object sanitizeSuperProperty(Object obj, C1662k c1662k) {
        int intValue;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            HashMap hashMap = new HashMap(map.size());
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                hashMap.put(key instanceof String ? (String) key : String.valueOf(key), sanitizeSuperProperty(entry.getValue(), c1662k));
            }
            return hashMap;
        } else if (obj instanceof List) {
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            for (Object obj2 : list) {
                arrayList.add(sanitizeSuperProperty(obj2, c1662k));
            }
            return arrayList;
        } else if (obj instanceof Date) {
            return String.valueOf(((Date) obj).getTime());
        } else {
            String valueOf = String.valueOf(obj);
            if (obj instanceof String) {
                intValue = ((Integer) c1662k.m6656a(C1568b.f1735bb)).intValue();
                if (intValue <= 0 || valueOf.length() <= intValue) {
                    return valueOf;
                }
            } else if (!(obj instanceof Uri) || (intValue = ((Integer) c1662k.m6656a(C1568b.f1736bc)).intValue()) <= 0 || valueOf.length() <= intValue) {
                return valueOf;
            }
            return valueOf.substring(0, intValue);
        }
    }

    public static float secondsToMillis(float f) {
        return f * 1000.0f;
    }

    public static long secondsToMillisLong(float f) {
        return floatToLong(secondsToMillis(f));
    }

    public static String shortenKey(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    public static void showAlert(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(17039370, (DialogInterface.OnClickListener) null).create().show();
    }

    public static void showToast(final String str, final Context context) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.utils.Utils.2
            @Override // java.lang.Runnable
            public void run() {
                Toast makeText = Toast.makeText(context, str, 0);
                makeText.setMargin(0.0f, 0.1f);
                makeText.show();
            }
        });
    }

    public static void showToast(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getDisplayName() + ": " + str, 1).show();
    }

    public static Map<String, String> stringifyObjectMap(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return hashMap;
    }

    public static Map<String, String> toUrlSafeMap(Map<String, String> map) {
        HashMap hashMap = new HashMap(map);
        for (String str : hashMap.keySet()) {
            String str2 = (String) hashMap.get(str);
            if (str2 != null) {
                hashMap.put(str, StringUtils.encodeUrlString(str2));
            }
        }
        return hashMap;
    }

    public static int toVersionCode(String str) {
        String[] split;
        int i = 0;
        for (String str2 : str.replaceAll("-beta", ".").split("\\.")) {
            if (str2.length() > 2) {
                C1710r.m6310i(TAG, "Version number components cannot be longer than two digits -> " + str);
                return i;
            }
            i = (i * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i * 100) + 99 : i;
    }

    public static double tryParseDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            C1710r.m6316c(TAG, "Failed to parse double from String: " + str, th);
            return d;
        }
    }

    public static int tryToGetExoPlayerVersionCode() {
        try {
            Field field = getField(Class.forName("com.google.android.exoplayer2.ExoPlayerLibraryInfo"), "VERSION_INT");
            field.setAccessible(true);
            return ((Integer) field.get(null)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String urlStringWithoutQueryParameters(String str) {
        Uri parse = Uri.parse(str);
        return new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath()).build().toString();
    }

    public static void validateAdSdkKey(AppLovinAd appLovinAd, C1662k c1662k) {
        if (appLovinAd instanceof AppLovinAdBase) {
            String m6590x = c1662k.m6590x();
            String m6590x2 = ((AppLovinAdBase) appLovinAd).getSdk().m6590x();
            if (m6590x.equals(m6590x2)) {
                return;
            }
            C1710r.m6310i("AppLovinAd", "Ad was loaded from sdk with key: " + m6590x2 + ", but is being rendered from sdk with key: " + m6590x);
            c1662k.m6669R().m6893a(C1586f.f2043l);
        }
    }
}

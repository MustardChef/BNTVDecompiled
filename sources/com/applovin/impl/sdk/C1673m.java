package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import com.applovin.impl.sdk.network.C1684b;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.p030d.C1587g;
import com.applovin.impl.sdk.p031e.C1599f;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.C1758k;
import com.applovin.impl.sdk.utils.C1762n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.m */
/* loaded from: classes.dex */
public class C1673m {

    /* renamed from: h */
    private static String f2319h;

    /* renamed from: i */
    private static int f2320i;

    /* renamed from: j */
    private static final AtomicReference<C1677a> f2321j = new AtomicReference<>();

    /* renamed from: a */
    private final C1662k f2322a;

    /* renamed from: b */
    private final C1710r f2323b;

    /* renamed from: c */
    private final Context f2324c;

    /* renamed from: d */
    private final Map<String, Object> f2325d;

    /* renamed from: f */
    private final Map<String, Object> f2327f;

    /* renamed from: g */
    private boolean f2328g;

    /* renamed from: e */
    private final Object f2326e = new Object();

    /* renamed from: k */
    private final AtomicReference<Integer> f2329k = new AtomicReference<>();

    /* renamed from: com.applovin.impl.sdk.m$a */
    /* loaded from: classes.dex */
    public static class C1677a {

        /* renamed from: a */
        public boolean f2333a;

        /* renamed from: b */
        public String f2334b = "";
    }

    /* renamed from: com.applovin.impl.sdk.m$b */
    /* loaded from: classes.dex */
    public static class C1678b {

        /* renamed from: a */
        public int f2335a = -1;

        /* renamed from: b */
        public int f2336b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1673m(C1662k c1662k) {
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f2322a = c1662k;
        this.f2323b = c1662k.m6588z();
        this.f2324c = c1662k.m6677J();
        this.f2325d = m6538o();
        this.f2327f = m6536q();
    }

    /* renamed from: A */
    private double m6573A() {
        return Math.round((TimeZone.getDefault().getOffset(new Date().getTime()) * 10.0d) / 3600000.0d) / 10.0d;
    }

    /* renamed from: B */
    private boolean m6572B() {
        return this.f2324c.getPackageManager().hasSystemFeature(C1724f.m6275d() ? "android.software.leanback" : "android.hardware.type.television");
    }

    /* renamed from: C */
    private boolean m6571C() {
        SensorManager sensorManager = (SensorManager) this.f2324c.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    /* renamed from: D */
    private String m6570D() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2324c.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    /* renamed from: E */
    private String m6569E() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f2324c.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                return telephonyManager.getNetworkOperatorName();
            } catch (Throwable th) {
                this.f2323b.m6318b("DataCollector", "Unable to collect carrier", th);
                return "";
            }
        }
        return "";
    }

    /* renamed from: F */
    private boolean m6568F() {
        try {
            if (!m6567G()) {
                if (!m6566H()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: G */
    private boolean m6567G() {
        String str = Build.TAGS;
        return str != null && str.contains(m6552b("lz}$blpz"));
    }

    /* renamed from: H */
    private boolean m6566H() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i = 0; i < 9; i++) {
            if (new File(m6552b(strArr[i])).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String m6564a(int i) {
        if (i == 1) {
            return "receiver";
        }
        if (i == 2) {
            return "speaker";
        }
        if (i == 4 || i == 3) {
            return "headphones";
        }
        if (i == 8) {
            return "bluetootha2dpoutput";
        }
        if (i == 13 || i == 19 || i == 5 || i == 6 || i == 12 || i == 11) {
            return "lineout";
        }
        if (i == 9 || i == 10) {
            return "hdmioutput";
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(42:1|(41:3|(1:5)(2:94|(1:96))|6|(1:8)|9|(1:11)|12|(1:14)|15|(1:17)|18|(1:20)|21|(1:23)|(1:25)(1:93)|(1:27)|28|29|30|(2:32|(1:34))|35|(2:85|86)|37|(2:39|(1:41))|42|(1:48)|49|(3:51|52|53)(1:84)|54|(2:56|(1:58))|59|(1:61)|62|(1:66)|67|(1:71)|72|(1:76)|77|(1:79)|80)|97|6|(0)|9|(0)|12|(0)|15|(0)|18|(0)|21|(0)|(0)(0)|(0)|28|29|30|(0)|35|(0)|37|(0)|42|(3:44|46|48)|49|(0)(0)|54|(0)|59|(0)|62|(2:64|66)|67|(2:69|71)|72|(2:74|76)|77|(0)|80) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0120, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0121, code lost:
        r6.f2323b.m6318b("DataCollector", "Unable to collect screen brightness", r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.Object> m6558a(java.util.Map<java.lang.String, java.lang.Object> r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 837
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1673m.m6558a(java.util.Map, boolean):java.util.Map");
    }

    /* renamed from: a */
    public static void m6563a(final Context context) {
        new Thread(new Runnable() { // from class: com.applovin.impl.sdk.m.1
            @Override // java.lang.Runnable
            public void run() {
                C1673m.f2321j.set(C1673m.m6550c(context));
            }
        }).start();
    }

    /* renamed from: a */
    private void m6559a(Map<String, Object> map) {
        if (((Boolean) this.f2322a.m6656a(C1568b.f1818dG)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(m6532u()));
        }
        if (((Boolean) this.f2322a.m6656a(C1568b.f1819dH)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(m6531v()));
        }
        if (((Boolean) this.f2322a.m6656a(C1568b.f1825dN)).booleanValue()) {
            C1780y.m6104c(this.f2322a);
        }
        if (((Boolean) this.f2322a.m6656a(C1568b.f1824dM)).booleanValue()) {
            C1780y.m6106b(this.f2322a);
        }
        if (((Boolean) this.f2322a.m6656a(C1568b.f1823dL)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.f2322a.m6656a(C1568b.f1820dI)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(m6535r()));
        }
        map.put("htn", Boolean.valueOf(m6528y()));
    }

    /* renamed from: a */
    private boolean m6561a(String str) {
        try {
            return Settings.Secure.getInt(this.f2324c.getContentResolver(), str) == 1;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m6560a(String str, String str2) {
        for (String str3 : CollectionUtils.explode(str2)) {
            if (str.startsWith(str3)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private String m6552b(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = 9; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static C1677a m6550c(Context context) {
        if (m6534s()) {
            try {
                C1677a c1677a = new C1677a();
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                c1677a.f2333a = advertisingIdInfo.isLimitAdTrackingEnabled();
                c1677a.f2334b = advertisingIdInfo.getId();
                return c1677a;
            } catch (Throwable th) {
                C1710r.m6316c("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
            }
        } else {
            C1710r.m6310i("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }");
        }
        return new C1677a();
    }

    /* renamed from: n */
    private Map<String, String> m6539n() {
        return Utils.stringifyObjectMap(m6557a(null, true, false));
    }

    /* renamed from: o */
    private Map<String, Object> m6538o() {
        Map<String, String> metaData;
        HashMap hashMap = new HashMap(32);
        hashMap.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("brand_name", Build.BRAND);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("sim", Boolean.valueOf(m6542k()));
        hashMap.put("aida", Boolean.valueOf(m6534s()));
        hashMap.put("locale", Locale.getDefault().toString());
        hashMap.put("model", Build.MODEL);
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("platform", "android");
        hashMap.put("revision", Build.DEVICE);
        hashMap.put("tz_offset", Double.valueOf(m6573A()));
        hashMap.put("gy", Boolean.valueOf(m6571C()));
        hashMap.put("country_code", m6570D());
        hashMap.put("carrier", m6569E());
        hashMap.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.f2324c)));
        hashMap.put("tv", Boolean.valueOf(m6572B()));
        DisplayMetrics displayMetrics = this.f2324c.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            hashMap.put("adns", Float.valueOf(displayMetrics.density));
            hashMap.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            hashMap.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            hashMap.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            Point m6279a = C1724f.m6279a(this.f2324c);
            hashMap.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow(m6279a.x, 2.0d) + Math.pow(m6279a.y, 2.0d)) / displayMetrics.xdpi));
        }
        hashMap.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        if (this.f2322a.m6607g() && (metaData = Utils.getMetaData(this.f2322a.m6598p())) != null) {
            String str = metaData.get("GraphicsMemorySizeMegabytes");
            if (StringUtils.isValidString(str)) {
                try {
                    hashMap.put("gms_mb", Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException unused) {
                    C1710r c1710r = this.f2323b;
                    c1710r.m6314e("DataCollector", "Graphics memory size megabytes couldn't be parsed to an integer: " + str);
                }
            }
        }
        m6559a(hashMap);
        return hashMap;
    }

    /* renamed from: p */
    private String m6537p() {
        int orientation = Utils.getOrientation(this.f2324c);
        return orientation == 1 ? "portrait" : orientation == 2 ? "landscape" : "none";
    }

    /* renamed from: q */
    private Map<String, Object> m6536q() {
        PackageInfo packageInfo;
        HashMap hashMap = new HashMap(20);
        PackageManager packageManager = this.f2324c.getPackageManager();
        ApplicationInfo applicationInfo = this.f2324c.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f2324c.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        hashMap.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, packageManager.getApplicationLabel(applicationInfo));
        hashMap.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        hashMap.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        hashMap.put("package_name", applicationInfo.packageName);
        hashMap.put("vz", StringUtils.toShortSHA1Hash(applicationInfo.packageName));
        if (str == null) {
            str = "";
        }
        hashMap.put("installer_name", str);
        hashMap.put("tg", C1762n.m6165a(this.f2322a));
        hashMap.put("debug", Boolean.valueOf(Utils.isPubInDebugMode(this.f2322a.m6677J())));
        hashMap.put("ia", Long.valueOf(lastModified));
        Long l = (Long) this.f2322a.m6654a(C1570d.f1932d);
        if (l != null) {
            hashMap.put("ia_v2", l);
        } else {
            this.f2322a.m6653a((C1570d<C1570d<Long>>) C1570d.f1932d, (C1570d<Long>) Long.valueOf(lastModified));
        }
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        String userEngagementSdkVersion = Utils.getUserEngagementSdkVersion();
        if (StringUtils.isValidString(userEngagementSdkVersion)) {
            hashMap.put("ue_sdk_version", userEngagementSdkVersion);
        }
        hashMap.put("api_did", this.f2322a.m6656a(C1568b.f1650W));
        hashMap.put("first_install", Boolean.valueOf(this.f2322a.m6673N()));
        hashMap.put("first_install_v2", Boolean.valueOf(!this.f2322a.m6672O()));
        hashMap.put("first_install_v3_ms", packageInfo != null ? Long.valueOf(packageInfo.firstInstallTime) : "");
        hashMap.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        hashMap.put("epv", Integer.valueOf(Utils.tryToGetExoPlayerVersionCode()));
        return hashMap;
    }

    /* renamed from: r */
    private boolean m6535r() {
        ConnectivityManager connectivityManager;
        if (C1724f.m6273f() && (connectivityManager = (ConnectivityManager) this.f2324c.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getRestrictBackgroundStatus() == 3;
            } catch (Throwable th) {
                this.f2322a.m6588z().m6318b("DataCollector", "Unable to collect constrained network info.", th);
            }
        }
        return false;
    }

    /* renamed from: s */
    private static boolean m6534s() {
        return Utils.checkClassExistence("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    /* renamed from: t */
    private C1678b m6533t() {
        C1678b c1678b = new C1678b();
        Intent registerReceiver = this.f2324c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            c1678b.f2336b = -1;
        } else {
            c1678b.f2336b = (int) ((intExtra / intExtra2) * 100.0f);
        }
        c1678b.f2335a = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        return c1678b;
    }

    /* renamed from: u */
    private long m6532u() {
        List asList = Arrays.asList(StringUtils.emptyIfNull(Settings.Secure.getString(this.f2324c.getContentResolver(), "enabled_accessibility_services")).split(":"));
        long j = asList.contains("AccessibilityMenuService") ? 256L : 0L;
        if (asList.contains("SelectToSpeakService")) {
            j |= 512;
        }
        if (asList.contains("SoundAmplifierService")) {
            j |= 2;
        }
        if (asList.contains("SpeechToTextAccessibilityService")) {
            j |= 128;
        }
        if (asList.contains("SwitchAccessService")) {
            j |= 4;
        }
        if ((this.f2324c.getResources().getConfiguration().uiMode & 48) == 32) {
            j |= 1024;
        }
        if (m6561a("accessibility_enabled")) {
            j |= 8;
        }
        if (m6561a("touch_exploration_enabled")) {
            j |= 16;
        }
        if (C1724f.m6275d()) {
            if (m6561a("accessibility_display_inversion_enabled")) {
                j |= 32;
            }
            return m6561a("skip_first_use_hints") ? j | 64 : j;
        }
        return j;
    }

    /* renamed from: v */
    private float m6531v() {
        try {
            return Settings.System.getFloat(this.f2324c.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            this.f2323b.m6318b("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    /* renamed from: w */
    private String m6530w() {
        AudioManager audioManager = (AudioManager) this.f2324c.getSystemService("audio");
        if (audioManager != null) {
            StringBuilder sb = new StringBuilder();
            if (C1724f.m6274e()) {
                for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                    String m6564a = m6564a(audioDeviceInfo.getType());
                    if (!TextUtils.isEmpty(m6564a)) {
                        sb.append(m6564a);
                        sb.append(",");
                    }
                }
            } else {
                if (audioManager.isWiredHeadsetOn()) {
                    sb.append("headphones");
                    sb.append(",");
                }
                if (audioManager.isBluetoothA2dpOn()) {
                    sb.append("bluetootha2dpoutput");
                }
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                this.f2323b.m6319b("DataCollector", "No sound outputs detected");
            }
            return sb2;
        }
        return null;
    }

    /* renamed from: x */
    private String m6529x() {
        if (C1724f.m6273f()) {
            try {
                StringBuilder sb = new StringBuilder();
                LocaleList locales = this.f2324c.getResources().getConfiguration().getLocales();
                for (int i = 0; i < locales.size(); i++) {
                    sb.append(locales.get(i));
                    sb.append(",");
                }
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: y */
    private boolean m6528y() {
        Activity m6628al;
        Window window;
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        return (!C1724f.m6272g() || (m6628al = this.f2322a.m6628al()) == null || (window = m6628al.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getSafeInsetTop() <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public Integer m6527z() {
        AudioManager audioManager = (AudioManager) this.f2324c.getSystemService("audio");
        if (audioManager != null) {
            return Integer.valueOf((int) (audioManager.getStreamVolume(3) * ((Float) this.f2322a.m6656a(C1568b.f1822dK)).floatValue()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m6565a() {
        String encodeToString = Base64.encodeToString(new JSONObject(m6539n()).toString().getBytes(Charset.defaultCharset()), 2);
        if (((Boolean) this.f2322a.m6656a(C1568b.f1904eo)).booleanValue()) {
            return C1758k.m6188a(encodeToString, this.f2322a.m6590x(), Utils.getServerAdjustedUnixTimestampMillis(this.f2322a));
        }
        return encodeToString;
    }

    /* renamed from: a */
    public Map<String, Object> m6557a(Map<String, String> map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap(64);
        Map<String, Object> m6556a = m6556a(z);
        Map<String, Object> m6546g = m6546g();
        Map<String, Object> m6544i = m6544i();
        if (z2) {
            hashMap.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, m6556a);
            hashMap.put("app_info", m6546g);
            if (m6544i != null) {
                hashMap.put("connection_info", m6544i);
            }
            if (map != null) {
                hashMap.put("ad_info", map);
            }
        } else {
            hashMap.putAll(m6556a);
            hashMap.putAll(m6546g);
            if (m6544i != null) {
                hashMap.putAll(m6544i);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
        }
        hashMap.put("accept", "custom_size,launch_app,video");
        hashMap.put("format", "json");
        Utils.putObjectForStringIfValid("mediation_provider", this.f2322a.m6595s(), hashMap);
        Utils.putObjectForStringIfValid("plugin_version", (String) this.f2322a.m6656a(C1568b.f1863dz), hashMap);
        if (!((Boolean) this.f2322a.m6656a(C1568b.f1903en)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f2322a.m6590x());
        }
        hashMap.putAll(m6545h());
        if (((Boolean) this.f2322a.m6656a(C1568b.f1834dW)).booleanValue()) {
            C1587g m6669R = this.f2322a.m6669R();
            hashMap.put("li", Long.valueOf(m6669R.m6890b(C1586f.f2033b)));
            hashMap.put("si", Long.valueOf(m6669R.m6890b(C1586f.f2035d)));
            hashMap.put("pf", Long.valueOf(m6669R.m6890b(C1586f.f2039h)));
            hashMap.put("mpf", Long.valueOf(m6669R.m6890b(C1586f.f2046o)));
            hashMap.put("gpf", Long.valueOf(m6669R.m6890b(C1586f.f2040i)));
            hashMap.put("asoac", Long.valueOf(m6669R.m6890b(C1586f.f2044m)));
        }
        hashMap.put("rid", UUID.randomUUID().toString());
        return hashMap;
    }

    /* renamed from: a */
    public Map<String, Object> m6556a(boolean z) {
        HashMap hashMap;
        synchronized (this.f2326e) {
            hashMap = new HashMap(this.f2325d);
        }
        return m6558a(hashMap, z);
    }

    /* renamed from: b */
    public Map<String, Object> m6555b() {
        return new HashMap(this.f2325d);
    }

    /* renamed from: c */
    public Map<String, Object> m6551c() {
        return new HashMap(this.f2327f);
    }

    /* renamed from: d */
    public Map<String, Object> m6549d() {
        return m6556a(false);
    }

    /* renamed from: e */
    public void m6548e() {
        synchronized (this.f2326e) {
            m6559a(this.f2325d);
        }
    }

    /* renamed from: f */
    public boolean m6547f() {
        return this.f2328g;
    }

    /* renamed from: g */
    public Map<String, Object> m6546g() {
        HashMap hashMap = new HashMap(this.f2327f);
        hashMap.put("test_ads", Boolean.valueOf(this.f2328g));
        if (((Boolean) this.f2322a.m6656a(C1568b.f1856ds)).booleanValue()) {
            Utils.putObjectForStringIfValid("cuid", this.f2322a.m6601m(), hashMap);
        }
        if (((Boolean) this.f2322a.m6656a(C1568b.f1859dv)).booleanValue()) {
            hashMap.put("compass_random_token", this.f2322a.m6600n());
        }
        if (((Boolean) this.f2322a.m6656a(C1568b.f1861dx)).booleanValue()) {
            hashMap.put("applovin_random_token", this.f2322a.m6599o());
        }
        String name = this.f2322a.m6597q().getName();
        if (StringUtils.isValidString(name)) {
            hashMap.put("user_segment_name", name);
        }
        return hashMap;
    }

    /* renamed from: h */
    public Map<String, Object> m6545h() {
        HashMap hashMap = new HashMap(5);
        hashMap.put("sc", this.f2322a.m6656a(C1568b.f1682ab));
        hashMap.put("sc2", this.f2322a.m6656a(C1568b.f1683ac));
        hashMap.put("sc3", this.f2322a.m6656a(C1568b.f1684ad));
        hashMap.put("server_installed_at", this.f2322a.m6656a(C1568b.f1685ae));
        Utils.putObjectForStringIfValid("persisted_data", (String) this.f2322a.m6654a(C1570d.f1953y), hashMap);
        return hashMap;
    }

    /* renamed from: i */
    public Map<String, Object> m6544i() {
        C1684b.C1686b m6510a = this.f2322a.m6671P().m6510a();
        if (m6510a != null) {
            HashMap hashMap = new HashMap(4);
            hashMap.put("lrm_ts_ms", Long.valueOf(m6510a.m6495a()));
            hashMap.put("lrm_url", m6510a.m6494b());
            hashMap.put("lrm_ct_ms", Long.valueOf(m6510a.m6492d()));
            hashMap.put("lrm_rs", Long.valueOf(m6510a.m6493c()));
            return hashMap;
        }
        return null;
    }

    /* renamed from: j */
    public C1677a m6543j() {
        C1677a m6550c = m6550c(this.f2324c);
        if (((Boolean) this.f2322a.m6656a(C1568b.f1855dr)).booleanValue()) {
            if (m6550c.f2333a && !((Boolean) this.f2322a.m6656a(C1568b.f1854dq)).booleanValue()) {
                m6550c.f2334b = "";
            }
            f2321j.set(m6550c);
        } else {
            m6550c = new C1677a();
        }
        this.f2328g = StringUtils.isValidString(m6550c.f2334b) ? this.f2322a.m6598p().getTestDeviceAdvertisingIds().contains(m6550c.f2334b) : false;
        return m6550c;
    }

    /* renamed from: k */
    public boolean m6542k() {
        return m6560a(Build.DEVICE, "goldfish,vbox") || m6560a(Build.HARDWARE, "ranchu,generic,vbox") || m6560a(Build.MANUFACTURER, "Genymotion") || m6560a(Build.MODEL, "Android SDK built for x86");
    }

    /* renamed from: l */
    public void m6541l() {
        this.f2322a.m6670Q().m6793a(new C1599f(this.f2322a, new C1599f.InterfaceC1600a() { // from class: com.applovin.impl.sdk.m.2
            @Override // com.applovin.impl.sdk.p031e.C1599f.InterfaceC1600a
            /* renamed from: a */
            public void mo6526a(C1677a c1677a) {
                C1673m.f2321j.set(c1677a);
            }
        }), C1620o.EnumC1622a.ADVERTISING_INFO_COLLECTION);
        this.f2322a.m6670Q().m6793a(new C1642y(this.f2322a, true, new Runnable() { // from class: com.applovin.impl.sdk.m.3
            @Override // java.lang.Runnable
            public void run() {
                C1673m.this.f2329k.set(C1673m.this.m6527z());
            }
        }), C1620o.EnumC1622a.CACHING_OTHER);
    }
}

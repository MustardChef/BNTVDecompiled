package com.applovin.impl.mediation.p015c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.ServerProtocol;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.c */
/* loaded from: classes.dex */
public class C1391c {

    /* renamed from: a */
    private static final TreeMap<String, String> f974a;

    /* renamed from: b */
    private static final List<String> f975b;

    /* renamed from: c */
    private static JSONArray f976c;

    static {
        TreeMap<String, String> treeMap = new TreeMap<>();
        f974a = treeMap;
        treeMap.put("com.applovin.mediation.adapters.AdColonyMediationAdapter", "AdColony");
        treeMap.put("com.applovin.mediation.adapters.AmazonMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AmazonBiddingMediationAdapter", "Amazon");
        treeMap.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", "AppLovin");
        treeMap.put("com.applovin.mediation.adapters.ByteDanceMediationAdapter", "Pangle");
        treeMap.put("com.applovin.mediation.adapters.ChartboostMediationAdapter", "Chartboost");
        treeMap.put("com.applovin.mediation.adapters.DataseatMediationAdapter", "Dataseat");
        treeMap.put("com.applovin.mediation.adapters.FacebookMediationAdapter", "Facebook");
        treeMap.put("com.applovin.mediation.adapters.GoogleMediationAdapter", "AdMob");
        treeMap.put("com.applovin.mediation.adapters.GoogleAdManagerMediationAdapter", "Google Ad Manager");
        treeMap.put("com.applovin.mediation.adapters.HyprMXMediationAdapter", "HyprMX");
        treeMap.put("com.applovin.mediation.adapters.IMobileMediationAdapter", "i-mobile");
        treeMap.put("com.applovin.mediation.adapters.InMobiMediationAdapter", "InMobi");
        treeMap.put("com.applovin.mediation.adapters.InneractiveMediationAdapter", "Fyber");
        treeMap.put("com.applovin.mediation.adapters.IronSourceMediationAdapter", "ironSource");
        treeMap.put("com.applovin.mediation.adapters.LeadboltMediationAdapter", "Leadbolt");
        treeMap.put("com.applovin.mediation.adapters.LineMediationAdapter", "LINE");
        treeMap.put("com.applovin.mediation.adapters.MadvertiseMediationAdapter", "madvertise");
        treeMap.put("com.applovin.mediation.adapters.MaioMediationAdapter", "Maio");
        treeMap.put("com.applovin.mediation.adapters.MintegralMediationAdapter", "Mintegral");
        treeMap.put("com.applovin.mediation.adapters.MoPubMediationAdapter", "MoPub");
        treeMap.put("com.applovin.mediation.adapters.MyTargetMediationAdapter", "myTarget");
        treeMap.put("com.applovin.mediation.adapters.NendMediationAdapter", "Nend");
        treeMap.put("com.applovin.mediation.adapters.OguryMediationAdapter", "Ogury");
        treeMap.put("com.applovin.mediation.adapters.OguryPresageMediationAdapter", "Ogury Presage");
        treeMap.put("com.applovin.mediation.adapters.SayGamesMediationAdapter", "SayGames");
        treeMap.put("com.applovin.mediation.adapters.SmaatoMediationAdapter", "Smaato");
        treeMap.put("com.applovin.mediation.adapters.SnapMediationAdapter", "Snap");
        treeMap.put("com.applovin.mediation.adapters.TapjoyMediationAdapter", "Tapjoy");
        treeMap.put("com.applovin.mediation.adapters.TencentMediationAdapter", "Tencent");
        treeMap.put("com.applovin.mediation.adapters.UnityAdsMediationAdapter", "Unity Ads");
        treeMap.put("com.applovin.mediation.adapters.VerizonAdsMediationAdapter", "Verizon");
        treeMap.put("com.applovin.mediation.adapters.VerveMediationAdapter", "Verve");
        treeMap.put("com.applovin.mediation.adapters.VungleMediationAdapter", "Vungle");
        treeMap.put("com.applovin.mediation.adapters.YandexMediationAdapter", "Yandex");
        f975b = new ArrayList(treeMap.keySet());
    }

    /* renamed from: a */
    public static C1620o.EnumC1622a m7598a(MaxAdFormat maxAdFormat) {
        return maxAdFormat == MaxAdFormat.INTERSTITIAL ? C1620o.EnumC1622a.MEDIATION_INTERSTITIAL : maxAdFormat == MaxAdFormat.REWARDED ? C1620o.EnumC1622a.MEDIATION_INCENTIVIZED : maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL ? C1620o.EnumC1622a.MEDIATION_REWARDED_INTERSTITIAL : C1620o.EnumC1622a.MEDIATION_BANNER;
    }

    /* renamed from: a */
    public static MaxAdapter m7596a(String str, C1662k c1662k) {
        Class<?> cls;
        if (TextUtils.isEmpty(str)) {
            c1662k.m6588z().m6314e("AppLovinSdk", "Failed to create adapter instance. No class name provided");
            return null;
        }
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            C1710r m6588z = c1662k.m6588z();
            m6588z.m6318b("AppLovinSdk", "Failed to load: " + str, th);
        }
        if (MaxAdapter.class.isAssignableFrom(cls)) {
            return (MaxAdapter) cls.getConstructor(AppLovinSdk.class).newInstance(c1662k.m6664W());
        }
        C1710r m6588z2 = c1662k.m6588z();
        m6588z2.m6314e("AppLovinSdk", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
        return null;
    }

    /* renamed from: a */
    public static AppLovinSdkUtils.Size m7600a(int i, MaxAdFormat maxAdFormat, Activity activity) {
        if (i < 0) {
            try {
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                i = AppLovinSdkUtils.pxToDp(activity, displayMetrics.widthPixels);
            } catch (Throwable th) {
                C1710r.m6316c("MediationUtils", "Failed to get adaptive banner size. Will fallback to using format specific ad view ad size.", th);
                return maxAdFormat.getSize();
            }
        }
        Class<?> cls = Class.forName("com.google.android.gms.ads.AdSize");
        Method method = cls.getMethod("getCurrentOrientationAnchoredAdaptiveBannerAdSize", Context.class, Integer.TYPE);
        Method method2 = cls.getMethod("getWidth", new Class[0]);
        Method method3 = cls.getMethod("getHeight", new Class[0]);
        Object invoke = method.invoke(null, activity, Integer.valueOf(i));
        return new AppLovinSdkUtils.Size(((Integer) method2.invoke(invoke, new Object[0])).intValue(), ((Integer) method3.invoke(invoke, new Object[0])).intValue());
    }

    /* renamed from: a */
    public static JSONArray m7599a(C1662k c1662k) {
        JSONArray jSONArray;
        if (((Boolean) c1662k.m6656a(C1567a.f1614M)).booleanValue() || (jSONArray = f976c) == null) {
            if (f976c != null) {
                m7595b(c1662k);
                return f976c;
            }
            f976c = new JSONArray();
            for (String str : f975b) {
                MaxAdapter m7596a = m7596a(str, c1662k);
                if (m7596a != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", f974a.get(str));
                        jSONObject.put("class", str);
                        jSONObject.put("sdk_version", m7596a.getSdkVersion());
                        jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, m7596a.getAdapterVersion());
                    } catch (Throwable unused) {
                    }
                    f976c.put(jSONObject);
                }
            }
            return f976c;
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static boolean m7597a(Object obj) {
        return (obj instanceof AbstractC1537g) && StringUtils.isValidString(((AbstractC1537g) obj).m7160M());
    }

    /* renamed from: b */
    private static void m7595b(C1662k c1662k) {
        MaxAdapter m7596a;
        for (int i = 0; i < f976c.length(); i++) {
            JSONObject jSONObject = JsonUtils.getJSONObject(f976c, i, (JSONObject) null);
            String string = JsonUtils.getString(jSONObject, "class", "");
            if (!StringUtils.isValidString(JsonUtils.getString(jSONObject, "sdk_version", "")) && (m7596a = m7596a(string, c1662k)) != null) {
                JsonUtils.putString(jSONObject, "sdk_version", m7596a.getSdkVersion());
            }
        }
    }

    /* renamed from: b */
    public static boolean m7594b(Object obj) {
        return (obj instanceof AbstractC1334a) && "APPLOVIN".equals(((AbstractC1334a) obj).m7762L());
    }
}

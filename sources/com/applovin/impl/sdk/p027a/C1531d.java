package com.applovin.impl.sdk.p027a;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.appevents.AppEventsConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.d */
/* loaded from: classes.dex */
public final class C1531d {

    /* renamed from: a */
    private static final Map<String, C1531d> f1486a = new HashMap();

    /* renamed from: b */
    private static final Object f1487b = new Object();

    /* renamed from: c */
    private JSONObject f1488c;

    /* renamed from: d */
    private final String f1489d;

    /* renamed from: e */
    private AppLovinAdSize f1490e;

    /* renamed from: f */
    private AppLovinAdType f1491f;

    private C1531d(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        String str2;
        if (TextUtils.isEmpty(str) && (appLovinAdType == null || appLovinAdSize == null)) {
            throw new IllegalArgumentException("No zone identifier or type or size specified");
        }
        this.f1490e = appLovinAdSize;
        this.f1491f = appLovinAdType;
        if (StringUtils.isValidString(str)) {
            str2 = str.trim();
        } else {
            str2 = appLovinAdSize.getLabel() + "_" + appLovinAdType.getLabel();
        }
        this.f1489d = str2.toLowerCase(Locale.ENGLISH);
    }

    /* renamed from: a */
    public static C1531d m7217a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return m7216a(appLovinAdSize, appLovinAdType, null);
    }

    /* renamed from: a */
    public static C1531d m7216a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        C1531d c1531d = new C1531d(appLovinAdSize, appLovinAdType, str);
        synchronized (f1487b) {
            String str2 = c1531d.f1489d;
            Map<String, C1531d> map = f1486a;
            if (map.containsKey(str2)) {
                c1531d = map.get(str2);
            } else {
                map.put(str2, c1531d);
            }
        }
        return c1531d;
    }

    /* renamed from: a */
    public static C1531d m7215a(String str) {
        return m7216a(null, null, str);
    }

    /* renamed from: a */
    public static C1531d m7214a(String str, JSONObject jSONObject) {
        C1531d m7215a = m7215a(str);
        m7215a.f1488c = jSONObject;
        return m7215a;
    }

    /* renamed from: a */
    public static void m7213a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has(AppEventsConstants.EVENT_PARAM_AD_TYPE)) {
            synchronized (f1487b) {
                C1531d c1531d = f1486a.get(JsonUtils.getString(jSONObject, "zone_id", ""));
                if (c1531d != null) {
                    c1531d.f1490e = AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", ""));
                    c1531d.f1491f = AppLovinAdType.fromString(JsonUtils.getString(jSONObject, AppEventsConstants.EVENT_PARAM_AD_TYPE, ""));
                }
            }
        }
    }

    /* renamed from: b */
    public static C1531d m7211b(String str) {
        return m7216a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str);
    }

    /* renamed from: f */
    public static Collection<C1531d> m7207f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(5);
        Collections.addAll(linkedHashSet, m7206g(), m7205h(), m7204i(), m7203j(), m7202k());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    /* renamed from: g */
    public static C1531d m7206g() {
        return m7217a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR);
    }

    /* renamed from: h */
    public static C1531d m7205h() {
        return m7217a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR);
    }

    /* renamed from: i */
    public static C1531d m7204i() {
        return m7217a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR);
    }

    /* renamed from: j */
    public static C1531d m7203j() {
        return m7217a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
    }

    /* renamed from: k */
    public static C1531d m7202k() {
        return m7217a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED);
    }

    /* renamed from: a */
    public String m7218a() {
        return this.f1489d;
    }

    /* renamed from: b */
    public MaxAdFormat m7212b() {
        AppLovinAdSize m7210c = m7210c();
        if (m7210c == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (m7210c == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (m7210c == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (m7210c == AppLovinAdSize.CROSS_PROMO) {
            return MaxAdFormat.CROSS_PROMO;
        }
        if (m7210c == AppLovinAdSize.INTERSTITIAL) {
            if (m7209d() == AppLovinAdType.REGULAR) {
                return MaxAdFormat.INTERSTITIAL;
            }
            if (m7209d() == AppLovinAdType.INCENTIVIZED) {
                return MaxAdFormat.REWARDED;
            }
            if (m7209d() == AppLovinAdType.AUTO_INCENTIVIZED) {
                return MaxAdFormat.REWARDED_INTERSTITIAL;
            }
            return null;
        }
        return null;
    }

    /* renamed from: c */
    public AppLovinAdSize m7210c() {
        if (this.f1490e == null && JsonUtils.valueExists(this.f1488c, "ad_size")) {
            this.f1490e = AppLovinAdSize.fromString(JsonUtils.getString(this.f1488c, "ad_size", null));
        }
        return this.f1490e;
    }

    /* renamed from: d */
    public AppLovinAdType m7209d() {
        if (this.f1491f == null && JsonUtils.valueExists(this.f1488c, AppEventsConstants.EVENT_PARAM_AD_TYPE)) {
            this.f1491f = AppLovinAdType.fromString(JsonUtils.getString(this.f1488c, AppEventsConstants.EVENT_PARAM_AD_TYPE, null));
        }
        return this.f1491f;
    }

    /* renamed from: e */
    public boolean m7208e() {
        return m7207f().contains(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f1489d.equalsIgnoreCase(((C1531d) obj).f1489d);
    }

    public int hashCode() {
        return this.f1489d.hashCode();
    }

    public String toString() {
        return "AdZone{id=" + this.f1489d + ", zoneObject=" + this.f1488c + '}';
    }
}

package com.applovin.impl.sdk;

import android.graphics.Color;
import com.applovin.impl.sdk.p027a.C1531d;
import com.applovin.impl.sdk.p027a.C1543h;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class AppLovinAdBase implements AppLovinAd {

    /* renamed from: a */
    private final int f1407a;
    protected final JSONObject adObject;
    protected final Object adObjectLock;

    /* renamed from: b */
    private C1531d f1408b;

    /* renamed from: c */
    private final long f1409c;

    /* renamed from: d */
    private C1543h f1410d;
    protected final JSONObject fullResponse;
    protected final Object fullResponseLock;
    protected final C1662k sdk;
    protected final EnumC1528b source;

    /* JADX INFO: Access modifiers changed from: protected */
    public AppLovinAdBase(JSONObject jSONObject, JSONObject jSONObject2, EnumC1528b enumC1528b, C1662k c1662k) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        }
        if (jSONObject2 == null) {
            throw new IllegalArgumentException("No response specified");
        }
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.adObject = jSONObject;
        this.fullResponse = jSONObject2;
        this.source = enumC1528b;
        this.sdk = c1662k;
        this.adObjectLock = new Object();
        this.fullResponseLock = new Object();
        this.f1409c = System.currentTimeMillis();
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        this.f1407a = new String(charArray).hashCode();
    }

    protected boolean containsKeyForAdObject(String str) {
        boolean has;
        synchronized (this.adObjectLock) {
            has = this.adObject.has(str);
        }
        return has;
    }

    public boolean equals(Object obj) {
        AppLovinAd m7066b;
        if ((obj instanceof C1543h) && (m7066b = ((C1543h) obj).m7066b()) != null) {
            obj = m7066b;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAdBase appLovinAdBase = (AppLovinAdBase) obj;
        C1531d c1531d = this.f1408b;
        if (c1531d == null ? appLovinAdBase.f1408b == null : c1531d.equals(appLovinAdBase.f1408b)) {
            return this.source == appLovinAdBase.source && this.f1407a == appLovinAdBase.f1407a;
        }
        return false;
    }

    @Override // com.applovin.sdk.AppLovinAd
    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1L);
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getAdValue(String str, String str2) {
        return JsonUtils.getString(getJsonObjectFromAdObject("ad_values", new JSONObject()), str, str2);
    }

    public C1531d getAdZone() {
        C1531d c1531d = this.f1408b;
        if (c1531d != null) {
            if (c1531d.m7210c() != null && this.f1408b.m7209d() != null) {
                return this.f1408b;
            }
            if (getSize() == null && getType() == null) {
                return this.f1408b;
            }
        }
        C1531d m7216a = C1531d.m7216a(getSize(), getType(), getStringFromFullResponse("zone_id", null));
        this.f1408b = m7216a;
        return m7216a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getBooleanFromAdObject(String str, Boolean bool) {
        boolean booleanValue;
        synchronized (this.adObjectLock) {
            booleanValue = JsonUtils.getBoolean(this.adObject, str, bool).booleanValue();
        }
        return booleanValue;
    }

    protected boolean getBooleanFromFullResponse(String str, boolean z) {
        boolean booleanValue;
        synchronized (this.fullResponseLock) {
            booleanValue = JsonUtils.getBoolean(this.fullResponse, str, Boolean.valueOf(z)).booleanValue();
        }
        return booleanValue;
    }

    public String getClCode() {
        String stringFromAdObject = getStringFromAdObject("clcode", "");
        return StringUtils.isValidString(stringFromAdObject) ? stringFromAdObject : getStringFromFullResponse("clcode", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getColorFromAdObject(String str, int i) {
        String stringFromAdObject = getStringFromAdObject(str, null);
        return StringUtils.isValidString(stringFromAdObject) ? Color.parseColor(stringFromAdObject) : i;
    }

    public long getCreatedAtMillis() {
        return this.f1409c;
    }

    public C1543h getDummyAd() {
        return this.f1410d;
    }

    public long getFetchLatencyMillis() {
        return getLongFromFullResponse("ad_fetch_latency_millis", -1L);
    }

    public long getFetchResponseSize() {
        return getLongFromFullResponse("ad_fetch_response_size", -1L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getFloatFromAdObject(String str, float f) {
        float f2;
        synchronized (this.adObjectLock) {
            f2 = JsonUtils.getFloat(this.adObject, str, f);
        }
        return f2;
    }

    protected float getFloatFromFullResponse(String str, float f) {
        float f2;
        synchronized (this.fullResponseLock) {
            f2 = JsonUtils.getFloat(this.fullResponse, str, f);
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getIntFromAdObject(String str, int i) {
        int i2;
        synchronized (this.adObjectLock) {
            i2 = JsonUtils.getInt(this.adObject, str, i);
        }
        return i2;
    }

    protected int getIntFromFullResponse(String str, int i) {
        int i2;
        synchronized (this.fullResponseLock) {
            i2 = JsonUtils.getInt(this.fullResponse, str, i);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject getJsonObjectFromAdObject(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.adObjectLock) {
            jSONObject2 = JsonUtils.getJSONObject(this.adObject, str, jSONObject);
        }
        return jSONObject2;
    }

    protected JSONObject getJsonObjectFromFullResponse(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.fullResponseLock) {
            jSONObject2 = JsonUtils.getJSONObject(this.fullResponse, str, jSONObject);
        }
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getLongFromAdObject(String str, long j) {
        long j2;
        synchronized (this.adObjectLock) {
            j2 = JsonUtils.getLong(this.adObject, str, j);
        }
        return j2;
    }

    protected long getLongFromFullResponse(String str, long j) {
        long j2;
        synchronized (this.fullResponseLock) {
            j2 = JsonUtils.getLong(this.fullResponse, str, j);
        }
        return j2;
    }

    public String getPrimaryKey() {
        return getStringFromAdObject("pk", "NA");
    }

    public String getRawFullResponse() {
        String jSONObject;
        synchronized (this.fullResponseLock) {
            jSONObject = this.fullResponse.toString();
        }
        return jSONObject;
    }

    public C1662k getSdk() {
        return this.sdk;
    }

    public String getSecondaryKey1() {
        return getStringFromAdObject("sk1", null);
    }

    public String getSecondaryKey2() {
        return getStringFromAdObject("sk2", null);
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", null));
    }

    public EnumC1528b getSource() {
        return this.source;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStringFromAdObject(String str, String str2) {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, str, str2);
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getStringFromFullResponse(String str, String str2) {
        String string;
        synchronized (this.fullResponseLock) {
            string = JsonUtils.getString(this.fullResponse, str, str2);
        }
        return string;
    }

    @Override // com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse(AppEventsConstants.EVENT_PARAM_AD_TYPE, null));
    }

    @Override // com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (getAdZone().m7208e()) {
            return null;
        }
        return getStringFromFullResponse("zone_id", null);
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", false);
    }

    public boolean hasVideoUrl() {
        this.sdk.m6588z().m6314e("AppLovinAdBase", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public int hashCode() {
        return this.f1407a;
    }

    @Override // com.applovin.sdk.AppLovinAd
    public boolean isVideoAd() {
        return this.adObject.has("is_video_ad") ? getBooleanFromAdObject("is_video_ad", false) : hasVideoUrl();
    }

    public void setDummyAd(C1543h c1543h) {
        this.f1410d = c1543h;
    }

    public void setHasShown(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return getBooleanFromAdObject("chcis", false);
    }

    public String toString() {
        return "AppLovinAd{adIdNumber=" + getAdIdNumber() + ", source=" + getSource() + ", zoneId='" + getZoneId() + "'}";
    }
}

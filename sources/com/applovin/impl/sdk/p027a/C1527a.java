package com.applovin.impl.sdk.p027a;

import android.net.Uri;
import com.applovin.impl.adview.AbstractC1252j;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.a.a */
/* loaded from: classes.dex */
public final class C1527a extends AbstractC1537g {

    /* renamed from: a */
    private final String f1468a;

    /* renamed from: b */
    private final String f1469b;

    /* renamed from: c */
    private final String f1470c;

    public C1527a(JSONObject jSONObject, JSONObject jSONObject2, EnumC1528b enumC1528b, C1662k c1662k) {
        super(jSONObject, jSONObject2, enumC1528b, c1662k);
        this.f1468a = m7233c();
        this.f1469b = m7230i();
        this.f1470c = m7234aO();
    }

    /* renamed from: aO */
    private String m7234aO() {
        return getStringFromAdObject("stream_url", "");
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: a */
    public void mo7146a() {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", this.f1468a);
            JsonUtils.putString(this.adObject, "stream_url", this.f1470c);
        }
    }

    /* renamed from: a */
    public void m7236a(Uri uri) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "video", uri.toString());
        }
    }

    /* renamed from: a */
    public void m7235a(String str) {
        synchronized (this.adObjectLock) {
            JsonUtils.putString(this.adObject, "html", str);
        }
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: b */
    public JSONObject mo7099b() {
        JSONObject deepCopy;
        synchronized (this.fullResponseLock) {
            deepCopy = JsonUtils.deepCopy(this.fullResponse);
        }
        JSONArray jSONArray = JsonUtils.getJSONArray(deepCopy, "ads", new JSONArray());
        if (jSONArray.length() > 0) {
            JSONObject jSONObject = JsonUtils.getJSONObject(jSONArray, 0, new JSONObject());
            JsonUtils.putString(jSONObject, "html", this.f1468a);
            JsonUtils.putString(jSONObject, "video", this.f1469b);
            JsonUtils.putString(jSONObject, "stream_url", this.f1470c);
        }
        return deepCopy;
    }

    /* renamed from: c */
    public String m7233c() {
        String string;
        synchronized (this.adObjectLock) {
            string = JsonUtils.getString(this.adObject, "html", null);
        }
        return string;
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: d */
    public String mo7089d() {
        return this.f1469b;
    }

    /* renamed from: e */
    public String m7232e() {
        return this.f1470c;
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: f */
    public boolean mo7085f() {
        return this.adObject.has("stream_url");
    }

    /* renamed from: g */
    public void m7231g() {
        synchronized (this.adObjectLock) {
            this.adObject.remove("stream_url");
        }
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: h */
    public Uri mo7082h() {
        String m7234aO = m7234aO();
        if (StringUtils.isValidString(m7234aO)) {
            return Uri.parse(m7234aO);
        }
        String m7230i = m7230i();
        if (StringUtils.isValidString(m7230i)) {
            return Uri.parse(m7230i);
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public boolean hasVideoUrl() {
        return mo7082h() != null;
    }

    /* renamed from: i */
    public String m7230i() {
        return getStringFromAdObject("video", "");
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: j */
    public Uri mo7081j() {
        String stringFromAdObject = getStringFromAdObject("click_url", "");
        if (StringUtils.isValidString(stringFromAdObject)) {
            return Uri.parse(stringFromAdObject);
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.p027a.AbstractC1537g
    /* renamed from: k */
    public Uri mo7080k() {
        String stringFromAdObject = getStringFromAdObject("video_click_url", "");
        return StringUtils.isValidString(stringFromAdObject) ? Uri.parse(stringFromAdObject) : mo7081j();
    }

    /* renamed from: l */
    public float m7229l() {
        return getFloatFromAdObject("mraid_close_delay_graphic", 0.0f);
    }

    /* renamed from: m */
    public boolean m7228m() {
        return getBooleanFromAdObject("close_button_graphic_hidden", false);
    }

    /* renamed from: n */
    public boolean m7227n() {
        if (this.adObject.has("close_button_expandable_hidden")) {
            return getBooleanFromAdObject("close_button_expandable_hidden", false);
        }
        return true;
    }

    /* renamed from: o */
    public AbstractC1252j.EnumC1253a m7226o() {
        return m7145a(getIntFromAdObject("expandable_style", AbstractC1252j.EnumC1253a.INVISIBLE.m8055a()));
    }
}

package com.applovin.impl.mediation.debugger.p016a.p017a;

import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.a */
/* loaded from: classes.dex */
public class C1402a implements Comparable<C1402a> {

    /* renamed from: a */
    private final String f1013a;

    /* renamed from: b */
    private final String f1014b;

    /* renamed from: c */
    private final MaxAdFormat f1015c;

    /* renamed from: d */
    private final C1404c f1016d;

    /* renamed from: e */
    private final List<C1404c> f1017e;

    public C1402a(JSONObject jSONObject, Map<String, C1407b> map, C1662k c1662k) {
        this.f1013a = JsonUtils.getString(jSONObject, "name", "");
        this.f1014b = JsonUtils.getString(jSONObject, "display_name", "");
        this.f1015c = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, "format", null));
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "waterfalls", new JSONArray());
        this.f1017e = new ArrayList(jSONArray.length());
        C1404c c1404c = null;
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                C1404c c1404c2 = new C1404c(jSONObject2, map, c1662k);
                this.f1017e.add(c1404c2);
                if (c1404c == null && c1404c2.m7539c()) {
                    c1404c = c1404c2;
                }
            }
        }
        this.f1016d = c1404c;
    }

    /* renamed from: g */
    private C1404c m7549g() {
        if (this.f1017e.isEmpty()) {
            return null;
        }
        return this.f1017e.get(0);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C1402a c1402a) {
        return this.f1014b.compareToIgnoreCase(c1402a.f1014b);
    }

    /* renamed from: a */
    public String m7556a() {
        return this.f1013a;
    }

    /* renamed from: b */
    public String m7554b() {
        return this.f1014b;
    }

    /* renamed from: c */
    public String m7553c() {
        MaxAdFormat maxAdFormat = this.f1015c;
        return maxAdFormat != null ? maxAdFormat.getDisplayName() : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    /* renamed from: d */
    public MaxAdFormat m7552d() {
        return this.f1015c;
    }

    /* renamed from: e */
    public C1404c m7551e() {
        C1404c c1404c = this.f1016d;
        return c1404c != null ? c1404c : m7549g();
    }

    /* renamed from: f */
    public String m7550f() {
        return "\n---------- " + this.f1014b + " ----------\nIdentifier - " + this.f1013a + "\nFormat     - " + m7553c();
    }
}

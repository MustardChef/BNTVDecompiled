package com.applovin.impl.mediation.debugger.p016a.p017a;

import com.applovin.impl.mediation.debugger.p016a.p018b.C1407b;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.c */
/* loaded from: classes.dex */
public class C1404c {

    /* renamed from: a */
    private final String f1023a;

    /* renamed from: b */
    private final boolean f1024b;

    /* renamed from: c */
    private final List<C1403b> f1025c;

    /* renamed from: d */
    private final List<C1403b> f1026d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1404c(JSONObject jSONObject, Map<String, C1407b> map, C1662k c1662k) {
        this.f1023a = JsonUtils.getString(jSONObject, "name", "");
        this.f1024b = JsonUtils.getBoolean(jSONObject, MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY, false).booleanValue();
        this.f1025c = m7541a("bidders", jSONObject, map, c1662k);
        this.f1026d = m7541a("waterfall", jSONObject, map, c1662k);
    }

    /* renamed from: a */
    private List<C1403b> m7541a(String str, JSONObject jSONObject, Map<String, C1407b> map, C1662k c1662k) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, str, new JSONArray());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null);
            if (jSONObject2 != null) {
                String string = JsonUtils.getString(jSONObject2, "adapter_class", "");
                C1407b c1407b = map.get(string);
                if (c1407b == null) {
                    C1710r m6588z = c1662k.m6588z();
                    m6588z.m6314e("AdUnitWaterfall", "Failed to retrieve network info for adapter class: " + string);
                } else {
                    arrayList.add(new C1403b(jSONObject2, c1407b, c1662k));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<C1403b> m7542a() {
        return this.f1025c;
    }

    /* renamed from: b */
    public List<C1403b> m7540b() {
        return this.f1026d;
    }

    /* renamed from: c */
    public boolean m7539c() {
        return this.f1024b;
    }
}

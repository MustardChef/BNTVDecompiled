package com.applovin.impl.mediation.p014b;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.mediation.p013a.C1338e;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p030d.C1586f;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.a */
/* loaded from: classes.dex */
public class C1367a extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final Activity f914a;

    public C1367a(Activity activity, C1662k c1662k) {
        super("TaskAutoInitAdapters", c1662k, true);
        this.f914a = activity;
    }

    /* renamed from: a */
    private List<C1338e> m7666a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(new C1338e(JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, this.f2058b));
        }
        return arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2 = (String) this.f2058b.m6654a(C1570d.f1952x);
        if (StringUtils.isValidString(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                List<C1338e> m7666a = m7666a(JsonUtils.getJSONArray(jSONObject, this.f2058b.m6679H().m7351a() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                if (m7666a.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Auto-initing ");
                    sb.append(m7666a.size());
                    sb.append(" adapters");
                    sb.append(this.f2058b.m6679H().m7351a() ? " in test mode" : "");
                    sb.append("...");
                    m6884a(sb.toString());
                    if (TextUtils.isEmpty(this.f2058b.m6595s())) {
                        this.f2058b.m6614c(AppLovinMediationProvider.MAX);
                    } else if (!this.f2058b.m6609f()) {
                        C1710r.m6310i("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.f2058b.m6595s());
                    }
                    if (this.f914a == null) {
                        C1710r.m6310i("AppLovinSdk", "\n**********\nFailed to initialize 3rd-party SDKs. Please make sure to initialize the AppLovin SDK with an Activity context.\n**********\n");
                        this.f2058b.m6669R().m6889b(C1586f.f2047p, 1L);
                        return;
                    }
                    for (final C1338e c1338e : m7666a) {
                        this.f2058b.m6670Q().m6783b().execute(new Runnable() { // from class: com.applovin.impl.mediation.b.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                C1367a c1367a = C1367a.this;
                                c1367a.m6884a("Auto-initing adapter: " + c1338e);
                                C1367a.this.f2058b.m6685B().m7339a(c1338e, C1367a.this.f914a);
                            }
                        });
                    }
                }
            } catch (JSONException e) {
                e = e;
                str = "Failed to parse auto-init adapters JSON";
                m6883a(str, e);
            } catch (Throwable th) {
                e = th;
                str = "Failed to auto-init adapters";
                m6883a(str, e);
            }
        }
    }
}

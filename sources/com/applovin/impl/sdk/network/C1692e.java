package com.applovin.impl.sdk.network;

import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p029c.C1571e;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.e */
/* loaded from: classes.dex */
public class C1692e {

    /* renamed from: a */
    private static final Object f2395a = new Object();

    /* renamed from: a */
    private static JSONObject m6459a(String str, Context context) {
        JSONObject m6457b = m6457b(context);
        if (m6457b == null) {
            m6457b = new JSONObject();
        }
        if (!m6457b.has(str)) {
            try {
                m6457b.put(str, new JSONObject());
            } catch (JSONException unused) {
            }
        }
        return m6457b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m6461a(int i, String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f2395a) {
            String urlStringWithoutQueryParameters = Utils.urlStringWithoutQueryParameters(str);
            JSONObject m6459a = m6459a(urlStringWithoutQueryParameters, context);
            String num = Integer.toString(i);
            JSONObject optJSONObject = m6459a.optJSONObject(urlStringWithoutQueryParameters);
            try {
                optJSONObject.put(num, optJSONObject.optInt(num) + 1);
            } catch (JSONException unused) {
            }
            try {
                m6459a.put(urlStringWithoutQueryParameters, optJSONObject);
            } catch (JSONException unused2) {
            }
            m6458a(m6459a, context);
        }
    }

    /* renamed from: a */
    public static void m6460a(Context context) {
        synchronized (f2395a) {
            C1571e.m6986a((C1570d) C1570d.f1945q, context);
        }
    }

    /* renamed from: a */
    private static void m6458a(JSONObject jSONObject, Context context) {
        C1571e.m6984a(C1570d.f1945q, jSONObject.toString(), context);
    }

    /* renamed from: b */
    public static JSONObject m6457b(Context context) {
        JSONObject jSONObject;
        synchronized (f2395a) {
            try {
                try {
                    jSONObject = new JSONObject((String) C1571e.m6977b(C1570d.f1945q, JsonUtils.EMPTY_JSON, context));
                } catch (JSONException unused) {
                    return new JSONObject();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jSONObject;
    }
}

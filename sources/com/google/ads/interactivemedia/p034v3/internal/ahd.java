package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Build;
import android.webkit.WebView;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahd */
/* loaded from: classes2.dex */
public class ahd {

    /* renamed from: a */
    private ahx f4060a;

    /* renamed from: b */
    private long f4061b;

    /* renamed from: c */
    private int f4062c;

    public ahd() {
        m5289b();
        this.f4060a = new ahx((WebView) null);
    }

    /* renamed from: a */
    public final WebView m5290a() {
        return (WebView) this.f4060a.get();
    }

    /* renamed from: b */
    public final void m5289b() {
        this.f4061b = System.nanoTime();
        this.f4062c = 1;
    }

    /* renamed from: c */
    public void mo5282c() {
        this.f4060a.clear();
    }

    /* renamed from: d */
    public final void m5288d(String str, long j) {
        if (j < this.f4061b || this.f4062c == 3) {
            return;
        }
        this.f4062c = 3;
        agw.m5309a().m5304f(m5290a(), str);
    }

    /* renamed from: e */
    public final void m5287e(String str, long j) {
        if (j >= this.f4061b) {
            this.f4062c = 2;
            agw.m5309a().m5304f(m5290a(), str);
        }
    }

    /* renamed from: f */
    public void mo5281f(agj agjVar, agh aghVar) {
        m5286g(agjVar, aghVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final void m5286g(agj agjVar, agh aghVar, JSONObject jSONObject) {
        String m5342i = agjVar.m5342i();
        JSONObject jSONObject2 = new JSONObject();
        ahi.m5271h(jSONObject2, "environment", "app");
        ahi.m5271h(jSONObject2, "adSessionType", aghVar.m5355c());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("; ");
        sb.append(str2);
        ahi.m5271h(jSONObject3, "deviceType", sb.toString());
        ahi.m5271h(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        ahi.m5271h(jSONObject3, "os", "Android");
        ahi.m5271h(jSONObject2, "deviceInfo", jSONObject3);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        ahi.m5271h(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        ahi.m5271h(jSONObject4, "partnerName", aghVar.m5354d().m5338a());
        ahi.m5271h(jSONObject4, "partnerVersion", aghVar.m5354d().m5337b());
        ahi.m5271h(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        ahi.m5271h(jSONObject5, "libraryVersion", "1.3.3-google_20200416");
        ahi.m5271h(jSONObject5, "appId", agu.m5311b().m5312a().getApplicationContext().getPackageName());
        ahi.m5271h(jSONObject2, "app", jSONObject5);
        if (aghVar.m5353e() != null) {
            ahi.m5271h(jSONObject2, "contentUrl", aghVar.m5353e());
        }
        ahi.m5271h(jSONObject2, "customReferenceData", aghVar.m5352f());
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = aghVar.m5351g().iterator();
        if (it.hasNext()) {
            aev aevVar = (aev) it.next();
            throw null;
        } else {
            agw.m5309a().m5303g(m5290a(), m5342i, jSONObject2, jSONObject6, jSONObject);
        }
    }

    /* renamed from: h */
    public final void m5285h(float f) {
        agw.m5309a().m5305e(m5290a(), f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final void m5284i(WebView webView) {
        this.f4060a = new ahx(webView);
    }

    /* renamed from: j */
    public void mo5280j() {
    }

    /* renamed from: k */
    public final boolean m5283k() {
        return this.f4060a.get() != null;
    }
}

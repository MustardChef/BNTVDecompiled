package com.applovin.impl.mediation.p014b;

import android.app.Activity;
import com.applovin.impl.mediation.p013a.C1339f;
import com.applovin.impl.mediation.p013a.C1341g;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.b */
/* loaded from: classes.dex */
public class C1369b extends AbstractRunnableC1589a {

    /* renamed from: a */
    private static String f917a;

    /* renamed from: c */
    private final MaxAdFormat f918c;

    /* renamed from: d */
    private final Activity f919d;

    /* renamed from: e */
    private final InterfaceC1373a f920e;

    /* renamed from: com.applovin.impl.mediation.b.b$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1373a {
        /* renamed from: a */
        void mo7585a(JSONArray jSONArray);
    }

    static {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(m7661a("APPLOVIN_NETWORK", "com.applovin.mediation.adapters.AppLovinMediationAdapter"));
            m7661a("FACEBOOK_NETWORK", "com.applovin.mediation.adapters.FacebookMediationAdapter").put("run_on_ui_thread", false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("signal_providers", jSONArray);
            f917a = jSONObject.toString();
        } catch (JSONException unused) {
        }
    }

    public C1369b(MaxAdFormat maxAdFormat, Activity activity, C1662k c1662k, InterfaceC1373a interfaceC1373a) {
        super("TaskCollectSignals", c1662k);
        this.f918c = maxAdFormat;
        this.f919d = activity;
        this.f920e = interfaceC1373a;
    }

    /* renamed from: a */
    private static JSONObject m7661a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("class", str2);
        jSONObject.put("adapter_timeout_ms", 30000);
        jSONObject.put("max_signal_length", 32768);
        jSONObject.put("scode", "");
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7664a(final C1341g c1341g, final C1339f.InterfaceC1340a interfaceC1340a) {
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.mediation.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                C1369b.this.f2058b.m6684C().collectSignal(C1369b.this.f918c, c1341g, C1369b.this.f919d, interfaceC1340a);
            }
        };
        if (c1341g.m7757Q()) {
            m6884a("Running signal collection for " + c1341g + " on the main thread");
            this.f919d.runOnUiThread(runnable);
            return;
        }
        m6884a("Running signal collection for " + c1341g + " on the background thread");
        runnable.run();
    }

    /* renamed from: a */
    private void m7660a(Collection<C1339f> collection) {
        String str;
        String m7726d;
        JSONArray jSONArray = new JSONArray();
        for (C1339f c1339f : collection) {
            try {
                JSONObject jSONObject = new JSONObject();
                C1341g m7732a = c1339f.m7732a();
                jSONObject.put("name", m7732a.m7763K());
                jSONObject.put("class", m7732a.m7764J());
                jSONObject.put("adapter_version", c1339f.m7727c());
                jSONObject.put("sdk_version", c1339f.m7729b());
                JSONObject jSONObject2 = new JSONObject();
                if (StringUtils.isValidString(c1339f.m7725e())) {
                    str = "error_message";
                    m7726d = c1339f.m7725e();
                } else {
                    str = "signal";
                    m7726d = c1339f.m7726d();
                }
                jSONObject2.put(str, m7726d);
                jSONObject.put("data", jSONObject2);
                jSONArray.put(jSONObject);
                m6884a("Collected signal from " + m7732a);
            } catch (JSONException e) {
                m6883a("Failed to create signal data", e);
            }
        }
        m7659a(jSONArray);
    }

    /* renamed from: a */
    private void m7659a(JSONArray jSONArray) {
        InterfaceC1373a interfaceC1373a = this.f920e;
        if (interfaceC1373a != null) {
            interfaceC1373a.mo7585a(jSONArray);
        }
    }

    /* renamed from: a */
    private void m7658a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException, InterruptedException {
        final List synchronizedList = CollectionUtils.synchronizedList(jSONArray.length());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final CountDownLatch countDownLatch = new CountDownLatch(jSONArray.length());
        ScheduledExecutorService m6783b = this.f2058b.m6670Q().m6783b();
        for (int i = 0; i < jSONArray.length(); i++) {
            final C1341g c1341g = new C1341g(jSONArray.getJSONObject(i), jSONObject, this.f2058b);
            m6783b.execute(new Runnable() { // from class: com.applovin.impl.mediation.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    C1369b.this.m7664a(c1341g, new C1339f.InterfaceC1340a() { // from class: com.applovin.impl.mediation.b.b.1.1
                        @Override // com.applovin.impl.mediation.p013a.C1339f.InterfaceC1340a
                        /* renamed from: a */
                        public void mo7654a(C1339f c1339f) {
                            if (atomicBoolean.get() && c1339f != null) {
                                synchronizedList.add(c1339f);
                            }
                            countDownLatch.countDown();
                        }
                    });
                }
            });
        }
        countDownLatch.await(((Long) this.f2058b.m6656a(C1567a.f1633k)).longValue(), TimeUnit.MILLISECONDS);
        atomicBoolean.set(false);
        m7660a(synchronizedList);
    }

    /* renamed from: b */
    private void m7656b(String str, Throwable th) {
        m6883a("No signals collected: " + str, th);
        m7659a(new JSONArray());
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject((String) this.f2058b.m6623b((C1570d<C1570d<String>>) C1570d.f1951w, (C1570d<String>) f917a));
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            if (jSONArray.length() == 0) {
                m7656b("No signal providers found", null);
            } else {
                m7658a(jSONArray, jSONObject);
            }
        } catch (InterruptedException e) {
            e = e;
            str = "Failed to wait for signals";
            m7656b(str, e);
        } catch (JSONException e2) {
            e = e2;
            str = "Failed to parse signals JSON";
            m7656b(str, e);
        } catch (Throwable th) {
            e = th;
            str = "Failed to collect signals";
            m7656b(str, e);
        }
    }
}

package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.mediation.p013a.C1338e;
import com.applovin.impl.mediation.p014b.C1367a;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.adapter.MaxAdapter;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.e */
/* loaded from: classes.dex */
public class C1468e {

    /* renamed from: a */
    private final C1662k f1286a;

    /* renamed from: b */
    private final C1710r f1287b;

    /* renamed from: c */
    private final AtomicBoolean f1288c = new AtomicBoolean();

    /* renamed from: d */
    private final JSONArray f1289d = new JSONArray();

    /* renamed from: e */
    private final LinkedHashSet<String> f1290e = new LinkedHashSet<>();

    /* renamed from: f */
    private final Object f1291f = new Object();

    /* renamed from: g */
    private boolean f1292g;

    public C1468e(C1662k c1662k) {
        this.f1286a = c1662k;
        this.f1287b = c1662k.m6588z();
    }

    /* renamed from: a */
    public void m7342a(Activity activity) {
        if (this.f1288c.compareAndSet(false, true)) {
            this.f1292g = activity == null;
            this.f1286a.m6670Q().m6794a(new C1367a(activity, this.f1286a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7340a(C1338e c1338e, long j, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z;
        if (initializationStatus == null || initializationStatus == MaxAdapter.InitializationStatus.INITIALIZING) {
            return;
        }
        synchronized (this.f1291f) {
            z = !m7341a(c1338e);
            if (z) {
                this.f1290e.add(c1338e.m7764J());
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putString(jSONObject, "class", c1338e.m7764J());
                JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                JsonUtils.putString(jSONObject, "error_message", JSONObject.quote(str));
                this.f1289d.put(jSONObject);
            }
        }
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "DID_INITIALIZE");
            bundle.putString("network_name", c1338e.m7763K());
            bundle.putInt("initialization_status", initializationStatus.getCode());
            if (StringUtils.isValidString(str)) {
                bundle.putString("error_message", str);
            }
            this.f1286a.m6634af().m6731a(bundle, "max_adapter_events");
            this.f1286a.m6657a(c1338e);
            this.f1286a.m6684C().processAdapterInitializationPostback(c1338e, j, initializationStatus, str);
            this.f1286a.m6634af().m6728a(initializationStatus, c1338e.m7764J());
        }
    }

    /* renamed from: a */
    public void m7339a(C1338e c1338e, Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("type", "WILL_INITIALIZE");
        bundle.putString("network_name", c1338e.m7763K());
        this.f1286a.m6634af().m6731a(bundle, "max_adapter_events");
        C1471g m7334a = this.f1286a.m6686A().m7334a(c1338e);
        if (m7334a != null) {
            C1710r c1710r = this.f1287b;
            c1710r.m6317c("MediationAdapterInitializationManager", "Initializing adapter " + c1338e);
            m7334a.m7319a(MaxAdapterParametersImpl.m7846a(c1338e), activity);
        }
    }

    /* renamed from: a */
    public boolean m7343a() {
        return this.f1288c.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m7341a(C1338e c1338e) {
        boolean contains;
        synchronized (this.f1291f) {
            contains = this.f1290e.contains(c1338e.m7764J());
        }
        return contains;
    }

    /* renamed from: b */
    public boolean m7338b() {
        return this.f1292g;
    }

    /* renamed from: c */
    public LinkedHashSet<String> m7337c() {
        LinkedHashSet<String> linkedHashSet;
        synchronized (this.f1291f) {
            linkedHashSet = this.f1290e;
        }
        return linkedHashSet;
    }

    /* renamed from: d */
    public JSONArray m7336d() {
        JSONArray jSONArray;
        synchronized (this.f1291f) {
            jSONArray = this.f1289d;
        }
        return jSONArray;
    }
}

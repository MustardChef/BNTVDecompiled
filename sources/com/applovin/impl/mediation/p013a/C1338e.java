package com.applovin.impl.mediation.p013a;

import android.os.Bundle;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.e */
/* loaded from: classes.dex */
public class C1338e {

    /* renamed from: a */
    private final JSONObject f832a;

    /* renamed from: b */
    protected final C1662k f833b;

    /* renamed from: c */
    private final JSONObject f834c;

    /* renamed from: d */
    private final Object f835d = new Object();

    /* renamed from: e */
    private final Object f836e = new Object();

    /* renamed from: f */
    private volatile String f837f;

    public C1338e(JSONObject jSONObject, JSONObject jSONObject2, C1662k c1662k) {
        if (c1662k == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        }
        this.f833b = c1662k;
        this.f832a = jSONObject2;
        this.f834c = jSONObject;
    }

    /* renamed from: a */
    private int m7753a() {
        return m7742b("mute_state", m7750a("mute_state", ((Integer) this.f833b.m6656a(C1567a.f1613L)).intValue()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H */
    public JSONObject m7766H() {
        JSONObject jSONObject;
        synchronized (this.f836e) {
            jSONObject = this.f832a;
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I */
    public JSONObject m7765I() {
        JSONObject jSONObject;
        synchronized (this.f835d) {
            jSONObject = this.f834c;
        }
        return jSONObject;
    }

    /* renamed from: J */
    public String m7764J() {
        return m7739b("class", (String) null);
    }

    /* renamed from: K */
    public String m7763K() {
        return m7739b("name", (String) null);
    }

    /* renamed from: L */
    public String m7762L() {
        return m7763K().split("_")[0];
    }

    /* renamed from: M */
    public boolean m7761M() {
        return m7740b("is_testing", (Boolean) false).booleanValue();
    }

    /* renamed from: N */
    public Boolean m7760N() {
        return m7752a("huc") ? m7740b("huc", (Boolean) false) : m7748a("huc", (Boolean) null);
    }

    /* renamed from: O */
    public Boolean m7759O() {
        return m7752a("aru") ? m7740b("aru", (Boolean) false) : m7748a("aru", (Boolean) null);
    }

    /* renamed from: P */
    public Boolean m7758P() {
        return m7752a("dns") ? m7740b("dns", (Boolean) false) : m7748a("dns", (Boolean) null);
    }

    /* renamed from: Q */
    public boolean m7757Q() {
        return m7740b("run_on_ui_thread", (Boolean) true).booleanValue();
    }

    /* renamed from: R */
    public Bundle m7756R() {
        Bundle bundle = m7743b("server_parameters") instanceof JSONObject ? JsonUtils.toBundle(m7744a("server_parameters", (JSONObject) null)) : new Bundle();
        int m7753a = m7753a();
        if (m7753a != -1) {
            bundle.putBoolean("is_muted", m7753a == 2 ? this.f833b.m6598p().isMuted() : m7753a == 0);
        }
        return bundle;
    }

    /* renamed from: S */
    public long m7755S() {
        return m7741b("adapter_timeout_ms", ((Long) this.f833b.m6656a(C1567a.f1634l)).longValue());
    }

    /* renamed from: T */
    public long m7754T() {
        return m7741b("init_completion_delay_ms", -1L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public float m7751a(String str, float f) {
        float f2;
        synchronized (this.f835d) {
            f2 = JsonUtils.getFloat(this.f834c, str, f);
        }
        return f2;
    }

    /* renamed from: a */
    protected int m7750a(String str, int i) {
        int i2;
        synchronized (this.f836e) {
            i2 = JsonUtils.getInt(this.f832a, str, i);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public long m7749a(String str, long j) {
        long j2;
        synchronized (this.f836e) {
            j2 = JsonUtils.getLong(this.f832a, str, j);
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean m7748a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f836e) {
            bool2 = JsonUtils.getBoolean(this.f832a, str, bool);
        }
        return bool2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Float m7747a(String str, Float f) {
        Float f2;
        synchronized (this.f835d) {
            f2 = JsonUtils.getFloat(this.f834c, str, f);
        }
        return f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public String m7746a(String str, String str2) {
        String string;
        synchronized (this.f836e) {
            string = JsonUtils.getString(this.f832a, str, str2);
        }
        return string;
    }

    /* renamed from: a */
    protected JSONArray m7745a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f836e) {
            jSONArray2 = JsonUtils.getJSONArray(this.f832a, str, jSONArray);
        }
        return jSONArray2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject m7744a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.f835d) {
            jSONObject2 = JsonUtils.getJSONObject(this.f834c, str, jSONObject);
        }
        return jSONObject2;
    }

    /* renamed from: a */
    protected boolean m7752a(String str) {
        boolean has;
        synchronized (this.f835d) {
            has = this.f834c.has(str);
        }
        return has;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public int m7742b(String str, int i) {
        int i2;
        synchronized (this.f835d) {
            i2 = JsonUtils.getInt(this.f834c, str, i);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public long m7741b(String str, long j) {
        long j2;
        synchronized (this.f835d) {
            j2 = JsonUtils.getLong(this.f834c, str, j);
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public Boolean m7740b(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f835d) {
            bool2 = JsonUtils.getBoolean(this.f834c, str, bool);
        }
        return bool2;
    }

    /* renamed from: b */
    protected Object m7743b(String str) {
        Object opt;
        synchronized (this.f835d) {
            opt = this.f834c.opt(str);
        }
        return opt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public String m7739b(String str, String str2) {
        String string;
        synchronized (this.f835d) {
            string = JsonUtils.getString(this.f834c, str, str2);
        }
        return string;
    }

    /* renamed from: b */
    protected JSONArray m7738b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f835d) {
            jSONArray2 = JsonUtils.getJSONArray(this.f834c, str, jSONArray);
        }
        return jSONArray2;
    }

    /* renamed from: c */
    public void m7737c(String str) {
        this.f837f = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m7736c(String str, long j) {
        synchronized (this.f835d) {
            JsonUtils.putLong(this.f834c, str, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m7735c(String str, String str2) {
        synchronized (this.f835d) {
            JsonUtils.putString(this.f834c, str, str2);
        }
    }

    /* renamed from: d */
    public List<String> m7734d(String str) {
        if (str != null) {
            List optList = JsonUtils.optList(m7745a(str, new JSONArray()), Collections.EMPTY_LIST);
            List optList2 = JsonUtils.optList(m7738b(str, new JSONArray()), Collections.EMPTY_LIST);
            ArrayList arrayList = new ArrayList(optList.size() + optList2.size());
            arrayList.addAll(optList);
            arrayList.addAll(optList2);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    /* renamed from: e */
    public String m7733e(String str) {
        String m7739b = m7739b(str, "");
        return StringUtils.isValidString(m7739b) ? m7739b : m7746a(str, "");
    }

    public String getPlacement() {
        return this.f837f;
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + m7764J() + "', adapterName='" + m7763K() + "', isTesting=" + m7761M() + '}';
    }
}

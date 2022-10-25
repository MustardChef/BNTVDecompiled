package com.applovin.impl.sdk.p029c;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.c.c */
/* loaded from: classes.dex */
public class C1569c {

    /* renamed from: a */
    protected final C1662k f1920a;

    /* renamed from: b */
    protected final C1710r f1921b;

    /* renamed from: c */
    protected final Context f1922c;

    /* renamed from: d */
    protected final SharedPreferences f1923d;

    /* renamed from: e */
    private final Map<String, Object> f1924e = new HashMap();

    /* renamed from: f */
    private final Object f1925f = new Object();

    /* renamed from: g */
    private Map<String, Object> f1926g;

    public C1569c(C1662k c1662k) {
        this.f1920a = c1662k;
        this.f1921b = c1662k.m6588z();
        Context m6677J = c1662k.m6677J();
        this.f1922c = m6677J;
        this.f1923d = m6677J.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Class.forName(C1568b.class.getName());
            Class.forName(C1567a.class.getName());
        } catch (Throwable unused) {
        }
        try {
            Field field = Utils.getField(c1662k.m6598p().getClass(), "localSettings");
            field.setAccessible(true);
            this.f1926g = (HashMap) field.get(c1662k.m6598p());
        } catch (Throwable unused2) {
        }
        m6998b();
    }

    /* renamed from: a */
    private static Object m7000a(String str, JSONObject jSONObject, Object obj) throws JSONException {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    /* renamed from: e */
    private String m6993e() {
        return "com.applovin.sdk." + Utils.shortenKey(this.f1920a.m6590x()) + ".";
    }

    /* renamed from: a */
    public <T> C1568b<T> m7001a(String str, C1568b<T> c1568b) {
        synchronized (this.f1925f) {
            Iterator<C1568b<?>> it = C1568b.m7005c().iterator();
            while (it.hasNext()) {
                C1568b<T> c1568b2 = (C1568b<T>) it.next();
                if (c1568b2.m7009a().equals(str)) {
                    return c1568b2;
                }
            }
            return c1568b;
        }
    }

    /* renamed from: a */
    public <T> T m7003a(C1568b<T> c1568b) {
        if (c1568b != null) {
            synchronized (this.f1925f) {
                Object obj = this.f1924e.get(c1568b.m7009a());
                if (obj == null) {
                    return c1568b.m7006b();
                }
                return c1568b.m7008a(obj);
            }
        }
        throw new IllegalArgumentException("No setting type specified");
    }

    /* renamed from: a */
    public void m7004a() {
        String m6993e = m6993e();
        synchronized (this.f1925f) {
            SharedPreferences.Editor edit = this.f1923d.edit();
            for (C1568b<?> c1568b : C1568b.m7005c()) {
                Object obj = this.f1924e.get(c1568b.m7009a());
                if (obj != null) {
                    this.f1920a.m6643a(m6993e + c1568b.m7009a(), (String) obj, edit);
                }
            }
            edit.apply();
        }
    }

    /* renamed from: a */
    public <T> void m7002a(C1568b<?> c1568b, Object obj) {
        if (c1568b == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        if (obj == null) {
            throw new IllegalArgumentException("No new value specified");
        }
        synchronized (this.f1925f) {
            this.f1924e.put(c1568b.m7009a(), obj);
        }
    }

    /* renamed from: a */
    public void m6999a(JSONObject jSONObject) {
        synchronized (this.f1925f) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        C1568b<Long> m7001a = m7001a(next, (C1568b) null);
                        if (m7001a != null) {
                            this.f1924e.put(m7001a.m7009a(), m7000a(next, jSONObject, m7001a.m7006b()));
                            if (m7001a == C1568b.f1905ep) {
                                this.f1924e.put(C1568b.f1906eq.m7009a(), Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                    } catch (JSONException e) {
                        this.f1921b.m6318b("SettingsManager", "Unable to parse JSON settingsValues array", e);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public List<String> m6997b(C1568b<String> c1568b) {
        return CollectionUtils.explode((String) m7003a(c1568b));
    }

    /* renamed from: b */
    public void m6998b() {
        String m6993e = m6993e();
        synchronized (this.f1925f) {
            for (C1568b<?> c1568b : C1568b.m7005c()) {
                try {
                    Object m6642a = this.f1920a.m6642a(m6993e + c1568b.m7009a(), null, c1568b.m7006b().getClass(), this.f1923d);
                    if (m6642a != null) {
                        this.f1924e.put(c1568b.m7009a(), m6642a);
                    }
                } catch (Exception e) {
                    C1710r c1710r = this.f1921b;
                    c1710r.m6318b("SettingsManager", "Unable to load \"" + c1568b.m7009a() + "\"", e);
                }
            }
        }
    }

    /* renamed from: c */
    public List<MaxAdFormat> m6995c(C1568b<String> c1568b) {
        ArrayList arrayList = new ArrayList(6);
        for (String str : m6997b(c1568b)) {
            arrayList.add(MaxAdFormat.formatFromString(str));
        }
        return arrayList;
    }

    /* renamed from: c */
    public void m6996c() {
        synchronized (this.f1925f) {
            this.f1924e.clear();
        }
        this.f1920a.m6658a(this.f1923d);
    }

    /* renamed from: d */
    public boolean m6994d() {
        return this.f1920a.m6598p().isVerboseLoggingEnabled() || ((Boolean) m7003a(C1568b.f1681aa)).booleanValue();
    }
}

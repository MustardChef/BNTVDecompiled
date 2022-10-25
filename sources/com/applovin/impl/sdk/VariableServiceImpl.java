package com.applovin.impl.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.p029c.C1570d;
import com.applovin.impl.sdk.p031e.C1612l;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinVariableService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VariableServiceImpl implements AppLovinVariableService {

    /* renamed from: a */
    private final C1662k f1456a;

    /* renamed from: d */
    private AppLovinVariableService.OnVariablesUpdateListener f1459d;

    /* renamed from: e */
    private Bundle f1460e;

    /* renamed from: b */
    private final AtomicBoolean f1457b = new AtomicBoolean();

    /* renamed from: c */
    private final AtomicBoolean f1458c = new AtomicBoolean();

    /* renamed from: f */
    private final Object f1461f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public VariableServiceImpl(C1662k c1662k) {
        this.f1456a = c1662k;
        String str = (String) c1662k.m6654a(C1570d.f1938j);
        if (StringUtils.isValidString(str)) {
            updateVariables(JsonUtils.deserialize(str));
        }
    }

    /* renamed from: a */
    private Object m7242a(String str, Object obj, Class<?> cls) {
        if (TextUtils.isEmpty(str)) {
            C1710r.m6310i("AppLovinVariableService", "Unable to retrieve variable value for empty name");
            return obj;
        }
        if (!this.f1456a.m6613d()) {
            C1710r.m6311h("AppLovinSdk", "Attempted to retrieve variable before SDK initialization. Please wait until after the SDK has initialized, e.g. AppLovinSdk.initializeSdk(Context, SdkInitializationListener).");
        }
        synchronized (this.f1461f) {
            if (this.f1460e == null) {
                C1710r.m6310i("AppLovinVariableService", "Unable to retrieve variable value for name \"" + str + "\". No variables returned by the server.");
                return obj;
            } else if (cls.equals(String.class)) {
                return this.f1460e.getString(str, (String) obj);
            } else if (cls.equals(Boolean.class)) {
                return Boolean.valueOf(this.f1460e.getBoolean(str, ((Boolean) obj).booleanValue()));
            } else {
                throw new IllegalStateException("Unable to retrieve variable value for " + str);
            }
        }
    }

    /* renamed from: a */
    private void m7244a() {
        Bundle bundle;
        synchronized (this.f1461f) {
            if (this.f1459d != null && (bundle = this.f1460e) != null) {
                final Bundle bundle2 = (Bundle) bundle.clone();
                AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.VariableServiceImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        VariableServiceImpl.this.f1459d.onVariablesUpdate(bundle2);
                    }
                });
            }
        }
    }

    @Override // com.applovin.sdk.AppLovinVariableService
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.applovin.sdk.AppLovinVariableService
    public boolean getBoolean(String str, boolean z) {
        return ((Boolean) m7242a(str, Boolean.valueOf(z), Boolean.class)).booleanValue();
    }

    @Override // com.applovin.sdk.AppLovinVariableService
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.applovin.sdk.AppLovinVariableService
    public String getString(String str, String str2) {
        return (String) m7242a(str, str2, String.class);
    }

    @Override // com.applovin.sdk.AppLovinVariableService
    @Deprecated
    public void loadVariables() {
        String str;
        if (!this.f1456a.m6613d()) {
            str = "The AppLovin SDK is waiting for the initial variables to be returned upon completing initialization.";
        } else if (this.f1457b.compareAndSet(false, true)) {
            this.f1456a.m6670Q().m6793a(new C1612l(this.f1456a, new C1612l.InterfaceC1614a() { // from class: com.applovin.impl.sdk.VariableServiceImpl.1
                @Override // com.applovin.impl.sdk.p031e.C1612l.InterfaceC1614a
                /* renamed from: a */
                public void mo6803a() {
                    VariableServiceImpl.this.f1457b.set(false);
                }
            }), C1620o.EnumC1622a.BACKGROUND);
            return;
        } else {
            str = "Ignored explicit variables load. Service is already in the process of retrieving the latest set of variables.";
        }
        C1710r.m6310i("AppLovinVariableService", str);
    }

    @Override // com.applovin.sdk.AppLovinVariableService
    @Deprecated
    public void setOnVariablesUpdateListener(AppLovinVariableService.OnVariablesUpdateListener onVariablesUpdateListener) {
        this.f1459d = onVariablesUpdateListener;
        synchronized (this.f1461f) {
            if (onVariablesUpdateListener != null) {
                if (this.f1460e != null && this.f1458c.compareAndSet(false, true)) {
                    this.f1456a.m6588z().m6319b("AppLovinVariableService", "Setting initial listener");
                    m7244a();
                }
            }
        }
    }

    public String toString() {
        return "VariableService{variables=" + this.f1460e + ", listener=" + this.f1459d + '}';
    }

    public void updateVariables(JSONObject jSONObject) {
        C1710r m6588z = this.f1456a.m6588z();
        m6588z.m6319b("AppLovinVariableService", "Updating variables: " + jSONObject + "...");
        synchronized (this.f1461f) {
            this.f1460e = JsonUtils.toBundle(jSONObject);
            m7244a();
            this.f1456a.m6653a((C1570d<C1570d<String>>) C1570d.f1938j, (C1570d<String>) jSONObject.toString());
        }
    }
}

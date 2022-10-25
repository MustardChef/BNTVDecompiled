package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.network.C1684b;
import com.applovin.impl.sdk.p028b.C1565c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.aa */
/* loaded from: classes.dex */
public abstract class AbstractC1590aa extends AbstractC1640x {
    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1590aa(String str, C1662k c1662k) {
        super(str, c1662k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6874b(JSONObject jSONObject) {
        C1565c m6873c = m6873c(jSONObject);
        if (m6873c == null) {
            return;
        }
        mo6742a(m6873c);
        m6884a("Pending reward handled: " + m6873c);
    }

    /* renamed from: c */
    private C1565c m6873c(JSONObject jSONObject) {
        String str;
        try {
            JSONObject m6262a = C1725g.m6262a(jSONObject);
            C1725g.m6257d(m6262a, this.f2058b);
            C1725g.m6258c(jSONObject, this.f2058b);
            C1725g.m6255e(jSONObject, this.f2058b);
            Map<String, String> stringMap = JsonUtils.toStringMap((JSONObject) m6262a.get(NativeProtocol.WEB_DIALOG_PARAMS));
            try {
                str = m6262a.getString("result");
            } catch (Throwable unused) {
                str = "network_timeout";
            }
            return C1565c.m7019a(str, stringMap);
        } catch (JSONException e) {
            m6883a("Unable to parse API response", e);
            return null;
        }
    }

    /* renamed from: a */
    protected abstract void mo6742a(C1565c c1565c);

    /* renamed from: b */
    protected abstract boolean mo6740b();

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: h */
    protected int mo6748h() {
        return ((Integer) this.f2058b.m6656a(C1568b.f1747bn)).intValue();
    }

    @Override // java.lang.Runnable
    public void run() {
        m6749a(m6747i(), new C1684b.InterfaceC1687c<JSONObject>() { // from class: com.applovin.impl.sdk.e.aa.1
            @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject) {
                if (AbstractC1590aa.this.mo6740b()) {
                    AbstractC1590aa abstractC1590aa = AbstractC1590aa.this;
                    abstractC1590aa.m6879d("Reward validation failed with error code " + i + " but task was cancelled already");
                    return;
                }
                AbstractC1590aa abstractC1590aa2 = AbstractC1590aa.this;
                abstractC1590aa2.m6879d("Reward validation failed with code " + i + " and error: " + str);
                AbstractC1590aa.this.mo6743a(i);
            }

            @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject, int i) {
                if (!AbstractC1590aa.this.mo6740b()) {
                    AbstractC1590aa abstractC1590aa = AbstractC1590aa.this;
                    abstractC1590aa.m6884a("Reward validation succeeded with code " + i + " and response: " + jSONObject);
                    AbstractC1590aa.this.m6874b(jSONObject);
                    return;
                }
                AbstractC1590aa abstractC1590aa2 = AbstractC1590aa.this;
                abstractC1590aa2.m6879d("Reward validation succeeded with code " + i + " but task was cancelled already");
                AbstractC1590aa abstractC1590aa3 = AbstractC1590aa.this;
                abstractC1590aa3.m6879d("Response: " + jSONObject);
            }
        });
    }
}

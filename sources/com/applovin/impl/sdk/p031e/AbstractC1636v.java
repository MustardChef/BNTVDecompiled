package com.applovin.impl.sdk.p031e;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.network.C1684b;
import com.applovin.impl.sdk.p028b.C1565c;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.v */
/* loaded from: classes.dex */
public abstract class AbstractC1636v extends AbstractC1640x {
    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC1636v(String str, C1662k c1662k) {
        super(str, c1662k);
    }

    /* renamed from: a */
    private JSONObject m6761a(C1565c c1565c) {
        JSONObject i = m6747i();
        JsonUtils.putString(i, "result", c1565c.m7018b());
        Map<String, String> m7021a = c1565c.m7021a();
        if (m7021a != null) {
            JsonUtils.putJSONObject(i, NativeProtocol.WEB_DIALOG_PARAMS, new JSONObject(m7021a));
        }
        return i;
    }

    /* renamed from: b */
    protected abstract C1565c mo6760b();

    /* renamed from: b */
    protected abstract void mo6759b(JSONObject jSONObject);

    /* renamed from: c */
    protected abstract void mo6758c();

    @Override // com.applovin.impl.sdk.p031e.AbstractC1640x
    /* renamed from: h */
    protected int mo6748h() {
        return ((Integer) this.f2058b.m6656a(C1568b.f1748bo)).intValue();
    }

    @Override // java.lang.Runnable
    public void run() {
        C1565c mo6760b = mo6760b();
        if (mo6760b == null) {
            m6879d("Pending reward not found");
            mo6758c();
            return;
        }
        m6884a("Reporting pending reward: " + mo6760b + "...");
        m6749a(m6761a(mo6760b), new C1684b.InterfaceC1687c<JSONObject>() { // from class: com.applovin.impl.sdk.e.v.1
            @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, JSONObject jSONObject) {
                AbstractC1636v.this.mo6743a(i);
            }

            @Override // com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(JSONObject jSONObject, int i) {
                AbstractC1636v.this.mo6759b(jSONObject);
            }
        });
    }
}

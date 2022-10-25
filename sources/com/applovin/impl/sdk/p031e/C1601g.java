package com.applovin.impl.sdk.p031e;

import android.text.TextUtils;
import com.applovin.impl.adview.C1238d;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.network.C1700h;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.utils.C1725g;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPostbackListener;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.g */
/* loaded from: classes.dex */
public class C1601g extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final C1700h f2079a;

    /* renamed from: c */
    private final AppLovinPostbackListener f2080c;

    /* renamed from: d */
    private final C1620o.EnumC1622a f2081d;

    public C1601g(C1700h c1700h, C1620o.EnumC1622a enumC1622a, C1662k c1662k, AppLovinPostbackListener appLovinPostbackListener) {
        super("TaskDispatchPostback", c1662k);
        if (c1700h == null) {
            throw new IllegalArgumentException("No request specified");
        }
        this.f2079a = c1700h;
        this.f2080c = appLovinPostbackListener;
        this.f2081d = enumC1622a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6835a() {
        AbstractC1633t<Object> abstractC1633t = new AbstractC1633t<Object>(this.f2079a, m6880d()) { // from class: com.applovin.impl.sdk.e.g.2

            /* renamed from: a */
            final String f2083a;

            {
                this.f2083a = C1601g.this.f2079a.m6489a();
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6491a(int i, String str, Object obj) {
                m6879d("Failed to dispatch postback. Error code: " + i + " URL: " + this.f2083a);
                if (C1601g.this.f2080c != null) {
                    C1601g.this.f2080c.onPostbackFailure(this.f2083a, i);
                }
                if (C1601g.this.f2079a.m6398q()) {
                    this.f2058b.m6634af().m6726a(C1601g.this.f2079a.m6397r(), this.f2083a, i, obj, str, false);
                }
            }

            @Override // com.applovin.impl.sdk.p031e.AbstractC1633t, com.applovin.impl.sdk.network.C1684b.InterfaceC1687c
            /* renamed from: a */
            public void mo6490a(Object obj, int i) {
                if (obj instanceof String) {
                    for (String str : this.f2058b.m6625b(C1568b.f1666aL)) {
                        if (str.startsWith(str)) {
                            String str2 = (String) obj;
                            if (TextUtils.isEmpty(str2)) {
                                continue;
                            } else {
                                try {
                                    JSONObject jSONObject = new JSONObject(str2);
                                    C1725g.m6257d(jSONObject, this.f2058b);
                                    C1725g.m6258c(jSONObject, this.f2058b);
                                    C1725g.m6255e(jSONObject, this.f2058b);
                                    break;
                                } catch (JSONException unused) {
                                }
                            }
                        }
                    }
                }
                if (C1601g.this.f2080c != null) {
                    C1601g.this.f2080c.onPostbackSuccess(this.f2083a);
                }
                if (C1601g.this.f2079a.m6398q()) {
                    this.f2058b.m6634af().m6726a(C1601g.this.f2079a.m6397r(), this.f2083a, i, obj, null, true);
                }
            }
        };
        abstractC1633t.m6769a(this.f2081d);
        m6880d().m6670Q().m6794a(abstractC1633t);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (StringUtils.isValidString(this.f2079a.m6489a())) {
            if (this.f2079a.m6396s()) {
                C1238d.m8087a(this.f2079a, m6880d(), new AppLovinPostbackListener() { // from class: com.applovin.impl.sdk.e.g.1
                    @Override // com.applovin.sdk.AppLovinPostbackListener
                    public void onPostbackFailure(String str, int i) {
                        C1601g.this.m6835a();
                    }

                    @Override // com.applovin.sdk.AppLovinPostbackListener
                    public void onPostbackSuccess(String str) {
                        if (C1601g.this.f2080c != null) {
                            C1601g.this.f2080c.onPostbackSuccess(C1601g.this.f2079a.m6489a());
                        }
                    }
                });
                return;
            } else {
                m6835a();
                return;
            }
        }
        m6882b("Requested URL is not valid; nothing to do...");
        AppLovinPostbackListener appLovinPostbackListener = this.f2080c;
        if (appLovinPostbackListener != null) {
            appLovinPostbackListener.onPostbackFailure(this.f2079a.m6489a(), AppLovinErrorCodes.INVALID_URL);
        }
    }
}

package com.applovin.impl.sdk.p031e;

import com.applovin.impl.p010a.C1135c;
import com.applovin.impl.p010a.C1142i;
import com.applovin.impl.p010a.EnumC1136d;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.EnumC1528b;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.C1767q;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.applovin.impl.sdk.e.q */
/* loaded from: classes.dex */
public abstract class AbstractC1627q extends AbstractRunnableC1589a {

    /* renamed from: a */
    private final AppLovinAdLoadListener f2167a;

    /* renamed from: c */
    private final C1628a f2168c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.e.q$a */
    /* loaded from: classes.dex */
    public static final class C1628a extends C1135c {
        C1628a(JSONObject jSONObject, JSONObject jSONObject2, EnumC1528b enumC1528b, C1662k c1662k) {
            super(jSONObject, jSONObject2, enumC1528b, c1662k);
        }

        /* renamed from: a */
        void m6771a(C1766p c1766p) {
            if (c1766p == null) {
                throw new IllegalArgumentException("No aggregated vast response specified");
            }
            this.f217a.add(c1766p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.e.q$b */
    /* loaded from: classes.dex */
    public static final class C1629b extends AbstractC1627q {

        /* renamed from: a */
        private final JSONObject f2169a;

        C1629b(C1135c c1135c, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
            super(c1135c, appLovinAdLoadListener, c1662k);
            if (appLovinAdLoadListener == null) {
                throw new IllegalArgumentException("No callback specified.");
            }
            this.f2169a = c1135c.m8378c();
        }

        @Override // java.lang.Runnable
        public void run() {
            EnumC1136d enumC1136d;
            m6884a("Processing SDK JSON response...");
            String string = JsonUtils.getString(this.f2169a, "xml", null);
            if (StringUtils.isValidString(string)) {
                if (string.length() < ((Integer) this.f2058b.m6656a(C1568b.f1894ee)).intValue()) {
                    try {
                        m6774a(C1767q.m6142a(string, this.f2058b));
                        return;
                    } catch (Throwable th) {
                        m6883a("Unable to parse VAST response", th);
                    }
                } else {
                    m6879d("VAST response is over max length");
                }
                enumC1136d = EnumC1136d.XML_PARSING;
            } else {
                m6879d("No VAST response received.");
                enumC1136d = EnumC1136d.NO_WRAPPER_RESPONSE;
            }
            m6775a(enumC1136d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.applovin.impl.sdk.e.q$c */
    /* loaded from: classes.dex */
    public static final class C1630c extends AbstractC1627q {

        /* renamed from: a */
        private final C1766p f2170a;

        C1630c(C1766p c1766p, C1135c c1135c, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
            super(c1135c, appLovinAdLoadListener, c1662k);
            if (c1766p == null) {
                throw new IllegalArgumentException("No response specified.");
            }
            if (c1135c == null) {
                throw new IllegalArgumentException("No context specified.");
            }
            if (appLovinAdLoadListener == null) {
                throw new IllegalArgumentException("No callback specified.");
            }
            this.f2170a = c1766p;
        }

        @Override // java.lang.Runnable
        public void run() {
            m6884a("Processing VAST Wrapper response...");
            m6774a(this.f2170a);
        }
    }

    AbstractC1627q(C1135c c1135c, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        super("TaskProcessVastResponse", c1662k);
        if (c1135c == null) {
            throw new IllegalArgumentException("No context specified.");
        }
        this.f2167a = appLovinAdLoadListener;
        this.f2168c = (C1628a) c1135c;
    }

    /* renamed from: a */
    public static AbstractC1627q m6773a(C1766p c1766p, C1135c c1135c, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        return new C1630c(c1766p, c1135c, appLovinAdLoadListener, c1662k);
    }

    /* renamed from: a */
    public static AbstractC1627q m6772a(JSONObject jSONObject, JSONObject jSONObject2, EnumC1528b enumC1528b, AppLovinAdLoadListener appLovinAdLoadListener, C1662k c1662k) {
        return new C1629b(new C1628a(jSONObject, jSONObject2, enumC1528b, c1662k), appLovinAdLoadListener, c1662k);
    }

    /* renamed from: a */
    void m6775a(EnumC1136d enumC1136d) {
        m6879d("Failed to process VAST response due to VAST error code " + enumC1136d);
        C1142i.m8352a(this.f2168c, this.f2167a, enumC1136d, -6, this.f2058b);
    }

    /* renamed from: a */
    void m6774a(C1766p c1766p) {
        EnumC1136d enumC1136d;
        AbstractRunnableC1589a c1632s;
        int a = this.f2168c.m8380a();
        m6884a("Finished parsing XML at depth " + a);
        this.f2168c.m6771a(c1766p);
        if (!C1142i.m8351a(c1766p)) {
            if (C1142i.m8340b(c1766p)) {
                m6884a("VAST response is inline. Rendering ad...");
                c1632s = new C1632s(this.f2168c, this.f2167a, this.f2058b);
                this.f2058b.m6670Q().m6794a(c1632s);
                return;
            }
            m6879d("VAST response is an error");
            enumC1136d = EnumC1136d.NO_WRAPPER_RESPONSE;
            m6775a(enumC1136d);
        }
        int intValue = ((Integer) this.f2058b.m6656a(C1568b.f1895ef)).intValue();
        if (a < intValue) {
            m6884a("VAST response is wrapper. Resolving...");
            c1632s = new C1638w(this.f2168c, this.f2167a, this.f2058b);
            this.f2058b.m6670Q().m6794a(c1632s);
            return;
        }
        m6879d("Reached beyond max wrapper depth of " + intValue);
        enumC1136d = EnumC1136d.WRAPPER_LIMIT_REACHED;
        m6775a(enumC1136d);
    }
}

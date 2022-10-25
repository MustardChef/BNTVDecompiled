package com.applovin.impl.mediation.p013a;

import android.os.SystemClock;
import com.applovin.impl.mediation.C1471g;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p028b.C1565c;
import com.applovin.impl.sdk.p029c.C1567a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.c */
/* loaded from: classes.dex */
public class C1336c extends AbstractC1334a {

    /* renamed from: c */
    private final AtomicReference<C1565c> f829c;

    /* renamed from: d */
    private final AtomicBoolean f830d;

    /* renamed from: e */
    private final AtomicBoolean f831e;

    private C1336c(C1336c c1336c, C1471g c1471g) {
        super(c1336c.m7765I(), c1336c.m7766H(), c1471g, c1336c.f833b);
        this.f831e = new AtomicBoolean();
        this.f829c = c1336c.f829c;
        this.f830d = c1336c.f830d;
    }

    public C1336c(JSONObject jSONObject, JSONObject jSONObject2, C1662k c1662k) {
        super(jSONObject, jSONObject2, null, c1662k);
        this.f831e = new AtomicBoolean();
        this.f829c = new AtomicReference<>();
        this.f830d = new AtomicBoolean();
    }

    /* renamed from: A */
    public void m7785A() {
        this.f830d.set(true);
    }

    /* renamed from: B */
    public C1565c m7784B() {
        return this.f829c.getAndSet(null);
    }

    /* renamed from: C */
    public boolean m7783C() {
        return m7740b("show_nia", m7748a("show_nia", (Boolean) false)).booleanValue();
    }

    /* renamed from: D */
    public String m7782D() {
        return m7739b("nia_title", m7746a("nia_title", ""));
    }

    /* renamed from: E */
    public String m7781E() {
        return m7739b("nia_message", m7746a("nia_message", ""));
    }

    /* renamed from: F */
    public String m7780F() {
        return m7739b("nia_button_title", m7746a("nia_button_title", ""));
    }

    /* renamed from: G */
    public AtomicBoolean m7779G() {
        return this.f831e;
    }

    @Override // com.applovin.impl.mediation.p013a.AbstractC1334a
    /* renamed from: a */
    public AbstractC1334a mo7767a(C1471g c1471g) {
        return new C1336c(this, c1471g);
    }

    /* renamed from: a */
    public void m7778a(C1565c c1565c) {
        this.f829c.set(c1565c);
    }

    /* renamed from: q */
    public long m7777q() {
        long b = m7741b("ad_expiration_ms", -1L);
        return b >= 0 ? b : m7749a("ad_expiration_ms", ((Long) this.f833b.m6656a(C1567a.f1606E)).longValue());
    }

    /* renamed from: r */
    public long m7776r() {
        long b = m7741b("ad_hidden_timeout_ms", -1L);
        return b >= 0 ? b : m7749a("ad_hidden_timeout_ms", ((Long) this.f833b.m6656a(C1567a.f1609H)).longValue());
    }

    /* renamed from: s */
    public boolean m7775s() {
        if (m7740b("schedule_ad_hidden_on_ad_dismiss", (Boolean) false).booleanValue()) {
            return true;
        }
        return m7748a("schedule_ad_hidden_on_ad_dismiss", (Boolean) this.f833b.m6656a(C1567a.f1610I)).booleanValue();
    }

    /* renamed from: t */
    public long m7774t() {
        long b = m7741b("ad_hidden_on_ad_dismiss_callback_delay_ms", -1L);
        return b >= 0 ? b : m7749a("ad_hidden_on_ad_dismiss_callback_delay_ms", ((Long) this.f833b.m6656a(C1567a.f1611J)).longValue());
    }

    /* renamed from: u */
    public long m7773u() {
        if (m7805m() > 0) {
            return SystemClock.elapsedRealtime() - m7805m();
        }
        return -1L;
    }

    /* renamed from: v */
    public long m7772v() {
        long b = m7741b("fullscreen_display_delay_ms", -1L);
        return b >= 0 ? b : ((Long) this.f833b.m6656a(C1567a.f1645w)).longValue();
    }

    /* renamed from: w */
    public long m7771w() {
        return m7741b("ahdm", ((Long) this.f833b.m6656a(C1567a.f1646x)).longValue());
    }

    /* renamed from: x */
    public String m7770x() {
        return m7739b("bcode", "");
    }

    /* renamed from: y */
    public String m7769y() {
        return m7746a("mcode", "");
    }

    /* renamed from: z */
    public boolean m7768z() {
        return this.f830d.get();
    }
}

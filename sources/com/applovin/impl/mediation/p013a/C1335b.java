package com.applovin.impl.mediation.p013a;

import android.view.View;
import com.applovin.impl.mediation.C1471g;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p029c.C1567a;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.b */
/* loaded from: classes.dex */
public class C1335b extends AbstractC1334a {
    private C1335b(C1335b c1335b, C1471g c1471g) {
        super(c1335b.m7765I(), c1335b.m7766H(), c1471g, c1335b.f833b);
    }

    public C1335b(JSONObject jSONObject, JSONObject jSONObject2, C1662k c1662k) {
        super(jSONObject, jSONObject2, null, c1662k);
    }

    /* renamed from: A */
    public boolean m7800A() {
        return m7740b("dadf", (Boolean) false).booleanValue();
    }

    /* renamed from: B */
    public boolean m7799B() {
        return m7798C() >= 0;
    }

    /* renamed from: C */
    public long m7798C() {
        long b = m7741b("ad_refresh_ms", -1L);
        return b >= 0 ? b : m7749a("ad_refresh_ms", ((Long) this.f833b.m6656a(C1567a.f1635m)).longValue());
    }

    /* renamed from: D */
    public boolean m7797D() {
        return m7740b("proe", (Boolean) this.f833b.m6656a(C1567a.f1612K)).booleanValue();
    }

    /* renamed from: E */
    public long m7796E() {
        return Utils.parseColor(m7739b("bg_color", (String) null));
    }

    @Override // com.applovin.impl.mediation.p013a.AbstractC1334a
    /* renamed from: a */
    public AbstractC1334a mo7767a(C1471g c1471g) {
        return new C1335b(this, c1471g);
    }

    /* renamed from: q */
    public int m7795q() {
        int b = m7742b("ad_view_width", -2);
        if (b == -2) {
            MaxAdFormat format = getFormat();
            if (format.isAdViewAd()) {
                return format.getSize().getWidth();
            }
            throw new IllegalStateException("Invalid ad format");
        }
        return b;
    }

    /* renamed from: r */
    public int m7794r() {
        int b = m7742b("ad_view_height", -2);
        if (b == -2) {
            MaxAdFormat format = getFormat();
            if (format.isAdViewAd()) {
                return format.getSize().getHeight();
            }
            throw new IllegalStateException("Invalid ad format");
        }
        return b;
    }

    /* renamed from: s */
    public View m7793s() {
        if (!m7814d() || this.f827a == null) {
            return null;
        }
        View m7327a = this.f827a.m7327a();
        if (m7327a != null) {
            return m7327a;
        }
        throw new IllegalStateException("Ad-view based ad is missing an ad view");
    }

    /* renamed from: t */
    public long m7792t() {
        return m7741b("viewability_imp_delay_ms", ((Long) this.f833b.m6656a(C1568b.f1711bD)).longValue());
    }

    /* renamed from: u */
    public int m7791u() {
        MaxAdFormat format = getFormat();
        C1568b<Integer> c1568b = format == MaxAdFormat.BANNER ? C1568b.f1712bE : format == MaxAdFormat.MREC ? C1568b.f1714bG : format == MaxAdFormat.LEADER ? C1568b.f1716bI : null;
        if (c1568b != null) {
            return m7742b("viewability_min_width", ((Integer) this.f833b.m6656a(c1568b)).intValue());
        }
        return 0;
    }

    /* renamed from: v */
    public int m7790v() {
        MaxAdFormat format = getFormat();
        C1568b<Integer> c1568b = format == MaxAdFormat.BANNER ? C1568b.f1713bF : format == MaxAdFormat.MREC ? C1568b.f1715bH : format == MaxAdFormat.LEADER ? C1568b.f1717bJ : null;
        if (c1568b != null) {
            return m7742b("viewability_min_height", ((Integer) this.f833b.m6656a(c1568b)).intValue());
        }
        return 0;
    }

    /* renamed from: w */
    public float m7789w() {
        return m7751a("viewability_min_alpha", ((Float) this.f833b.m6656a(C1567a.f1718bK)).floatValue() / 100.0f);
    }

    /* renamed from: x */
    public int m7788x() {
        return m7742b("viewability_min_pixels", -1);
    }

    /* renamed from: y */
    public boolean m7787y() {
        return m7788x() >= 0;
    }

    /* renamed from: z */
    public long m7786z() {
        return m7741b("viewability_timer_min_visible_ms", ((Long) this.f833b.m6656a(C1567a.f1719bL)).longValue());
    }
}

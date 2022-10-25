package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.mediation.p013a.AbstractC1334a;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1527a;
import com.google.android.exoplayer2.database.DatabaseProvider;

/* renamed from: com.applovin.impl.sdk.utils.j */
/* loaded from: classes.dex */
public class C1757j {

    /* renamed from: a */
    private final StringBuilder f2562a = new StringBuilder();

    /* renamed from: a */
    public C1757j m6200a() {
        this.f2562a.append("\n========================================");
        return this;
    }

    /* renamed from: a */
    public C1757j m6199a(AppLovinAdView appLovinAdView) {
        return m6194a("Size", appLovinAdView.getSize().getWidth() + "x" + appLovinAdView.getSize().getHeight()).m6194a("Alpha", Float.valueOf(appLovinAdView.getAlpha())).m6194a("Visibility", C1763o.m6156b(appLovinAdView.getVisibility()));
    }

    /* renamed from: a */
    public C1757j m6198a(AbstractC1334a abstractC1334a) {
        return m6194a("Network", abstractC1334a.m7762L()).m6194a("Format", abstractC1334a.getFormat().getLabel()).m6194a("Ad Unit ID", abstractC1334a.getAdUnitId()).m6194a("Placement", abstractC1334a.getPlacement()).m6194a("Network Placement", abstractC1334a.m7808j()).m6194a("Serve ID", abstractC1334a.m7813e()).m6194a("Creative ID", StringUtils.isValidString(abstractC1334a.getCreativeId()) ? abstractC1334a.getCreativeId() : "None").m6194a("Server Parameters", abstractC1334a.m7756R());
    }

    /* renamed from: a */
    public C1757j m6197a(AbstractC1537g abstractC1537g) {
        boolean z = abstractC1537g instanceof C1129a;
        m6194a("Format", abstractC1537g.getAdZone().m7212b() != null ? abstractC1537g.getAdZone().m7212b().getLabel() : null).m6194a("Ad ID", Long.valueOf(abstractC1537g.getAdIdNumber())).m6194a("Zone ID", abstractC1537g.getAdZone().m7218a()).m6194a("Source", abstractC1537g.getSource()).m6194a("Ad Class", z ? "VastAd" : "AdServerAd");
        String m7077r = abstractC1537g.m7077r();
        if (StringUtils.isValidString(m7077r)) {
            m6194a("DSP Name", m7077r);
        }
        if (z) {
            m6194a("VAST DSP", ((C1129a) abstractC1537g).m8415i());
        }
        return this;
    }

    /* renamed from: a */
    public C1757j m6196a(C1662k c1662k) {
        return m6194a("Muted", Boolean.valueOf(c1662k.m6598p().isMuted())).m6194a(DatabaseProvider.TABLE_PREFIX, Boolean.valueOf(Utils.checkExoPlayerEligibility(c1662k)));
    }

    /* renamed from: a */
    public C1757j m6195a(String str) {
        StringBuilder sb = this.f2562a;
        sb.append("\n");
        sb.append(str);
        return this;
    }

    /* renamed from: a */
    public C1757j m6194a(String str, Object obj) {
        return m6193a(str, obj, "");
    }

    /* renamed from: a */
    public C1757j m6193a(String str, Object obj, String str2) {
        StringBuilder sb = this.f2562a;
        sb.append("\n");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }

    /* renamed from: b */
    public C1757j m6192b(AbstractC1537g abstractC1537g) {
        m6194a("Target", abstractC1537g.m7078q()).m6194a("close_style", abstractC1537g.m7073v()).m6193a("close_delay_graphic", Long.valueOf(abstractC1537g.m7074u()), "s");
        if (abstractC1537g instanceof C1527a) {
            C1527a c1527a = (C1527a) abstractC1537g;
            m6194a("HTML", c1527a.m7233c().substring(0, Math.min(c1527a.m7233c().length(), 64)));
        }
        if (abstractC1537g.hasVideoUrl()) {
            m6193a("close_delay", Long.valueOf(abstractC1537g.m7076s()), "s").m6194a("skip_style", abstractC1537g.m7072w()).m6194a("Streaming", Boolean.valueOf(abstractC1537g.mo7085f())).m6194a("Video Location", abstractC1537g.mo7089d()).m6194a("video_button_properties", abstractC1537g.m7170C());
        }
        return this;
    }

    /* renamed from: b */
    public C1757j m6191b(String str) {
        this.f2562a.append(str);
        return this;
    }

    public String toString() {
        return this.f2562a.toString();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.webkit.WebView;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahg */
/* loaded from: classes2.dex */
public final class ahg extends ahd {

    /* renamed from: a */
    private WebView f4065a;

    /* renamed from: b */
    private Long f4066b = null;

    /* renamed from: c */
    private final Map f4067c;

    public ahg(Map map) {
        this.f4067c = map;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ahd
    /* renamed from: c */
    public final void mo5282c() {
        super.mo5282c();
        new Handler().postDelayed(new ahf(this), Math.max(4000 - (this.f4066b == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.f4066b.longValue(), TimeUnit.NANOSECONDS)), (long) ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.f4065a = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ahd
    /* renamed from: f */
    public final void mo5281f(agj agjVar, agh aghVar) {
        JSONObject jSONObject = new JSONObject();
        Map m5350h = aghVar.m5350h();
        for (String str : m5350h.keySet()) {
            ahi.m5271h(jSONObject, str, (aev) m5350h.get(str));
        }
        m5286g(agjVar, aghVar, jSONObject);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ahd
    /* renamed from: j */
    public final void mo5280j() {
        WebView webView = new WebView(agu.m5311b().m5312a());
        this.f4065a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        m5284i(this.f4065a);
        agw.m5309a().m5302h(this.f4065a, null);
        Iterator it = this.f4067c.keySet().iterator();
        if (!it.hasNext()) {
            this.f4066b = Long.valueOf(System.nanoTime());
            return;
        }
        aev aevVar = (aev) this.f4067c.get((String) it.next());
        throw null;
    }
}

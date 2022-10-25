package com.applovin.impl.sdk.p031e;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.p010a.C1134b;
import com.applovin.impl.p010a.C1137e;
import com.applovin.impl.p010a.C1146k;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.p030d.C1584d;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collections;

/* renamed from: com.applovin.impl.sdk.e.e */
/* loaded from: classes.dex */
class C1598e extends AbstractC1594c {

    /* renamed from: c */
    private final C1129a f2077c;

    public C1598e(C1129a c1129a, C1662k c1662k, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", c1129a, c1662k, appLovinAdLoadListener);
        this.f2077c = c1129a;
    }

    /* renamed from: j */
    private void m6838j() {
        String str;
        String str2;
        String str3;
        if (m6854b()) {
            return;
        }
        if (this.f2077c.m8425aQ()) {
            C1134b m8412n = this.f2077c.m8412n();
            if (m8412n != null) {
                C1137e m8383b = m8412n.m8383b();
                if (m8383b != null) {
                    Uri m8366b = m8383b.m8366b();
                    String uri = m8366b != null ? m8366b.toString() : "";
                    String m8365c = m8383b.m8365c();
                    if (!URLUtil.isValidUrl(uri) && !StringUtils.isValidString(m8365c)) {
                        m6881c("Companion ad does not have any resources attached. Skipping...");
                        return;
                    } else if (m8383b.m8371a() == C1137e.EnumC1138a.STATIC) {
                        m6884a("Caching static companion ad at " + uri + "...");
                        Uri b = m6853b(uri, Collections.emptyList(), false);
                        if (b != null) {
                            m8383b.m8370a(b);
                            this.f2077c.m7140a(true);
                            return;
                        }
                        str2 = "Failed to cache static companion ad";
                    } else if (m8383b.m8371a() == C1137e.EnumC1138a.HTML) {
                        if (StringUtils.isValidString(uri)) {
                            m6884a("Begin caching HTML companion ad. Fetching from " + uri + "...");
                            m8365c = m6850f(uri);
                            if (StringUtils.isValidString(m8365c)) {
                                str3 = "HTML fetched. Caching HTML now...";
                            } else {
                                str2 = "Unable to load companion ad resources from " + uri;
                            }
                        } else {
                            str3 = "Caching provided HTML for companion ad. No fetch required. HTML: " + m8365c;
                        }
                        m6884a(str3);
                        m8383b.m8367a(m6856a(m8365c, Collections.emptyList(), this.f2077c));
                        this.f2077c.m7140a(true);
                        return;
                    } else if (m8383b.m8371a() != C1137e.EnumC1138a.IFRAME) {
                        return;
                    } else {
                        str = "Skip caching of iFrame resource...";
                    }
                } else {
                    str2 = "Failed to retrieve non-video resources from companion ad. Skipping...";
                }
                m6879d(str2);
                return;
            }
            str = "No companion ad provided. Skipping...";
        } else {
            str = "Companion ad caching disabled. Skipping...";
        }
        m6884a(str);
    }

    /* renamed from: k */
    private void m6837k() {
        C1146k m8413m;
        Uri m8324b;
        if (m6854b()) {
            return;
        }
        if (!this.f2077c.m8424aR()) {
            m6884a("Video caching disabled. Skipping...");
        } else if (this.f2077c.m8414l() == null || (m8413m = this.f2077c.m8413m()) == null || (m8324b = m8413m.m8324b()) == null) {
        } else {
            Uri a = m6855a(m8324b.toString(), Collections.emptyList(), false);
            if (a == null) {
                m6879d("Failed to cache video file: " + m8413m);
                return;
            }
            m6884a("Video file successfully cached into: " + a);
            m8413m.m8327a(a);
        }
    }

    /* renamed from: l */
    private void m6836l() {
        String m8427aO;
        String str;
        if (m6854b()) {
            return;
        }
        if (this.f2077c.m8426aP() != null) {
            m6884a("Begin caching HTML template. Fetching from " + this.f2077c.m8426aP() + "...");
            m8427aO = m6857a(this.f2077c.m8426aP().toString(), this.f2077c.m7163J());
        } else {
            m8427aO = this.f2077c.m8427aO();
        }
        if (StringUtils.isValidString(m8427aO)) {
            C1129a c1129a = this.f2077c;
            c1129a.m8428a(m6856a(m8427aO, c1129a.m7163J(), this.f2077c));
            str = "Finish caching HTML template " + this.f2077c.m8427aO() + " for ad #" + this.f2077c.getAdIdNumber();
        } else {
            str = "Unable to load HTML template";
        }
        m6884a(str);
    }

    @Override // com.applovin.impl.sdk.p031e.AbstractC1594c, java.lang.Runnable
    public void run() {
        super.run();
        if (this.f2077c.mo7085f()) {
            m6884a("Begin caching for VAST streaming ad #" + this.f2064a.getAdIdNumber() + "...");
            m6852c();
            if (this.f2077c.m8416g()) {
                m6847i();
            }
            if (this.f2077c.m8417e() == C1129a.EnumC1132b.COMPANION_AD) {
                m6838j();
                m6836l();
            } else {
                m6837k();
            }
            if (!this.f2077c.m8416g()) {
                m6847i();
            }
            if (this.f2077c.m8417e() == C1129a.EnumC1132b.COMPANION_AD) {
                m6837k();
            } else {
                m6838j();
                m6836l();
            }
        } else {
            m6884a("Begin caching for VAST ad #" + this.f2064a.getAdIdNumber() + "...");
            m6852c();
            m6838j();
            m6837k();
            m6836l();
            m6847i();
        }
        m6884a("Finished caching VAST ad #" + this.f2077c.getAdIdNumber());
        long currentTimeMillis = System.currentTimeMillis() - this.f2077c.getCreatedAtMillis();
        C1584d.m6924a(this.f2077c, this.f2058b);
        C1584d.m6925a(currentTimeMillis, this.f2077c, this.f2058b);
        m6861a(this.f2077c);
        this.f2077c.m8418c();
        m6863a();
    }
}

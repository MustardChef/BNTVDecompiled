package com.applovin.impl.adview.activity.p012b;

import android.os.SystemClock;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.activity.p011a.C1166b;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.utils.C1721d;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.b */
/* loaded from: classes.dex */
public class C1186b extends AbstractC1173a {

    /* renamed from: r */
    private final C1166b f408r;

    /* renamed from: s */
    private C1721d f409s;

    /* renamed from: t */
    private long f410t;

    /* renamed from: u */
    private AtomicBoolean f411u;

    public C1186b(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.f408r = new C1166b(this.f366a, this.f369d, this.f367b);
        this.f411u = new AtomicBoolean();
    }

    /* renamed from: c */
    private long m8245c() {
        if (this.f366a instanceof C1527a) {
            float m7229l = ((C1527a) this.f366a).m7229l();
            if (m7229l <= 0.0f) {
                m7229l = (float) this.f366a.m7074u();
            }
            return (long) (Utils.secondsToMillisLong(m7229l) * (this.f366a.m7156Q() / 100.0d));
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.p028b.C1554b.InterfaceC1564a
    /* renamed from: a */
    public void mo7023a() {
    }

    @Override // com.applovin.impl.sdk.p028b.C1554b.InterfaceC1564a
    /* renamed from: b */
    public void mo7022b() {
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: d */
    public void mo8167d() {
        this.f408r.m8276a(this.f372g, this.f371f);
        m8259a(false);
        this.f371f.renderAd(this.f366a);
        m8260a("javascript:al_onPoststitialShow();", this.f366a.m7155R());
        if (m8248r()) {
            long m8245c = m8245c();
            this.f410t = m8245c;
            if (m8245c > 0) {
                C1710r c1710r = this.f368c;
                c1710r.m6319b("InterActivityV2", "Scheduling timer for ad fully watched in " + this.f410t + "ms...");
                this.f409s = C1721d.m6283a(this.f410t, this.f367b, new Runnable() { // from class: com.applovin.impl.adview.activity.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C1186b.this.f368c.m6319b("InterActivityV2", "Marking ad as fully watched");
                        C1186b.this.f411u.set(true);
                    }
                });
            }
        }
        if (this.f372g != null) {
            if (this.f366a.m7074u() >= 0) {
                m8263a(this.f372g, this.f366a.m7074u(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C1186b.this.f374i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                this.f372g.setVisibility(0);
            }
        }
        mo8161s();
        super.m8255b(m8247t());
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: g */
    public void mo8165g() {
        mo8164l();
        C1721d c1721d = this.f409s;
        if (c1721d != null) {
            c1721d.m6284a();
            this.f409s = null;
        }
        super.mo8165g();
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: l */
    protected void mo8164l() {
        C1721d c1721d;
        boolean mo8163p = mo8163p();
        int i = 100;
        if (m8248r()) {
            if (!mo8163p && (c1721d = this.f409s) != null) {
                i = (int) Math.min(100.0d, ((this.f410t - c1721d.m6282b()) / this.f410t) * 100.0d);
            }
            C1710r c1710r = this.f368c;
            c1710r.m6319b("InterActivityV2", "Ad engaged at " + i + "%");
        }
        super.m8267a(i, false, mo8163p, -2L);
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: p */
    protected boolean mo8163p() {
        if (m8248r()) {
            return this.f411u.get();
        }
        return true;
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: q */
    protected boolean mo8162q() {
        return false;
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: s */
    protected void mo8161s() {
        long m7122ad;
        long millis;
        long j = 0;
        if (this.f366a.m7123ac() >= 0 || this.f366a.m7122ad() >= 0) {
            int i = (this.f366a.m7123ac() > 0L ? 1 : (this.f366a.m7123ac() == 0L ? 0 : -1));
            AbstractC1537g abstractC1537g = this.f366a;
            if (i >= 0) {
                m7122ad = abstractC1537g.m7123ac();
            } else {
                if (abstractC1537g.m7121ae()) {
                    int m7229l = (int) ((C1527a) this.f366a).m7229l();
                    if (m7229l > 0) {
                        millis = TimeUnit.SECONDS.toMillis(m7229l);
                    } else {
                        int m7074u = (int) this.f366a.m7074u();
                        if (m7074u > 0) {
                            millis = TimeUnit.SECONDS.toMillis(m7074u);
                        }
                    }
                    j = 0 + millis;
                }
                m7122ad = (long) (j * (this.f366a.m7122ad() / 100.0d));
            }
            m8266a(m7122ad);
        }
    }
}

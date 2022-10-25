package com.applovin.impl.adview.activity.p012b;

import android.graphics.PointF;
import android.net.Uri;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1254k;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.p010a.C1140g;
import com.applovin.impl.p010a.C1141h;
import com.applovin.impl.p010a.C1142i;
import com.applovin.impl.p010a.C1143j;
import com.applovin.impl.p010a.C1146k;
import com.applovin.impl.p010a.EnumC1136d;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.activity.b.d */
/* loaded from: classes.dex */
public class C1191d extends C1205f {

    /* renamed from: w */
    private final C1129a f417w;

    /* renamed from: x */
    private final Set<C1140g> f418x;

    public C1191d(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.f418x = hashSet;
        C1129a c1129a = (C1129a) abstractC1537g;
        this.f417w = c1129a;
        hashSet.addAll(c1129a.m8429a(C1129a.EnumC1133c.VIDEO, C1141h.f253a));
        m8235a(C1129a.EnumC1133c.IMPRESSION);
        m8233a(C1129a.EnumC1133c.VIDEO, "creativeView");
    }

    /* renamed from: a */
    private void m8235a(C1129a.EnumC1133c enumC1133c) {
        m8234a(enumC1133c, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m8234a(C1129a.EnumC1133c enumC1133c, EnumC1136d enumC1136d) {
        m8232a(enumC1133c, "", enumC1136d);
    }

    /* renamed from: a */
    private void m8233a(C1129a.EnumC1133c enumC1133c, String str) {
        m8232a(enumC1133c, str, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m8232a(C1129a.EnumC1133c enumC1133c, String str, EnumC1136d enumC1136d) {
        m8228a(this.f417w.m8430a(enumC1133c, str), enumC1136d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8229a(Set<C1140g> set) {
        m8228a(set, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m8228a(Set<C1140g> set, EnumC1136d enumC1136d) {
        if (set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.f469r.getCurrentPosition());
        C1146k m8413m = this.f417w.m8413m();
        Uri m8328a = m8413m != null ? m8413m.m8328a() : null;
        C1710r c1710r = this.f368c;
        c1710r.m6319b("InterActivityV2", "Firing " + set.size() + " tracker(s): " + set);
        C1142i.m8346a(set, seconds, m8328a, enumC1136d, this.f367b);
    }

    /* renamed from: y */
    private void m8225y() {
        if (!mo8163p() || this.f418x.isEmpty()) {
            return;
        }
        C1710r c1710r = this.f368c;
        c1710r.m6315d("InterActivityV2", "Firing " + this.f418x.size() + " un-fired video progress trackers when video was completed.");
        m8229a(this.f418x);
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f
    /* renamed from: a */
    public void mo8201a(PointF pointF) {
        m8235a(C1129a.EnumC1133c.VIDEO_CLICK);
        super.mo8201a(pointF);
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f
    /* renamed from: c */
    protected void mo8192c() {
        this.f470s.m8047c();
        super.mo8192c();
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f
    /* renamed from: c */
    public void mo8190c(String str) {
        m8234a(C1129a.EnumC1133c.ERROR, EnumC1136d.MEDIA_FILE_ERROR);
        super.mo8190c(str);
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f, com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: d */
    public void mo8167d() {
        super.mo8167d();
        this.f470s.m8050a("PROGRESS_TRACKING", ((Long) this.f367b.m6656a(C1568b.f1896eg)).longValue(), new C1254k.InterfaceC1256a() { // from class: com.applovin.impl.adview.activity.b.d.1
            @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
            /* renamed from: a */
            public void mo7891a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(C1191d.this.f472u - (C1191d.this.f469r.getDuration() - C1191d.this.f469r.getCurrentPosition()));
                HashSet hashSet = new HashSet();
                for (C1140g c1140g : new HashSet(C1191d.this.f418x)) {
                    if (c1140g.m8361a(seconds, C1191d.this.m8176x())) {
                        hashSet.add(c1140g);
                        C1191d.this.f418x.remove(c1140g);
                    }
                }
                C1191d.this.m8229a(hashSet);
            }

            @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
            /* renamed from: b */
            public boolean mo7890b() {
                return !C1191d.this.f473v;
            }
        });
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: e */
    public void mo8227e() {
        super.mo8227e();
        m8233a(this.f473v ? C1129a.EnumC1133c.COMPANION : C1129a.EnumC1133c.VIDEO, "resume");
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: f */
    public void mo8226f() {
        super.mo8226f();
        m8233a(this.f473v ? C1129a.EnumC1133c.COMPANION : C1129a.EnumC1133c.VIDEO, "pause");
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f, com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: g */
    public void mo8165g() {
        m8233a(C1129a.EnumC1133c.VIDEO, "close");
        m8233a(C1129a.EnumC1133c.COMPANION, "close");
        super.mo8165g();
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f, com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: s */
    protected void mo8161s() {
        long ad;
        int u;
        long j = 0;
        if (this.f417w.m7123ac() >= 0 || this.f417w.m7122ad() >= 0) {
            int i = (this.f417w.m7123ac() > 0L ? 1 : (this.f417w.m7123ac() == 0L ? 0 : -1));
            C1129a c1129a = this.f417w;
            if (i >= 0) {
                ad = c1129a.m7123ac();
            } else {
                C1143j m8414l = c1129a.m8414l();
                if (m8414l != null && m8414l.m8333b() > 0) {
                    j = 0 + TimeUnit.SECONDS.toMillis(m8414l.m8333b());
                } else if (this.f472u > 0) {
                    j = 0 + this.f472u;
                }
                if (c1129a.m7121ae() && (u = (int) c1129a.m7074u()) > 0) {
                    j += TimeUnit.SECONDS.toMillis(u);
                }
                ad = (long) (j * (this.f417w.m7122ad() / 100.0d));
            }
            m8266a(ad);
        }
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f
    /* renamed from: u */
    public void mo8179u() {
        m8233a(C1129a.EnumC1133c.VIDEO, "skip");
        super.mo8179u();
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f
    /* renamed from: v */
    public void mo8178v() {
        super.mo8178v();
        m8233a(C1129a.EnumC1133c.VIDEO, this.f471t ? "mute" : "unmute");
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1205f
    /* renamed from: w */
    public void mo8177w() {
        m8225y();
        if (!C1142i.m8339c(this.f417w)) {
            this.f368c.m6319b("InterActivityV2", "VAST ad does not have valid companion ad - dismissing...");
            mo8165g();
        } else if (this.f473v) {
        } else {
            m8233a(C1129a.EnumC1133c.COMPANION, "creativeView");
            super.mo8177w();
        }
    }
}

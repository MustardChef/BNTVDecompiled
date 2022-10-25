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

/* renamed from: com.applovin.impl.adview.activity.b.c */
/* loaded from: classes.dex */
public class C1189c extends C1193e {

    /* renamed from: A */
    private final Set<C1140g> f414A;

    /* renamed from: z */
    private final C1129a f415z;

    public C1189c(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.f414A = hashSet;
        C1129a c1129a = (C1129a) abstractC1537g;
        this.f415z = c1129a;
        hashSet.addAll(c1129a.m8429a(C1129a.EnumC1133c.VIDEO, C1141h.f253a));
        m8243a(C1129a.EnumC1133c.IMPRESSION);
        m8241a(C1129a.EnumC1133c.VIDEO, "creativeView");
    }

    /* renamed from: C */
    private void m8244C() {
        if (!mo8163p() || this.f414A.isEmpty()) {
            return;
        }
        C1710r c1710r = this.f368c;
        c1710r.m6315d("InterActivityV2", "Firing " + this.f414A.size() + " un-fired video progress trackers when video was completed.");
        m8237a(this.f414A);
    }

    /* renamed from: a */
    private void m8243a(C1129a.EnumC1133c enumC1133c) {
        m8242a(enumC1133c, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m8242a(C1129a.EnumC1133c enumC1133c, EnumC1136d enumC1136d) {
        m8240a(enumC1133c, "", enumC1136d);
    }

    /* renamed from: a */
    private void m8241a(C1129a.EnumC1133c enumC1133c, String str) {
        m8240a(enumC1133c, str, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m8240a(C1129a.EnumC1133c enumC1133c, String str, EnumC1136d enumC1136d) {
        m8236a(this.f415z.m8430a(enumC1133c, str), enumC1136d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8237a(Set<C1140g> set) {
        m8236a(set, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m8236a(Set<C1140g> set, EnumC1136d enumC1136d) {
        if (set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.f434s.getCurrentPosition());
        C1146k m8413m = this.f415z.m8413m();
        Uri m8328a = m8413m != null ? m8413m.m8328a() : null;
        C1710r c1710r = this.f368c;
        c1710r.m6319b("InterActivityV2", "Firing " + set.size() + " tracker(s): " + set);
        C1142i.m8346a(set, seconds, m8328a, enumC1136d, this.f367b);
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e
    /* renamed from: a */
    public void mo8221a(PointF pointF) {
        m8243a(C1129a.EnumC1133c.VIDEO_CLICK);
        super.mo8221a(pointF);
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e
    /* renamed from: c */
    protected void mo8214c() {
        this.f435t.m8047c();
        super.mo8214c();
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e
    /* renamed from: c */
    public void mo8212c(String str) {
        m8242a(C1129a.EnumC1133c.ERROR, EnumC1136d.MEDIA_FILE_ERROR);
        super.mo8212c(str);
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e, com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: d */
    public void mo8167d() {
        super.mo8167d();
        this.f435t.m8050a("PROGRESS_TRACKING", ((Long) this.f367b.m6656a(C1568b.f1896eg)).longValue(), new C1254k.InterfaceC1256a() { // from class: com.applovin.impl.adview.activity.b.c.1
            @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
            /* renamed from: a */
            public void mo7891a() {
                long seconds = TimeUnit.MILLISECONDS.toSeconds(C1189c.this.f437v - (C1189c.this.f434s.getDuration() - C1189c.this.f434s.getCurrentPosition()));
                HashSet hashSet = new HashSet();
                for (C1140g c1140g : new HashSet(C1189c.this.f414A)) {
                    if (c1140g.m8361a(seconds, C1189c.this.m8223B())) {
                        hashSet.add(c1140g);
                        C1189c.this.f414A.remove(c1140g);
                    }
                }
                C1189c.this.m8237a(hashSet);
            }

            @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
            /* renamed from: b */
            public boolean mo7890b() {
                return !C1189c.this.f439x;
            }
        });
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: e */
    public void mo8227e() {
        super.mo8227e();
        m8241a(this.f439x ? C1129a.EnumC1133c.COMPANION : C1129a.EnumC1133c.VIDEO, "resume");
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: f */
    public void mo8226f() {
        super.mo8226f();
        m8241a(this.f439x ? C1129a.EnumC1133c.COMPANION : C1129a.EnumC1133c.VIDEO, "pause");
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e, com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: g */
    public void mo8165g() {
        m8241a(C1129a.EnumC1133c.VIDEO, "close");
        m8241a(C1129a.EnumC1133c.COMPANION, "close");
        super.mo8165g();
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e, com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: s */
    protected void mo8161s() {
        long ad;
        int u;
        long j = 0;
        if (this.f415z.m7123ac() >= 0 || this.f415z.m7122ad() >= 0) {
            int i = (this.f415z.m7123ac() > 0L ? 1 : (this.f415z.m7123ac() == 0L ? 0 : -1));
            C1129a c1129a = this.f415z;
            if (i >= 0) {
                ad = c1129a.m7123ac();
            } else {
                C1143j m8414l = c1129a.m8414l();
                if (m8414l != null && m8414l.m8333b() > 0) {
                    j = 0 + TimeUnit.SECONDS.toMillis(m8414l.m8333b());
                } else if (this.f437v > 0) {
                    j = 0 + this.f437v;
                }
                if (c1129a.m7121ae() && (u = (int) c1129a.m7074u()) > 0) {
                    j += TimeUnit.SECONDS.toMillis(u);
                }
                ad = (long) (j * (this.f415z.m7122ad() / 100.0d));
            }
            m8266a(ad);
        }
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e
    /* renamed from: u */
    public void mo8208u() {
        m8241a(C1129a.EnumC1133c.VIDEO, "skip");
        super.mo8208u();
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e
    /* renamed from: v */
    public void mo8207v() {
        super.mo8207v();
        m8241a(C1129a.EnumC1133c.VIDEO, this.f436u ? "mute" : "unmute");
    }

    @Override // com.applovin.impl.adview.activity.p012b.C1193e
    /* renamed from: w */
    public void mo8206w() {
        m8244C();
        if (!C1142i.m8339c(this.f415z)) {
            this.f368c.m6319b("InterActivityV2", "VAST ad does not have valid companion ad - dismissing...");
            mo8165g();
        } else if (this.f439x) {
        } else {
            m8241a(C1129a.EnumC1133c.COMPANION, "creativeView");
            super.mo8206w();
        }
    }
}

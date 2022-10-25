package com.applovin.impl.adview.activity.p012b;

import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.StrictMode;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C1157a;
import com.applovin.impl.adview.C1267n;
import com.applovin.impl.adview.InterfaceC1248g;
import com.applovin.impl.adview.activity.p011a.C1171d;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p027a.AbstractC1537g;
import com.applovin.impl.sdk.p027a.C1527a;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.p031e.AbstractRunnableC1589a;
import com.applovin.impl.sdk.p031e.C1620o;
import com.applovin.impl.sdk.p031e.C1642y;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.C1799R;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.applovin.impl.adview.activity.b.g */
/* loaded from: classes.dex */
public class C1218g extends AbstractC1173a implements InterfaceC1248g {

    /* renamed from: A */
    private boolean f492A;

    /* renamed from: B */
    private long f493B;

    /* renamed from: C */
    private long f494C;

    /* renamed from: r */
    private final C1171d f495r;

    /* renamed from: s */
    private final C1267n f496s;

    /* renamed from: t */
    private final ImageView f497t;

    /* renamed from: u */
    private final C1157a f498u;

    /* renamed from: v */
    private final boolean f499v;

    /* renamed from: w */
    private double f500w;

    /* renamed from: x */
    private double f501x;

    /* renamed from: y */
    private AtomicBoolean f502y;

    /* renamed from: z */
    private AtomicBoolean f503z;

    /* renamed from: com.applovin.impl.adview.activity.b.g$a */
    /* loaded from: classes.dex */
    private class View$OnClickListenerC1222a implements View.OnClickListener {
        private View$OnClickListenerC1222a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == C1218g.this.f496s) {
                if (!C1218g.this.mo8162q()) {
                    C1218g.this.m8160u();
                    return;
                }
                C1218g.this.m8250n();
                C1218g.this.f380o.m7029b();
            } else if (view == C1218g.this.f497t) {
                C1218g.this.m8158w();
            } else {
                C1710r c1710r = C1218g.this.f368c;
                c1710r.m6314e("InterActivityV2", "Unhandled click on widget: " + view);
            }
        }
    }

    public C1218g(AbstractC1537g abstractC1537g, AppLovinFullscreenActivity appLovinFullscreenActivity, C1662k c1662k, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(abstractC1537g, appLovinFullscreenActivity, c1662k, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.f495r = new C1171d(this.f366a, this.f369d, this.f367b);
        boolean mo7085f = this.f366a.mo7085f();
        this.f499v = mo7085f;
        this.f502y = new AtomicBoolean();
        this.f503z = new AtomicBoolean();
        this.f492A = m8247t();
        this.f493B = -2L;
        this.f494C = 0L;
        View$OnClickListenerC1222a view$OnClickListenerC1222a = new View$OnClickListenerC1222a();
        if (abstractC1537g.m7076s() >= 0) {
            C1267n c1267n = new C1267n(abstractC1537g.m7072w(), appLovinFullscreenActivity);
            this.f496s = c1267n;
            c1267n.setVisibility(8);
            c1267n.setOnClickListener(view$OnClickListenerC1222a);
        } else {
            this.f496s = null;
        }
        if (m8171a(this.f492A, c1662k)) {
            ImageView imageView = new ImageView(appLovinFullscreenActivity);
            this.f497t = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(view$OnClickListenerC1222a);
            m8166d(this.f492A);
        } else {
            this.f497t = null;
        }
        if (!mo7085f) {
            this.f498u = null;
            return;
        }
        C1157a c1157a = new C1157a(appLovinFullscreenActivity, ((Integer) c1662k.m6656a(C1568b.f1765cF)).intValue(), 16842874);
        this.f498u = c1157a;
        c1157a.setColor(Color.parseColor("#75FFFFFF"));
        c1157a.setBackgroundColor(Color.parseColor("#00000000"));
        c1157a.setVisibility(8);
    }

    /* renamed from: a */
    private static boolean m8171a(boolean z, C1662k c1662k) {
        if (((Boolean) c1662k.m6656a(C1568b.f1803cr)).booleanValue()) {
            if (!((Boolean) c1662k.m6656a(C1568b.f1804cs)).booleanValue() || z) {
                return true;
            }
            return ((Boolean) c1662k.m6656a(C1568b.f1806cu)).booleanValue();
        }
        return false;
    }

    /* renamed from: d */
    private void m8166d(boolean z) {
        if (C1724f.m6275d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f369d.getDrawable(z ? C1799R.C1801drawable.unmute_to_mute : C1799R.C1801drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f497t.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f497t.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri m7135aE = z ? this.f366a.m7135aE() : this.f366a.m7134aF();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f497t.setImageURI(m7135aE);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m8157x() {
        if (this.f503z.compareAndSet(false, true)) {
            m8263a(this.f496s, this.f366a.m7076s(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.g.2
                @Override // java.lang.Runnable
                public void run() {
                    C1218g.this.f493B = -1L;
                    C1218g.this.f494C = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    @Override // com.applovin.impl.sdk.p028b.C1554b.InterfaceC1564a
    /* renamed from: a */
    public void mo7023a() {
        this.f368c.m6319b("InterActivityV2", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
    }

    @Override // com.applovin.impl.adview.InterfaceC1248g
    /* renamed from: a */
    public void mo8068a(double d) {
        m8256b("javascript:al_setVideoMuted(" + this.f492A + ");");
        C1157a c1157a = this.f498u;
        if (c1157a != null) {
            c1157a.m8288b();
        }
        if (this.f496s != null) {
            m8157x();
        }
        this.f371f.getAdViewController().m8110m();
        this.f501x = d;
        mo8161s();
        if (this.f366a.m7113am()) {
            this.f380o.m7033a(this.f366a, (Runnable) null);
        }
    }

    @Override // com.applovin.impl.adview.InterfaceC1248g
    /* renamed from: a_ */
    public void mo8067a_() {
        m8159v();
    }

    @Override // com.applovin.impl.sdk.p028b.C1554b.InterfaceC1564a
    /* renamed from: b */
    public void mo7022b() {
        this.f368c.m6319b("InterActivityV2", "Skipping video from prompt");
        m8160u();
    }

    @Override // com.applovin.impl.adview.InterfaceC1248g
    /* renamed from: b */
    public void mo8066b(double d) {
        this.f500w = d;
    }

    @Override // com.applovin.impl.adview.InterfaceC1248g
    /* renamed from: b_ */
    public void mo8065b_() {
        C1157a c1157a = this.f498u;
        if (c1157a != null) {
            c1157a.m8289a();
        }
    }

    @Override // com.applovin.impl.adview.InterfaceC1248g
    /* renamed from: c */
    public void mo8064c() {
        C1157a c1157a = this.f498u;
        if (c1157a != null) {
            c1157a.m8288b();
        }
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: d */
    public void mo8167d() {
        this.f495r.m8273a(this.f497t, this.f496s, this.f372g, this.f498u, this.f371f);
        this.f371f.getAdViewController().m8145a(this);
        m8259a(false);
        C1157a c1157a = this.f498u;
        if (c1157a != null) {
            c1157a.m8289a();
        }
        this.f371f.renderAd(this.f366a);
        if (this.f496s != null) {
            this.f367b.m6670Q().m6791a((AbstractRunnableC1589a) new C1642y(this.f367b, new Runnable() { // from class: com.applovin.impl.adview.activity.b.g.1
                @Override // java.lang.Runnable
                public void run() {
                    C1218g.this.m8157x();
                }
            }), C1620o.EnumC1622a.MAIN, this.f366a.m7075t(), true);
        }
        super.m8255b(this.f492A);
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: g */
    public void mo8165g() {
        mo8164l();
        super.mo8165g();
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: l */
    protected void mo8164l() {
        super.m8267a((int) this.f500w, this.f499v, mo8163p(), this.f493B);
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: p */
    protected boolean mo8163p() {
        return this.f500w >= ((double) this.f366a.m7157P());
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: q */
    protected boolean mo8162q() {
        return m8248r() && !mo8163p();
    }

    @Override // com.applovin.impl.adview.activity.p012b.AbstractC1173a
    /* renamed from: s */
    protected void mo8161s() {
        long m7122ad;
        int m7229l;
        if (this.f366a.m7123ac() >= 0 || this.f366a.m7122ad() >= 0) {
            int i = (this.f366a.m7123ac() > 0L ? 1 : (this.f366a.m7123ac() == 0L ? 0 : -1));
            AbstractC1537g abstractC1537g = this.f366a;
            if (i >= 0) {
                m7122ad = abstractC1537g.m7123ac();
            } else {
                C1527a c1527a = (C1527a) abstractC1537g;
                long millis = this.f501x > 0.0d ? 0 + TimeUnit.SECONDS.toMillis((long) this.f501x) : 0L;
                if (c1527a.m7121ae() && ((m7229l = (int) ((C1527a) this.f366a).m7229l()) > 0 || (m7229l = (int) c1527a.m7074u()) > 0)) {
                    millis += TimeUnit.SECONDS.toMillis(m7229l);
                }
                m7122ad = (long) (millis * (this.f366a.m7122ad() / 100.0d));
            }
            m8266a(m7122ad);
        }
    }

    /* renamed from: u */
    public void m8160u() {
        this.f493B = SystemClock.elapsedRealtime() - this.f494C;
        C1710r c1710r = this.f368c;
        c1710r.m6319b("InterActivityV2", "Skipping video with skip time: " + this.f493B + "ms");
        this.f370e.m6914f();
        if (this.f366a.m7071x()) {
            mo8165g();
        } else {
            m8159v();
        }
    }

    /* renamed from: v */
    public void m8159v() {
        if (this.f502y.compareAndSet(false, true)) {
            this.f368c.m6319b("InterActivityV2", "Showing postitial...");
            m8256b("javascript:al_showPostitial();");
            C1267n c1267n = this.f496s;
            if (c1267n != null) {
                c1267n.setVisibility(8);
            }
            ImageView imageView = this.f497t;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            C1157a c1157a = this.f498u;
            if (c1157a != null) {
                c1157a.m8288b();
            }
            if (this.f372g != null) {
                if (this.f366a.m7074u() >= 0) {
                    m8263a(this.f372g, this.f366a.m7074u(), new Runnable() { // from class: com.applovin.impl.adview.activity.b.g.3
                        @Override // java.lang.Runnable
                        public void run() {
                            C1218g.this.f374i = SystemClock.elapsedRealtime();
                        }
                    });
                } else {
                    this.f372g.setVisibility(0);
                }
            }
            this.f371f.getAdViewController().m8108n();
        }
    }

    /* renamed from: w */
    protected void m8158w() {
        this.f492A = !this.f492A;
        m8256b("javascript:al_setVideoMuted(" + this.f492A + ");");
        m8166d(this.f492A);
        m8258a(this.f492A, 0L);
    }
}

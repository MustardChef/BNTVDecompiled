package com.applovin.impl.adview;

import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.impl.adview.C1254k;
import com.applovin.impl.p010a.C1129a;
import com.applovin.impl.p010a.C1140g;
import com.applovin.impl.p010a.C1141h;
import com.applovin.impl.p010a.C1142i;
import com.applovin.impl.p010a.C1146k;
import com.applovin.impl.p010a.EnumC1136d;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.adview.t */
/* loaded from: classes.dex */
public class ActivityC1314t extends AbstractActivityC1269p {

    /* renamed from: a */
    private final Set<C1140g> f753a = new HashSet();

    /* renamed from: a */
    private void m7899a() {
        if (!isFullyWatched() || this.f753a.isEmpty()) {
            return;
        }
        C1710r c1710r = this.logger;
        c1710r.m6315d("InterstitialActivity", "Firing " + this.f753a.size() + " un-fired video progress trackers when video was completed.");
        m7894a(this.f753a);
    }

    /* renamed from: a */
    private void m7898a(C1129a.EnumC1133c enumC1133c) {
        m7897a(enumC1133c, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m7897a(C1129a.EnumC1133c enumC1133c, EnumC1136d enumC1136d) {
        m7895a(enumC1133c, "", enumC1136d);
    }

    /* renamed from: a */
    private void m7896a(C1129a.EnumC1133c enumC1133c, String str) {
        m7895a(enumC1133c, str, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m7895a(C1129a.EnumC1133c enumC1133c, String str, EnumC1136d enumC1136d) {
        if (isVastAd()) {
            m7893a(((C1129a) this.currentAd).m8430a(enumC1133c, str), enumC1136d);
        }
    }

    /* renamed from: a */
    private void m7894a(Set<C1140g> set) {
        m7893a(set, EnumC1136d.UNSPECIFIED);
    }

    /* renamed from: a */
    private void m7893a(Set<C1140g> set, EnumC1136d enumC1136d) {
        if (!isVastAd() || set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.videoView.getCurrentPosition());
        C1146k m8413m = m7892b().m8413m();
        Uri m8328a = m8413m != null ? m8413m.m8328a() : null;
        C1710r c1710r = this.logger;
        c1710r.m6319b("InterstitialActivity", "Firing " + set.size() + " tracker(s): " + set);
        C1142i.m8346a(set, seconds, m8328a, enumC1136d, this.sdk);
    }

    /* renamed from: b */
    private C1129a m7892b() {
        if (this.currentAd instanceof C1129a) {
            return (C1129a) this.currentAd;
        }
        return null;
    }

    @Override // com.applovin.impl.adview.AbstractActivityC1269p
    public void clickThroughFromVideo(PointF pointF) {
        super.clickThroughFromVideo(pointF);
        m7898a(C1129a.EnumC1133c.VIDEO_CLICK);
    }

    @Override // com.applovin.impl.adview.AbstractActivityC1269p, com.applovin.impl.adview.InterfaceC1258l
    public void dismiss() {
        if (isVastAd()) {
            m7896a(C1129a.EnumC1133c.VIDEO, "close");
            m7896a(C1129a.EnumC1133c.COMPANION, "close");
        }
        super.dismiss();
    }

    public void handleCountdownStep() {
        if (isVastAd()) {
            long seconds = this.computedLengthSeconds - TimeUnit.MILLISECONDS.toSeconds(this.videoView.getDuration() - this.videoView.getCurrentPosition());
            HashSet hashSet = new HashSet();
            for (C1140g c1140g : new HashSet(this.f753a)) {
                if (c1140g.m8361a(seconds, getVideoPercentViewed())) {
                    hashSet.add(c1140g);
                    this.f753a.remove(c1140g);
                }
            }
            m7894a(hashSet);
        }
    }

    @Override // com.applovin.impl.adview.AbstractActivityC1269p
    public void handleMediaError(String str) {
        m7897a(C1129a.EnumC1133c.ERROR, EnumC1136d.MEDIA_FILE_ERROR);
        super.handleMediaError(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.adview.AbstractActivityC1269p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isVastAd()) {
            this.f753a.addAll(m7892b().m8429a(C1129a.EnumC1133c.VIDEO, C1141h.f253a));
            m7898a(C1129a.EnumC1133c.IMPRESSION);
            m7896a(C1129a.EnumC1133c.VIDEO, "creativeView");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.adview.AbstractActivityC1269p, android.app.Activity
    public void onPause() {
        super.onPause();
        m7896a(this.postitialWasDisplayed ? C1129a.EnumC1133c.COMPANION : C1129a.EnumC1133c.VIDEO, "pause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.adview.AbstractActivityC1269p, android.app.Activity
    public void onResume() {
        super.onResume();
        m7896a(this.postitialWasDisplayed ? C1129a.EnumC1133c.COMPANION : C1129a.EnumC1133c.VIDEO, "resume");
    }

    @Override // com.applovin.impl.adview.AbstractActivityC1269p
    public void playVideo() {
        this.countdownManager.m8050a("PROGRESS_TRACKING", ((Long) this.sdk.m6656a(C1568b.f1896eg)).longValue(), new C1254k.InterfaceC1256a() { // from class: com.applovin.impl.adview.t.1
            @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
            /* renamed from: a */
            public void mo7891a() {
                ActivityC1314t.this.handleCountdownStep();
            }

            @Override // com.applovin.impl.adview.C1254k.InterfaceC1256a
            /* renamed from: b */
            public boolean mo7890b() {
                return ActivityC1314t.this.shouldContinueFullLengthVideoCountdown();
            }
        });
        super.playVideo();
    }

    @Override // com.applovin.impl.adview.AbstractActivityC1269p
    public void showPostitial() {
        if (isVastAd()) {
            m7899a();
            if (!C1142i.m8339c(m7892b())) {
                dismiss();
                return;
            } else if (this.postitialWasDisplayed) {
                return;
            } else {
                m7896a(C1129a.EnumC1133c.COMPANION, "creativeView");
            }
        }
        super.showPostitial();
    }

    @Override // com.applovin.impl.adview.AbstractActivityC1269p
    public void skipVideo() {
        m7896a(C1129a.EnumC1133c.VIDEO, "skip");
        super.skipVideo();
    }

    @Override // com.applovin.impl.adview.AbstractActivityC1269p
    public void toggleMute() {
        super.toggleMute();
        m7896a(C1129a.EnumC1133c.VIDEO, this.videoMuted ? "mute" : "unmute");
    }
}

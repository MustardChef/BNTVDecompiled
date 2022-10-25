package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.ads.interactivemedia.p034v3.api.AdPodInfo;
import com.google.ads.interactivemedia.p034v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.p034v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.alc */
/* loaded from: classes2.dex */
public final class alc implements VideoAdPlayer, ResizablePlayer, ald, aky {

    /* renamed from: a */
    private final C2745gz f4357a;

    /* renamed from: b */
    private final SurfaceView f4358b;

    /* renamed from: c */
    private final aen f4359c;

    /* renamed from: d */
    private final FrameLayout f4360d;

    /* renamed from: e */
    private final ViewGroup f4361e;

    /* renamed from: f */
    private final List f4362f;

    /* renamed from: g */
    private final HashSet f4363g;

    /* renamed from: h */
    private final akz f4364h;

    /* renamed from: i */
    private final ala f4365i;

    /* renamed from: j */
    private final alb f4366j;

    /* renamed from: k */
    private final ArrayList f4367k;

    /* renamed from: l */
    private final C2645dg f4368l;

    /* renamed from: m */
    private C3053sj f4369m;

    /* renamed from: n */
    private AdPodInfo f4370n;

    /* renamed from: o */
    private int f4371o;

    public alc(Context context, ViewGroup viewGroup) {
        C2745gz m2168a = C2741gv.m2168a(new C2691ez(context, new ale(context)));
        this.f4367k = new ArrayList();
        this.f4361e = viewGroup;
        this.f4357a = m2168a;
        String m2538ar = C2628cq.m2538ar(context);
        C2646dh c2646dh = new C2646dh();
        c2646dh.m2481b(m2538ar);
        this.f4368l = new C2645dg(context, c2646dh);
        this.f4362f = new ArrayList(1);
        ala alaVar = new ala(this);
        this.f4365i = alaVar;
        this.f4363g = axd.m4408d(4);
        alb albVar = new alb(this);
        this.f4366j = albVar;
        akz akzVar = new akz();
        this.f4364h = akzVar;
        akzVar.m5059b(this);
        m2168a.m2153J(alaVar);
        m2168a.m2152K(albVar);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f4360d = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        aen aenVar = new aen(context);
        this.f4359c = aenVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        aenVar.setLayoutParams(layoutParams);
        this.f4371o = 1;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f4358b = surfaceView;
        surfaceView.setZOrderMediaOverlay(true);
        m2168a.m2145R(surfaceView);
        aenVar.addView(surfaceView);
        frameLayout.addView(aenVar);
        viewGroup.addView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    /* renamed from: i */
    private final int m5046i(AdMediaInfo adMediaInfo) {
        return this.f4367k.indexOf(adMediaInfo);
    }

    /* renamed from: j */
    public final AdMediaInfo m5045j(int i) {
        if (i < 0 || i >= this.f4367k.size()) {
            return null;
        }
        return (AdMediaInfo) this.f4367k.get(i);
    }

    /* renamed from: k */
    public final AdMediaInfo m5044k() {
        int g = this.f4357a.mo2129g();
        if (this.f4369m == null) {
            return null;
        }
        return m5045j(g);
    }

    /* renamed from: l */
    private final void m5043l(AdMediaInfo adMediaInfo) {
        InterfaceC3069sz m1774a;
        Uri parse = Uri.parse(adMediaInfo.getUrl());
        int m2522l = C2628cq.m2522l(parse);
        if (m2522l == 0) {
            m1774a = new C2844kq(this.f4368l).m1774a(parse);
        } else if (m2522l == 2) {
            m1774a = new C2957ov(this.f4368l).m1439a(parse);
        } else if (m2522l == 4) {
            m1774a = new C3089ts(this.f4368l, new C3088tr(new C3234zb(1, null))).m1012a(parse);
        } else {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Unsupported type: ");
            sb.append(m2522l);
            throw new IllegalStateException(sb.toString());
        }
        C3053sj c3053sj = this.f4369m;
        atm.m4612j(c3053sj);
        c3053sj.m1135l(m1774a);
        this.f4367k.add(adMediaInfo);
    }

    /* renamed from: m */
    private final void m5042m() {
        this.f4360d.setVisibility(8);
        this.f4358b.setVisibility(4);
        this.f4369m = null;
        this.f4364h.m5057d();
        this.f4371o = 1;
        this.f4357a.m2144S();
        this.f4357a.m2140W();
        this.f4363g.clear();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aky
    /* renamed from: a */
    public final void mo5054a() {
        AdMediaInfo m5044k = m5044k();
        VideoProgressUpdate adProgress = getAdProgress();
        for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : this.f4362f) {
            videoAdPlayerCallback.onAdProgress(m5044k, adProgress);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
    public final void addCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
        this.f4362f.add(videoAdPlayerCallback);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return ((this.f4357a.m2118r() == 2 || this.f4357a.m2118r() == 3) && this.f4357a.m2117s() > 0) ? new VideoProgressUpdate(this.f4357a.mo2126j(), this.f4357a.m2117s()) : VideoProgressUpdate.VIDEO_TIME_NOT_READY;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VolumeProvider
    public final int getVolume() {
        return 100;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
    public final void pauseAd(AdMediaInfo adMediaInfo) {
        this.f4364h.m5057d();
        this.f4371o = 4;
        this.f4357a.m2147P(false);
        for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : this.f4362f) {
            videoAdPlayerCallback.onPause(adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
    public final void playAd(AdMediaInfo adMediaInfo) {
        if (this.f4369m == null || !this.f4367k.contains(adMediaInfo)) {
            throw new IllegalStateException("Call to playAd without appropriate call to loadAd first.");
        }
        this.f4360d.setVisibility(0);
        this.f4358b.setVisibility(0);
        int i = this.f4371o;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            throw new IllegalStateException("Call to playAd when player state is not LOADED.");
        }
        if (i2 == 1) {
            for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : this.f4362f) {
                videoAdPlayerCallback.onPlay(adMediaInfo);
            }
            this.f4357a.m2146Q(this.f4358b.getHolder());
        } else if (i2 == 2) {
            return;
        } else {
            if (i2 == 3) {
                for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback2 : this.f4362f) {
                    videoAdPlayerCallback2.onResume(adMediaInfo);
                }
            }
        }
        this.f4364h.m5058c();
        this.f4371o = 3;
        this.f4357a.m2147P(true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
    public final void release() {
        m5042m();
        this.f4357a.m2149N(this.f4365i);
        this.f4357a.m2148O(this.f4366j);
        this.f4357a.m2150M();
        this.f4364h.m5057d();
        this.f4361e.removeView(this.f4360d);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
    public final void removeCallback(VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback) {
        this.f4362f.remove(videoAdPlayerCallback);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.ResizablePlayer
    public final void resize(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((this.f4361e.getWidth() - i) - i3, (this.f4361e.getHeight() - i2) - i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        this.f4359c.setLayoutParams(layoutParams);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
    public final void stopAd(AdMediaInfo adMediaInfo) {
        if (this.f4369m == null) {
            Log.e("IMASDK", "Attempting to stop when no current ad source");
            return;
        }
        this.f4363g.add(adMediaInfo);
        int m5046i = m5046i(adMediaInfo);
        int g = this.f4357a.mo2129g();
        if (m5046i == g) {
            if (m5046i(adMediaInfo) != this.f4367k.size() - 1) {
                this.f4357a.mo2120p(this.f4357a.mo2129g() + 1);
                return;
            }
            m5042m();
        } else if (m5046i > g) {
            int m5046i2 = m5046i(adMediaInfo);
            C3053sj c3053sj = this.f4369m;
            atm.m4612j(c3053sj);
            c3053sj.m1150M(m5046i2);
            this.f4367k.remove(adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer
    public final void loadAd(AdMediaInfo adMediaInfo, AdPodInfo adPodInfo) {
        if (this.f4369m != null) {
            AdPodInfo adPodInfo2 = this.f4370n;
            if (adPodInfo2 == null || adPodInfo == null || adPodInfo2.getPodIndex() != adPodInfo.getPodIndex()) {
                throw new IllegalStateException("Called loadAd on an ad from a different ad break.");
            }
            m5043l(adMediaInfo);
            return;
        }
        this.f4357a.m2144S();
        C2745gz c2745gz = this.f4357a;
        c2745gz.mo2120p(c2745gz.mo2129g());
        this.f4367k.clear();
        this.f4369m = new C3053sj(new C3101ud(), new InterfaceC3069sz[0]);
        this.f4370n = adPodInfo;
        m5043l(adMediaInfo);
        this.f4357a.m2147P(false);
        this.f4357a.m2151L(this.f4369m);
        this.f4371o = 2;
    }
}

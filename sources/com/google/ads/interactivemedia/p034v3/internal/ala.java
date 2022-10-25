package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.ads.interactivemedia.p034v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ala */
/* loaded from: classes2.dex */
public final class ala implements InterfaceC2787in {

    /* renamed from: a */
    final /* synthetic */ alc f4355a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ala(alc alcVar) {
        this.f4355a = alcVar;
    }

    /* renamed from: am */
    private final void m5055am(AdMediaInfo adMediaInfo) {
        HashSet hashSet;
        List<VideoAdPlayer.VideoAdPlayerCallback> list;
        HashSet hashSet2;
        if (adMediaInfo != null) {
            hashSet = this.f4355a.f4363g;
            if (hashSet.contains(adMediaInfo)) {
                return;
            }
            list = this.f4355a.f4362f;
            for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : list) {
                videoAdPlayerCallback.onEnded(adMediaInfo);
            }
            hashSet2 = this.f4355a.f4363g;
            hashSet2.add(adMediaInfo);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: A */
    public final /* synthetic */ void mo2037A() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: B */
    public final /* synthetic */ void mo2036B() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: C */
    public final /* synthetic */ void mo2035C() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: D */
    public final /* synthetic */ void mo2034D() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: E */
    public final /* synthetic */ void mo2033E() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: F */
    public final /* synthetic */ void mo2032F() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: G */
    public final /* synthetic */ void mo2031G() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: H */
    public final /* synthetic */ void mo2030H() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: I */
    public final /* synthetic */ void mo2029I() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: J */
    public final /* synthetic */ void mo2028J() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: K */
    public final /* synthetic */ void mo2027K() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: L */
    public final /* synthetic */ void mo2026L() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: M */
    public final /* synthetic */ void mo2025M() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: N */
    public final /* synthetic */ void mo2024N() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: O */
    public final /* synthetic */ void mo2023O() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: P */
    public final void mo2022P(int i) {
        AdMediaInfo m5044k;
        List<VideoAdPlayer.VideoAdPlayerCallback> list;
        List<VideoAdPlayer.VideoAdPlayerCallback> list2;
        m5044k = this.f4355a.m5044k();
        if (m5044k == null) {
            return;
        }
        if (i == 2) {
            list = this.f4355a.f4362f;
            for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : list) {
                videoAdPlayerCallback.onBuffering(m5044k);
            }
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            m5055am(m5044k);
        } else {
            list2 = this.f4355a.f4362f;
            for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback2 : list2) {
                videoAdPlayerCallback2.onLoaded(m5044k);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: Q */
    public final /* synthetic */ void mo2021Q() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: R */
    public final void mo2020R(int i) {
        C3053sj c3053sj;
        C2745gz c2745gz;
        AdMediaInfo m5045j;
        List<VideoAdPlayer.VideoAdPlayerCallback> list;
        AdMediaInfo m5045j2;
        if (i != 0) {
            return;
        }
        alc alcVar = this.f4355a;
        c3053sj = alcVar.f4369m;
        if (c3053sj == null) {
            Log.d("IMASDK", "Position discontinuity occurred when there is no active media source.");
            return;
        }
        c2745gz = alcVar.f4357a;
        int g = c2745gz.mo2129g();
        for (int i2 = 0; i2 < g; i2++) {
            m5045j2 = this.f4355a.m5045j(i2);
            m5055am(m5045j2);
        }
        m5045j = this.f4355a.m5045j(g);
        if (m5045j != null) {
            list = this.f4355a.f4362f;
            for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : list) {
                videoAdPlayerCallback.onLoaded(m5045j);
                videoAdPlayerCallback.onPlay(m5045j);
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: S */
    public final /* synthetic */ void mo2019S() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: T */
    public final /* synthetic */ void mo2018T() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: U */
    public final /* synthetic */ void mo2017U() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: V */
    public final /* synthetic */ void mo2016V() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: W */
    public final /* synthetic */ void mo2015W() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: X */
    public final /* synthetic */ void mo2014X() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: Y */
    public final /* synthetic */ void mo2013Y() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: Z */
    public final /* synthetic */ void mo2012Z() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: a */
    public final void mo2011a(C2786im c2786im, C2556ap c2556ap) {
        AdMediaInfo m5045j;
        HashSet hashSet;
        List<VideoAdPlayer.VideoAdPlayerCallback> list;
        m5045j = this.f4355a.m5045j(c2786im.f7602c);
        hashSet = this.f4355a.f4363g;
        hashSet.add(m5045j);
        list = this.f4355a.f4362f;
        for (VideoAdPlayer.VideoAdPlayerCallback videoAdPlayerCallback : list) {
            videoAdPlayerCallback.onError(m5045j);
        }
        String valueOf = String.valueOf(c2556ap);
        String.valueOf(valueOf).length();
        Log.e("IMASDK", "Player Error:".concat(String.valueOf(valueOf)));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: aa */
    public final /* synthetic */ void mo2010aa() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: ab */
    public final /* synthetic */ void mo2009ab() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: ac */
    public final /* synthetic */ void mo2008ac() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: ad */
    public final /* synthetic */ void mo2007ad() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: ae */
    public final /* synthetic */ void mo2006ae() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: af */
    public final /* synthetic */ void mo2005af() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: ag */
    public final /* synthetic */ void mo2004ag() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: ah */
    public final /* synthetic */ void mo2003ah() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: ai */
    public final /* synthetic */ void mo2002ai() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: aj */
    public final /* synthetic */ void mo2001aj() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: ak */
    public final /* synthetic */ void mo2000ak() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: al */
    public final /* synthetic */ void mo1999al() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: b */
    public final /* synthetic */ void mo1998b() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: c */
    public final /* synthetic */ void mo1997c() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: d */
    public final /* synthetic */ void mo1996d() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: e */
    public final /* synthetic */ void mo1995e() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: f */
    public final /* synthetic */ void mo1994f() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: g */
    public final /* synthetic */ void mo1993g() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: h */
    public final /* synthetic */ void mo1992h() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: i */
    public final /* synthetic */ void mo1991i() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: j */
    public final /* synthetic */ void mo1990j() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: k */
    public final /* synthetic */ void mo1989k() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: l */
    public final /* synthetic */ void mo1988l() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: m */
    public final /* synthetic */ void mo1987m() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: n */
    public final /* synthetic */ void mo1986n() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: o */
    public final /* synthetic */ void mo1985o() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: p */
    public final /* synthetic */ void mo1984p() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: q */
    public final /* synthetic */ void mo1983q() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: r */
    public final /* synthetic */ void mo1982r() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: s */
    public final /* synthetic */ void mo1981s() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: t */
    public final /* synthetic */ void mo1980t() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: u */
    public final /* synthetic */ void mo1979u() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: v */
    public final /* synthetic */ void mo1978v() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: w */
    public final /* synthetic */ void mo1977w() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: x */
    public final /* synthetic */ void mo1976x() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: y */
    public final /* synthetic */ void mo1975y() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2787in
    /* renamed from: z */
    public final /* synthetic */ void mo1974z() {
    }
}

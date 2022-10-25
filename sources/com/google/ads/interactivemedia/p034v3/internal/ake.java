package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.AdError;
import com.google.ads.interactivemedia.p034v3.api.player.AdMediaInfo;
import com.google.ads.interactivemedia.p034v3.api.player.ResizablePlayer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.p034v3.impl.data.C2496bn;
import com.google.ads.interactivemedia.p034v3.impl.data.C2513d;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;
import com.google.ads.interactivemedia.p034v3.impl.data.C2533x;
import com.google.ads.interactivemedia.p034v3.impl.data.ResizeAndPositionVideoMsgData;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ake */
/* loaded from: classes2.dex */
public final class ake implements akv, aid {

    /* renamed from: a */
    private final AdDisplayContainer f4284a;

    /* renamed from: b */
    private final VideoAdPlayer f4285b;

    /* renamed from: c */
    private final aji f4286c;

    /* renamed from: d */
    private final ajx f4287d;

    /* renamed from: e */
    private final String f4288e;

    /* renamed from: f */
    private final aie f4289f;

    /* renamed from: g */
    private final auz f4290g = auz.m4538p();

    public ake(String str, ajx ajxVar, aji ajiVar, AdDisplayContainer adDisplayContainer) {
        this.f4284a = adDisplayContainer;
        VideoAdPlayer player = adDisplayContainer.getPlayer();
        this.f4285b = player;
        this.f4286c = ajiVar;
        this.f4287d = ajxVar;
        this.f4288e = str;
        aie aieVar = new aie();
        this.f4289f = aieVar;
        aieVar.m5215a(this);
        player.addCallback(aieVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aid
    /* renamed from: a */
    public final void mo5113a(ajo ajoVar, ajp ajpVar) {
        this.f4287d.mo5122o(new ajq(ajoVar, ajpVar, "*"));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aid
    /* renamed from: b */
    public final void mo5112b(ajp ajpVar, AdMediaInfo adMediaInfo, Object obj) {
        ajo ajoVar = (ajo) this.f4290g.m4547g().get(adMediaInfo);
        if (ajoVar == null) {
            String valueOf = String.valueOf(ajpVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 113);
            sb.append("The adMediaInfo for the ");
            sb.append(valueOf);
            sb.append(" event is not active. This may occur if callbacks are triggered after the ad is unloaded.");
            C2525p.m5988d(sb.toString());
            return;
        }
        this.f4287d.mo5122o(new ajq(ajoVar, ajpVar, this.f4288e, obj));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: c */
    public final void mo5067c() {
        C2525p.m5989c("Destroying NativeVideoDisplay");
        this.f4285b.removeCallback(this.f4289f);
        this.f4285b.release();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: d */
    public final void mo5066d() {
    }

    /* renamed from: e */
    public final void m5111e() {
        this.f4289f.m5213c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: f */
    public final void mo5065f(ajo ajoVar, ajp ajpVar, C2496bn c2496bn) {
        AdMediaInfo adMediaInfo = (AdMediaInfo) this.f4290g.get(ajoVar);
        ajp ajpVar2 = ajp.activate;
        int ordinal = ajpVar.ordinal();
        if (ordinal != 34) {
            if (ordinal == 43) {
                if (c2496bn == null || c2496bn.videoUrl == null) {
                    this.f4286c.m5165c(new aib(new AdError(AdError.AdErrorType.LOAD, AdError.AdErrorCode.INTERNAL_ERROR, "Load message must contain video url.")));
                    return;
                }
                this.f4289f.m5214b();
                AdMediaInfo adMediaInfo2 = new AdMediaInfo(c2496bn.videoUrl);
                C2513d c2513d = c2496bn.adPodInfo;
                if (c2513d == null) {
                    c2513d = null;
                }
                this.f4290g.put(ajoVar, adMediaInfo2);
                this.f4285b.loadAd(adMediaInfo2, c2513d);
                return;
            } else if (ordinal != 72) {
                if (ordinal == 52) {
                    this.f4285b.pauseAd(adMediaInfo);
                    return;
                } else if (ordinal != 53) {
                    return;
                } else {
                    this.f4285b.playAd(adMediaInfo);
                    this.f4289f.m5214b();
                    return;
                }
            }
        }
        this.f4285b.stopAd(adMediaInfo);
        this.f4290g.remove(ajoVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: g */
    public final void mo5064g(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        if (!(this.f4285b instanceof ResizablePlayer)) {
            C2525p.m5991a("Video player does not support resizing.");
        } else if (!C2533x.m5986a(this.f4284a, resizeAndPositionVideoMsgData)) {
            C2525p.m5991a("Creative resize parameters were not within the containers bounds.");
        } else {
            int width = this.f4284a.getAdContainer().getWidth();
            int height = this.f4284a.getAdContainer().getHeight();
            int intValue = resizeAndPositionVideoMsgData.mo6010x().intValue();
            int intValue2 = resizeAndPositionVideoMsgData.width().intValue();
            int intValue3 = resizeAndPositionVideoMsgData.mo6009y().intValue();
            ((ResizablePlayer) this.f4285b).resize(resizeAndPositionVideoMsgData.mo6010x().intValue(), resizeAndPositionVideoMsgData.mo6009y().intValue(), (width - intValue) - intValue2, (height - intValue3) - resizeAndPositionVideoMsgData.height().intValue());
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.f4285b.getAdProgress();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.akv
    /* renamed from: h */
    public final void mo5063h() {
        VideoAdPlayer videoAdPlayer = this.f4285b;
        if (videoAdPlayer instanceof ResizablePlayer) {
            ((ResizablePlayer) videoAdPlayer).resize(0, 0, 0, 0);
        }
    }

    /* renamed from: i */
    public final boolean m5110i() {
        return this.f4285b instanceof ald;
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.AdsManager;
import com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2506bx;
import com.google.ads.interactivemedia.p034v3.impl.data.C2525p;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aiq */
/* loaded from: classes2.dex */
public final class aiq extends ajb implements AdsManager, AdErrorEvent.AdErrorListener {

    /* renamed from: a */
    private final List f4172a;

    /* renamed from: b */
    private final akw f4173b;

    /* renamed from: c */
    private ajg f4174c;

    /* renamed from: d */
    private akp f4175d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public aiq(java.lang.String r16, com.google.ads.interactivemedia.p034v3.internal.ajx r17, com.google.ads.interactivemedia.p034v3.api.AdDisplayContainer r18, com.google.ads.interactivemedia.p034v3.internal.akp r19, java.util.List r20, java.util.SortedSet r21, com.google.ads.interactivemedia.p034v3.internal.akm r22, com.google.ads.interactivemedia.p034v3.internal.aji r23, android.content.Context r24, boolean r25) {
        /*
            r15 = this;
            r10 = r15
            r11 = r16
            r12 = r17
            r13 = r19
            com.google.ads.interactivemedia.v3.internal.ake r3 = new com.google.ads.interactivemedia.v3.internal.ake
            r4 = r18
            r7 = r23
            r3.<init>(r11, r12, r7, r4)
            com.google.ads.interactivemedia.v3.internal.ahz r5 = new com.google.ads.interactivemedia.v3.internal.ahz
            android.view.ViewGroup r0 = r18.getAdContainer()
            r5.<init>(r11, r12, r0)
            com.google.ads.interactivemedia.v3.internal.akw r14 = new com.google.ads.interactivemedia.v3.internal.akw
            android.webkit.WebView r0 = r17.m5144a()
            android.view.ViewGroup r1 = r18.getAdContainer()
            r14.<init>(r0, r1)
            r0 = r15
            r1 = r16
            r2 = r17
            r6 = r22
            r8 = r24
            r9 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r20
            r10.f4172a = r0
            r10.f4175d = r13
            r10.f4173b = r14
            if (r13 == 0) goto L4d
            com.google.ads.interactivemedia.v3.internal.ajg r0 = new com.google.ads.interactivemedia.v3.internal.ajg
            r1 = r21
            r0.<init>(r12, r1, r11)
            r10.f4174c = r0
            r13.m5094b(r0)
            r19.m5092d()
        L4d:
            r15.addAdErrorListener(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.aiq.<init>(java.lang.String, com.google.ads.interactivemedia.v3.internal.ajx, com.google.ads.interactivemedia.v3.api.AdDisplayContainer, com.google.ads.interactivemedia.v3.internal.akp, java.util.List, java.util.SortedSet, com.google.ads.interactivemedia.v3.internal.akm, com.google.ads.interactivemedia.v3.internal.aji, android.content.Context, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.ajb
    /* renamed from: a */
    public final Map mo5177a(AdsRenderingSettings adsRenderingSettings) {
        Map mo5177a = super.mo5177a(adsRenderingSettings);
        akp akpVar = this.f4175d;
        if (akpVar != null) {
            VideoProgressUpdate m5090f = akpVar.m5090f();
            if (!m5090f.equals(VideoProgressUpdate.VIDEO_TIME_NOT_READY)) {
                double currentTimeMs = ((float) m5090f.getCurrentTimeMs()) / 1000.0f;
                StringBuilder sb = new StringBuilder(68);
                sb.append("AdsManager.init -> Setting contentStartTime ");
                sb.append(currentTimeMs);
                C2525p.m5989c(sb.toString());
                mo5177a.put("contentStartTime", Double.valueOf(currentTimeMs));
            }
        }
        return mo5177a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajb, com.google.ads.interactivemedia.p034v3.internal.ajv
    /* renamed from: b */
    public final void mo5088b(aju ajuVar) {
        ake akeVar = (ake) m5176c();
        AdEvent.AdEventType adEventType = ajuVar.f4250a;
        AdEvent.AdEventType adEventType2 = AdEvent.AdEventType.ALL_ADS_COMPLETED;
        int ordinal = adEventType.ordinal();
        if (ordinal == 0) {
            super.destroy();
            akp akpVar = this.f4175d;
            if (akpVar != null) {
                akpVar.m5091e();
                this.f4175d = null;
            }
            this.f4173b.m5062a();
            m5173n(ajp.destroy);
            super.mo5088b(ajuVar);
            m5175l();
            return;
        }
        if (ordinal == 5) {
            akp akpVar2 = this.f4175d;
            if (akpVar2 != null) {
                akpVar2.m5091e();
            }
        } else if (ordinal == 6) {
            this.f4173b.m5062a();
            akeVar.m5111e();
            akp akpVar3 = this.f4175d;
            if (akpVar3 != null) {
                akpVar3.m5092d();
            }
        } else if (ordinal == 14) {
            this.f4173b.m5062a();
        } else if (ordinal == 15) {
            this.f4173b.m5061b();
        }
        super.mo5088b(ajuVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManager
    public final void clicked() {
        m5173n(ajp.click);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajb, com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void destroy() {
        super.destroy();
        akp akpVar = this.f4175d;
        if (akpVar != null) {
            akpVar.m5091e();
            this.f4175d = null;
        }
        this.f4173b.m5062a();
        m5173n(ajp.destroy);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManager
    public final void discardAdBreak() {
        m5173n(ajp.discardAdBreak);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManager
    public final List<Float> getAdCuePoints() {
        return this.f4172a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final boolean isCustomPlaybackUsed() {
        return ((ake) m5176c()).m5110i();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdErrorEvent.AdErrorListener
    public final void onAdError(AdErrorEvent adErrorEvent) {
        this.f4173b.m5062a();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManager
    public final void pause() {
        m5173n(ajp.pause);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManager
    public final void requestNextAdBreak() {
        if (this.f4175d != null) {
            m5174m(ajo.contentTimeUpdate, ajp.contentTimeUpdate, AbstractC2506bx.create(this.f4175d.m5090f()));
            m5173n(ajp.requestNextAdBreak);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManager
    public final void resume() {
        m5173n(ajp.resume);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManager
    public final void skip() {
        m5173n(ajp.skip);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdsManager
    public final void start() {
        m5173n(ajp.start);
    }
}

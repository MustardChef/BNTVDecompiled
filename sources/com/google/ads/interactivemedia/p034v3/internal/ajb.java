package com.google.ads.interactivemedia.p034v3.internal;

import android.app.Application;
import android.content.Context;
import com.google.ads.interactivemedia.p034v3.api.AdError;
import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.p034v3.api.AdsRenderingSettings;
import com.google.ads.interactivemedia.p034v3.api.BaseDisplayContainer;
import com.google.ads.interactivemedia.p034v3.api.BaseManager;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.p034v3.api.IMASDK;
import com.google.ads.interactivemedia.p034v3.api.player.VideoProgressUpdate;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2515f;
import com.google.ads.interactivemedia.p034v3.impl.data.C2509c;
import com.google.ads.interactivemedia.p034v3.impl.data.C2516g;
import com.google.ads.interactivemedia.p034v3.impl.data.C2522m;
import com.google.ads.interactivemedia.p034v3.impl.data.ResizeAndPositionVideoMsgData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ajb */
/* loaded from: classes2.dex */
abstract class ajb implements BaseManager, ajv, alf {

    /* renamed from: a */
    private final ajx f4201a;

    /* renamed from: b */
    private final String f4202b;

    /* renamed from: d */
    private final aji f4204d;

    /* renamed from: e */
    private final Context f4205e;

    /* renamed from: f */
    private final ahz f4206f;

    /* renamed from: g */
    private final akm f4207g;

    /* renamed from: h */
    private final akv f4208h;

    /* renamed from: i */
    private C2509c f4209i;

    /* renamed from: j */
    private AdProgressInfo f4210j;

    /* renamed from: m */
    private final alw f4213m;

    /* renamed from: n */
    private alg f4214n;

    /* renamed from: c */
    private final List f4203c = new ArrayList(1);

    /* renamed from: l */
    private boolean f4212l = false;

    /* renamed from: k */
    private AdsRenderingSettings f4211k = new C2516g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajb(String str, ajx ajxVar, akv akvVar, BaseDisplayContainer baseDisplayContainer, ahz ahzVar, akm akmVar, aji ajiVar, Context context, boolean z) {
        this.f4202b = str;
        this.f4201a = ajxVar;
        this.f4208h = akvVar;
        this.f4205e = context;
        this.f4204d = ajiVar;
        this.f4206f = ahzVar;
        ahzVar.m5222j(z);
        if (akmVar == null) {
            akmVar = null;
        } else {
            akmVar.m5100f(str);
            akmVar.m5102d(baseDisplayContainer.getAdContainer());
            addAdEventListener(akmVar);
            addAdErrorListener(akmVar);
            aja ajaVar = (aja) baseDisplayContainer;
            for (FriendlyObstruction friendlyObstruction : ajaVar.m5179b()) {
                akmVar.m5103c(friendlyObstruction);
            }
            ajaVar.m5178c(akmVar);
        }
        this.f4207g = akmVar;
        this.f4213m = new alw(context, this.f4211k);
        ajxVar.m5138g(this, str);
        ajxVar.m5136i(this.f4208h, str);
        ahzVar.m5225f();
        Application m5993a = C2522m.m5993a(context);
        if (m5993a != null) {
            alg algVar = new alg(m5993a);
            this.f4214n = algVar;
            algVar.m5038a(this);
        }
    }

    /* renamed from: o */
    private final void m5172o(AdErrorEvent adErrorEvent) {
        this.f4210j = null;
        this.f4204d.m5165c(adErrorEvent);
    }

    /* renamed from: p */
    private final void m5171p(String str) {
        if (C2522m.m5992b(this.f4205e, this.f4201a.m5143b())) {
            this.f4201a.m5144a().requestFocus();
            this.f4201a.mo5122o(new ajq(ajo.userInteraction, ajp.focusUiElement, str));
        }
    }

    /* renamed from: q */
    private final boolean m5170q() {
        return this.f4211k.getFocusSkipButtonWhenAvailable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Map mo5177a(AdsRenderingSettings adsRenderingSettings) {
        HashMap hashMap = new HashMap();
        hashMap.put("adsRenderingSettings", AbstractC2515f.builder(adsRenderingSettings).build());
        return hashMap;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void addAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.f4204d.m5167a(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void addAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.f4203c.add(adEventListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006d A[LOOP:0: B:30:0x0067->B:32:0x006d, LOOP_END] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo5088b(com.google.ads.interactivemedia.p034v3.internal.aju r6) {
        /*
            r5 = this;
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r0 = r6.f4250a
            com.google.ads.interactivemedia.v3.impl.data.c r1 = r6.f4251b
            com.google.ads.interactivemedia.v3.impl.data.ay r2 = com.google.ads.interactivemedia.p034v3.impl.data.EnumC2480ay.Html
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r2 = com.google.ads.interactivemedia.p034v3.api.AdEvent.AdEventType.ALL_ADS_COMPLETED
            int r2 = r0.ordinal()
            r3 = 3
            r4 = 0
            if (r2 == r3) goto L56
            r3 = 24
            if (r2 == r3) goto L56
            r3 = 5
            if (r2 == r3) goto L50
            r3 = 6
            if (r2 == r3) goto L4a
            r3 = 20
            if (r2 == r3) goto L47
            r3 = 21
            if (r2 == r3) goto L42
            switch(r2) {
                case 13: goto L36;
                case 14: goto L56;
                case 15: goto L26;
                default: goto L25;
            }
        L25:
            goto L58
        L26:
            if (r1 == 0) goto L2a
            r5.f4209i = r1
        L2a:
            boolean r1 = r5.m5170q()
            if (r1 == 0) goto L58
            java.lang.String r1 = r5.f4202b
            r5.m5171p(r1)
            goto L58
        L36:
            boolean r1 = r5.m5170q()
            if (r1 == 0) goto L58
            java.lang.String r1 = r5.f4202b
            r5.m5171p(r1)
            goto L58
        L42:
            com.google.ads.interactivemedia.v3.api.AdProgressInfo r1 = r6.f4254e
            r5.f4210j = r1
            goto L58
        L47:
            r5.f4209i = r1
            goto L58
        L4a:
            com.google.ads.interactivemedia.v3.internal.ahz r1 = r5.f4206f
            r1.m5221k()
            goto L58
        L50:
            com.google.ads.interactivemedia.v3.internal.ahz r1 = r5.f4206f
            r1.m5223i()
            goto L58
        L56:
            r5.f4210j = r4
        L58:
            java.util.Map r6 = r6.f4252c
            com.google.ads.interactivemedia.v3.internal.aic r1 = new com.google.ads.interactivemedia.v3.internal.aic
            com.google.ads.interactivemedia.v3.impl.data.c r2 = r5.f4209i
            r1.<init>(r0, r2, r6)
            java.util.List r6 = r5.f4203c
            java.util.Iterator r6 = r6.iterator()
        L67:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L77
            java.lang.Object r2 = r6.next()
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventListener r2 = (com.google.ads.interactivemedia.p034v3.api.AdEvent.AdEventListener) r2
            r2.onAdEvent(r1)
            goto L67
        L77:
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r6 = com.google.ads.interactivemedia.p034v3.api.AdEvent.AdEventType.COMPLETED
            if (r0 == r6) goto L81
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r6 = com.google.ads.interactivemedia.p034v3.api.AdEvent.AdEventType.SKIPPED
            if (r0 != r6) goto L80
            goto L81
        L80:
            return
        L81:
            r5.f4209i = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.ajb.mo5088b(com.google.ads.interactivemedia.v3.internal.aju):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final akv m5176c() {
        return this.f4208h;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.alf
    /* renamed from: d */
    public final void mo5040d() {
        this.f4201a.mo5122o(new ajq(ajo.adsManager, ajp.appBackgrounding, this.f4202b));
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public void destroy() {
        this.f4212l = true;
        this.f4207g.m5098h();
        this.f4206f.m5224g();
        this.f4206f.m5221k();
        alg algVar = this.f4214n;
        if (algVar != null) {
            algVar.m5037b();
        }
        this.f4208h.mo5067c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.alf
    /* renamed from: e */
    public final void mo5039e() {
        this.f4201a.mo5122o(new ajq(ajo.adsManager, ajp.appForegrounding, this.f4202b));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajv
    /* renamed from: f */
    public final void mo5150f(AdError.AdErrorType adErrorType, int i, String str) {
        m5172o(new aib(new AdError(adErrorType, i, str)));
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void focus() {
        m5171p(this.f4202b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajv
    /* renamed from: g */
    public final void mo5149g(AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str) {
        m5172o(new aib(new AdError(adErrorType, adErrorCode, str)));
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.player.AdProgressProvider
    public final VideoProgressUpdate getAdProgress() {
        return this.f4212l ? VideoProgressUpdate.VIDEO_TIME_NOT_READY : this.f4208h.getAdProgress();
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final AdProgressInfo getAdProgressInfo() {
        return this.f4210j;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final IMASDK getCurrentAd() {
        return this.f4209i;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajv
    /* renamed from: h */
    public final void mo5148h(String str) {
        this.f4213m.m5011a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
        if (r0 != 2) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.ajv
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo5147i(android.view.ViewGroup r10, com.google.ads.interactivemedia.p034v3.impl.data.CompanionData r11, java.lang.String r12, com.google.ads.interactivemedia.p034v3.api.CompanionAdSlot r13, com.google.ads.interactivemedia.p034v3.internal.ajx r14, com.google.ads.interactivemedia.p034v3.internal.alt r15) {
        /*
            r9 = this;
            r10.removeAllViews()
            com.google.ads.interactivemedia.v3.internal.ajc r13 = (com.google.ads.interactivemedia.p034v3.internal.ajc) r13
            java.util.List r6 = r13.m5169a()
            com.google.ads.interactivemedia.v3.impl.data.ay r0 = com.google.ads.interactivemedia.p034v3.impl.data.EnumC2480ay.Html
            com.google.ads.interactivemedia.v3.api.AdEvent$AdEventType r0 = com.google.ads.interactivemedia.p034v3.api.AdEvent.AdEventType.ALL_ADS_COMPLETED
            com.google.ads.interactivemedia.v3.impl.data.ay r0 = r11.type()
            int r0 = r0.ordinal()
            r1 = 0
            if (r0 == 0) goto L64
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L1f
            if (r0 == r2) goto L64
            goto L6f
        L1f:
            android.content.Context r4 = r10.getContext()
            java.lang.String r0 = r11.src()
            java.lang.String r5 = r11.size()
            if (r5 != 0) goto L2e
            goto L51
        L2e:
            r1 = -1
            java.lang.String r7 = "x"
            java.lang.String[] r1 = r5.split(r7, r1)
            int r5 = r1.length
            r7 = 0
            if (r5 == r2) goto L3f
            com.google.ads.interactivemedia.v3.impl.data.bi r1 = new com.google.ads.interactivemedia.v3.impl.data.bi
            r1.<init>(r7, r7)
            goto L51
        L3f:
            com.google.ads.interactivemedia.v3.impl.data.bi r2 = new com.google.ads.interactivemedia.v3.impl.data.bi
            r5 = r1[r7]
            int r5 = java.lang.Integer.parseInt(r5)
            r1 = r1[r3]
            int r1 = java.lang.Integer.parseInt(r1)
            r2.<init>(r5, r1)
            r1 = r2
        L51:
            com.google.android.gms.tasks.Task r15 = r15.m5017b(r0, r1)
            com.google.ads.interactivemedia.v3.internal.ajm r8 = new com.google.ads.interactivemedia.v3.internal.ajm
            com.google.ads.interactivemedia.v3.internal.alw r7 = r9.f4213m
            r0 = r8
            r1 = r4
            r2 = r14
            r3 = r11
            r4 = r15
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r1 = r8
            goto L6f
        L64:
            com.google.ads.interactivemedia.v3.internal.ajf r1 = new com.google.ads.interactivemedia.v3.internal.ajf
            android.content.Context r14 = r10.getContext()
            com.google.ads.interactivemedia.v3.internal.alw r15 = r9.f4213m
            r1.<init>(r14, r11, r6, r15)
        L6f:
            if (r1 == 0) goto L7a
            r1.setTag(r12)
            r13.m5168b(r12)
            r10.addView(r1)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.ajb.mo5147i(android.view.ViewGroup, com.google.ads.interactivemedia.v3.impl.data.CompanionData, java.lang.String, com.google.ads.interactivemedia.v3.api.CompanionAdSlot, com.google.ads.interactivemedia.v3.internal.ajx, com.google.ads.interactivemedia.v3.internal.alt):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void init() {
        init(null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajv
    /* renamed from: j */
    public final void mo5146j(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData) {
        this.f4208h.mo5064g(resizeAndPositionVideoMsgData);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajv
    /* renamed from: k */
    public final void mo5145k() {
        this.f4208h.mo5063h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final void m5175l() {
        this.f4201a.m5132n(this.f4202b);
        this.f4203c.clear();
        this.f4204d.m5166b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public final void m5174m(ajo ajoVar, ajp ajpVar, Object obj) {
        this.f4201a.mo5122o(new ajq(ajoVar, ajpVar, this.f4202b, obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public final void m5173n(ajp ajpVar) {
        this.f4201a.mo5122o(new ajq(ajo.adsManager, ajpVar, this.f4202b));
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void removeAdErrorListener(AdErrorEvent.AdErrorListener adErrorListener) {
        this.f4204d.m5164d(adErrorListener);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void removeAdEventListener(AdEvent.AdEventListener adEventListener) {
        this.f4203c.remove(adEventListener);
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.BaseManager
    public final void init(AdsRenderingSettings adsRenderingSettings) {
        if (adsRenderingSettings != null) {
            this.f4211k = adsRenderingSettings;
            this.f4213m.m5010b(adsRenderingSettings);
        }
        this.f4201a.mo5122o(new ajq(ajo.adsManager, ajp.init, this.f4202b, mo5177a(this.f4211k)));
        this.f4208h.mo5066d();
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.facebook.internal.ServerProtocol;
import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.p034v3.impl.data.AbstractC2504bv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.akm */
/* loaded from: classes2.dex */
public final class akm implements AdEvent.AdEventListener, AdErrorEvent.AdErrorListener, aiz, ajw {

    /* renamed from: a */
    private final ajx f4300a;

    /* renamed from: b */
    private final akl f4301b;

    /* renamed from: c */
    private final Context f4302c;

    /* renamed from: d */
    private View f4303d;

    /* renamed from: e */
    private String f4304e;

    /* renamed from: f */
    private final Set f4305f;

    /* renamed from: g */
    private boolean f4306g;

    /* renamed from: h */
    private boolean f4307h;

    /* renamed from: i */
    private String f4308i;

    /* renamed from: j */
    private agf f4309j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akm(ajx ajxVar, Context context) {
        akl aklVar = new akl();
        this.f4306g = false;
        this.f4307h = false;
        this.f4308i = null;
        this.f4300a = ajxVar;
        this.f4302c = context;
        this.f4301b = aklVar;
        this.f4305f = new HashSet();
    }

    /* renamed from: j */
    private final void m5096j(List list) {
        AbstractC2504bv abstractC2504bv;
        if (list == null) {
            abstractC2504bv = null;
        } else if (list.isEmpty()) {
            return;
        } else {
            abstractC2504bv = AbstractC2504bv.builder().friendlyObstructions(list).build();
        }
        this.f4300a.mo5122o(new ajq(ajo.omid, ajp.registerFriendlyObstructions, this.f4304e, abstractC2504bv));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajw
    /* renamed from: a */
    public final void mo5105a() {
        this.f4306g = false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.ajw
    /* renamed from: b */
    public final void mo5104b() {
        agd.m5369b(this.f4302c);
        this.f4306g = true;
    }

    /* renamed from: c */
    public final void m5103c(FriendlyObstruction friendlyObstruction) {
        if (this.f4305f.contains(friendlyObstruction)) {
            return;
        }
        this.f4305f.add(friendlyObstruction);
        agf agfVar = this.f4309j;
        if (agfVar == null) {
            return;
        }
        agfVar.mo5349b(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
        m5096j(Arrays.asList(friendlyObstruction));
    }

    /* renamed from: d */
    public final void m5102d(View view) {
        this.f4303d = view;
    }

    /* renamed from: e */
    public final void m5101e(String str) {
        this.f4308i = str;
    }

    /* renamed from: f */
    public final void m5100f(String str) {
        this.f4304e = str;
    }

    /* renamed from: g */
    public final void m5099g() {
        this.f4305f.clear();
        agf agfVar = this.f4309j;
        if (agfVar == null) {
            return;
        }
        agfVar.mo5346e();
        m5096j(null);
    }

    /* renamed from: h */
    public final void m5098h() {
        agf agfVar;
        if (!this.f4306g || (agfVar = this.f4309j) == null) {
            return;
        }
        agfVar.mo5348c();
        this.f4309j = null;
    }

    /* renamed from: i */
    public final void m5097i() {
        this.f4307h = true;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdErrorEvent.AdErrorListener
    public final void onAdError(AdErrorEvent adErrorEvent) {
        agf agfVar;
        if (!this.f4306g || (agfVar = this.f4309j) == null) {
            return;
        }
        agfVar.mo5348c();
        this.f4309j = null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdEvent.AdEventListener
    public final void onAdEvent(AdEvent adEvent) {
        if (this.f4306g) {
            AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
            int ordinal = adEvent.getType().ordinal();
            if (ordinal == 3 || ordinal == 14) {
                m5098h();
            } else if (ordinal == 15 && this.f4306g && this.f4309j == null && this.f4303d != null) {
                agg m5358b = agg.m5358b(agk.DEFINED_BY_JAVASCRIPT, agm.DEFINED_BY_JAVASCRIPT, agn.JAVASCRIPT, agn.JAVASCRIPT);
                ago m5336c = ago.m5336c();
                WebView m5144a = this.f4300a.m5144a();
                String str = this.f4308i;
                String str2 = true != this.f4307h ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
                StringBuilder sb = new StringBuilder(str2.length() + 7);
                sb.append("{ssai:");
                sb.append(str2);
                sb.append("}");
                agf m5360a = agf.m5360a(m5358b, agh.m5356b(m5336c, m5144a, str, sb.toString()));
                m5360a.mo5347d(this.f4303d);
                for (FriendlyObstruction friendlyObstruction : this.f4305f) {
                    m5360a.mo5349b(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
                }
                m5096j(new ArrayList(this.f4305f));
                m5360a.mo5345f();
                this.f4309j = m5360a;
            }
        }
    }
}

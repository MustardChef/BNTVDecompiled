package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agg */
/* loaded from: classes2.dex */
public final class agg {

    /* renamed from: a */
    private final agn f3953a;

    /* renamed from: b */
    private final agn f3954b;

    /* renamed from: c */
    private final agk f3955c;

    /* renamed from: d */
    private final agm f3956d;

    private agg(agk agkVar, agm agmVar, agn agnVar, agn agnVar2) {
        this.f3955c = agkVar;
        this.f3956d = agmVar;
        this.f3953a = agnVar;
        if (agnVar2 == null) {
            this.f3954b = agn.NONE;
        } else {
            this.f3954b = agnVar2;
        }
    }

    /* renamed from: b */
    public static agg m5358b(agk agkVar, agm agmVar, agn agnVar, agn agnVar2) {
        C2518i.m5997d(agkVar, "CreativeType is null");
        C2518i.m5997d(agmVar, "ImpressionType is null");
        C2518i.m5997d(agnVar, "Impression owner is null");
        if (agnVar == agn.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (agkVar != agk.DEFINED_BY_JAVASCRIPT || agnVar != agn.NATIVE) {
            if (agmVar != agm.DEFINED_BY_JAVASCRIPT || agnVar != agn.NATIVE) {
                return new agg(agkVar, agmVar, agnVar, agnVar2);
            }
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
    }

    /* renamed from: a */
    public final JSONObject m5359a() {
        JSONObject jSONObject = new JSONObject();
        ahi.m5271h(jSONObject, "impressionOwner", this.f3953a);
        if (this.f3955c == null || this.f3956d == null) {
            ahi.m5271h(jSONObject, "videoEventsOwner", this.f3954b);
        } else {
            ahi.m5271h(jSONObject, "mediaEventsOwner", this.f3954b);
            ahi.m5271h(jSONObject, "creativeType", this.f3955c);
            ahi.m5271h(jSONObject, "impressionType", this.f3956d);
        }
        ahi.m5271h(jSONObject, "isolateVerificationScripts", true);
        return jSONObject;
    }
}

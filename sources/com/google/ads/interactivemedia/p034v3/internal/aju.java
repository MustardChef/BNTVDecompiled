package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.p034v3.impl.data.C2509c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aju */
/* loaded from: classes2.dex */
public final class aju {

    /* renamed from: a */
    public final AdEvent.AdEventType f4250a;

    /* renamed from: b */
    public final C2509c f4251b;

    /* renamed from: c */
    public Map f4252c;

    /* renamed from: d */
    public List f4253d = new ArrayList();

    /* renamed from: e */
    AdProgressInfo f4254e;

    /* renamed from: f */
    public double f4255f;

    public aju(AdEvent.AdEventType adEventType, C2509c c2509c) {
        this.f4250a = adEventType;
        this.f4251b = c2509c;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return brf.m2729c(this, obj, new String[0]);
    }

    public final int hashCode() {
        return brh.m2722a(this, new String[0]);
    }
}

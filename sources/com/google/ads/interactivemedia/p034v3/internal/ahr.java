package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahr */
/* loaded from: classes2.dex */
public abstract class ahr extends ahs {

    /* renamed from: a */
    protected final HashSet f4098a;

    /* renamed from: b */
    protected final JSONObject f4099b;

    /* renamed from: c */
    protected final long f4100c;

    public ahr(ahl ahlVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(ahlVar);
        this.f4098a = new HashSet(hashSet);
        this.f4099b = jSONObject;
        this.f4100c = j;
    }
}

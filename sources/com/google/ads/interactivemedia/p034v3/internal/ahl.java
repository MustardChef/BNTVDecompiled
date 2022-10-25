package com.google.ads.interactivemedia.p034v3.internal;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahl */
/* loaded from: classes2.dex */
public final class ahl {

    /* renamed from: a */
    private JSONObject f4083a;

    /* renamed from: b */
    private final aht f4084b;

    public ahl(aht ahtVar) {
        this.f4084b = ahtVar;
    }

    /* renamed from: a */
    public final JSONObject m5254a() {
        return this.f4083a;
    }

    /* renamed from: b */
    public final void m5253b() {
        this.f4084b.m5234a(new ahu(this));
    }

    /* renamed from: c */
    public final void m5252c(JSONObject jSONObject, HashSet hashSet, long j) {
        this.f4084b.m5234a(new ahv(this, hashSet, jSONObject, j));
    }

    /* renamed from: d */
    public final void m5251d(JSONObject jSONObject, HashSet hashSet, long j) {
        this.f4084b.m5234a(new ahw(this, hashSet, jSONObject, j));
    }

    /* renamed from: e */
    public final void m5250e(JSONObject jSONObject) {
        this.f4083a = jSONObject;
    }
}

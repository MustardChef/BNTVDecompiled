package com.google.ads.interactivemedia.p034v3.internal;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.anr */
/* loaded from: classes2.dex */
public final class anr implements asx {

    /* renamed from: a */
    private final arv f4728a;

    /* renamed from: b */
    private final asf f4729b;

    /* renamed from: c */
    private final aod f4730c;

    /* renamed from: d */
    private final anq f4731d;

    /* renamed from: e */
    private final ang f4732e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public anr(arv arvVar, asf asfVar, aod aodVar, anq anqVar, ang angVar) {
        this.f4728a = arvVar;
        this.f4729b = asfVar;
        this.f4730c = aodVar;
        this.f4731d = anqVar;
        this.f4732e = angVar;
    }

    /* renamed from: e */
    private final Map m4910e() {
        HashMap hashMap = new HashMap();
        afr m4698b = this.f4729b.m4698b();
        hashMap.put("v", this.f4728a.m4716b());
        hashMap.put("gms", Boolean.valueOf(this.f4728a.m4715c()));
        hashMap.put("int", m4698b.m5552f());
        hashMap.put("up", Boolean.valueOf(this.f4731d.m4912a()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.asx
    /* renamed from: a */
    public final Map mo4643a() {
        Map m4910e = m4910e();
        m4910e.put("lts", Long.valueOf(this.f4730c.m4861a()));
        return m4910e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.asx
    /* renamed from: b */
    public final Map mo4642b() {
        Map m4910e = m4910e();
        afr m4699a = this.f4729b.m4699a();
        m4910e.put("gai", Boolean.valueOf(this.f4728a.m4714d()));
        m4910e.put("did", m4699a.m5553e());
        m4910e.put("dst", Integer.valueOf(afk.m5633b(m4699a.m5564ag())));
        m4910e.put("doo", Boolean.valueOf(m4699a.m5567ad()));
        ang angVar = this.f4732e;
        if (angVar != null) {
            m4910e.put("nt", Long.valueOf(angVar.m4921a()));
        }
        return m4910e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.asx
    /* renamed from: c */
    public final Map mo4641c() {
        return m4910e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final void m4911d(View view) {
        this.f4730c.m4858d(view);
    }
}

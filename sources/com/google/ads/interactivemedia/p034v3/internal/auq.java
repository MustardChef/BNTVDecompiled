package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.auq */
/* loaded from: classes2.dex */
final class auq extends aug {

    /* renamed from: a */
    final Object f5118a;

    /* renamed from: b */
    int f5119b;

    /* renamed from: c */
    final /* synthetic */ auz f5120c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public auq(auz auzVar, int i) {
        this.f5120c = auzVar;
        this.f5118a = auzVar.f5135a[i];
        this.f5119b = i;
    }

    /* renamed from: a */
    final void m4560a() {
        int i = this.f5119b;
        if (i != -1) {
            auz auzVar = this.f5120c;
            if (i <= auzVar.f5137c && anx.m4882b(auzVar.f5135a[i], this.f5118a)) {
                return;
            }
        }
        this.f5119b = this.f5120c.m4551c(this.f5118a);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object getKey() {
        return this.f5118a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object getValue() {
        m4560a();
        int i = this.f5119b;
        if (i == -1) {
            return null;
        }
        return this.f5120c.f5136b[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object setValue(Object obj) {
        m4560a();
        int i = this.f5119b;
        if (i == -1) {
            this.f5120c.put(this.f5118a, obj);
            return null;
        }
        Object obj2 = this.f5120c.f5136b[i];
        if (anx.m4882b(obj2, obj)) {
            return obj;
        }
        this.f5120c.m4554C(this.f5119b, obj);
        return obj2;
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aur */
/* loaded from: classes2.dex */
final class aur extends aug {

    /* renamed from: a */
    final auz f5121a;

    /* renamed from: b */
    final Object f5122b;

    /* renamed from: c */
    int f5123c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aur(auz auzVar, int i) {
        this.f5121a = auzVar;
        this.f5122b = auzVar.f5136b[i];
        this.f5123c = i;
    }

    /* renamed from: a */
    private final void m4559a() {
        int i = this.f5123c;
        if (i != -1) {
            auz auzVar = this.f5121a;
            if (i <= auzVar.f5137c && anx.m4882b(this.f5122b, auzVar.f5136b[i])) {
                return;
            }
        }
        this.f5123c = this.f5121a.m4549e(this.f5122b);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object getKey() {
        return this.f5122b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object getValue() {
        m4559a();
        int i = this.f5123c;
        if (i == -1) {
            return null;
        }
        return this.f5121a.f5135a[i];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.aug, java.util.Map.Entry
    public final Object setValue(Object obj) {
        m4559a();
        int i = this.f5123c;
        if (i == -1) {
            this.f5121a.m4537q(this.f5122b, obj);
            return null;
        }
        Object obj2 = this.f5121a.f5135a[i];
        if (anx.m4882b(obj2, obj)) {
            return obj;
        }
        this.f5121a.m4555B(this.f5123c, obj);
        return obj2;
    }
}

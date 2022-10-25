package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjx */
/* loaded from: classes2.dex */
public final class bjx implements bgz {

    /* renamed from: a */
    final /* synthetic */ Class f5883a;

    /* renamed from: b */
    final /* synthetic */ bgy f5884b;

    /* renamed from: c */
    private final /* synthetic */ int f5885c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bjx(Class cls, bgy bgyVar, int i) {
        this.f5885c = i;
        this.f5883a = cls;
        this.f5884b = bgyVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgz
    /* renamed from: a */
    public final bgy mo3604a(bgh bghVar, bkt bktVar) {
        if (this.f5885c != 0) {
            if (bktVar.m3600c() == this.f5883a) {
                return this.f5884b;
            }
            return null;
        }
        Class<?> m3600c = bktVar.m3600c();
        if (this.f5883a.isAssignableFrom(m3600c)) {
            return new bjw(this, m3600c);
        }
        return null;
    }

    public final String toString() {
        if (this.f5885c != 0) {
            String name = this.f5883a.getName();
            String obj = this.f5884b.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 23 + obj.length());
            sb.append("Factory[type=");
            sb.append(name);
            sb.append(",adapter=");
            sb.append(obj);
            sb.append("]");
            return sb.toString();
        }
        String name2 = this.f5883a.getName();
        String obj2 = this.f5884b.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + 32 + obj2.length());
        sb2.append("Factory[typeHierarchy=");
        sb2.append(name2);
        sb2.append(",adapter=");
        sb2.append(obj2);
        sb2.append("]");
        return sb2.toString();
    }
}

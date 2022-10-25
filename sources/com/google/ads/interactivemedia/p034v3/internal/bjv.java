package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjv */
/* loaded from: classes2.dex */
public final class bjv implements bgz {

    /* renamed from: a */
    final /* synthetic */ Class f5877a;

    /* renamed from: b */
    final /* synthetic */ Class f5878b;

    /* renamed from: c */
    final /* synthetic */ bgy f5879c;

    /* renamed from: d */
    private final /* synthetic */ int f5880d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bjv(Class cls, Class cls2, bgy bgyVar, int i) {
        this.f5880d = i;
        this.f5877a = cls;
        this.f5878b = cls2;
        this.f5879c = bgyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bjv(Class cls, Class cls2, bgy bgyVar, int i, byte[] bArr) {
        this.f5880d = i;
        this.f5878b = cls;
        this.f5877a = cls2;
        this.f5879c = bgyVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgz
    /* renamed from: a */
    public final bgy mo3604a(bgh bghVar, bkt bktVar) {
        if (this.f5880d != 0) {
            Class m3600c = bktVar.m3600c();
            if (m3600c == this.f5878b || m3600c == this.f5877a) {
                return this.f5879c;
            }
            return null;
        }
        Class m3600c2 = bktVar.m3600c();
        if (m3600c2 == this.f5877a || m3600c2 == this.f5878b) {
            return this.f5879c;
        }
        return null;
    }

    public final String toString() {
        if (this.f5880d == 0) {
            String name = this.f5877a.getName();
            String name2 = this.f5878b.getName();
            String obj = this.f5879c.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 24 + String.valueOf(name2).length() + obj.length());
            sb.append("Factory[type=");
            sb.append(name);
            sb.append("+");
            sb.append(name2);
            sb.append(",adapter=");
            sb.append(obj);
            sb.append("]");
            return sb.toString();
        }
        String name3 = this.f5877a.getName();
        String name4 = this.f5878b.getName();
        String obj2 = this.f5879c.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(name3).length() + 24 + String.valueOf(name4).length() + obj2.length());
        sb2.append("Factory[type=");
        sb2.append(name3);
        sb2.append("+");
        sb2.append(name4);
        sb2.append(",adapter=");
        sb2.append(obj2);
        sb2.append("]");
        return sb2.toString();
    }
}

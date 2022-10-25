package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bns */
/* loaded from: classes2.dex */
public class bns {

    /* renamed from: a */
    protected volatile boj f6292a;

    /* renamed from: b */
    private volatile bls f6293b;

    static {
        bmr.m3341a();
    }

    /* renamed from: a */
    public final int m3243a() {
        if (this.f6293b != null) {
            return this.f6293b.mo3054d();
        }
        if (this.f6292a != null) {
            return this.f6292a.mo3175as();
        }
        return 0;
    }

    /* renamed from: b */
    public final bls m3242b() {
        if (this.f6293b != null) {
            return this.f6293b;
        }
        synchronized (this) {
            if (this.f6293b != null) {
                return this.f6293b;
            }
            if (this.f6292a == null) {
                this.f6293b = bls.f6015b;
            } else {
                this.f6293b = this.f6292a.mo3177ap();
            }
            return this.f6293b;
        }
    }

    /* renamed from: d */
    public final boj m3240d(boj bojVar) {
        boj bojVar2 = this.f6292a;
        this.f6293b = null;
        this.f6292a = bojVar;
        return bojVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bns) {
            bns bnsVar = (bns) obj;
            boj bojVar = this.f6292a;
            boj bojVar2 = bnsVar.f6292a;
            if (bojVar == null && bojVar2 == null) {
                return m3242b().equals(bnsVar.m3242b());
            }
            if (bojVar == null || bojVar2 == null) {
                if (bojVar != null) {
                    return bojVar.equals(bnsVar.m3241c(bojVar.mo3171aT()));
                }
                return m3241c(bojVar2.mo3171aT()).equals(bojVar2);
            }
            return bojVar.equals(bojVar2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    /* renamed from: c */
    public final boj m3241c(boj bojVar) {
        if (this.f6292a == null) {
            synchronized (this) {
                if (this.f6292a == null) {
                    try {
                        this.f6292a = bojVar;
                        this.f6293b = bls.f6015b;
                    } catch (bnm unused) {
                        this.f6292a = bojVar;
                        this.f6293b = bls.f6015b;
                    }
                }
            }
        }
        return this.f6292a;
    }
}

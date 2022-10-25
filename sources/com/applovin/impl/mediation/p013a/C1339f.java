package com.applovin.impl.mediation.p013a;

import com.applovin.impl.mediation.C1471g;

/* renamed from: com.applovin.impl.mediation.a.f */
/* loaded from: classes.dex */
public class C1339f {

    /* renamed from: a */
    private final C1341g f838a;

    /* renamed from: b */
    private final String f839b;

    /* renamed from: c */
    private final String f840c;

    /* renamed from: d */
    private final String f841d;

    /* renamed from: e */
    private final String f842e;

    /* renamed from: com.applovin.impl.mediation.a.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1340a {
        /* renamed from: a */
        void mo7654a(C1339f c1339f);
    }

    private C1339f(C1341g c1341g, C1471g c1471g, String str, String str2) {
        String str3;
        this.f838a = c1341g;
        this.f841d = str;
        this.f842e = str2;
        if (c1471g != null) {
            this.f839b = c1471g.m7301f();
            str3 = c1471g.m7299g();
        } else {
            str3 = null;
            this.f839b = null;
        }
        this.f840c = str3;
    }

    /* renamed from: a */
    public static C1339f m7731a(C1341g c1341g, C1471g c1471g, String str) {
        if (c1341g != null) {
            if (c1471g != null) {
                return new C1339f(c1341g, c1471g, str, null);
            }
            throw new IllegalArgumentException("No adapterWrapper specified");
        }
        throw new IllegalArgumentException("No spec specified");
    }

    /* renamed from: a */
    public static C1339f m7730a(C1341g c1341g, String str) {
        return m7728b(c1341g, null, str);
    }

    /* renamed from: b */
    public static C1339f m7728b(C1341g c1341g, C1471g c1471g, String str) {
        if (c1341g != null) {
            return new C1339f(c1341g, c1471g, null, str);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    /* renamed from: a */
    public C1341g m7732a() {
        return this.f838a;
    }

    /* renamed from: b */
    public String m7729b() {
        return this.f839b;
    }

    /* renamed from: c */
    public String m7727c() {
        return this.f840c;
    }

    /* renamed from: d */
    public String m7726d() {
        return this.f841d;
    }

    /* renamed from: e */
    public String m7725e() {
        return this.f842e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.f838a);
        sb.append(", mSdkVersion='");
        sb.append(this.f839b);
        sb.append('\'');
        sb.append(", mAdapterVersion='");
        sb.append(this.f840c);
        sb.append('\'');
        sb.append(", mSignalDataLength='");
        String str = this.f841d;
        sb.append(str != null ? str.length() : 0);
        sb.append('\'');
        sb.append(", mErrorMessage=");
        sb.append(this.f842e);
        sb.append('}');
        return sb.toString();
    }
}

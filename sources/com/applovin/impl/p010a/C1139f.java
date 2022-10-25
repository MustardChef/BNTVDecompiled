package com.applovin.impl.p010a;

import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.internal.ServerProtocol;

/* renamed from: com.applovin.impl.a.f */
/* loaded from: classes.dex */
public class C1139f {

    /* renamed from: a */
    private String f246a;

    /* renamed from: b */
    private String f247b;

    private C1139f() {
    }

    /* renamed from: a */
    public static C1139f m8363a(C1766p c1766p, C1139f c1139f, C1662k c1662k) {
        if (c1766p != null) {
            if (c1662k != null) {
                if (c1139f == null) {
                    try {
                        c1139f = new C1139f();
                    } catch (Throwable th) {
                        c1662k.m6588z().m6318b("VastSystemInfo", "Error occurred while initializing", th);
                        return null;
                    }
                }
                if (!StringUtils.isValidString(c1139f.f246a)) {
                    String m6150c = c1766p.m6150c();
                    if (StringUtils.isValidString(m6150c)) {
                        c1139f.f246a = m6150c;
                    }
                }
                if (!StringUtils.isValidString(c1139f.f247b)) {
                    String str = c1766p.m6152b().get(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                    if (StringUtils.isValidString(str)) {
                        c1139f.f247b = str;
                    }
                }
                return c1139f;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }
        throw new IllegalArgumentException("No node specified.");
    }

    /* renamed from: a */
    public String m8364a() {
        return this.f246a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1139f) {
            C1139f c1139f = (C1139f) obj;
            String str = this.f246a;
            if (str == null ? c1139f.f246a == null : str.equals(c1139f.f246a)) {
                String str2 = this.f247b;
                String str3 = c1139f.f247b;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f246a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f247b;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastSystemInfo{name='" + this.f246a + "', version='" + this.f247b + "'}";
    }
}

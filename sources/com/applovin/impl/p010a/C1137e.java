package com.applovin.impl.p010a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.StringUtils;

/* renamed from: com.applovin.impl.a.e */
/* loaded from: classes.dex */
public class C1137e {

    /* renamed from: a */
    private EnumC1138a f238a;

    /* renamed from: b */
    private Uri f239b;

    /* renamed from: c */
    private String f240c;

    /* renamed from: com.applovin.impl.a.e$a */
    /* loaded from: classes.dex */
    public enum EnumC1138a {
        UNSPECIFIED,
        STATIC,
        IFRAME,
        HTML
    }

    private C1137e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C1137e m8369a(C1766p c1766p, C1137e c1137e, C1662k c1662k) {
        if (c1766p != null) {
            if (c1662k != null) {
                if (c1137e == null) {
                    try {
                        c1137e = new C1137e();
                    } catch (Throwable th) {
                        c1662k.m6588z().m6318b("VastNonVideoResource", "Error occurred while initializing", th);
                        return null;
                    }
                }
                if (c1137e.f239b == null && !StringUtils.isValidString(c1137e.f240c)) {
                    String m8368a = m8368a(c1766p, "StaticResource");
                    if (URLUtil.isValidUrl(m8368a)) {
                        c1137e.f239b = Uri.parse(m8368a);
                        c1137e.f238a = EnumC1138a.STATIC;
                        return c1137e;
                    }
                    String m8368a2 = m8368a(c1766p, "IFrameResource");
                    if (StringUtils.isValidString(m8368a2)) {
                        c1137e.f238a = EnumC1138a.IFRAME;
                        if (URLUtil.isValidUrl(m8368a2)) {
                            c1137e.f239b = Uri.parse(m8368a2);
                        } else {
                            c1137e.f240c = m8368a2;
                        }
                        return c1137e;
                    }
                    String m8368a3 = m8368a(c1766p, "HTMLResource");
                    if (StringUtils.isValidString(m8368a3)) {
                        c1137e.f238a = EnumC1138a.HTML;
                        if (URLUtil.isValidUrl(m8368a3)) {
                            c1137e.f239b = Uri.parse(m8368a3);
                        } else {
                            c1137e.f240c = m8368a3;
                        }
                    }
                }
                return c1137e;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }
        throw new IllegalArgumentException("No node specified.");
    }

    /* renamed from: a */
    private static String m8368a(C1766p c1766p, String str) {
        C1766p m6151b = c1766p.m6151b(str);
        if (m6151b != null) {
            return m6151b.m6150c();
        }
        return null;
    }

    /* renamed from: a */
    public EnumC1138a m8371a() {
        return this.f238a;
    }

    /* renamed from: a */
    public void m8370a(Uri uri) {
        this.f239b = uri;
    }

    /* renamed from: a */
    public void m8367a(String str) {
        this.f240c = str;
    }

    /* renamed from: b */
    public Uri m8366b() {
        return this.f239b;
    }

    /* renamed from: c */
    public String m8365c() {
        return this.f240c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1137e) {
            C1137e c1137e = (C1137e) obj;
            if (this.f238a != c1137e.f238a) {
                return false;
            }
            Uri uri = this.f239b;
            if (uri == null ? c1137e.f239b == null : uri.equals(c1137e.f239b)) {
                String str = this.f240c;
                String str2 = c1137e.f240c;
                return str != null ? str.equals(str2) : str2 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        EnumC1138a enumC1138a = this.f238a;
        int hashCode = (enumC1138a != null ? enumC1138a.hashCode() : 0) * 31;
        Uri uri = this.f239b;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        String str = this.f240c;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "VastNonVideoResource{type=" + this.f238a + ", resourceUri=" + this.f239b + ", resourceContents='" + this.f240c + "'}";
    }
}

package com.applovin.impl.p010a;

import android.net.Uri;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.StringUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.applovin.impl.a.b */
/* loaded from: classes.dex */
public class C1134b {

    /* renamed from: a */
    private int f210a;

    /* renamed from: b */
    private int f211b;

    /* renamed from: c */
    private Uri f212c;

    /* renamed from: d */
    private C1137e f213d;

    /* renamed from: e */
    private Set<C1140g> f214e = new HashSet();

    /* renamed from: f */
    private Map<String, Set<C1140g>> f215f = new HashMap();

    private C1134b() {
    }

    /* renamed from: a */
    public static C1134b m8384a(C1766p c1766p, C1134b c1134b, C1135c c1135c, C1662k c1662k) {
        C1766p m6151b;
        if (c1766p != null) {
            if (c1662k != null) {
                if (c1134b == null) {
                    try {
                        c1134b = new C1134b();
                    } catch (Throwable th) {
                        c1662k.m6588z().m6318b("VastCompanionAd", "Error occurred while initializing", th);
                        return null;
                    }
                }
                if (c1134b.f210a == 0 && c1134b.f211b == 0) {
                    int parseInt = StringUtils.parseInt(c1766p.m6152b().get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                    int parseInt2 = StringUtils.parseInt(c1766p.m6152b().get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                    if (parseInt > 0 && parseInt2 > 0) {
                        c1134b.f210a = parseInt;
                        c1134b.f211b = parseInt2;
                    }
                }
                c1134b.f213d = C1137e.m8369a(c1766p, c1134b.f213d, c1662k);
                if (c1134b.f212c == null && (m6151b = c1766p.m6151b("CompanionClickThrough")) != null) {
                    String m6150c = m6151b.m6150c();
                    if (StringUtils.isValidString(m6150c)) {
                        c1134b.f212c = Uri.parse(m6150c);
                    }
                }
                C1142i.m8347a(c1766p.m6153a("CompanionClickTracking"), c1134b.f214e, c1135c, c1662k);
                C1142i.m8349a(c1766p, c1134b.f215f, c1135c, c1662k);
                return c1134b;
            }
            throw new IllegalArgumentException("No sdk specified.");
        }
        throw new IllegalArgumentException("No node specified.");
    }

    /* renamed from: a */
    public Uri m8385a() {
        return this.f212c;
    }

    /* renamed from: b */
    public C1137e m8383b() {
        return this.f213d;
    }

    /* renamed from: c */
    public Set<C1140g> m8382c() {
        return this.f214e;
    }

    /* renamed from: d */
    public Map<String, Set<C1140g>> m8381d() {
        return this.f215f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1134b) {
            C1134b c1134b = (C1134b) obj;
            if (this.f210a == c1134b.f210a && this.f211b == c1134b.f211b) {
                Uri uri = this.f212c;
                if (uri == null ? c1134b.f212c == null : uri.equals(c1134b.f212c)) {
                    C1137e c1137e = this.f213d;
                    if (c1137e == null ? c1134b.f213d == null : c1137e.equals(c1134b.f213d)) {
                        Set<C1140g> set = this.f214e;
                        if (set == null ? c1134b.f214e == null : set.equals(c1134b.f214e)) {
                            Map<String, Set<C1140g>> map = this.f215f;
                            Map<String, Set<C1140g>> map2 = c1134b.f215f;
                            return map != null ? map.equals(map2) : map2 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f210a * 31) + this.f211b) * 31;
        Uri uri = this.f212c;
        int hashCode = (i + (uri != null ? uri.hashCode() : 0)) * 31;
        C1137e c1137e = this.f213d;
        int hashCode2 = (hashCode + (c1137e != null ? c1137e.hashCode() : 0)) * 31;
        Set<C1140g> set = this.f214e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C1140g>> map = this.f215f;
        return hashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastCompanionAd{width=" + this.f210a + ", height=" + this.f211b + ", destinationUri=" + this.f212c + ", nonVideoResource=" + this.f213d + ", clickTrackers=" + this.f214e + ", eventTrackers=" + this.f215f + '}';
    }
}

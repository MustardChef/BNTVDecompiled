package com.applovin.impl.p010a;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.p029c.C1568b;
import com.applovin.impl.sdk.utils.C1724f;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.j */
/* loaded from: classes.dex */
public class C1143j {

    /* renamed from: a */
    private List<C1146k> f256a;

    /* renamed from: b */
    private List<String> f257b;

    /* renamed from: c */
    private int f258c;

    /* renamed from: d */
    private Uri f259d;

    /* renamed from: e */
    private final Set<C1140g> f260e;

    /* renamed from: f */
    private final Map<String, Set<C1140g>> f261f;

    /* renamed from: com.applovin.impl.a.j$a */
    /* loaded from: classes.dex */
    public enum EnumC1145a {
        UNSPECIFIED,
        LOW,
        MEDIUM,
        HIGH
    }

    private C1143j() {
        this.f256a = Collections.EMPTY_LIST;
        this.f257b = Collections.EMPTY_LIST;
        this.f260e = new HashSet();
        this.f261f = new HashMap();
    }

    private C1143j(C1135c c1135c) {
        this.f256a = Collections.EMPTY_LIST;
        this.f257b = Collections.EMPTY_LIST;
        this.f260e = new HashSet();
        this.f261f = new HashMap();
        this.f257b = c1135c.m8374g();
    }

    /* renamed from: a */
    private static int m8334a(String str, C1662k c1662k) {
        try {
            List<String> explode = CollectionUtils.explode(str, ":");
            if (explode.size() == 3) {
                return (int) (TimeUnit.HOURS.toSeconds(StringUtils.parseInt(explode.get(0))) + TimeUnit.MINUTES.toSeconds(StringUtils.parseInt(explode.get(1))) + StringUtils.parseInt(explode.get(2)));
            }
        } catch (Throwable unused) {
            C1710r m6588z = c1662k.m6588z();
            m6588z.m6314e("VastVideoCreative", "Unable to parse duration from \"" + str + "\"");
        }
        return 0;
    }

    /* renamed from: a */
    public static C1143j m8336a(C1766p c1766p, C1143j c1143j, C1135c c1135c, C1662k c1662k) {
        C1766p m6151b;
        List<C1146k> m8335a;
        C1766p m6151b2;
        int m8334a;
        if (c1766p != null) {
            if (c1135c != null) {
                if (c1662k != null) {
                    if (c1143j == null) {
                        try {
                            c1143j = new C1143j(c1135c);
                        } catch (Throwable th) {
                            c1662k.m6588z().m6318b("VastVideoCreative", "Error occurred while initializing", th);
                            return null;
                        }
                    }
                    if (c1143j.f258c == 0 && (m6151b2 = c1766p.m6151b("Duration")) != null && (m8334a = m8334a(m6151b2.m6150c(), c1662k)) > 0) {
                        c1143j.f258c = m8334a;
                    }
                    C1766p m6151b3 = c1766p.m6151b("MediaFiles");
                    if (m6151b3 != null && (m8335a = m8335a(m6151b3, c1662k)) != null && m8335a.size() > 0) {
                        List<C1146k> list = c1143j.f256a;
                        if (list != null) {
                            m8335a.addAll(list);
                        }
                        c1143j.f256a = m8335a;
                    }
                    C1766p m6151b4 = c1766p.m6151b("VideoClicks");
                    if (m6151b4 != null) {
                        if (c1143j.f259d == null && (m6151b = m6151b4.m6151b("ClickThrough")) != null) {
                            String m6150c = m6151b.m6150c();
                            if (StringUtils.isValidString(m6150c)) {
                                c1143j.f259d = Uri.parse(m6150c);
                            }
                        }
                        C1142i.m8347a(m6151b4.m6153a("ClickTracking"), c1143j.f260e, c1135c, c1662k);
                    }
                    C1142i.m8349a(c1766p, c1143j.f261f, c1135c, c1662k);
                    return c1143j;
                }
                throw new IllegalArgumentException("No sdk specified.");
            }
            throw new IllegalArgumentException("No context specified.");
        }
        throw new IllegalArgumentException("No node specified.");
    }

    /* renamed from: a */
    private static List<C1146k> m8335a(C1766p c1766p, C1662k c1662k) {
        List<C1766p> m6153a = c1766p.m6153a("MediaFile");
        ArrayList arrayList = new ArrayList(m6153a.size());
        List<String> explode = CollectionUtils.explode((String) c1662k.m6656a(C1568b.f1898ei));
        List<String> explode2 = CollectionUtils.explode((String) c1662k.m6656a(C1568b.f1897eh));
        for (C1766p c1766p2 : m6153a) {
            C1146k m8326a = C1146k.m8326a(c1766p2, c1662k);
            if (m8326a != null) {
                try {
                    String m8323c = m8326a.m8323c();
                    if (!StringUtils.isValidString(m8323c) || explode.contains(m8323c)) {
                        if (((Boolean) c1662k.m6656a(C1568b.f1899ej)).booleanValue()) {
                            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(m8326a.m8324b().toString());
                            if (StringUtils.isValidString(fileExtensionFromUrl) && !explode2.contains(fileExtensionFromUrl)) {
                            }
                        }
                        C1710r m6588z = c1662k.m6588z();
                        m6588z.m6315d("VastVideoCreative", "Video file not supported: " + m8326a);
                    }
                    arrayList.add(m8326a);
                } catch (Throwable th) {
                    C1710r m6588z2 = c1662k.m6588z();
                    m6588z2.m6318b("VastVideoCreative", "Failed to validate video file: " + m8326a, th);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public C1146k m8337a(EnumC1145a enumC1145a) {
        List<C1146k> list = this.f256a;
        if (list == null || list.size() == 0) {
            return null;
        }
        List arrayList = new ArrayList(3);
        for (String str : this.f257b) {
            for (C1146k c1146k : this.f256a) {
                String m8323c = c1146k.m8323c();
                if (StringUtils.isValidString(m8323c) && str.equalsIgnoreCase(m8323c)) {
                    arrayList.add(c1146k);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList = this.f256a;
        }
        if (C1724f.m6276c()) {
            Collections.sort(arrayList, new Comparator<C1146k>() { // from class: com.applovin.impl.a.j.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(C1146k c1146k2, C1146k c1146k3) {
                    return Integer.compare(c1146k2.m8322d(), c1146k3.m8322d());
                }
            });
        }
        return (C1146k) arrayList.get(enumC1145a == EnumC1145a.LOW ? 0 : enumC1145a == EnumC1145a.MEDIUM ? arrayList.size() / 2 : arrayList.size() - 1);
    }

    /* renamed from: a */
    public List<C1146k> m8338a() {
        return this.f256a;
    }

    /* renamed from: b */
    public int m8333b() {
        return this.f258c;
    }

    /* renamed from: c */
    public Uri m8332c() {
        return this.f259d;
    }

    /* renamed from: d */
    public Set<C1140g> m8331d() {
        return this.f260e;
    }

    /* renamed from: e */
    public Map<String, Set<C1140g>> m8330e() {
        return this.f261f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1143j) {
            C1143j c1143j = (C1143j) obj;
            if (this.f258c != c1143j.f258c) {
                return false;
            }
            List<C1146k> list = this.f256a;
            if (list == null ? c1143j.f256a == null : list.equals(c1143j.f256a)) {
                Uri uri = this.f259d;
                if (uri == null ? c1143j.f259d == null : uri.equals(c1143j.f259d)) {
                    Set<C1140g> set = this.f260e;
                    if (set == null ? c1143j.f260e == null : set.equals(c1143j.f260e)) {
                        Map<String, Set<C1140g>> map = this.f261f;
                        Map<String, Set<C1140g>> map2 = c1143j.f261f;
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

    public int hashCode() {
        List<C1146k> list = this.f256a;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + this.f258c) * 31;
        Uri uri = this.f259d;
        int hashCode2 = (hashCode + (uri != null ? uri.hashCode() : 0)) * 31;
        Set<C1140g> set = this.f260e;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        Map<String, Set<C1140g>> map = this.f261f;
        return hashCode3 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "VastVideoCreative{videoFiles=" + this.f256a + ", durationSeconds=" + this.f258c + ", destinationUri=" + this.f259d + ", clickTrackers=" + this.f260e + ", eventTrackers=" + this.f261f + '}';
    }
}

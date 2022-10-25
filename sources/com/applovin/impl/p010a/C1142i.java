package com.applovin.impl.p010a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.C1710r;
import com.applovin.impl.sdk.network.C1697g;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.i */
/* loaded from: classes.dex */
public class C1142i {

    /* renamed from: a */
    private static DateFormat f254a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US);

    /* renamed from: b */
    private static Random f255b = new Random(System.currentTimeMillis());

    /* renamed from: a */
    public static Uri m8348a(String str, long j, Uri uri, EnumC1136d enumC1136d, C1662k c1662k) {
        if (!URLUtil.isValidUrl(str)) {
            c1662k.m6588z().m6314e("VastUtils", "Unable to replace macros in invalid URL string.");
            return null;
        }
        try {
            String replace = str.replace("[ERRORCODE]", Integer.toString(enumC1136d.m8372a()));
            if (j >= 0) {
                replace = replace.replace("[CONTENTPLAYHEAD]", m8356a(j));
            }
            if (uri != null) {
                replace = replace.replace("[ASSETURI]", uri.toString());
            }
            return Uri.parse(replace.replace("[CACHEBUSTING]", m8357a()).replace("[TIMESTAMP]", m8342b()));
        } catch (Throwable th) {
            C1710r m6588z = c1662k.m6588z();
            m6588z.m6318b("VastUtils", "Unable to replace macros in URL string " + str, th);
            return null;
        }
    }

    /* renamed from: a */
    public static EnumC1136d m8355a(C1129a c1129a) {
        if (m8341b(c1129a) || m8339c(c1129a)) {
            return null;
        }
        return EnumC1136d.GENERAL_WRAPPER_ERROR;
    }

    /* renamed from: a */
    private static String m8357a() {
        return Integer.toString(f255b.nextInt(89999999) + 10000000);
    }

    /* renamed from: a */
    private static String m8356a(long j) {
        if (j > 0) {
            return String.format(Locale.US, "%02d:%02d:%02d.000", Long.valueOf(TimeUnit.SECONDS.toHours(j)), Long.valueOf(TimeUnit.SECONDS.toMinutes(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % TimeUnit.MINUTES.toSeconds(1L)));
        }
        return "00:00:00.000";
    }

    /* renamed from: a */
    public static String m8354a(C1135c c1135c) {
        C1766p m6149c;
        if (c1135c != null) {
            List<C1766p> m8379b = c1135c.m8379b();
            int size = c1135c.m8379b().size();
            if (size <= 0 || (m6149c = m8379b.get(size - 1).m6149c("VASTAdTagURI")) == null) {
                return null;
            }
            return m6149c.m6150c();
        }
        throw new IllegalArgumentException("Unable to get resolution uri string for fetching the next wrapper or inline response in the chain");
    }

    /* renamed from: a */
    public static String m8350a(C1766p c1766p, String str, String str2) {
        C1766p m6151b = c1766p.m6151b(str);
        if (m6151b != null) {
            String m6150c = m6151b.m6150c();
            if (StringUtils.isValidString(m6150c)) {
                return m6150c;
            }
        }
        return str2;
    }

    /* renamed from: a */
    private static Set<C1140g> m8353a(C1135c c1135c, C1662k c1662k) {
        if (c1135c != null) {
            List<C1766p> m8379b = c1135c.m8379b();
            Set<C1140g> hashSet = new HashSet<>(m8379b.size());
            for (C1766p c1766p : m8379b) {
                C1766p m6149c = c1766p.m6149c("Wrapper");
                if (m6149c == null) {
                    m6149c = c1766p.m6149c("InLine");
                }
                hashSet = m8343a(hashSet, m6149c != null ? m6149c.m6153a("Error") : c1766p.m6153a("Error"), c1135c, c1662k);
            }
            C1710r m6588z = c1662k.m6588z();
            m6588z.m6319b("VastUtils", "Retrieved " + hashSet.size() + " top level error trackers: " + hashSet);
            return hashSet;
        }
        return null;
    }

    /* renamed from: a */
    private static Set<C1140g> m8343a(Set<C1140g> set, List<C1766p> list, C1135c c1135c, C1662k c1662k) {
        if (list != null) {
            for (C1766p c1766p : list) {
                C1140g m8360a = C1140g.m8360a(c1766p, c1135c, c1662k);
                if (m8360a != null) {
                    set.add(m8360a);
                }
            }
        }
        return set;
    }

    /* renamed from: a */
    public static void m8352a(C1135c c1135c, AppLovinAdLoadListener appLovinAdLoadListener, EnumC1136d enumC1136d, int i, C1662k c1662k) {
        if (c1662k == null) {
            throw new IllegalArgumentException("Unable to handle failure. No sdk specified.");
        }
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
        m8345a(m8353a(c1135c, c1662k), enumC1136d, c1662k);
    }

    /* renamed from: a */
    public static void m8349a(C1766p c1766p, Map<String, Set<C1140g>> map, C1135c c1135c, C1662k c1662k) {
        List<C1766p> m6153a;
        C1710r m6588z;
        String str;
        if (c1662k == null) {
            throw new IllegalArgumentException("Unable to render event trackers. No sdk specified.");
        }
        if (c1766p == null) {
            m6588z = c1662k.m6588z();
            str = "Unable to render event trackers; null node provided";
        } else if (map != null) {
            C1766p m6151b = c1766p.m6151b("TrackingEvents");
            if (m6151b == null || (m6153a = m6151b.m6153a("Tracking")) == null) {
                return;
            }
            for (C1766p c1766p2 : m6153a) {
                String str2 = c1766p2.m6152b().get("event");
                if (StringUtils.isValidString(str2)) {
                    C1140g m8360a = C1140g.m8360a(c1766p2, c1135c, c1662k);
                    if (m8360a != null) {
                        Set<C1140g> set = map.get(str2);
                        if (set != null) {
                            set.add(m8360a);
                        } else {
                            HashSet hashSet = new HashSet();
                            hashSet.add(m8360a);
                            map.put(str2, hashSet);
                        }
                    }
                } else {
                    C1710r m6588z2 = c1662k.m6588z();
                    m6588z2.m6314e("VastUtils", "Could not find event for tracking node = " + c1766p2);
                }
            }
            return;
        } else {
            m6588z = c1662k.m6588z();
            str = "Unable to render event trackers; null event trackers provided";
        }
        m6588z.m6314e("VastUtils", str);
    }

    /* renamed from: a */
    public static void m8347a(List<C1766p> list, Set<C1140g> set, C1135c c1135c, C1662k c1662k) {
        C1710r m6588z;
        String str;
        if (c1662k == null) {
            throw new IllegalArgumentException("Unable to render trackers. No sdk specified.");
        }
        if (list == null) {
            m6588z = c1662k.m6588z();
            str = "Unable to render trackers; null nodes provided";
        } else if (set != null) {
            for (C1766p c1766p : list) {
                C1140g m8360a = C1140g.m8360a(c1766p, c1135c, c1662k);
                if (m8360a != null) {
                    set.add(m8360a);
                }
            }
            return;
        } else {
            m6588z = c1662k.m6588z();
            str = "Unable to render trackers; null trackers provided";
        }
        m6588z.m6314e("VastUtils", str);
    }

    /* renamed from: a */
    public static void m8346a(Set<C1140g> set, long j, Uri uri, EnumC1136d enumC1136d, C1662k c1662k) {
        if (c1662k == null) {
            throw new IllegalArgumentException("Unable to fire trackers. No sdk specified.");
        }
        if (set == null || set.isEmpty()) {
            return;
        }
        for (C1140g c1140g : set) {
            Uri m8348a = m8348a(c1140g.m8358b(), j, uri, enumC1136d, c1662k);
            if (m8348a != null) {
                c1662k.m6668S().m6450a(C1697g.m6421o().m6410c(m8348a.toString()).m6416a(false).m6420a(), false);
            }
        }
    }

    /* renamed from: a */
    public static void m8345a(Set<C1140g> set, EnumC1136d enumC1136d, C1662k c1662k) {
        m8346a(set, -1L, (Uri) null, enumC1136d, c1662k);
    }

    /* renamed from: a */
    public static void m8344a(Set<C1140g> set, C1662k c1662k) {
        m8346a(set, -1L, (Uri) null, EnumC1136d.UNSPECIFIED, c1662k);
    }

    /* renamed from: a */
    public static boolean m8351a(C1766p c1766p) {
        if (c1766p != null) {
            return c1766p.m6149c("Wrapper") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains a wrapper response");
    }

    /* renamed from: b */
    private static String m8342b() {
        f254a.setTimeZone(TimeZone.getDefault());
        return f254a.format(new Date());
    }

    /* renamed from: b */
    public static boolean m8341b(C1129a c1129a) {
        C1143j m8414l;
        List<C1146k> m8338a;
        return (c1129a == null || (m8414l = c1129a.m8414l()) == null || (m8338a = m8414l.m8338a()) == null || m8338a.isEmpty()) ? false : true;
    }

    /* renamed from: b */
    public static boolean m8340b(C1766p c1766p) {
        if (c1766p != null) {
            return c1766p.m6149c("InLine") != null;
        }
        throw new IllegalArgumentException("Unable to check if a given XmlNode contains an inline response");
    }

    /* renamed from: c */
    public static boolean m8339c(C1129a c1129a) {
        C1134b m8412n;
        C1137e m8383b;
        if (c1129a == null || (m8412n = c1129a.m8412n()) == null || (m8383b = m8412n.m8383b()) == null) {
            return false;
        }
        return m8383b.m8366b() != null || StringUtils.isValidString(m8383b.m8365c());
    }
}

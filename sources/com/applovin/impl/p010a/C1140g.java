package com.applovin.impl.p010a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.applovin.impl.sdk.C1662k;
import com.applovin.impl.sdk.utils.C1766p;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.a.g */
/* loaded from: classes.dex */
public class C1140g {

    /* renamed from: a */
    private String f248a;

    /* renamed from: b */
    private String f249b;

    /* renamed from: c */
    private String f250c;

    /* renamed from: d */
    private long f251d = -1;

    /* renamed from: e */
    private int f252e = -1;

    private C1140g() {
    }

    /* renamed from: a */
    private static int m8359a(String str, C1135c c1135c) {
        if (TtmlNode.START.equalsIgnoreCase(str)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(str)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(str)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(str)) {
            return 75;
        }
        if ("complete".equalsIgnoreCase(str)) {
            if (c1135c != null) {
                return c1135c.m8373h();
            }
            return 95;
        }
        return -1;
    }

    /* renamed from: a */
    public static C1140g m8360a(C1766p c1766p, C1135c c1135c, C1662k c1662k) {
        TimeUnit timeUnit;
        long seconds;
        if (c1766p != null) {
            if (c1662k != null) {
                try {
                    String m6150c = c1766p.m6150c();
                    if (!StringUtils.isValidString(m6150c)) {
                        c1662k.m6588z().m6314e("VastTracker", "Unable to create tracker. Could not find URL.");
                        return null;
                    }
                    C1140g c1140g = new C1140g();
                    c1140g.f250c = m6150c;
                    c1140g.f248a = c1766p.m6152b().get("id");
                    c1140g.f249b = c1766p.m6152b().get("event");
                    c1140g.f252e = m8359a(c1140g.m8362a(), c1135c);
                    String str = c1766p.m6152b().get(TypedValues.CycleType.S_WAVE_OFFSET);
                    if (StringUtils.isValidString(str)) {
                        String trim = str.trim();
                        if (trim.contains("%")) {
                            c1140g.f252e = StringUtils.parseInt(trim.substring(0, trim.length() - 1));
                        } else if (trim.contains(":")) {
                            List<String> explode = CollectionUtils.explode(trim, ":");
                            int size = explode.size();
                            if (size > 0) {
                                long j = 0;
                                int i = size - 1;
                                for (int i2 = i; i2 >= 0; i2--) {
                                    String str2 = explode.get(i2);
                                    if (StringUtils.isNumeric(str2)) {
                                        int parseInt = Integer.parseInt(str2);
                                        if (i2 == i) {
                                            seconds = parseInt;
                                        } else {
                                            if (i2 == size - 2) {
                                                timeUnit = TimeUnit.MINUTES;
                                            } else if (i2 == size - 3) {
                                                timeUnit = TimeUnit.HOURS;
                                            }
                                            seconds = timeUnit.toSeconds(parseInt);
                                        }
                                        j += seconds;
                                    }
                                }
                                c1140g.f251d = j;
                                c1140g.f252e = -1;
                            }
                        } else {
                            c1662k.m6588z().m6314e("VastTracker", "Unable to parse time offset from rawOffsetString = " + trim);
                        }
                    }
                    return c1140g;
                } catch (Throwable th) {
                    c1662k.m6588z().m6318b("VastTracker", "Error occurred while initializing", th);
                    return null;
                }
            }
            throw new IllegalArgumentException("No sdk specified.");
        }
        throw new IllegalArgumentException("No node specified.");
    }

    /* renamed from: a */
    public String m8362a() {
        return this.f249b;
    }

    /* renamed from: a */
    public boolean m8361a(long j, int i) {
        long j2 = this.f251d;
        boolean z = j2 >= 0;
        boolean z2 = j >= j2;
        int i2 = this.f252e;
        boolean z3 = i2 >= 0;
        boolean z4 = i >= i2;
        if (z && z2) {
            return true;
        }
        return z3 && z4;
    }

    /* renamed from: b */
    public String m8358b() {
        return this.f250c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1140g) {
            C1140g c1140g = (C1140g) obj;
            if (this.f251d == c1140g.f251d && this.f252e == c1140g.f252e) {
                String str = this.f248a;
                if (str == null ? c1140g.f248a == null : str.equals(c1140g.f248a)) {
                    String str2 = this.f249b;
                    if (str2 == null ? c1140g.f249b == null : str2.equals(c1140g.f249b)) {
                        return this.f250c.equals(c1140g.f250c);
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
        String str = this.f248a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f249b;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        long j = this.f251d;
        return ((((((hashCode + hashCode2) * 31) + this.f250c.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.f252e;
    }

    public String toString() {
        return "VastTracker{identifier='" + this.f248a + "', event='" + this.f249b + "', uriString='" + this.f250c + "', offsetSeconds=" + this.f251d + ", offsetPercent=" + this.f252e + '}';
    }
}

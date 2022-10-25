package com.google.ads.interactivemedia.p034v3.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.atm */
/* loaded from: classes2.dex */
public final class atm {
    /* renamed from: a */
    public static String m4621a(String str) {
        if (atk.m4623a(str)) {
            return null;
        }
        return str;
    }

    /* renamed from: b */
    public static String m4620b(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String sb;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                sb = "null";
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
                    sb2.append(name);
                    sb2.append('@');
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", sb3.length() != 0 ? "Exception during lenientFormat for ".concat(sb3) : new String("Exception during lenientFormat for "), (Throwable) e);
                    String name2 = e.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(sb3.length() + 9 + String.valueOf(name2).length());
                    sb4.append("<");
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name2);
                    sb4.append(">");
                    sb = sb4.toString();
                }
            }
            objArr[i2] = sb;
            i2++;
        }
        StringBuilder sb5 = new StringBuilder(str.length() + (length * 16));
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (indexOf = str.indexOf("%s", i3)) == -1) {
                break;
            }
            sb5.append((CharSequence) str, i3, indexOf);
            sb5.append(objArr[i]);
            i3 = indexOf + 2;
            i++;
        }
        sb5.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb5.append(" [");
            sb5.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb5.append(", ");
                sb5.append(objArr[i4]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }

    /* renamed from: c */
    public static boolean m4619c(String str) {
        return atk.m4623a(str);
    }

    /* renamed from: d */
    public static void m4618d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: e */
    public static void m4617e(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    /* renamed from: f */
    public static void m4616f(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(m4620b(str, obj));
        }
    }

    /* renamed from: g */
    public static void m4615g(int i, int i2, int i3) {
        String m4608n;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                m4608n = m4608n(i, i3, "start index");
            } else {
                m4608n = (i2 < 0 || i2 > i3) ? m4608n(i2, i3, "end index") : m4620b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(m4608n);
        }
    }

    /* renamed from: h */
    public static void m4614h(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    /* renamed from: i */
    public static void m4613i(int i, int i2) {
        String m4620b;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                m4620b = m4620b("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
            } else if (i2 < 0) {
                StringBuilder sb = new StringBuilder(26);
                sb.append("negative size: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            } else {
                m4620b = m4620b("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(m4620b);
        }
    }

    /* renamed from: j */
    public static void m4612j(Object obj) {
        Objects.requireNonNull(obj);
    }

    /* renamed from: k */
    public static void m4611k(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException((String) obj2);
        }
    }

    /* renamed from: l */
    public static void m4610l(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(m4608n(i, i2, FirebaseAnalytics.Param.INDEX));
        }
    }

    /* renamed from: m */
    public static atj m4609m(Object obj) {
        return new atj(obj.getClass().getSimpleName());
    }

    /* renamed from: n */
    private static String m4608n(int i, int i2, String str) {
        if (i < 0) {
            return m4620b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return m4620b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }
}

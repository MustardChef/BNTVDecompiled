package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaFormat;
import android.net.Uri;
import android.os.Trace;
import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ce */
/* loaded from: classes2.dex */
public final class C2616ce {

    /* renamed from: a */
    private static volatile boolean f6934a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* bridge */ /* synthetic */ void m2692a() {
    }

    /* renamed from: b */
    public static void m2691b(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    /* renamed from: c */
    public static void m2690c(MediaFormat mediaFormat, List list) {
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap((byte[]) list.get(i)));
        }
    }

    /* renamed from: d */
    public static Object m2689d(Object obj) {
        Objects.requireNonNull(obj);
        return obj;
    }

    /* renamed from: e */
    public static Object m2688e(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException();
    }

    /* renamed from: f */
    public static void m2687f(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: g */
    public static void m2686g(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: h */
    public static void m2685h(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: i */
    public static void m2684i(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    /* renamed from: j */
    public static void m2683j(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* renamed from: k */
    public static void m2682k(InterfaceC2637cz interfaceC2637cz) {
        if (interfaceC2637cz != null) {
            try {
                interfaceC2637cz.mo1125d();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: l */
    public static boolean m2681l(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 3;
    }

    /* renamed from: m */
    public static boolean m2680m(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return m2681l(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    /* renamed from: n */
    public static boolean m2679n(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return xmlPullParser.getEventType() == 2;
    }

    /* renamed from: o */
    public static boolean m2678o(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        return m2679n(xmlPullParser) && xmlPullParser.getName().equals(str);
    }

    /* renamed from: p */
    public static String m2677p(XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (m2670w(xmlPullParser.getAttributeName(i)).equals("default_KID")) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    /* renamed from: q */
    public static boolean m2676q(XmlPullParser xmlPullParser) throws XmlPullParserException {
        return m2679n(xmlPullParser) && m2670w(xmlPullParser.getName()).equals("pssh");
    }

    /* renamed from: r */
    public static Uri m2675r(String str, String str2) {
        return Uri.parse(m2674s(str, str2));
    }

    /* renamed from: s */
    public static String m2674s(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] m2668y = m2668y(str2);
        if (m2668y[0] != -1) {
            sb.append(str2);
            m2669x(sb, m2668y[1], m2668y[2]);
            return sb.toString();
        }
        int[] m2668y2 = m2668y(str);
        if (m2668y[3] == 0) {
            sb.append((CharSequence) str, 0, m2668y2[3]);
            sb.append(str2);
            return sb.toString();
        } else if (m2668y[2] == 0) {
            sb.append((CharSequence) str, 0, m2668y2[2]);
            sb.append(str2);
            return sb.toString();
        } else if (m2668y[1] != 0) {
            int i = m2668y2[0] + 1;
            sb.append((CharSequence) str, 0, i);
            sb.append(str2);
            return m2669x(sb, m2668y[1] + i, i + m2668y[2]);
        } else if (str2.charAt(0) == '/') {
            sb.append((CharSequence) str, 0, m2668y2[1]);
            sb.append(str2);
            int i2 = m2668y2[1];
            return m2669x(sb, i2, m2668y[2] + i2);
        } else {
            int i3 = m2668y2[0];
            int i4 = m2668y2[1];
            if (i3 + 2 >= i4 || i4 != m2668y2[2]) {
                int lastIndexOf = str.lastIndexOf(47, m2668y2[2] - 1);
                int i5 = lastIndexOf == -1 ? m2668y2[1] : lastIndexOf + 1;
                sb.append((CharSequence) str, 0, i5);
                sb.append(str2);
                return m2669x(sb, m2668y2[1], i5 + m2668y[2]);
            }
            sb.append((CharSequence) str, 0, i4);
            sb.append(JsonPointer.SEPARATOR);
            sb.append(str2);
            int i6 = m2668y2[1];
            return m2669x(sb, i6, m2668y[2] + i6 + 1);
        }
    }

    /* renamed from: t */
    public static boolean m2673t(String str) {
        return (str == null || m2668y(str)[0] == -1) ? false : true;
    }

    /* renamed from: u */
    public static void m2672u(String str) {
        if (C2628cq.f6961a >= 18) {
            Trace.beginSection(str);
        }
    }

    /* renamed from: v */
    public static void m2671v() {
        if (C2628cq.f6961a >= 18) {
            Trace.endSection();
        }
    }

    /* renamed from: w */
    private static String m2670w(String str) {
        int indexOf = str.indexOf(58);
        return indexOf == -1 ? str : str.substring(indexOf + 1);
    }

    /* renamed from: x */
    private static String m2669x(StringBuilder sb, int i, int i2) {
        int i3;
        int i4;
        if (i >= i2) {
            return sb.toString();
        }
        if (sb.charAt(i) == '/') {
            i++;
        }
        int i5 = i;
        int i6 = i5;
        while (i5 <= i2) {
            if (i5 == i2) {
                i3 = i5;
            } else if (sb.charAt(i5) == '/') {
                i3 = i5 + 1;
            } else {
                i5++;
            }
            int i7 = i6 + 1;
            if (i5 != i7 || sb.charAt(i6) != '.') {
                if (i5 == i6 + 2 && sb.charAt(i6) == '.' && sb.charAt(i7) == '.') {
                    i4 = sb.lastIndexOf("/", i6 - 2) + 1;
                    int i8 = i4 > i ? i4 : i;
                    sb.delete(i8, i3);
                    i2 -= i3 - i8;
                } else {
                    i4 = i5 + 1;
                }
                i6 = i4;
            } else {
                sb.delete(i6, i3);
                i2 -= i3 - i6;
            }
            i5 = i6;
        }
        return sb.toString();
    }

    /* renamed from: y */
    private static int[] m2668y(String str) {
        int i;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i2 = indexOf4 + 2;
        if (i2 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i2) == '/') {
            i = str.indexOf(47, indexOf4 + 3);
            if (i == -1 || i > indexOf2) {
                i = indexOf2;
            }
        } else {
            i = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }
}

package com.google.ads.interactivemedia.p034v3.internal;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.blankj.utilcode.constant.TimeConstants;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.cq */
/* loaded from: classes2.dex */
public final class C2628cq {

    /* renamed from: a */
    public static final int f6961a;

    /* renamed from: b */
    public static final String f6962b;

    /* renamed from: c */
    public static final String f6963c;

    /* renamed from: d */
    public static final String f6964d;

    /* renamed from: e */
    public static final String f6965e;

    /* renamed from: f */
    public static final byte[] f6966f;

    /* renamed from: g */
    private static final Pattern f6967g;

    /* renamed from: h */
    private static final Pattern f6968h;

    /* renamed from: i */
    private static final Pattern f6969i;

    /* renamed from: j */
    private static HashMap f6970j;

    /* renamed from: k */
    private static final String[] f6971k;

    /* renamed from: l */
    private static final String[] f6972l;

    /* renamed from: m */
    private static final int[] f6973m;

    /* renamed from: n */
    private static final int[] f6974n;

    static {
        int i = Build.VERSION.SDK_INT;
        f6961a = i;
        String str = Build.DEVICE;
        f6962b = str;
        String str2 = Build.MANUFACTURER;
        f6963c = str2;
        String str3 = Build.MODEL;
        f6964d = str3;
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 17 + String.valueOf(str3).length() + String.valueOf(str2).length());
        sb.append(str);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(i);
        f6965e = sb.toString();
        f6966f = new byte[0];
        f6967g = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        f6968h = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        Pattern.compile("%([A-Fa-f0-9]{2})");
        f6969i = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
        f6971k = new String[]{"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", "sr", "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
        f6972l = new String[]{"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
        f6973m = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
        f6974n = new int[]{0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, bqk.f6597cd, 238, bqk.f6598ce, bqk.f6603cj, bqk.f6602ci, bqk.f6541bA, 245, bqk.f6555bO, bqk.f6587bu, bqk.f6553bM, bqk.f6548bH, 196, 195, 202, 205, 144, 151, 158, 153, 140, 139, 130, 133, 168, 175, 166, 161, 180, 179, 186, 189, 199, 192, 201, 206, bqk.f6557bQ, bqk.f6558bR, bqk.f6552bL, bqk.f6549bI, 255, bqk.f6595cb, 241, 246, bqk.f6543bC, bqk.f6562bV, 237, 234, 183, 176, 185, 190, 171, 172, 165, 162, 143, 136, 129, 134, 147, 148, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, 146, 155, 156, 177, 182, 191, 184, 173, 170, 163, 164, 249, 254, bqk.f6594ca, 240, bqk.f6565bY, 226, 235, bqk.f6567ba, 193, 198, 207, 200, bqk.f6559bS, bqk.f6576bj, bqk.f6550bJ, bqk.f6551bK, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, 167, 178, 181, 188, 187, 150, 145, 152, 159, 138, 141, 132, 131, 222, bqk.f6556bP, 208, bqk.f6554bN, 194, 197, 204, 203, bqk.f6596cc, bqk.f6560bT, bqk.f6526am, 239, 250, bqk.f6604ck, 244, 243};
    }

    /* renamed from: A */
    public static Handler m2582A(Handler.Callback callback) {
        Looper myLooper = Looper.myLooper();
        C2616ce.m2688e(myLooper);
        return m2509y(myLooper, callback);
    }

    /* renamed from: B */
    public static Handler m2581B() {
        return m2509y(m2580C(), null);
    }

    /* renamed from: C */
    public static Looper m2580C() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    /* renamed from: D */
    public static C2962p m2579D(int i, int i2, int i3) {
        C2935o c2935o = new C2935o();
        c2935o.m1532ae(MimeTypes.AUDIO_RAW);
        c2935o.m1556H(i2);
        c2935o.m1531af(i3);
        c2935o.m1539Y(i);
        return c2935o.m1506v();
    }

    /* renamed from: E */
    public static Object m2578E(Object obj) {
        return obj;
    }

    /* renamed from: F */
    public static String m2577F(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: G */
    public static String m2576G(byte[] bArr) {
        return new String(bArr, atg.f5038b);
    }

    /* renamed from: H */
    public static String m2575H(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, atg.f5038b);
    }

    /* renamed from: I */
    public static String m2574I(String str, int i) {
        String[] m2545ak = m2545ak(str);
        if (m2545ak.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : m2545ak) {
            if (i == C2554an.m4975b(str2)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    /* renamed from: J */
    public static String m2573J(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int length = objArr.length;
            if (i >= length) {
                return sb.toString();
            }
            sb.append(objArr[i].getClass().getSimpleName());
            if (i < length - 1) {
                sb.append(", ");
            }
            i++;
        }
    }

    /* renamed from: K */
    public static String m2572K(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return anx.m4880d(networkCountryIso);
            }
        }
        return anx.m4880d(Locale.getDefault().getCountry());
    }

    /* renamed from: L */
    public static String m2571L(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return "YES";
                        }
                        throw new IllegalStateException();
                    }
                    return "NO_EXCEEDS_CAPABILITIES";
                }
                return "NO_UNSUPPORTED_DRM";
            }
            return "NO_UNSUPPORTED_TYPE";
        }
        return "NO";
    }

    /* renamed from: M */
    public static String m2570M(Locale locale) {
        return f6961a >= 21 ? locale.toLanguageTag() : locale.toString();
    }

    /* renamed from: N */
    public static String m2569N(int i) {
        switch (i) {
            case 0:
                return MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY;
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return "text";
            case 4:
                return "image";
            case 5:
                return TtmlNode.TAG_METADATA;
            case 6:
                return "camera motion";
            default:
                return "?";
        }
    }

    /* renamed from: O */
    public static String m2568O(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals(C3282C.LANGUAGE_UNDETERMINED)) {
            str = replace;
        }
        String m4881c = anx.m4881c(str);
        int i = 0;
        String str2 = m2546aj(m4881c, "-")[0];
        if (f6970j == null) {
            f6970j = m2533aw();
        }
        String str3 = (String) f6970j.get(str2);
        if (str3 != null) {
            String valueOf = String.valueOf(m4881c.substring(str2.length()));
            m4881c = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
            str2 = str3;
        }
        if (!"no".equals(str2) && !"i".equals(str2) && !"zh".equals(str2)) {
            return m4881c;
        }
        while (true) {
            String[] strArr = f6972l;
            int length = strArr.length;
            if (i >= 18) {
                return m4881c;
            }
            if (m4881c.startsWith(strArr[i])) {
                String valueOf2 = String.valueOf(strArr[i + 1]);
                String valueOf3 = String.valueOf(m4881c.substring(strArr[i].length()));
                return valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
            }
            i += 2;
        }
    }

    /* renamed from: P */
    public static ExecutorService m2567P(final String str) {
        return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.google.ads.interactivemedia.v3.internal.cp
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, str);
            }
        });
    }

    /* renamed from: Q */
    public static void m2566Q(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: R */
    public static void m2565R(List list, int i, int i2) {
        if (i < 0 || i2 > list.size() || i > i2) {
            throw new IllegalArgumentException();
        }
        if (i != i2) {
            list.subList(i, i2).clear();
        }
    }

    /* renamed from: S */
    public static void m2564S(Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: T */
    public static boolean m2563T(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: U */
    public static boolean m2562U(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (m2563T(obj2, obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: V */
    public static boolean m2561V(int i) {
        return i == 536870912 || i == 805306368 || i == 4;
    }

    /* renamed from: W */
    public static boolean m2560W(int i) {
        return i == 3 || i == 2 || i == 268435456 || i == 536870912 || i == 805306368 || i == 4;
    }

    /* renamed from: X */
    public static boolean m2559X(int i) {
        return i == 10 || i == 13;
    }

    /* renamed from: Y */
    public static boolean m2558Y(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    /* renamed from: Z */
    public static boolean m2557Z(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    /* renamed from: a */
    public static float m2556a(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f, f3));
    }

    /* renamed from: aa */
    public static boolean m2555aa(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    /* renamed from: ab */
    public static byte[] m2554ab(String str) {
        return str.getBytes(atg.f5038b);
    }

    /* renamed from: ac */
    public static byte[] m2553ac(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* renamed from: ad */
    public static Object[] m2552ad(Object[] objArr) {
        return objArr;
    }

    /* renamed from: ae */
    public static Object[] m2551ae(Object[] objArr, Object obj) {
        int length = objArr.length;
        Object[] copyOf = Arrays.copyOf(objArr, length + 1);
        copyOf[length] = obj;
        return copyOf;
    }

    /* renamed from: af */
    public static Object[] m2550af(Object[] objArr, Object[] objArr2) {
        int length = objArr.length;
        int length2 = objArr2.length;
        Object[] copyOf = Arrays.copyOf(objArr, length + length2);
        System.arraycopy(objArr2, 0, copyOf, length, length2);
        return copyOf;
    }

    /* renamed from: ag */
    public static Object[] m2549ag(Object[] objArr, int i) {
        C2616ce.m2687f(i <= objArr.length);
        return Arrays.copyOf(objArr, i);
    }

    /* renamed from: ah */
    public static String[] m2548ah() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] m2547ai = f6961a >= 24 ? m2547ai(configuration.getLocales().toLanguageTags(), ",") : new String[]{m2570M(configuration.locale)};
        for (int i = 0; i < m2547ai.length; i++) {
            m2547ai[i] = m2568O(m2547ai[i]);
        }
        return m2547ai;
    }

    /* renamed from: ai */
    public static String[] m2547ai(String str, String str2) {
        return str.split(str2, -1);
    }

    /* renamed from: aj */
    public static String[] m2546aj(String str, String str2) {
        return str.split(str2, 2);
    }

    /* renamed from: ak */
    public static String[] m2545ak(String str) {
        return TextUtils.isEmpty(str) ? new String[0] : m2547ai(str.trim(), "(\\s*,\\s*)");
    }

    /* renamed from: al */
    public static long m2544al(long j, long j2) {
        long j3 = j + j2;
        if (((j ^ j3) & (j2 ^ j3)) < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    /* renamed from: am */
    public static int m2543am(long[] jArr, long j, boolean z) {
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        do {
            binarySearch++;
            if (binarySearch >= jArr.length) {
                break;
            }
        } while (jArr[binarySearch] == j);
        return !z ? binarySearch : binarySearch - 1;
    }

    /* renamed from: an */
    public static int m2542an(List list, Comparable comparable, boolean z) {
        int i;
        int binarySearch = Collections.binarySearch(list, comparable);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (((Comparable) list.get(binarySearch)).compareTo(comparable) == 0);
            i = binarySearch + 1;
        }
        return z ? Math.max(0, i) : i;
    }

    /* renamed from: ao */
    public static int m2541ao(int[] iArr, int i) {
        int binarySearch = Arrays.binarySearch(iArr, i);
        if (binarySearch < 0) {
            return -(binarySearch + 2);
        }
        do {
            binarySearch--;
            if (binarySearch < 0) {
                break;
            }
        } while (iArr[binarySearch] == i);
        return binarySearch;
    }

    /* renamed from: ap */
    public static int m2540ap(long[] jArr, long j, boolean z) {
        int i;
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            i = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            i = binarySearch + 1;
        }
        return z ? Math.max(0, i) : i;
    }

    /* renamed from: aq */
    public static int m2539aq(byte[] bArr, int i) {
        int i2 = -1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = f6973m[(i2 >>> 24) ^ (bArr[i3] & 255)] ^ (i2 << 8);
        }
        return i2;
    }

    /* renamed from: ar */
    public static String m2538ar(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "?";
        }
        String str2 = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder(61 + String.valueOf(str).length() + String.valueOf(str2).length());
        sb.append("IMA SDK ExoPlayer");
        sb.append("/");
        sb.append(str);
        sb.append(" (Linux;Android ");
        sb.append(str2);
        sb.append(") AndroidXMedia/1.0.0-alpha");
        return sb.toString();
    }

    /* renamed from: as */
    public static void m2537as(Handler handler, Runnable runnable) {
        if (handler.getLooper().getThread().isAlive()) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    /* renamed from: au */
    public static long m2535au(long j, long j2) {
        long j3 = j - j2;
        if (((j ^ j3) & (j2 ^ j)) < 0) {
            return Long.MIN_VALUE;
        }
        return j3;
    }

    /* renamed from: av */
    private static String m2534av(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            C2613cb.m2698a("Util", str.length() != 0 ? "Failed to read system property ".concat(str) : new String("Failed to read system property "), e);
            return null;
        }
    }

    /* renamed from: aw */
    private static HashMap m2533aw() {
        String[] iSOLanguages = Locale.getISOLanguages();
        int length = iSOLanguages.length;
        int length2 = f6971k.length;
        HashMap hashMap = new HashMap(length + 86);
        int i = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = f6971k;
            int length3 = strArr.length;
            if (i >= 86) {
                return hashMap;
            }
            hashMap.put(strArr[i], strArr[i + 1]);
            i += 2;
        }
    }

    /* renamed from: b */
    public static int m2532b(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    /* renamed from: c */
    public static int m2531c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i, i3));
    }

    /* renamed from: d */
    public static int m2530d(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return -1;
        }
        return audioManager.generateAudioSessionId();
    }

    /* renamed from: e */
    public static int m2529e(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return bqk.f6558bR;
            case 6:
                return bqk.f6603cj;
            case 7:
                return 1276;
            case 8:
                int i2 = f6961a;
                return (i2 < 23 && i2 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    /* renamed from: f */
    public static int m2528f(ByteBuffer byteBuffer, int i) {
        int i2 = byteBuffer.getInt(i);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i2 : Integer.reverseBytes(i2);
    }

    /* renamed from: g */
    public static int m2527g(String str, int i) {
        int i2 = 0;
        for (String str2 : m2545ak(str)) {
            if (i == C2554an.m4975b(str2)) {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: h */
    public static int m2526h(int i) {
        if (i == 2 || i == 4) {
            return PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION;
        }
        if (i != 10) {
            if (i != 7) {
                if (i != 8) {
                    switch (i) {
                        case 15:
                            return PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR;
                        case 16:
                        case 18:
                            return PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION;
                        case 17:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            return PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED;
                        default:
                            switch (i) {
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                    return PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED;
                                default:
                                    return PlaybackException.ERROR_CODE_DRM_SYSTEM_ERROR;
                            }
                    }
                }
                return PlaybackException.ERROR_CODE_DRM_CONTENT_ERROR;
            }
            return PlaybackException.ERROR_CODE_DRM_DISALLOWED_OPERATION;
        }
        return PlaybackException.ERROR_CODE_DRM_LICENSE_ACQUISITION_FAILED;
    }

    /* renamed from: i */
    public static int m2525i(String str) {
        String[] m2547ai;
        int length;
        int i = 0;
        if (str != null && (length = (m2547ai = m2547ai(str, "_")).length) >= 2) {
            String str2 = m2547ai[length - 1];
            boolean z = length >= 3 && "neg".equals(m2547ai[length + (-2)]);
            try {
                C2616ce.m2689d(str2);
                i = Integer.parseInt(str2);
                if (z) {
                    return -i;
                }
            } catch (NumberFormatException unused) {
            }
            return i;
        }
        return 0;
    }

    /* renamed from: j */
    public static int m2524j(int i) {
        if (i != 8) {
            if (i != 16) {
                if (i != 24) {
                    if (i != 32) {
                        return 0;
                    }
                    return C3282C.ENCODING_PCM_32BIT;
                }
                return 536870912;
            }
            return 2;
        }
        return 3;
    }

    /* renamed from: k */
    public static int m2523k(int i, int i2) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 268435456) {
                        if (i == 536870912) {
                            return i2 * 3;
                        }
                        if (i != 805306368) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
                return i2 * 4;
            }
            return i2;
        }
        return i2 + i2;
    }

    /* renamed from: l */
    public static int m2522l(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !anx.m4879e("rtsp", scheme)) {
            String path = uri.getPath();
            if (path == null) {
                return 4;
            }
            String m4881c = anx.m4881c(path);
            if (!m4881c.endsWith(".mpd")) {
                if (!m4881c.endsWith(".m3u8")) {
                    Matcher matcher = f6969i.matcher(m4881c);
                    if (!matcher.matches()) {
                        return 4;
                    }
                    String group = matcher.group(2);
                    if (group == null) {
                        return 1;
                    }
                    if (!group.contains("format=mpd-time-csf")) {
                        if (!group.contains("format=m3u8-aapl")) {
                            return 1;
                        }
                    }
                }
                return 2;
            }
            return 0;
        }
        return 3;
    }

    /* renamed from: m */
    public static int m2521m(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: n */
    public static long m2520n(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    /* renamed from: o */
    public static long m2519o(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j, j3));
    }

    /* renamed from: p */
    public static long m2518p(long j, float f) {
        return f == 1.0f ? j : Math.round(j * f);
    }

    /* renamed from: q */
    public static long m2517q(long j) {
        if (j == C3282C.TIME_UNSET) {
            return System.currentTimeMillis();
        }
        return j + SystemClock.elapsedRealtime();
    }

    /* renamed from: r */
    public static long m2516r(long j, float f) {
        return f == 1.0f ? j : Math.round(j / f);
    }

    /* renamed from: s */
    public static long m2515s(long j) {
        return (j == C3282C.TIME_UNSET || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    /* renamed from: t */
    public static long m2514t(String str) throws C2555ao {
        Matcher matcher = f6967g.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            throw C2555ao.m4866a(valueOf.length() != 0 ? "Invalid date/time format: ".concat(valueOf) : new String("Invalid date/time format: "), null);
        }
        int i = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if ("-".equals(matcher.group(11))) {
                i = -i;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            String valueOf2 = String.valueOf(matcher.group(8));
            gregorianCalendar.set(14, new BigDecimal(valueOf2.length() != 0 ? "0.".concat(valueOf2) : new String("0.")).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i != 0 ? timeInMillis - (i * TimeConstants.MIN) : timeInMillis;
    }

    /* renamed from: u */
    public static long m2513u(String str) {
        Matcher matcher = f6968h.matcher(str);
        if (matcher.matches()) {
            boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
            String group = matcher.group(3);
            double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
            String group2 = matcher.group(5);
            double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
            String group3 = matcher.group(7);
            double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
            String group4 = matcher.group(10);
            double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
            String group5 = matcher.group(12);
            double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
            String group6 = matcher.group(14);
            long parseDouble6 = (long) ((parseDouble5 + (group6 != null ? Double.parseDouble(group6) : 0.0d)) * 1000.0d);
            return isEmpty ? -parseDouble6 : parseDouble6;
        }
        return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
    }

    /* renamed from: v */
    public static long m2512v(long j, long j2, long j3) {
        int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i < 0 || j3 % j2 != 0) {
            return (i >= 0 || j2 % j3 != 0) ? (long) (j * (j2 / j3)) : j * (j2 / j3);
        }
        return j / (j3 / j2);
    }

    /* renamed from: w */
    public static long m2511w(long j) {
        return (j == C3282C.TIME_UNSET || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    /* renamed from: x */
    public static Point m2510x(Context context) {
        String m2534av;
        DisplayManager displayManager;
        int i = f6961a;
        Display display = null;
        if (i >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
            display = displayManager.getDisplay(0);
        }
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            C2616ce.m2689d(windowManager);
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && m2557Z(context)) {
            if (i < 28) {
                m2534av = m2534av("sys.display-size");
            } else {
                m2534av = m2534av("vendor.display-size");
            }
            if (!TextUtils.isEmpty(m2534av)) {
                try {
                    String[] m2547ai = m2547ai(m2534av.trim(), "x");
                    if (m2547ai.length == 2) {
                        int parseInt = Integer.parseInt(m2547ai[0]);
                        int parseInt2 = Integer.parseInt(m2547ai[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                String valueOf = String.valueOf(m2534av);
                Log.e("Util", valueOf.length() != 0 ? "Invalid display size: ".concat(valueOf) : new String("Invalid display size: "));
            }
            if ("Sony".equals(f6963c) && f6964d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
        }
        Point point = new Point();
        int i2 = f6961a;
        if (i2 >= 23) {
            Display.Mode mode = display.getMode();
            point.x = mode.getPhysicalWidth();
            point.y = mode.getPhysicalHeight();
            return point;
        } else if (i2 < 17) {
            display.getSize(point);
            return point;
        } else {
            display.getRealSize(point);
            return point;
        }
    }

    /* renamed from: y */
    public static Handler m2509y(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    /* renamed from: z */
    public static Handler m2508z() {
        return m2582A(null);
    }

    /* renamed from: at */
    public static void m2536at(long[] jArr, long j) {
        int i = 0;
        int i2 = (j > 1000000L ? 1 : (j == 1000000L ? 0 : -1));
        if (i2 >= 0 && j % 1000000 == 0) {
            long j2 = j / 1000000;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j2;
                i++;
            }
        } else if (i2 >= 0 || 1000000 % j != 0) {
            double d = 1000000.0d / j;
            while (i < jArr.length) {
                jArr[i] = (long) (jArr[i] * d);
                i++;
            }
        } else {
            long j3 = 1000000 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j3;
                i++;
            }
        }
    }
}

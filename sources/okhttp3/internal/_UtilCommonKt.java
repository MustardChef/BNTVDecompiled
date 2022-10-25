package okhttp3.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.tvprovider.media.p009tv.TvContractCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.FileSystem;
import okio.Options;
import okio.Path;

/* compiled from: -UtilCommon.kt */
@Metadata(m108d1 = {"\u0000â\u0001\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0000\u001a\u001a\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018H\u0080\bø\u0001\u0000\u001a0\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0004\b\u0000\u0010\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0000\u001a\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000fH\u0000\u001a%\u0010\"\u001a\u00020\u0011\"\u0004\b\u0000\u0010#*\b\u0012\u0004\u0012\u0002H#0$2\u0006\u0010%\u001a\u0002H#H\u0000¢\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020(*\u00020)2\u0006\u0010*\u001a\u00020(H\u0080\u0004\u001a\u0015\u0010'\u001a\u00020\u0013*\u00020(2\u0006\u0010*\u001a\u00020\u0013H\u0080\u0004\u001a\u0015\u0010'\u001a\u00020(*\u00020+2\u0006\u0010*\u001a\u00020(H\u0080\u0004\u001a\u000e\u0010,\u001a\u00020\u0011*\u00060-j\u0002`.\u001a%\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f00*\b\u0012\u0004\u0012\u00020\u000f002\u0006\u00101\u001a\u00020\u000fH\u0000¢\u0006\u0002\u00102\u001a\u0014\u00103\u001a\u00020\u0011*\u0002042\u0006\u00105\u001a\u000206H\u0000\u001a\u0014\u00107\u001a\u00020\u0011*\u0002042\u0006\u00108\u001a\u000206H\u0000\u001a&\u00109\u001a\u00020(*\u00020\u000f2\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020(2\b\b\u0002\u0010=\u001a\u00020(\u001a&\u00109\u001a\u00020(*\u00020\u000f2\u0006\u0010>\u001a\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020(2\b\b\u0002\u0010=\u001a\u00020(\u001a;\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001a\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\u0017\u0010@\u001a\u0013\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u00020 0A¢\u0006\u0002\bBH\u0080\bø\u0001\u0000\u001aC\u0010C\u001a\u00020 *\b\u0012\u0004\u0012\u00020\u000f002\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001002\u001a\u0010E\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0Fj\n\u0012\u0006\b\u0000\u0012\u00020\u000f`GH\u0000¢\u0006\u0002\u0010H\u001a7\u0010I\u001a\u00020(*\b\u0012\u0004\u0012\u00020\u000f002\u0006\u00101\u001a\u00020\u000f2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u000f0Fj\b\u0012\u0004\u0012\u00020\u000f`GH\u0000¢\u0006\u0002\u0010J\u001a\f\u0010K\u001a\u00020(*\u00020\u000fH\u0000\u001a \u0010L\u001a\u00020(*\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020(2\b\b\u0002\u0010=\u001a\u00020(H\u0000\u001a \u0010M\u001a\u00020(*\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020(2\b\b\u0002\u0010=\u001a\u00020(H\u0000\u001a\u0016\u0010N\u001a\u00020(*\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020(H\u0000\u001aG\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000f00*\b\u0012\u0004\u0012\u00020\u000f002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000f002\u001a\u0010E\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0Fj\n\u0012\u0006\b\u0000\u0012\u00020\u000f`GH\u0000¢\u0006\u0002\u0010P\u001a\u0014\u0010Q\u001a\u00020 *\u0002042\u0006\u0010R\u001a\u000206H\u0000\u001a\u001e\u0010S\u001a\u0004\u0018\u00010T*\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020(H\u0000\u001a\f\u0010Y\u001a\u00020(*\u00020;H\u0000\u001a\f\u0010Z\u001a\u00020(*\u00020[H\u0000\u001a\u0014\u0010\\\u001a\u00020(*\u00020]2\u0006\u0010\u001e\u001a\u00020)H\u0000\u001a\u0012\u0010^\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010_\u001a\u00020\u0013\u001a\u0016\u0010`\u001a\u00020(*\u0004\u0018\u00010\u000f2\u0006\u0010_\u001a\u00020(H\u0000\u001a\u001e\u0010a\u001a\u00020\u000f*\u00020\u000f2\b\b\u0002\u0010<\u001a\u00020(2\b\b\u0002\u0010=\u001a\u00020(\u001a\"\u0010b\u001a\u00020c*\u00060dj\u0002`e2\u0010\u0010f\u001a\f\u0012\b\u0012\u00060dj\u0002`e0\u001aH\u0000\u001a\u0014\u0010g\u001a\u00020\u0011*\u00020h2\u0006\u0010i\u001a\u00020(H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006j"}, m107d2 = {"EMPTY_BYTE_ARRAY", "", "UNICODE_BOMS", "Lokio/Options;", "getUNICODE_BOMS", "()Lokio/Options;", "commonEmptyHeaders", "Lokhttp3/Headers;", "getCommonEmptyHeaders", "()Lokhttp3/Headers;", "commonEmptyRequestBody", "Lokhttp3/RequestBody;", "getCommonEmptyRequestBody", "()Lokhttp3/RequestBody;", "userAgent", "", "checkOffsetAndCount", "", "arrayLength", "", TypedValues.CycleType.S_WAVE_OFFSET, "count", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "interleave", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "", "b", "isSensitiveHeader", "", "name", "addIfAbsent", ExifInterface.LONGITUDE_EAST, "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "", "mask", "", "closeQuietly", "Ljava/io/Closeable;", "Lokio/Closeable;", "concat", "", "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "deleteContents", "Lokio/FileSystem;", "directory", "Lokio/Path;", "deleteIfExists", "path", "delimiterOffset", TtmlNode.RUBY_DELIMITER, "", "startIndex", "endIndex", "delimiters", "filterList", "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hasIntersection", "other", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "file", "matchAtPolyfill", "Lkotlin/text/MatchResult;", "Lkotlin/text/Regex;", TvContractCompat.PARAM_INPUT, "", FirebaseAnalytics.Param.INDEX, "parseHexDigit", "readMedium", "Lokio/BufferedSource;", "skipAll", "Lokio/Buffer;", "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _UtilCommonKt {
    public static final byte[] EMPTY_BYTE_ARRAY;
    private static final Options UNICODE_BOMS = Options.Companion.m70of(ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000"));
    private static final Headers commonEmptyHeaders = Headers.Companion.m78of(new String[0]);
    private static final RequestBody commonEmptyRequestBody;
    public static final String userAgent = "okhttp/5.0.0-alpha.6";

    public static final int and(byte b, int i) {
        return b & i;
    }

    public static final int and(short s, int i) {
        return s & i;
    }

    public static final long and(int i, long j) {
        return i & j;
    }

    public static final int parseHexDigit(char c) {
        boolean z = true;
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        char c2 = 'a';
        if (!('a' <= c && c < 'g')) {
            c2 = 'A';
            if (!(('A' > c || c >= 'G') ? false : false)) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static final MatchResult matchAtPolyfill(Regex regex, CharSequence input, int i) {
        Intrinsics.checkNotNullParameter(regex, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        MatchResult find = regex.find(input, i);
        if (find != null && find.getRange().getFirst() == i) {
            return find;
        }
        return null;
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        commonEmptyRequestBody = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    public static final Options getUNICODE_BOMS() {
        return UNICODE_BOMS;
    }

    public static final String[] intersect(String[] strArr, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            int length2 = other.length;
            int i2 = 0;
            while (true) {
                if (i2 < length2) {
                    String str2 = other[i2];
                    i2++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    i++;
                    Iterator it = ArrayIteratorKt.iterator(strArr2);
                    while (it.hasNext()) {
                        if (comparator.compare(str, (String) it.next()) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final String[] concat(String[] strArr, String value) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[ArraysKt.getLastIndex(strArr2)] = value;
        return strArr2;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i < i2) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            if (!((((charAt == '\t' || charAt == '\n') || charAt == '\f') || charAt == '\r') || charAt == ' ')) {
                return i;
            }
            i = i3;
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i3 = i2 - 1;
        if (i <= i3) {
            while (true) {
                int i4 = i3 - 1;
                char charAt = str.charAt(i3);
                if (!((((charAt == '\t' || charAt == '\n') || charAt == '\f') || charAt == '\r') || charAt == ' ')) {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3 = i4;
            }
        }
        return i;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    public static final String trimSubstring(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i, i2);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i2));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final int delimiterOffset(String str, String delimiters, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        while (i < i2) {
            int i3 = i + 1;
            if (StringsKt.contains$default((CharSequence) delimiters, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i = i3;
        }
        return i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static final int delimiterOffset(String str, char c, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i < i2) {
            int i3 = i + 1;
            if (str.charAt(i) == c) {
                return i;
            }
            i = i3;
        }
        return i2;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0) {
                return i;
            }
            i = i2;
        }
        return -1;
    }

    public static final boolean isSensitiveHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.equals(name, "Authorization", true) || StringsKt.equals(name, HttpHeaders.COOKIE, true) || StringsKt.equals(name, HttpHeaders.PROXY_AUTHORIZATION, true) || StringsKt.equals(name, HttpHeaders.SET_COOKIE, true);
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "<this>");
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    public static final int readMedium(BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        return and(bufferedSource.readByte(), 255) | (and(bufferedSource.readByte(), 255) << 16) | (and(bufferedSource.readByte(), 255) << 8);
    }

    public static final void ignoreIoExceptions(Functions<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    public static final int skipAll(Buffer buffer, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            i++;
            buffer.readByte();
        }
        return i;
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    public static final int indexOfNonWhitespace(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt != ' ' && charAt != '\t') {
                return i;
            }
            i = i2;
        }
        return str.length();
    }

    public static final long toLongOrDefault(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int toNonNegativeInt(String str, int i) {
        Long valueOf;
        if (str == null) {
            valueOf = null;
        } else {
            try {
                valueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        if (valueOf == null) {
            return i;
        }
        long longValue = valueOf.longValue();
        if (longValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }

    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isCivilized(okio.FileSystem r4, okio.Path r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            okio.Sink r0 = r4.sink(r5)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r0
            okio.Sink r2 = (okio.Sink) r2     // Catch: java.lang.Throwable -> L1c
            r4.delete(r5)     // Catch: java.io.IOException -> L19 java.lang.Throwable -> L1c
            r4 = 1
            return r4
        L19:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L1c
            goto L20
        L1c:
            r2 = move-exception
            r3 = r2
            r2 = r1
            r1 = r3
        L20:
            if (r0 != 0) goto L23
            goto L2f
        L23:
            r0.close()     // Catch: java.lang.Throwable -> L27
            goto L2f
        L27:
            r0 = move-exception
            if (r1 != 0) goto L2c
            r1 = r0
            goto L2f
        L2c:
            kotlin.ExceptionsKt.addSuppressed(r1, r0)
        L2f:
            if (r1 != 0) goto L39
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r4.delete(r5)
            r4 = 0
            return r4
        L39:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._UtilCommonKt.isCivilized(okio.FileSystem, okio.Path):boolean");
    }

    public static final void deleteIfExists(FileSystem fileSystem, Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            fileSystem.delete(path);
        } catch (FileNotFoundException unused) {
        }
    }

    public static final void deleteContents(FileSystem fileSystem, Path directory) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            IOException iOException = null;
            for (Path path : fileSystem.list(directory)) {
                try {
                    if (fileSystem.metadata(path).isDirectory()) {
                        deleteContents(fileSystem, path);
                    }
                    fileSystem.delete(path);
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final <E> void addIfAbsent(List<E> list, E e) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.contains(e)) {
            return;
        }
        list.add(e);
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> suppressed) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(suppressed, "suppressed");
        for (Exception exc2 : suppressed) {
            ExceptionsKt.addSuppressed(exc, exc2);
        }
        return exc;
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList emptyList = CollectionsKt.emptyList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (T) it.next();
            if (predicate.invoke(obj).booleanValue()) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList();
                }
                TypeIntrinsics.asMutableList(emptyList).add(obj);
            }
        }
        return emptyList;
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("length=" + j + ", offset=" + j2 + ", count=" + j2);
        }
    }

    public static final Headers getCommonEmptyHeaders() {
        return commonEmptyHeaders;
    }

    public static final RequestBody getCommonEmptyRequestBody() {
        return commonEmptyRequestBody;
    }

    public static final <T> List<T> interleave(Iterable<? extends T> a, Iterable<? extends T> b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Iterator<? extends T> it = a.iterator();
        Iterator<? extends T> it2 = b.iterator();
        List createListBuilder = CollectionsKt.createListBuilder();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                return CollectionsKt.build(createListBuilder);
            }
            if (it.hasNext()) {
                createListBuilder.add(it.next());
            }
            if (it2.hasNext()) {
                createListBuilder.add(it2.next());
            }
        }
    }

    public static final int indexOf(String[] strArr, String value, Comparator<String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (comparator.compare(strArr[i], value) == 0) {
                return i;
            }
            i = i2;
        }
        return -1;
    }
}

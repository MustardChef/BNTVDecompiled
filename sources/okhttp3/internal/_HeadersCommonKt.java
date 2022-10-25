package okhttp3.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.progressionUtil;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.Headers;

/* compiled from: -HeadersCommon.kt */
@Metadata(m108d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001H\u0000¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0007*\u00020\u0011H\u0000\u001a\u0016\u0010\u0016\u001a\u00020\u0017*\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000\u001a\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0001*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u0007H\u0000\u001a\u001e\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001f0\u001e*\u00020\u0007H\u0000\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0000\u001a\f\u0010\"\u001a\u00020\u0011*\u00020\u0007H\u0000\u001a\u0014\u0010#\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u001c\u0010$\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0018\u0010%\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010&H\u0000\u001a\f\u0010'\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\u0014\u0010(\u001a\u00020\u0001*\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0000\u001a\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010**\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¨\u0006+"}, m107d2 = {"commonHeadersGet", "", "namesAndValues", "", "name", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "commonHeadersOf", "Lokhttp3/Headers;", "inputNamesAndValues", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersCheckName", "", "headersCheckValue", "value", "charCode", "", "commonAdd", "Lokhttp3/Headers$Builder;", "commonAddAll", "headers", "commonAddLenient", "commonBuild", "commonEquals", "", "other", "", "commonGet", "commonHashCode", "", "commonIterator", "", "Lkotlin/Pair;", "commonName", FirebaseAnalytics.Param.INDEX, "commonNewBuilder", "commonRemoveAll", "commonSet", "commonToHeaders", "", "commonToString", "commonValue", "commonValues", "", "okhttp"}, m106k = 2, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class _HeadersCommonKt {
    public static final String commonName(Headers headers, int i) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        String str = (String) ArraysKt.getOrNull(headers.getNamesAndValues$okhttp(), i * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i + ']');
    }

    public static final String commonValue(Headers headers, int i) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        String str = (String) ArraysKt.getOrNull(headers.getNamesAndValues$okhttp(), (i * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i + ']');
    }

    public static final List<String> commonValues(Headers headers, String name) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int size = headers.size();
        int i = 0;
        ArrayList arrayList = null;
        while (i < size) {
            int i2 = i + 1;
            if (StringsKt.equals(name, headers.name(i), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i));
            }
            i = i2;
        }
        List<String> list = arrayList != null ? CollectionsKt.toList(arrayList) : null;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final Iterator<Tuples<String, String>> commonIterator(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        int size = headers.size();
        Tuples[] tuplesArr = new Tuples[size];
        for (int i = 0; i < size; i++) {
            tuplesArr[i] = TuplesKt.m100to(headers.name(i), headers.value(i));
        }
        return ArrayIteratorKt.iterator(tuplesArr);
    }

    public static final Headers.Builder commonNewBuilder(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Headers.Builder builder = new Headers.Builder();
        CollectionsKt.addAll(builder.getNamesAndValues$okhttp(), headers.getNamesAndValues$okhttp());
        return builder;
    }

    public static final boolean commonEquals(Headers headers, Object obj) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        return (obj instanceof Headers) && Arrays.equals(headers.getNamesAndValues$okhttp(), ((Headers) obj).getNamesAndValues$okhttp());
    }

    public static final int commonHashCode(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        return Arrays.hashCode(headers.getNamesAndValues$okhttp());
    }

    public static final String commonToString(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            String name = headers.name(i);
            String value = headers.value(i);
            sb.append(name);
            sb.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
            i = i2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String commonHeadersGet(String[] namesAndValues, String name) {
        Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = namesAndValues.length - 2;
        int progressionLastElement = progressionUtil.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement > length) {
            return null;
        }
        while (true) {
            int i = length - 2;
            if (StringsKt.equals(name, namesAndValues[length], true)) {
                return namesAndValues[length + 1];
            }
            if (length == progressionLastElement) {
                return null;
            }
            length = i;
        }
    }

    public static final Headers.Builder commonAdd(Headers.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        commonAddLenient(builder, name, value);
        return builder;
    }

    public static final Headers.Builder commonAddAll(Headers.Builder builder, Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            commonAddLenient(builder, headers.name(i), headers.value(i));
        }
        return builder;
    }

    public static final Headers.Builder commonAddLenient(Headers.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.getNamesAndValues$okhttp().add(name);
        builder.getNamesAndValues$okhttp().add(StringsKt.trim((CharSequence) value).toString());
        return builder;
    }

    public static final Headers.Builder commonRemoveAll(Headers.Builder builder, String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int i = 0;
        while (i < builder.getNamesAndValues$okhttp().size()) {
            if (StringsKt.equals(name, builder.getNamesAndValues$okhttp().get(i), true)) {
                builder.getNamesAndValues$okhttp().remove(i);
                builder.getNamesAndValues$okhttp().remove(i);
                i -= 2;
            }
            i += 2;
        }
        return builder;
    }

    public static final Headers.Builder commonSet(Headers.Builder builder, String name, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        builder.removeAll(name);
        commonAddLenient(builder, name, value);
        return builder;
    }

    public static final String commonGet(Headers.Builder builder, String name) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int size = builder.getNamesAndValues$okhttp().size() - 2;
        int progressionLastElement = progressionUtil.getProgressionLastElement(size, 0, -2);
        if (progressionLastElement > size) {
            return null;
        }
        while (true) {
            int i = size - 2;
            if (StringsKt.equals(name, builder.getNamesAndValues$okhttp().get(size), true)) {
                return builder.getNamesAndValues$okhttp().get(size + 1);
            }
            if (size == progressionLastElement) {
                return null;
            }
            size = i;
        }
    }

    public static final Headers commonBuild(Headers.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Object[] array = builder.getNamesAndValues$okhttp().toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new Headers((String[]) array);
    }

    public static final void headersCheckName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(name.length() > 0)) {
            throw new IllegalArgumentException("name is empty".toString());
        }
        int length = name.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = name.charAt(i);
            if (!('!' <= charAt && charAt < 127)) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(charAt) + " at " + i + " in header name: " + name).toString());
            }
            i = i2;
        }
    }

    public static final void headersCheckValue(String value, String name) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = value.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = value.charAt(i);
            boolean z = true;
            if (charAt != '\t') {
                if (!(' ' <= charAt && charAt < 127)) {
                    z = false;
                }
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected char 0x");
                sb.append(charCode(charAt));
                sb.append(" at ");
                sb.append(i);
                sb.append(" in ");
                sb.append(name);
                sb.append(" value");
                sb.append(_UtilCommonKt.isSensitiveHeader(name) ? "" : Intrinsics.stringPlus(": ", value));
                throw new IllegalArgumentException(sb.toString().toString());
            }
            i = i2;
        }
    }

    private static final String charCode(char c) {
        String num = Integer.toString(c, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        return num.length() < 2 ? Intrinsics.stringPlus("0", num) : num;
    }

    public static final Headers commonHeadersOf(String... inputNamesAndValues) {
        Intrinsics.checkNotNullParameter(inputNamesAndValues, "inputNamesAndValues");
        int i = 0;
        if (!(inputNamesAndValues.length % 2 == 0)) {
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
        String[] strArr = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!(strArr[i2] != null)) {
                throw new IllegalArgumentException("Headers cannot be null".toString());
            }
            strArr[i2] = StringsKt.trim((CharSequence) inputNamesAndValues[i2]).toString();
            i2 = i3;
        }
        int progressionLastElement = progressionUtil.getProgressionLastElement(0, strArr.length - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                int i4 = i + 2;
                String str = strArr[i];
                String str2 = strArr[i + 1];
                headersCheckName(str);
                headersCheckValue(str2, str);
                if (i == progressionLastElement) {
                    break;
                }
                i = i4;
            }
        }
        return new Headers(strArr);
    }

    public static final Headers commonToHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String[] strArr = new String[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String obj = StringsKt.trim((CharSequence) entry.getKey()).toString();
            String obj2 = StringsKt.trim((CharSequence) entry.getValue()).toString();
            headersCheckName(obj);
            headersCheckValue(obj2, obj);
            strArr[i] = obj;
            strArr[i + 1] = obj2;
            i += 2;
        }
        return new Headers(strArr);
    }
}

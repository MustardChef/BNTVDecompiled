package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: JsUnpacker.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/JsUnpacker;", "", "packedJS", "", "(Ljava/lang/String;)V", "detect", "", "unpack", "Companion", "Unbase", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class JsUnpacker {
    public static final Companion Companion = new Companion(null);

    /* renamed from: c */
    private static final List<Integer> f10027c = CollectionsKt.listOf((Object[]) new Integer[]{99, 111, 109, 46, 103, 111, 111, 103, 108, 101, 46, 97, 110, 100, 114, 111, 105, 100, 46, 103, 109, 115, 46, 97, 100, 115, 46, 77, 111, 98, 105, 108, 101, 65, 100, 115});

    /* renamed from: z */
    private static final List<Integer> f10028z = CollectionsKt.listOf((Object[]) new Integer[]{99, 111, 109, 46, 102, 97, 99, 101, 98, 111, 111, 107, 46, 97, 100, 115, 46, 65, 100});
    private String packedJS;

    public JsUnpacker(String str) {
        this.packedJS = str;
    }

    public final boolean detect() {
        String str = this.packedJS;
        Intrinsics.checkNotNull(str);
        return Pattern.compile("eval\\(function\\(p,a,c,k,e,[rd]").matcher(StringsKt.replace$default(str, " ", "", false, 4, (Object) null)).find();
    }

    public final String unpack() {
        int i;
        try {
            Matcher matcher = Pattern.compile("\\}\\s*\\('(.*)',\\s*(.*?),\\s*(\\d+),\\s*'(.*?)'\\.split\\('\\|'\\)", 32).matcher(this.packedJS);
            if (matcher.find() && matcher.groupCount() == 4) {
                String group = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(group, "m.group(1)");
                String replace$default = StringsKt.replace$default(group, "\\'", "'", false, 4, (Object) null);
                String radixStr = matcher.group(2);
                String countStr = matcher.group(3);
                String group2 = matcher.group(4);
                Intrinsics.checkNotNullExpressionValue(group2, "m.group(4)");
                Object[] array = new Regex("\\|").split(group2, 0).toArray(new String[0]);
                if (array != null) {
                    String[] strArr = (String[]) array;
                    int i2 = 36;
                    try {
                        Intrinsics.checkNotNullExpressionValue(radixStr, "radixStr");
                        i2 = Integer.parseInt(radixStr);
                    } catch (Exception unused) {
                    }
                    try {
                        Intrinsics.checkNotNullExpressionValue(countStr, "countStr");
                        i = Integer.parseInt(countStr);
                    } catch (Exception unused2) {
                        i = 0;
                    }
                    if (strArr.length != i) {
                        throw new Exception("Unknown p.a.c.k.e.r. encoding");
                    }
                    Unbase unbase = new Unbase(i2);
                    Matcher matcher2 = Pattern.compile("\\b\\w+\\b").matcher(replace$default);
                    StringBuilder sb = new StringBuilder(replace$default);
                    int i3 = 0;
                    while (matcher2.find()) {
                        String word = matcher2.group(0);
                        Intrinsics.checkNotNullExpressionValue(word, "word");
                        int unbase2 = unbase.unbase(word);
                        String str = (unbase2 >= strArr.length || unbase2 < 0) ? null : strArr[unbase2];
                        if (str != null) {
                            if (str.length() > 0) {
                                sb.replace(matcher2.start() + i3, matcher2.end() + i3, str);
                                i3 += str.length() - word.length();
                            }
                        }
                    }
                    return sb.toString();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        } catch (Exception e) {
            ArchComponentExt.logError(e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsUnpacker.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/JsUnpacker$Unbase;", "", "radix", "", "(Lcom/lagradost/cloudstream3/utils/JsUnpacker;I)V", "ALPHABET_62", "", "ALPHABET_95", "alphabet", "dictionary", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "unbase", "str", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public final class Unbase {
        private final String ALPHABET_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private final String ALPHABET_95 = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        private String alphabet;
        private HashMap<String, Integer> dictionary;
        private final int radix;

        public Unbase(int i) {
            this.radix = i;
            if (i > 36) {
                int i2 = 0;
                if (i < 62) {
                    String substring = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(0, i);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    this.alphabet = substring;
                } else {
                    if (63 <= i && i < 95) {
                        String substring2 = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".substring(0, i);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        this.alphabet = substring2;
                    } else if (i == 62) {
                        this.alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    } else if (i == 95) {
                        this.alphabet = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
                    }
                }
                this.dictionary = new HashMap<>(95);
                String str = this.alphabet;
                Intrinsics.checkNotNull(str);
                int length = str.length();
                while (i2 < length) {
                    Integer valueOf = Integer.valueOf(i2);
                    HashMap<String, Integer> hashMap = this.dictionary;
                    Intrinsics.checkNotNull(hashMap);
                    String str2 = this.alphabet;
                    Intrinsics.checkNotNull(str2);
                    int i3 = i2 + 1;
                    String substring3 = str2.substring(i2, i3);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    hashMap.put(substring3, valueOf);
                    i2 = i3;
                }
            }
        }

        public final int unbase(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            if (this.alphabet == null) {
                return Integer.parseInt(str, CharsKt.checkRadix(this.radix));
            }
            String sb = new StringBuilder(str).reverse().toString();
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder(str).reverse().toString()");
            int length = sb.length();
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                double pow = Math.pow(this.radix, i2);
                HashMap<String, Integer> hashMap = this.dictionary;
                Intrinsics.checkNotNull(hashMap);
                int i3 = i2 + 1;
                String substring = sb.substring(i2, i3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                Integer num = hashMap.get(substring);
                Intrinsics.checkNotNull(num);
                i += (int) (pow * num.doubleValue());
                i2 = i3;
            }
            return i;
        }
    }

    /* compiled from: JsUnpacker.kt */
    @Metadata(m108d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/JsUnpacker$Companion;", "", "()V", "c", "", "", "getC", "()Ljava/util/List;", "z", "getZ", "load", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Integer> getC() {
            return JsUnpacker.f10027c;
        }

        public final List<Integer> getZ() {
            return JsUnpacker.f10028z;
        }

        public final String load(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                try {
                    int size = getC().size();
                    for (int i = 0; i < size; i++) {
                        str = getC().get(i % 4).intValue() > 270 ? str + getC().get(i % 3).intValue() : str + ((char) getC().get(i).intValue());
                    }
                    String substring = str.substring(str.length() - getC().size(), str.length());
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return Class.forName(substring).getName();
                } catch (Exception unused) {
                    String valueOf = String.valueOf((char) getC().get(2).intValue());
                    for (int i2 = 0; i2 < getZ().size(); i2++) {
                        valueOf = valueOf + ((char) getZ().get(i2).intValue());
                    }
                    String substring2 = valueOf.substring(1, valueOf.length());
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    return Class.forName(substring2).getName();
                }
            } catch (Exception unused2) {
                return (String) null;
            }
        }
    }
}

package com.lagradost.cloudstream3.utils;

import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.concurrent.Thread;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: FillerEpisodeCheck.kt */
@Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J'\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\u00020\u000e*\u00020\u000eH\u0002J\f\u0010\u0015\u001a\u00020\u0004*\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/FillerEpisodeCheck;", "", "()V", "MAIN_URL", "", "list", "Ljava/util/HashMap;", "getList", "()Ljava/util/HashMap;", "setList", "(Ljava/util/HashMap;)V", "fixName", "name", "getFillerEpisodes", "", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFillerList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calc", "toClassDir", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public final class FillerEpisodeCheck {
    public static final FillerEpisodeCheck INSTANCE = new FillerEpisodeCheck();
    private static final String MAIN_URL = "https://www.animefillerlist.com";
    private static HashMap<String, String> list;

    private FillerEpisodeCheck() {
    }

    public final HashMap<String, String> getList() {
        return list;
    }

    public final void setList(HashMap<String, String> hashMap) {
        list = hashMap;
    }

    private final String fixName(String str) {
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = str.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return new Regex("[^a-zA-Z0-9 ]").replace(StringsKt.replace$default(lowerCase, "-", " ", false, 4, (Object) null), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(14:1|(2:3|(11:5|6|7|(1:(3:10|11|12)(2:76|77))(2:78|(2:80|81)(2:82|(1:84)(1:85)))|13|(7:16|17|18|19|(4:21|22|(1:24)(1:62)|(1:61)(5:26|27|(2:32|(4:34|35|(1:37)|(4:43|44|(3:46|(2:53|54)|52)|56)(3:39|40|41))(3:57|58|59))|60|(0)(0)))(1:63)|42|14)|69|70|(2:72|73)|66|67))|88|6|7|(0)(0)|13|(1:14)|69|70|(0)|66|67|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014b, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x014c, code lost:
        r11 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0 A[Catch: Exception -> 0x014b, TRY_LEAVE, TryCatch #0 {Exception -> 0x014b, blocks: (B:12:0x0031, B:24:0x0081, B:25:0x009a, B:27:0x00a0, B:20:0x004b), top: B:70:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0142 A[Catch: Exception -> 0x0149, TRY_LEAVE, TryCatch #1 {Exception -> 0x0149, blocks: (B:29:0x00c8, B:31:0x00ce, B:36:0x00e0, B:38:0x00e5, B:45:0x00f2, B:47:0x0102, B:49:0x0108, B:51:0x010f, B:53:0x0115, B:56:0x011c, B:57:0x0129, B:58:0x012c, B:59:0x013b, B:61:0x0142), top: B:72:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getFillerList(kotlin.coroutines.Continuation<? super java.lang.Boolean> r24) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.FillerEpisodeCheck.getFillerList(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String toClassDir(String str) {
        if (str == null) {
            str = "null";
        }
        int calc = calc(RangesKt.random(new IntRange(6, 10), Random.Default));
        return str + "cache" + calc;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fb A[Catch: Exception -> 0x0035, TryCatch #1 {Exception -> 0x0035, blocks: (B:12:0x002e, B:19:0x004a, B:26:0x0066, B:29:0x006f, B:32:0x0074, B:35:0x00fb, B:37:0x0104, B:40:0x0113, B:22:0x0056), top: B:77:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0166 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0167 A[Catch: Exception -> 0x01cb, TryCatch #0 {Exception -> 0x01cb, blocks: (B:46:0x015a, B:49:0x0167, B:50:0x017d, B:52:0x0183, B:54:0x0191, B:56:0x0198, B:58:0x01a6, B:60:0x01ac, B:66:0x01bf, B:42:0x0152), top: B:75:0x0152 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getFillerEpisodes(java.lang.String r33, kotlin.coroutines.Continuation<? super java.util.HashMap<java.lang.Integer, java.lang.Boolean>> r34) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.FillerEpisodeCheck.getFillerEpisodes(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int calc(int i) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 10;
        Thread.thread((r12 & 1) != 0, (r12 & 2) != 0 ? false : false, (r12 & 4) != 0 ? null : null, (r12 & 8) != 0 ? null : null, (r12 & 16) != 0 ? -1 : 0, new FillerEpisodeCheck$calc$1(i, intRef));
        return intRef.element;
    }
}

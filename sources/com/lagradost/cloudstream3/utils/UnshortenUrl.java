package com.lagradost.cloudstream3.utils;

import com.facebook.share.internal.ShareConstants;
import com.lagradost.cloudstream3.MainAPIKt;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(m108d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u0019\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0019\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/ShortLink;", "", "()V", "adflyRegex", "", "davisonbarkerRegex", "linksafeRegex", "linkupRegex", "nuovoIndirizzoRegex", "nuovoLinkRegex", "shortList", "", "Lcom/lagradost/cloudstream3/utils/ShortLink$ShortUrl;", "uprotRegex", "isShortLink", "", "url", "unshorten", ShareConstants.MEDIA_URI, "type", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unshortenAdfly", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unshortenDavisonbarker", "unshortenLinksafe", "unshortenLinkup", "unshortenNuovoIndirizzo", "unshortenNuovoLink", "unshortenUprot", "ShortUrl", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.utils.ShortLink */
/* loaded from: classes4.dex */
public final class UnshortenUrl {
    public static final UnshortenUrl INSTANCE;
    private static final String adflyRegex;
    private static final String davisonbarkerRegex;
    private static final String linksafeRegex;
    private static final String linkupRegex;
    private static final String nuovoIndirizzoRegex;
    private static final String nuovoLinkRegex;
    private static final List<ShortUrl> shortList;
    private static final String uprotRegex;

    /* compiled from: UnshortenUrl.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B>\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006ø\u0001\u0000¢\u0006\u0002\u0010\bB<\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006ø\u0001\u0000¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\tHÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J-\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003ø\u0001\u0000¢\u0006\u0002\u0010\fJK\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\u00032$\b\u0002\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R2\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006ø\u0001\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/ShortLink$ShortUrl;", "", "regex", "", "type", "function", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/text/Regex;", "(Lkotlin/text/Regex;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getFunction", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getRegex", "()Lkotlin/text/Regex;", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Lkotlin/text/Regex;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)Lcom/lagradost/cloudstream3/utils/ShortLink$ShortUrl;", "equals", "", "other", "hashCode", "", "toString", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.utils.ShortLink$ShortUrl */
    /* loaded from: classes4.dex */
    public static final class ShortUrl {
        private final Function2<String, Continuation<? super String>, Object> function;
        private final Regex regex;
        private final String type;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShortUrl copy$default(ShortUrl shortUrl, Regex regex, String str, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                regex = shortUrl.regex;
            }
            if ((i & 2) != 0) {
                str = shortUrl.type;
            }
            if ((i & 4) != 0) {
                function2 = shortUrl.function;
            }
            return shortUrl.copy(regex, str, function2);
        }

        public final Regex component1() {
            return this.regex;
        }

        public final String component2() {
            return this.type;
        }

        public final Function2<String, Continuation<? super String>, Object> component3() {
            return this.function;
        }

        public final ShortUrl copy(Regex regex, String type, Function2<? super String, ? super Continuation<? super String>, ? extends Object> function) {
            Intrinsics.checkNotNullParameter(regex, "regex");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(function, "function");
            return new ShortUrl(regex, type, function);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShortUrl) {
                ShortUrl shortUrl = (ShortUrl) obj;
                return Intrinsics.areEqual(this.regex, shortUrl.regex) && Intrinsics.areEqual(this.type, shortUrl.type) && Intrinsics.areEqual(this.function, shortUrl.function);
            }
            return false;
        }

        public int hashCode() {
            return (((this.regex.hashCode() * 31) + this.type.hashCode()) * 31) + this.function.hashCode();
        }

        public String toString() {
            return "ShortUrl(regex=" + this.regex + ", type=" + this.type + ", function=" + this.function + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ShortUrl(Regex regex, String type, Function2<? super String, ? super Continuation<? super String>, ? extends Object> function) {
            Intrinsics.checkNotNullParameter(regex, "regex");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(function, "function");
            this.regex = regex;
            this.type = type;
            this.function = function;
        }

        public final Regex getRegex() {
            return this.regex;
        }

        public final String getType() {
            return this.type;
        }

        public final Function2<String, Continuation<? super String>, Object> getFunction() {
            return this.function;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ShortUrl(String regex, String type, Function2<? super String, ? super Continuation<? super String>, ? extends Object> function) {
            this(new Regex(regex), type, function);
            Intrinsics.checkNotNullParameter(regex, "regex");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(function, "function");
        }
    }

    private UnshortenUrl() {
    }

    static {
        UnshortenUrl unshortenUrl = new UnshortenUrl();
        INSTANCE = unshortenUrl;
        adflyRegex = "adf\\.ly|j\\.gs|q\\.gs|u\\.bb|ay\\.gy|atominik\\.com|tinyium\\.com|microify\\.com|threadsphere\\.bid|clearload\\.bid|activetect\\.net|swiftviz\\.net|briskgram\\.net|activetect\\.net|stoodsef\\.com|baymaleti\\.net|thouth\\.net|uclaut\\.net|gloyah\\.net|larati\\.net|scuseami\\.net";
        linkupRegex = "linkup\\.pro|buckler.link";
        linksafeRegex = "linksafe\\.cc";
        nuovoIndirizzoRegex = "mixdrop\\.nuovoindirizzo\\.com";
        nuovoLinkRegex = "nuovolink\\.com";
        uprotRegex = "uprot\\.net";
        davisonbarkerRegex = "davisonbarker\\.pro|lowrihouston\\.pro";
        shortList = CollectionsKt.listOf((Object[]) new ShortUrl[]{new ShortUrl("adf\\.ly|j\\.gs|q\\.gs|u\\.bb|ay\\.gy|atominik\\.com|tinyium\\.com|microify\\.com|threadsphere\\.bid|clearload\\.bid|activetect\\.net|swiftviz\\.net|briskgram\\.net|activetect\\.net|stoodsef\\.com|baymaleti\\.net|thouth\\.net|uclaut\\.net|gloyah\\.net|larati\\.net|scuseami\\.net", "adfly", new ShortLink$shortList$1(unshortenUrl)), new ShortUrl("linkup\\.pro|buckler.link", "linkup", new ShortLink$shortList$2(unshortenUrl)), new ShortUrl("linksafe\\.cc", "linksafe", new ShortLink$shortList$3(unshortenUrl)), new ShortUrl("mixdrop\\.nuovoindirizzo\\.com", "nuovoindirizzo", new ShortLink$shortList$4(unshortenUrl)), new ShortUrl("nuovolink\\.com", "nuovolink", new ShortLink$shortList$5(unshortenUrl)), new ShortUrl("uprot\\.net", "uprot", new ShortLink$shortList$6(unshortenUrl)), new ShortUrl("davisonbarker\\.pro|lowrihouston\\.pro", "uprot", new ShortLink$shortList$7(unshortenUrl))});
    }

    public final boolean isShortLink(String url) {
        boolean z;
        Intrinsics.checkNotNullParameter(url, "url");
        List<ShortUrl> list = shortList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (ShortUrl shortUrl : list) {
                if (Regex.find$default(shortUrl.getRegex(), url, 0, 2, null) != null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ Object unshorten$default(UnshortenUrl unshortenUrl, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return unshortenUrl.unshorten(str, str2, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00cc  */
    /* JADX WARN: Type inference failed for: r15v7, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x00b1 -> B:86:0x00b5). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object unshorten(java.lang.String r13, java.lang.String r14, kotlin.coroutines.Continuation<? super java.lang.String> r15) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.UnshortenUrl.unshorten(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x029a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object unshortenAdfly(java.lang.String r20, kotlin.coroutines.Continuation<? super java.lang.String> r21) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.UnshortenUrl.unshortenAdfly(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object unshortenLinkup(java.lang.String r24, kotlin.coroutines.Continuation<? super java.lang.String> r25) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.UnshortenUrl.unshortenLinkup(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String unshortenLinksafe(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return MainAPIKt.base64Decode((String) CollectionsKt.last((List<? extends Object>) StringsKt.split$default((CharSequence) uri, new String[]{"?url="}, false, 0, 6, (Object) null)));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0085 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object unshortenNuovoIndirizzo(java.lang.String r21, kotlin.coroutines.Continuation<? super java.lang.String> r22) {
        /*
            r20 = this;
            r0 = r22
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoIndirizzo$1
            if (r1 == 0) goto L18
            r1 = r0
            com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoIndirizzo$1 r1 = (com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoIndirizzo$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r20
            goto L1f
        L18:
            com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoIndirizzo$1 r1 = new com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoIndirizzo$1
            r2 = r20
            r1.<init>(r2, r0)
        L1f:
            java.lang.Object r0 = r1.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L38
            if (r3 != r4) goto L30
            kotlin.ResultKt.throwOnFailure(r0)
            goto L63
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            kotlin.ResultKt.throwOnFailure(r0)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r0 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r0
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 1
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r0 = 0
            r17 = 2014(0x7de, float:2.822E-42)
            r18 = 0
            r1.label = r4
            r4 = r21
            r19 = r15
            r15 = r0
            r16 = r1
            java.lang.Object r0 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            r1 = r19
            if (r0 != r1) goto L63
            return r1
        L63:
            com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
            okhttp3.Headers r1 = r0.getHeaders()
            java.lang.String r3 = "refresh"
            java.lang.String r1 = r1.get(r3)
            if (r1 == 0) goto L85
            okhttp3.Headers r0 = r0.getHeaders()
            java.lang.String r0 = r0.get(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r1 = 2
            java.lang.String r3 = "="
            r4 = 0
            java.lang.String r0 = kotlin.text.StringsKt.substringAfter$default(r0, r3, r4, r1, r4)
            goto L87
        L85:
            java.lang.String r0 = "non trovato"
        L87:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.UnshortenUrl.unshortenNuovoIndirizzo(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object unshortenNuovoLink(java.lang.String r21, kotlin.coroutines.Continuation<? super java.lang.String> r22) {
        /*
            r20 = this;
            r0 = r22
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoLink$1
            if (r1 == 0) goto L18
            r1 = r0
            com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoLink$1 r1 = (com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoLink$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r20
            goto L1f
        L18:
            com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoLink$1 r1 = new com.lagradost.cloudstream3.utils.ShortLink$unshortenNuovoLink$1
            r2 = r20
            r1.<init>(r2, r0)
        L1f:
            java.lang.Object r0 = r1.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L38
            if (r3 != r4) goto L30
            kotlin.ResultKt.throwOnFailure(r0)
            goto L63
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            kotlin.ResultKt.throwOnFailure(r0)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r0 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r0
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 1
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r0 = 0
            r17 = 2014(0x7de, float:2.822E-42)
            r18 = 0
            r1.label = r4
            r4 = r21
            r19 = r15
            r15 = r0
            r16 = r1
            java.lang.Object r0 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            r1 = r19
            if (r0 != r1) goto L63
            return r1
        L63:
            com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
            org.jsoup.nodes.Document r0 = r0.getDocument()
            java.lang.String r1 = "a"
            org.jsoup.nodes.Element r0 = r0.selectFirst(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r1 = "href"
            java.lang.String r0 = r0.attr(r1)
            java.lang.String r1 = "app.get(uri, allowRedire…First(\"a\")!!.attr(\"href\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.UnshortenUrl.unshortenNuovoLink(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object unshortenUprot(java.lang.String r22, kotlin.coroutines.Continuation<? super java.lang.String> r23) {
        /*
            r21 = this;
            r0 = r23
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.utils.ShortLink$unshortenUprot$1
            if (r1 == 0) goto L18
            r1 = r0
            com.lagradost.cloudstream3.utils.ShortLink$unshortenUprot$1 r1 = (com.lagradost.cloudstream3.utils.ShortLink$unshortenUprot$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r21
            goto L1f
        L18:
            com.lagradost.cloudstream3.utils.ShortLink$unshortenUprot$1 r1 = new com.lagradost.cloudstream3.utils.ShortLink$unshortenUprot$1
            r2 = r21
            r1.<init>(r2, r0)
        L1f:
            java.lang.Object r0 = r1.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L41
            if (r3 != r4) goto L39
            java.lang.Object r1 = r1.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r0)
            r20 = r1
            r1 = r0
            r0 = r20
            goto L6f
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.ResultKt.throwOnFailure(r0)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r0 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r0
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r17 = 2046(0x7fe, float:2.867E-42)
            r18 = 0
            r0 = r22
            r1.L$0 = r0
            r1.label = r4
            r4 = r22
            r19 = r15
            r15 = 0
            r16 = r1
            java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            r3 = r19
            if (r1 != r3) goto L6f
            return r3
        L6f:
            com.lagradost.nicehttp.NiceResponse r1 = (com.lagradost.nicehttp.NiceResponse) r1
            java.lang.String r1 = r1.getText()
            kotlin.text.Regex r3 = new kotlin.text.Regex
            java.lang.String r4 = "<a[^>]+href=\"([^\"]+)"
            r3.<init>(r4)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4 = 0
            r5 = 2
            r6 = 0
            kotlin.sequences.Sequence r1 = kotlin.text.Regex.findAll$default(r3, r1, r4, r5, r6)
            com.lagradost.cloudstream3.utils.ShortLink$unshortenUprot$2 r3 = com.lagradost.cloudstream3.utils.ShortLink$unshortenUprot$2.INSTANCE
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            kotlin.sequences.Sequence r1 = kotlin.sequences.SequencesKt.map(r1, r3)
            java.util.List r1 = kotlin.sequences.SequencesKt.toList(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L97:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto Lc1
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            r7 = r3
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r8 = "https://maxstream.video"
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = kotlin.text.StringsKt.contains$default(r7, r8, r4, r5, r6)
            if (r8 != 0) goto Lc0
            java.lang.String r8 = "https://uprot.net"
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r7 = kotlin.text.StringsKt.contains$default(r7, r8, r4, r5, r6)
            if (r7 == 0) goto L97
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            if (r7 != 0) goto L97
        Lc0:
            return r3
        Lc1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.UnshortenUrl.unshortenUprot(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String unshortenDavisonbarker(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        String decode = URLDecoder.decode(StringsKt.substringAfter$default(uri, "dest=", (String) null, 2, (Object) null));
        Intrinsics.checkNotNullExpressionValue(decode, "decode(uri.substringAfter(\"dest=\"))");
        return decode;
    }
}

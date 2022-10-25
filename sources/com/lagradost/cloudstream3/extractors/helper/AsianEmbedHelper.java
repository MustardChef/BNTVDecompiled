package com.lagradost.cloudstream3.extractors.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AsianEmbedHelper.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/helper/AsianEmbedHelper;", "", "()V", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes3.dex */
public final class AsianEmbedHelper {
    public static final Companion Companion = new Companion(null);

    /* compiled from: AsianEmbedHelper.kt */
    @Metadata(m108d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JA\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/extractors/helper/AsianEmbedHelper$Companion;", "", "()V", "getUrls", "", "url", "", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object getUrls(java.lang.String r21, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r22, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) {
            /*
                r20 = this;
                r0 = r24
                boolean r1 = r0 instanceof com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper$Companion$getUrls$1
                if (r1 == 0) goto L18
                r1 = r0
                com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper$Companion$getUrls$1 r1 = (com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper$Companion$getUrls$1) r1
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
                com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper$Companion$getUrls$1 r1 = new com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper$Companion$getUrls$1
                r2 = r20
                r1.<init>(r2, r0)
            L1f:
                java.lang.Object r0 = r1.result
                java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r3 = r1.label
                r14 = 1
                if (r3 == 0) goto L46
                if (r3 != r14) goto L3e
                java.lang.Object r3 = r1.L$2
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                java.lang.Object r4 = r1.L$1
                kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
                java.lang.Object r1 = r1.L$0
                java.lang.String r1 = (java.lang.String) r1
                kotlin.ResultKt.throwOnFailure(r0)
                r19 = 1
                goto L87
            L3e:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L46:
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
                r0 = 0
                r16 = 0
                r17 = 2046(0x7fe, float:2.867E-42)
                r18 = 0
                r4 = r21
                r1.L$0 = r4
                r24 = r15
                r15 = r22
                r1.L$1 = r15
                r15 = r23
                r1.L$2 = r15
                r1.label = r14
                r19 = 1
                r14 = r0
                r0 = r24
                r15 = r16
                r16 = r1
                java.lang.Object r1 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
                if (r1 != r0) goto L80
                return r0
            L80:
                r4 = r22
                r3 = r23
                r0 = r1
                r1 = r21
            L87:
                com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
                org.jsoup.nodes.Document r0 = r0.getDocument()
                java.lang.String r5 = "div#list-server-more > ul > li.linkserver"
                org.jsoup.select.Elements r0 = r0.select(r5)
                r5 = r0
                java.util.Collection r5 = (java.util.Collection) r5
                if (r5 == 0) goto La1
                boolean r5 = r5.isEmpty()
                if (r5 == 0) goto L9f
                goto La1
            L9f:
                r14 = 0
                goto La2
            La1:
                r14 = 1
            La2:
                if (r14 != 0) goto Lb6
                java.lang.String r5 = "links"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
                java.util.List r0 = (java.util.List) r0
                com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper$Companion$getUrls$2 r5 = new com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper$Companion$getUrls$2
                r6 = 0
                r5.<init>(r1, r4, r3, r6)
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                com.lagradost.cloudstream3.ParCollections.apmap(r0, r5)
            Lb6:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.extractors.helper.AsianEmbedHelper.Companion.getUrls(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}

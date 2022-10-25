package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.SubtitleFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExtractorApi.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0016JM\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJM\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m107d2 = {"Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "name", "getName", "requiresReferer", "", "getRequiresReferer", "()Z", "getExtractorUrl", "id", "getSafeUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUrl", "", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* loaded from: classes4.dex */
public abstract class ExtractorApi {
    public String getExtractorUrl(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return id;
    }

    public abstract String getMainUrl();

    public abstract String getName();

    public abstract boolean getRequiresReferer();

    public Object getUrl(String str, String str2, Continuation<? super List<? extends ExtractorLink>> continuation) {
        return CollectionsKt.emptyList();
    }

    public Object getUrl(String str, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function12, continuation);
    }

    public static /* synthetic */ Object getUrl$default(ExtractorApi extractorApi, String str, String str2, Function1 function1, Function1 function12, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return extractorApi.getUrl(str, str2, function1, function12, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUrl");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.lagradost.cloudstream3.utils.ExtractorApi r3, java.lang.String r4, java.lang.String r5, kotlin.jvm.functions.Function1 r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r6 = r8 instanceof com.lagradost.cloudstream3.utils.ExtractorApi$getUrl$1
            if (r6 == 0) goto L14
            r6 = r8
            com.lagradost.cloudstream3.utils.ExtractorApi$getUrl$1 r6 = (com.lagradost.cloudstream3.utils.ExtractorApi$getUrl$1) r6
            int r0 = r6.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L14
            int r8 = r6.label
            int r8 = r8 - r1
            r6.label = r8
            goto L19
        L14:
            com.lagradost.cloudstream3.utils.ExtractorApi$getUrl$1 r6 = new com.lagradost.cloudstream3.utils.ExtractorApi$getUrl$1
            r6.<init>(r3, r8)
        L19:
            java.lang.Object r8 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r3 = r6.L$0
            r7 = r3
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L45
        L2f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r8 = r3.getUrl(r4, r5, r6)
            if (r8 != r0) goto L45
            return r0
        L45:
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L5d
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r3 = r8.iterator()
        L4f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L5d
            java.lang.Object r4 = r3.next()
            r7.invoke(r4)
            goto L4f
        L5d:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.ExtractorApi.getUrl$suspendImpl(com.lagradost.cloudstream3.utils.ExtractorApi, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getSafeUrl$default(ExtractorApi extractorApi, String str, String str2, Function1 function1, Function1 function12, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return extractorApi.getSafeUrl(str, str2, function1, function12, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSafeUrl");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getSafeUrl(java.lang.String r8, java.lang.String r9, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r10, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.lagradost.cloudstream3.utils.ExtractorApi$getSafeUrl$1
            if (r0 == 0) goto L14
            r0 = r12
            com.lagradost.cloudstream3.utils.ExtractorApi$getSafeUrl$1 r0 = (com.lagradost.cloudstream3.utils.ExtractorApi$getSafeUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.lagradost.cloudstream3.utils.ExtractorApi$getSafeUrl$1 r0 = new com.lagradost.cloudstream3.utils.ExtractorApi$getSafeUrl$1
            r0.<init>(r7, r12)
        L19:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L2b
            goto L4b
        L2b:
            r8 = move-exception
            goto L46
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r12)
            r6.label = r2     // Catch: java.lang.Exception -> L2b
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            java.lang.Object r8 = r1.getUrl(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L2b
            if (r8 != r0) goto L4b
            return r0
        L46:
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r8)
        L4b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.utils.ExtractorApi.getSafeUrl(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getUrl$default(ExtractorApi extractorApi, String str, String str2, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return extractorApi.getUrl(str, str2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUrl");
    }
}

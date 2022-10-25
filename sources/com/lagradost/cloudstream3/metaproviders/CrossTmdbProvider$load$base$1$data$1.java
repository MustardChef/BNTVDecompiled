package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MovieLoadResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CrossTmdbProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/MovieLoadResponse;", "api", "Lcom/lagradost/cloudstream3/MainAPI;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.metaproviders.CrossTmdbProvider$load$base$1$data$1", m98f = "CrossTmdbProvider.kt", m97i = {0}, m96l = {70, 84}, m95m = "invokeSuspend", m94n = {"api"}, m93s = {"L$0"})
/* loaded from: classes3.dex */
public final class CrossTmdbProvider$load$base$1$data$1 extends SuspendLambda implements Function2<MainAPI, Continuation<? super MovieLoadResponse>, Object> {
    final /* synthetic */ String $matchName;
    final /* synthetic */ LoadResponse $this_apply;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CrossTmdbProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrossTmdbProvider$load$base$1$data$1(LoadResponse loadResponse, CrossTmdbProvider crossTmdbProvider, String str, Continuation<? super CrossTmdbProvider$load$base$1$data$1> continuation) {
        super(2, continuation);
        this.$this_apply = loadResponse;
        this.this$0 = crossTmdbProvider;
        this.$matchName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CrossTmdbProvider$load$base$1$data$1 crossTmdbProvider$load$base$1$data$1 = new CrossTmdbProvider$load$base$1$data$1(this.$this_apply, this.this$0, this.$matchName, continuation);
        crossTmdbProvider$load$base$1$data$1.L$0 = obj;
        return crossTmdbProvider$load$base$1$data$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MainAPI mainAPI, Continuation<? super MovieLoadResponse> continuation) {
        return ((CrossTmdbProvider$load$base$1$data$1) create(mainAPI, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8 A[Catch: Exception -> 0x00cb, TryCatch #0 {Exception -> 0x00cb, blocks: (B:6:0x000f, B:42:0x00b2, B:44:0x00b8, B:45:0x00bc, B:11:0x0020, B:19:0x004c, B:21:0x0050, B:22:0x005c, B:24:0x0062, B:26:0x0078, B:28:0x007c, B:30:0x0085, B:32:0x008b, B:37:0x009f, B:39:0x00a3, B:46:0x00bf, B:47:0x00c6, B:14:0x002c, B:16:0x0038, B:49:0x00c8), top: B:54:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bc A[Catch: Exception -> 0x00cb, TryCatch #0 {Exception -> 0x00cb, blocks: (B:6:0x000f, B:42:0x00b2, B:44:0x00b8, B:45:0x00bc, B:11:0x0020, B:19:0x004c, B:21:0x0050, B:22:0x005c, B:24:0x0062, B:26:0x0078, B:28:0x007c, B:30:0x0085, B:32:0x008b, B:37:0x009f, B:39:0x00a3, B:46:0x00bf, B:47:0x00c6, B:14:0x002c, B:16:0x0038, B:49:0x00c8), top: B:54:0x0009 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> Lcb
            goto Lb2
        L14:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1c:
            java.lang.Object r1 = r12.L$0
            com.lagradost.cloudstream3.MainAPI r1 = (com.lagradost.cloudstream3.MainAPI) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> Lcb
            goto L4c
        L24:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            com.lagradost.cloudstream3.MainAPI r1 = (com.lagradost.cloudstream3.MainAPI) r1
            java.util.Set r13 = r1.getSupportedTypes()     // Catch: java.lang.Exception -> Lcb
            com.lagradost.cloudstream3.TvType r5 = com.lagradost.cloudstream3.TvType.Movie     // Catch: java.lang.Exception -> Lcb
            boolean r13 = r13.contains(r5)     // Catch: java.lang.Exception -> Lcb
            if (r13 == 0) goto Lc8
            com.lagradost.cloudstream3.LoadResponse r13 = r12.$this_apply     // Catch: java.lang.Exception -> Lcb
            java.lang.String r13 = r13.getName()     // Catch: java.lang.Exception -> Lcb
            r5 = r12
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> Lcb
            r12.L$0 = r1     // Catch: java.lang.Exception -> Lcb
            r12.label = r3     // Catch: java.lang.Exception -> Lcb
            java.lang.Object r13 = r1.search(r13, r5)     // Catch: java.lang.Exception -> Lcb
            if (r13 != r0) goto L4c
            return r0
        L4c:
            java.util.List r13 = (java.util.List) r13     // Catch: java.lang.Exception -> Lcb
            if (r13 == 0) goto Lc7
            java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch: java.lang.Exception -> Lcb
            com.lagradost.cloudstream3.metaproviders.CrossTmdbProvider r5 = r12.this$0     // Catch: java.lang.Exception -> Lcb
            java.lang.String r6 = r12.$matchName     // Catch: java.lang.Exception -> Lcb
            com.lagradost.cloudstream3.LoadResponse r7 = r12.$this_apply     // Catch: java.lang.Exception -> Lcb
            java.util.Iterator r13 = r13.iterator()     // Catch: java.lang.Exception -> Lcb
        L5c:
            boolean r8 = r13.hasNext()     // Catch: java.lang.Exception -> Lcb
            if (r8 == 0) goto Lbf
            java.lang.Object r8 = r13.next()     // Catch: java.lang.Exception -> Lcb
            r9 = r8
            com.lagradost.cloudstream3.SearchResponse r9 = (com.lagradost.cloudstream3.SearchResponse) r9     // Catch: java.lang.Exception -> Lcb
            java.lang.String r10 = r9.getName()     // Catch: java.lang.Exception -> Lcb
            java.lang.String r10 = com.lagradost.cloudstream3.metaproviders.CrossTmdbProvider.access$filterName(r5, r10)     // Catch: java.lang.Exception -> Lcb
            boolean r10 = kotlin.text.StringsKt.equals(r10, r6, r3)     // Catch: java.lang.Exception -> Lcb
            r11 = 0
            if (r10 == 0) goto L9d
            boolean r10 = r9 instanceof com.lagradost.cloudstream3.MovieSearchResponse     // Catch: java.lang.Exception -> Lcb
            if (r10 == 0) goto L9c
            r10 = r9
            com.lagradost.cloudstream3.MovieSearchResponse r10 = (com.lagradost.cloudstream3.MovieSearchResponse) r10     // Catch: java.lang.Exception -> Lcb
            java.lang.Integer r10 = r10.getYear()     // Catch: java.lang.Exception -> Lcb
            if (r10 == 0) goto L9c
            java.lang.Integer r10 = r7.getYear()     // Catch: java.lang.Exception -> Lcb
            if (r10 == 0) goto L9c
            com.lagradost.cloudstream3.MovieSearchResponse r9 = (com.lagradost.cloudstream3.MovieSearchResponse) r9     // Catch: java.lang.Exception -> Lcb
            java.lang.Integer r9 = r9.getYear()     // Catch: java.lang.Exception -> Lcb
            java.lang.Integer r10 = r7.getYear()     // Catch: java.lang.Exception -> Lcb
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r10)     // Catch: java.lang.Exception -> Lcb
            if (r9 != 0) goto L9c
            goto L9d
        L9c:
            r11 = 1
        L9d:
            if (r11 == 0) goto L5c
            com.lagradost.cloudstream3.SearchResponse r8 = (com.lagradost.cloudstream3.SearchResponse) r8     // Catch: java.lang.Exception -> Lcb
            if (r8 == 0) goto Lc7
            java.lang.String r13 = r8.getUrl()     // Catch: java.lang.Exception -> Lcb
            r12.L$0 = r4     // Catch: java.lang.Exception -> Lcb
            r12.label = r2     // Catch: java.lang.Exception -> Lcb
            java.lang.Object r13 = r1.load(r13, r12)     // Catch: java.lang.Exception -> Lcb
            if (r13 != r0) goto Lb2
            return r0
        Lb2:
            com.lagradost.cloudstream3.LoadResponse r13 = (com.lagradost.cloudstream3.LoadResponse) r13     // Catch: java.lang.Exception -> Lcb
            boolean r0 = r13 instanceof com.lagradost.cloudstream3.MovieLoadResponse     // Catch: java.lang.Exception -> Lcb
            if (r0 == 0) goto Lbc
            com.lagradost.cloudstream3.MovieLoadResponse r13 = (com.lagradost.cloudstream3.MovieLoadResponse) r13     // Catch: java.lang.Exception -> Lcb
            r4 = r13
            goto Lc7
        Lbc:
            com.lagradost.cloudstream3.MovieLoadResponse r4 = (com.lagradost.cloudstream3.MovieLoadResponse) r4     // Catch: java.lang.Exception -> Lcb
            goto Lc7
        Lbf:
            java.util.NoSuchElementException r13 = new java.util.NoSuchElementException     // Catch: java.lang.Exception -> Lcb
            java.lang.String r0 = "Collection contains no element matching the predicate."
            r13.<init>(r0)     // Catch: java.lang.Exception -> Lcb
            throw r13     // Catch: java.lang.Exception -> Lcb
        Lc7:
            return r4
        Lc8:
            java.lang.Void r4 = (java.lang.Void) r4     // Catch: java.lang.Exception -> Lcb
            goto Ld3
        Lcb:
            r13 = move-exception
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            com.lagradost.cloudstream3.mvvm.ArchComponentExt.logError(r13)
            java.lang.Void r4 = (java.lang.Void) r4
        Ld3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.metaproviders.CrossTmdbProvider$load$base$1$data$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

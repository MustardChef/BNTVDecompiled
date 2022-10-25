package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AllMoviesForYouProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "id", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.AllMoviesForYouProvider$loadLinks$2", m98f = "AllMoviesForYouProvider.kt", m97i = {1}, m96l = {197, 200, 202}, m95m = "invokeSuspend", m94n = {"destination$iv$iv"}, m93s = {"L$4"})
/* loaded from: classes3.dex */
public final class AllMoviesForYouProvider$loadLinks$2 extends SuspendLambda implements Function2<String, Continuation<? super Object>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ AllMoviesForYouProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AllMoviesForYouProvider$loadLinks$2(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, AllMoviesForYouProvider allMoviesForYouProvider, Continuation<? super AllMoviesForYouProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.$data = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
        this.this$0 = allMoviesForYouProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AllMoviesForYouProvider$loadLinks$2 allMoviesForYouProvider$loadLinks$2 = new AllMoviesForYouProvider$loadLinks$2(this.$data, this.$subtitleCallback, this.$callback, this.this$0, continuation);
        allMoviesForYouProvider$loadLinks$2.L$0 = obj;
        return allMoviesForYouProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Object> continuation) {
        return invoke2(str, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<Object> continuation) {
        return ((AllMoviesForYouProvider$loadLinks$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x011f  */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0105 -> B:24:0x010b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.AllMoviesForYouProvider$loadLinks$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

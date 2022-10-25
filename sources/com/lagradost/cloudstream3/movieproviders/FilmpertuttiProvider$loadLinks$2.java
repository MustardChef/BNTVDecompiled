package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: FilmpertuttiProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "id", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.FilmpertuttiProvider$loadLinks$2", m98f = "FilmpertuttiProvider.kt", m97i = {}, m96l = {226, bqk.f6543bC, bqk.f6596cc, bqk.f6526am, 235}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class FilmpertuttiProvider$loadLinks$2 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FilmpertuttiProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FilmpertuttiProvider$loadLinks$2(FilmpertuttiProvider filmpertuttiProvider, String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super FilmpertuttiProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.this$0 = filmpertuttiProvider;
        this.$data = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FilmpertuttiProvider$loadLinks$2 filmpertuttiProvider$loadLinks$2 = new FilmpertuttiProvider$loadLinks$2(this.this$0, this.$data, this.$subtitleCallback, this.$callback, continuation);
        filmpertuttiProvider$loadLinks$2.L$0 = obj;
        return filmpertuttiProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Boolean> continuation) {
        return ((FilmpertuttiProvider$loadLinks$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0101 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.movieproviders.FilmpertuttiProvider$loadLinks$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PeliSmartProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PeliSmartProvider$loadLinks$2", m98f = "PeliSmartProvider.kt", m97i = {}, m96l = {155}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class PeliSmartProvider$loadLinks$2 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PeliSmartProvider$loadLinks$2(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super PeliSmartProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.$data = str;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PeliSmartProvider$loadLinks$2 peliSmartProvider$loadLinks$2 = new PeliSmartProvider$loadLinks$2(this.$data, this.$subtitleCallback, this.$callback, continuation);
        peliSmartProvider$loadLinks$2.L$0 = obj;
        return peliSmartProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Boolean> continuation) {
        return ((PeliSmartProvider$loadLinks$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object loadExtractor = ExtractorApiKt.loadExtractor(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) this.L$0, "https://pelismart.com/p/1.php?v=", "https://evoload.io/e/", false, 4, (Object) null), "https://pelismart.com/p/2.php?v=", "https://streamtape.com/e/", false, 4, (Object) null), "https://pelismart.com/p/4.php?v=", "https://dood.to/e/", false, 4, (Object) null), "https://pelismarthd.com/p/1.php?v=", "https://evoload.io/e/", false, 4, (Object) null), "https://pelismarthd.com/p/2.php?v=", "https://streamtape.com/e/", false, 4, (Object) null), "https://pelismarthd.com/p/4.php?v=", "https://dood.to/e/", false, 4, (Object) null), this.$data, this.$subtitleCallback, this.$callback, this);
        return loadExtractor == coroutine_suspended ? coroutine_suspended : loadExtractor;
    }
}

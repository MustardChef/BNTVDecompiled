package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.extractors.FEmbed;
import com.lagradost.cloudstream3.utils.ExtractorApi;
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
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: PinoyMoviePediaProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "link", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.PinoyMoviePediaProvider$loadLinks$2", m98f = "PinoyMoviePediaProvider.kt", m97i = {}, m96l = {bqk.f6596cc, 234}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class PinoyMoviePediaProvider$loadLinks$2 extends SuspendLambda implements Function2<String, Continuation<? super Object>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Ref.IntRef $count;
    final /* synthetic */ String $data;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PinoyMoviePediaProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PinoyMoviePediaProvider$loadLinks$2(Ref.IntRef intRef, String str, PinoyMoviePediaProvider pinoyMoviePediaProvider, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super PinoyMoviePediaProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.$count = intRef;
        this.$data = str;
        this.this$0 = pinoyMoviePediaProvider;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PinoyMoviePediaProvider$loadLinks$2 pinoyMoviePediaProvider$loadLinks$2 = new PinoyMoviePediaProvider$loadLinks$2(this.$count, this.$data, this.this$0, this.$subtitleCallback, this.$callback, continuation);
        pinoyMoviePediaProvider$loadLinks$2.L$0 = obj;
        return pinoyMoviePediaProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String str, Continuation<? super Object> continuation) {
        return invoke2(str, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, Continuation<Object> continuation) {
        return ((PinoyMoviePediaProvider$loadLinks$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            this.$count.element++;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "fembed.com", false, 2, (Object) null)) {
                FEmbed fEmbed = new FEmbed();
                fEmbed.setDomainUrl("diasfem.com");
                this.label = 1;
                obj = ExtractorApi.getUrl$default(fEmbed, this.$data, null, this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 2;
                Object loadExtractor = ExtractorApiKt.loadExtractor(str, this.this$0.getMainUrl(), this.$subtitleCallback, this.$callback, this);
                return loadExtractor == coroutine_suspended ? coroutine_suspended : loadExtractor;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Function1<ExtractorLink, Unit> function1 = this.$callback;
        for (ExtractorLink extractorLink : (Iterable) obj) {
            function1.invoke(extractorLink);
        }
        return Unit.INSTANCE;
    }
}

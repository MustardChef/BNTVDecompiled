package com.lagradost.cloudstream3.movieproviders;

import com.google.ads.interactivemedia.p034v3.internal.bqk;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FrenchStreamProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.FrenchStreamProvider$loadLinks$2", m98f = "FrenchStreamProvider.kt", m97i = {}, m96l = {bqk.f6560bT}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class FrenchStreamProvider$loadLinks$2 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FrenchStreamProvider$loadLinks$2(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super FrenchStreamProvider$loadLinks$2> continuation) {
        super(2, continuation);
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FrenchStreamProvider$loadLinks$2 frenchStreamProvider$loadLinks$2 = new FrenchStreamProvider$loadLinks$2(this.$subtitleCallback, this.$callback, continuation);
        frenchStreamProvider$loadLinks$2.L$0 = obj;
        return frenchStreamProvider$loadLinks$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super Unit> continuation) {
        return invoke2((Tuples<String, String>) tuples, continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<? super Unit> continuation) {
        return ((FrenchStreamProvider$loadLinks$2) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Tuples tuples = (Tuples) this.L$0;
            ExtractorApi[] extractorApis = ExtractorApiKt.getExtractorApis();
            int i2 = 0;
            int length = extractorApis.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                ExtractorApi extractorApi = extractorApis[i2];
                if (StringsKt.contains((CharSequence) tuples.getFirst(), (CharSequence) extractorApi.getName(), true)) {
                    this.label = 1;
                    if (extractorApi.getSafeUrl((String) tuples.getSecond(), (String) tuples.getSecond(), this.$subtitleCallback, this.$callback, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    i2++;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

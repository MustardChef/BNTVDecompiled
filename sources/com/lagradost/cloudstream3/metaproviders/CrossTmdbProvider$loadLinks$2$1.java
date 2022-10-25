package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
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

/* compiled from: CrossTmdbProvider.kt */
@Metadata(m108d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.metaproviders.CrossTmdbProvider$loadLinks$2$1", m98f = "CrossTmdbProvider.kt", m97i = {}, m96l = {45}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class CrossTmdbProvider$loadLinks$2$1 extends SuspendLambda implements Function2<Tuples<? extends String, ? extends String>, Continuation<? super Object>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    final /* synthetic */ boolean $isCasting;
    final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CrossTmdbProvider$loadLinks$2$1(boolean z, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function12, Continuation<? super CrossTmdbProvider$loadLinks$2$1> continuation) {
        super(2, continuation);
        this.$isCasting = z;
        this.$subtitleCallback = function1;
        this.$callback = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CrossTmdbProvider$loadLinks$2$1 crossTmdbProvider$loadLinks$2$1 = new CrossTmdbProvider$loadLinks$2$1(this.$isCasting, this.$subtitleCallback, this.$callback, continuation);
        crossTmdbProvider$loadLinks$2$1.L$0 = obj;
        return crossTmdbProvider$loadLinks$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Tuples<? extends String, ? extends String> tuples, Continuation<? super Object> continuation) {
        return invoke2((Tuples<String, String>) tuples, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(Tuples<String, String> tuples, Continuation<Object> continuation) {
        return ((CrossTmdbProvider$loadLinks$2$1) create(tuples, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Tuples tuples = (Tuples) this.L$0;
                String str = (String) tuples.component2();
                MainAPI apiFromNameNull = APIHolder.INSTANCE.getApiFromNameNull((String) tuples.component1());
                if (apiFromNameNull == null) {
                    return null;
                }
                boolean z = this.$isCasting;
                Function1<SubtitleFile, Unit> function1 = this.$subtitleCallback;
                Function1<ExtractorLink, Unit> function12 = this.$callback;
                boolean z2 = z;
                this.label = 1;
                obj = apiFromNameNull.loadLinks(str, z2, function1, function12, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        } catch (Exception e) {
            ArchComponentExt.logError(e);
            return Unit.INSTANCE;
        }
    }
}

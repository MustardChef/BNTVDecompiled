package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.movieproviders.SflixProvider;
import com.lagradost.cloudstream3.utils.Extensions;
import com.lagradost.nicehttp.Requests;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: SflixProvider.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SflixProvider$Companion$extractRabbitStream$2$1$1", m98f = "SflixProvider.kt", m97i = {}, m96l = {672}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class SflixProvider$Companion$extractRabbitStream$2$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $extractorData;
    final /* synthetic */ SflixProvider.Companion.PollingData $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SflixProvider$Companion$extractRabbitStream$2$1$1(String str, SflixProvider.Companion.PollingData pollingData, Continuation<? super SflixProvider$Companion$extractRabbitStream$2$1$1> continuation) {
        super(1, continuation);
        this.$extractorData = str;
        this.$it = pollingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SflixProvider$Companion$extractRabbitStream$2$1$1(this.$extractorData, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SflixProvider$Companion$extractRabbitStream$2$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String generateTimeStamp;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Extensions.RequestCustom app = MainActivityKt.getApp();
            StringBuilder sb = new StringBuilder();
            sb.append(this.$extractorData);
            sb.append("&t=");
            generateTimeStamp = SflixProvider.Companion.generateTimeStamp();
            sb.append(generateTimeStamp);
            sb.append("&sid=");
            sb.append(this.$it.getSid());
            this.label = 1;
            if (Requests.get$default(app, sb.toString(), null, null, null, null, false, 0, null, 0L, null, false, this, 2046, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}

package com.lagradost.cloudstream3.movieproviders;

import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
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

/* compiled from: SoaptwoDayProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "stream", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.movieproviders.SoaptwoDayProvider$loadLinks$2$1", m98f = "SoaptwoDayProvider.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
final class SoaptwoDayProvider$loadLinks$2$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SoaptwoDayProvider$loadLinks$2$1(Function1<? super ExtractorLink, Unit> function1, Continuation<? super SoaptwoDayProvider$loadLinks$2$1> continuation) {
        super(2, continuation);
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SoaptwoDayProvider$loadLinks$2$1 soaptwoDayProvider$loadLinks$2$1 = new SoaptwoDayProvider$loadLinks$2$1(this.$callback, continuation);
        soaptwoDayProvider$loadLinks$2$1.L$0 = obj;
        return soaptwoDayProvider$loadLinks$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((SoaptwoDayProvider$loadLinks$2$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String replace$default = StringsKt.replace$default(StringsKt.replace$default((String) this.L$0, "\\/", "/", false, 4, (Object) null), "\\\\\\", "", false, 4, (Object) null);
            if (!StringsKt.isBlank(replace$default)) {
                this.$callback.invoke(new ExtractorLink("Soap2Day", "Soap2Day", replace$default, "https://soap2day.ac", Qualities.Unknown.getValue(), false, null, null, 192, null));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

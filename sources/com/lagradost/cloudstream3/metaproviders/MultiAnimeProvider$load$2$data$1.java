package com.lagradost.cloudstream3.metaproviders;

import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiAnimeProvider.kt */
@Metadata(m108d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", ""}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.metaproviders.MultiAnimeProvider$load$2$data$1", m98f = "MultiAnimeProvider.kt", m97i = {}, m96l = {49}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class MultiAnimeProvider$load$2$data$1 extends SuspendLambda implements Function2<String, Continuation<? super LoadResponse>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MultiAnimeProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiAnimeProvider$load$2$data$1(MultiAnimeProvider multiAnimeProvider, Continuation<? super MultiAnimeProvider$load$2$data$1> continuation) {
        super(2, continuation);
        this.this$0 = multiAnimeProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MultiAnimeProvider$load$2$data$1 multiAnimeProvider$load$2$data$1 = new MultiAnimeProvider$load$2$data$1(this.this$0, continuation);
        multiAnimeProvider$load$2$data$1.L$0 = obj;
        return multiAnimeProvider$load$2$data$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super LoadResponse> continuation) {
        return ((MultiAnimeProvider$load$2$data$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List validApis;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            validApis = this.this$0.getValidApis();
            Iterator it = validApis.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (StringsKt.startsWith$default(str, ((MainAPI) obj2).getMainUrl(), false, 2, (Object) null)) {
                    break;
                }
            }
            MainAPI mainAPI = (MainAPI) obj2;
            if (mainAPI == null) {
                return null;
            }
            this.label = 1;
            obj = mainAPI.load(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return (LoadResponse) obj;
    }
}

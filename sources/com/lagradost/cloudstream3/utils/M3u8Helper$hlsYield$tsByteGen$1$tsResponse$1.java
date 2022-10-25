package com.lagradost.cloudstream3.utils;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: M3u8Helper.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/nicehttp/NiceResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.utils.M3u8Helper$hlsYield$tsByteGen$1$tsResponse$1", m98f = "M3u8Helper.kt", m97i = {}, m96l = {241}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes4.dex */
final class M3u8Helper$hlsYield$tsByteGen$1$tsResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NiceResponse>, Object> {
    final /* synthetic */ Map<String, String> $headers;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M3u8Helper$hlsYield$tsByteGen$1$tsResponse$1(String str, Map<String, String> map, Continuation<? super M3u8Helper$hlsYield$tsByteGen$1$tsResponse$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$headers = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new M3u8Helper$hlsYield$tsByteGen$1$tsResponse$1(this.$url, this.$headers, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NiceResponse> continuation) {
        return ((M3u8Helper$hlsYield$tsByteGen$1$tsResponse$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object obj2 = Requests.get$default(MainActivityKt.getApp(), this.$url, this.$headers, null, null, null, false, 0, null, 0L, null, false, this, 2044, null);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}

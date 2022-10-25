package com.lagradost.cloudstream3.p041ui.result;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultViewModel$load$1", m98f = "ResultViewModel.kt", m97i = {0, 1, 2, 2, 2}, m96l = {330, 352, 401}, m95m = "invokeSuspend", m94n = {"api", "validUrl", "loadResponse", "dubStatus", "mainId"}, m93s = {"L$0", "L$0", "L$0", "L$1", "I$0"})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$load$1 */
/* loaded from: classes4.dex */
public final class ResultViewModel$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $apiName;
    final /* synthetic */ boolean $showFillers;
    final /* synthetic */ String $url;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ResultViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultViewModel$load$1(ResultViewModel resultViewModel, String str, String str2, boolean z, Continuation<? super ResultViewModel$load$1> continuation) {
        super(2, continuation);
        this.this$0 = resultViewModel;
        this.$url = str;
        this.$apiName = str2;
        this.$showFillers = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResultViewModel$load$1(this.this$0, this.$url, this.$apiName, this.$showFillers, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ResultViewModel$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0267  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r34) {
        /*
            Method dump skipped, instructions count: 1308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.ResultViewModel$load$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

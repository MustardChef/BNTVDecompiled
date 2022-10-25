package com.lagradost.cloudstream3.p041ui.result;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.SyncViewModel$publishUserData$1", m98f = "SyncViewModel.kt", m97i = {0}, m96l = {172}, m95m = "invokeSuspend", m94n = {"user"}, m93s = {"L$0"})
/* renamed from: com.lagradost.cloudstream3.ui.result.SyncViewModel$publishUserData$1 */
/* loaded from: classes4.dex */
public final class SyncViewModel$publishUserData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ SyncViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncViewModel$publishUserData$1(SyncViewModel syncViewModel, Continuation<? super SyncViewModel$publishUserData$1> continuation) {
        super(2, continuation);
        this.this$0 = syncViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SyncViewModel$publishUserData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SyncViewModel$publishUserData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00ac -> B:26:0x00b3). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 1
            if (r1 == 0) goto L29
            if (r1 != r2) goto L21
            java.lang.Object r1 = r11.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r11.L$1
            com.lagradost.cloudstream3.ui.result.SyncViewModel r3 = (com.lagradost.cloudstream3.p041ui.result.SyncViewModel) r3
            java.lang.Object r4 = r11.L$0
            com.lagradost.cloudstream3.mvvm.Resource r4 = (com.lagradost.cloudstream3.mvvm.Resource) r4
            kotlin.ResultKt.throwOnFailure(r12)
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r11
            goto Lb3
        L21:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L29:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = "SYNCVM"
            java.lang.String r1 = "publishUserData"
            android.util.Log.i(r12, r1)
            com.lagradost.cloudstream3.ui.result.SyncViewModel r12 = r11.this$0
            androidx.lifecycle.LiveData r12 = r12.getUserData()
            java.lang.Object r12 = r12.getValue()
            com.lagradost.cloudstream3.mvvm.Resource r12 = (com.lagradost.cloudstream3.mvvm.Resource) r12
            boolean r1 = r12 instanceof com.lagradost.cloudstream3.mvvm.Resource.Success
            if (r1 == 0) goto Lbb
            com.lagradost.cloudstream3.ui.result.SyncViewModel r1 = r11.this$0
            java.util.Map r1 = com.lagradost.cloudstream3.p041ui.result.SyncViewModel.access$getSyncs$p(r1)
            com.lagradost.cloudstream3.ui.result.SyncViewModel r3 = r11.this$0
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r4 = r12
            r12 = r11
        L55:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto Lbc
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            java.util.List r7 = com.lagradost.cloudstream3.p041ui.result.SyncViewModel.access$getRepos$p(r3)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L77:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L8f
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.lagradost.cloudstream3.syncproviders.SyncRepo r9 = (com.lagradost.cloudstream3.syncproviders.SyncRepo) r9
            java.lang.String r9 = r9.getIdPrefix()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r6)
            if (r9 == 0) goto L77
            goto L90
        L8f:
            r8 = 0
        L90:
            com.lagradost.cloudstream3.syncproviders.SyncRepo r8 = (com.lagradost.cloudstream3.syncproviders.SyncRepo) r8
            if (r8 == 0) goto L55
            r6 = r4
            com.lagradost.cloudstream3.mvvm.Resource$Success r6 = (com.lagradost.cloudstream3.mvvm.Resource.Success) r6
            java.lang.Object r6 = r6.getValue()
            com.lagradost.cloudstream3.syncproviders.SyncAPI$SyncStatus r6 = (com.lagradost.cloudstream3.syncproviders.SyncAPI.SyncStatus) r6
            r12.L$0 = r4
            r12.L$1 = r3
            r12.L$2 = r1
            r12.label = r2
            java.lang.Object r5 = r8.score(r5, r6, r12)
            if (r5 != r0) goto Lac
            return r0
        Lac:
            r10 = r0
            r0 = r12
            r12 = r5
            r5 = r4
            r4 = r3
            r3 = r1
            r1 = r10
        Lb3:
            com.lagradost.cloudstream3.mvvm.Resource r12 = (com.lagradost.cloudstream3.mvvm.Resource) r12
            r12 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r4 = r5
            goto L55
        Lbb:
            r12 = r11
        Lbc:
            com.lagradost.cloudstream3.ui.result.SyncViewModel r12 = r12.this$0
            r12.updateUserData()
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.result.SyncViewModel$publishUserData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

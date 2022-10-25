package com.lagradost.cloudstream3.syncproviders;

import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncRepo.kt */
@Metadata(m108d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.syncproviders.SyncRepo$getStatus$2", m98f = "SyncRepo.kt", m97i = {}, m96l = {19}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* loaded from: classes3.dex */
public final class SyncRepo$getStatus$2 extends SuspendLambda implements Function1<Continuation<? super SyncAPI.SyncStatus>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ SyncRepo this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncRepo$getStatus$2(SyncRepo syncRepo, String str, Continuation<? super SyncRepo$getStatus$2> continuation) {
        super(1, continuation);
        this.this$0 = syncRepo;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SyncRepo$getStatus$2(this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super SyncAPI.SyncStatus> continuation) {
        return ((SyncRepo$getStatus$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SyncAPI syncAPI;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            syncAPI = this.this$0.repo;
            this.label = 1;
            obj = syncAPI.getStatus(this.$id, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        SyncAPI.SyncStatus syncStatus = (SyncAPI.SyncStatus) obj;
        if (syncStatus != null) {
            return syncStatus;
        }
        throw new ErrorLoadingException("No data");
    }
}

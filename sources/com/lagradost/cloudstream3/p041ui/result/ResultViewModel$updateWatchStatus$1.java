package com.lagradost.cloudstream3.p041ui.result;

import androidx.lifecycle.MutableLiveData;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResultViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultViewModel$updateWatchStatus$1", m98f = "ResultViewModel.kt", m97i = {}, m96l = {92}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$updateWatchStatus$1 */
/* loaded from: classes4.dex */
public final class ResultViewModel$updateWatchStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchType $status;
    int label;
    final /* synthetic */ ResultViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultViewModel$updateWatchStatus$1(ResultViewModel resultViewModel, WatchType watchType, Continuation<? super ResultViewModel$updateWatchStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = resultViewModel;
        this.$status = watchType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResultViewModel$updateWatchStatus$1(this.this$0, this.$status, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ResultViewModel$updateWatchStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Integer value = this.this$0.getId().getValue();
            if (value == null) {
                return Unit.INSTANCE;
            }
            int intValue = value.intValue();
            mutableLiveData = this.this$0._watchStatus;
            mutableLiveData.postValue(this.$status);
            mutableLiveData2 = this.this$0.page;
            WatchType watchType = this.$status;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new C49531(intValue, watchType, (LoadResponse) mutableLiveData2.getValue(), null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultViewModel.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    @DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.ResultViewModel$updateWatchStatus$1$1", m98f = "ResultViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$updateWatchStatus$1$1 */
    /* loaded from: classes4.dex */
    public static final class C49531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $currentId;
        final /* synthetic */ LoadResponse $resultPage;
        final /* synthetic */ WatchType $status;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49531(int i, WatchType watchType, LoadResponse loadResponse, Continuation<? super C49531> continuation) {
            super(2, continuation);
            this.$currentId = i;
            this.$status = watchType;
            this.$resultPage = loadResponse;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C49531(this.$currentId, this.$status, this.$resultPage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C49531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DataStoreHelper.INSTANCE.setResultWatchState(boxing.boxInt(this.$currentId), this.$status.getInternalId());
                if (this.$resultPage != null) {
                    DataStoreHelper.BookmarkedData bookmarkedData = DataStoreHelper.INSTANCE.getBookmarkedData(boxing.boxInt(this.$currentId));
                    long currentTimeMillis = System.currentTimeMillis();
                    DataStoreHelper.INSTANCE.setBookmarkedData(boxing.boxInt(this.$currentId), new DataStoreHelper.BookmarkedData(boxing.boxInt(this.$currentId), bookmarkedData != null ? bookmarkedData.getBookmarkedTime() : currentTimeMillis, currentTimeMillis, this.$resultPage.getName(), this.$resultPage.getUrl(), this.$resultPage.getApiName(), this.$resultPage.getType(), this.$resultPage.getPosterUrl(), this.$resultPage.getYear(), null, null, 1536, null));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}

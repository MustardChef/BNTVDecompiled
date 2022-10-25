package com.lagradost.cloudstream3.p041ui.result;

import android.util.Log;
import com.lagradost.cloudstream3.utils.SyncUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.result.SyncViewModel$addFromUrl$1", m98f = "SyncViewModel.kt", m97i = {}, m96l = {104}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.result.SyncViewModel$addFromUrl$1 */
/* loaded from: classes4.dex */
public final class SyncViewModel$addFromUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ SyncViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncViewModel$addFromUrl$1(String str, SyncViewModel syncViewModel, Continuation<? super SyncViewModel$addFromUrl$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.this$0 = syncViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SyncViewModel$addFromUrl$1(this.$url, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SyncViewModel$addFromUrl$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.i(SyncViewModel.TAG, "addFromUrl = " + this.$url);
            if (this.$url == null || this.this$0.getHasAddedFromUrl().contains(this.$url)) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            obj = SyncUtil.INSTANCE.getIdsFromUrl(this.$url, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        Tuples tuples = (Tuples) obj;
        if (tuples != null) {
            SyncViewModel syncViewModel = this.this$0;
            String str = this.$url;
            String str2 = (String) tuples.component1();
            String str3 = (String) tuples.component2();
            syncViewModel.getHasAddedFromUrl().add(str);
            syncViewModel.setMalId(str2);
            syncViewModel.setAniListId(str3);
            syncViewModel.updateSynced();
            if (str2 != null || str3 != null) {
                Log.i(SyncViewModel.TAG, "addFromUrl->updateMetaAndUser " + str2 + ' ' + str3);
                syncViewModel.updateMetaAndUser();
            }
        }
        return Unit.INSTANCE;
    }
}

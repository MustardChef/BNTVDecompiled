package com.lagradost.cloudstream3.p041ui.player;

import androidx.lifecycle.MutableLiveData;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerGeneratorViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$loadLinks$1", m98f = "PlayerGeneratorViewModel.kt", m97i = {0, 0}, m96l = {144}, m95m = "invokeSuspend", m94n = {"currentLinks", "currentSubs"}, m93s = {"L$0", "L$1"})
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$loadLinks$1 */
/* loaded from: classes3.dex */
public final class PlayerGeneratorViewModel$loadLinks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $clearCache;
    final /* synthetic */ boolean $isCasting;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PlayerGeneratorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerGeneratorViewModel$loadLinks$1(PlayerGeneratorViewModel playerGeneratorViewModel, boolean z, boolean z2, Continuation<? super PlayerGeneratorViewModel$loadLinks$1> continuation) {
        super(2, continuation);
        this.this$0 = playerGeneratorViewModel;
        this.$clearCache = z;
        this.$isCasting = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerGeneratorViewModel$loadLinks$1(this.this$0, this.$clearCache, this.$isCasting, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerGeneratorViewModel$loadLinks$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Set linkedHashSet;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        Set set;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        MutableLiveData mutableLiveData6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            linkedHashSet = new LinkedHashSet();
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            mutableLiveData = this.this$0._currentSubs;
            mutableLiveData.postValue(linkedHashSet2);
            mutableLiveData2 = this.this$0._currentLinks;
            mutableLiveData2.postValue(linkedHashSet);
            mutableLiveData3 = this.this$0._loadingLinks;
            mutableLiveData3.postValue(new Resource.Loading(null, 1, null));
            this.L$0 = linkedHashSet;
            this.L$1 = linkedHashSet2;
            this.label = 1;
            Object safeApiCall = ArchComponentExt.safeApiCall(new PlayerGeneratorViewModel$loadLinks$1$loadingState$1(this.this$0, this.$clearCache, this.$isCasting, linkedHashSet, linkedHashSet2, null), this);
            if (safeApiCall == coroutine_suspended) {
                return coroutine_suspended;
            }
            set = linkedHashSet2;
            obj = safeApiCall;
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            set = (Set) this.L$1;
            linkedHashSet = (Set) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData4 = this.this$0._loadingLinks;
        mutableLiveData4.postValue((Resource) obj);
        mutableLiveData5 = this.this$0._currentLinks;
        mutableLiveData5.postValue(linkedHashSet);
        mutableLiveData6 = this.this$0._currentSubs;
        mutableLiveData6.postValue(set);
        return Unit.INSTANCE;
    }
}

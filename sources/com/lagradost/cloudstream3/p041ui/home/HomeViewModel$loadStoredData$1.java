package com.lagradost.cloudstream3.p041ui.home;

import androidx.lifecycle.MutableLiveData;
import com.lagradost.cloudstream3.p041ui.WatchType;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.home.HomeViewModel$loadStoredData$1", m98f = "HomeViewModel.kt", m97i = {}, m96l = {100, 133}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeViewModel$loadStoredData$1 */
/* loaded from: classes3.dex */
public final class HomeViewModel$loadStoredData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EnumSet<WatchType> $preferredWatchStatus;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeViewModel$loadStoredData$1(HomeViewModel homeViewModel, EnumSet<WatchType> enumSet, Continuation<? super HomeViewModel$loadStoredData$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
        this.$preferredWatchStatus = enumSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$loadStoredData$1(this.this$0, this.$preferredWatchStatus, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$loadStoredData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new HomeViewModel$loadStoredData$1$watchStatusIds$1(null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                mutableLiveData3 = this.this$0._bookmarks;
                mutableLiveData3.postValue(new Tuples(boxing.boxBoolean(true), (List) obj));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        if (list != null) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (hashSet.add(boxing.boxInt(((Number) ((Tuples) obj2).getFirst()).intValue()))) {
                    arrayList.add(obj2);
                }
            }
            ArrayList<Tuples> arrayList2 = arrayList;
            int length = WatchType.values().length;
            EnumSet currentWatchTypes = EnumSet.noneOf(WatchType.class);
            for (Tuples tuples : arrayList2) {
                currentWatchTypes.add(tuples.getSecond());
                if (currentWatchTypes.size() >= length) {
                    break;
                }
            }
            currentWatchTypes.remove(WatchType.NONE);
            if (currentWatchTypes.size() <= 0) {
                mutableLiveData2 = this.this$0._bookmarks;
                mutableLiveData2.postValue(new Tuples(boxing.boxBoolean(false), new ArrayList()));
                return Unit.INSTANCE;
            }
            EnumSet<WatchType> enumSet = this.$preferredWatchStatus;
            if (enumSet == null) {
                Intrinsics.checkNotNullExpressionValue(currentWatchTypes, "currentWatchTypes");
                enumSet = EnumSet.of((Enum) CollectionsKt.first(currentWatchTypes));
            }
            mutableLiveData = this.this$0._availableWatchStatusTypes;
            mutableLiveData.postValue(new Tuples(enumSet, currentWatchTypes));
            this.label = 2;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new HomeViewModel$loadStoredData$1$list$1(arrayList2, enumSet, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData3 = this.this$0._bookmarks;
            mutableLiveData3.postValue(new Tuples(boxing.boxBoolean(true), (List) obj));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}

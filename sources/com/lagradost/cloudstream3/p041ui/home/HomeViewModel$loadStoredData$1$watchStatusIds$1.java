package com.lagradost.cloudstream3.p041ui.home;

import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeViewModel.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0001*\u00020\u0005H\u008a@"}, m107d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "Lcom/lagradost/cloudstream3/ui/WatchType;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.home.HomeViewModel$loadStoredData$1$watchStatusIds$1", m98f = "HomeViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeViewModel$loadStoredData$1$watchStatusIds$1 */
/* loaded from: classes3.dex */
final class HomeViewModel$loadStoredData$1$watchStatusIds$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Tuples<? extends Integer, ? extends WatchType>>>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeViewModel$loadStoredData$1$watchStatusIds$1(Continuation<? super HomeViewModel$loadStoredData$1$watchStatusIds$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$loadStoredData$1$watchStatusIds$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Tuples<? extends Integer, ? extends WatchType>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<? extends Tuples<Integer, ? extends WatchType>>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<? extends Tuples<Integer, ? extends WatchType>>> continuation) {
        return ((HomeViewModel$loadStoredData$1$watchStatusIds$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<Integer> allWatchStateIds = DataStoreHelper.INSTANCE.getAllWatchStateIds();
            if (allWatchStateIds != null) {
                List<Integer> list = allWatchStateIds;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (Number number : list) {
                    int intValue = number.intValue();
                    arrayList.add(new Tuples(boxing.boxInt(intValue), DataStoreHelper.INSTANCE.getResultWatchState(intValue)));
                }
                return arrayList;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

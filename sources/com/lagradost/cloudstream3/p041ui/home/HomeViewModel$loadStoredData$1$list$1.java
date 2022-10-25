package com.lagradost.cloudstream3.p041ui.home;

import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeViewModel.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, m107d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DataStoreHelper$BookmarkedData;", "Lkotlinx/coroutines/CoroutineScope;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
@DebugMetadata(m99c = "com.lagradost.cloudstream3.ui.home.HomeViewModel$loadStoredData$1$list$1", m98f = "HomeViewModel.kt", m97i = {}, m96l = {}, m95m = "invokeSuspend", m94n = {}, m93s = {})
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeViewModel$loadStoredData$1$list$1 */
/* loaded from: classes3.dex */
final class HomeViewModel$loadStoredData$1$list$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DataStoreHelper.BookmarkedData>>, Object> {
    final /* synthetic */ EnumSet<WatchType> $watchPrefNotNull;
    final /* synthetic */ List<Tuples<Integer, WatchType>> $watchStatusIds;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeViewModel$loadStoredData$1$list$1(List<? extends Tuples<Integer, ? extends WatchType>> list, EnumSet<WatchType> enumSet, Continuation<? super HomeViewModel$loadStoredData$1$list$1> continuation) {
        super(2, continuation);
        this.$watchStatusIds = list;
        this.$watchPrefNotNull = enumSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$loadStoredData$1$list$1(this.$watchStatusIds, this.$watchPrefNotNull, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends DataStoreHelper.BookmarkedData>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<DataStoreHelper.BookmarkedData>>) continuation);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<DataStoreHelper.BookmarkedData>> continuation) {
        return ((HomeViewModel$loadStoredData$1$list$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        EnumSet<WatchType> enumSet = this.$watchPrefNotNull;
        ArrayList<Tuples> arrayList = new ArrayList();
        for (Object obj2 : this.$watchStatusIds) {
            if (enumSet.contains(((Tuples) obj2).getSecond())) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Tuples tuples : arrayList) {
            DataStoreHelper.BookmarkedData bookmarkedData = DataStoreHelper.INSTANCE.getBookmarkedData((Integer) tuples.getFirst());
            if (bookmarkedData != null) {
                arrayList2.add(bookmarkedData);
            }
        }
        return CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.lagradost.cloudstream3.ui.home.HomeViewModel$loadStoredData$1$list$1$invokeSuspend$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(-((DataStoreHelper.BookmarkedData) t).getLatestUpdatedTime()), Long.valueOf(-((DataStoreHelper.BookmarkedData) t2).getLatestUpdatedTime()));
            }
        });
    }
}

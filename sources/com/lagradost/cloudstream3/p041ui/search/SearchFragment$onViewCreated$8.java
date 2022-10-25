package com.lagradost.cloudstream3.p041ui.search;

import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.home.HomeParentItemAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SearchFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "list", "", "Lcom/lagradost/cloudstream3/ui/search/OnGoingSearch;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchFragment$onViewCreated$8 */
/* loaded from: classes4.dex */
final class SearchFragment$onViewCreated$8 extends Lambda implements Function1<List<? extends OnGoingSearch>, Unit> {
    final /* synthetic */ ReentrantLock $listLock;
    final /* synthetic */ SearchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFragment$onViewCreated$8(ReentrantLock reentrantLock, SearchFragment searchFragment) {
        super(1);
        this.$listLock = reentrantLock;
        this.this$0 = searchFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends OnGoingSearch> list) {
        invoke2((List<OnGoingSearch>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<OnGoingSearch> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        try {
            try {
                this.$listLock.lock();
                RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.search_master_recycler);
                HomeParentItemAdapter homeParentItemAdapter = (HomeParentItemAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
                if (homeParentItemAdapter != null) {
                    List<OnGoingSearch> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (OnGoingSearch onGoingSearch : list2) {
                        arrayList.add(new HomePageList(onGoingSearch.getApiName(), onGoingSearch.getData() instanceof Resource.Success ? SearchFragment.Companion.filterSearchResponse((List) ((Resource.Success) onGoingSearch.getData()).getValue()) : new ArrayList(), null, null, null, 28, null));
                    }
                    homeParentItemAdapter.updateList(arrayList);
                }
            } catch (Exception e) {
                ArchComponentExt.logError(e);
            }
        } finally {
            this.$listLock.unlock();
        }
    }
}

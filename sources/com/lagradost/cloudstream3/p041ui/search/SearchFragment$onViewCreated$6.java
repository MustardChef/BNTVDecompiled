package com.lagradost.cloudstream3.p041ui.search;

import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.C4761R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SearchFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "list", "", "Lcom/lagradost/cloudstream3/ui/search/SearchHistoryItem;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchFragment$onViewCreated$6 */
/* loaded from: classes4.dex */
final class SearchFragment$onViewCreated$6 extends Lambda implements Function1<List<? extends SearchHistoryItem>, Unit> {
    final /* synthetic */ SearchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFragment$onViewCreated$6(SearchFragment searchFragment) {
        super(1);
        this.this$0 = searchFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SearchHistoryItem> list) {
        invoke2((List<SearchHistoryItem>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<SearchHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        RecyclerView.Adapter adapter = ((RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.search_history_recycler)).getAdapter();
        SearchHistoryAdaptor searchHistoryAdaptor = adapter instanceof SearchHistoryAdaptor ? (SearchHistoryAdaptor) adapter : null;
        if (searchHistoryAdaptor != null) {
            searchHistoryAdaptor.updateList(list);
        }
    }
}

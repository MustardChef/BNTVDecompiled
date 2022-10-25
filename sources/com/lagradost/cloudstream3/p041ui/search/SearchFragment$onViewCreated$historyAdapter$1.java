package com.lagradost.cloudstream3.p041ui.search;

import androidx.appcompat.widget.SearchView;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.TvType;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SearchFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "click", "Lcom/lagradost/cloudstream3/ui/search/SearchHistoryCallback;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchFragment$onViewCreated$historyAdapter$1 */
/* loaded from: classes4.dex */
final class SearchFragment$onViewCreated$historyAdapter$1 extends Lambda implements Function1<SearchHistoryCallback, Unit> {
    final /* synthetic */ List<Tuples<MaterialButton, List<TvType>>> $pairList;
    final /* synthetic */ SearchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SearchFragment$onViewCreated$historyAdapter$1(SearchFragment searchFragment, List<? extends Tuples<? extends MaterialButton, ? extends List<? extends TvType>>> list) {
        super(1);
        this.this$0 = searchFragment;
        this.$pairList = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchHistoryCallback searchHistoryCallback) {
        invoke2(searchHistoryCallback);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SearchHistoryCallback click) {
        SearchViewModel searchViewModel;
        SearchViewModel searchViewModel2;
        Intrinsics.checkNotNullParameter(click, "click");
        SearchHistoryItem item = click.getItem();
        int clickAction = click.getClickAction();
        if (clickAction != 0) {
            if (clickAction != 1) {
                return;
            }
            AcraApplication.Companion.removeKey(SearchViewModelKt.SEARCH_HISTORY_KEY, item.getKey());
            searchViewModel2 = this.this$0.getSearchViewModel();
            searchViewModel2.updateHistory();
            return;
        }
        searchViewModel = this.this$0.getSearchViewModel();
        searchViewModel.clearSearch();
        if (!item.getType().isEmpty()) {
            SearchFragment.onViewCreated$updateSelectedList(this.this$0, this.$pairList, CollectionsKt.toMutableList((Collection) item.getType()));
        }
        SearchView searchView = (SearchView) this.this$0._$_findCachedViewById(C4761R.C4764id.main_search);
        if (searchView != null) {
            searchView.setQuery(item.getSearchText(), true);
        }
    }
}

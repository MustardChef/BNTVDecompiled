package com.lagradost.cloudstream3.p041ui.search;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.APIRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: SearchViewModel.kt */
@Metadata(m108d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0019J2\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 H\u0002J2\u0010\"\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00050\n0\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000f¨\u0006$"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_currentHistory", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/lagradost/cloudstream3/ui/search/SearchHistoryItem;", "_currentSearch", "Lcom/lagradost/cloudstream3/ui/search/OnGoingSearch;", "_searchResponse", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/SearchResponse;", "currentHistory", "Landroidx/lifecycle/LiveData;", "getCurrentHistory", "()Landroidx/lifecycle/LiveData;", "currentSearch", "getCurrentSearch", "onGoingSearch", "Lkotlinx/coroutines/Job;", "repos", "Lcom/lagradost/cloudstream3/ui/APIRepository;", "searchResponse", "getSearchResponse", "clearSearch", "", "search", "query", "", "providersActive", "", "ignoreSettings", "", "isQuickSearch", "searchAndCancel", "updateHistory", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchViewModel */
/* loaded from: classes4.dex */
public final class SearchViewModel extends ViewModel {
    private Job onGoingSearch;
    private final List<APIRepository> repos;
    private final MutableLiveData<Resource<List<SearchResponse>>> _searchResponse = new MutableLiveData<>();
    private final MutableLiveData<List<OnGoingSearch>> _currentSearch = new MutableLiveData<>();
    private final MutableLiveData<List<SearchHistoryItem>> _currentHistory = new MutableLiveData<>();

    public SearchViewModel() {
        List<MainAPI> apis = APIHolder.INSTANCE.getApis();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(apis, 10));
        for (MainAPI mainAPI : apis) {
            arrayList.add(new APIRepository(mainAPI, null, 2, null));
        }
        this.repos = arrayList;
    }

    public final LiveData<Resource<List<SearchResponse>>> getSearchResponse() {
        return this._searchResponse;
    }

    public final LiveData<List<OnGoingSearch>> getCurrentSearch() {
        return this._currentSearch;
    }

    public final LiveData<List<SearchHistoryItem>> getCurrentHistory() {
        return this._currentHistory;
    }

    public final void clearSearch() {
        this._searchResponse.postValue(new Resource.Success(new ArrayList()));
        this._currentSearch.postValue(CollectionsKt.emptyList());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void searchAndCancel$default(SearchViewModel searchViewModel, String str, Set set, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            set = SetsKt.emptySet();
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        searchViewModel.searchAndCancel(str, set, z, z2);
    }

    public final void searchAndCancel(String query, Set<String> providersActive, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(providersActive, "providersActive");
        Job job = this.onGoingSearch;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.onGoingSearch = search(query, providersActive, z, z2);
    }

    public final Job updateHistory() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SearchViewModel$updateHistory$1(this, null), 3, null);
        return launch$default;
    }

    static /* synthetic */ Job search$default(SearchViewModel searchViewModel, String str, Set set, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return searchViewModel.search(str, set, z, z2);
    }

    private final Job search(String str, Set<String> set, boolean z, boolean z2) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SearchViewModel$search$1(str, this, z2, z, set, null), 3, null);
        return launch$default;
    }
}

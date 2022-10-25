package com.lagradost.cloudstream3.p041ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lagradost.cloudstream3.PageResponse;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.APIRepository;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: PageViewModel.kt */
@Metadata(m108d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/PageViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_searchResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/PageResponse;", "hasLoadMore", "", "getHasLoadMore", "()Z", "repos", "Lcom/lagradost/cloudstream3/ui/APIRepository;", "getRepos", "()Lcom/lagradost/cloudstream3/ui/APIRepository;", "setRepos", "(Lcom/lagradost/cloudstream3/ui/APIRepository;)V", "searchResponse", "Landroidx/lifecycle/LiveData;", "getSearchResponse", "()Landroidx/lifecycle/LiveData;", "getPage", "Lkotlinx/coroutines/Job;", "url", "", "name", "urlApi", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.PageViewModel */
/* loaded from: classes3.dex */
public final class PageViewModel extends ViewModel {
    private final MutableLiveData<Resource<PageResponse>> _searchResponse = new MutableLiveData<>();
    private final boolean hasLoadMore;
    private APIRepository repos;

    public final LiveData<Resource<PageResponse>> getSearchResponse() {
        return this._searchResponse;
    }

    public final boolean getHasLoadMore() {
        return this.hasLoadMore;
    }

    public final APIRepository getRepos() {
        return this.repos;
    }

    public final void setRepos(APIRepository aPIRepository) {
        this.repos = aPIRepository;
    }

    public final Job getPage(String str, String str2, String str3) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PageViewModel$getPage$1(str, str2, str3, this, null), 3, null);
        return launch$default;
    }
}

package com.lagradost.cloudstream3.p041ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.APIRepository;
import com.lagradost.cloudstream3.p041ui.WatchType;
import java.util.EnumSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: HomeViewModel.kt */
@Metadata(m108d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020\"H\u0002J\u0012\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010)\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010)\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010\u0005J\u0006\u0010,\u001a\u00020\u001cJ\u0016\u0010-\u001a\u00020\u001c2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0006\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R/\u0010\u0017\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R)\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00070\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001f\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u0006/"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_apiName", "Landroidx/lifecycle/MutableLiveData;", "", "_availableWatchStatusTypes", "Lkotlin/Pair;", "Ljava/util/EnumSet;", "Lcom/lagradost/cloudstream3/ui/WatchType;", "_bookmarks", "", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "_page", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "_randomItems", "_resumeWatching", "apiName", "Landroidx/lifecycle/LiveData;", "getApiName", "()Landroidx/lifecycle/LiveData;", "availableWatchStatusTypes", "getAvailableWatchStatusTypes", "bookmarks", "getBookmarks", "onGoingLoad", "Lkotlinx/coroutines/Job;", "page", "getPage", "randomItems", "getRandomItems", "repo", "Lcom/lagradost/cloudstream3/ui/APIRepository;", "resumeWatching", "getResumeWatching", "autoloadRepo", "load", "api", "Lcom/lagradost/cloudstream3/MainAPI;", "loadAndCancel", "", "preferredApiName", "loadResumeWatching", "loadStoredData", "preferredWatchStatus", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeViewModel */
/* loaded from: classes3.dex */
public final class HomeViewModel extends ViewModel {
    private final MutableLiveData<String> _apiName;
    private final MutableLiveData<Tuples<EnumSet<WatchType>, EnumSet<WatchType>>> _availableWatchStatusTypes;
    private final MutableLiveData<Tuples<Boolean, List<SearchResponse>>> _bookmarks;
    private final MutableLiveData<Resource<HomePageResponse>> _page;
    private final MutableLiveData<List<SearchResponse>> _randomItems;
    private final MutableLiveData<List<SearchResponse>> _resumeWatching;
    private final LiveData<String> apiName;
    private final LiveData<Tuples<EnumSet<WatchType>, EnumSet<WatchType>>> availableWatchStatusTypes;
    private final LiveData<Tuples<Boolean, List<SearchResponse>>> bookmarks;
    private Job onGoingLoad;
    private final LiveData<Resource<HomePageResponse>> page;
    private final LiveData<List<SearchResponse>> randomItems;
    private APIRepository repo;
    private final LiveData<List<SearchResponse>> resumeWatching;

    public HomeViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._apiName = mutableLiveData;
        this.apiName = mutableLiveData;
        MutableLiveData<Resource<HomePageResponse>> mutableLiveData2 = new MutableLiveData<>();
        this._page = mutableLiveData2;
        this.page = mutableLiveData2;
        MutableLiveData<List<SearchResponse>> mutableLiveData3 = new MutableLiveData<>(null);
        this._randomItems = mutableLiveData3;
        this.randomItems = mutableLiveData3;
        MutableLiveData<Tuples<EnumSet<WatchType>, EnumSet<WatchType>>> mutableLiveData4 = new MutableLiveData<>();
        this._availableWatchStatusTypes = mutableLiveData4;
        this.availableWatchStatusTypes = mutableLiveData4;
        MutableLiveData<Tuples<Boolean, List<SearchResponse>>> mutableLiveData5 = new MutableLiveData<>();
        this._bookmarks = mutableLiveData5;
        this.bookmarks = mutableLiveData5;
        MutableLiveData<List<SearchResponse>> mutableLiveData6 = new MutableLiveData<>();
        this._resumeWatching = mutableLiveData6;
        this.resumeWatching = mutableLiveData6;
    }

    public final LiveData<String> getApiName() {
        return this.apiName;
    }

    public final LiveData<Resource<HomePageResponse>> getPage() {
        return this.page;
    }

    public final LiveData<List<SearchResponse>> getRandomItems() {
        return this.randomItems;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final APIRepository autoloadRepo() {
        for (MainAPI mainAPI : APIHolder.INSTANCE.getApis()) {
            if (mainAPI.getHasMainPage()) {
                return new APIRepository(mainAPI, null, 2, null);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final LiveData<Tuples<EnumSet<WatchType>, EnumSet<WatchType>>> getAvailableWatchStatusTypes() {
        return this.availableWatchStatusTypes;
    }

    public final LiveData<Tuples<Boolean, List<SearchResponse>>> getBookmarks() {
        return this.bookmarks;
    }

    public final LiveData<List<SearchResponse>> getResumeWatching() {
        return this.resumeWatching;
    }

    public final Job loadResumeWatching() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$loadResumeWatching$1(this, null), 3, null);
        return launch$default;
    }

    public final Job loadStoredData(EnumSet<WatchType> enumSet) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$loadStoredData$1(this, enumSet, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadAndCancel(MainAPI mainAPI) {
        Job job = this.onGoingLoad;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.onGoingLoad = load(mainAPI);
    }

    private final Job load(MainAPI mainAPI) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$load$1(this, mainAPI, null), 3, null);
        return launch$default;
    }

    public final Job loadAndCancel(String str) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeViewModel$loadAndCancel$1(str, this, null), 3, null);
        return launch$default;
    }
}

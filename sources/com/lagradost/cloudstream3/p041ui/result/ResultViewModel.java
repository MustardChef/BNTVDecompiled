package com.lagradost.cloudstream3.p041ui.result;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.animeproviders.NineAnimeProvider;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.APIRepository;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.p041ui.player.IGenerator;
import com.lagradost.cloudstream3.p041ui.player.RepoLinkGenerator;
import com.lagradost.cloudstream3.p041ui.player.SubtitleData;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.internal.progressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: ResultViewModel.kt */
@Metadata(m108d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 l2\u00020\u0001:\u0001lB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010G\u001a\u00020\u00152\u0006\u0010H\u001a\u00020\u00152\b\u0010I\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0007J\u0015\u0010M\u001a\u00020K2\b\u0010N\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010OJ\u0015\u0010P\u001a\u00020K2\b\u0010Q\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010OJ1\u0010R\u001a\u00020K2\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010Q\u001a\u0004\u0018\u00010\u00122\b\u0010N\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010TJ\u0014\u0010U\u001a\u0004\u0018\u00010\u00052\b\u0010V\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010W\u001a\u0004\u0018\u00010(2\u0006\u0010X\u001a\u00020\u000bJ\u001e\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020]JI\u0010^\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\r0_0\u00102\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020]2\b\b\u0002\u0010c\u001a\u00020]H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010dJ\u0019\u0010e\u001a\u00020K2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010OJ\u0006\u0010g\u001a\u00020KJ\u000e\u0010h\u001a\u00020K2\u0006\u0010I\u001a\u00020-J/\u0010i\u001a\u00020K2\b\u0010f\u001a\u0004\u0018\u00010\u00122\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010Q\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0002\u0010jJ\u000e\u0010k\u001a\u00020Z2\u0006\u0010L\u001a\u00020\u0017R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR+\u0010\u001e\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t0\u00198F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\r0\u00198F¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR0\u0010\"\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120#j\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012`$0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00198F¢\u0006\u0006\u001a\u0004\b&\u0010\u001bR\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00100\u00198F¢\u0006\u0006\u001a\u0004\b5\u0010\u001bR\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u00120\u00198F¢\u0006\u0006\u001a\u0004\b7\u0010\u001bR\u001d\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\u0019¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001bR\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00100\u00198F¢\u0006\u0006\u001a\u0004\b=\u0010\u001bR\u001f\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\n0\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010+R\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010+R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00170\u00198F¢\u0006\u0006\u001a\u0004\bF\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006m"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_apiName", "Landroidx/lifecycle/MutableLiveData;", "", "_dubStatus", "Lcom/lagradost/cloudstream3/DubStatus;", "_dubSubEpisodes", "", "", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "_dubSubSelections", "", "_episodes", "_publicEpisodes", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "_publicEpisodesCount", "", "_rangeOptions", "_resultResponse", "Lcom/lagradost/cloudstream3/LoadResponse;", "_watchStatus", "Lcom/lagradost/cloudstream3/ui/WatchType;", "apiName", "Landroidx/lifecycle/LiveData;", "getApiName", "()Landroidx/lifecycle/LiveData;", "dubStatus", "getDubStatus", "dubSubEpisodes", "getDubSubEpisodes", "dubSubSelections", "getDubSubSelections", "episodeById", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "episodes", "getEpisodes", "generator", "Lcom/lagradost/cloudstream3/ui/player/IGenerator;", "id", "getId", "()Landroidx/lifecycle/MutableLiveData;", "lastMeta", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "getLastMeta", "()Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "setLastMeta", "(Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;)V", "loadResponseVM", "page", "publicEpisodes", "getPublicEpisodes", "publicEpisodesCount", "getPublicEpisodesCount", "rangeOptions", "getRangeOptions", "repo", "Lcom/lagradost/cloudstream3/ui/APIRepository;", "result", "getResult", "seasonSelections", "getSeasonSelections", "selectedRange", "getSelectedRange", "selectedRangeInt", "selectedSeason", "getSelectedSeason", "watchStatus", "getWatchStatus", "applyMeta", "resp", "meta", "changeDubStatus", "", "status", "changeRange", SessionDescription.ATTR_RANGE, "(Ljava/lang/Integer;)V", "changeSeason", "selection", "filterEpisodes", "list", "(Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "filterName", "name", "getGenerator", "episode", "load", "Lkotlinx/coroutines/Job;", "url", "showFillers", "", "loadEpisode", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "isCasting", "clearCache", "(Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadWatchStatus", "localId", "reloadEpisodes", "setMeta", "updateEpisodes", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;)V", "updateWatchStatus", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel */
/* loaded from: classes4.dex */
public final class ResultViewModel extends ViewModel {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "RVM";
    private MutableLiveData<String> _apiName;
    private final MutableLiveData<DubStatus> _dubStatus;
    private final MutableLiveData<Map<DubStatus, List<ResultEpisode>>> _dubSubEpisodes;
    private final MutableLiveData<Set<DubStatus>> _dubSubSelections;
    private final MutableLiveData<List<String>> _rangeOptions;
    private final MutableLiveData<WatchType> _watchStatus;
    private IGenerator generator;

    /* renamed from: id */
    private final MutableLiveData<Integer> f10022id;
    private SyncAPI.SyncResult lastMeta;
    private LoadResponse loadResponseVM;
    private final MutableLiveData<LoadResponse> page;
    private final LiveData<List<String>> rangeOptions;
    private APIRepository repo;
    private final MutableLiveData<List<Integer>> seasonSelections;
    private final MutableLiveData<String> selectedRange;
    private final MutableLiveData<Integer> selectedRangeInt;
    private final MutableLiveData<Integer> selectedSeason;
    private final MutableLiveData<Resource<LoadResponse>> _resultResponse = new MutableLiveData<>();
    private final MutableLiveData<List<ResultEpisode>> _episodes = new MutableLiveData<>();
    private final MutableLiveData<HashMap<Integer, Integer>> episodeById = new MutableLiveData<>();
    private final MutableLiveData<Resource<List<ResultEpisode>>> _publicEpisodes = new MutableLiveData<>();
    private final MutableLiveData<Integer> _publicEpisodesCount = new MutableLiveData<>();

    public ResultViewModel() {
        MutableLiveData<List<String>> mutableLiveData = new MutableLiveData<>();
        this._rangeOptions = mutableLiveData;
        this.selectedRange = new MutableLiveData<>();
        this.selectedRangeInt = new MutableLiveData<>();
        this.rangeOptions = mutableLiveData;
        this._dubStatus = new MutableLiveData<>();
        this.page = new MutableLiveData<>();
        this.f10022id = new MutableLiveData<>();
        this.selectedSeason = new MutableLiveData<>(-2);
        this.seasonSelections = new MutableLiveData<>();
        this._dubSubSelections = new MutableLiveData<>();
        this._dubSubEpisodes = new MutableLiveData<>();
        this._watchStatus = new MutableLiveData<>();
        this._apiName = new MutableLiveData<>();
    }

    public final MutableLiveData<String> getSelectedRange() {
        return this.selectedRange;
    }

    public final LiveData<List<String>> getRangeOptions() {
        return this.rangeOptions;
    }

    public final LiveData<Resource<LoadResponse>> getResult() {
        return this._resultResponse;
    }

    public final LiveData<List<ResultEpisode>> getEpisodes() {
        return this._episodes;
    }

    public final LiveData<Resource<List<ResultEpisode>>> getPublicEpisodes() {
        return this._publicEpisodes;
    }

    public final LiveData<Integer> getPublicEpisodesCount() {
        return this._publicEpisodesCount;
    }

    public final LiveData<DubStatus> getDubStatus() {
        return this._dubStatus;
    }

    public final MutableLiveData<Integer> getId() {
        return this.f10022id;
    }

    public final MutableLiveData<Integer> getSelectedSeason() {
        return this.selectedSeason;
    }

    public final MutableLiveData<List<Integer>> getSeasonSelections() {
        return this.seasonSelections;
    }

    public final LiveData<Set<DubStatus>> getDubSubSelections() {
        return this._dubSubSelections;
    }

    public final LiveData<Map<DubStatus, List<ResultEpisode>>> getDubSubEpisodes() {
        return this._dubSubEpisodes;
    }

    public final LiveData<WatchType> getWatchStatus() {
        return this._watchStatus;
    }

    public final Job updateWatchStatus(WatchType status) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(status, "status");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ResultViewModel$updateWatchStatus$1(this, status, null), 3, null);
        return launch$default;
    }

    /* compiled from: ResultViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/ResultViewModel$Companion;", "", "()V", "TAG", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultViewModel$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final SyncAPI.SyncResult getLastMeta() {
        return this.lastMeta;
    }

    public final void setLastMeta(SyncAPI.SyncResult syncResult) {
        this.lastMeta = syncResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadResponse applyMeta(LoadResponse loadResponse, SyncAPI.SyncResult syncResult) {
        ArrayList arrayList;
        Set union;
        SyncAPI.SyncSearchResult copy;
        if (syncResult == null) {
            return loadResponse;
        }
        this.lastMeta = syncResult;
        Log.i(TAG, "applyMeta");
        Integer duration = loadResponse.getDuration();
        if (duration == null) {
            duration = syncResult.getDuration();
        }
        loadResponse.setDuration(duration);
        Integer rating = loadResponse.getRating();
        if (rating == null) {
            rating = syncResult.getPublicScore();
        }
        loadResponse.setRating(rating);
        List<String> tags = loadResponse.getTags();
        if (tags == null) {
            tags = syncResult.getGenres();
        }
        loadResponse.setTags(tags);
        String plot = loadResponse.getPlot();
        loadResponse.setPlot(plot == null || StringsKt.isBlank(plot) ? syncResult.getSynopsis() : loadResponse.getPlot());
        LoadResponse.Companion.addTrailer(loadResponse, syncResult.getTrailerUrl());
        String posterUrl = loadResponse.getPosterUrl();
        if (posterUrl == null && (posterUrl = syncResult.getPosterUrl()) == null) {
            posterUrl = syncResult.getBackgroundPosterUrl();
        }
        loadResponse.setPosterUrl(posterUrl);
        List<ActorData> actors = loadResponse.getActors();
        if (actors == null) {
            actors = syncResult.getActors();
        }
        loadResponse.setActors(actors);
        ArrayList arrayList2 = new ArrayList();
        List<String> listOf = CollectionsKt.listOf(new NineAnimeProvider().getName());
        List<SyncAPI.SyncSearchResult> recommendations = syncResult.getRecommendations();
        if (recommendations != null) {
            for (SyncAPI.SyncSearchResult syncSearchResult : recommendations) {
                for (String str : listOf) {
                    copy = syncSearchResult.copy((r20 & 1) != 0 ? syncSearchResult.getName() : null, (r20 & 2) != 0 ? syncSearchResult.getApiName() : str, (r20 & 4) != 0 ? syncSearchResult.syncId : null, (r20 & 8) != 0 ? syncSearchResult.getUrl() : null, (r20 & 16) != 0 ? syncSearchResult.getPosterUrl() : null, (r20 & 32) != 0 ? syncSearchResult.getType() : null, (r20 & 64) != 0 ? syncSearchResult.getQuality() : null, (r20 & 128) != 0 ? syncSearchResult.getPosterHeaders() : null, (r20 & 256) != 0 ? syncSearchResult.getId() : null);
                    arrayList2.add(copy);
                }
            }
        }
        List<SearchResponse> recommendations2 = loadResponse.getRecommendations();
        if (recommendations2 == null || (union = CollectionsKt.union(recommendations2, arrayList2)) == null || (arrayList = CollectionsKt.toList(union)) == null) {
            arrayList = arrayList2;
        }
        loadResponse.setRecommendations(arrayList);
        return loadResponse;
    }

    public final void setMeta(SyncAPI.SyncResult meta) {
        LoadResponse loadResponse;
        Intrinsics.checkNotNullParameter(meta, "meta");
        Log.i(TAG, "setMeta");
        Resource<LoadResponse> value = getResult().getValue();
        Resource.Success success = value instanceof Resource.Success ? (Resource.Success) value : null;
        if (success == null || (loadResponse = (LoadResponse) success.getValue()) == null) {
            return;
        }
        this._resultResponse.postValue(new Resource.Success(applyMeta(loadResponse, meta)));
    }

    static /* synthetic */ void loadWatchStatus$default(ResultViewModel resultViewModel, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        resultViewModel.loadWatchStatus(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadWatchStatus(Integer num) {
        if (num == null && (num = this.f10022id.getValue()) == null) {
            return;
        }
        this._watchStatus.postValue(DataStoreHelper.INSTANCE.getResultWatchState(num.intValue()));
    }

    private final void filterEpisodes(List<ResultEpisode> list, Integer num, Integer num2) {
        Integer value;
        int intValue;
        if (list == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (ResultEpisode resultEpisode : list) {
            if (!hashMap.containsKey(resultEpisode.getSeason())) {
                hashMap.put(resultEpisode.getSeason(), true);
            }
        }
        List<Tuples> list2 = MapsKt.toList(hashMap);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (Tuples tuples : list2) {
            arrayList.add((Integer) tuples.getFirst());
        }
        List<Integer> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.lagradost.cloudstream3.ui.result.ResultViewModel$filterEpisodes$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) t, (Integer) t2);
            }
        });
        this.seasonSelections.postValue(sortedWith);
        if (sortedWith.isEmpty()) {
            this._publicEpisodes.postValue(new Resource.Success(CollectionsKt.emptyList()));
            return;
        }
        Integer num3 = !hashMap.containsKey(num) ? (Integer) CollectionsKt.first((List<? extends Object>) sortedWith) : num;
        Integer value2 = this.f10022id.getValue();
        if (value2 != null) {
            DataStoreHelper.INSTANCE.setResultSeason(value2.intValue(), num3);
        }
        this.selectedSeason.postValue(Integer.valueOf(num3 != null ? num3.intValue() : -2));
        List arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((ResultEpisode) obj).getSeason(), num3)) {
                arrayList2.add(obj);
            }
        }
        List list3 = arrayList2;
        this._publicEpisodesCount.postValue(Integer.valueOf(list3.size()));
        ArrayList arrayList3 = new ArrayList();
        int progressionLastElement = progressionUtil.getProgressionLastElement(0, list3.size() - 1, 50);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 50;
                if (i2 < list3.size()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i + 1);
                    sb.append('-');
                    sb.append(i2);
                    arrayList3.add(sb.toString());
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i + 1);
                    sb2.append('-');
                    sb2.append(list3.size());
                    arrayList3.add(sb2.toString());
                }
                if (i == progressionLastElement) {
                    break;
                }
                i = i2;
            }
        }
        if (num2 != null) {
            intValue = num2.intValue();
        } else {
            if (num != null) {
                value = 0;
            } else {
                value = this.selectedRangeInt.getValue();
                if (value == null) {
                    value = 0;
                }
            }
            intValue = value.intValue();
        }
        if (intValue * 50 > list3.size()) {
            intValue = list3.size() / 50;
        }
        if (list3.size() > 60) {
            list3 = list3.subList(intValue * 50, Math.min(list3.size(), (intValue + 1) * 50));
            this._rangeOptions.postValue(arrayList3);
            this.selectedRangeInt.postValue(Integer.valueOf(intValue));
            this.selectedRange.postValue(arrayList3.get(intValue));
        } else {
            String str = "1-" + list3.size();
            this._rangeOptions.postValue(CollectionsKt.listOf(str));
            this.selectedRangeInt.postValue(0);
            this.selectedRange.postValue(str);
        }
        this._publicEpisodes.postValue(new Resource.Success(list3));
    }

    public final void changeSeason(Integer num) {
        filterEpisodes(this._episodes.getValue(), num, null);
    }

    public final void changeRange(Integer num) {
        filterEpisodes(this._episodes.getValue(), null, num);
    }

    public final void changeDubStatus(DubStatus dubStatus) {
        Map<DubStatus, List<ResultEpisode>> value;
        List<ResultEpisode> list;
        if (dubStatus == null || (value = getDubSubEpisodes().getValue()) == null || (list = value.get(dubStatus)) == null) {
            return;
        }
        Integer it = this.f10022id.getValue();
        if (it != null) {
            DataStoreHelper dataStoreHelper = DataStoreHelper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dataStoreHelper.setDub(it.intValue(), dubStatus);
        }
        this._dubStatus.postValue(dubStatus);
        updateEpisodes(null, list, null);
    }

    public static /* synthetic */ Object loadEpisode$default(ResultViewModel resultViewModel, ResultEpisode resultEpisode, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return resultViewModel.loadEpisode(resultEpisode, z, z2, continuation);
    }

    public final Object loadEpisode(ResultEpisode resultEpisode, boolean z, boolean z2, Continuation<? super Resource<? extends Tuples<? extends Set<? extends ExtractorLink>, ? extends Set<SubtitleData>>>> continuation) {
        return ArchComponentExt.safeApiCall(new ResultViewModel$loadEpisode$2(this, resultEpisode, z2, z, null), continuation);
    }

    public final IGenerator getGenerator(ResultEpisode episode) {
        Intrinsics.checkNotNullParameter(episode, "episode");
        List<ResultEpisode> value = this._episodes.getValue();
        int indexOf = value != null ? value.indexOf(episode) : episode.getIndex();
        IGenerator iGenerator = this.generator;
        if (iGenerator != null) {
            iGenerator.mo8669goto(indexOf);
        }
        return this.generator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEpisodes(Integer num, List<ResultEpisode> list, Integer num2) {
        this._episodes.postValue(list);
        this.generator = new RepoLinkGenerator(list, 0, this.loadResponseVM, 2, null);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer value = this.selectedRangeInt.getValue();
        for (IndexedValue indexedValue : CollectionsKt.withIndex(list)) {
            hashMap.put(Integer.valueOf(((ResultEpisode) indexedValue.getValue()).getId()), Integer.valueOf(indexedValue.getIndex()));
        }
        this.episodeById.postValue(hashMap);
        if (num2 != null && num2.intValue() == -1) {
            DataStoreHelper dataStoreHelper = DataStoreHelper.INSTANCE;
            if (num == null && (num = this.f10022id.getValue()) == null) {
                return;
            }
            num2 = Integer.valueOf(dataStoreHelper.getResultSeason(num.intValue()));
        }
        filterEpisodes(list, num2, value);
    }

    public final void reloadEpisodes() {
        ResultEpisode copy;
        List<ResultEpisode> value = this._episodes.getValue();
        if (value == null) {
            return;
        }
        List<ResultEpisode> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ResultEpisode resultEpisode : list) {
            DataStoreHelper.PosDur viewPos = DataStoreHelper.INSTANCE.getViewPos(Integer.valueOf(resultEpisode.getId()));
            long j = 0;
            long position = viewPos != null ? viewPos.getPosition() : 0L;
            if (viewPos != null) {
                j = viewPos.getDuration();
            }
            copy = resultEpisode.copy((r36 & 1) != 0 ? resultEpisode.headerName : null, (r36 & 2) != 0 ? resultEpisode.name : null, (r36 & 4) != 0 ? resultEpisode.poster : null, (r36 & 8) != 0 ? resultEpisode.episode : 0, (r36 & 16) != 0 ? resultEpisode.season : null, (r36 & 32) != 0 ? resultEpisode.data : null, (r36 & 64) != 0 ? resultEpisode.apiName : null, (r36 & 128) != 0 ? resultEpisode.f10017id : 0, (r36 & 256) != 0 ? resultEpisode.index : 0, (r36 & 512) != 0 ? resultEpisode.position : position, (r36 & 1024) != 0 ? resultEpisode.duration : j, (r36 & 2048) != 0 ? resultEpisode.rating : null, (r36 & 4096) != 0 ? resultEpisode.description : null, (r36 & 8192) != 0 ? resultEpisode.isFiller : null, (r36 & 16384) != 0 ? resultEpisode.tvType : null, (r36 & 32768) != 0 ? resultEpisode.parentId : 0);
            arrayList.add(copy);
        }
        updateEpisodes(null, arrayList, this.selectedSeason.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String filterName(String str) {
        List<String> groupValues;
        String str2;
        if (str == null) {
            return null;
        }
        MatchResult find$default = Regex.find$default(new Regex("[eE]pisode [0-9]*(.*)"), str, 0, 2, null);
        if (find$default != null && (groupValues = find$default.getGroupValues()) != null && (str2 = groupValues.get(1)) != null) {
            if (str2.length() == 0) {
                return null;
            }
        }
        return str;
    }

    public final Job load(String url, String apiName, boolean z) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ResultViewModel$load$1(this, url, apiName, z, null), 3, null);
        return launch$default;
    }

    public final LiveData<String> getApiName() {
        return this._apiName;
    }
}

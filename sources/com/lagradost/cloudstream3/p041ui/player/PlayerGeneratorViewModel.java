package com.lagradost.cloudstream3.p041ui.player;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.browser.SubtitleBrowserRepository;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorUri;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: PlayerGeneratorViewModel.kt */
@Metadata(m108d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\u0010\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u0019J*\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0(J\r\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u0010+J\b\u0010,\u001a\u0004\u0018\u00010\u000fJ\b\u0010-\u001a\u0004\u0018\u00010\u000fJ\r\u0010.\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010/J\u001a\u00100\u001a\u00020\u001f2\b\b\u0002\u00101\u001a\u00020\r2\b\b\u0002\u00102\u001a\u00020\rJ\u000e\u00100\u001a\u00020\u001f2\u0006\u00103\u001a\u00020*J\u0006\u00104\u001a\u00020\u001fJ\u0006\u00105\u001a\u00020\u001fJ\u0014\u00106\u001a\u00020\u001f2\f\u00107\u001a\b\u0012\u0004\u0012\u00020&08J\u0006\u00109\u001a\u00020\u001fJ\u0006\u0010:\u001a\u00020\u001fJ\"\u0010;\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0(R*\u0010\u0003\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u00050\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f0\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006="}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/PlayerGeneratorViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_currentLinks", "Landroidx/lifecycle/MutableLiveData;", "", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "Lcom/lagradost/cloudstream3/utils/ExtractorUri;", "_currentSubs", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "_loadingLinks", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "_notifyData", "", "currentJob", "Lkotlinx/coroutines/Job;", "currentLinks", "Landroidx/lifecycle/LiveData;", "getCurrentLinks", "()Landroidx/lifecycle/LiveData;", "currentSubs", "getCurrentSubs", "generator", "Lcom/lagradost/cloudstream3/ui/player/IGenerator;", "loadingLinks", "getLoadingLinks", "notifyData", "getNotifyData", "addSubtitles", "", "file", "attachGenerator", "newGenerator", "extrasZipSubtitle", "subtitleFileZip", "fileDir", "", "callback", "Lkotlin/Function1;", "getId", "", "()Ljava/lang/Integer;", "getMeta", "getNextMeta", "hasNextEpisode", "()Ljava/lang/Boolean;", "loadLinks", "clearCache", "isCasting", "episode", "loadLinksNext", "loadLinksPrev", "notifyToPlayer", "listSubPath", "", "preLoadNextLinks", "refreshData", "uploadFileSub", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel */
/* loaded from: classes3.dex */
public final class PlayerGeneratorViewModel extends ViewModel {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "PlayViewGen";
    private final MutableLiveData<Set<Tuples<ExtractorLink, ExtractorUri>>> _currentLinks;
    private final MutableLiveData<Set<SubtitleData>> _currentSubs;
    private final MutableLiveData<Resource<Boolean>> _loadingLinks;
    private final MutableLiveData<Resource<Object>> _notifyData;
    private Job currentJob;
    private final LiveData<Set<Tuples<ExtractorLink, ExtractorUri>>> currentLinks;
    private final LiveData<Set<SubtitleData>> currentSubs;
    private IGenerator generator;
    private final LiveData<Resource<Boolean>> loadingLinks;

    public final void refreshData() {
    }

    /* compiled from: PlayerGeneratorViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/player/PlayerGeneratorViewModel$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.PlayerGeneratorViewModel$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return PlayerGeneratorViewModel.TAG;
        }
    }

    public PlayerGeneratorViewModel() {
        MutableLiveData<Set<Tuples<ExtractorLink, ExtractorUri>>> mutableLiveData = new MutableLiveData<>(SetsKt.emptySet());
        this._currentLinks = mutableLiveData;
        this.currentLinks = mutableLiveData;
        MutableLiveData<Set<SubtitleData>> mutableLiveData2 = new MutableLiveData<>(SetsKt.emptySet());
        this._currentSubs = mutableLiveData2;
        this.currentSubs = mutableLiveData2;
        MutableLiveData<Resource<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this._loadingLinks = mutableLiveData3;
        this.loadingLinks = mutableLiveData3;
        this._notifyData = new MutableLiveData<>();
    }

    public final LiveData<Set<Tuples<ExtractorLink, ExtractorUri>>> getCurrentLinks() {
        return this.currentLinks;
    }

    public final LiveData<Set<SubtitleData>> getCurrentSubs() {
        return this.currentSubs;
    }

    public final LiveData<Resource<Boolean>> getLoadingLinks() {
        return this.loadingLinks;
    }

    public final LiveData<Resource<Object>> getNotifyData() {
        return this._notifyData;
    }

    public final void notifyToPlayer(List<String> listSubPath) {
        Intrinsics.checkNotNullParameter(listSubPath, "listSubPath");
        this._notifyData.postValue(new Resource.Success(listSubPath));
    }

    public final Integer getId() {
        IGenerator iGenerator = this.generator;
        if (iGenerator != null) {
            return iGenerator.getCurrentId();
        }
        return null;
    }

    public final void loadLinks(int i) {
        IGenerator iGenerator = this.generator;
        if (iGenerator != null) {
            iGenerator.mo8669goto(i);
        }
        loadLinks$default(this, false, false, 3, null);
    }

    public final void loadLinksPrev() {
        Log.i(TAG, "loadLinksPrev");
        IGenerator iGenerator = this.generator;
        boolean z = true;
        if ((iGenerator == null || !iGenerator.hasPrev()) ? false : false) {
            IGenerator iGenerator2 = this.generator;
            if (iGenerator2 != null) {
                iGenerator2.prev();
            }
            loadLinks$default(this, false, false, 3, null);
        }
    }

    public final void loadLinksNext() {
        Log.i(TAG, "loadLinksNext");
        IGenerator iGenerator = this.generator;
        boolean z = true;
        if ((iGenerator == null || !iGenerator.hasNext()) ? false : false) {
            IGenerator iGenerator2 = this.generator;
            if (iGenerator2 != null) {
                iGenerator2.next();
            }
            loadLinks$default(this, false, false, 3, null);
        }
    }

    public final Boolean hasNextEpisode() {
        IGenerator iGenerator = this.generator;
        if (iGenerator != null) {
            return Boolean.valueOf(iGenerator.hasNext());
        }
        return null;
    }

    public final void preLoadNextLinks() {
        Job launch$default;
        Log.i(TAG, "preLoadNextLinks");
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerGeneratorViewModel$preLoadNextLinks$1(this, null), 3, null);
        this.currentJob = launch$default;
    }

    public final Object getMeta() {
        return ArchComponentExt.normalSafeApiCall(new PlayerGeneratorViewModel$getMeta$1(this));
    }

    public final Object getNextMeta() {
        return ArchComponentExt.normalSafeApiCall(new PlayerGeneratorViewModel$getNextMeta$1(this));
    }

    public final void attachGenerator(IGenerator iGenerator) {
        if (this.generator == null) {
            this.generator = iGenerator;
        }
    }

    public final void addSubtitles(Set<SubtitleData> file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Set<SubtitleData> value = this._currentSubs.getValue();
        if (value == null) {
            value = SetsKt.emptySet();
        }
        Set<SubtitleData> set = CollectionsKt.toSet(CollectionsKt.distinct(SetsKt.plus((Set) value, (Iterable) file)));
        if (Intrinsics.areEqual(set, value)) {
            return;
        }
        this._currentSubs.postValue(set);
        Log.d("BLUE", "addSubtitles postValue");
    }

    public static /* synthetic */ void loadLinks$default(PlayerGeneratorViewModel playerGeneratorViewModel, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        playerGeneratorViewModel.loadLinks(z, z2);
    }

    public final void loadLinks(boolean z, boolean z2) {
        Job launch$default;
        Log.i(TAG, "loadLinks");
        Job job = this.currentJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerGeneratorViewModel$loadLinks$1(this, z, z2, null), 3, null);
        this.currentJob = launch$default;
    }

    public final void uploadFileSub(String file, Function1<? super SubtitleData, Unit> callback) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Log.d("BLUE uploadFileSub", String.valueOf(file));
        new SubtitleBrowserRepository().uploadFile(new File(file), new PlayerGeneratorViewModel$uploadFileSub$1(this, callback));
    }

    public final void extrasZipSubtitle(SubtitleData subtitleFileZip, String fileDir, Function1<? super SubtitleData, Unit> callback) {
        Intrinsics.checkNotNullParameter(subtitleFileZip, "subtitleFileZip");
        Intrinsics.checkNotNullParameter(fileDir, "fileDir");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new PlayerGeneratorViewModel$extrasZipSubtitle$1(subtitleFileZip, fileDir, this, callback, null), 2, null);
    }
}

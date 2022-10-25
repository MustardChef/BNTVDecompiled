package com.lagradost.cloudstream3.p041ui.result;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import com.lagradost.cloudstream3.syncproviders.SyncRepo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: SyncViewModel.kt */
@Metadata(m108d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 D2\u00020\u0001:\u0001DB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\fJ\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0002J\u001c\u0010*\u001a\u00020'2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010,J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u001e\u0010.\u001a\u00020$2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e00H\u0002J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020$J\u0012\u00106\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u00107\u001a\u0002022\u0006\u00108\u001a\u000204J\u000e\u00109\u001a\u0002022\u0006\u0010:\u001a\u000204J\u0012\u0010;\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\fH\u0002J\u000e\u0010<\u001a\u0002022\u0006\u0010=\u001a\u000204J\u000e\u0010>\u001a\u0002022\u0006\u0010?\u001a\u000204J\u0006\u0010@\u001a\u000202J\b\u0010A\u001a\u00020$H\u0002J\u0006\u0010B\u001a\u000202J\u0006\u0010C\u001a\u00020$R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0010j\b\u0012\u0004\u0012\u00020\f`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\u00178F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b0\u00178F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0019¨\u0006E"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/SyncViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_currentSynced", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/lagradost/cloudstream3/ui/result/CurrentSynced;", "_metaResponse", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "_syncIds", "", "", "_userDataResponse", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;", "hasAddedFromUrl", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getHasAddedFromUrl", "()Ljava/util/HashSet;", "setHasAddedFromUrl", "(Ljava/util/HashSet;)V", TtmlNode.TAG_METADATA, "Landroidx/lifecycle/LiveData;", "getMetadata", "()Landroidx/lifecycle/LiveData;", "repos", "Lcom/lagradost/cloudstream3/syncproviders/SyncRepo;", "syncIds", "getSyncIds", "synced", "getSynced", "syncs", "userData", "getUserData", "addFromUrl", "Lkotlinx/coroutines/Job;", "url", "addSync", "", "idPrefix", "id", "addSyncs", "map", "", "getMissing", "modifyData", "update", "Lkotlin/Function1;", "modifyMaxEpisode", "", "episodeNum", "", "publishUserData", "setAniListId", "setEpisodes", "episodes", "setEpisodesDelta", "delta", "setMalId", "setScore", "score", "setStatus", "which", "updateMetaAndUser", "updateMetadata", "updateSynced", "updateUserData", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.SyncViewModel */
/* loaded from: classes4.dex */
public final class SyncViewModel extends ViewModel {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "SYNCVM";
    private final List<SyncRepo> repos = AccountManager.Companion.getSyncApis();
    private final MutableLiveData<Resource<SyncAPI.SyncResult>> _metaResponse = new MutableLiveData<>();
    private final MutableLiveData<Resource<SyncAPI.SyncStatus>> _userDataResponse = new MutableLiveData<>(null);
    private Map<String, String> syncs = new LinkedHashMap();
    private final MutableLiveData<Map<String, String>> _syncIds = new MutableLiveData<>(new LinkedHashMap());
    private final MutableLiveData<List<CurrentSynced>> _currentSynced = new MutableLiveData<>(getMissing());
    private HashSet<String> hasAddedFromUrl = new HashSet<>();

    /* compiled from: SyncViewModel.kt */
    @Metadata(m108d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/result/SyncViewModel$Companion;", "", "()V", "TAG", "", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.SyncViewModel$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final LiveData<Resource<SyncAPI.SyncResult>> getMetadata() {
        return this._metaResponse;
    }

    public final LiveData<Resource<SyncAPI.SyncStatus>> getUserData() {
        return this._userDataResponse;
    }

    public final LiveData<Map<String, String>> getSyncIds() {
        return this._syncIds;
    }

    public final LiveData<List<CurrentSynced>> getSynced() {
        return this._currentSynced;
    }

    private final List<CurrentSynced> getMissing() {
        List<SyncRepo> list = this.repos;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SyncRepo syncRepo : list) {
            arrayList.add(new CurrentSynced(syncRepo.getName(), syncRepo.getIdPrefix(), this.syncs.containsKey(syncRepo.getIdPrefix()), syncRepo.hasAccount(), syncRepo.getIcon()));
        }
        return arrayList;
    }

    public final void updateSynced() {
        Log.i(TAG, "updateSynced");
        this._currentSynced.postValue(getMissing());
    }

    private final boolean addSync(String str, String str2) {
        if (Intrinsics.areEqual(this.syncs.get(str), str2)) {
            return false;
        }
        Log.i(TAG, "addSync " + str + " = " + str2);
        this.syncs.put(str, str2);
        this._syncIds.postValue(this.syncs);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setMalId(String str) {
        String idPrefix = AccountManager.Companion.getMalApi().getIdPrefix();
        if (str == null) {
            return false;
        }
        return addSync(idPrefix, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setAniListId(String str) {
        String idPrefix = AccountManager.Companion.getAniListApi().getIdPrefix();
        if (str == null) {
            return false;
        }
        return addSync(idPrefix, str);
    }

    public final HashSet<String> getHasAddedFromUrl() {
        return this.hasAddedFromUrl;
    }

    public final void setHasAddedFromUrl(HashSet<String> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.hasAddedFromUrl = hashSet;
    }

    public final Job addFromUrl(String str) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SyncViewModel$addFromUrl$1(str, this, null), 3, null);
        return launch$default;
    }

    public final void setEpisodesDelta(int i) {
        Integer watchedEpisodes;
        Log.i(TAG, "setEpisodesDelta = " + i);
        Resource<SyncAPI.SyncStatus> value = getUserData().getValue();
        if (!(value instanceof Resource.Success) || (watchedEpisodes = ((SyncAPI.SyncStatus) ((Resource.Success) value).getValue()).getWatchedEpisodes()) == null) {
            return;
        }
        setEpisodes(watchedEpisodes.intValue() + i);
    }

    public final void setEpisodes(int i) {
        Integer totalEpisodes;
        int intValue;
        Log.i(TAG, "setEpisodes = " + i);
        if (i < 0) {
            return;
        }
        Resource<SyncAPI.SyncResult> value = getMetadata().getValue();
        if ((value instanceof Resource.Success) && (totalEpisodes = ((SyncAPI.SyncResult) ((Resource.Success) value).getValue()).getTotalEpisodes()) != null && i > (intValue = totalEpisodes.intValue())) {
            setEpisodes(intValue);
            return;
        }
        Resource<SyncAPI.SyncStatus> value2 = getUserData().getValue();
        if (value2 instanceof Resource.Success) {
            this._userDataResponse.postValue(new Resource.Success(SyncAPI.SyncStatus.copy$default((SyncAPI.SyncStatus) ((Resource.Success) value2).getValue(), 0, null, Integer.valueOf(i), null, null, 27, null)));
        }
    }

    public final void setScore(int i) {
        Log.i(TAG, "setScore = " + i);
        Resource<SyncAPI.SyncStatus> value = getUserData().getValue();
        if (value instanceof Resource.Success) {
            this._userDataResponse.postValue(new Resource.Success(SyncAPI.SyncStatus.copy$default((SyncAPI.SyncStatus) ((Resource.Success) value).getValue(), 0, Integer.valueOf(i), null, null, null, 29, null)));
        }
    }

    public final void setStatus(int i) {
        Log.i(TAG, "setStatus = " + i);
        if (i < -1 || i > 5) {
            return;
        }
        Resource<SyncAPI.SyncStatus> value = getUserData().getValue();
        if (value instanceof Resource.Success) {
            this._userDataResponse.postValue(new Resource.Success(SyncAPI.SyncStatus.copy$default((SyncAPI.SyncStatus) ((Resource.Success) value).getValue(), i, null, null, null, null, 30, null)));
        }
    }

    public final Job publishUserData() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SyncViewModel$publishUserData$1(this, null), 3, null);
        return launch$default;
    }

    public final void modifyMaxEpisode(int i) {
        Log.i(TAG, "modifyMaxEpisode = " + i);
        modifyData(new SyncViewModel$modifyMaxEpisode$1(i));
    }

    private final Job modifyData(Function1<? super SyncAPI.SyncStatus, SyncAPI.SyncStatus> function1) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SyncViewModel$modifyData$1(this, function1, null), 3, null);
        return launch$default;
    }

    public final Job updateUserData() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SyncViewModel$updateUserData$1(this, null), 3, null);
        return launch$default;
    }

    private final Job updateMetadata() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SyncViewModel$updateMetadata$1(this, null), 3, null);
        return launch$default;
    }

    public final void updateMetaAndUser() {
        Log.i(TAG, "updateMetaAndUser");
        updateMetadata();
        updateUserData();
    }

    public final boolean addSyncs(Map<String, String> map) {
        boolean z;
        if (map != null) {
            while (true) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    z = addSync(entry.getKey(), entry.getValue()) || z;
                }
                return z;
            }
        }
        return false;
    }
}

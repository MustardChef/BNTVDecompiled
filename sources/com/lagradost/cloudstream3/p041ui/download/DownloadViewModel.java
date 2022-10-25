package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: DownloadViewModel.kt */
@Metadata(m108d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006\u001d"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_availableBytes", "Landroidx/lifecycle/MutableLiveData;", "", "_downloadBytes", "_headerCards", "", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadHeaderCached;", "_noDownloadsText", "", "_usedBytes", "availableBytes", "Landroidx/lifecycle/LiveData;", "getAvailableBytes", "()Landroidx/lifecycle/LiveData;", "downloadBytes", "getDownloadBytes", "headerCards", "getHeaderCards", "noDownloadsText", "getNoDownloadsText", "usedBytes", "getUsedBytes", "updateList", "Lkotlinx/coroutines/Job;", "context", "Landroid/content/Context;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadViewModel */
/* loaded from: classes3.dex */
public final class DownloadViewModel extends ViewModel {
    private final MutableLiveData<Long> _availableBytes;
    private final MutableLiveData<Long> _downloadBytes;
    private final MutableLiveData<List<VisualDownloadHeaderCached>> _headerCards;
    private final MutableLiveData<String> _noDownloadsText;
    private final MutableLiveData<Long> _usedBytes;
    private final LiveData<Long> availableBytes;
    private final LiveData<Long> downloadBytes;
    private final LiveData<List<VisualDownloadHeaderCached>> headerCards;
    private final LiveData<String> noDownloadsText;
    private final LiveData<Long> usedBytes;

    public DownloadViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue("");
        this._noDownloadsText = mutableLiveData;
        this.noDownloadsText = mutableLiveData;
        MutableLiveData<List<VisualDownloadHeaderCached>> mutableLiveData2 = new MutableLiveData<>();
        CollectionsKt.emptyList();
        this._headerCards = mutableLiveData2;
        this.headerCards = mutableLiveData2;
        MutableLiveData<Long> mutableLiveData3 = new MutableLiveData<>();
        this._usedBytes = mutableLiveData3;
        MutableLiveData<Long> mutableLiveData4 = new MutableLiveData<>();
        this._availableBytes = mutableLiveData4;
        MutableLiveData<Long> mutableLiveData5 = new MutableLiveData<>();
        this._downloadBytes = mutableLiveData5;
        this.usedBytes = mutableLiveData3;
        this.availableBytes = mutableLiveData4;
        this.downloadBytes = mutableLiveData5;
    }

    public final LiveData<String> getNoDownloadsText() {
        return this.noDownloadsText;
    }

    public final LiveData<List<VisualDownloadHeaderCached>> getHeaderCards() {
        return this.headerCards;
    }

    public final LiveData<Long> getUsedBytes() {
        return this.usedBytes;
    }

    public final LiveData<Long> getAvailableBytes() {
        return this.availableBytes;
    }

    public final LiveData<Long> getDownloadBytes() {
        return this.downloadBytes;
    }

    public final Job updateList(Context context) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(context, "context");
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DownloadViewModel$updateList$1(this, context, null), 3, null);
        return launch$default;
    }
}

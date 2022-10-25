package com.lagradost.cloudstream3.p041ui.browser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lagradost.cloudstream3.mvvm.Resource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: SubtitleBrowserViewModel.kt */
@Metadata(m108d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0012R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001f\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_resultResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "repo", "Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserRepository;", "getRepo", "()Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserRepository;", "setRepo", "(Lcom/lagradost/cloudstream3/ui/browser/SubtitleBrowserRepository;)V", "resultResponse", "Landroidx/lifecycle/LiveData;", "getResultResponse", "()Landroidx/lifecycle/LiveData;", "downloadSubtitle", "", "url", "", "fileDir", "resetData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.browser.SubtitleBrowserViewModel */
/* loaded from: classes.dex */
public final class SubtitleBrowserViewModel extends ViewModel {
    private final MutableLiveData<Resource<Object>> _resultResponse = new MutableLiveData<>();
    private SubtitleBrowserRepository repo;

    public final void resetData() {
    }

    public final SubtitleBrowserRepository getRepo() {
        return this.repo;
    }

    public final void setRepo(SubtitleBrowserRepository subtitleBrowserRepository) {
        this.repo = subtitleBrowserRepository;
    }

    public final LiveData<Resource<Object>> getResultResponse() {
        return this._resultResponse;
    }

    public final void downloadSubtitle(String url, String fileDir) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fileDir, "fileDir");
        this.repo = new SubtitleBrowserRepository();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SubtitleBrowserViewModel$downloadSubtitle$1(this, url, fileDir, null), 3, null);
    }
}

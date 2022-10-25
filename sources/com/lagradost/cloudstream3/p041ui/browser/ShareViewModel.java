package com.lagradost.cloudstream3.p041ui.browser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.lagradost.cloudstream3.mvvm.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareViewModel.kt */
@Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\fR\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/browser/ShareViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_notifyData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "notifyData", "Landroidx/lifecycle/LiveData;", "getNotifyData", "()Landroidx/lifecycle/LiveData;", "notifyToPlayer", "", "listSubPath", "", "", "refreshData", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.browser.ShareViewModel */
/* loaded from: classes.dex */
public final class ShareViewModel extends ViewModel {
    private final MutableLiveData<Resource<Object>> _notifyData = new MutableLiveData<>();

    public final LiveData<Resource<Object>> getNotifyData() {
        return this._notifyData;
    }

    public final void notifyToPlayer(List<String> listSubPath) {
        Intrinsics.checkNotNullParameter(listSubPath, "listSubPath");
        this._notifyData.postValue(new Resource.Success(listSubPath));
    }

    public final void refreshData() {
        this._notifyData.postValue(null);
    }
}

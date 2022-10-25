package com.lagradost.cloudstream3.p041ui.livetv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.mvvm.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: LiveTvViewModel.kt */
@Metadata(m108d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fR \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/livetv/LiveTvViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_searchResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "searchResponse", "Landroidx/lifecycle/LiveData;", "getSearchResponse", "()Landroidx/lifecycle/LiveData;", "getIPTV", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lkotlinx/coroutines/Job;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.livetv.LiveTvViewModel */
/* loaded from: classes3.dex */
public final class LiveTvViewModel extends ViewModel {
    private final MutableLiveData<Resource<List<SearchResponse>>> _searchResponse = new MutableLiveData<>();

    public final LiveData<Resource<List<SearchResponse>>> getSearchResponse() {
        return this._searchResponse;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getIPTV(kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r21) {
        /*
            r20 = this;
            r0 = r21
            boolean r1 = r0 instanceof com.lagradost.cloudstream3.p041ui.livetv.LiveTvViewModel$getIPTV$1
            if (r1 == 0) goto L18
            r1 = r0
            com.lagradost.cloudstream3.ui.livetv.LiveTvViewModel$getIPTV$1 r1 = (com.lagradost.cloudstream3.p041ui.livetv.LiveTvViewModel$getIPTV$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L18
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r20
            goto L1f
        L18:
            com.lagradost.cloudstream3.ui.livetv.LiveTvViewModel$getIPTV$1 r1 = new com.lagradost.cloudstream3.ui.livetv.LiveTvViewModel$getIPTV$1
            r2 = r20
            r1.<init>(r2, r0)
        L1f:
            java.lang.Object r0 = r1.result
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L38
            if (r3 != r4) goto L30
            kotlin.ResultKt.throwOnFailure(r0)
            goto L63
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            kotlin.ResultKt.throwOnFailure(r0)
            com.lagradost.cloudstream3.utils.Extensions$RequestCustom r0 = com.lagradost.cloudstream3.MainActivityKt.getApp()
            r3 = r0
            com.lagradost.nicehttp.Requests r3 = (com.lagradost.nicehttp.Requests) r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r0 = 0
            r17 = 2046(0x7fe, float:2.867E-42)
            r18 = 0
            r1.label = r4
            java.lang.String r4 = "https://raw.githubusercontent.com/cinehubwork/abc/master/schedule.json"
            r19 = r15
            r15 = r0
            r16 = r1
            java.lang.Object r0 = com.lagradost.nicehttp.Requests.get$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, r18)
            r1 = r19
            if (r0 != r1) goto L63
            return r1
        L63:
            com.lagradost.nicehttp.NiceResponse r0 = (com.lagradost.nicehttp.NiceResponse) r0
            okhttp3.Response r0 = r0.getOkhttpResponse()
            boolean r1 = r0.isSuccessful()
            if (r1 == 0) goto L97
            okhttp3.ResponseBody r1 = r0.body()
            if (r1 == 0) goto L97
            com.google.gson.Gson r1 = new com.google.gson.Gson
            r1.<init>()
            okhttp3.ResponseBody r0 = r0.body()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r0 = r0.string()
            java.lang.Class<com.phimhd.ListIPTV> r3 = com.phimhd.ListIPTV.class
            java.lang.Object r0 = r1.fromJson(r0, r3)
            com.phimhd.ListIPTV r0 = (com.phimhd.ListIPTV) r0
            java.lang.String r1 = "listIPTV"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.List r0 = com.phimhd.ConfigHomeKt.toLiveTvSearchResponse(r0)
            return r0
        L97:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.livetv.LiveTvViewModel.getIPTV(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Job search() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new LiveTvViewModel$search$1(this, null), 3, null);
        return launch$default;
    }
}

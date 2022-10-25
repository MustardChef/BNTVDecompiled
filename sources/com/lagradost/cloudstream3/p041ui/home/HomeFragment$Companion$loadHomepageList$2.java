package com.lagradost.cloudstream3.p041ui.home;

import android.app.Activity;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lagradost.cloudstream3.p041ui.search.SearchClickCallback;
import com.lagradost.cloudstream3.p041ui.search.SearchHelper;
import com.lagradost.cloudstream3.utils.UIHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "callback", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$Companion$loadHomepageList$2 */
/* loaded from: classes3.dex */
public final class HomeFragment$Companion$loadHomepageList$2 extends Lambda implements Function1<SearchClickCallback, Unit> {
    final /* synthetic */ BottomSheetDialog $bottomSheetDialogBuilder;
    final /* synthetic */ Activity $this_loadHomepageList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$Companion$loadHomepageList$2(Activity activity, BottomSheetDialog bottomSheetDialog) {
        super(1);
        this.$this_loadHomepageList = activity;
        this.$bottomSheetDialogBuilder = bottomSheetDialog;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SearchClickCallback searchClickCallback) {
        invoke2(searchClickCallback);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SearchClickCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SearchHelper.INSTANCE.handleSearchClickCallback(this.$this_loadHomepageList, callback);
        if (callback.getAction() == 0 || callback.getAction() == 2) {
            UIHelper.INSTANCE.dismissSafe(this.$bottomSheetDialogBuilder, this.$this_loadHomepageList);
        }
    }
}

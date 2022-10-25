package com.lagradost.cloudstream3.p041ui.home;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.p041ui.search.SearchClickCallback;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.widget.CenterZoomLayoutManager;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", FirebaseAnalytics.Param.ITEMS, "", "Lcom/lagradost/cloudstream3/SearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$4 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$4 extends Lambda implements Function1<List<? extends SearchResponse>, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$4(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SearchResponse> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends SearchResponse> list) {
        List<? extends SearchResponse> list2 = list;
        boolean z = false;
        if (list2 == null || list2.isEmpty()) {
            HomeFragment.toggleMainVisibility$default(this.this$0, false, null, 2, null);
            return;
        }
        HomeChildItemAdapter homeChildItemAdapter = (HomeChildItemAdapter) ((RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview)).getAdapter();
        if (homeChildItemAdapter != null && Intrinsics.areEqual(homeChildItemAdapter.getCardList(), list)) {
            HomeFragment homeFragment = this.this$0;
            Context context = homeFragment.getContext();
            homeFragment.toggleMainVisibility(true, context != null ? Boolean.valueOf(SettingsFragment.Companion.isTvSettings(context)) : null);
            return;
        }
        this.this$0.setUpActionHeaderMovieHomeScreen(list.get(0));
        final int size = list.size();
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview);
        if (recyclerView != null) {
            recyclerView.setAdapter(new HomeChildItemAdapter(CollectionsKt.toMutableList((Collection) list2), Integer.valueOf((int) R.layout.home_result_big_grid), Integer.valueOf(((RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview)).getNextFocusUpId()), Integer.valueOf(((RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview)).getNextFocusDownId()), new C48611(this.this$0)));
        }
        Context context2 = this.this$0.getContext();
        if (context2 != null && !SettingsFragment.Companion.isTvSettings(context2)) {
            z = true;
        }
        if (z) {
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview);
            if (recyclerView2 != null) {
                final HomeFragment homeFragment2 = this.this$0;
                recyclerView2.post(new Runnable() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$onViewCreated$4$rcSX0LDbD0hDUx2-UYgGqnp45To
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeFragment$onViewCreated$4.m8653invoke$lambda1(HomeFragment.this, size);
                    }
                });
            }
        } else {
            SearchResponse searchResponse = (SearchResponse) CollectionsKt.firstOrNull((List<? extends Object>) list);
            if (searchResponse != null) {
                this.this$0.focusCallback(searchResponse);
            }
        }
        HomeFragment homeFragment3 = this.this$0;
        Context context3 = homeFragment3.getContext();
        homeFragment3.toggleMainVisibility(true, context3 != null ? Boolean.valueOf(SettingsFragment.Companion.isTvSettings(context3)) : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeFragment.kt */
    @Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "callback", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$4$1 */
    /* loaded from: classes3.dex */
    public static final class C48611 extends Lambda implements Function1<SearchClickCallback, Unit> {
        final /* synthetic */ HomeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48611(HomeFragment homeFragment) {
            super(1);
            this.this$0 = homeFragment;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchClickCallback searchClickCallback) {
            invoke2(searchClickCallback);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(SearchClickCallback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.this$0.homeHandleSearch(callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m8653invoke$lambda1(HomeFragment this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView = (RecyclerView) this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview);
        CenterZoomLayoutManager centerZoomLayoutManager = (CenterZoomLayoutManager) (recyclerView != null ? recyclerView.getLayoutManager() : null);
        if (centerZoomLayoutManager != null) {
            centerZoomLayoutManager.updateSize(true);
            if (i > 2) {
                centerZoomLayoutManager.scrollToPosition(i / 2);
                CenterZoomLayoutManager.snap$default(centerZoomLayoutManager, null, new HomeFragment$onViewCreated$4$2$1$1(this$0), 1, null);
            }
        }
    }
}

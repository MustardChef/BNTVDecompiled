package com.lagradost.cloudstream3.p041ui.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.search.SearchFragment;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "data", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$6 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$6 extends Lambda implements Function1<Resource<? extends HomePageResponse>, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$6(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends HomePageResponse> resource) {
        invoke2((Resource<HomePageResponse>) resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<HomePageResponse> data) {
        View.OnClickListener onClickListener;
        boolean z;
        ExtendedFloatingActionButton extendedFloatingActionButton;
        ArrayList emptyList;
        List<HomePageList> items;
        HomePageList homePageList;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof Resource.Success) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading_shimmer);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.stopShimmer();
            }
            HomePageResponse homePageResponse = (HomePageResponse) ((Resource.Success) data).getValue();
            HomeFragment.Companion.getListHomepageItems().clear();
            this.this$0.currentHomePage = homePageResponse;
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_master_recycler);
            RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            HomeParentItemAdapter homeParentItemAdapter = adapter instanceof HomeParentItemAdapter ? (HomeParentItemAdapter) adapter : null;
            if (homeParentItemAdapter != null) {
                if (homePageResponse == null || (items = homePageResponse.getItems()) == null) {
                    emptyList = CollectionsKt.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (HomePageList homePageList2 : items) {
                        try {
                            HomeFragment.Companion.getListHomepageItems().addAll(SearchFragment.Companion.filterSearchResponse(homePageList2.getList()));
                            homePageList = new HomePageList(homePageList2.getName(), SearchFragment.Companion.filterSearchResponse(homePageList2.getList()), homePageList2.getUrlMore(), homePageList2.getNameApi(), homePageList2.getCardType());
                        } catch (Exception e) {
                            ArchComponentExt.logError(e);
                            homePageList = null;
                        }
                        if (homePageList != null) {
                            arrayList.add(homePageList);
                        }
                    }
                    emptyList = arrayList;
                }
                homeParentItemAdapter.updateList(emptyList);
            }
            FrameLayout frameLayout = (FrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading_error);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            NestedScrollView nestedScrollView = (NestedScrollView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loaded);
            if (nestedScrollView != null) {
                nestedScrollView.setVisibility(0);
            }
            z = this.this$0.toggleRandomButton;
            if (z && (extendedFloatingActionButton = (ExtendedFloatingActionButton) this.this$0._$_findCachedViewById(C4761R.C4764id.home_random)) != null) {
                extendedFloatingActionButton.setVisibility(HomeFragment.Companion.getListHomepageItems().isEmpty() ^ true ? 0 : 8);
            }
            this.this$0.setUpPageHomeScreen(homePageResponse);
        } else if (data instanceof Resource.Failure) {
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading_shimmer);
            if (shimmerFrameLayout2 != null) {
                shimmerFrameLayout2.stopShimmer();
            }
            ((TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_error_text)).setText(((Resource.Failure) data).getErrorString());
            onClickListener = this.this$0.apiChangeClickListener;
            ((MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.home_reload_connectionerror)).setOnClickListener(onClickListener);
            final HomeFragment homeFragment = this.this$0;
            ((MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.home_reload_connection_open_in_browser)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$onViewCreated$6$G_efs_rqpSh20_d1NErKk_ciKbA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment$onViewCreated$6.m8656invoke$lambda2(HomeFragment.this, view);
                }
            });
            FrameLayout frameLayout2 = (FrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading);
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
            LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading_error);
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            NestedScrollView nestedScrollView2 = (NestedScrollView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loaded);
            if (nestedScrollView2 == null) {
                return;
            }
            nestedScrollView2.setVisibility(8);
        } else if (data instanceof Resource.Loading) {
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_master_recycler);
            RecyclerView.Adapter adapter2 = recyclerView2 != null ? recyclerView2.getAdapter() : null;
            HomeParentItemAdapter homeParentItemAdapter2 = adapter2 instanceof HomeParentItemAdapter ? adapter2 : null;
            if (homeParentItemAdapter2 != null) {
                homeParentItemAdapter2.updateList(CollectionsKt.emptyList());
            }
            ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading_shimmer);
            if (shimmerFrameLayout3 != null) {
                shimmerFrameLayout3.startShimmer();
            }
            FrameLayout frameLayout3 = (FrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading);
            if (frameLayout3 != null) {
                frameLayout3.setVisibility(0);
            }
            LinearLayout linearLayout3 = (LinearLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loading_error);
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            NestedScrollView nestedScrollView3 = (NestedScrollView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_loaded);
            if (nestedScrollView3 == null) {
                return;
            }
            nestedScrollView3.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m8656invoke$lambda2(HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<MainAPI> apis = APIHolder.INSTANCE.getApis();
        UIHelper uIHelper = UIHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        List<MainAPI> list = apis;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(new Tuples(Integer.valueOf(i), ((MainAPI) obj).getName()));
            i = i2;
        }
        uIHelper.popupMenuNoIconsAndNoStringRes(view, arrayList, new HomeFragment$onViewCreated$6$2$2(apis, this$0));
    }
}

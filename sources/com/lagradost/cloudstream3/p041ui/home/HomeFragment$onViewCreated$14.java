package com.lagradost.cloudstream3.p041ui.home;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", FirebaseAnalytics.Param.INDEX, "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$14 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$14 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$14(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        List<SearchResponse> cardList;
        final SearchResponse searchResponse;
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview);
        HomeChildItemAdapter homeChildItemAdapter = (HomeChildItemAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
        if (homeChildItemAdapter == null || (cardList = homeChildItemAdapter.getCardList()) == null || (searchResponse = cardList.get(i)) == null) {
            return;
        }
        final HomeFragment homeFragment = this.this$0;
        MaterialButton materialButton = (MaterialButton) homeFragment._$_findCachedViewById(C4761R.C4764id.home_main_play);
        if (materialButton != null) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$onViewCreated$14$o-ORzw4FhEw6uhFcnS2ACKLFQ2U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment$onViewCreated$14.m8650invoke$lambda2$lambda0(HomeFragment.this, searchResponse, view);
                }
            });
        }
        MaterialButton materialButton2 = (MaterialButton) homeFragment._$_findCachedViewById(C4761R.C4764id.home_main_info);
        if (materialButton2 != null) {
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$onViewCreated$14$7JLlQMELjQeWbHJ_MDPWgImYP2Y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment$onViewCreated$14.m8651invoke$lambda2$lambda1(HomeFragment.this, searchResponse, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-0  reason: not valid java name */
    public static final void m8650invoke$lambda2$lambda0(HomeFragment this$0, SearchResponse random, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(random, "$random");
        AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), random, 1, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m8651invoke$lambda2$lambda1(HomeFragment this$0, SearchResponse random, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(random, "$random");
        AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), random, 0, null, 6, null);
    }
}

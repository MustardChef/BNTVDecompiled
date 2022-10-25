package com.lagradost.cloudstream3.p041ui.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.SearchResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, m107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$10 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$10 extends Lambda implements Function1<Tuples<? extends Boolean, ? extends List<? extends SearchResponse>>, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$10(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends Boolean, ? extends List<? extends SearchResponse>> tuples) {
        invoke2((Tuples<Boolean, ? extends List<? extends SearchResponse>>) tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<Boolean, ? extends List<? extends SearchResponse>> tuples) {
        Intrinsics.checkNotNullParameter(tuples, "<name for destructuring parameter 0>");
        boolean booleanValue = tuples.component1().booleanValue();
        final List<? extends SearchResponse> component2 = tuples.component2();
        LinearLayout home_bookmarked_holder = (LinearLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_bookmarked_holder);
        Intrinsics.checkNotNullExpressionValue(home_bookmarked_holder, "home_bookmarked_holder");
        home_bookmarked_holder.setVisibility(booleanValue ? 0 : 8);
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_bookmarked_child_recyclerview);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        HomeChildItemAdapter homeChildItemAdapter = adapter instanceof HomeChildItemAdapter ? (HomeChildItemAdapter) adapter : null;
        if (homeChildItemAdapter != null) {
            homeChildItemAdapter.updateList(component2);
        }
        FrameLayout frameLayout = (FrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_bookmarked_child_more_info);
        if (frameLayout != null) {
            final HomeFragment homeFragment = this.this$0;
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$onViewCreated$10$RSxYOcFQ0SS3OAFs_HdbpMDgrrE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment$onViewCreated$10.m8648invoke$lambda0(HomeFragment.this, component2, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8648invoke$lambda0(HomeFragment this$0, List bookmarks, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bookmarks, "$bookmarks");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            String string = this$0.getString(R.string.error_bookmarks_text);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.error_bookmarks_text)");
            HomeFragment.Companion.loadHomepageList(activity, new HomePageList(string, bookmarks, null, null, null, 28, null));
        }
    }
}

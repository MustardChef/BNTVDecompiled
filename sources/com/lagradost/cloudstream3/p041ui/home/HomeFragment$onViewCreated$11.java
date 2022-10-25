package com.lagradost.cloudstream3.p041ui.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.p041ui.home.HomeFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "resumeWatching", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$11 */
/* loaded from: classes3.dex */
final class HomeFragment$onViewCreated$11 extends Lambda implements Function1<List<? extends SearchResponse>, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeFragment$onViewCreated$11(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SearchResponse> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final List<? extends SearchResponse> resumeWatching) {
        Intrinsics.checkNotNullParameter(resumeWatching, "resumeWatching");
        LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_watch_holder);
        if (linearLayout != null) {
            linearLayout.setVisibility(resumeWatching.isEmpty() ^ true ? 0 : 8);
        }
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.home_watch_child_recyclerview);
        RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        HomeChildItemAdapter homeChildItemAdapter = adapter instanceof HomeChildItemAdapter ? (HomeChildItemAdapter) adapter : null;
        if (homeChildItemAdapter != null) {
            homeChildItemAdapter.updateList(resumeWatching);
        }
        FrameLayout frameLayout = (FrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.home_watch_child_more_info);
        if (frameLayout != null) {
            final HomeFragment homeFragment = this.this$0;
            frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$onViewCreated$11$LNjWQSZ8JGXNQxrO_NNxh_TbEQ0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment$onViewCreated$11.m8649invoke$lambda0(HomeFragment.this, resumeWatching, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m8649invoke$lambda0(HomeFragment this$0, List resumeWatching, View view) {
        String str;
        CharSequence text;
        String obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resumeWatching, "$resumeWatching");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            HomeFragment.Companion companion = HomeFragment.Companion;
            FragmentActivity fragmentActivity = activity;
            TextView textView = (TextView) this$0._$_findCachedViewById(C4761R.C4764id.home_watch_parent_item_title);
            if (textView == null || (text = textView.getText()) == null || (obj = text.toString()) == null) {
                String string = this$0.getString(R.string.continue_watching);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.continue_watching)");
                str = string;
            } else {
                str = obj;
            }
            companion.loadHomepageList(fragmentActivity, new HomePageList(str, resumeWatching, null, null, null, 28, null));
        }
    }
}

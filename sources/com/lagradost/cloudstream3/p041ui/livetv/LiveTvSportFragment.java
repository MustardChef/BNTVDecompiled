package com.lagradost.cloudstream3.p041ui.livetv;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.applovin.mediation.ads.MaxAdView;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.p041ui.home.HomeFragment;
import com.lagradost.cloudstream3.p041ui.search.SearchAdaptor;
import com.lagradost.cloudstream3.p041ui.search.SearchClickCallback;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.phimhd.AppController;
import com.phimhd.Key;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveTvSportFragment.kt */
@Metadata(m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/livetv/LiveTvSportFragment;", "Landroidx/fragment/app/Fragment;", "()V", "liveTvViewModel", "Lcom/lagradost/cloudstream3/ui/livetv/LiveTvViewModel;", "fixGrid", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.livetv.LiveTvSportFragment */
/* loaded from: classes3.dex */
public final class LiveTvSportFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    private static Function1<? super SearchClickCallback, Unit> clickCallback;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private LiveTvViewModel liveTvViewModel;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* compiled from: LiveTvSportFragment.kt */
    @Metadata(m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rR(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/livetv/LiveTvSportFragment$Companion;", "", "()V", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function1;", "setClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "pushSearch", "activity", "Landroid/app/Activity;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.livetv.LiveTvSportFragment$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void pushSearch(Activity activity) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            Bundle bundle = new Bundle();
            Unit unit = Unit.INSTANCE;
            uIHelper.navigate(activity, R.id.global_to_navigation_livetv, bundle);
        }

        public final Function1<SearchClickCallback, Unit> getClickCallback() {
            return LiveTvSportFragment.clickCallback;
        }

        public final void setClickCallback(Function1<? super SearchClickCallback, Unit> function1) {
            LiveTvSportFragment.clickCallback = function1;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(4);
        }
        this.liveTvViewModel = (LiveTvViewModel) new ViewModelProvider(this).get(LiveTvViewModel.class);
        return inflater.inflate(R.layout.fragment_tv, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        clickCallback = null;
    }

    private final void fixGrid() {
        Integer spanCount;
        FragmentActivity activity = getActivity();
        if (activity != null && (spanCount = UIHelper.INSTANCE.getSpanCount(activity)) != null) {
            HomeFragment.Companion.setCurrentSpan(spanCount.intValue());
        }
        ((AutofitRecyclerView) _$_findCachedViewById(C4761R.C4764id.livetv_autofit_results)).setSpanCount(HomeFragment.Companion.getCurrentSpan());
        HomeFragment.Companion.setCurrentSpan(HomeFragment.Companion.getCurrentSpan());
        HomeFragment.Companion.getConfigEvent().invoke(Integer.valueOf(HomeFragment.Companion.getCurrentSpan()));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        fixGrid();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        SearchAdaptor searchAdaptor;
        MaxAdView maxAdView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Context context = getContext();
        if (context != null) {
            UIHelper.INSTANCE.fixPaddingStatusbar(context, (LinearLayout) _$_findCachedViewById(C4761R.C4764id.livetv_root));
        }
        fixGrid();
        AppController companion = AppController.Companion.getInstance();
        LiveTvViewModel liveTvViewModel = null;
        if ((companion != null ? companion.getKey() : null) != null) {
            AppController companion2 = AppController.Companion.getInstance();
            Key key = companion2 != null ? companion2.getKey() : null;
            Intrinsics.checkNotNull(key);
            if (!key.isExpired() && (maxAdView = (MaxAdView) _$_findCachedViewById(C4761R.C4764id.adView)) != null) {
                maxAdView.setVisibility(8);
            }
        }
        AutofitRecyclerView autofitRecyclerView = (AutofitRecyclerView) _$_findCachedViewById(C4761R.C4764id.livetv_autofit_results);
        if (getActivity() != null) {
            ArrayList arrayList = new ArrayList();
            AutofitRecyclerView livetv_autofit_results = (AutofitRecyclerView) _$_findCachedViewById(C4761R.C4764id.livetv_autofit_results);
            Intrinsics.checkNotNullExpressionValue(livetv_autofit_results, "livetv_autofit_results");
            searchAdaptor = new SearchAdaptor(arrayList, livetv_autofit_results, null, new LiveTvSportFragment$onViewCreated$1$1(this), 4, null);
        } else {
            searchAdaptor = null;
        }
        autofitRecyclerView.setAdapter(searchAdaptor);
        LiveTvSportFragment liveTvSportFragment = this;
        LiveTvViewModel liveTvViewModel2 = this.liveTvViewModel;
        if (liveTvViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveTvViewModel");
            liveTvViewModel2 = null;
        }
        ArchComponentExt.observe(liveTvSportFragment, liveTvViewModel2.getSearchResponse(), new LiveTvSportFragment$onViewCreated$2(this));
        ((ImageView) _$_findCachedViewById(C4761R.C4764id.livetv_back)).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.livetv.-$$Lambda$LiveTvSportFragment$j9JhlMXvxAbdh-fSg-WLsK3AvXI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveTvSportFragment.m8662onViewCreated$lambda2(LiveTvSportFragment.this, view2);
            }
        });
        LiveTvViewModel liveTvViewModel3 = this.liveTvViewModel;
        if (liveTvViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveTvViewModel");
        } else {
            liveTvViewModel = liveTvViewModel3;
        }
        liveTvViewModel.search();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m8662onViewCreated$lambda2(LiveTvSportFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }
}

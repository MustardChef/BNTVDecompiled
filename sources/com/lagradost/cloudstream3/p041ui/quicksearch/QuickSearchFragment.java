package com.lagradost.cloudstream3.p041ui.quicksearch;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.p041ui.home.HomeFragment;
import com.lagradost.cloudstream3.p041ui.search.SearchClickCallback;
import com.lagradost.cloudstream3.p041ui.search.SearchViewModel;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: QuickSearchFragment.kt */
@Metadata(m108d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u001a\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0019R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/quicksearch/QuickSearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", QuickSearchFragment.PROVIDER_KEY, "", "", "searchViewModel", "Lcom/lagradost/cloudstream3/ui/search/SearchViewModel;", "fixGrid", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "search", "", "context", "Landroid/content/Context;", "query", "isQuickSearch", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.quicksearch.QuickSearchFragment */
/* loaded from: classes3.dex */
public final class QuickSearchFragment extends Fragment {
    public static final String AUTOSEARCH_KEY = "autosearch";
    public static final Companion Companion = new Companion(null);
    public static final String PROVIDER_KEY = "providers";
    private static Function1<? super SearchClickCallback, Unit> clickCallback;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Set<String> providers;
    private SearchViewModel searchViewModel;

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

    /* compiled from: QuickSearchFragment.kt */
    @Metadata(m108d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/quicksearch/QuickSearchFragment$Companion;", "", "()V", "AUTOSEARCH_KEY", "", "PROVIDER_KEY", "clickCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "", "getClickCallback", "()Lkotlin/jvm/functions/Function1;", "setClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "pushSearch", "activity", "Landroid/app/Activity;", "autoSearch", QuickSearchFragment.PROVIDER_KEY, "", "(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/String;)V", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.quicksearch.QuickSearchFragment$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void pushSearch$default(Companion companion, Activity activity, String str, String[] strArr, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                strArr = null;
            }
            companion.pushSearch(activity, str, strArr);
        }

        public final void pushSearch(Activity activity, String str, String[] strArr) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            Bundle bundle = new Bundle();
            if (strArr != null) {
                bundle.putStringArray(QuickSearchFragment.PROVIDER_KEY, strArr);
            }
            if (str != null) {
                bundle.putString(QuickSearchFragment.AUTOSEARCH_KEY, StringsKt.trim((CharSequence) StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.trim((CharSequence) str).toString(), (CharSequence) "(DUB)"), (CharSequence) "(SUB)"), (CharSequence) "(Dub)"), (CharSequence) "(Sub)")).toString());
            }
            Unit unit = Unit.INSTANCE;
            uIHelper.navigate(activity, R.id.global_to_navigation_quick_search, bundle);
        }

        public final Function1<SearchClickCallback, Unit> getClickCallback() {
            return QuickSearchFragment.clickCallback;
        }

        public final void setClickCallback(Function1<? super SearchClickCallback, Unit> function1) {
            QuickSearchFragment.clickCallback = function1;
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
        this.searchViewModel = (SearchViewModel) new ViewModelProvider(this).get(SearchViewModel.class);
        return inflater.inflate(R.layout.quick_search, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        clickCallback = null;
    }

    public final boolean search(Context context, String query, boolean z) {
        List<MainAPI> filterProviderByPreferredMedia;
        Intrinsics.checkNotNullParameter(query, "query");
        Set<String> set = this.providers;
        SearchViewModel searchViewModel = null;
        if (set == null) {
            if (context == null || (filterProviderByPreferredMedia = APIHolder.INSTANCE.filterProviderByPreferredMedia(context, false)) == null) {
                set = null;
            } else {
                List<MainAPI> list = filterProviderByPreferredMedia;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (MainAPI mainAPI : list) {
                    arrayList.add(mainAPI.getName());
                }
                set = CollectionsKt.toSet(arrayList);
            }
        }
        if (set != null) {
            SearchViewModel searchViewModel2 = this.searchViewModel;
            if (searchViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
            } else {
                searchViewModel = searchViewModel2;
            }
            searchViewModel.searchAndCancel(query, set, false, z);
            return true;
        }
        return false;
    }

    private final void fixGrid() {
        Integer spanCount;
        FragmentActivity activity = getActivity();
        if (activity != null && (spanCount = UIHelper.INSTANCE.getSpanCount(activity)) != null) {
            HomeFragment.Companion.setCurrentSpan(spanCount.intValue());
        }
        ((AutofitRecyclerView) _$_findCachedViewById(C4761R.C4764id.quick_search_autofit_results)).setSpanCount(HomeFragment.Companion.getCurrentSpan());
        HomeFragment.Companion.setCurrentSpan(HomeFragment.Companion.getCurrentSpan());
        HomeFragment.Companion.getConfigEvent().invoke(Integer.valueOf(HomeFragment.Companion.getCurrentSpan()));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        fixGrid();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b0  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r13, android.os.Bundle r14) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.quicksearch.QuickSearchFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m8752onViewCreated$lambda5(QuickSearchFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            UIHelper.INSTANCE.popCurrentPage(activity);
        }
    }
}

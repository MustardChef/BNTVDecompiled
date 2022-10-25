package com.lagradost.cloudstream3.p041ui.search;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazy;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.p041ui.home.HomeFragment;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;

/* compiled from: SearchFragment.kt */
@Metadata(m108d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010(\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010\u000bJ\b\u0010*\u001a\u00020\u0018H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006,"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", "searchViewModel", "Lcom/lagradost/cloudstream3/ui/search/SearchViewModel;", "getSearchViewModel", "()Lcom/lagradost/cloudstream3/ui/search/SearchViewModel;", "searchViewModel$delegate", "Lkotlin/Lazy;", "selectedApis", "", "", "getSelectedApis", "()Ljava/util/Set;", "setSelectedApis", "(Ljava/util/Set;)V", "selectedSearchTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSelectedSearchTypes", "()Ljava/util/List;", "setSelectedSearchTypes", "(Ljava/util/List;)V", "fixGrid", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "search", "query", "searchDefaultQuery", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.search.SearchFragment */
/* loaded from: classes4.dex */
public final class SearchFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_QUERY_SEARCH = "DEFAULT_SEARCH";
    private final Lazy searchViewModel$delegate;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private List<TvType> selectedSearchTypes = new ArrayList();
    private Set<String> selectedApis = new LinkedHashSet();

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

    /* compiled from: SearchFragment.kt */
    @Metadata(m108d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/search/SearchFragment$Companion;", "", "()V", "DEFAULT_QUERY_SEARCH", "", "filterSearchResponse", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.search.SearchFragment$Companion */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
            if (r2 != false) goto L33;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.util.List<com.lagradost.cloudstream3.SearchResponse> filterSearchResponse(java.util.List<? extends com.lagradost.cloudstream3.SearchResponse> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Collection r0 = (java.util.Collection) r0
                java.util.Iterator r8 = r8.iterator()
            L12:
                boolean r1 = r8.hasNext()
                if (r1 == 0) goto L73
                java.lang.Object r1 = r8.next()
                r2 = r1
                com.lagradost.cloudstream3.SearchResponse r2 = (com.lagradost.cloudstream3.SearchResponse) r2
                boolean r3 = r2 instanceof com.lagradost.cloudstream3.AnimeSearchResponse
                r4 = 0
                r5 = 1
                if (r3 == 0) goto L6c
                com.lagradost.cloudstream3.AnimeSearchResponse r2 = (com.lagradost.cloudstream3.AnimeSearchResponse) r2
                java.util.EnumSet r2 = r2.getDubStatus()
                r3 = r2
                java.util.Collection r3 = (java.util.Collection) r3
                if (r3 == 0) goto L39
                boolean r3 = r3.isEmpty()
                if (r3 == 0) goto L37
                goto L39
            L37:
                r3 = 0
                goto L3a
            L39:
                r3 = 1
            L3a:
                if (r3 != 0) goto L6c
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                boolean r3 = r2 instanceof java.util.Collection
                if (r3 == 0) goto L4d
                r3 = r2
                java.util.Collection r3 = (java.util.Collection) r3
                boolean r3 = r3.isEmpty()
                if (r3 == 0) goto L4d
            L4b:
                r2 = 0
                goto L6a
            L4d:
                java.util.Iterator r2 = r2.iterator()
            L51:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L4b
                java.lang.Object r3 = r2.next()
                com.lagradost.cloudstream3.DubStatus r3 = (com.lagradost.cloudstream3.DubStatus) r3
                com.lagradost.cloudstream3.ui.APIRepository$Companion r6 = com.lagradost.cloudstream3.p041ui.APIRepository.Companion
                java.util.HashSet r6 = r6.getDubStatusActive()
                boolean r3 = r6.contains(r3)
                if (r3 == 0) goto L51
                r2 = 1
            L6a:
                if (r2 == 0) goto L6d
            L6c:
                r4 = 1
            L6d:
                if (r4 == 0) goto L12
                r0.add(r1)
                goto L12
            L73:
                java.util.List r0 = (java.util.List) r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.search.SearchFragment.Companion.filterSearchResponse(java.util.List):java.util.List");
        }
    }

    public SearchFragment() {
        SearchFragment searchFragment = this;
        this.searchViewModel$delegate = FragmentViewModelLazy.createViewModelLazy(searchFragment, Reflection.getOrCreateKotlinClass(SearchViewModel.class), new SearchFragment$special$$inlined$activityViewModels$default$1(searchFragment), new SearchFragment$special$$inlined$activityViewModels$default$2(null, searchFragment), new SearchFragment$special$$inlined$activityViewModels$default$3(searchFragment));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchViewModel getSearchViewModel() {
        return (SearchViewModel) this.searchViewModel$delegate.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(4);
        }
        return inflater.inflate(R.layout.fragment_search, viewGroup, false);
    }

    private final void fixGrid() {
        Integer spanCount;
        FragmentActivity activity = getActivity();
        if (activity != null && (spanCount = UIHelper.INSTANCE.getSpanCount(activity)) != null) {
            HomeFragment.Companion.setCurrentSpan(spanCount.intValue());
        }
        ((AutofitRecyclerView) _$_findCachedViewById(C4761R.C4764id.search_autofit_results)).setSpanCount(HomeFragment.Companion.getCurrentSpan());
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
    public void onDestroyView() {
        UIHelper.INSTANCE.hideKeyboard(this);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final List<TvType> getSelectedSearchTypes() {
        return this.selectedSearchTypes;
    }

    public final void setSelectedSearchTypes(List<TvType> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.selectedSearchTypes = list;
    }

    public final Set<String> getSelectedApis() {
        return this.selectedApis;
    }

    public final void setSelectedApis(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.selectedApis = set;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        if (r5 != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void search(java.lang.String r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L3
            return
        L3:
            android.content.Context r0 = r10.getContext()
            if (r0 == 0) goto L88
            com.lagradost.cloudstream3.APIHolder r1 = com.lagradost.cloudstream3.APIHolder.INSTANCE
            java.util.HashSet r0 = r1.getApiSettings(r0)
            if (r0 == 0) goto L88
            com.lagradost.cloudstream3.ui.search.SearchViewModel r1 = r10.getSearchViewModel()
            java.util.Set<java.lang.String> r2 = r10.selectedApis
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L24:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L77
            java.lang.Object r4 = r2.next()
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            boolean r6 = r0.contains(r5)
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L70
            com.lagradost.cloudstream3.APIHolder r6 = com.lagradost.cloudstream3.APIHolder.INSTANCE
            com.lagradost.cloudstream3.MainAPI r5 = r6.getApiFromName(r5)
            java.util.Set r5 = r5.getSupportedTypes()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r6 = r5 instanceof java.util.Collection
            if (r6 == 0) goto L54
            r6 = r5
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L54
        L52:
            r5 = 0
            goto L6d
        L54:
            java.util.Iterator r5 = r5.iterator()
        L58:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L52
            java.lang.Object r6 = r5.next()
            com.lagradost.cloudstream3.TvType r6 = (com.lagradost.cloudstream3.TvType) r6
            java.util.List<com.lagradost.cloudstream3.TvType> r9 = r10.selectedSearchTypes
            boolean r6 = r9.contains(r6)
            if (r6 == 0) goto L58
            r5 = 1
        L6d:
            if (r5 == 0) goto L70
            goto L71
        L70:
            r7 = 0
        L71:
            if (r7 == 0) goto L24
            r3.add(r4)
            goto L24
        L77:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Set r3 = kotlin.collections.CollectionsKt.toSet(r3)
            r4 = 0
            r5 = 0
            r6 = 12
            r7 = 0
            r2 = r11
            com.lagradost.cloudstream3.p041ui.search.SearchViewModel.searchAndCancel$default(r1, r2, r3, r4, r5, r6, r7)
        L88:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.search.SearchFragment.search(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x01b4, code lost:
        if (r1 != null) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0174  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onViewCreated(android.view.View r14, android.os.Bundle r15) {
        /*
            Method dump skipped, instructions count: 891
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.search.SearchFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b3  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List, T] */
    /* renamed from: onViewCreated$lambda-27  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m8870onViewCreated$lambda27(final com.lagradost.cloudstream3.p041ui.search.SearchFragment r23, android.view.View r24) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.search.SearchFragment.m8870onViewCreated$lambda27(com.lagradost.cloudstream3.ui.search.SearchFragment, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$lambda-8  reason: not valid java name */
    public static final void m8877onViewCreated$lambda27$lambda26$lambda25$lambda8(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        UIHelper.INSTANCE.dismissSafe(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$lambda-9  reason: not valid java name */
    public static final void m8878onViewCreated$lambda27$lambda26$lambda25$lambda9(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        UIHelper.INSTANCE.dismissSafe(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$lambda-10  reason: not valid java name */
    public static final void m8872onViewCreated$lambda27$lambda26$lambda25$lambda10(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        UIHelper.INSTANCE.dismissSafe(dialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$lambda-11  reason: not valid java name */
    public static final void m8873onViewCreated$lambda27$lambda26$lambda25$lambda11(SearchFragment this$0, Set currentSelectedApis, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentSelectedApis, "$currentSelectedApis");
        Context context = this$0.getContext();
        if (context != null) {
            DataStore.INSTANCE.setKey(context, SearchFragmentKt.SEARCH_PREF_PROVIDERS, CollectionsKt.toList(currentSelectedApis));
        }
        this$0.selectedApis = currentSelectedApis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$lambda-14  reason: not valid java name */
    public static final void m8874onViewCreated$lambda27$lambda26$lambda25$lambda14(Ref.ObjectRef currentValidApis, Set currentSelectedApis, ListView listView, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(currentValidApis, "$currentValidApis");
        Intrinsics.checkNotNullParameter(currentSelectedApis, "$currentSelectedApis");
        Collection collection = (Collection) currentValidApis.element;
        if (collection == null || collection.isEmpty()) {
            return;
        }
        String name = ((MainAPI) ((List) currentValidApis.element).get(i)).getName();
        if (currentSelectedApis.contains(name)) {
            listView.setItemChecked(i, false);
            currentSelectedApis.remove(name);
            return;
        }
        listView.setItemChecked(i, true);
        currentSelectedApis.add(name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a5, code lost:
        if (r4 != null) goto L32;
     */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.util.List, T] */
    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$updateList  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m8879onViewCreated$lambda27$lambda26$lambda25$updateList(android.widget.ArrayAdapter<java.lang.String> r6, kotlin.jvm.internal.Ref.ObjectRef<java.util.List<com.lagradost.cloudstream3.MainAPI>> r7, java.util.List<? extends com.lagradost.cloudstream3.MainAPI> r8, android.widget.ListView r9, java.util.Set<java.lang.String> r10, java.util.List<com.lagradost.cloudstream3.TvType> r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.search.SearchFragment.m8879onViewCreated$lambda27$lambda26$lambda25$updateList(android.widget.ArrayAdapter, kotlin.jvm.internal.Ref$ObjectRef, java.util.List, android.widget.ListView, java.util.Set, java.util.List, boolean):void");
    }

    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$buttonContains  reason: not valid java name */
    private static final boolean m8871onViewCreated$lambda27$lambda26$lambda25$buttonContains(List<TvType> list, List<? extends TvType> list2) {
        List<TvType> list3 = list;
        if ((list3 instanceof Collection) && list3.isEmpty()) {
            return false;
        }
        for (TvType tvType : list3) {
            if (list2.contains(tvType)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$lambda-23  reason: not valid java name */
    public static final void m8875onViewCreated$lambda27$lambda26$lambda25$lambda23(List selectedSearchTypes, List validTypes, List pairList, MaterialButton materialButton, ArrayAdapter arrayAdapter, Ref.ObjectRef currentValidApis, List validAPIs, ListView listView, Set currentSelectedApis, boolean z, View view) {
        Intrinsics.checkNotNullParameter(selectedSearchTypes, "$selectedSearchTypes");
        Intrinsics.checkNotNullParameter(validTypes, "$validTypes");
        Intrinsics.checkNotNullParameter(pairList, "$pairList");
        Intrinsics.checkNotNullParameter(arrayAdapter, "$arrayAdapter");
        Intrinsics.checkNotNullParameter(currentValidApis, "$currentValidApis");
        Intrinsics.checkNotNullParameter(validAPIs, "$validAPIs");
        Intrinsics.checkNotNullParameter(currentSelectedApis, "$currentSelectedApis");
        selectedSearchTypes.clear();
        selectedSearchTypes.addAll(validTypes);
        Iterator it = pairList.iterator();
        while (it.hasNext()) {
            MaterialButton materialButton2 = (MaterialButton) ((Tuples) it.next()).component1();
            if (materialButton2 != null) {
                materialButton2.setSelected(false);
            }
        }
        materialButton.setSelected(true);
        m8879onViewCreated$lambda27$lambda26$lambda25$updateList(arrayAdapter, currentValidApis, validAPIs, listView, currentSelectedApis, selectedSearchTypes, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-27$lambda-26$lambda-25$lambda-24  reason: not valid java name */
    public static final boolean m8876onViewCreated$lambda27$lambda26$lambda25$lambda24(MaterialButton materialButton, List selectedSearchTypes, List validTypes, ArrayAdapter arrayAdapter, Ref.ObjectRef currentValidApis, List validAPIs, ListView listView, Set currentSelectedApis, boolean z, View view) {
        Intrinsics.checkNotNullParameter(selectedSearchTypes, "$selectedSearchTypes");
        Intrinsics.checkNotNullParameter(validTypes, "$validTypes");
        Intrinsics.checkNotNullParameter(arrayAdapter, "$arrayAdapter");
        Intrinsics.checkNotNullParameter(currentValidApis, "$currentValidApis");
        Intrinsics.checkNotNullParameter(validAPIs, "$validAPIs");
        Intrinsics.checkNotNullParameter(currentSelectedApis, "$currentSelectedApis");
        if (!m8871onViewCreated$lambda27$lambda26$lambda25$buttonContains(selectedSearchTypes, validTypes)) {
            materialButton.setSelected(true);
            selectedSearchTypes.addAll(validTypes);
        } else {
            materialButton.setSelected(false);
            selectedSearchTypes.removeAll(validTypes);
        }
        m8879onViewCreated$lambda27$lambda26$lambda25$updateList(arrayAdapter, currentValidApis, validAPIs, listView, currentSelectedApis, selectedSearchTypes, z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$updateSelectedList(SearchFragment searchFragment, List<? extends Tuples<? extends MaterialButton, ? extends List<? extends TvType>>> list, List<TvType> list2) {
        searchFragment.selectedSearchTypes = list2;
        for (Tuples<? extends MaterialButton, ? extends List<? extends TvType>> tuples : list) {
            MaterialButton component1 = tuples.component1();
            List<? extends TvType> component2 = tuples.component2();
            if (component1 != null) {
                List<TvType> list3 = searchFragment.selectedSearchTypes;
                boolean z = false;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it = list3.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (component2.contains((TvType) it.next())) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                component1.setSelected(z);
            }
        }
    }

    /* renamed from: onViewCreated$lambda-38$buttonContains-35  reason: not valid java name */
    private static final boolean m8880onViewCreated$lambda38$buttonContains35(SearchFragment searchFragment, List<? extends TvType> list) {
        List<TvType> list2 = searchFragment.selectedSearchTypes;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        for (TvType tvType : list2) {
            if (list.contains(tvType)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-38$lambda-36  reason: not valid java name */
    public static final void m8881onViewCreated$lambda38$lambda36(SearchFragment this$0, List validTypes, List pairList, View view) {
        CharSequence query;
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(validTypes, "$validTypes");
        Intrinsics.checkNotNullParameter(pairList, "$pairList");
        Set set = CollectionsKt.toSet(this$0.selectedSearchTypes);
        this$0.selectedSearchTypes.clear();
        this$0.selectedSearchTypes.addAll(validTypes);
        Iterator it = pairList.iterator();
        while (it.hasNext()) {
            MaterialButton materialButton = (MaterialButton) ((Tuples) it.next()).component1();
            if (materialButton != null) {
                materialButton.setSelected(false);
            }
        }
        if (view != null && (context = view.getContext()) != null) {
            DataStore.INSTANCE.setKey(context, SearchFragmentKt.SEARCH_PREF_TAGS, this$0.selectedSearchTypes);
        }
        if (view != null) {
            view.setSelected(true);
        }
        if (Intrinsics.areEqual(set, CollectionsKt.toSet(this$0.selectedSearchTypes))) {
            return;
        }
        SearchView searchView = (SearchView) this$0._$_findCachedViewById(C4761R.C4764id.main_search);
        this$0.search((searchView == null || (query = searchView.getQuery()) == null) ? null : query.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-38$lambda-37  reason: not valid java name */
    public static final boolean m8882onViewCreated$lambda38$lambda37(SearchFragment this$0, List validTypes, View view) {
        CharSequence query;
        Context context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(validTypes, "$validTypes");
        if (!m8880onViewCreated$lambda38$buttonContains35(this$0, validTypes)) {
            if (view != null) {
                view.setSelected(true);
            }
            this$0.selectedSearchTypes.addAll(validTypes);
        } else {
            if (view != null) {
                view.setSelected(false);
            }
            this$0.selectedSearchTypes.removeAll(validTypes);
        }
        if (view != null && (context = view.getContext()) != null) {
            DataStore.INSTANCE.setKey(context, SearchFragmentKt.SEARCH_PREF_TAGS, this$0.selectedSearchTypes);
        }
        SearchView searchView = (SearchView) this$0._$_findCachedViewById(C4761R.C4764id.main_search);
        this$0.search((searchView == null || (query = searchView.getQuery()) == null) ? null : query.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
        if (r7 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void searchDefaultQuery() {
        /*
            r11 = this;
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.main_search
            android.view.View r0 = r11._$_findCachedViewById(r0)
            androidx.appcompat.widget.SearchView r0 = (androidx.appcompat.widget.SearchView) r0
            java.lang.CharSequence r0 = r0.getQuery()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto Lc8
            int r0 = com.lagradost.cloudstream3.C4761R.C4764id.search_master_recycler
            android.view.View r0 = r11._$_findCachedViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r1 = 0
            if (r0 != 0) goto L24
            goto L29
        L24:
            android.view.View r0 = (android.view.View) r0
            r0.setVisibility(r1)
        L29:
            android.content.Context r0 = r11.getContext()
            if (r0 == 0) goto Lc8
            com.lagradost.cloudstream3.APIHolder r2 = com.lagradost.cloudstream3.APIHolder.INSTANCE
            java.util.HashSet r0 = r2.getApiSettings(r0)
            if (r0 == 0) goto Lc8
            com.lagradost.cloudstream3.ui.search.SearchViewModel r2 = r11.getSearchViewModel()
            int r3 = com.lagradost.cloudstream3.C4761R.C4764id.main_search
            android.view.View r3 = r11._$_findCachedViewById(r3)
            androidx.appcompat.widget.SearchView r3 = (androidx.appcompat.widget.SearchView) r3
            java.lang.CharSequence r3 = r3.getQuery()
            java.lang.String r3 = r3.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r4 = kotlin.text.StringsKt.isBlank(r3)
            if (r4 == 0) goto L55
            java.lang.String r3 = "DEFAULT_SEARCH"
        L55:
            java.lang.String r3 = (java.lang.String) r3
            java.util.Set<java.lang.String> r4 = r11.selectedApis
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L66:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto Lb8
            java.lang.Object r6 = r4.next()
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = r0.contains(r7)
            r9 = 1
            if (r8 == 0) goto Lb1
            com.lagradost.cloudstream3.APIHolder r8 = com.lagradost.cloudstream3.APIHolder.INSTANCE
            com.lagradost.cloudstream3.MainAPI r7 = r8.getApiFromName(r7)
            java.util.Set r7 = r7.getSupportedTypes()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r8 = r7 instanceof java.util.Collection
            if (r8 == 0) goto L95
            r8 = r7
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L95
        L93:
            r7 = 0
            goto Lae
        L95:
            java.util.Iterator r7 = r7.iterator()
        L99:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L93
            java.lang.Object r8 = r7.next()
            com.lagradost.cloudstream3.TvType r8 = (com.lagradost.cloudstream3.TvType) r8
            java.util.List<com.lagradost.cloudstream3.TvType> r10 = r11.selectedSearchTypes
            boolean r8 = r10.contains(r8)
            if (r8 == 0) goto L99
            r7 = 1
        Lae:
            if (r7 == 0) goto Lb1
            goto Lb2
        Lb1:
            r9 = 0
        Lb2:
            if (r9 == 0) goto L66
            r5.add(r6)
            goto L66
        Lb8:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Set r4 = kotlin.collections.CollectionsKt.toSet(r5)
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            com.lagradost.cloudstream3.p041ui.search.SearchViewModel.searchAndCancel$default(r2, r3, r4, r5, r6, r7, r8)
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.search.SearchFragment.searchDefaultQuery():void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        searchDefaultQuery();
    }
}

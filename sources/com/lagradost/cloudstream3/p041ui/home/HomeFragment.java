package com.lagradost.cloudstream3.p041ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazy;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.AcraApplication;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.Page;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.p041ui.WatchType;
import com.lagradost.cloudstream3.p041ui.browser.ICallback;
import com.lagradost.cloudstream3.p041ui.home.HomeFragment;
import com.lagradost.cloudstream3.p041ui.quicksearch.QuickSearchFragment;
import com.lagradost.cloudstream3.p041ui.search.SearchAdaptor;
import com.lagradost.cloudstream3.p041ui.search.SearchClickCallback;
import com.lagradost.cloudstream3.p041ui.search.SearchHelper;
import com.lagradost.cloudstream3.p041ui.settings.SettingsFragment;
import com.lagradost.cloudstream3.syncproviders.AccountManager;
import com.lagradost.cloudstream3.syncproviders.AuthAPI;
import com.lagradost.cloudstream3.syncproviders.OAuth2API;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import com.lagradost.cloudstream3.utils.Event;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.widget.CenterZoomLayoutManager;
import com.phimhd.BaseFragment;
import com.phimhd.ICallbackDialogFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;

/* compiled from: HomeFragment.kt */
@Metadata(m108d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J&\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0016H\u0016J\u001a\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\b\u0010+\u001a\u00020\u0016H\u0002J!\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00142\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010/J\n\u00100\u001a\u000201*\u000202R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/HomeFragment;", "Lcom/phimhd/BaseFragment;", "()V", "apiChangeClickListener", "Landroid/view/View$OnClickListener;", "currentApiName", "", "getCurrentApiName", "()Ljava/lang/String;", "setCurrentApiName", "(Ljava/lang/String;)V", "currentHomePage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "homeViewModel", "Lcom/lagradost/cloudstream3/ui/home/HomeViewModel;", "getHomeViewModel", "()Lcom/lagradost/cloudstream3/ui/home/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "toggleRandomButton", "", "fixGrid", "", "focusCallback", "card", "Lcom/lagradost/cloudstream3/SearchResponse;", "homeHandleSearch", "callback", "Lcom/lagradost/cloudstream3/ui/search/SearchClickCallback;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "reloadStored", "toggleMainVisibility", "visible", "recyclerViewRandomVisible", "(ZLjava/lang/Boolean;)V", "toPage", "Lcom/lagradost/cloudstream3/Page;", "Lcom/lagradost/cloudstream3/MainAPI;", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment */
/* loaded from: classes3.dex */
public final class HomeFragment extends BaseFragment {
    private static final int errorProfilePic;
    private static final List<Integer> errorProfilePics;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final View.OnClickListener apiChangeClickListener = new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$7A2KtSo9iqf3WrjvtN3QGTXehvc
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            HomeFragment.m8630apiChangeClickListener$lambda3(HomeFragment.this, view);
        }
    };
    private String currentApiName;
    private HomePageResponse currentHomePage;
    private final Lazy homeViewModel$delegate;
    private boolean toggleRandomButton;
    public static final Companion Companion = new Companion(null);
    private static final Event<Integer> configEvent = new Event<>();
    private static int currentSpan = 1;
    private static final List<SearchResponse> listHomepageItems = new ArrayList();

    @Override // com.phimhd.BaseFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // com.phimhd.BaseFragment
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

    @Override // com.phimhd.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(m108d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\\\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00100\u00170\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018J\u0012\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$J(\u0010%\u001a\u00020!*\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!0*R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/HomeFragment$Companion;", "", "()V", "configEvent", "Lcom/lagradost/cloudstream3/utils/Event;", "", "getConfigEvent", "()Lcom/lagradost/cloudstream3/utils/Event;", "currentSpan", "getCurrentSpan", "()I", "setCurrentSpan", "(I)V", "errorProfilePic", "getErrorProfilePic", "errorProfilePics", "", "listHomepageItems", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "getListHomepageItems", "()Ljava/util/List;", "getPairList", "Lkotlin/Pair;", "Lcom/google/android/material/button/MaterialButton;", "Lcom/lagradost/cloudstream3/TvType;", "anime", "cartoons", "tvs", "docs", "movies", "asian", "loadHomepageList", "", "Landroid/app/Activity;", "item", "Lcom/lagradost/cloudstream3/HomePageList;", "selectHomepage", "Landroid/content/Context;", "selectedApiName", "", "callback", "Lkotlin/Function1;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.home.HomeFragment$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Event<Integer> getConfigEvent() {
            return HomeFragment.configEvent;
        }

        public final int getCurrentSpan() {
            return HomeFragment.currentSpan;
        }

        public final void setCurrentSpan(int i) {
            HomeFragment.currentSpan = i;
        }

        public final List<SearchResponse> getListHomepageItems() {
            return HomeFragment.listHomepageItems;
        }

        public final int getErrorProfilePic() {
            return HomeFragment.errorProfilePic;
        }

        public final void loadHomepageList(final Activity activity, HomePageList item) {
            Intrinsics.checkNotNullParameter(activity, "<this>");
            Intrinsics.checkNotNullParameter(item, "item");
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
            bottomSheetDialog.setContentView(R.layout.home_episodes_expanded);
            View findViewById = bottomSheetDialog.findViewById(R.id.home_expanded_text);
            Intrinsics.checkNotNull(findViewById);
            ((TextView) findViewById).setText(item.getName());
            View findViewById2 = bottomSheetDialog.findViewById(R.id.home_expanded_recycler);
            Intrinsics.checkNotNull(findViewById2);
            AutofitRecyclerView autofitRecyclerView = (AutofitRecyclerView) findViewById2;
            View findViewById3 = bottomSheetDialog.findViewById(R.id.home_expanded_drag_down);
            Intrinsics.checkNotNull(findViewById3);
            ((FrameLayout) findViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$Companion$SCvk54ifWBarU-D1qr2eoIWil-8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.Companion.m8639loadHomepageList$lambda0(BottomSheetDialog.this, activity, view);
                }
            });
            autofitRecyclerView.setSpanCount(getCurrentSpan());
            autofitRecyclerView.setAdapter(new SearchAdaptor(CollectionsKt.toMutableList((Collection) item.getList()), autofitRecyclerView, null, new HomeFragment$Companion$loadHomepageList$2(activity, bottomSheetDialog), 4, null));
            final HomeFragment$Companion$loadHomepageList$spanListener$1 homeFragment$Companion$loadHomepageList$spanListener$1 = new HomeFragment$Companion$loadHomepageList$spanListener$1(autofitRecyclerView);
            getConfigEvent().plusAssign(homeFragment$Companion$loadHomepageList$spanListener$1);
            bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$Companion$8EBRJe9bmoBQFhabLfsrO5-JLRA
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    HomeFragment.Companion.m8640loadHomepageList$lambda1(Function1.this, dialogInterface);
                }
            });
            bottomSheetDialog.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: loadHomepageList$lambda-0  reason: not valid java name */
        public static final void m8639loadHomepageList$lambda0(BottomSheetDialog bottomSheetDialogBuilder, Activity this_loadHomepageList, View view) {
            Intrinsics.checkNotNullParameter(bottomSheetDialogBuilder, "$bottomSheetDialogBuilder");
            Intrinsics.checkNotNullParameter(this_loadHomepageList, "$this_loadHomepageList");
            UIHelper.INSTANCE.dismissSafe(bottomSheetDialogBuilder, this_loadHomepageList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: loadHomepageList$lambda-1  reason: not valid java name */
        public static final void m8640loadHomepageList$lambda1(Function1 spanListener, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(spanListener, "$spanListener");
            HomeFragment.Companion.getConfigEvent().minusAssign(spanListener);
        }

        public final List<Tuples<MaterialButton, List<TvType>>> getPairList(MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, MaterialButton materialButton4, MaterialButton materialButton5, MaterialButton materialButton6) {
            return CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples(materialButton, CollectionsKt.listOf((Object[]) new TvType[]{TvType.Anime, TvType.OVA, TvType.AnimeMovie})), new Tuples(materialButton2, CollectionsKt.listOf(TvType.Cartoon)), new Tuples(materialButton3, CollectionsKt.listOf(TvType.TvSeries)), new Tuples(materialButton4, CollectionsKt.listOf(TvType.Documentary)), new Tuples(materialButton5, CollectionsKt.listOf((Object[]) new TvType[]{TvType.Movie, TvType.Torrent})), new Tuples(materialButton6, CollectionsKt.listOf(TvType.AsianDrama))});
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00d2, code lost:
            if (r3 != null) goto L32;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x014b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0168  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0171  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0176  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0188  */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List, T] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void selectHomepage(final android.content.Context r28, final java.lang.String r29, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r30) {
            /*
                Method dump skipped, instructions count: 647
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.home.HomeFragment.Companion.selectHomepage(android.content.Context, java.lang.String, kotlin.jvm.functions.Function1):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: selectHomepage$lambda-17$lambda-4  reason: not valid java name */
        public static final void m8644selectHomepage$lambda17$lambda4(BottomSheetDialog dialog, View view) {
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            UIHelper.INSTANCE.dismissSafe(dialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: selectHomepage$lambda-17$lambda-5  reason: not valid java name */
        public static final void m8645selectHomepage$lambda17$lambda5(Ref.ObjectRef currentApiName, String str, Function1 callback, BottomSheetDialog dialog, View view) {
            String str2;
            Intrinsics.checkNotNullParameter(currentApiName, "$currentApiName");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            if (!Intrinsics.areEqual(currentApiName.element, str) && (str2 = (String) currentApiName.element) != null) {
                callback.invoke(str2);
            }
            UIHelper.INSTANCE.dismissSafe(dialog);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.String] */
        /* renamed from: selectHomepage$lambda-17$lambda-6  reason: not valid java name */
        public static final void m8646selectHomepage$lambda17$lambda6(Ref.ObjectRef currentValidApis, Ref.ObjectRef currentApiName, Function1 callback, BottomSheetDialog dialog, AdapterView adapterView, View view, int i, long j) {
            Intrinsics.checkNotNullParameter(currentValidApis, "$currentValidApis");
            Intrinsics.checkNotNullParameter(currentApiName, "$currentApiName");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(dialog, "$dialog");
            if (!((Collection) currentValidApis.element).isEmpty()) {
                currentApiName.element = ((MainAPI) ((List) currentValidApis.element).get(i)).getName();
                String str = (String) currentApiName.element;
                if (str != null) {
                    callback.invoke(str);
                }
                UIHelper.INSTANCE.dismissSafe(dialog);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
            if (r4 != false) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00cd, code lost:
            if (r3 != null) goto L37;
         */
        /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List, T] */
        /* renamed from: selectHomepage$lambda-17$updateList  reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static final void m8647selectHomepage$lambda17$updateList(android.content.Context r6, java.util.List<com.lagradost.cloudstream3.TvType> r7, android.widget.ArrayAdapter<java.lang.String> r8, kotlin.jvm.internal.Ref.ObjectRef<java.util.List<com.lagradost.cloudstream3.MainAPI>> r9, java.util.List<com.lagradost.cloudstream3.MainAPI> r10, kotlin.jvm.internal.Ref.ObjectRef<java.lang.String> r11, android.widget.ListView r12, boolean r13) {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lagradost.cloudstream3.p041ui.home.HomeFragment.Companion.m8647selectHomepage$lambda17$updateList(android.content.Context, java.util.List, android.widget.ArrayAdapter, kotlin.jvm.internal.Ref$ObjectRef, java.util.List, kotlin.jvm.internal.Ref$ObjectRef, android.widget.ListView, boolean):void");
        }

        /* renamed from: selectHomepage$lambda-17$buttonContains  reason: not valid java name */
        private static final boolean m8641selectHomepage$lambda17$buttonContains(List<TvType> list, List<? extends TvType> list2) {
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
        /* renamed from: selectHomepage$lambda-17$lambda-15  reason: not valid java name */
        public static final void m8642selectHomepage$lambda17$lambda15(List preSelectedTypes, List validTypes, List pairList, MaterialButton materialButton, Context this_selectHomepage, ArrayAdapter arrayAdapter, Ref.ObjectRef currentValidApis, List validAPIs, Ref.ObjectRef currentApiName, ListView listView, boolean z, View view) {
            Intrinsics.checkNotNullParameter(preSelectedTypes, "$preSelectedTypes");
            Intrinsics.checkNotNullParameter(validTypes, "$validTypes");
            Intrinsics.checkNotNullParameter(pairList, "$pairList");
            Intrinsics.checkNotNullParameter(this_selectHomepage, "$this_selectHomepage");
            Intrinsics.checkNotNullParameter(arrayAdapter, "$arrayAdapter");
            Intrinsics.checkNotNullParameter(currentValidApis, "$currentValidApis");
            Intrinsics.checkNotNullParameter(validAPIs, "$validAPIs");
            Intrinsics.checkNotNullParameter(currentApiName, "$currentApiName");
            preSelectedTypes.clear();
            preSelectedTypes.addAll(validTypes);
            Iterator it = pairList.iterator();
            while (it.hasNext()) {
                MaterialButton materialButton2 = (MaterialButton) ((Tuples) it.next()).component1();
                if (materialButton2 != null) {
                    materialButton2.setSelected(false);
                }
            }
            materialButton.setSelected(true);
            m8647selectHomepage$lambda17$updateList(this_selectHomepage, preSelectedTypes, arrayAdapter, currentValidApis, validAPIs, currentApiName, listView, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: selectHomepage$lambda-17$lambda-16  reason: not valid java name */
        public static final boolean m8643selectHomepage$lambda17$lambda16(MaterialButton materialButton, List preSelectedTypes, List validTypes, Context this_selectHomepage, ArrayAdapter arrayAdapter, Ref.ObjectRef currentValidApis, List validAPIs, Ref.ObjectRef currentApiName, ListView listView, boolean z, View view) {
            Intrinsics.checkNotNullParameter(preSelectedTypes, "$preSelectedTypes");
            Intrinsics.checkNotNullParameter(validTypes, "$validTypes");
            Intrinsics.checkNotNullParameter(this_selectHomepage, "$this_selectHomepage");
            Intrinsics.checkNotNullParameter(arrayAdapter, "$arrayAdapter");
            Intrinsics.checkNotNullParameter(currentValidApis, "$currentValidApis");
            Intrinsics.checkNotNullParameter(validAPIs, "$validAPIs");
            Intrinsics.checkNotNullParameter(currentApiName, "$currentApiName");
            if (!m8641selectHomepage$lambda17$buttonContains(preSelectedTypes, validTypes)) {
                materialButton.setSelected(true);
                preSelectedTypes.addAll(validTypes);
            } else {
                materialButton.setSelected(false);
                preSelectedTypes.removeAll(validTypes);
            }
            m8647selectHomepage$lambda17$updateList(this_selectHomepage, preSelectedTypes, arrayAdapter, currentValidApis, validAPIs, currentApiName, listView, z);
            return true;
        }
    }

    public HomeFragment() {
        HomeFragment homeFragment = this;
        this.homeViewModel$delegate = FragmentViewModelLazy.createViewModelLazy(homeFragment, Reflection.getOrCreateKotlinClass(HomeViewModel.class), new HomeFragment$special$$inlined$activityViewModels$default$1(homeFragment), new HomeFragment$special$$inlined$activityViewModels$default$2(null, homeFragment), new HomeFragment$special$$inlined$activityViewModels$default$3(homeFragment));
    }

    static {
        List<Integer> listOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf((int) R.drawable.monke_benene), Integer.valueOf((int) R.drawable.monke_burrito), Integer.valueOf((int) R.drawable.monke_coco), Integer.valueOf((int) R.drawable.monke_cookie), Integer.valueOf((int) R.drawable.monke_flusdered), Integer.valueOf((int) R.drawable.monke_funny), Integer.valueOf((int) R.drawable.monke_like), Integer.valueOf((int) R.drawable.monke_party), Integer.valueOf((int) R.drawable.monke_sob), Integer.valueOf((int) R.drawable.monke_drink)});
        errorProfilePics = listOf;
        errorProfilePic = ((Number) CollectionsKt.random(listOf, Random.Default)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeViewModel getHomeViewModel() {
        return (HomeViewModel) this.homeViewModel$delegate.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = getContext();
        boolean z = true;
        return inflater.inflate((context == null || !SettingsFragment.Companion.isTvSettings(context)) ? false : false ? R.layout.fragment_home_tv : R.layout.fragment_home, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void toggleMainVisibility$default(HomeFragment homeFragment, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = true;
        }
        homeFragment.toggleMainVisibility(z, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleMainVisibility(boolean z, Boolean bool) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C4761R.C4764id.home_main_holder);
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview);
        if (recyclerView == null) {
            return;
        }
        recyclerView.setVisibility(Intrinsics.areEqual((Object) bool, (Object) true) ? 0 : 8);
    }

    private final void fixGrid() {
        Integer spanCount;
        FragmentActivity activity = getActivity();
        if (activity != null && (spanCount = UIHelper.INSTANCE.getSpanCount(activity)) != null) {
            currentSpan = spanCount.intValue();
        }
        configEvent.invoke(Integer.valueOf(currentSpan));
    }

    public final Page toPage(MainAPI mainAPI) {
        Intrinsics.checkNotNullParameter(mainAPI, "<this>");
        return new Page(mainAPI.getName(), mainAPI.getMainUrl(), false, mainAPI.getName(), null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: apiChangeClickListener$lambda-3  reason: not valid java name */
    public static final void m8630apiChangeClickListener$lambda3(final HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null && SettingsFragment.Companion.isTrueTvSettings(context)) {
            Companion companion = Companion;
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            companion.selectHomepage(context2, this$0.currentApiName, new HomeFragment$apiChangeClickListener$1$1(this$0));
            return;
        }
        APIHolder aPIHolder = APIHolder.INSTANCE;
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        List<MainAPI> mutableList = CollectionsKt.toMutableList((Collection) APIHolder.filterProviderByPreferredMedia$default(aPIHolder, context3, false, 1, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mutableList, 10));
        for (MainAPI mainAPI : mutableList) {
            arrayList.add(this$0.toPage(mainAPI));
        }
        ArrayList arrayList2 = arrayList;
        ICallbackDialogFilter iCallbackDialogFilter = this$0.getICallbackDialogFilter();
        if (iCallbackDialogFilter != null) {
            iCallbackDialogFilter.showDialogFilter(arrayList2, new ICallback() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$zVFmis8TbZUYxJ5mI7HZqjJPiqI
                @Override // com.lagradost.cloudstream3.p041ui.browser.ICallback
                public final void onCallback(Object obj) {
                    HomeFragment.m8631apiChangeClickListener$lambda3$lambda2(HomeFragment.this, (Page) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: apiChangeClickListener$lambda-3$lambda-2  reason: not valid java name */
    public static final void m8631apiChangeClickListener$lambda3$lambda2(HomeFragment this$0, Page page) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Log.d("Blue", "Page " + page.getName() + ' ' + page.getUrl());
        this$0.getHomeViewModel().loadAndCancel(page.getName());
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        fixGrid();
    }

    @Override // com.phimhd.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        reloadStored();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadStored() {
        getHomeViewModel().loadResumeWatching();
        EnumSet<WatchType> noneOf = EnumSet.noneOf(WatchType.class);
        Context context = AcraApplication.Companion.getContext();
        Object obj = null;
        if (context != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                String string = dataStore.getSharedPrefs(context).getString(HomeFragmentKt.HOME_BOOKMARK_VALUE_LIST, null);
                if (string != null) {
                    Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                    Object readValue = dataStore.getMapper().readValue(string, int[].class);
                    Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                    obj = readValue;
                }
            } catch (Exception unused) {
            }
        }
        int[] iArr = (int[]) obj;
        if (iArr != null) {
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i : iArr) {
                arrayList.add(WatchType.Companion.fromInternalId(Integer.valueOf(i)));
            }
            noneOf.addAll(arrayList);
        }
        getHomeViewModel().loadStoredData(noneOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void focusCallback(SearchResponse searchResponse) {
        TextView textView = (TextView) _$_findCachedViewById(C4761R.C4764id.home_focus_text);
        if (textView != null) {
            textView.setText(searchResponse.getName());
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_blur_poster);
        if (imageView != null) {
            UIHelper.setImageBlur$default(UIHelper.INSTANCE, imageView, searchResponse.getPosterUrl(), 50, 10, null, 8, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void homeHandleSearch(SearchClickCallback searchClickCallback) {
        if (searchClickCallback.getAction() == 4) {
            focusCallback(searchClickCallback.getCard());
        } else {
            SearchHelper.INSTANCE.handleSearchClickCallback(getActivity(), searchClickCallback);
        }
    }

    public final String getCurrentApiName() {
        return this.currentApiName;
    }

    public final void setCurrentApiName(String str) {
        this.currentApiName = str;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        boolean z;
        Object obj;
        String string;
        ExtendedFloatingActionButton extendedFloatingActionButton;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        fixGrid();
        ImageView imageView = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api);
        if (imageView != null) {
            imageView.setOnClickListener(this.apiChangeClickListener);
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api_loading);
        if (imageView2 != null) {
            imageView2.setOnClickListener(this.apiChangeClickListener);
        }
        ExtendedFloatingActionButton extendedFloatingActionButton2 = (ExtendedFloatingActionButton) _$_findCachedViewById(C4761R.C4764id.home_api_fab);
        if (extendedFloatingActionButton2 != null) {
            extendedFloatingActionButton2.setOnClickListener(this.apiChangeClickListener);
        }
        ExtendedFloatingActionButton extendedFloatingActionButton3 = (ExtendedFloatingActionButton) _$_findCachedViewById(C4761R.C4764id.home_random);
        if (extendedFloatingActionButton3 != null) {
            extendedFloatingActionButton3.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$xeCOAlhORD77a1RMKFpon3thqZk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeFragment.m8634onViewCreated$lambda6(HomeFragment.this, view2);
                }
            });
        }
        Context context = getContext();
        if (context != null) {
            this.toggleRandomButton = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(getString(R.string.random_button_key), false);
            ExtendedFloatingActionButton home_random = (ExtendedFloatingActionButton) _$_findCachedViewById(C4761R.C4764id.home_random);
            if (home_random != null) {
                Intrinsics.checkNotNullExpressionValue(home_random, "home_random");
                home_random.setVisibility(this.toggleRandomButton ? 0 : 8);
            }
            if (!this.toggleRandomButton && (extendedFloatingActionButton = (ExtendedFloatingActionButton) _$_findCachedViewById(C4761R.C4764id.home_random)) != null) {
                extendedFloatingActionButton.setVisibility(8);
            }
        }
        HomeFragment homeFragment = this;
        ArchComponentExt.observe(homeFragment, getHomeViewModel().getApiName(), new HomeFragment$onViewCreated$3(this));
        ArchComponentExt.observe(homeFragment, getHomeViewModel().getRandomItems(), new HomeFragment$onViewCreated$4(this));
        SearchView searchView = (SearchView) _$_findCachedViewById(C4761R.C4764id.home_search);
        if (searchView != null) {
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: com.lagradost.cloudstream3.ui.home.HomeFragment$onViewCreated$5
                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextChange(String newText) {
                    Intrinsics.checkNotNullParameter(newText, "newText");
                    return true;
                }

                @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
                public boolean onQueryTextSubmit(String query) {
                    Intrinsics.checkNotNullParameter(query, "query");
                    QuickSearchFragment.Companion companion = QuickSearchFragment.Companion;
                    FragmentActivity activity = HomeFragment.this.getActivity();
                    String currentApiName = HomeFragment.this.getCurrentApiName();
                    companion.pushSearch(activity, query, currentApiName != null ? new String[]{currentApiName} : null);
                    return true;
                }
            });
        }
        ArchComponentExt.observe(homeFragment, getHomeViewModel().getPage(), new HomeFragment$onViewCreated$6(this));
        HomeParentItemAdapter homeParentItemAdapter = new HomeParentItemAdapter(new ArrayList(), new HomeFragment$onViewCreated$adapter$1(this), new HomeFragment$onViewCreated$adapter$2(this));
        List<Tuples> listOf = CollectionsKt.listOf((Object[]) new Tuples[]{new Tuples((MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_type_watching_btt), WatchType.WATCHING), new Tuples((MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_type_completed_btt), WatchType.COMPLETED), new Tuples((MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_type_dropped_btt), WatchType.DROPPED), new Tuples((MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_type_on_hold_btt), WatchType.ONHOLD), new Tuples((MaterialButton) _$_findCachedViewById(C4761R.C4764id.home_plan_to_watch_btt), WatchType.PLANTOWATCH)});
        for (Tuples tuples : listOf) {
            final WatchType watchType = (WatchType) tuples.getSecond();
            MaterialButton materialButton = (MaterialButton) tuples.getFirst();
            if (materialButton != null) {
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$wwOlOSTu0Xw38tNe4WrLiE0Vmu0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        HomeFragment.m8635onViewCreated$lambda8(HomeFragment.this, watchType, view2);
                    }
                });
            }
            MaterialButton materialButton2 = (MaterialButton) tuples.getFirst();
            if (materialButton2 != null) {
                materialButton2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$PPdt45T7gC2VDq7MrEwyDehKibk
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        boolean m8632onViewCreated$lambda11;
                        m8632onViewCreated$lambda11 = HomeFragment.m8632onViewCreated$lambda11(WatchType.this, this, view2);
                        return m8632onViewCreated$lambda11;
                    }
                });
            }
        }
        ArchComponentExt.observe(homeFragment, getHomeViewModel().getAvailableWatchStatusTypes(), new HomeFragment$onViewCreated$9(this, listOf));
        ArchComponentExt.observe(homeFragment, getHomeViewModel().getBookmarks(), new HomeFragment$onViewCreated$10(this));
        ArchComponentExt.observe(homeFragment, getHomeViewModel().getResumeWatching(), new HomeFragment$onViewCreated$11(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_bookmarked_child_recyclerview);
        ArrayList arrayList = new ArrayList();
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_bookmarked_child_recyclerview);
        Integer valueOf = recyclerView2 != null ? Integer.valueOf(recyclerView2.getNextFocusUpId()) : null;
        RecyclerView recyclerView3 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_bookmarked_child_recyclerview);
        recyclerView.setAdapter(new HomeChildItemAdapter(arrayList, Integer.valueOf((int) R.layout.home_result_circle_grid), valueOf, recyclerView3 != null ? Integer.valueOf(recyclerView3.getNextFocusDownId()) : null, new HomeFragment$onViewCreated$12(this)));
        RecyclerView recyclerView4 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_watch_child_recyclerview);
        if (recyclerView4 != null) {
            ArrayList arrayList2 = new ArrayList();
            RecyclerView recyclerView5 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_watch_child_recyclerview);
            Integer valueOf2 = recyclerView5 != null ? Integer.valueOf(recyclerView5.getNextFocusUpId()) : null;
            RecyclerView recyclerView6 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_watch_child_recyclerview);
            recyclerView4.setAdapter(new HomeChildItemAdapter(arrayList2, null, valueOf2, recyclerView6 != null ? Integer.valueOf(recyclerView6.getNextFocusDownId()) : null, new HomeFragment$onViewCreated$13(this), 2, null));
        }
        ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_master_recycler)).setAdapter(homeParentItemAdapter);
        ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_master_recycler)).setLayoutManager(new GridLayoutManager(getContext(), 1));
        Context context2 = getContext();
        if ((context2 == null || SettingsFragment.Companion.isTvSettings(context2)) ? false : true) {
            new LinearSnapHelper().attachToRecyclerView((RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview));
            CenterZoomLayoutManager centerZoomLayoutManager = new CenterZoomLayoutManager(getContext(), 0, false);
            centerZoomLayoutManager.setOnSizeListener(new HomeFragment$onViewCreated$14(this));
            RecyclerView recyclerView7 = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.home_main_poster_recyclerview);
            if (recyclerView7 != null) {
                recyclerView7.setLayoutManager(centerZoomLayoutManager);
            }
        }
        reloadStored();
        Context context3 = getContext();
        if (context3 != null) {
            DataStore dataStore = DataStore.INSTANCE;
            try {
                string = dataStore.getSharedPrefs(context3).getString(DataStoreKt.HOMEPAGE_API, null);
            } catch (Exception unused) {
            }
            if (string == null) {
                obj = null;
                str = (String) obj;
            } else {
                Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                obj = dataStore.getMapper().readValue(string, String.class);
                Intrinsics.checkNotNullExpressionValue(obj, "mapper.readValue(this, T::class.java)");
                str = (String) obj;
            }
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(getHomeViewModel().getApiName().getValue(), str) || str == null) {
            getHomeViewModel().loadAndCancel(str);
        }
        ((NestedScrollView) _$_findCachedViewById(C4761R.C4764id.home_loaded)).setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$HomeFragment$CrXWehQ1Amwcob1LjN_whiUNrW4
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                HomeFragment.m8633onViewCreated$lambda12(HomeFragment.this, nestedScrollView, i, i2, i3, i4);
            }
        });
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.home_profile_picture_holder);
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        Context context4 = getContext();
        if (context4 != null) {
            if (SettingsFragment.Companion.isTvSettings(context4)) {
                ExtendedFloatingActionButton home_api_fab = (ExtendedFloatingActionButton) _$_findCachedViewById(C4761R.C4764id.home_api_fab);
                if (home_api_fab != null) {
                    Intrinsics.checkNotNullExpressionValue(home_api_fab, "home_api_fab");
                    home_api_fab.setVisibility(8);
                }
                ImageView home_change_api = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api);
                if (home_change_api != null) {
                    Intrinsics.checkNotNullExpressionValue(home_change_api, "home_change_api");
                    home_change_api.setVisibility(0);
                }
                if (SettingsFragment.Companion.isTrueTvSettings(context4)) {
                    ImageView home_change_api_loading = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api_loading);
                    if (home_change_api_loading != null) {
                        Intrinsics.checkNotNullExpressionValue(home_change_api_loading, "home_change_api_loading");
                        home_change_api_loading.setVisibility(0);
                    }
                    ImageView imageView3 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api_loading);
                    if (imageView3 != null) {
                        imageView3.setFocusable(true);
                    }
                    ImageView imageView4 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api_loading);
                    if (imageView4 != null) {
                        imageView4.setFocusableInTouchMode(true);
                    }
                    ImageView imageView5 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api);
                    if (imageView5 != null) {
                        imageView5.setFocusable(true);
                    }
                    ImageView imageView6 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api);
                    if (imageView6 != null) {
                        imageView6.setFocusableInTouchMode(true);
                    }
                }
            } else {
                ExtendedFloatingActionButton home_api_fab2 = (ExtendedFloatingActionButton) _$_findCachedViewById(C4761R.C4764id.home_api_fab);
                if (home_api_fab2 != null) {
                    Intrinsics.checkNotNullExpressionValue(home_api_fab2, "home_api_fab");
                    home_api_fab2.setVisibility(0);
                }
                ImageView home_change_api2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api);
                if (home_change_api2 != null) {
                    Intrinsics.checkNotNullExpressionValue(home_change_api2, "home_change_api");
                    home_change_api2.setVisibility(8);
                }
                ImageView home_change_api_loading2 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_change_api_loading);
                if (home_change_api_loading2 != null) {
                    Intrinsics.checkNotNullExpressionValue(home_change_api_loading2, "home_change_api_loading");
                    home_change_api_loading2.setVisibility(8);
                }
            }
            Iterator<OAuth2API> it = AccountManager.Companion.getOAuth2Apis().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AuthAPI.LoginInfo loginInfo = it.next().loginInfo();
                String profilePicture = loginInfo != null ? loginInfo.getProfilePicture() : null;
                ImageView imageView7 = (ImageView) _$_findCachedViewById(C4761R.C4764id.home_profile_picture);
                if (imageView7 == null || !UIHelper.setImage$default(UIHelper.INSTANCE, imageView7, profilePicture, null, Integer.valueOf(errorProfilePic), 2, null)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    FrameLayout home_profile_picture_holder = (FrameLayout) _$_findCachedViewById(C4761R.C4764id.home_profile_picture_holder);
                    if (home_profile_picture_holder != null) {
                        Intrinsics.checkNotNullExpressionValue(home_profile_picture_holder, "home_profile_picture_holder");
                        home_profile_picture_holder.setVisibility(0);
                    }
                }
            }
        }
        setUpHomeScreenWithPhimHD(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final void m8634onViewCreated$lambda6(HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<SearchResponse> list = listHomepageItems;
        if (!list.isEmpty()) {
            AppUtils.loadSearchResult$default(AppUtils.INSTANCE, this$0.getActivity(), (SearchResponse) CollectionsKt.random(list, Random.Default), 0, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-8  reason: not valid java name */
    public static final void m8635onViewCreated$lambda8(HomeFragment this$0, WatchType watch, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        this$0.getHomeViewModel().loadStoredData(EnumSet.of(watch));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-11  reason: not valid java name */
    public static final boolean m8632onViewCreated$lambda11(WatchType watch, HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(watch, "$watch");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EnumSet<WatchType> noneOf = EnumSet.noneOf(WatchType.class);
        DataStore dataStore = DataStore.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        Object obj = null;
        try {
            String string = dataStore.getSharedPrefs(context).getString(HomeFragmentKt.HOME_BOOKMARK_VALUE_LIST, null);
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "getSharedPrefs().getStri…h, null) ?: return defVal");
                Object readValue = dataStore.getMapper().readValue(string, int[].class);
                Intrinsics.checkNotNullExpressionValue(readValue, "mapper.readValue(this, T::class.java)");
                obj = readValue;
            }
        } catch (Exception unused) {
        }
        int[] iArr = (int[]) obj;
        if (iArr != null) {
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i : iArr) {
                arrayList.add(WatchType.Companion.fromInternalId(Integer.valueOf(i)));
            }
            noneOf.addAll(arrayList);
        }
        if (noneOf.contains(watch)) {
            noneOf.remove(watch);
        } else {
            noneOf.add(watch);
        }
        this$0.getHomeViewModel().loadStoredData(noneOf);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-12  reason: not valid java name */
    public static final void m8633onViewCreated$lambda12(HomeFragment this$0, NestedScrollView view, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        int i5 = i2 - i4;
        if (i5 > 0) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) this$0._$_findCachedViewById(C4761R.C4764id.home_api_fab);
            if (extendedFloatingActionButton != null) {
                extendedFloatingActionButton.shrink();
            }
            ExtendedFloatingActionButton extendedFloatingActionButton2 = (ExtendedFloatingActionButton) this$0._$_findCachedViewById(C4761R.C4764id.home_random);
            if (extendedFloatingActionButton2 != null) {
                extendedFloatingActionButton2.shrink();
            }
        } else if (i5 < -5) {
            Context context = view.getContext();
            boolean z = false;
            if (context != null && !SettingsFragment.Companion.isTvSettings(context)) {
                z = true;
            }
            if (z) {
                ExtendedFloatingActionButton extendedFloatingActionButton3 = (ExtendedFloatingActionButton) this$0._$_findCachedViewById(C4761R.C4764id.home_api_fab);
                if (extendedFloatingActionButton3 != null) {
                    extendedFloatingActionButton3.extend();
                }
                ExtendedFloatingActionButton extendedFloatingActionButton4 = (ExtendedFloatingActionButton) this$0._$_findCachedViewById(C4761R.C4764id.home_random);
                if (extendedFloatingActionButton4 != null) {
                    extendedFloatingActionButton4.extend();
                }
            }
        }
    }
}

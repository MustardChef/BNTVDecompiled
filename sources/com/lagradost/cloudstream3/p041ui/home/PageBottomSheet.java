package com.lagradost.cloudstream3.p041ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.LogUtils;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.PageResponse;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.p041ui.search.SearchAdaptor;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageBottomSheet.kt */
@Metadata(m108d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/PageBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "is_loading", "", "()Z", "set_loading", "(Z)V", "listData", "Ljava/util/ArrayList;", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lkotlin/collections/ArrayList;", "name", "", "nameApi", "url", "viewModel", "Lcom/lagradost/cloudstream3/ui/home/PageViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.home.PageBottomSheet */
/* loaded from: classes3.dex */
public final class PageBottomSheet extends BottomSheetDialogFragment {
    public static final Companion Companion = new Companion(null);
    private boolean is_loading;
    private String name;
    private String nameApi;
    private String url;
    private PageViewModel viewModel;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ArrayList<SearchResponse> listData = new ArrayList<>();

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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    /* compiled from: PageBottomSheet.kt */
    @Metadata(m108d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J(\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\r"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/home/PageBottomSheet$Companion;", "", "()V", "newInstance", "Lcom/lagradost/cloudstream3/ui/home/PageBottomSheet;", "url", "", "name", "nameApi", "push", "", "activity", "Landroid/app/Activity;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.home.PageBottomSheet$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PageBottomSheet newInstance(String url, String name, String nameApi) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(nameApi, "nameApi");
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            bundle.putString("name", name);
            bundle.putString("nameApi", nameApi);
            PageBottomSheet pageBottomSheet = new PageBottomSheet();
            pageBottomSheet.setArguments(bundle);
            return pageBottomSheet;
        }

        public final void push(Activity activity, String url, String name, String nameApi) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(nameApi, "nameApi");
            UIHelper uIHelper = UIHelper.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            bundle.putString("name", name);
            bundle.putString("nameApi", nameApi);
            Unit unit = Unit.INSTANCE;
            uIHelper.navigate(activity, R.id.global_to_navigation_page, bundle);
        }
    }

    public final boolean is_loading() {
        return this.is_loading;
    }

    public final void set_loading(boolean z) {
        this.is_loading = z;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.viewModel = (PageViewModel) new ViewModelProvider(this).get(PageViewModel.class);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.name = arguments.getString("name", "");
            this.url = arguments.getString("url", "");
            this.nameApi = arguments.getString("nameApi", "");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_page, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.home_expanded_text);
        Intrinsics.checkNotNull(findViewById);
        ((TextView) findViewById).setText(this.name);
        View findViewById2 = view.findViewById(R.id.home_expanded_recycler);
        Intrinsics.checkNotNull(findViewById2);
        final AutofitRecyclerView autofitRecyclerView = (AutofitRecyclerView) findViewById2;
        View findViewById3 = view.findViewById(R.id.home_expanded_drag_down);
        Intrinsics.checkNotNull(findViewById3);
        ((FrameLayout) findViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$PageBottomSheet$VbHvrDJY2R4If3IRf7l4Gx9LXrQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PageBottomSheet.m8658onViewCreated$lambda1(PageBottomSheet.this, view2);
            }
        });
        autofitRecyclerView.setSpanCount(HomeFragment.Companion.getCurrentSpan());
        autofitRecyclerView.setAdapter(new SearchAdaptor(this.listData, autofitRecyclerView, true, new PageBottomSheet$onViewCreated$2(this)));
        autofitRecyclerView.setEnableLoadmore(true);
        autofitRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.lagradost.cloudstream3.ui.home.PageBottomSheet$onViewCreated$3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                String str;
                PageViewModel pageViewModel;
                String str2;
                String str3;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(gridLayoutManager);
                if (gridLayoutManager.getItemCount() > gridLayoutManager.findLastCompletelyVisibleItemPosition() + 2 || PageBottomSheet.this.is_loading()) {
                    return;
                }
                PageBottomSheet.this.set_loading(true);
                if (autofitRecyclerView.getNoMore()) {
                    return;
                }
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                PageViewModel pageViewModel2 = null;
                Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemCount()) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.intValue() > 1) {
                    Log.d("Blue", "Loadmore  now ------>");
                    str = PageBottomSheet.this.url;
                    if (str != null) {
                        PageBottomSheet pageBottomSheet = PageBottomSheet.this;
                        pageViewModel = pageBottomSheet.viewModel;
                        if (pageViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        } else {
                            pageViewModel2 = pageViewModel;
                        }
                        str2 = pageBottomSheet.name;
                        str3 = pageBottomSheet.nameApi;
                        pageViewModel2.getPage(str, str2, str3);
                    }
                }
            }
        });
        new PageBottomSheet$onViewCreated$spanListener$1(autofitRecyclerView);
        PageViewModel pageViewModel = this.viewModel;
        PageViewModel pageViewModel2 = null;
        if (pageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            pageViewModel = null;
        }
        pageViewModel.getSearchResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: com.lagradost.cloudstream3.ui.home.-$$Lambda$PageBottomSheet$9OE-s2vV68f2wE1GQ_Oad_mwEI0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PageBottomSheet.m8659onViewCreated$lambda2(PageBottomSheet.this, autofitRecyclerView, (Resource) obj);
            }
        });
        PageViewModel pageViewModel3 = this.viewModel;
        if (pageViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            pageViewModel2 = pageViewModel3;
        }
        pageViewModel2.getPage(this.url, this.name, this.nameApi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m8658onViewCreated$lambda1(PageBottomSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m8659onViewCreated$lambda2(PageBottomSheet this$0, AutofitRecyclerView recycle, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recycle, "$recycle");
        if (resource instanceof Resource.Loading) {
            return;
        }
        if (resource instanceof Resource.Failure) {
            this$0.is_loading = false;
            Log.e("Blue", "Error 1 " + ((Resource.Failure) resource).getErrorString());
            recycle.loadMoreComplete();
            recycle.setEnableLoadmore(false);
        } else if (resource instanceof Resource.Success) {
            this$0.is_loading = false;
            recycle.loadMoreComplete();
            Resource.Success success = (Resource.Success) resource;
            boolean z = ((PageResponse) success.getValue()).getNextUrl() == null;
            recycle.setNoMore(z);
            this$0.url = ((PageResponse) success.getValue()).getNextUrl();
            if (this$0.listData.size() == 0) {
                this$0.listData.addAll(((PageResponse) success.getValue()).getList());
                RecyclerView.Adapter adapter = recycle.getAdapter();
                Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.lagradost.cloudstream3.ui.search.SearchAdapter");
                ((SearchAdaptor) adapter).notifyDataSetChanged();
                LogUtils.m6080d("Blue", "notifyDataSetChanged");
            } else if (!((PageResponse) success.getValue()).getList().isEmpty()) {
                int size = this$0.listData.size();
                this$0.listData.addAll(((PageResponse) success.getValue()).getList());
                RecyclerView.Adapter adapter2 = recycle.getAdapter();
                if (adapter2 != null) {
                    adapter2.notifyItemRangeInserted(size, ((PageResponse) success.getValue()).getList().size());
                }
                LogUtils.m6080d("Blue", "notifyItemRangeInserted");
            } else {
                RecyclerView.Adapter adapter3 = recycle.getAdapter();
                Objects.requireNonNull(adapter3, "null cannot be cast to non-null type com.lagradost.cloudstream3.ui.search.SearchAdapter");
                ((SearchAdaptor) adapter3).setEnableLoadmore(Boolean.valueOf(!z));
                RecyclerView.Adapter adapter4 = recycle.getAdapter();
                Objects.requireNonNull(adapter4, "null cannot be cast to non-null type com.lagradost.cloudstream3.ui.search.SearchAdapter");
                ((SearchAdaptor) adapter4).notifyDataSetChanged();
                LogUtils.m6080d("Blue", "notifyDataSetChanged No more");
                Toast.makeText(this$0.getContext(), "Danh sách đã hết", 0).show();
            }
        }
    }
}

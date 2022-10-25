package com.lagradost.cloudstream3.p041ui.download;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.Event;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadFragment.kt */
@Metadata(m108d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0016\u0010\u0019\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0014\u0010\u001d\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\fH\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006 "}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadFragment;", "Landroidx/fragment/app/Fragment;", "()V", "downloadDeleteEventListener", "Lkotlin/Function1;", "", "", "downloadsViewModel", "Lcom/lagradost/cloudstream3/ui/download/DownloadViewModel;", "getBytesAsText", "", "bytes", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "setList", "list", "", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadHeaderCached;", "setLayoutWidth", "weight", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadFragment */
/* loaded from: classes3.dex */
public final class DownloadFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Function1<? super Integer, Unit> downloadDeleteEventListener;
    private DownloadViewModel downloadsViewModel;

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

    /* compiled from: DownloadFragment.kt */
    @Metadata(m108d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadFragment$Companion;", "", "()V", "push", "", "activity", "Landroid/app/Activity;", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.download.DownloadFragment$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void push(Activity activity) {
            UIHelper uIHelper = UIHelper.INSTANCE;
            Bundle bundle = new Bundle();
            Unit unit = Unit.INSTANCE;
            uIHelper.navigate(activity, R.id.global_to_navigation_downloads, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getBytesAsText(long j) {
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(((float) j) / 1.0E9f)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLayoutWidth(View view, long j) {
        view.setLayoutParams(new LinearLayout.LayoutParams(0, -1, Math.max(((float) j) / 1.0E9f, 0.1f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setList(List<VisualDownloadHeaderCached> list) {
        Coroutines.INSTANCE.main(new DownloadFragment$setList$1(this, list, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.download_list);
        DownloadHeaderAdapter downloadHeaderAdapter = (DownloadHeaderAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
        if (downloadHeaderAdapter != null) {
            downloadHeaderAdapter.killAdapter();
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.downloadDeleteEventListener != null) {
            Event<Integer> downloadDeleteEvent = VideoDownloadManager.INSTANCE.getDownloadDeleteEvent();
            Function1<? super Integer, Unit> function1 = this.downloadDeleteEventListener;
            Intrinsics.checkNotNull(function1);
            downloadDeleteEvent.minusAssign(function1);
            this.downloadDeleteEventListener = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DownloadViewModel downloadViewModel = (DownloadViewModel) new ViewModelProvider(this).get(DownloadViewModel.class);
        this.downloadsViewModel = downloadViewModel;
        DownloadFragment downloadFragment = this;
        DownloadViewModel downloadViewModel2 = null;
        if (downloadViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadsViewModel");
            downloadViewModel = null;
        }
        ArchComponentExt.observe(downloadFragment, downloadViewModel.getNoDownloadsText(), new DownloadFragment$onCreateView$1(this));
        DownloadViewModel downloadViewModel3 = this.downloadsViewModel;
        if (downloadViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadsViewModel");
            downloadViewModel3 = null;
        }
        ArchComponentExt.observe(downloadFragment, downloadViewModel3.getHeaderCards(), new DownloadFragment$onCreateView$2(this));
        DownloadViewModel downloadViewModel4 = this.downloadsViewModel;
        if (downloadViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadsViewModel");
            downloadViewModel4 = null;
        }
        ArchComponentExt.observe(downloadFragment, downloadViewModel4.getAvailableBytes(), new DownloadFragment$onCreateView$3(this));
        DownloadViewModel downloadViewModel5 = this.downloadsViewModel;
        if (downloadViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadsViewModel");
            downloadViewModel5 = null;
        }
        ArchComponentExt.observe(downloadFragment, downloadViewModel5.getUsedBytes(), new DownloadFragment$onCreateView$4(this));
        DownloadViewModel downloadViewModel6 = this.downloadsViewModel;
        if (downloadViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadsViewModel");
        } else {
            downloadViewModel2 = downloadViewModel6;
        }
        ArchComponentExt.observe(downloadFragment, downloadViewModel2.getDownloadBytes(), new DownloadFragment$onCreateView$5(this));
        return inflater.inflate(R.layout.fragment_downloads, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        UIHelper.INSTANCE.hideKeyboard(this);
        DownloadHeaderAdapter downloadHeaderAdapter = new DownloadHeaderAdapter(new ArrayList(), new DownloadFragment$onViewCreated$adapter$1(this), new DownloadFragment$onViewCreated$adapter$2(this));
        DownloadFragment$onViewCreated$1 downloadFragment$onViewCreated$1 = new DownloadFragment$onViewCreated$1(this);
        this.downloadDeleteEventListener = downloadFragment$onViewCreated$1;
        if (downloadFragment$onViewCreated$1 != null) {
            VideoDownloadManager.INSTANCE.getDownloadDeleteEvent().plusAssign(downloadFragment$onViewCreated$1);
        }
        ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.download_list)).setAdapter(downloadHeaderAdapter);
        ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.download_list)).setLayoutManager(new GridLayoutManager(getContext(), 1));
        DownloadViewModel downloadViewModel = this.downloadsViewModel;
        if (downloadViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadsViewModel");
            downloadViewModel = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        downloadViewModel.updateList(requireContext);
        Context context = getContext();
        if (context != null) {
            UIHelper.INSTANCE.fixPaddingStatusbar(context, (CoordinatorLayout) _$_findCachedViewById(C4761R.C4764id.download_root));
        }
    }
}

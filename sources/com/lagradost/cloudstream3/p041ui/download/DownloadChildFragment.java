package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bongngotv2.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.material.appbar.MaterialToolbar;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.utils.Coroutines;
import com.lagradost.cloudstream3.utils.UIHelper;
import com.lagradost.cloudstream3.utils.VideoDownloadManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: DownloadChildFragment.kt */
@Metadata(m108d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadChildFragment;", "Landroidx/fragment/app/Fragment;", "()V", "downloadDeleteEventListener", "Lkotlin/Function1;", "", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onViewCreated", ViewHierarchyConstants.VIEW_KEY, "updateList", "Lkotlinx/coroutines/Job;", "folder", "", "Companion", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadChildFragment */
/* loaded from: classes3.dex */
public final class DownloadChildFragment extends Fragment {
    public static final Companion Companion = new Companion(null);
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private Function1<? super Integer, Unit> downloadDeleteEventListener;

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

    /* compiled from: DownloadChildFragment.kt */
    @Metadata(m108d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, m107d2 = {"Lcom/lagradost/cloudstream3/ui/download/DownloadChildFragment$Companion;", "", "()V", "newInstance", "Landroid/os/Bundle;", "headerName", "", "folder", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.download.DownloadChildFragment$Companion */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Bundle newInstance(String headerName, String folder) {
            Intrinsics.checkNotNullParameter(headerName, "headerName");
            Intrinsics.checkNotNullParameter(folder, "folder");
            Bundle bundle = new Bundle();
            bundle.putString("folder", folder);
            bundle.putString("name", headerName);
            return bundle;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C4761R.C4764id.download_child_list);
        DownloadChildAdapter downloadChildAdapter = (DownloadChildAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
        if (downloadChildAdapter != null) {
            downloadChildAdapter.killAdapter();
        }
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Function1<? super Integer, Unit> function1 = this.downloadDeleteEventListener;
        if (function1 != null) {
            VideoDownloadManager.INSTANCE.getDownloadDeleteEvent().minusAssign(function1);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_child_downloads, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Job updateList(String str) {
        return Coroutines.INSTANCE.main(new DownloadChildFragment$updateList$1(this, str, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("folder") : null;
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("name") : null;
        if (string == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        Context context = getContext();
        if (context != null) {
            UIHelper.INSTANCE.fixPaddingStatusbar(context, (CoordinatorLayout) _$_findCachedViewById(C4761R.C4764id.download_child_root));
        }
        ((MaterialToolbar) _$_findCachedViewById(C4761R.C4764id.download_child_toolbar)).setTitle(string2);
        ((MaterialToolbar) _$_findCachedViewById(C4761R.C4764id.download_child_toolbar)).setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        ((MaterialToolbar) _$_findCachedViewById(C4761R.C4764id.download_child_toolbar)).setNavigationOnClickListener(new View.OnClickListener() { // from class: com.lagradost.cloudstream3.ui.download.-$$Lambda$DownloadChildFragment$H7oplXCQLxHiF-0G2QThI3Or1PQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DownloadChildFragment.m8624onViewCreated$lambda1(DownloadChildFragment.this, view2);
            }
        });
        DownloadChildAdapter downloadChildAdapter = new DownloadChildAdapter(new ArrayList(), new DownloadChildFragment$onViewCreated$adapter$1(this, string2));
        DownloadChildFragment$onViewCreated$2 downloadChildFragment$onViewCreated$2 = new DownloadChildFragment$onViewCreated$2(this, string);
        this.downloadDeleteEventListener = downloadChildFragment$onViewCreated$2;
        if (downloadChildFragment$onViewCreated$2 != null) {
            VideoDownloadManager.INSTANCE.getDownloadDeleteEvent().plusAssign(downloadChildFragment$onViewCreated$2);
        }
        ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.download_child_list)).setAdapter(downloadChildAdapter);
        ((RecyclerView) _$_findCachedViewById(C4761R.C4764id.download_child_list)).setLayoutManager(new GridLayoutManager(getContext(), 1));
        updateList(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m8624onViewCreated$lambda1(DownloadChildFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }
}

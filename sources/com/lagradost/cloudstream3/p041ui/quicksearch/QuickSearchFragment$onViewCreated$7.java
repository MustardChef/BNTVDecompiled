package com.lagradost.cloudstream3.p041ui.quicksearch;

import android.widget.ImageView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.p041ui.AutofitRecyclerView;
import com.lagradost.cloudstream3.p041ui.search.SearchAdaptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: QuickSearchFragment.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.quicksearch.QuickSearchFragment$onViewCreated$7 */
/* loaded from: classes3.dex */
final class QuickSearchFragment$onViewCreated$7 extends Lambda implements Function1<Resource<? extends List<? extends SearchResponse>>, Unit> {
    final /* synthetic */ ImageView $searchExitIcon;
    final /* synthetic */ QuickSearchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickSearchFragment$onViewCreated$7(ImageView imageView, QuickSearchFragment quickSearchFragment) {
        super(1);
        this.$searchExitIcon = imageView;
        this.this$0 = quickSearchFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends List<? extends SearchResponse>> resource) {
        invoke2(resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<? extends List<? extends SearchResponse>> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof Resource.Success) {
            Object value = ((Resource.Success) it).getValue();
            QuickSearchFragment quickSearchFragment = this.this$0;
            List<? extends SearchResponse> list = (List) value;
            System.out.println((Object) ("DATA: " + list));
            AutofitRecyclerView autofitRecyclerView = (AutofitRecyclerView) quickSearchFragment._$_findCachedViewById(C4761R.C4764id.quick_search_autofit_results);
            RecyclerView.Adapter adapter = autofitRecyclerView != null ? autofitRecyclerView.getAdapter() : null;
            SearchAdaptor searchAdaptor = adapter instanceof SearchAdaptor ? (SearchAdaptor) adapter : null;
            if (searchAdaptor != null) {
                searchAdaptor.updateList(list);
            }
            ImageView imageView = this.$searchExitIcon;
            if (imageView != null) {
                imageView.setAlpha(1.0f);
            }
            ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.quick_search_loading_bar);
            if (contentLoadingProgressBar == null) {
                return;
            }
            contentLoadingProgressBar.setAlpha(0.0f);
        } else if (it instanceof Resource.Failure) {
            ImageView imageView2 = this.$searchExitIcon;
            if (imageView2 != null) {
                imageView2.setAlpha(1.0f);
            }
            ContentLoadingProgressBar contentLoadingProgressBar2 = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.quick_search_loading_bar);
            if (contentLoadingProgressBar2 == null) {
                return;
            }
            contentLoadingProgressBar2.setAlpha(0.0f);
        } else if (it instanceof Resource.Loading) {
            ImageView imageView3 = this.$searchExitIcon;
            if (imageView3 != null) {
                imageView3.setAlpha(0.0f);
            }
            ContentLoadingProgressBar contentLoadingProgressBar3 = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.quick_search_loading_bar);
            if (contentLoadingProgressBar3 == null) {
                return;
            }
            contentLoadingProgressBar3.setAlpha(1.0f);
        }
    }
}

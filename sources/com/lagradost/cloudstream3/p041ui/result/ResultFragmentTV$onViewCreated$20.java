package com.lagradost.cloudstream3.p041ui.result;

import androidx.recyclerview.widget.RecyclerView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.Resource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, m107d2 = {"<anonymous>", "", "episodes", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "", "Lcom/lagradost/cloudstream3/ui/result/ResultEpisode;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$20 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$20 extends Lambda implements Function1<Resource<? extends List<? extends ResultEpisode>>, Unit> {
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$20(ResultFragmentTV resultFragmentTV) {
        super(1);
        this.this$0 = resultFragmentTV;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends List<? extends ResultEpisode>> resource) {
        invoke2((Resource<? extends List<ResultEpisode>>) resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<? extends List<ResultEpisode>> episodes) {
        Intrinsics.checkNotNullParameter(episodes, "episodes");
        if (episodes instanceof Resource.Failure) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episode_loading);
            if (shimmerFrameLayout == null) {
                return;
            }
            shimmerFrameLayout.setVisibility(8);
        } else if (episodes instanceof Resource.Loading) {
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episode_loading);
            if (shimmerFrameLayout2 == null) {
                return;
            }
            shimmerFrameLayout2.setVisibility(0);
        } else if (episodes instanceof Resource.Success) {
            ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episode_loading);
            if (shimmerFrameLayout3 != null) {
                shimmerFrameLayout3.setVisibility(8);
            }
            if (((RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episodes)) == null || ((RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episodes)).getAdapter() == null) {
                return;
            }
            Resource.Success success = (Resource.Success) episodes;
            this.this$0.currentEpisodes = (List) success.getValue();
            RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episodes);
            RecyclerView.Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            EpisodeAdapter episodeAdapter = adapter instanceof EpisodeAdapter ? (EpisodeAdapter) adapter : null;
            if (episodeAdapter != null) {
                episodeAdapter.setCardList((List) success.getValue());
            }
            RecyclerView recyclerView2 = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episodes);
            RecyclerView.Adapter adapter2 = recyclerView2 != null ? recyclerView2.getAdapter() : null;
            EpisodeAdapter episodeAdapter2 = adapter2 instanceof EpisodeAdapter ? (EpisodeAdapter) adapter2 : null;
            if (episodeAdapter2 != null) {
                episodeAdapter2.updateLayout();
            }
            RecyclerView recyclerView3 = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_episodes);
            RecyclerView.Adapter adapter3 = recyclerView3 != null ? recyclerView3.getAdapter() : null;
            EpisodeAdapter episodeAdapter3 = adapter3 instanceof EpisodeAdapter ? adapter3 : null;
            if (episodeAdapter3 != null) {
                episodeAdapter3.notifyDataSetChanged();
            }
        }
    }
}

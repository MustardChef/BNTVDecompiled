package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.widget.ContentLoadingProgressBar;
import com.bongngotv2.R;
import com.discord.panels.OverlappingPanelsLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.slider.Slider;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.ArchComponentExt;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "status", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$18 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$18 extends Lambda implements Function1<Resource<? extends SyncAPI.SyncStatus>, Unit> {
    final /* synthetic */ Ref.IntRef $currentSyncProgress;
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$18(ResultFragmentTV resultFragmentTV, Ref.IntRef intRef) {
        super(1);
        this.this$0 = resultFragmentTV;
        this.$currentSyncProgress = intRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SyncAPI.SyncStatus> resource) {
        invoke2((Resource<SyncAPI.SyncStatus>) resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<SyncAPI.SyncStatus> resource) {
        boolean z = true;
        if (resource instanceof Resource.Failure) {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_loading_shimmer);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.stopShimmer();
            }
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_loading_shimmer);
            if (shimmerFrameLayout2 != null) {
                shimmerFrameLayout2.setVisibility(8);
            }
            ScrollView scrollView = (ScrollView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_holder);
            if (scrollView != null) {
                scrollView.setVisibility(8);
            }
        } else {
            if (resource instanceof Resource.Loading) {
                ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_loading_shimmer);
                if (shimmerFrameLayout3 != null) {
                    shimmerFrameLayout3.startShimmer();
                }
                ShimmerFrameLayout shimmerFrameLayout4 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_loading_shimmer);
                if (shimmerFrameLayout4 != null) {
                    shimmerFrameLayout4.setVisibility(0);
                }
                ScrollView scrollView2 = (ScrollView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_holder);
                if (scrollView2 != null) {
                    scrollView2.setVisibility(8);
                }
            } else if (resource instanceof Resource.Success) {
                ShimmerFrameLayout shimmerFrameLayout5 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_loading_shimmer);
                if (shimmerFrameLayout5 != null) {
                    shimmerFrameLayout5.stopShimmer();
                }
                ShimmerFrameLayout shimmerFrameLayout6 = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_loading_shimmer);
                if (shimmerFrameLayout6 != null) {
                    shimmerFrameLayout6.setVisibility(8);
                }
                ScrollView scrollView3 = (ScrollView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_holder);
                if (scrollView3 != null) {
                    scrollView3.setVisibility(0);
                }
                SyncAPI.SyncStatus syncStatus = (SyncAPI.SyncStatus) ((Resource.Success) resource).getValue();
                Slider slider = (Slider) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_rating);
                if (slider != null) {
                    Integer score = syncStatus.getScore();
                    slider.setValue(score != null ? score.intValue() : 0.0f);
                }
                ListView listView = (ListView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_check);
                if (listView != null) {
                    listView.setItemChecked(syncStatus.getStatus() + 1, true);
                }
                Integer watchedEpisodes = syncStatus.getWatchedEpisodes();
                int intValue = watchedEpisodes != null ? watchedEpisodes.intValue() : 0;
                this.$currentSyncProgress.element = intValue;
                Integer maxEpisodes = syncStatus.getMaxEpisodes();
                if (maxEpisodes != null) {
                    ResultFragmentTV.onViewCreated$setSyncMaxEpisodes(this.this$0, Integer.valueOf(maxEpisodes.intValue()));
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_episodes);
                    if (contentLoadingProgressBar != null) {
                        contentLoadingProgressBar.setProgress(intValue * 1000, true);
                    }
                } else {
                    ContentLoadingProgressBar contentLoadingProgressBar2 = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_episodes);
                    if (contentLoadingProgressBar2 != null) {
                        contentLoadingProgressBar2.setProgress(intValue * 1000);
                    }
                }
                EditText editText = (EditText) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_current_episodes);
                if (editText != null) {
                    Editable.Factory factory = Editable.Factory.getInstance();
                    editText.setText(factory != null ? factory.newEditable(String.valueOf(intValue)) : null);
                }
                ArchComponentExt.normalSafeApiCall(new C49452(this.this$0, syncStatus));
            }
            z = false;
        }
        OverlappingPanelsLayout overlappingPanelsLayout = (OverlappingPanelsLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.result_overlapping_panels);
        if (overlappingPanelsLayout != null) {
            overlappingPanelsLayout.setStartPanelLockState(z ? OverlappingPanelsLayout.LockState.CLOSE : OverlappingPanelsLayout.LockState.UNLOCKED);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResultFragmentTV.kt */
    @Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, m107d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$18$2 */
    /* loaded from: classes4.dex */
    public static final class C49452 extends Lambda implements Functions<Unit> {

        /* renamed from: $d */
        final /* synthetic */ SyncAPI.SyncStatus f10020$d;
        final /* synthetic */ ResultFragmentTV this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C49452(ResultFragmentTV resultFragmentTV, SyncAPI.SyncStatus syncStatus) {
            super(0);
            this.this$0 = resultFragmentTV;
            this.f10020$d = syncStatus;
        }

        @Override // kotlin.jvm.functions.Functions
        public final Unit invoke() {
            String string;
            Context context = this.this$0.getContext();
            if (context != null && (string = context.getString(R.string.sync_score_format)) != null) {
                Object[] objArr = new Object[1];
                Integer score = this.f10020$d.getScore();
                objArr[0] = Integer.valueOf(score != null ? score.intValue() : 0);
                String format = String.format(string, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                if (format != null) {
                    MaterialButton materialButton = (MaterialButton) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_score_text);
                    if (materialButton != null) {
                        materialButton.setText(format);
                    }
                    return Unit.INSTANCE;
                }
            }
            return null;
        }
    }
}

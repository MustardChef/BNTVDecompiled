package com.lagradost.cloudstream3.p041ui.result;

import android.content.Context;
import android.widget.TextView;
import androidx.core.widget.ContentLoadingProgressBar;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.C4761R;
import com.lagradost.cloudstream3.mvvm.Resource;
import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: ResultFragmentTV.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "meta", "Lcom/lagradost/cloudstream3/mvvm/Resource;", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncResult;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.ResultFragmentTV$onViewCreated$17 */
/* loaded from: classes4.dex */
final class ResultFragmentTV$onViewCreated$17 extends Lambda implements Function1<Resource<? extends SyncAPI.SyncResult>, Unit> {
    final /* synthetic */ Ref.IntRef $currentSyncProgress;
    final /* synthetic */ ResultFragmentTV this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultFragmentTV$onViewCreated$17(ResultFragmentTV resultFragmentTV, Ref.IntRef intRef) {
        super(1);
        this.this$0 = resultFragmentTV;
        this.$currentSyncProgress = intRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends SyncAPI.SyncResult> resource) {
        invoke2((Resource<SyncAPI.SyncResult>) resource);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Resource<SyncAPI.SyncResult> meta) {
        TextView textView;
        Context context;
        ResultViewModel resultViewModel;
        Intrinsics.checkNotNullParameter(meta, "meta");
        String str = null;
        ResultViewModel resultViewModel2 = null;
        str = null;
        if (meta instanceof Resource.Success) {
            SyncAPI.SyncResult syncResult = (SyncAPI.SyncResult) ((Resource.Success) meta).getValue();
            ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_episodes);
            if (contentLoadingProgressBar != null) {
                contentLoadingProgressBar.setProgress(this.$currentSyncProgress.element * 1000);
            }
            ResultFragmentTV.onViewCreated$setSyncMaxEpisodes(this.this$0, syncResult.getTotalEpisodes());
            resultViewModel = this.this$0.viewModel;
            if (resultViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                resultViewModel2 = resultViewModel;
            }
            resultViewModel2.setMeta(syncResult);
        } else if (!(meta instanceof Resource.Loading) || (textView = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_max_episodes)) == null) {
        } else {
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.result_sync_max_episodes);
            if (textView2 != null && (context = textView2.getContext()) != null) {
                str = context.getString(R.string.sync_total_episodes_none);
            }
            textView.setText(str);
        }
    }
}

package com.lagradost.cloudstream3.p041ui.download;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bongngotv2.R;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.DataStoreKt;
import com.lagradost.cloudstream3.utils.UIHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DownloadFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "click", "Lcom/lagradost/cloudstream3/ui/download/DownloadHeaderClickEvent;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadFragment$onViewCreated$adapter$1 */
/* loaded from: classes3.dex */
final class DownloadFragment$onViewCreated$adapter$1 extends Lambda implements Function1<DownloadHeaderClickEvent, Unit> {
    final /* synthetic */ DownloadFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFragment$onViewCreated$adapter$1(DownloadFragment downloadFragment) {
        super(1);
        this.this$0 = downloadFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DownloadHeaderClickEvent downloadHeaderClickEvent) {
        invoke2(downloadHeaderClickEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DownloadHeaderClickEvent click) {
        AppCompatActivity appCompatActivity;
        Intrinsics.checkNotNullParameter(click, "click");
        int action = click.getAction();
        if (action != 0) {
            if (action == 1 && (appCompatActivity = (AppCompatActivity) this.this$0.getActivity()) != null) {
                AppUtils.INSTANCE.loadResult(appCompatActivity, click.getData().getUrl(), click.getData().getApiName(), (r13 & 4) != 0 ? 0 : 0, (r13 & 8) != 0 ? 0 : 0);
            }
        } else if (MainAPIKt.isMovieType(click.getData().getType())) {
        } else {
            String folderName = DataStore.INSTANCE.getFolderName(DataStoreKt.DOWNLOAD_EPISODE_CACHE, String.valueOf(click.getData().getId()));
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                UIHelper.INSTANCE.navigate(activity, R.id.action_navigation_downloads_to_navigation_download_child, DownloadChildFragment.Companion.newInstance(click.getData().getName(), folderName));
            }
        }
    }
}

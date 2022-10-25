package com.lagradost.cloudstream3.p041ui.download;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.C4761R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DownloadFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "id", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadFragment$onViewCreated$1 */
/* loaded from: classes3.dex */
final class DownloadFragment$onViewCreated$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ DownloadFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFragment$onViewCreated$1(DownloadFragment downloadFragment) {
        super(1);
        this.this$0 = downloadFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        boolean z;
        Context context;
        DownloadViewModel downloadViewModel;
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.download_list);
        DownloadViewModel downloadViewModel2 = null;
        DownloadHeaderAdapter downloadHeaderAdapter = (DownloadHeaderAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
        List<VisualDownloadHeaderCached> cardList = downloadHeaderAdapter != null ? downloadHeaderAdapter.getCardList() : null;
        if (cardList != null) {
            List<VisualDownloadHeaderCached> list = cardList;
            boolean z2 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (VisualDownloadHeaderCached visualDownloadHeaderCached : list) {
                    if (visualDownloadHeaderCached.getData().getId() == i) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            z2 = false;
            if (!z2 || (context = this.this$0.getContext()) == null) {
                return;
            }
            DownloadFragment downloadFragment = this.this$0;
            downloadFragment.setList(new ArrayList());
            downloadViewModel = downloadFragment.downloadsViewModel;
            if (downloadViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("downloadsViewModel");
            } else {
                downloadViewModel2 = downloadViewModel;
            }
            downloadViewModel2.updateList(context);
        }
    }
}

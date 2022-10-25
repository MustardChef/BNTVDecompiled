package com.lagradost.cloudstream3.p041ui.download;

import androidx.recyclerview.widget.RecyclerView;
import com.lagradost.cloudstream3.C4761R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: DownloadChildFragment.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "id", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadChildFragment$onViewCreated$2 */
/* loaded from: classes3.dex */
final class DownloadChildFragment$onViewCreated$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ String $folder;
    final /* synthetic */ DownloadChildFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadChildFragment$onViewCreated$2(DownloadChildFragment downloadChildFragment, String str) {
        super(1);
        this.this$0 = downloadChildFragment;
        this.$folder = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        boolean z;
        RecyclerView recyclerView = (RecyclerView) this.this$0._$_findCachedViewById(C4761R.C4764id.download_child_list);
        DownloadChildAdapter downloadChildAdapter = (DownloadChildAdapter) (recyclerView != null ? recyclerView.getAdapter() : null);
        List<VisualDownloadChildCached> cardList = downloadChildAdapter != null ? downloadChildAdapter.getCardList() : null;
        if (cardList != null) {
            List<VisualDownloadChildCached> list = cardList;
            boolean z2 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (VisualDownloadChildCached visualDownloadChildCached : list) {
                    if (visualDownloadChildCached.getData().getId() == i) {
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
            if (z2) {
                this.this$0.updateList(this.$folder);
            }
        }
    }
}

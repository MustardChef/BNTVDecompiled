package com.lagradost.cloudstream3.p041ui.download;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.lagradost.cloudstream3.C4761R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: DownloadFragment.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "it", "", "Lcom/lagradost/cloudstream3/ui/download/VisualDownloadHeaderCached;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.download.DownloadFragment$onCreateView$2 */
/* loaded from: classes3.dex */
final class DownloadFragment$onCreateView$2 extends Lambda implements Function1<List<? extends VisualDownloadHeaderCached>, Unit> {
    final /* synthetic */ DownloadFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadFragment$onCreateView$2(DownloadFragment downloadFragment) {
        super(1);
        this.this$0 = downloadFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends VisualDownloadHeaderCached> list) {
        invoke2((List<VisualDownloadHeaderCached>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<VisualDownloadHeaderCached> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.setList(it);
        ShimmerFrameLayout download_loading = (ShimmerFrameLayout) this.this$0._$_findCachedViewById(C4761R.C4764id.download_loading);
        Intrinsics.checkNotNullExpressionValue(download_loading, "download_loading");
        download_loading.setVisibility(8);
    }
}

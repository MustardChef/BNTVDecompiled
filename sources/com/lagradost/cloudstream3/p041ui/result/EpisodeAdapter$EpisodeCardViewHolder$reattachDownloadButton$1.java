package com.lagradost.cloudstream3.p041ui.result;

import com.lagradost.cloudstream3.p041ui.download.DownloadClickEvent;
import com.lagradost.cloudstream3.p041ui.result.EpisodeAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: EpisodeAdapter.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/ui/download/DownloadClickEvent;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.EpisodeAdapter$EpisodeCardViewHolder$reattachDownloadButton$1 */
/* loaded from: classes4.dex */
final class EpisodeAdapter$EpisodeCardViewHolder$reattachDownloadButton$1 extends Lambda implements Function1<DownloadClickEvent, Unit> {
    final /* synthetic */ ResultEpisode $card;
    final /* synthetic */ EpisodeAdapter.EpisodeCardViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EpisodeAdapter$EpisodeCardViewHolder$reattachDownloadButton$1(EpisodeAdapter.EpisodeCardViewHolder episodeCardViewHolder, ResultEpisode resultEpisode) {
        super(1);
        this.this$0 = episodeCardViewHolder;
        this.$card = resultEpisode;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DownloadClickEvent downloadClickEvent) {
        invoke2(downloadClickEvent);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DownloadClickEvent it) {
        Function1 function1;
        Function1 function12;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getAction() == 4) {
            function12 = this.this$0.clickCallback;
            function12.invoke(new EpisodeClickEvent(6, this.$card));
            return;
        }
        function1 = this.this$0.downloadClickCallback;
        function1.invoke(it);
    }
}

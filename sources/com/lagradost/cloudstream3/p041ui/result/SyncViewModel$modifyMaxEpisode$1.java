package com.lagradost.cloudstream3.p041ui.result;

import com.lagradost.cloudstream3.syncproviders.SyncAPI;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: SyncViewModel.kt */
@Metadata(m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Lcom/lagradost/cloudstream3/syncproviders/SyncAPI$SyncStatus;", "status", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.result.SyncViewModel$modifyMaxEpisode$1 */
/* loaded from: classes4.dex */
final class SyncViewModel$modifyMaxEpisode$1 extends Lambda implements Function1<SyncAPI.SyncStatus, SyncAPI.SyncStatus> {
    final /* synthetic */ int $episodeNum;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SyncViewModel$modifyMaxEpisode$1(int i) {
        super(1);
        this.$episodeNum = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final SyncAPI.SyncStatus invoke(SyncAPI.SyncStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        int i = this.$episodeNum;
        Integer watchedEpisodes = status.getWatchedEpisodes();
        if (watchedEpisodes != null) {
            return SyncAPI.SyncStatus.copy$default(status, 0, null, Integer.valueOf(Math.max(i, watchedEpisodes.intValue())), null, null, 27, null);
        }
        return null;
    }
}

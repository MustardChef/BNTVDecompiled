package com.lagradost.cloudstream3.p041ui.player;

import android.util.Log;
import com.lagradost.cloudstream3.SubtitleFile;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RepoLinkGenerator.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "it", "", "Lcom/lagradost/cloudstream3/SubtitleFile;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.RepoLinkGenerator$generateLinks$4$1$1 */
/* loaded from: classes3.dex */
final class RepoLinkGenerator$generateLinks$4$1$1 extends Lambda implements Function1<List<? extends SubtitleFile>, Unit> {
    final /* synthetic */ Set<SubtitleData> $currentSubsCache;
    final /* synthetic */ Function1<SubtitleData, Unit> $subtitleCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepoLinkGenerator$generateLinks$4$1$1(Set<SubtitleData> set, Function1<? super SubtitleData, Unit> function1) {
        super(1);
        this.$currentSubsCache = set;
        this.$subtitleCallback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SubtitleFile> list) {
        invoke2((List<SubtitleFile>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<SubtitleFile> it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Set<SubtitleData> set = this.$currentSubsCache;
        Function1<SubtitleData, Unit> function1 = this.$subtitleCallback;
        for (SubtitleFile subtitleFile : it) {
            SubtitleData subtitleData = PlayerSubtitleHelper.Companion.getSubtitleData(subtitleFile);
            if (!set.contains(subtitleData)) {
                function1.invoke(subtitleData);
                set.add(subtitleData);
                Log.d("BLUE", "add to callback  --> " + subtitleData);
            }
        }
    }
}

package com.lagradost.cloudstream3.p041ui.player;

import com.lagradost.cloudstream3.SubtitleFile;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: RepoLinkGenerator.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "file", "Lcom/lagradost/cloudstream3/SubtitleFile;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.RepoLinkGenerator$generateLinks$result$1 */
/* loaded from: classes3.dex */
final class RepoLinkGenerator$generateLinks$result$1 extends Lambda implements Function1<SubtitleFile, Unit> {
    final /* synthetic */ Set<SubtitleData> $currentSubsCache;
    final /* synthetic */ Set<String> $currentSubsNames;
    final /* synthetic */ Set<String> $currentSubsUrls;
    final /* synthetic */ Function1<SubtitleData, Unit> $subtitleCallback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepoLinkGenerator$generateLinks$result$1(Set<String> set, Set<String> set2, Set<SubtitleData> set3, Function1<? super SubtitleData, Unit> function1) {
        super(1);
        this.$currentSubsUrls = set;
        this.$currentSubsNames = set2;
        this.$currentSubsCache = set3;
        this.$subtitleCallback = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SubtitleFile subtitleFile) {
        invoke2(subtitleFile);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SubtitleFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        SubtitleData subtitleData = PlayerSubtitleHelper.Companion.getSubtitleData(file);
        if (this.$currentSubsUrls.contains(subtitleData.getUrl())) {
            return;
        }
        this.$currentSubsUrls.add(subtitleData.getUrl());
        int i = 0;
        String name = subtitleData.getName();
        while (this.$currentSubsNames.contains(name)) {
            i++;
            name = subtitleData.getName() + ' ' + i;
        }
        this.$currentSubsNames.add(name);
        SubtitleData copy$default = SubtitleData.copy$default(subtitleData, name, null, null, null, null, 30, null);
        if (this.$currentSubsCache.contains(copy$default)) {
            return;
        }
        this.$subtitleCallback.invoke(copy$default);
        this.$currentSubsCache.add(copy$default);
    }
}

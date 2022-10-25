package com.lagradost.cloudstream3.p041ui.player;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, m107d2 = {"<anonymous>", "", "set", "", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$onViewCreated$8 */
/* loaded from: classes3.dex */
final class GeneratorPlayer$onViewCreated$8 extends Lambda implements Function1<Set<? extends SubtitleData>, Unit> {
    final /* synthetic */ GeneratorPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$onViewCreated$8(GeneratorPlayer generatorPlayer) {
        super(1);
        this.this$0 = generatorPlayer;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends SubtitleData> set) {
        invoke2((Set<SubtitleData>) set);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Set<SubtitleData> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        this.this$0.currentSubs = set;
        this.this$0.getPlayer().setActiveSubtitles(set);
        this.this$0.autoSelectSubtitles();
    }
}

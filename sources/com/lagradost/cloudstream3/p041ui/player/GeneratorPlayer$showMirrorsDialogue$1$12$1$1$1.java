package com.lagradost.cloudstream3.p041ui.player;

import com.lagradost.cloudstream3.utils.Coroutines;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneratorPlayer.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Lcom/lagradost/cloudstream3/ui/player/SubtitleData;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$showMirrorsDialogue$1$12$1$1$1 */
/* loaded from: classes3.dex */
public final class GeneratorPlayer$showMirrorsDialogue$1$12$1$1$1 extends Lambda implements Function1<SubtitleData, Unit> {
    final /* synthetic */ GeneratorPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeneratorPlayer$showMirrorsDialogue$1$12$1$1$1(GeneratorPlayer generatorPlayer) {
        super(1);
        this.this$0 = generatorPlayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeneratorPlayer.kt */
    @Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.GeneratorPlayer$showMirrorsDialogue$1$12$1$1$1$1 */
    /* loaded from: classes3.dex */
    public static final class C48721 extends Lambda implements Functions<Unit> {
        final /* synthetic */ SubtitleData $it;
        final /* synthetic */ GeneratorPlayer this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C48721(GeneratorPlayer generatorPlayer, SubtitleData subtitleData) {
            super(0);
            this.this$0 = generatorPlayer;
            this.$it = subtitleData;
        }

        @Override // kotlin.jvm.functions.Functions
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Functions
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.addAndSelectSubtitles(this.$it);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SubtitleData subtitleData) {
        invoke2(subtitleData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(SubtitleData it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Coroutines.INSTANCE.runOnMainThread(new C48721(this.this$0, it));
    }
}

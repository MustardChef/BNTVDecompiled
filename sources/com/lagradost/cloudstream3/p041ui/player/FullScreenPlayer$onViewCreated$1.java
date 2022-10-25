package com.lagradost.cloudstream3.p041ui.player;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullScreenPlayer.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "eventType", "Lcom/lagradost/cloudstream3/ui/player/PlayerEventType;", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$onViewCreated$1 */
/* loaded from: classes3.dex */
public final class FullScreenPlayer$onViewCreated$1 extends Lambda implements Function1<PlayerEventType, Unit> {
    final /* synthetic */ View $view;
    final /* synthetic */ FullScreenPlayer this$0;

    /* compiled from: FullScreenPlayer.kt */
    @Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$onViewCreated$1$WhenMappings */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlayerEventType.values().length];
            iArr[PlayerEventType.Lock.ordinal()] = 1;
            iArr[PlayerEventType.NextEpisode.ordinal()] = 2;
            iArr[PlayerEventType.Pause.ordinal()] = 3;
            iArr[PlayerEventType.PlayPauseToggle.ordinal()] = 4;
            iArr[PlayerEventType.Play.ordinal()] = 5;
            iArr[PlayerEventType.Resize.ordinal()] = 6;
            iArr[PlayerEventType.PrevEpisode.ordinal()] = 7;
            iArr[PlayerEventType.SeekForward.ordinal()] = 8;
            iArr[PlayerEventType.ShowSpeed.ordinal()] = 9;
            iArr[PlayerEventType.SeekBack.ordinal()] = 10;
            iArr[PlayerEventType.ToggleMute.ordinal()] = 11;
            iArr[PlayerEventType.ToggleHide.ordinal()] = 12;
            iArr[PlayerEventType.ShowMirrors.ordinal()] = 13;
            iArr[PlayerEventType.SearchSubtitlesOnline.ordinal()] = 14;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenPlayer$onViewCreated$1(FullScreenPlayer fullScreenPlayer, View view) {
        super(1);
        this.this$0 = fullScreenPlayer;
        this.$view = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlayerEventType playerEventType) {
        invoke2(playerEventType);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(PlayerEventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        switch (WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()]) {
            case 1:
                this.this$0.toggleLock();
                return;
            case 2:
                this.this$0.getPlayer().handleEvent(CSPlayerEvent.NextEpisode);
                return;
            case 3:
                this.this$0.getPlayer().handleEvent(CSPlayerEvent.Pause);
                return;
            case 4:
                this.this$0.getPlayer().handleEvent(CSPlayerEvent.PlayPauseToggle);
                return;
            case 5:
                this.this$0.getPlayer().handleEvent(CSPlayerEvent.Play);
                return;
            case 6:
                this.this$0.nextResize();
                return;
            case 7:
                this.this$0.getPlayer().handleEvent(CSPlayerEvent.PrevEpisode);
                return;
            case 8:
                this.this$0.getPlayer().handleEvent(CSPlayerEvent.SeekForward);
                return;
            case 9:
                this.this$0.showSpeedDialog();
                return;
            case 10:
                this.this$0.getPlayer().handleEvent(CSPlayerEvent.SeekBack);
                return;
            case 11:
                this.this$0.getPlayer().handleEvent(CSPlayerEvent.ToggleMute);
                return;
            case 12:
                this.this$0.onClickChange();
                return;
            case 13:
                this.this$0.showMirrorsDialogue();
                return;
            case 14:
                if (GeneratorPlayer.Companion.getSubsProvidersIsActive()) {
                    FullScreenPlayer fullScreenPlayer = this.this$0;
                    Context context = this.$view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "view.context");
                    fullScreenPlayer.openOnlineSubPicker(context, null, C48681.INSTANCE);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FullScreenPlayer.kt */
    @Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
    /* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$onViewCreated$1$1 */
    /* loaded from: classes3.dex */
    public static final class C48681 extends Lambda implements Functions<Unit> {
        public static final C48681 INSTANCE = new C48681();

        C48681() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Functions
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Functions
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }
}

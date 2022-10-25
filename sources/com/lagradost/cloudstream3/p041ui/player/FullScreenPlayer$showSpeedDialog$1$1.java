package com.lagradost.cloudstream3.p041ui.player;

import androidx.fragment.app.FragmentActivity;
import com.lagradost.cloudstream3.utils.UIHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: FullScreenPlayer.kt */
@Metadata(m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$showSpeedDialog$1$1 */
/* loaded from: classes3.dex */
final class FullScreenPlayer$showSpeedDialog$1$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ FullScreenPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenPlayer$showSpeedDialog$1$1(FullScreenPlayer fullScreenPlayer) {
        super(0);
        this.this$0 = fullScreenPlayer;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity activity;
        if (!this.this$0.isFullScreenPlayer() || (activity = this.this$0.getActivity()) == null) {
            return;
        }
        UIHelper.INSTANCE.hideSystemUI(activity);
    }
}

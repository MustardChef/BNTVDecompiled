package com.lagradost.cloudstream3.p041ui.player;

import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lagradost.cloudstream3.utils.UIHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullScreenPlayer.kt */
@Metadata(m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", FirebaseAnalytics.Param.INDEX, "", "invoke"}, m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$showSpeedDialog$1$2 */
/* loaded from: classes3.dex */
public final class FullScreenPlayer$showSpeedDialog$1$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List<Float> $speedsNumbers;
    final /* synthetic */ FullScreenPlayer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullScreenPlayer$showSpeedDialog$1$2(FullScreenPlayer fullScreenPlayer, List<Float> list) {
        super(1);
        this.this$0 = fullScreenPlayer;
        this.$speedsNumbers = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        FragmentActivity activity;
        if (this.this$0.isFullScreenPlayer() && (activity = this.this$0.getActivity()) != null) {
            UIHelper.INSTANCE.hideSystemUI(activity);
        }
        this.this$0.setPlayBackSpeed(this.$speedsNumbers.get(i).floatValue());
    }
}

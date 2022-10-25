package com.lagradost.cloudstream3.p041ui.player;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.lagradost.cloudstream3.C4761R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullScreenPlayer.kt */
@Metadata(m108d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, m107d2 = {"com/lagradost/cloudstream3/ui/player/FullScreenPlayer$rewind$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "app_release"}, m106k = 1, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.FullScreenPlayer$rewind$1 */
/* loaded from: classes3.dex */
public final class FullScreenPlayer$rewind$1 implements Animation.AnimationListener {
    final /* synthetic */ FullScreenPlayer this$0;

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullScreenPlayer$rewind$1(FullScreenPlayer fullScreenPlayer) {
        this.this$0 = fullScreenPlayer;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C4761R.C4764id.exo_rew_text);
        if (textView != null) {
            final FullScreenPlayer fullScreenPlayer = this.this$0;
            textView.post(new Runnable() { // from class: com.lagradost.cloudstream3.ui.player.-$$Lambda$FullScreenPlayer$rewind$1$3tt5vwjriHDih0E1dtlqHwzgiGI
                @Override // java.lang.Runnable
                public final void run() {
                    FullScreenPlayer$rewind$1.m8707onAnimationEnd$lambda0(FullScreenPlayer.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onAnimationEnd$lambda-0  reason: not valid java name */
    public static final void m8707onAnimationEnd$lambda0(FullScreenPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.resetRewindText();
        ConstraintLayout constraintLayout = (ConstraintLayout) this$0._$_findCachedViewById(C4761R.C4764id.player_center_menu);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(this$0.isShowing() ^ true ? 8 : 0);
        }
        FrameLayout frameLayout = (FrameLayout) this$0._$_findCachedViewById(C4761R.C4764id.player_rew_holder);
        if (frameLayout == null) {
            return;
        }
        frameLayout.setAlpha(this$0.isShowing() ? 1.0f : 0.0f);
    }
}

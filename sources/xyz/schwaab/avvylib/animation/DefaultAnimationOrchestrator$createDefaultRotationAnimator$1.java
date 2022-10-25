package xyz.schwaab.avvylib.animation;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import xyz.schwaab.avvylib.AvatarView;

/* compiled from: DefaultAnimationOrchestrator.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tR\u00020\nH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, m107d2 = {"xyz/schwaab/avvylib/animation/DefaultAnimationOrchestrator$createDefaultRotationAnimator$1", "Lxyz/schwaab/avvylib/animation/AvatarViewAnimator;", "baseAnimator", "Landroid/animation/ValueAnimator;", "getBaseAnimator", "()Landroid/animation/ValueAnimator;", "onValueUpdate", "", "animatorInterface", "Lxyz/schwaab/avvylib/AvatarView$AnimatorInterface;", "Lxyz/schwaab/avvylib/AvatarView;", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class DefaultAnimationOrchestrator$createDefaultRotationAnimator$1 implements AvatarViewAnimator {
    final /* synthetic */ long $rotationDurationInMillis;
    private final ValueAnimator baseAnimator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultAnimationOrchestrator$createDefaultRotationAnimator$1(long j) {
        this.$rotationDurationInMillis = j;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new LinearInterpolator());
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNull(ofFloat);
        this.baseAnimator = ofFloat;
    }

    @Override // xyz.schwaab.avvylib.animation.AvatarViewAnimator
    public ValueAnimator getBaseAnimator() {
        return this.baseAnimator;
    }

    @Override // xyz.schwaab.avvylib.animation.AvatarViewAnimator
    public void onValueUpdate(AvatarView.AnimatorInterface animatorInterface) {
        Intrinsics.checkNotNullParameter(animatorInterface, "animatorInterface");
        animatorInterface.updateAnimationState(new C5572x8c33dba4(this));
    }
}

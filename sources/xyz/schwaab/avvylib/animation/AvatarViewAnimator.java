package xyz.schwaab.avvylib.animation;

import android.animation.ValueAnimator;
import kotlin.Metadata;
import xyz.schwaab.avvylib.AvatarView;

/* compiled from: AvatarViewAnimator.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tR\u00020\nH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, m107d2 = {"Lxyz/schwaab/avvylib/animation/AvatarViewAnimator;", "", "baseAnimator", "Landroid/animation/ValueAnimator;", "getBaseAnimator", "()Landroid/animation/ValueAnimator;", "onValueUpdate", "", "animatorInterface", "Lxyz/schwaab/avvylib/AvatarView$AnimatorInterface;", "Lxyz/schwaab/avvylib/AvatarView;", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
/* loaded from: classes5.dex */
public interface AvatarViewAnimator {
    ValueAnimator getBaseAnimator();

    void onValueUpdate(AvatarView.AnimatorInterface animatorInterface);
}

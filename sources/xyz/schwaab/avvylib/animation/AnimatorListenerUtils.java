package xyz.schwaab.avvylib.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00010\u0004H\u0000¨\u0006\u0005"}, m107d2 = {"addOnAnimationEndListener", "", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "avvylib_release"}, m106k = 2, m105mv = {1, 4, 0})
/* renamed from: xyz.schwaab.avvylib.animation.AnimatorListenerUtilsKt */
/* loaded from: classes5.dex */
public final class AnimatorListenerUtils {
    public static final void addOnAnimationEndListener(Animator addOnAnimationEndListener, final Function1<? super Animator, Unit> onEnd) {
        Intrinsics.checkNotNullParameter(addOnAnimationEndListener, "$this$addOnAnimationEndListener");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        addOnAnimationEndListener.addListener(new Animator.AnimatorListener() { // from class: xyz.schwaab.avvylib.animation.AnimatorListenerUtilsKt$addOnAnimationEndListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Function1.this.invoke(animator);
            }
        });
    }
}

package xyz.schwaab.avvylib.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xyz.schwaab.avvylib.AvatarView;

/* compiled from: AvatarViewAnimationOrchestrator.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B%\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ)\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015R\u00020\u00162\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018H\u0000¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006 "}, m107d2 = {"Lxyz/schwaab/avvylib/animation/AvatarViewAnimationOrchestrator;", "", "setupAnimator", "Lxyz/schwaab/avvylib/animation/AvatarViewAnimator;", "progressAnimator", "(Lxyz/schwaab/avvylib/animation/AvatarViewAnimator;Lxyz/schwaab/avvylib/animation/AvatarViewAnimator;)V", "setupAnimators", "", "progressAnimators", "(Ljava/util/List;Ljava/util/List;)V", "animatorSet", "Landroid/animation/AnimatorSet;", "getAnimatorSet", "()Landroid/animation/AnimatorSet;", "progressSet", "getProgressSet", "setupSet", "getSetupSet", "attach", "", "animatorInterface", "Lxyz/schwaab/avvylib/AvatarView$AnimatorInterface;", "Lxyz/schwaab/avvylib/AvatarView;", "onSetupEnd", "Lkotlin/Function0;", "attach$avvylib_release", "cancel", "cancel$avvylib_release", "reverse", "reverse$avvylib_release", TtmlNode.START, "start$avvylib_release", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class AvatarViewAnimationOrchestrator {
    private final AnimatorSet animatorSet;
    private final List<AvatarViewAnimator> progressAnimators;
    private final AnimatorSet progressSet;
    private final List<AvatarViewAnimator> setupAnimators;
    private final AnimatorSet setupSet;

    public AvatarViewAnimationOrchestrator() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarViewAnimationOrchestrator(List<? extends AvatarViewAnimator> setupAnimators, List<? extends AvatarViewAnimator> progressAnimators) {
        Intrinsics.checkNotNullParameter(setupAnimators, "setupAnimators");
        Intrinsics.checkNotNullParameter(progressAnimators, "progressAnimators");
        this.setupAnimators = setupAnimators;
        this.progressAnimators = progressAnimators;
        AnimatorSet animatorSet = new AnimatorSet();
        List<? extends AvatarViewAnimator> list = setupAnimators;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (AvatarViewAnimator avatarViewAnimator : list) {
            arrayList.add(avatarViewAnimator.getBaseAnimator());
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            Object[] array = arrayList2.toArray(new ValueAnimator[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Animator[] animatorArr = (Animator[]) array;
            animatorSet.playTogether((Animator[]) Arrays.copyOf(animatorArr, animatorArr.length));
        }
        Unit unit = Unit.INSTANCE;
        this.setupSet = animatorSet;
        AnimatorSet animatorSet2 = new AnimatorSet();
        List<AvatarViewAnimator> list2 = this.progressAnimators;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (AvatarViewAnimator avatarViewAnimator2 : list2) {
            arrayList3.add(avatarViewAnimator2.getBaseAnimator());
        }
        ArrayList arrayList4 = arrayList3;
        if (!arrayList4.isEmpty()) {
            Object[] array2 = arrayList4.toArray(new ValueAnimator[0]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            Animator[] animatorArr2 = (Animator[]) array2;
            animatorSet2.playTogether((Animator[]) Arrays.copyOf(animatorArr2, animatorArr2.length));
        }
        Unit unit2 = Unit.INSTANCE;
        this.progressSet = animatorSet2;
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(this.setupSet, animatorSet2);
        Unit unit3 = Unit.INSTANCE;
        this.animatorSet = animatorSet3;
    }

    public /* synthetic */ AvatarViewAnimationOrchestrator(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AvatarViewAnimationOrchestrator(AvatarViewAnimator setupAnimator, AvatarViewAnimator progressAnimator) {
        this(CollectionsKt.listOf(setupAnimator), CollectionsKt.listOf(progressAnimator));
        Intrinsics.checkNotNullParameter(setupAnimator, "setupAnimator");
        Intrinsics.checkNotNullParameter(progressAnimator, "progressAnimator");
    }

    public final AnimatorSet getSetupSet() {
        return this.setupSet;
    }

    public final AnimatorSet getProgressSet() {
        return this.progressSet;
    }

    public final AnimatorSet getAnimatorSet() {
        return this.animatorSet;
    }

    public final void cancel$avvylib_release() {
        new Thread();
    }

    public final void start$avvylib_release() {
        this.animatorSet.start();
    }

    public final void reverse$avvylib_release() {
        for (AvatarViewAnimator avatarViewAnimator : this.setupAnimators) {
            avatarViewAnimator.getBaseAnimator().reverse();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void attach$avvylib_release$default(AvatarViewAnimationOrchestrator avatarViewAnimationOrchestrator, AvatarView.AnimatorInterface animatorInterface, Functions functions, int i, Object obj) {
        if ((i & 2) != 0) {
            functions = AvatarViewAnimationOrchestrator$attach$1.INSTANCE;
        }
        avatarViewAnimationOrchestrator.attach$avvylib_release(animatorInterface, functions);
    }

    public final void attach$avvylib_release(final AvatarView.AnimatorInterface animatorInterface, Functions<Unit> onSetupEnd) {
        Intrinsics.checkNotNullParameter(animatorInterface, "animatorInterface");
        Intrinsics.checkNotNullParameter(onSetupEnd, "onSetupEnd");
        for (final AvatarViewAnimator avatarViewAnimator : CollectionsKt.plus((Collection) this.setupAnimators, (Iterable) this.progressAnimators)) {
            avatarViewAnimator.getBaseAnimator().addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: xyz.schwaab.avvylib.animation.AvatarViewAnimationOrchestrator$attach$$inlined$forEach$lambda$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AvatarViewAnimator.this.onValueUpdate(animatorInterface);
                }
            });
        }
        AnimatorListenerUtils.addOnAnimationEndListener(this.setupSet, new AvatarViewAnimationOrchestrator$attach$3(onSetupEnd));
    }
}

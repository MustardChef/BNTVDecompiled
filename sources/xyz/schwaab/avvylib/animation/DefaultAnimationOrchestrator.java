package xyz.schwaab.avvylib.animation;

import kotlin.Metadata;

/* compiled from: DefaultAnimationOrchestrator.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m107d2 = {"Lxyz/schwaab/avvylib/animation/DefaultAnimationOrchestrator;", "", "()V", "DEFAULT_EXPANSION_DURATION", "", "DEFAULT_ROTATION_DURATION", "create", "Lxyz/schwaab/avvylib/animation/AvatarViewAnimationOrchestrator;", "rotationDurationInMillis", "expandDurationInMillis", "createDefaultExpansionAnimator", "Lxyz/schwaab/avvylib/animation/AvatarViewAnimator;", "createDefaultRotationAnimator", "avvylib_release"}, m106k = 1, m105mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class DefaultAnimationOrchestrator {
    private static final long DEFAULT_EXPANSION_DURATION = 250;
    private static final long DEFAULT_ROTATION_DURATION = 2000;
    public static final DefaultAnimationOrchestrator INSTANCE = new DefaultAnimationOrchestrator();

    private DefaultAnimationOrchestrator() {
    }

    public static /* synthetic */ AvatarViewAnimationOrchestrator create$default(DefaultAnimationOrchestrator defaultAnimationOrchestrator, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 2000;
        }
        if ((i & 2) != 0) {
            j2 = DEFAULT_EXPANSION_DURATION;
        }
        return defaultAnimationOrchestrator.create(j, j2);
    }

    public final AvatarViewAnimationOrchestrator create(long j, long j2) {
        return new AvatarViewAnimationOrchestrator(createDefaultExpansionAnimator(j2), createDefaultRotationAnimator(j));
    }

    public final AvatarViewAnimator createDefaultExpansionAnimator(long j) {
        return new DefaultAnimationOrchestrator$createDefaultExpansionAnimator$1(j);
    }

    public final AvatarViewAnimator createDefaultRotationAnimator(long j) {
        return new DefaultAnimationOrchestrator$createDefaultRotationAnimator$1(j);
    }
}

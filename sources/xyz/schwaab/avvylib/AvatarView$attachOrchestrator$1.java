package xyz.schwaab.avvylib;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;
import xyz.schwaab.avvylib.AvatarView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AvatarView.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m107d2 = {"<anonymous>", "", "invoke"}, m106k = 3, m105mv = {1, 4, 0})
/* loaded from: classes5.dex */
public final class AvatarView$attachOrchestrator$1 extends Lambda implements Functions<Unit> {
    final /* synthetic */ AvatarView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarView$attachOrchestrator$1(AvatarView avatarView) {
        super(0);
        this.this$0 = avatarView;
    }

    @Override // kotlin.jvm.functions.Functions
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Functions
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z;
        z = this.this$0.isReversedAnimating;
        if (z) {
            AvatarView avatarView = this.this$0;
            avatarView.animationDrawingState = AvatarView.AnimationDrawingState.copy$default(avatarView.animationDrawingState, 0.0f, 0.0f, 1, null);
            this.this$0.isReversedAnimating = false;
        }
    }
}

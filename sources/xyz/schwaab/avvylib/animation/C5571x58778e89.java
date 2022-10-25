package xyz.schwaab.avvylib.animation;

import com.facebook.internal.ServerProtocol;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import xyz.schwaab.avvylib.AvatarView;

/* compiled from: DefaultAnimationOrchestrator.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, m107d2 = {"<anonymous>", "Lxyz/schwaab/avvylib/AvatarView$AnimationDrawingState;", ServerProtocol.DIALOG_PARAM_STATE, "invoke"}, m106k = 3, m105mv = {1, 4, 0})
/* renamed from: xyz.schwaab.avvylib.animation.DefaultAnimationOrchestrator$createDefaultExpansionAnimator$1$onValueUpdate$1 */
/* loaded from: classes5.dex */
final class C5571x58778e89 extends Lambda implements Function1<AvatarView.AnimationDrawingState, AvatarView.AnimationDrawingState> {
    final /* synthetic */ DefaultAnimationOrchestrator$createDefaultExpansionAnimator$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5571x58778e89(DefaultAnimationOrchestrator$createDefaultExpansionAnimator$1 defaultAnimationOrchestrator$createDefaultExpansionAnimator$1) {
        super(1);
        this.this$0 = defaultAnimationOrchestrator$createDefaultExpansionAnimator$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final AvatarView.AnimationDrawingState invoke(AvatarView.AnimationDrawingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Object animatedValue = this.this$0.getBaseAnimator().getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        return AvatarView.AnimationDrawingState.copy$default(state, ((Float) animatedValue).floatValue(), 0.0f, 2, null);
    }
}

package xyz.schwaab.avvylib.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Lambda;

/* compiled from: AvatarViewAnimationOrchestrator.kt */
@Metadata(m109bv = {1, 0, 3}, m108d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, m107d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, m106k = 3, m105mv = {1, 4, 0})
/* loaded from: classes5.dex */
final class AvatarViewAnimationOrchestrator$attach$3 extends Lambda implements Function1<Animator, Unit> {
    final /* synthetic */ Functions $onSetupEnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarViewAnimationOrchestrator$attach$3(Functions functions) {
        super(1);
        this.$onSetupEnd = functions;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
        invoke2(animator);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Animator animator) {
        this.$onSetupEnd.invoke();
    }
}

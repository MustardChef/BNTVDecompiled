package com.lagradost.cloudstream3.p041ui.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractPlayerFragment.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.AbstractPlayerFragment$onViewCreated$1 */
/* loaded from: classes3.dex */
public /* synthetic */ class AbstractPlayerFragment$onViewCreated$1 extends FunctionReferenceImpl implements Function1<Object, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPlayerFragment$onViewCreated$1(Object obj) {
        super(1, obj, AbstractPlayerFragment.class, "playerUpdated", "playerUpdated(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        ((AbstractPlayerFragment) this.receiver).playerUpdated(obj);
    }
}

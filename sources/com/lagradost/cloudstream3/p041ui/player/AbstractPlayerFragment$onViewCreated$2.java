package com.lagradost.cloudstream3.p041ui.player;

import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractPlayerFragment.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.AbstractPlayerFragment$onViewCreated$2 */
/* loaded from: classes3.dex */
public /* synthetic */ class AbstractPlayerFragment$onViewCreated$2 extends FunctionReferenceImpl implements Function1<Tuples<? extends CSPlayerLoading, ? extends CSPlayerLoading>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPlayerFragment$onViewCreated$2(Object obj) {
        super(1, obj, AbstractPlayerFragment.class, "updateIsPlaying", "updateIsPlaying(Lkotlin/Pair;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends CSPlayerLoading, ? extends CSPlayerLoading> tuples) {
        invoke2(tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<? extends CSPlayerLoading, ? extends CSPlayerLoading> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((AbstractPlayerFragment) this.receiver).updateIsPlaying(p0);
    }
}

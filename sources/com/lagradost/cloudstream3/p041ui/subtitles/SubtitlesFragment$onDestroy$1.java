package com.lagradost.cloudstream3.p041ui.subtitles;

import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubtitlesFragment.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.subtitles.SubtitlesFragment$onDestroy$1 */
/* loaded from: classes4.dex */
/* synthetic */ class SubtitlesFragment$onDestroy$1 extends FunctionReferenceImpl implements Function1<Tuples<? extends Integer, ? extends Integer>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SubtitlesFragment$onDestroy$1(Object obj) {
        super(1, obj, SubtitlesFragment.class, "onColorSelected", "onColorSelected(Lkotlin/Pair;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Tuples<? extends Integer, ? extends Integer> tuples) {
        invoke2((Tuples<Integer, Integer>) tuples);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Tuples<Integer, Integer> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SubtitlesFragment) this.receiver).onColorSelected(p0);
    }
}

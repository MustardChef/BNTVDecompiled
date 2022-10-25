package com.lagradost.cloudstream3.p041ui.player;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractPlayerFragment.kt */
@Metadata(m106k = 3, m105mv = {1, 6, 0}, m103xi = 48)
/* renamed from: com.lagradost.cloudstream3.ui.player.AbstractPlayerFragment$onViewCreated$10 */
/* loaded from: classes3.dex */
/* synthetic */ class AbstractPlayerFragment$onViewCreated$10 extends FunctionReferenceImpl implements Function1<List<? extends SubtitleData>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractPlayerFragment$onViewCreated$10(Object obj) {
        super(1, obj, AbstractPlayerFragment.class, "embeddedSubtitlesFetched", "embeddedSubtitlesFetched(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SubtitleData> list) {
        invoke2((List<SubtitleData>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(List<SubtitleData> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((AbstractPlayerFragment) this.receiver).embeddedSubtitlesFetched(p0);
    }
}
